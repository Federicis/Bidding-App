package account;

import app.Application;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;

public abstract class AccountUtils {
    public static List<Client> getAllClientAccounts(){
        List<Client> clientAccounts = new ArrayList<>();
        SortedMap<String, UserEntity> accountsMap = Application.getAllAccounts();

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
        SortedMap<String, UserEntity> accountsMap = Application.getAllAccounts();

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

    public static int getFirstAvailableId(){
        return Application.getAllAccounts().size() + 1;
    }

    public static boolean addUserToDatabase(UserEntity user){
        try{
            Files.writeString(Path.of("improvised database/users.txt"), ((new StringBuilder())
                    .append("\n").append(user.getUsername())
                    .append(" ") .append(user.getPassword())
                    .append(" ") .append(user.getUserType())).toString(), StandardOpenOption.APPEND);
        }
        catch (IOException e) {
            return false;
        }
        return true;
    }
}
