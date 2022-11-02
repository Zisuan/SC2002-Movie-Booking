package View;

import java.util.*;
import java.io.*;
import Controller.*;
import Model.*;

public class BookTicket {

    public static final String FILEPATH = "./database/";

    public static void BookingMenu() throws SecurityException, ClassNotFoundException, IOException {
        // print booking ticket menu
        int choice;
        MovieManager mm = new MovieManager();
        ArrayList<Movie> movieDB = new ArrayList<Movie>();
        String dbPath = FILEPATH + "Movies.dat";
        movieDB = mm.loadMovie(dbPath);
        CinemaManager cm = new CinemaManager();
        ArrayList<Cinema> cinemaDB = new ArrayList<Cinema>();
        String dbPath2 = FILEPATH + "Cinemas.dat";
        cinemaDB = cm.loadCinema(dbPath2);
        ShowtimeManger sm = new ShowtimeManger();
        ArrayList<Showtime> showtimeDB = new ArrayList<Showtime>();
        String dbPath3 = FILEPATH + "Showtimes.dat";
        showtimeDB = sm.loadShowtime(dbPath3);
        SeatManager seatm = new SeatManager();
        ArrayList<Seat> seatDB = new ArrayList<Seat>();
        String dbPath4 = FILEPATH + "Seats.dat";
        seatDB = seatm.loadSeat(dbPath4);
        BookingManager bm = new BookingManager();
        ArrayList<Booking> bookingDB = new ArrayList<Booking>();
        String dbPath5 = FILEPATH + "Bookings.dat";
        bookingDB = bm.loadBooking(dbPath5);
        String selectedMovie;
        String selectedCinema;
        String selectedShowtime;
        String selectedSeat;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Booking Menu");
        System.out.println("1. Select Movie");
        selectedMovie = mm.selectMovie(movieDB)
        System.out.println("2. Select Cinema");
        selectedCinema = cm.selectCinema(cinemaDB);
        System.out.println("3. Select Showtime");
        selectedShowTime = sm.selectShowTime(showtimeDB);
        System.out.println("4. Select Seat");
        selectedSeat = seatm.selectSeat(seatDB);
        showTicketPrice();
        System.out.println("5. Confirm Booking");

        }
}
