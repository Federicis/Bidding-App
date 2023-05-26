package account;

import app.Application;
import app.DBUtils;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.SortedMap;

public class AccountService {

    public static AccountService instance;
    public static AccountService getInstance() {
        if (instance == null) {
            instance = new AccountService();
        }
        return instance;
    }
    public void login(Scanner input) throws SQLException {
        DBUtils.populateAccounts();
        SortedMap<String, UserEntity> accounts = Application.getAllAccounts();
        System.out.println("Enter your credentials:");
        System.out.println("Username:");
        String username;
        while((username = input.nextLine().trim()).isEmpty());
        System.out.println("Password:");
        String password;
        while((password = input.nextLine().trim()).isEmpty());
        UserEntity possibleUser = accounts.get(username);
        if(possibleUser == null || !possibleUser.getPassword().equals(password))
            System.out.println("Username sau parola gresita!");
        else
            Application.setCurrentUser(possibleUser);
            System.out.println("Conectare reusita!");
    }

    public void register(Scanner input) throws Exception {
        DBUtils.populateAccounts();
        SortedMap<String, UserEntity> accounts = Application.getAllAccounts();
        System.out.println("Enter the desired credentials:");
        String username = "";
        while (username.isEmpty()) {
            System.out.println("Username:");
            while ((username = input.nextLine().trim()).isEmpty()) ;
            if (accounts.containsKey(username)) {
                System.out.println("Sorry, that username already exists! Try again!");
                username = "";
            }
        }
        String password = "";
        while (password.isEmpty()) {
            System.out.println("Password:");
            while ((password = input.nextLine().trim()).isEmpty()) ;
            if (password.length() < 9) {
                System.out.println("The password should be at least 9 characters long!");
                password = "";
            }
        }
        UserEntity newClient = new Client(username, password);
        if(AccountUtils.addUserToDatabase(newClient))
            System.out.println("Account created succesfully!");
        else
            throw new Exception("Database error occured!");
    }
}
