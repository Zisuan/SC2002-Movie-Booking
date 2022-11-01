package View;

import java.util.*;
import java.io.IOException;
import Controller.MovieManager;
import Model.Movie;

public class StaffMenu {

    public static final String FILEPATH = "./database/";

    public static void adminMenu() throws SecurityException, ClassNotFoundException, IOException {
        Scanner sc = new Scanner(System.in);
        int choice;
        System.out.println("Welcome to Staff Menu");
        System.out.println("Select an option: ");
        System.out.println("1. Movie Listings");
        System.out.println("2. Showtimes");
        System.out.println("3. System Setting");
        System.out.println("4. Logout");
        System.out.println("Option: ");

        choice = sc.nextInt();
        switch (choice) {
            case 1:
                MovieListing.MovieMenu();
                break;
            case 2:
                ShowtimeListing.ShowtimeMenu();
                break;
            case 3:
                ConfigureSystemSettings.configureSystemSettings();
                break;
            case 4:
                System.out.println("Goodbye!");
            default:
                System.out.println("Invalid option");
                System.out.println("Please re-enter!");
                break;
        }
    }
}
