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
    // TODO : Not showing all the listing of movie and showtimes.
    private static String dbPath = DatabaseFilePath.MovieSessions.getFilePath();

    public static final Scanner sc = new Scanner(System.in);

    // to add userobject to all views
    public static void BookingMenu(Customer customer, MovieManager mm, MovieSessionManager msm,
            SeatManager sm, PriceManager pm, TicketManager tm, HolidayManager hm, BookingManager bm,
            MovieSessionManager ms, TicketManager tmm)
            throws SecurityException, ClassNotFoundException, IOException {
        // print booking ticket menu
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_CYAN = "\u001B[36m";
        ArrayList<Movie> moviesInSessionDB = new ArrayList<Movie>();
        ArrayList<MovieSession> movieSessionDB = new ArrayList<MovieSession>();
        ArrayList<MovieSession> selectedMovieSessionDB = new ArrayList<MovieSession>();
        ArrayList<Cinema> cinemaDB = new ArrayList<Cinema>();
        ArrayList<Seat> seatDB = new ArrayList<Seat>();

        movieSessionDB = msm.loadObjects(dbPath);
        System.out.println(
                ANSI_BLUE + "=============================================================");
        System.out.println("                Welcome to Booking Menu              ");
        System.out.println("===========================================================");
        System.out.println("Please select the movie you want to book:" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "Enter 0 to return to main menu." + ANSI_RESET);
        moviesInSessionDB = msm.getMoviesInSession(movieSessionDB, mm);
        MovieManager.printMovieTitles(moviesInSessionDB);
        if (moviesInSessionDB.size() == 0) {
            System.out.println(ANSI_BLUE + "There are no movies in session at the moment.");
            System.out.println("Please come back later.");
            System.out.println("Press enter to return to main menu." + ANSI_RESET);
            sc.nextLine();
            return;
        }
        String movieIndex = sc.nextLine();
        if (movieIndex.equals("0")) {
            return;
        }
        Movie selectedMovie = mm.getMovieByIndex(moviesInSessionDB, movieIndex);

        // // ArrayList<Movie> movieDB = msm.getMoviesInSession(movieSessionDB, mm);
        // if (moviesInSessionDB.size() == 0) {
        // System.out.println(ANSI_BLUE + "There are no movies in session at the
        // moment.");
        // System.out.println("Please come back later.");
        // System.out.println("Press enter to return to main menu." + ANSI_RESET);
        // sc.nextLine();
        // return;
        // }
        // mm.printMovieTitles(moviesInSessionDB);
        // mm.printMovies(movieDB);
        System.out.println(ANSI_BLUE + "Please select the showtime you want to check the seat"
                + " availability for:" + ANSI_RESET);
        ArrayList<MovieSession> listOfSessionsInCinemaWithMovie = new ArrayList<MovieSession>();
        listOfSessionsInCinemaWithMovie = msm.filterSessionsByMovie(movieSessionDB,
                selectedMovie);
        msm.printAll(listOfSessionsInCinemaWithMovie);
        String showtimeIndex = sc.nextLine();
        // Cinema selectedCinema = cinemaDB.get(Integer.parseInt(showtimeIndex) - 1);
        MovieSession selectedMovieSession = listOfSessionsInCinemaWithMovie
                .get(Integer.parseInt(showtimeIndex) - 1);

        bookAMovie(selectedMovieSession, movieSessionDB, mm, ms, customer, pm, hm, bm, sm, tmm);

    }

    public static void bookAMovie(MovieSession selectedMovieSession, ArrayList<MovieSession> movieSessionDB,
            MovieManager mm,
            MovieSessionManager msm, Customer customer, PriceManager pm, HolidayManager hm, BookingManager bm,
            SeatManager sm, TicketManager tm) throws SecurityException, ClassNotFoundException, IOException {
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_CYAN = "\u001B[36m";
        // cinemaDB = msm.getCinemafilterSessionsByMovie(movieSessionDB, selectedMovie);

        // System.out.println(
        // ANSI_BLUE + "Please select the cinema you want to check the seat availability
        // for:"
        // + ANSI_RESET);
        // msm.printCinemas(cinemaDB);
        // System.out.println(ANSI_BLUE + "Please select the showtime you want to check
        // the seat"
        // + " availability for:" + ANSI_RESET);
        // msm.printAll(listOfSessionsInCinemaWithMovie);
        // String showtimeIndex = sc.nextLine();
        // // Cinema selectedCinema = cinemaDB.get(Integer.parseInt(showtimeIndex) - 1);
        // MovieSession selectedMovieSession = listOfSessionsInCinemaWithMovie
        // .get(Integer.parseInt(showtimeIndex) - 1);

        // Movie selectedMovie = mm.getMovieByIndex(moviesInSessionDB, movieIndex);

        // cinemaDB = msm.getSessionByMovieIndex(movieSessionDB, movieIndex);
        // System.out.println(ANSI_BLUE + "Please select the cinema you want to book:" +
        // ANSI_RESET);
        // msm.printCinemas(cinemaDB);
        // String cinemaCode = sc.nextLine();
        // if (cinemaCode.equals("0")) {
        // return;
        // }
        // Cinema selectedCinema = cinemaDB.get(Integer.parseInt(cinemaCode) - 1);

        // System.out.println(ANSI_BLUE + "Please select the date you want to book:" +
        // ANSI_RESET);
        // selectedMovieSessionDB = msm.filterSessionsByMovieAndCinema(movieSessionDB,
        // selectedMovie.getMovieTitle(),
        // selectedCinema.getCinemaCode());
        // msm.printShowtimes(selectedMovieSessionDB);
        // String showtime = sc.nextLine();
        // if (showtime.equals("0")) {
        // return;
        // }
        // MovieSession selectedShowtime = msm.getMovieSession(selectedMovieSessionDB,
        // Integer.parseInt(showtime));

        ArrayList<Seat> sessionSeats = selectedMovieSession.getSessionSeats();

        ArrayList<String> seatIDInfo = checkSeatAvailability(sessionSeats, selectedMovieSession, msm, sm);
        String ticketType = getUserTicketType();

        confrimBooking(sessionSeats,
                movieSessionDB, ticketType,
                selectedMovieSession, seatIDInfo, customer,
                pm, hm, bm, sm, tm, msm);
    }

    private static String getUserTicketType() {
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_CYAN = "\u001B[36m";
        System.out.println(ANSI_BLUE + "Are you a:");
        System.out.println("1. Student");
        System.out.println("2. Senior Citizen");
        System.out.println("3. None of the above" + ANSI_RESET);
        String ticketType = sc.nextLine();
        return ticketType;
    }

    public static ArrayList<String> checkSeatAvailability(ArrayList<Seat> sessionSeats, MovieSession selectedShowtime,
            MovieSessionManager msm, SeatManager sm)
            throws SecurityException, ClassNotFoundException, IOException {
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_CYAN = "\u001B[36m";
        String seatID = "";
        String row = "";
        String col = "";
        boolean isSeatBooked = false;
        do {
            if (isSeatBooked) {
                System.out.println(ANSI_BLUE + "Seat is not available, please try again." + ANSI_RESET);
                System.out.println(ANSI_BLUE + "Press enter to continue." + ANSI_RESET);
                sc.nextLine();
            }
            Helper.clearConsole();

            msm.printSessionSeats(selectedShowtime);
            System.out.println(ANSI_BLUE + "======================================================");
            System.out.println("              Seat Selection                      ");
            System.out.println("======================================================" + ANSI_RESET);
            System.out.println(ANSI_BLUE + "Please enter the row number:" + ANSI_RESET);
            row = sc.nextLine();

            System.out.println(ANSI_BLUE + "Please enter the column number:" + ANSI_RESET);
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

    // public static void confrimBooking(Movie selectedMovie, Cinema selectedCinema,
    // MovieSession selectedShowtime,
    // String ticketType, Customer customer,
    // ArrayList<String> seatIDInfo,
    // ArrayList<MovieSession> movieSessionDB,
    // ArrayList<Seat> sessionSeats,
    // MovieSessionManager msm, TicketManager tm, PriceManager pm, HolidayManager
    // hm, BookingManager bm,
    // SeatManager sm)
    // throws SecurityException, ClassNotFoundException, IOException {
    // final String ANSI_BLUE = "\u001B[34m";
    // final String ANSI_RESET = "\u001B[0m";
    // final String ANSI_CYAN = "\u001B[36m";
    // ArrayList<Ticket> ticketDB =
    // tm.loadObjects(DatabaseFilePath.Tickets.getFilePath());
    // ArrayList<Price> priceDB =
    // pm.loadObjects(DatabaseFilePath.Prices.getFilePath());
    // ArrayList<Holiday> holidayDB =
    // hm.loadObjects(DatabaseFilePath.Holidays.getFilePath());
    // ArrayList<Booking> bookingDB =
    // bm.loadObjects(DatabaseFilePath.Bookings.getFilePath());
    // Helper.clearConsole();

    // System.out.println(ANSI_BLUE + "Please confirm your booking:" + ANSI_RESET);
    // System.out.println(ANSI_CYAN + "Movie: " + selectedMovie.getMovieTitle());
    // System.out.println("Cinema: " + selectedCinema.getCinemaCode());
    // System.out.println("Showtime: " + selectedShowtime.getMovieDate() + " @ " +
    // selectedShowtime.getMovieTime());
    // System.out.println("Seat: " + seatIDInfo.get(0));
    // double ticketPrice = pm.getPrice(selectedShowtime, pm.getPrice(priceDB),
    // holidayDB, ticketType);
    // System.out.println("Price: " + ticketPrice + ANSI_RESET);
    // Seat selectedSeat = new Seat(seatIDInfo.get(0), selectedCinema,
    // seatIDInfo.get(1), seatIDInfo.get(2),
    // customer);
    // sm.assignSeat(sessionSeats, selectedSeat);
    // msm.printSessionSeats(selectedShowtime);

    // System.out.println(ANSI_BLUE + "Please enter 1 to confirm booking, 2 to
    // cancel booking:" + ANSI_RESET);
    // String confirm = sc.nextLine();
    // if (confirm.equals("1")) {
    // selectedShowtime.setSessionSeats(sessionSeats);
    // // TODO issue ticket

    // Ticket ticket = new Ticket(ticketPrice, ticketType, "Booked",
    // seatIDInfo.get(0), selectedShowtime, customer);
    // tm.addNewTicket(ticketDB, ticket);
    // bm.addBooking(bookingDB, customer, selectedShowtime, ticket);
    // bm.saveObjects(DatabaseFilePath.Bookings.getFilePath(), bookingDB);
    // msm.saveObjects(DatabaseFilePath.MovieSessions.getFilePath(),
    // movieSessionDB);
    // tm.saveObjects(DatabaseFilePath.Tickets.getFilePath(), ticketDB);
    // System.out.println(ANSI_BLUE + "Booking confirmed!");
    // System.out.println("Thank you for using MOBLIMA!");
    // System.out.println("Press enter to return to main menu" + ANSI_RESET);
    // sc.nextLine();
    // Helper.clearConsole();
    // } else {
    // System.out.println(ANSI_BLUE + "Booking cancelled!");
    // System.out.println("Press enter to return to main menu" + ANSI_RESET);
    // sc.nextLine();
    // Helper.clearConsole();
    // }
    // }

    public static void confrimBooking(ArrayList<Seat> sessionSeats, ArrayList<MovieSession> movieSessionDB,
            String ticketType,
            MovieSession selectedShowtime, ArrayList<String> seatIDInfo, Customer customer,
            PriceManager pm, HolidayManager hm, BookingManager bm, SeatManager sm, TicketManager tm,
            MovieSessionManager msm)
            throws SecurityException, ClassNotFoundException, IOException {
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_CYAN = "\u001B[36m";
        ArrayList<Ticket> ticketDB = tm.loadObjects(DatabaseFilePath.Tickets.getFilePath());
        ArrayList<Price> priceDB = pm.loadObjects(DatabaseFilePath.Prices.getFilePath());
        ArrayList<Holiday> holidayDB = hm.loadObjects(DatabaseFilePath.Holidays.getFilePath());
        ArrayList<Booking> bookingDB = bm.loadObjects(DatabaseFilePath.Bookings.getFilePath());
        Helper.clearConsole();

        System.out.println(ANSI_BLUE + "Please confirm your booking:" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "Movie: " + selectedShowtime.getMovie().getMovieTitle());
        System.out.println("Cinema: " + selectedShowtime.getCinema().getCinemaCode());
        System.out.println("Showtime: " + selectedShowtime.getMovieDate() + " @ " + selectedShowtime.getMovieTime());
        System.out.println("Seat: " + seatIDInfo.get(0));
        double ticketPrice = pm.getPrice(selectedShowtime, pm.getPrice(priceDB), holidayDB, ticketType);
        System.out.println("Price: " + ticketPrice + ANSI_RESET);
        Seat selectedSeat = new Seat(seatIDInfo.get(0), selectedShowtime.getCinema(), seatIDInfo.get(1),
                seatIDInfo.get(2),
                customer);
        sm.assignSeat(sessionSeats, selectedSeat);
        msm.printSessionSeats(selectedShowtime);

        System.out.println(ANSI_BLUE + "Please enter 1 to confirm booking, 2 to cancel booking:" + ANSI_RESET);
        String confirm = sc.nextLine();
        if (confirm.equals("1") && customer != null) {
            issueTicket(selectedShowtime, sessionSeats, seatIDInfo, ticketPrice, ticketDB, movieSessionDB, bookingDB,
                    customer, confirm, tm, bm, sm, msm);
        } else if (customer == null) {
            customer = captureCustomerDetails();
            issueTicket(selectedShowtime, sessionSeats, seatIDInfo, ticketPrice, ticketDB, movieSessionDB, bookingDB,
                    customer, confirm, tm, bm, sm, msm);

        } else {
            System.out.println(ANSI_BLUE + "Booking cancelled!");
            System.out.println("Press enter to return to main menu" + ANSI_RESET);
            sc.nextLine();
            Helper.clearConsole();
        }
    }

    private static Customer captureCustomerDetails() {
        String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_CYAN = "\u001B[36m";
        System.out
                .println(ANSI_BLUE + "Hi guest, please enter your details to complete your booking!" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "Please enter your first name:" + ANSI_RESET);
        String firstName = sc.nextLine();
        System.out.println(ANSI_BLUE + "Please enter your last name:" + ANSI_RESET);
        String lastName = sc.nextLine();
        System.out.println(ANSI_BLUE + "Please enter your mobile number:" + ANSI_RESET);
        String mobile = sc.nextLine();
        System.out.println(ANSI_BLUE + "Please enter your email:" + ANSI_RESET);
        String email = sc.nextLine();
        return new Customer(null, null, false, firstName, lastName, email, mobile);
    }

    public static void issueTicket(MovieSession selectedShowtime, ArrayList<Seat> sessionSeats,
            ArrayList<String> seatIDInfo, double ticketPrice, ArrayList<Ticket> ticketDB,
            ArrayList<MovieSession> movieSessionDB, ArrayList<Booking> bookingDB,
            Customer customer,
            String ticketType, TicketManager tm, BookingManager bm, SeatManager sm, MovieSessionManager msm)
            throws IOException {
        selectedShowtime.setSessionSeats(sessionSeats);
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_CYAN = "\u001B[36m";
        // TODO issue ticket

        Ticket ticket = new Ticket(ticketPrice, ticketType, "Booked",
                seatIDInfo.get(0), selectedShowtime, customer);
        tm.addNewTicket(ticketDB, ticket);
        bm.addBooking(bookingDB, customer, selectedShowtime, ticket);
        bm.saveObjects(DatabaseFilePath.Bookings.getFilePath(), bookingDB);
        msm.saveObjects(DatabaseFilePath.MovieSessions.getFilePath(), movieSessionDB);
        tm.saveObjects(DatabaseFilePath.Tickets.getFilePath(), ticketDB);
        System.out.println(ANSI_BLUE + "Booking confirmed!");
        System.out.println("Thank you for using MOBLIMA!");
        System.out.println("Press enter to return to main menu" + ANSI_RESET);
        sc.nextLine();
        Helper.clearConsole();
    }
}
