import java.io.IOException;
import java.util.*;

import Controller.*;

import Model.*;
import View.CustomerMenu;

public class MovieBookingApp {

    public static final String FILEPATH = "./database/";

    public static void main(String[] args) throws IOException, SecurityException, ClassNotFoundException {
        int option;
        do {
            // System.out.print("\033[H\033[2J");
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
