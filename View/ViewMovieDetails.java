package View;

import java.util.*;
import java.io.IOException;
import Controller.MovieManager;
import Model.Movie;

public class ViewMovieDetails {

    public static final String FILEPATH = "./database/";

    public static void searchMovie() throws SecurityException, ClassNotFoundException, IOException {
        Scanner sc = new Scanner(System.in);
        MovieManager mm = new MovieManager();
        ArrayList<Movie> movieDB = new ArrayList<Movie>();
        String dbPath = FILEPATH + "Movies.dat";
        movieDB = mm.loadMovie(dbPath);
        System.out.println("SEARCH MOVIE");
        System.out.println("Enter Movie Title: ");
        String movieTitle = sc.nextLine();
        mm.searchMovie(movieDB, movieTitle);
        // sc.close();
    }

    public static void ViewMoviesTitle() throws SecurityException, ClassNotFoundException, IOException {
        // show movie titles
        MovieManager mm = new MovieManager();
        ArrayList<Movie> movieDB = new ArrayList<Movie>();
        String dbPath = FILEPATH + "Movies.dat";
        movieDB = mm.loadMovie(dbPath);
        mm.printMovieTitles(movieDB);

    public static void ViewMovieDetails() throws SecurityException, ClassNotFoundException, IOException {
        // show movie details
        MovieManager mm = new MovieManager();
        ArrayList<Movie> movieDB = new ArrayList<Movie>();
        String dbPath = FILEPATH + "Movies.dat";
        movieDB = mm.loadMovie(dbPath);
        System.out.print("Enter Movie Title: ");
        Scanner sc = new Scanner(System.in);
        String movieTitle = sc.nextLine();
        mm.printMovieDetails(movieDB, movieTitle);
    }
}