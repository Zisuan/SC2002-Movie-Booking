import java.io.IOException;
import java.util.*;
import java.text.ParseException;

import Controller.LoginControl.LoginManager;
import View.Helper;

public class MovieBookingApp {

    public static final String FILEPATH = "./database/";

    public static void main(String[] args)
            throws IOException, SecurityException, ClassNotFoundException, ParseException {
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_CYAN = "\u001B[36m";
        int option;
        Scanner sc = new Scanner(System.in);
        do {
            Helper.clearConsole();
            option = 0;
            System.out.println(
                    ANSI_BLUE + "=====================================================================");
            System.out.println("                Welcome to MOBLIMA Movie Booking System              ");
            System.out.println("=====================================================================" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "(1) Use App as Admin");
            System.out.println("(2) Use App as Movie-goer");
            System.out.println("(3) Use App as Guest");
            System.out.println("(4) Exit" + ANSI_RESET);
            System.out.println(ANSI_BLUE + "=====================================================================");
            System.out.println("                           Enter Option:                             ");
            System.out.println("=====================================================================" + ANSI_RESET);
            option = sc.nextInt();
            // sc.nextLine();
            if (option == 1) {
                LoginManager.login();
            } else if (option == 2) {
                LoginManager.login();
            } else if (option == 3) {
                // GuestMenu TBC
            } else if (option == 4) {
                System.out.println(ANSI_BLUE + "Thank you for using MOBLIMA!" + ANSI_RESET);
                System.exit(0);
            } else {
                System.out.println(ANSI_BLUE + "Invalid option" + ANSI_RESET);
            }
        } while (option != 3);
        sc.close();

    }
}
