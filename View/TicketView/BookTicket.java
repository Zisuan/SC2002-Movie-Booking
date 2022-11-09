package View.TicketView;

import java.util.*;
import java.io.*;

import Controller.BookingManager;
import Controller.CinemaControl.CinemaManager;
import Controller.Helpers.DatabaseFilePath;
import Controller.HolidayControl.HolidayManager;
import Controller.MovieControl.MovieManager;
import Controller.MovieSessionControl.MovieSessionManager;
import Controller.PriceControl.PriceManager;
import Controller.SeatControl.SeatManager;
import Controller.TicketControl.TicketManager;
import Model.*;
import Model.Seat.SeatType;
import View.Helper;
import View.MovieView.ViewMovieDetails;

public class BookTicket {

    private static String dbPath = DatabaseFilePath.MovieSessions.getFilePath();

    public static final Scanner sc = new Scanner(System.in);

    // to add userobject to all views
    public static void BookingMenu(Customer customer, MovieManager mm, MovieSessionManager msm,
            SeatManager sm, PriceManager pm, TicketManager tm, HolidayManager hm, BookingManager bm)
            throws SecurityException, ClassNotFoundException, IOException {
        // print booking ticket menu

        ArrayList<Movie> moviesInSessionDB = new ArrayList<Movie>();
        ArrayList<MovieSession> movieSessionDB = new ArrayList<MovieSession>();
        ArrayList<MovieSession> selectedMovieSessionDB = new ArrayList<MovieSession>();
        ArrayList<Cinema> cinemaDB = new ArrayList<Cinema>();
        ArrayList<Seat> seatDB = new ArrayList<Seat>();

        movieSessionDB = msm.loadObjects(dbPath);
        System.out.println("Welcome to Booking Menu");
        System.out.println("Please select the movie you want to book:");
        moviesInSessionDB = msm.getMoviesInSession(movieSessionDB, mm);
        MovieManager.printMovieTitles(moviesInSessionDB);
        if (moviesInSessionDB.size() == 0) {
            System.out.println("There are no movies in session at the moment.");
            System.out.println("Please come back later.");
            System.out.println("Press enter to return to main menu.");
            sc.nextLine();
            return;
        }
        String movieIndex = sc.nextLine();
        Movie selectedMovie = mm.getMovieByIndex(moviesInSessionDB, movieIndex);

        cinemaDB = msm.filterSessionsByMovie(movieSessionDB, movieIndex);
        System.out.println("Please select the cinema you want to book:");
        msm.printCinemas(cinemaDB);
        String cinemaCode = sc.nextLine();
        Cinema selectedCinema = cinemaDB.get(Integer.parseInt(cinemaCode) - 1);

        System.out.println("Please select the date you want to book:");
        selectedMovieSessionDB = msm.filterSessionsByMovieAndCinema(movieSessionDB, selectedMovie.getMovieTitle(),
                selectedCinema.getCinemaCode());
        msm.printShowtimes(selectedMovieSessionDB);
        String showtime = sc.nextLine();

        MovieSession selectedShowtime = msm.getMovieSession(selectedMovieSessionDB, Integer.parseInt(showtime));

        ArrayList<Seat> sessionSeats = selectedShowtime.getSessionSeats();

        ArrayList<String> seatIDInfo = new ArrayList<String>();
        seatIDInfo = checkSeatAvailability(sessionSeats, selectedShowtime, msm, sm);
        String ticketType = getUserTicketType();

        confrimBooking(selectedMovie, selectedCinema, selectedShowtime, ticketType, customer,
                seatIDInfo,
                selectedMovieSessionDB, sessionSeats, msm, tm, pm, hm, bm, sm);

    }

    private static String getUserTicketType() {
        System.out.println("Are you a:");
        System.out.println("1. Student");
        System.out.println("2. Senior Citizen");
        System.out.println("3. None of the above");
        String ticketType = sc.nextLine();
        return ticketType;
    }

    public static ArrayList<String> checkSeatAvailability(ArrayList<Seat> sessionSeats, MovieSession selectedShowtime,
            MovieSessionManager msm, SeatManager sm)
            throws SecurityException, ClassNotFoundException, IOException {
        String seatID = "";
        String row = "";
        String col = "";
        boolean isSeatBooked = true;
        do {
            Helper.clearConsole();
            if (!isSeatBooked) {
                System.out.println("Seat is not available, please try again:");
            }

            msm.printSessionSeats(selectedShowtime);
            System.out.println("Please select the seat you want to book:");
            System.out.println("Please enter the row number:");
            row = sc.nextLine();

            System.out.println("Please enter the column number:");
            col = sc.nextLine();
            sessionSeats = selectedShowtime.getSessionSeats();
            if (Integer.parseInt(col) < 10) {
                col = "0" + col;
            }
            seatID = row + col;
            isSeatBooked = sm.getSeatStatus(sessionSeats, seatID);
        } while (isSeatBooked);
        ArrayList<String> seatIDInfo = new ArrayList<String>();
        seatIDInfo.add(seatID);
        seatIDInfo.add(row);
        seatIDInfo.add(col);
        return seatIDInfo;
    }

    public static void confrimBooking(Movie selectedMovie, Cinema selectedCinema, MovieSession selectedShowtime,
            String ticketType, Customer customer,
            ArrayList<String> seatIDInfo,
            ArrayList<MovieSession> movieSessionDB,
            ArrayList<Seat> sessionSeats,
            MovieSessionManager msm, TicketManager tm, PriceManager pm, HolidayManager hm, BookingManager bm,
            SeatManager sm)
            throws SecurityException, ClassNotFoundException, IOException {
        ArrayList<Ticket> ticketDB = tm.loadObjects(DatabaseFilePath.Tickets.getFilePath());
        ArrayList<Price> priceDB = pm.loadObjects(DatabaseFilePath.Prices.getFilePath());
        ArrayList<Holiday> holidayDB = hm.loadObjects(DatabaseFilePath.Holidays.getFilePath());
        ArrayList<Booking> bookingDB = bm.loadObjects(DatabaseFilePath.Bookings.getFilePath());
        Helper.clearConsole();

        System.out.println("Please confirm your booking:");
        System.out.println("Movie: " + selectedMovie.getMovieTitle());
        System.out.println("Cinema: " + selectedCinema.getCinemaCode());
        System.out.println("Showtime: " + selectedShowtime.getMovieDate() + " @ " + selectedShowtime.getMovieTime());
        System.out.println("Seat: " + seatIDInfo.get(0));
        double ticketPrice = pm.getPrice(selectedShowtime, pm.getPrice(priceDB), holidayDB, ticketType);
        System.out.println("Price: " + ticketPrice);
        Seat selectedSeat = new Seat(seatIDInfo.get(0), selectedCinema, seatIDInfo.get(1), seatIDInfo.get(2),
                customer);
        sm.assignSeat(sessionSeats, selectedSeat);
        msm.printSessionSeats(selectedShowtime);

        System.out.println("Please enter 1 to confirm booking, 2 to cancel booking:");
        String confirm = sc.nextLine();
        if (confirm.equals("1")) {
            selectedShowtime.setSessionSeats(sessionSeats);
            // TODO issue ticket

            Ticket ticket = new Ticket(ticketPrice, ticketType, "Booked",
                    seatIDInfo.get(0), selectedShowtime, customer);
            tm.addNewTicket(ticketDB, ticket);
            bm.addBooking(bookingDB, customer, selectedShowtime, ticket);
            bm.saveObjects(DatabaseFilePath.Bookings.getFilePath(), bookingDB);
            msm.saveObjects(DatabaseFilePath.MovieSessions.getFilePath(), movieSessionDB);
            tm.saveObjects(DatabaseFilePath.Tickets.getFilePath(), ticketDB);
            System.out.println("Booking confirmed!");
            System.out.println("Thank you for using MOBLIMA!");
            System.out.println("Press enter to return to main menu");
            sc.nextLine();
            Helper.clearConsole();
        } else {
            System.out.println("Booking cancelled!");
            System.out.println("Press enter to return to main menu");
            sc.nextLine();
            Helper.clearConsole();
        }
    }
}
