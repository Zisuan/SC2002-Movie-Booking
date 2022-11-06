package Controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

import View.Helper;
import View.UserMenuView.CustomerMenu;
import View.UserMenuView.StaffMenu;

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
