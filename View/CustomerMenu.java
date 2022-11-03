package View;

import java.io.IOException;
import java.util.*;
import Controller.MovieManager;
import Model.Movie;

public class CustomerMenu {

    public static void MovieGoerMenu() throws SecurityException, ClassNotFoundException, IOException {

        final String FILEPATH = "./database/";
        int choice;
        do {
            // System.out.print("\033[H\033[2J");
            Scanner sc = new Scanner(System.in);
            System.out.println("====Welcome to Customer Menu====");
            System.out.println("Select an option: ");
            System.out.println("1. Search Movie");
            System.out.println("2. List Movies");
            System.out.println("3. View Movie Details");
            System.out.println("4. Check Seat Availability and selection of Seats");
            System.out.println("5. Book & Purchase Tickets");
            System.out.println("6. View Booking History");
            System.out.println("7. List the Top 5 ranking movie by ticket sales OR by overall ratings");
            System.out.println("8. Exit");
            System.out.println("Option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    ViewMovieDetails.searchMovie();
                    break;
                case 2:
                    ViewMovieDetails.ViewMoviesTitle();
                    break;
                case 3:
                    ViewMovieDetails.ViewMovieDetails();
                    break;
                // case 3:
                // checkSeatAvailability();
                // break;
                case 5:
                    BookTicket.BookingMenu();
                    // break;
                    // case 5:
                    // viewBookingHistory();
                    // break;
                    // case 6:
                    // listTop5RankingMovie();
                    // break;
                    // case 7:
                    // System.out.println("Goodbye!");
                    // break;
                    // default:
                    // System.out.println("Invalid option");
                    // System.out.println("Please re-enter!");
                    // break;
            }

        } while (choice != 8);

    }

}