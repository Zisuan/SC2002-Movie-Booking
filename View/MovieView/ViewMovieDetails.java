package View.MovieView;

import java.util.*;

import Controller.MovieControl.MovieManager;

import java.io.IOException;

import Model.Movie;
import View.Helper;

public class ViewMovieDetails {

    public static final String FILEPATH = "./database/";

    public static void searchMovie() throws SecurityException, ClassNotFoundException, IOException {
        Scanner sc = new Scanner(System.in);
        MovieManager mm = new MovieManager();
        ArrayList<Movie> movieDB = new ArrayList<Movie>();
        String dbPath = FILEPATH + "Movies.dat";
        movieDB = mm.loadObjects(dbPath);
        System.out.println("SEARCH MOVIE");
        System.out.println("Enter Movie Title: ");
        String movieTitle = sc.nextLine();
        mm.searchMovie(movieDB, movieTitle);
        // sc.close();
    }

    public static void ViewMoviesTitle() throws SecurityException, ClassNotFoundException, IOException {
        // show movie titles
        Helper.clearConsole();
        MovieManager mm = new MovieManager();
        ArrayList<Movie> movieDB = new ArrayList<Movie>();
        String dbPath = FILEPATH + "Movies.dat";
        movieDB = mm.loadObjects(dbPath);
        System.out.println("-------------------------");
        System.out.println("List of Movies:");
        mm.printMovieTitles(movieDB);
    }

    public static void ViewMovieDetails(String username) throws SecurityException, ClassNotFoundException, IOException {
        // show movie details
        MovieManager mm = new MovieManager();
        ArrayList<Movie> movieDB = new ArrayList<Movie>();
        String dbPath = FILEPATH + "Movies.dat";
        movieDB = mm.loadObjects(dbPath);
        System.out.print("Enter Movie Title: ");
        Scanner sc = new Scanner(System.in);
        String movieTitle = sc.nextLine();
        mm.printMovieDetails(movieDB, movieTitle);
        if (mm.searchMovie(movieDB, movieTitle) != null) {
            System.out.println("Would you like to rate this movie? (Y/N)");
            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("Y")) {
                AddMovieReviewView.addMovieReview(movieDB, movieTitle, username);
            }
        }
    }

}