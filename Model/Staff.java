package Model;

import java.util.*;

import Controller.MovieManager;
import Controller.CinemaControl.CinemaManager;

public class Staff extends User {
    private String staffID;

    // constructor
    public Staff(String username, String password, boolean isStaff, String firstName, String lastName, String email,
            String mobileNumber, String staffID) {
        super(username, password, isStaff, firstName, lastName, email, mobileNumber);
        this.staffID = staffID;
    }

}
