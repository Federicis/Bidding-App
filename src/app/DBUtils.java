package app;

import account.Admin;
import account.Client;
import account.UserEntity;
import bidding.Car;
import bidding.House;
import bidding.Miscellaneous;

import java.sql.*;

public abstract class DBUtils {
    private static Connection connection;
    private static Statement statement;
    static void connectToDB() {
        String url = "jdbc:mysql://localhost:3306/biddingapp";
        String username = "root";
        String password = "admin";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void populateAccounts() throws SQLException {
        ResultSet resultSet = statement.executeQuery("select * from users");
        while(resultSet.next()){
            if(resultSet.getString(4).equals("Client")) {
                Application.getAllAccounts().put(resultSet.getString(2), new Client(resultSet.getString(2), resultSet.getString(3)));
            }
            else {
                Application.getAllAccounts().put(resultSet.getString(2), new Admin(resultSet.getString(2), resultSet.getString(3)));
            }
        }
        System.out.println("The users sorted alphabetically are: ");
        for (UserEntity account : Application.getAllAccounts().values()) {
            System.out.println(account.toString());
        }
    }
    public static void populateProducts() throws SQLException {
        ResultSet resultSet = statement.executeQuery("select * from products");
        while(resultSet.next()){
            if(resultSet.getString(4).equals("Cars")) {
                Application.getAllProducts().put(resultSet.getString(2),
                        new Car(resultSet.getString(2),
                                resultSet.getString(3),
                                resultSet.getInt(4) ,
                                resultSet.getInt(5)));
            }
            else if(resultSet.getString(4).equals("Houses")) {
                Application.getAllProducts().put(resultSet.getString(2),
                        new House(resultSet.getString(2),
                                  resultSet.getString(3),
                                  resultSet.getInt(4),
                                  resultSet.getInt(5)));            }
            else {
                Application.getAllProducts().put(resultSet.getString(2),
                        new Miscellaneous(resultSet.getString(2),
                                          resultSet.getString(3)));
            }
        }
    }
}
