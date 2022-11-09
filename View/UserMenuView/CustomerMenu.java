package View.UserMenuView;

import java.io.IOException;
import java.util.*;

import Controller.BookingManager;
import Controller.HolidayControl.HolidayManager;
import Controller.MovieControl.MovieManager;
import Controller.MovieSessionControl.MovieSessionManager;
import Controller.PriceControl.PriceManager;
import Controller.ReviewControl.ReviewManager;
import Controller.SeatControl.SeatManager;
import Controller.TicketControl.TicketManager;
import Model.Customer;
import View.CheckSeatAvailability;
import View.Helper;
import View.ViewBookingHistory;
import View.MovieView.ViewMovieDetails;
import View.TicketView.BookTicket;

public class CustomerMenu {

    public static void MovieGoerMenu(Customer customer)
            throws SecurityException, ClassNotFoundException, IOException {

        final String FILEPATH = "./database/";
        int choice;
        MovieManager mm = new MovieManager();
        ReviewManager rm = new ReviewManager();
        MovieSessionManager msm = new MovieSessionManager();
        SeatManager sm = new SeatManager();
        PriceManager pm = new PriceManager();
        TicketManager tm = new TicketManager();
        HolidayManager hm = new HolidayManager();
        BookingManager bm = new BookingManager();
        Scanner sc = new Scanner(System.in);

        do {
            // Helper.clearConsole();
            System.out.println("====================================");
            System.out.println("Hi " + customer.getUsername() + ",");
            System.out.println("Welcome to MOBLIMA!====");
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
            Helper.clearConsole();
            switch (choice) {
                case 1:
                    ViewMovieDetails.searchMovie(mm);
                    break;
                case 2:
                    ViewMovieDetails.ViewMoviesTitle(mm);
                    break;
                case 3:
                    ViewMovieDetails.ViewMovieDetail(customer.getUsername(), mm, rm);
                    break;
                case 4:
                    CheckSeatAvailability.checkSeatAvailability(mm, msm);
                    break;
                case 5:
                    BookTicket.BookingMenu(customer, mm, msm, sm, pm, tm, hm, bm);
                    break;
                case 6:
                    ViewBookingHistory.viewBookingHistory(customer.getUsername(), tm);
                    break;
                case 7:
                    // listTop5RankingMovie();
                    break;
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