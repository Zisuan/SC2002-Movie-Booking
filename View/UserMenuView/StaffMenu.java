package View.UserMenuView;

import java.util.*;

import Controller.MovieControl.MovieManager;
import Controller.MovieSessionControl.MovieSessionManager;
import Controller.PriceControl.PriceManager;

import java.io.IOException;
import View.ConfigureSystemSettings;
import View.MovieView.MovieListing;
import View.ShowtimeView.ShowtimeListing;

import java.text.ParseException;

public class StaffMenu {

    public static final String FILEPATH = "./database/";

    public static void adminMenu()
            throws SecurityException, ClassNotFoundException, IOException, ParseException {
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_CYAN = "\u001B[36m";
        int choice;
        Scanner sc = new Scanner(System.in);
        MovieManager mm = new MovieManager();
        PriceManager pm = new PriceManager();
        MovieSessionManager msm = new MovieSessionManager();
        do {
            System.out.println(
                    ANSI_BLUE + "=====================================================================");
            System.out.println("                      Welcome to Staff Menu                         ");
            System.out.println("=====================================================================" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "1. Create/Update/Remove Movie Listings");
            System.out.println("2. Create/Update/Remove Showtimes");
            System.out.println("3. Configure System Settings");
            System.out.println("4. View Rankings");
            System.out.println("5. Logout");
            System.out.println("6. Exit Application" + ANSI_RESET);
            System.out.println(ANSI_BLUE + "=====================================================================");
            System.out.println("                           Enter Option:                             ");
            System.out.println("=====================================================================" + ANSI_RESET);
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    MovieListing.MovieMenu(mm, msm);
                    break;
                case 2:
                    ShowtimeListing.ShowtimeMenu();
                    break;
                case 3:
                    ConfigureSystemSettings.configureSystemSettings(sc, pm);
                    break;
                case 4:
                    ViewRankings.listRankingMenu();
                    break;
                case 5:
                    System.out.println(ANSI_BLUE + "Logging out!" + ANSI_RESET);
                    break;
                case 6:
                    System.out.println(ANSI_BLUE + "Goodbye!" + ANSI_RESET);
                    System.exit(0);
                default:
                    System.out.println(ANSI_BLUE + "Invalid option");
                    System.out.println("Please re-enter!" + ANSI_RESET);
                    break;
            }
        } while (choice != 5);
        // sc.close();
    }
}
