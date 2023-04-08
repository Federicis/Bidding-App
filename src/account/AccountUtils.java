package account;

import app.Application;

import java.util.*;

public abstract class AccountUtils {
    public static void login(Scanner input, UserEntity currentUser, SortedMap<String, UserEntity> accounts){
        if(currentUser != null)
            System.out.println("Somebody is already connected!");
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
            System.out.println("Conectare reusita!");
    }

    public static List<Client> getAllClientAccounts(){
        List<Client> clientAccounts = new ArrayList<>();
        SortedMap<String, UserEntity> accountsMap = Application.getAccounts();

        if(accountsMap == null)
            return null;
        Collection<UserEntity> accountsList =  accountsMap.values();

        if(accountsList == null)
            return null;

        for(UserEntity account : accountsList){
            if(account instanceof Client){
                clientAccounts.add((Client) account);
            }
        }
        return clientAccounts;
    }
    public static List<Admin> getAllAdminAccounts(){
        List<Admin> adminAccounts = new ArrayList<>();
        SortedMap<String, UserEntity> accountsMap = Application.getAccounts();

        if(accountsMap == null)
            return null;
        Collection<UserEntity> accountsList =  accountsMap.values();

        if(accountsList == null)
            return null;

        for(UserEntity account : accountsList){
            if(account instanceof Admin){
                adminAccounts.add((Admin) account);
            }
        }
        return adminAccounts;
    }
}
