package View.TicketView;

import java.util.*;
import java.io.*;
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

    public static final String FILEPATH = "./database/";
    private static String dbPath = DatabaseFilePath.MovieSessions.getFilePath();

    public static final Scanner sc = new Scanner(System.in);

    // to add userobject to all views
    public static void BookingMenu(String username, MovieManager mm, MovieSessionManager msm,
            SeatManager sm, PriceManager pm, TicketManager tm, HolidayManager hm)
            throws SecurityException, ClassNotFoundException, IOException {
        // print booking ticket menu

        ArrayList<Movie> movieDB = new ArrayList<Movie>();
        ArrayList<MovieSession> movieSessionDB = new ArrayList<MovieSession>();
        ArrayList<MovieSession> selectedMovieSessionDB = new ArrayList<MovieSession>();
        ArrayList<Cinema> cinemaDB = new ArrayList<Cinema>();
        ArrayList<Seat> seatDB = new ArrayList<Seat>();

        movieSessionDB = msm.loadObjects(dbPath);
        System.out.println("Welcome to Booking Menu");
        System.out.println("Please select the movie you want to book:");
        movieDB = msm.getMoviesInSession(movieSessionDB);
        mm.printMovieTitles(movieDB);
        // mm.printMovies(movieDB);
        String movieIndex = sc.nextLine();
        Movie selectedMovie = mm.getMovieByIndex(movieDB, movieIndex);
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
        String seatID = seatIDInfo.get(0);
        String row = seatIDInfo.get(1);
        String col = seatIDInfo.get(2);
        String ticketType = getUserTicketType();

        Seat selectedSeat = new Seat(seatID, selectedCinema.getCinemaCode(), row, col, SeatType.NORMAL, true, 10);
        sm.assignSeat(sessionSeats, seatID, 1112);
        selectedShowtime.setSessionSeats(sessionSeats);
        confrimBooking(selectedMovie, selectedCinema, selectedShowtime, selectedSeat, ticketType, username, seatID,
                selectedMovieSessionDB, msm, tm, pm, hm);
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
            Seat selectedSeat, String ticketType, String username, String seatID,
            ArrayList<MovieSession> movieSessionDB,
            MovieSessionManager msm, TicketManager tm, PriceManager pm, HolidayManager hm)
            throws SecurityException, ClassNotFoundException, IOException {
        ArrayList<Ticket> ticketDB = tm.loadObjects(DatabaseFilePath.Tickets.getFilePath());
        ArrayList<Price> priceDB = pm.loadObjects(DatabaseFilePath.Prices.getFilePath());
        ArrayList<Holiday> holidayDB = hm.loadObjects(DatabaseFilePath.Holidays.getFilePath());
        Helper.clearConsole();

        System.out.println("Please confirm your booking:");
        System.out.println("Movie: " + selectedMovie.getMovieTitle());
        System.out.println("Cinema: " + selectedCinema.getCinemaCode());
        System.out.println("Showtime: " + selectedShowtime.getMovieDate() + " @ " + selectedShowtime.getMovieTime());
        System.out.println("Seat: " + selectedSeat.getSeatID());
        double ticketPrice = pm.getPrice(selectedShowtime, pm.getPrice(priceDB), holidayDB, ticketType);
        System.out.println("Price: " + ticketPrice);
        msm.printSessionSeats(selectedShowtime);

        System.out.println("Please enter 1 to confirm booking, 2 to cancel booking:");
        String confirm = sc.nextLine();
        if (confirm.equals("1")) {
            tm.addNewTicket(ticketDB, ticketPrice, ticketType, "Booked", seatID, selectedShowtime, username);
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
