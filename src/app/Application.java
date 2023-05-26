package app;

import account.UserEntity;
import bidding.Product;

import java.util.SortedMap;
import java.util.TreeMap;

public abstract class Application {
    private static UserEntity currentUser;
    private static SortedMap<String, UserEntity> accounts = new TreeMap<>(); // conturile sortate in ordine alfabetica
    private static SortedMap<String, Product> products = new TreeMap<>(); // produsele sortate in ordine alfabetica

    public static UserEntity getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(UserEntity currentUser) {
        Application.currentUser = currentUser;
    }

    public static SortedMap<String, UserEntity> getAllAccounts() {
        return accounts;
    }

    public static SortedMap<String, Product> getAllProducts() {
        return products;
    }

    public static void start() throws Exception {
        DBUtils.connectToDB();
        MenuManager menuManager = new MenuManager();
        while(true) {
            menuManager.loadMenu();
        }
    }
}
