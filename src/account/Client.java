package account;

public class Client extends UserEntity{
    public Client(int id, String username, String password) {
        super(id, username, password);
        userType = "Client";
    }
}
