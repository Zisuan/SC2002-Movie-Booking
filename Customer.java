public class Customer extends User {
    private String mobileNumber; // customer mobile number

    // create customer constructor
    public Customer(String username, String password, boolean isStaff, String firstName, String lastName, String email,
            String mobileNumber, Object object) {
        super(username, password, isStaff, firstName, lastName, email, mobileNumber);
        this.mobileNumber = mobileNumber;
    }

}
