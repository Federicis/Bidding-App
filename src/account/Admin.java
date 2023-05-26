package account;

public class Admin extends UserEntity{

    public Admin( String username, String password) {
        super( username, password);
        userType = "Admin";
    }
}
