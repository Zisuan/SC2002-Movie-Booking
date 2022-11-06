package View.TicketView;

import java.util.*;
import java.io.*;
import Controller.*;
import Controller.CinemaControl.CinemaManager;
import Controller.MovieSessionControl.MovieSessionManager;
import Controller.SeatControl.SeatManager;
import Model.*;

public class BookTicket {

    public static final String FILEPATH = "./database/";

    public static void BookingMenu() throws SecurityException, ClassNotFoundException, IOException {
        // print booking ticket menu
        int choice;
        MovieManager mm = new MovieManager();
        ArrayList<Movie> movieInSessionDB = new ArrayList<Movie>();
        String dbPath = FILEPATH + "Movies.dat";
        movieInSessionDB = mm.loadObjects(dbPath);

        CinemaManager cm = new CinemaManager();
        ArrayList<Cinema> cinemaInSessionDB = new ArrayList<Cinema>();
        String dbPath2 = FILEPATH + "Cinemas.dat";
        cinemaInSessionDB = cm.loadObjects(dbPath2);

        MovieSessionManager msm = new MovieSessionManager();
        ArrayList<MovieSession> showtimeDB = new ArrayList<MovieSession>();
        String dbPath3 = FILEPATH + "Showtimes.dat";
        showtimeDB = msm.loadObjects(dbPath3);

        SeatManager seatm = new SeatManager();
        ArrayList<Seat> seatDB = new ArrayList<Seat>();
        String dbPath4 = FILEPATH + "Seats.dat";
        seatDB = seatm.loadObjects(dbPath4);

        // BookingManager bm = new BookingManager();
        // ArrayList<Booking> bookingDB = new ArrayList<Booking>();
        // String dbPath5 = FILEPATH + "Bookings.dat";
        // bookingDB = bm.loadBooking(dbPath5);

        String selectedMovie;
        String selectedCinema;
        Cinema selectedCinemaObj;
        String selectedSession;
        String selectedSeat;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Booking Menu");
        System.out.println("1. Select Movie");

        movieInSessionDB = msm.getMovies(showtimeDB);
        mm.printMovieTitles(movieInSessionDB);

        // mm.printMovieTitles(movieDB);
        System.out.println("Enter the movie of choice:");
        selectedMovie = sc.nextLine();

        System.out.println("2. Select Cinema");
        cinemaInSessionDB = msm.getCinemaByMovie(showtimeDB, selectedMovie);
        System.out.println("Enter the cinema of choice:");
        // cm.getCinemas(cinemaInSessionDB);
        cm.printObjects(cinemaInSessionDB);
        selectedCinema = sc.nextLine();
        selectedCinemaObj = cm.getCinema(cinemaInSessionDB, selectedCinema);

        System.out.println("3. Select Showtime");
        showtimeDB = msm.getShowtimeByMovieAndCinema(showtimeDB, selectedMovie, selectedCinema);
        msm.printObjects(showtimeDB);
        selectedSession = sc.nextLine();

        System.out.println("4. Select Seat");
        MovieSession selectedSesssion = msm.getMovieSession(showtimeDB, Integer.parseInt(selectedSession));
        msm.printSessionSeats(selectedSesssion);

        // stophere

        // System.out.println("4. Select Seat");
        // selectedSeat = seatm.selectSeat(seatDB);
        // showTicketPrice();
        // System.out.println("5. Confirm Booking");

    }
}
