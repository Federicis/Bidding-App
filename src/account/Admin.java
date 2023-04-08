package account;

public class Admin extends UserEntity{

    public Admin(int id, String username, String password) {
        super(id, username, password);
        userType = "Admin";
    }
}
