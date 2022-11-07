package View.MovieView;

import java.util.*;

import Controller.MovieControl.MovieManager;

import java.io.IOException;

import Model.Movie;
import Model.Review;
import Model.Movie.MovieStatus;
import Model.Movie.MovieType;

public class CreateMovie {

    public static final String FILEPATH = "./database/";

    public static void createMovie(MovieManager mm, Scanner sc)
            throws SecurityException, ClassNotFoundException, IOException {
        ArrayList<Movie> movieDB = new ArrayList<Movie>();
        String dbPath = FILEPATH + "Movies.dat";
        movieDB = mm.loadObjects(dbPath);
        System.out.println("====CREATE NEW MOVIE LISTING====");
        System.out.println("Enter Movie Type: ");
        String movieType = sc.nextLine();
        System.out.println("Enter Movie Title: ");
        String movieTitle = sc.nextLine();
        System.out.println("Enter Movie Code: ");
        String movieCode = sc.nextLine();
        System.out.println("Enter Movie Rating: ");
        String movieRating = sc.nextLine();
        System.out.println("Enter Movie Status: ");
        String movieStatus = sc.nextLine();
        System.out.println("Enter Movie Synopsis: ");
        String movieSynopsis = sc.nextLine();
        System.out.println("Enter Movie Director: ");
        String movieDirector = sc.nextLine();
        System.out.println("Enter Number of Movie Casts: ");
        ArrayList<String> movieCast = new ArrayList<String>();
        ArrayList<Review> reviewsDB = new ArrayList<Review>();
        int cast = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < cast; i++) {
            System.out.println("Enter Movie Cast: ");
            String castName = sc.nextLine();
            movieCast.add(castName);
        }
        mm.addMovie(movieDB, MovieType.valueOf(movieType), movieTitle, MovieStatus.valueOf(movieStatus), movieCode,
                movieSynopsis, movieDirector, movieCast,
                reviewsDB, movieRating);
        mm.saveObjects(dbPath, movieDB);
        // sc.close();
    }
}
