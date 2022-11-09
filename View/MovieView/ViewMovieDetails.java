package View.MovieView;

import java.util.*;

import Controller.Helpers.DatabaseFilePath;
import Controller.MovieControl.MovieManager;
import Controller.ReviewControl.ReviewManager;

import java.io.IOException;

import Model.Movie;
import Model.Review;
import View.Helper;

public class ViewMovieDetails {

    public static final Scanner sc = new Scanner(System.in);
    private static String dbPath = DatabaseFilePath.Movies.getFilePath();

    public static void searchMovie(MovieManager mm)
            throws SecurityException, ClassNotFoundException, IOException {
        ArrayList<Movie> movieDB = new ArrayList<Movie>();
        movieDB = mm.loadObjects(dbPath);
        System.out.println("SEARCH MOVIE");
        System.out.println("Enter Movie Title: ");
        String movieTitle = sc.nextLine();
        if (mm.searchMovie(movieDB, movieTitle) != null) {
            System.out.println("Movie exists!");
        } else {
            System.out.println("Movie does not exist!");

        }

        // sc.close();
    }

    public static void ViewMoviesTitle(MovieManager mm) throws SecurityException, ClassNotFoundException, IOException {
        // show movie titles
        // Helper.clearConsole();
        ArrayList<Movie> movieDB = new ArrayList<Movie>();
        movieDB = mm.loadObjects(dbPath);
        System.out.println("-------------------------");
        System.out.println("List of Movies:");
        mm.printMovieTitles(movieDB);
    }

    public static void ViewMovieDetail(String username, MovieManager mm, ReviewManager rm)
            throws SecurityException, ClassNotFoundException, IOException {
        // show movie details
        ArrayList<Movie> movieDB = new ArrayList<Movie>();
        ArrayList<Review> reviewDB = new ArrayList<Review>();
        movieDB = mm.loadObjects(dbPath);
        System.out.print("Enter Movie Title: ");
        String movieTitle = sc.nextLine();
        reviewDB = mm.getReviews(movieDB, movieTitle);
        mm.printMovieDetails(movieDB, movieTitle);
        if (mm.searchMovie(movieDB, movieTitle) != null && !rm.searchReview(reviewDB, movieTitle, username)) {
            System.out.println("Would you like to rate this movie? (Y/N)");
            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("Y")) {
                AddMovieReviewView.addMovieReview(movieDB, movieTitle, username);
                mm.saveObjects(dbPath, movieDB);
            }
        }
    }

}