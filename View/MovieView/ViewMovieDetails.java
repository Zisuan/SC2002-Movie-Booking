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
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_CYAN = "\u001B[36m";
        ArrayList<Movie> movieDB = new ArrayList<Movie>();
        movieDB = mm.loadObjects(dbPath);
        System.out.println(ANSI_CYAN + "SEARCH MOVIE");
        System.out.println("Enter Movie Title: ");
        String movieTitle = sc.nextLine();
        if (mm.searchMovie(movieDB, movieTitle) != null) {
            System.out.println("Movie exists!" + ANSI_RESET);
        } else {
            System.out.println("Movie does not exist!" + ANSI_RESET);

        }

        // sc.close();
    }

    public static void ViewMoviesTitle(MovieManager mm) throws SecurityException, ClassNotFoundException, IOException {
        // show movie titles
        // Helper.clearConsole();
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_CYAN = "\u001B[36m";
        ArrayList<Movie> movieDB = new ArrayList<Movie>();
        movieDB = mm.loadObjects(dbPath);
        System.out.println(ANSI_BLUE + "-------------------------");
        System.out.println("List of Movies:" + ANSI_RESET);
        mm.printMovieTitles(movieDB);
    }

    public static void ViewMovieDetail(String username, MovieManager mm, ReviewManager rm)
            throws SecurityException, ClassNotFoundException, IOException {
        // show movie details
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_CYAN = "\u001B[36m";
        ArrayList<Movie> movieDB = new ArrayList<Movie>();
        ArrayList<Review> reviewDB = new ArrayList<Review>();
        movieDB = mm.loadObjects(dbPath);
        System.out.print(ANSI_CYAN + "Enter Movie Title: " + ANSI_RESET);
        String movieTitle = sc.nextLine();
        reviewDB = mm.getReviews(movieDB, movieTitle);
        mm.printMovieDetails(movieDB, movieTitle);
        if (mm.searchMovie(movieDB, movieTitle) != null && !rm.searchReview(reviewDB, movieTitle, username)) {
            System.out.println(ANSI_CYAN + "Would you like to rate this movie? (Y/N)" + ANSI_RESET);
            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("Y")) {
                AddMovieReviewView.addMovieReview(movieDB, movieTitle, username);
                mm.saveObjects(dbPath, movieDB);
            }
        }
    }

}