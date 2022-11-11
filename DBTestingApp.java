import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.*;

import Controller.CinemaControl.CinemaManager;
import Controller.HolidayControl.HolidayManager;
import Controller.MovieControl.MovieManager;
import Controller.MovieSessionControl.MovieSessionManager;
import Controller.PriceControl.PriceManager;
import Controller.ReviewControl.ReviewManager;
import Controller.SeatControl.SeatManager;
import Controller.TicketControl.TicketManager;
import Model.*;
import Model.Cinema.CinemaType;
import Model.Movie.MovieStatus;
import Model.Movie.MovieType;

public class DBTestingApp {

    public static final String FILEPATH = "./database/";

    // public static void testCinemaManager() throws IOException, SecurityException,
    // ClassNotFoundException {
    // CinemaManager cm = new CinemaManager();
    // ArrayList<Cinema> cinemaDB = new ArrayList<Cinema>();
    // String dbPath = FILEPATH + "Cinemas.csv";
    // cinemaDB = cm.loadCinema(dbPath, "Model.Cinema");
    // // cm.printCinemas(cinemaDB);
    // cm.addCinema(cinemaDB, "Cathay", "004", "3D");
    // cm.addCinema(cinemaDB, "Cathay", "004", "2D");
    // // cm.printCinemas(cinemaDB);
    // cm.saveCinema(dbPath, cinemaDB);
    // cm.printCinemas(cinemaDB);
    // }

    // public static void testMovieManager() throws SecurityException,
    // ClassNotFoundException, IOException {
    // MovieManager mm = new MovieManager();
    // ArrayList<Movie> movieDB = new ArrayList<Movie>();
    // String dbPath = FILEPATH + "Movies.csv";
    // // movieDB = mm.loadMovie(dbPath, "Model.Movie");
    // ArrayList<String> cast = new ArrayList<String>();
    // cast.add("Tom Hanks");
    // cast.add("Tim Allen");
    // cast.add("Joan Cusack");
    // cast.add("Don Rickles");
    // cast.add("Jim Varney");
    // cast.add("Wallace Shawn");
    // mm.addMovie(movieDB, 1,
    // "movieType", "movieTitle", "movieCode",
    // "movieRating", "movieStatus", "movieSynopsis", "movieDirector",
    // cast, "movieReview", "overallRating");
    // // mm.printMovies(movieDB);
    // mm.saveMovie(dbPath, movieDB);

    // }

    public static void initCinemas() throws IOException, SecurityException, ClassNotFoundException {
        CinemaManager cm = new CinemaManager();
        ArrayList<Cinema> cinemaDB = new ArrayList<Cinema>();
        String dbPath = FILEPATH + "Cinemas.dat";
        cm.addCinema(cinemaDB, "Cathay@Jem", 1, CinemaType.NORMAL);
        cm.addCinema(cinemaDB, "Cathay@Jem", 2, CinemaType.PLATINUM);
        cm.addCinema(cinemaDB, "Cathay@Jem", 3, CinemaType.PLATINUM);
        cm.addCinema(cinemaDB, "Cathay@Orchard", 1, CinemaType.NORMAL);
        cm.addCinema(cinemaDB, "Cathay@Orchard", 2, CinemaType.PLATINUM);
        cm.addCinema(cinemaDB, "Cathay@Orchard", 3, CinemaType.PLATINUM);
        cm.addCinema(cinemaDB, "Cathay@Vivo", 1, CinemaType.NORMAL);
        cm.addCinema(cinemaDB, "Cathay@Vivo", 2, CinemaType.PLATINUM);
        cm.addCinema(cinemaDB, "Cathay@Vivo", 3, CinemaType.PLATINUM);
        // Cinema curCinema = cm.getCinema(cinemaDB, "004");
        // curCinema.getCinemaSeatDB().add(new Seat("A21", "004", "A", "21", "Standard",
        // true, 10));
        // cm.printCinema(curCinema);
        cm.saveObjects(dbPath, cinemaDB);
        cinemaDB = cm.loadObjects(dbPath);
        cm.printObjects(cinemaDB);

        // cm.addCinema(cinemaDB, "Cathay", "004", "2D");
        // cm.printCinemas(cinemaDB);
        // cm.printCinemas(cinemaDB);
    }

    public static void initMovies() throws SecurityException, ClassNotFoundException, IOException {
        MovieManager mm = new MovieManager();
        ReviewManager rm = new ReviewManager();
        ArrayList<Movie> movieDB = new ArrayList<Movie>();
        String dbPath = FILEPATH + "Movies.dat";
        ArrayList<String> cast = new ArrayList<String>();
        ArrayList<Review> reviewsDB = new ArrayList<Review>();
        cast.add("Tom Hanks");
        cast.add("Tim Allen");
        cast.add("Joan Cusack");
        cast.add("Don Rickles");
        cast.add("Jim Varney");
        cast.add("Wallace Shawn");
        rm.addReview(reviewsDB, "My review", "CustomerName", "movieTitle", 3);
        // mm.addMovie(movieDB, MovieType.NORMAL, "movieTitle", MovieStatus.NOW_SHOWING,
        // "movieCode",
        // "movieSynopsis", "movieDirector", cast, reviewsDB, "movieRating");
        mm.saveObjects(dbPath, movieDB);
        movieDB = mm.loadObjects(dbPath);
        mm.printObjects(movieDB);
    }

    public static void initMovieSessions() throws IOException, SecurityException, ClassNotFoundException {
        MovieSessionManager msm = new MovieSessionManager();
        SeatManager sm = new SeatManager();
        ArrayList<MovieSession> movieSessionDB = new ArrayList<MovieSession>();
        // ArrayList<Seat> seatDB = sm.generateSeats(7, 10, "JemH1");
        String dbPath = FILEPATH + "MovieSessions.dat";
        Cinema temp = new Cinema("Cathay@Jem", 1, CinemaType.NORMAL);
        // Movie tempMovie = new Movie(MovieType.NORMAL, "tempTitle",
        // MovieStatus.NOW_SHOWING, "tempCode", "tempSynopsis",
        // "tempDirector", new ArrayList<String>(), new ArrayList<Review>(),
        // "tempRating");
        // Movie tempMovie1 = new Movie(MovieType.NORMAL, "movieTitle",
        // MovieStatus.NOW_SHOWING, "tem12pCode",
        // "tempSynopsis",
        // "tempDirector", new ArrayList<String>(), new ArrayList<Review>(),
        // "tempRating");
        LocalDate tempDate = LocalDate.parse("2022-12-25");
        // msm.addMovieSession(movieSessionDB, tempMovie, temp,
        // tempDate, "12:00",
        // seatDB);
        // msm.addMovieSession(movieSessionDB, tempMovie1, temp,
        // tempDate, "12:11",
        // seatDB);
        msm.saveObjects(dbPath, movieSessionDB);
        movieSessionDB = msm.loadObjects(dbPath);
        msm.printObjects(movieSessionDB);

    }

    public static void initHolidays() throws IOException, SecurityException, ClassNotFoundException {
        HolidayManager hm = new HolidayManager();
        ArrayList<Holiday> holidayDB = new ArrayList<Holiday>();
        String dbPath = FILEPATH + "Holidays.dat";
        hm.addHoliday(holidayDB, LocalDate.parse("2022-12-25"), "Boxing Day");
        hm.addHoliday(holidayDB, LocalDate.parse("2022-12-26"), "Chinese New Year");
        hm.addHoliday(holidayDB, LocalDate.parse("2022-12-30"), "Christmas");
        hm.addHoliday(holidayDB, LocalDate.parse("2022-12-31"), "Hari Raya");
        hm.addHoliday(holidayDB, LocalDate.parse("2023-01-01"), "Deepavali");
        hm.addHoliday(holidayDB, LocalDate.parse("2023-01-02"), "New Year");
        hm.listHolidays(holidayDB);
        hm.saveObjects(dbPath, holidayDB);
        holidayDB = hm.loadObjects(dbPath);
        hm.listHolidays(holidayDB);

    }

    public static void initPrices() throws IOException, SecurityException, ClassNotFoundException {
        PriceManager pm = new PriceManager();
        ArrayList<Price> priceDB = new ArrayList<Price>();
        String dbPath = FILEPATH + "Prices.dat";
        pm.createPrice(priceDB, 3, 2, 6, 5, 4, 7, 8.5, 6.5);
        pm.saveObjects(dbPath, priceDB);
        priceDB = pm.loadObjects(dbPath);
        pm.printPrice(priceDB);
    }

    public static void initTicket() throws IOException, SecurityException, ClassNotFoundException {
        TicketManager tm = new TicketManager();
        ArrayList<Ticket> ticketDB = new ArrayList<Ticket>();
        String dbPath = FILEPATH + "Tickets.dat";
        Cinema temp = new Cinema("Cathay@Jem", 1, CinemaType.NORMAL);
        // Movie tempMovie = new Movie(MovieType.NORMAL, "tempTitle",
        // MovieStatus.NOW_SHOWING, "tempCode", "tempSynopsis",
        // "tempDirector", new ArrayList<String>(), new ArrayList<Review>(),
        // "tempRating");
        // Movie tempMovie1 = new Movie(MovieType.NORMAL, "movieTitle",
        // MovieStatus.NOW_SHOWING, "tem12pCode",
        // "tempSynopsis",
        // "tempDirector", new ArrayList<String>(), new ArrayList<Review>(),
        // "tempRating");
        // // LocalDate tempDate = LocalDate.parse("2022-12-25");
        // MovieSession tempMS = new MovieSession(tempMovie, temp, tempDate, "12:00",
        // new ArrayList<Seat>());
        // MovieSession tempMS1 = new MovieSession(tempMovie1, temp, tempDate, "12:11",
        // new ArrayList<Seat>());
        // tm.addTicket(ticketDB, tempMS, "A1", "Adult", 10);
        // tm.addTicket(ticketDB, tempMS1, "A2", "Adult", 10);
        tm.saveObjects(dbPath, ticketDB);
        ticketDB = tm.loadObjects(dbPath);
        tm.printObjects(ticketDB);
    }

    // public static void testPriceManager() throws IOException, SecurityException,
    // ClassNotFoundException {
    // PriceManager pm = new PriceManager();
    // ArrayList<Price> priceDB = new ArrayList<Price>();
    // String dbPath = FILEPATH + "Prices.dat";
    // pm.createPrice(priceDB, 10, 3, 4, 1, 3, 56, 7, 8);
    // pm.saveObjects(dbPath, priceDB);
    // priceDB = pm.loadObjects(dbPath);
    // pm.printPrice(priceDB);
    // }

    public static void main(String[] args) throws IOException, SecurityException, ClassNotFoundException {

        initCinemas();
        // initMovies();
        // initHolidays();
        initPrices();
        // testPriceManager();
        // initMovieSessions();
        // testMovieManager();

    }
}
