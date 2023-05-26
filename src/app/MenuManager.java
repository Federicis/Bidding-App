package app;

import account.AccountService;
import bidding.BiddingService;

import java.util.Scanner;

import static java.lang.System.exit;

public class MenuManager {
    private static final AccountService accountService = AccountService.getInstance();
    private static final BiddingService biddingService = BiddingService.getInstance();

    public void loadMenu() throws Exception {
        if (Application.getCurrentUser() == null) {
            loadLoginMenu();
            return;
        }
        loadBiddingMenu();
    }

    public void loadLoginMenu() throws Exception {
        System.out.flush();
        System.out.println("You need to connect to your account first:");
        System.out.println("0.Exit");
        System.out.println("1.Log In");
        System.out.println("2.Register");
        System.out.print("Choose one of the options:");
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();
        if (option == 0) {
            exit(0);
        }
        if (option == 1) {
            accountService.login(input);
        } else if (option == 2) {
            accountService.register(input);
        } else {
            System.out.println("Invalid Selection");
        }
    }

    public void loadBiddingMenu() throws Exception {
        System.out.println("Biddings list:");
        System.out.println("0.Exit");
        System.out.println("1.Show products");
        System.out.println("2.Show categories");
        System.out.println("3.Show auctions");
        System.out.println("4.Log out");
        System.out.print("Choose one of the options:");
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();
        switch (option) {
            case 0:
                exit(0);
            case 1:
                biddingService.showAllProducts();
        }

    }
}
