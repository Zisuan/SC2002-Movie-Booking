import java.io.IOException;
import java.util.*;
import java.text.ParseException;

import Controller.*;
import Controller.LoginControl.LoginManager;
import View.Helper;

public class MovieBookingApp {

    public static final String FILEPATH = "./database/";

    public static void main(String[] args)
            throws IOException, SecurityException, ClassNotFoundException, ParseException {
        int option;
        do {
            Helper.clearConsole();
            Scanner sc = new Scanner(System.in);
            option = 0;
            System.out.println("=====================================================================");
            System.out.println("Welcome to MOBLIMA\n");
            System.out.println("(1) Use App as Admin");
            System.out.println("(2) Use App as Movie-goer");
            System.out.println("(3) Use App as Guest");
            System.out.println("(4) Exit");
            System.out.println();
            System.out.print("Enter the number of your choice: ");
            option = sc.nextInt();
            // sc.nextLine();
            if (option == 1) {
                LoginManager.login();
            } else if (option == 2) {
                LoginManager.login();
            } else if (option == 3) {
                // GuestMenu TBC
            } else if (option == 4) {
                System.out.println("Thank you for using MOBLIMA!");
                System.exit(0);
            } else {
                System.out.println("Invalid option");
            }
        } while (option != 3);
        // sc.close();

    }
}
