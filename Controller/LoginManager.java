package Controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

import Model.Customer;
import Model.Staff;
import View.StaffMenu;
import View.CustomerMenu;
import View.Helper;

public class LoginManager {
    public static void login() throws SecurityException, ClassNotFoundException, IOException, ParseException {
        Helper.clearConsole();
        Scanner sc = new Scanner(System.in);
        String username, password;
        System.out.println("Enter username: ");
        username = sc.nextLine();
        System.out.println("Enter password: ");
        password = sc.nextLine();
        LoginAuthenticator v = new LoginAuthenticator(username, password);
        if (v.validateLogin()) {
            System.out.println("Login successful");
            if (v.getRole()) {
                StaffMenu.adminMenu();
            } else {
                CustomerMenu.MovieGoerMenu(v.getUserName());
            }

        } else {
            System.out.println("Login failed");
        }
        // sc.close();
    }

}
