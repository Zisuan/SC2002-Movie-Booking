import java.io.IOException;
import java.util.*;

import Controller.*;

import Model.*;

public class MovieBookingApp {

    public static final String FILEPATH = "./database/";

    public static void main(String[] args) throws IOException, SecurityException, ClassNotFoundException {
        // int option;
        // Scanner sc = new Scanner(System.in);
        // System.out.println("=====================================================================");
        // System.out.println("Welcome to MOBLIMA\n");
        // System.out.println("(1) Use App as Admin");
        // System.out.println("(2) Use App as Movie-goer");
        // System.out.println("(3) Exit");
        // System.out.println();

        // do {
        // System.out.print("Enter the number of your choice: ");
        // option = sc.nextInt();
        // if (option == 1) {
        // LoginManager.login();
        // } else if (option == 2) {
        // LoginManager.login();
        // } else if (option == 3) {
        // System.out.println("Thank you for using MOBLIMA!");
        // System.exit(0);
        // } else {
        // System.out.println("Invalid option");
        // }
        // } while (option != 3);
        // sc.close();

        // CinemaManager cm = new CinemaManager();
        // ArrayList<Cinema> cinemaDB = new ArrayList<Cinema>();
        // String dbPath = FILEPATH + "Cinemas.csv";
        // cinemaDB = cm.loadCinema(dbPath, "Model.Cinema");
        // // cm.printCinemas(cinemaDB);
        // cm.addCinema(cinemaDB, "Cathay", "004", "3D", 4);
        // cm.addCinema(cinemaDB, "Cathay", "004", "2D", 5);
        // // cm.printCinemas(cinemaDB);
        // cm.saveCinema(dbPath, cinemaDB);
        // cm.printCinemas(cinemaDB);

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

    }
}
