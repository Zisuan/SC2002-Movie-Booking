package View.UserMenuView;

import java.util.*;

import Controller.MovieControl.MovieManager;
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
        int choice;
        Scanner sc = new Scanner(System.in);
        MovieManager mm = new MovieManager();
        PriceManager pm = new PriceManager();
        do {
            // System.out.print("\033[H\033[2J");
            System.out.println("====Welcome to Staff Menu====");
            System.out.println("Select an option: ");
            System.out.println("1. Create/Update/Remove Movie Listings");
            System.out.println("2. Create/Update/Remove Showtimes");
            System.out.println("3. Configure System Settings");
            System.out.println("4. List top 5 Movies by Ratings");
            System.out.println("5. List top 5 Movies by Sales");

            System.out.println("6. Logout");
            System.out.println("7. Exit Application");
            System.out.println("Option: ");

            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    MovieListing.MovieMenu(mm, sc);
                    break;
                case 2:
                    ShowtimeListing.ShowtimeMenu();
                    break;
                case 3:
                    ConfigureSystemSettings.configureSystemSettings(sc, pm);
                    break;
                case 4:
                    // List top 5 Movies by Ratings
                case 5:
                    // List top 5 Movies by Sales
                case 6:
                    System.out.println("Goodbye!");
                    break;
                case 7:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option");
                    System.out.println("Please re-enter!");
                    break;
            }
        } while (choice != 6);
        // sc.close();
    }
}
