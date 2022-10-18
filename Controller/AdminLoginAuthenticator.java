package Controller;

import java.util.*;

import Controller.Authenticator;
import Controller.ValidateAdminAuthenticator;
import Model.Staff;

public class AdminLoginAuthenticator {
    public static void adminLogin() {
        // create admin login
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username: ");
        String username = sc.nextLine();
        System.out.println("Enter password: ");
        String password = sc.nextLine();
        Authenticator a = new Authenticator(username, password);
        ValidateAdminAuthenticator v = new ValidateAdminAuthenticator();
        v.validateLogin(a);
        if (v.valid) {
            System.out.println("Login successful!" + v.name);
            Staff.adminMenu();
        } else {
            System.out.println("Login failed!");
            System.out.println("Please try again!");
            adminLogin();
        }
    }

}
