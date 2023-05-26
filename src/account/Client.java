package account;

public class Client extends UserEntity{
    public Client( String username, String password) {
        super(username, password);
        userType = "Client";
    }
}
