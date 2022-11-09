package Controller.LoginControl;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

import Controller.Helpers.LoginAuthenticator;
import Model.Customer;
import View.Helper;
import View.UserMenuView.CustomerMenu;
import View.UserMenuView.StaffMenu;

public class LoginManager {
    public static void login() throws SecurityException, ClassNotFoundException, IOException, ParseException {
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_CYAN = "\u001B[36m";
        Helper.clearConsole();
        Scanner sc = new Scanner(System.in);
        String username, password;
        System.out.println(ANSI_CYAN + "Enter username: ");
        username = sc.nextLine();
        System.out.println("Enter password: ");
        password = sc.nextLine();
        LoginAuthenticator v = new LoginAuthenticator(username, password);
        if (v.validateLogin()) {
            System.out.println("Login successful");
            if (v.getRole()) {
                StaffMenu.adminMenu();
            } else {
                Customer customer = new Customer(v.getUserName(), v.getPassword(), v.getRole(), v.getFirstName(),
                        v.getLastName());
                CustomerMenu.MovieGoerMenu(customer);
            }
        } else {
            System.out.println("Login failed");
        }
        System.out.println(ANSI_RESET);
        // sc.close();
    }

}
