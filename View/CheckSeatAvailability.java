package View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Controller.BookingManager;
import Controller.Helpers.DatabaseFilePath;
import Controller.HolidayControl.HolidayManager;
import Controller.MovieControl.MovieManager;
import Controller.MovieSessionControl.MovieSessionManager;
import Controller.PriceControl.PriceManager;
import Controller.SeatControl.SeatManager;
import Controller.TicketControl.TicketManager;
import Model.Cinema;
import Model.Customer;
import Model.Movie;
import Model.MovieSession;
import View.SelectionView.SelectionView;
import View.ShowtimeView.CreateShowTime;
import View.TicketView.BookTicket;

public class CheckSeatAvailability {
        // TODO : Put boooking after showing seat availabilty.
        // TODO : Not showing all the movies and showtime seats.
        final static String ANSI_BLUE = "\u001B[34m";
        final static String ANSI_RESET = "\u001B[0m";
        public static final Scanner sc = new Scanner(System.in);
        private static String dbPath = DatabaseFilePath.MovieSessions.getFilePath();

        public static void checkSeatAvailability(MovieManager mm, MovieSessionManager msm, HolidayManager hm,
                        Customer customer, PriceManager pm, BookingManager bm, SeatManager sm, TicketManager tm)
                        throws IOException, ClassNotFoundException {
                ArrayList<Movie> moviesInSessionDB = new ArrayList<Movie>();
                ArrayList<MovieSession> movieSessionDB = new ArrayList<MovieSession>();
                ArrayList<MovieSession> selectedMovieSessionDB = new ArrayList<MovieSession>();
                ArrayList<Cinema> cinemaDB = new ArrayList<Cinema>();
                movieSessionDB = msm.loadObjects(dbPath);

                System.out.println(
                                ANSI_BLUE + "=====================================================================");
                System.out.println("                      Check Seat Availability                        ");
                System.out.println("=====================================================================");
                System.out.println("Please select the movie you want to check the seat availability for:" + ANSI_RESET);
                moviesInSessionDB = msm.getMoviesInSession(movieSessionDB, mm);
                if (moviesInSessionDB.size() == 0) {
                        System.out.println(ANSI_BLUE + "There are no movies in session at the moment.");
                        System.out.println("Please come back later.");
                        System.out.println("Press enter to return to main menu." + ANSI_RESET);
                        sc.nextLine();
                        return;
                }

                Movie selectedMovie = SelectionView.chooseAMovie(moviesInSessionDB);
                ArrayList<MovieSession> listOfSessionsInCinemaWithMovie = new ArrayList<MovieSession>();
                listOfSessionsInCinemaWithMovie = msm.filterSessionsByMovie(movieSessionDB,
                                selectedMovie);
                System.out.println(ANSI_BLUE + "Please select the showtime you want to check the seat"
                                + " availability for:" + ANSI_RESET);
                msm.printAll(listOfSessionsInCinemaWithMovie);
                String showtimeIndex = sc.nextLine();

                MovieSession selectedMovieSession = listOfSessionsInCinemaWithMovie
                                .get(Integer.parseInt(showtimeIndex) - 1);
                System.out.println(ANSI_BLUE + "The seat availability for the selected showtime is:"
                                + ANSI_RESET);
                msm.printSessionSeats(selectedMovieSession);

                System.out.println(ANSI_BLUE + "Would you like to place a booking? Y/N" + ANSI_RESET);
                String bookingChoice = sc.nextLine();
                if (bookingChoice.equalsIgnoreCase("Y")) {
                        BookTicket.bookAMovie(
                                        selectedMovieSession,
                                        movieSessionDB, mm, msm, customer, pm,
                                        hm,
                                        bm, sm, tm);
                } else {
                        return;
                }
        }
}