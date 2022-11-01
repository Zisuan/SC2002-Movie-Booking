package View;

import java.util.*;
import java.io.IOException;
import Controller.MovieManager;
import Model.Movie;

public class CreateMovie {

    public static final String FILEPATH = "./database/";

    public static void createMovie() throws SecurityException, ClassNotFoundException, IOException {
        Scanner sc = new Scanner(System.in);

        MovieManager mm = new MovieManager();
        ArrayList<Movie> movieDB = new ArrayList<Movie>();
        String dbPath = FILEPATH + "Movies.csv";
        movieDB = mm.loadMovie(dbPath, "Model.Movie");

        System.out.println("CREATE NEW MOVIE LISTING");
        System.out.println("Enter Movie ID: ");
        int movieID = sc.nextInt();
        System.out.println("Enter Movie Type: ");
        String movieType = sc.next();
        System.out.println("Enter Movie Title: ");
        String movieTitle = sc.next();
        System.out.println("Enter Movie Code: ");
        String movieCode = sc.next();
        System.out.println("Enter Movie Rating: ");
        String movieRating = sc.next();
        System.out.println("Enter Movie Status: ");
        String movieStatus = sc.next();
        System.out.println("Enter Movie Synopsis: ");
        String movieSynopsis = sc.next();
        System.out.println("Enter Movie Director: ");
        String movieDirector = sc.next();
        System.out.println("Enter Movie Cast: FIXME");
        ArrayList<String> movieCast = new ArrayList<String>();
        System.out.println("Enter Movie Review: ");
        String movieReview = sc.next();
        System.out.println("Enter Overall Rating: ");
        String overallRating = sc.next();
        // mm.addMovie(movieDB, movieID, movieType, movieTitle, movieCode, movieRating,
        // movieStatus,
        // movieSynopsis,
        // movieDirector, movieCast, movieReview, overallRating);
        // mm.saveMovie(dbPath, movieDB);
        sc.close();
    }
}
