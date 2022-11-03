import java.io.IOException;
import java.util.*;

import Controller.*;
import Controller.CinemaControl.CinemaManager;
import Model.*;

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
        cm.addCinema(cinemaDB, "Cathay@Jem", "JemH1", "NormalClass");
        cm.addCinema(cinemaDB, "Cathay@Jem", "JemH2", "PlatinumClassSuite");
        cm.addCinema(cinemaDB, "Cathay@Jem", "JemH3", "GoldClassSuite");
        cm.addCinema(cinemaDB, "Cathay@Orchard", "OrcH1", "NormalClass");
        cm.addCinema(cinemaDB, "Cathay@Orchard", "OrcH2", "PlatinumClassSuite");
        cm.addCinema(cinemaDB, "Cathay@Orchard", "OrcH3", "GoldClassSuite");
        cm.addCinema(cinemaDB, "Cathay@Vivo", "VivH1", "NormalClass");
        cm.addCinema(cinemaDB, "Cathay@Vivo", "VivH2", "PlatinumClassSuite");
        cm.addCinema(cinemaDB, "Cathay@Vivo", "VivH3", "GoldClassSuite");
        // Cinema curCinema = cm.getCinema(cinemaDB, "004");
        // curCinema.getCinemaSeatDB().add(new Seat("A21", "004", "A", "21", "Standard",
        // true, 10));
        // cm.printCinema(curCinema);
        cm.saveCinema(dbPath, cinemaDB);
        cinemaDB = cm.loadCinema(dbPath);
        cm.printObjects(cinemaDB);

        // cm.addCinema(cinemaDB, "Cathay", "004", "2D");
        // cm.printCinemas(cinemaDB);
        // cm.printCinemas(cinemaDB);
    }

    public static void testPriceManager() throws IOException, SecurityException, ClassNotFoundException {
        PriceManager pm = new PriceManager();
        ArrayList<Price> priceDB = new ArrayList<Price>();
        String dbPath = FILEPATH + "Prices.dat";
        pm.createPrice(priceDB, 10, 3, 4, 1, 3, 56, 7, 8);
        pm.savePrice(dbPath, priceDB);
        priceDB = pm.loadPrice(dbPath);
        pm.printPrice(priceDB);
    }

    public static void main(String[] args) throws IOException, SecurityException, ClassNotFoundException {

        initCinemas();
        // testPriceManager();

        // testMovieManager();

    }
}
