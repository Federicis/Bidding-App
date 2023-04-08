package account;

public class UserEntity {
    protected int id;
    protected String username;
    protected String password;

    protected String userType;

    public UserEntity(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUserType() {
        return userType;
    }

    @Override
    public String toString(){
        return "Username:" + username + " Password:" + password + " " + userType;
    }
}
