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
    // TODO : LIST TOP 5 RANKING
    public static void MovieGoerMenu(Customer customer)
            throws SecurityException, ClassNotFoundException, IOException {
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_CYAN = "\u001B[36m";
        final String FILEPATH = "./database/";
        String choice;
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
            System.out.println(
                    ANSI_BLUE + "=====================================================================");
            System.out.println("                Welcome to MOBLIMA Movie Booking System              ");
            System.out.println("=====================================================================");
            System.out.println(
                    "                              Hi " + customer.getUsername() + ","
                            + "                           ");
            System.out.println("=====================================================================" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "1. Search Movie                                                      ");
            System.out.println("2. List Movies                                                       ");
            System.out.println("3. View Movie Details                                                ");
            System.out.println("4. Check Seat Availability and selection of Seats                    ");
            System.out.println("5. Book & Purchase Tickets                                           ");
            System.out.println("6. View Booking History                                              ");
            System.out.println("7. List the Top 5 ranking movie by ticket sales OR by overall ratings");
            System.out.println("8. Log Out                                                              " + ANSI_RESET);
            System.out.println(ANSI_BLUE + "=====================================================================");
            System.out.println("                           Enter Option:                             ");
            System.out.println("=====================================================================" + ANSI_RESET);
            choice = sc.nextLine();
            Helper.clearConsole();
            switch (Integer.parseInt(choice)) {
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
                    // ViewRankings.listTop5RankingMovie();
                    break;
                // case 7:
                // System.out.println("Goodbye!");
                // break;
                // default:
                // System.out.println("Invalid option");
                // System.out.println("Please re-enter!");
                // break;
            }

        } while (Integer.parseInt(choice) != 8);

    }

}