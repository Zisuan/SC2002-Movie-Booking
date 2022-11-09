package Model;

public class Staff extends User {
    private String staffID;

    // constructor
    public Staff(String username, String password, boolean isStaff, String firstName, String lastName, String email,
            String mobileNumber, String staffID) {
        super(username, password, isStaff);
        this.staffID = staffID;
    }

    public String getStaffID() {
        return staffID;
    }

    // set staff id
    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

}
