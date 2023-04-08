package app;

import account.Admin;
import account.Client;
import account.UserEntity;
import account.AccountUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public abstract class Application {
    private static UserEntity currentUser;
    private static SortedMap<String, UserEntity> accounts = new TreeMap<>(); // conturile sortate in ordine alfabetica

    public static SortedMap<String, UserEntity> getAccounts() {
        return accounts;
    }

    public static void start() throws IOException {
        populateAttributes();
        System.out.println("You need to connect to your account first:");
        System.out.println("1.Log In");
        System.out.println("2.Register");
        System.out.print("Choose one of the options:");
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();
        if(option == 1){
            AccountUtils.login(input, currentUser, accounts);

        }
        else if (option == 2){
            System.out.println("You chose Register"); //TODO
        }
        else{
            System.out.println("Invalid Selection");
        }
    }

    private static void populateAttributes() throws IOException {
        populateAccounts();
    }

    private static void populateAccounts() throws IOException {
        FileReader reader = new FileReader("improvised database/users.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        int cnt = -1;
        while ((line = bufferedReader.readLine()) != null){
            cnt++;
            String[] data = line.split(" ");
            String userName = data[0];
            String password = data[1];
            String userType = data[2];
            if(userType.equals("Client")) {
                accounts.put(userName, new Client(cnt, userName, password));
            }
            else {
                accounts.put(userName, new Admin(cnt, userName, password));
            }
        }

        System.out.println("The users sorted alphabetically are: ");
        for (UserEntity account : accounts.values()) {
            System.out.println(account.toString());
        }

    }
}
