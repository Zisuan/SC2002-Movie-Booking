package Model;

import java.io.Serializable;
import java.util.*;

public class Customer extends User implements Serializable {
    private String mobileNumber; // customer mobile number
    private String email; // customer email
    private String firstName; // customer first name
    private String lastName;

    // create customer constructor
    public Customer(String username, String password, boolean isStaff, String firstName, String lastName, String email,
            String mobileNumber) {
        super(username, password, isStaff);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }

    public Customer(String username, String password, boolean isStaff, String firstName, String lastName) {
        super(username, password, isStaff);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = null;
        this.mobileNumber = null;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

}
