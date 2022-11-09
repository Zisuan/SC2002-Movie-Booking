package Model;

public class User implements java.io.Serializable {
    // parent of Customer and Admin
    public String username;
    public String password;
    public boolean isStaff;

    public User(String username, String password, boolean isStaff) {
        this.username = username;
        this.password = password;
        this.isStaff = isStaff;
    }

    // create user getter
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isStaff() {
        return isStaff;
    }

}
