package View.MovieView;

import java.util.*;

import Controller.Helpers.DatabaseFilePath;
import Controller.MovieControl.MovieManager;
import Controller.ReviewControl.ReviewManager;

import java.io.IOException;

import Model.Movie;
import Model.Review;
import Model.Movie.MovieStatus;
import View.Helper;

public class ViewMovieDetails {
    // review
    public static final Scanner sc = new Scanner(System.in);
    private static String dbPath = DatabaseFilePath.Movies.getFilePath();

    public static void searchMovie(MovieManager mm)
            throws SecurityException, ClassNotFoundException, IOException {
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_CYAN = "\u001B[36m";
        ArrayList<Movie> movieDB = new ArrayList<Movie>();
        movieDB = mm.loadObjects(dbPath);
        System.out.println(
                ANSI_BLUE + "=====================================================================");
        System.out.println("                            Search Movie              ");
        System.out.println("=====================================================================");
        System.out.println("Enter Movie Title: " + ANSI_RESET);
        String movieTitle = sc.nextLine();
        System.out.println();
        if (mm.searchMovieByTitle(movieDB, movieTitle) != null) {
            System.out.println(ANSI_BLUE + "Movie exists!" + ANSI_RESET);
        } else {
            System.out.println(ANSI_BLUE + "Movie does not exist!" + ANSI_RESET);

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
        System.out.println(
                ANSI_BLUE + "=====================================================================");
        System.out.println("                           List of Movies              ");
        System.out.println("=====================================================================");
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
        System.out.println(
                ANSI_BLUE + "=====================================================================");
        System.out.println("                            Movie Detail             ");
        System.out.println("=====================================================================");
        System.out.print("Enter Movie Title: " + ANSI_RESET);
        String movieTitle = sc.nextLine();
        System.out.println();
        reviewDB = mm.getReviews(movieDB, movieTitle);
        Movie selectedMovie = mm.searchMovieByTitle(movieDB, movieTitle);
        mm.printMovieDetails(movieDB, movieTitle);
        if (selectedMovie != null && !rm.searchReview(reviewDB, movieTitle, username)
                && !selectedMovie.getMovieStatus().equals(MovieStatus.COMING_SOON)) {
            System.out.println(ANSI_CYAN + "Would you like to rate this movie? (Y/N)" + ANSI_RESET);
            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("Y")) {
                AddMovieReviewView.addMovieReview(movieDB, movieTitle, username);
                mm.saveObjects(dbPath, movieDB);
            }
        }
    }

}