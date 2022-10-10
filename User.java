public class User {
    // parent of Customer and Admin
    public String username;
    public String password;
    public boolean isStaff;
    public String firstName;
    public String lastName;
    public String email;
    public String mobileNumber;

    // create user constructor
    public User(String username, String password, boolean isStaff, String firstName, String lastName, String email,
            String mobileNumber) {
        this.username = username;
        this.password = password;
        this.isStaff = isStaff;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }

}
