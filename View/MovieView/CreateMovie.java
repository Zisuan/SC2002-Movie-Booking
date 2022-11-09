package View.MovieView;

import java.util.*;

import Controller.Helpers.DatabaseFilePath;
import Controller.MovieControl.MovieManager;

import java.io.IOException;

import Model.Movie;
import Model.Review;
import Model.Movie.MovieStatus;
import Model.Movie.MovieType;
import View.Helper;

public class CreateMovie {

    public static final Scanner sc = new Scanner(System.in);

    public static void createMovie(MovieManager mm)
            throws SecurityException, ClassNotFoundException, IOException {
        ArrayList<Movie> movieDB = new ArrayList<Movie>();
        movieDB = mm.loadObjects(DatabaseFilePath.Movies.getFilePath());
        System.out.println("====CREATE NEW MOVIE LISTING====");
        Movie newMovie = fullMoviePrompt();
        mm.printMovie(newMovie);
        System.out.println("\nConfirm to add this movie? (Y/N)");
        String confirm = sc.nextLine();
        if (confirm.equalsIgnoreCase("Y")) {
            movieDB.add(newMovie);
            mm.saveObjects(DatabaseFilePath.Movies.getFilePath(), movieDB);
            System.out.println("Movie Added!");
        } else {
            System.out.println("Movie not added!");
        }
        // sc.close();
        System.out.println("Press enter to return to main menu");
        sc.nextLine();
        Helper.clearConsole();
    }

    public static Movie fullMoviePrompt() {
        System.out.println("Enter Movie Type: \n 1. 3D \n 2. Blockbuster \n 3. Normal");
        String movieType = sc.nextLine();
        System.out.println("Enter Movie Title: ");
        String movieTitle = sc.nextLine();
        System.out.println("Enter Movie Rating: \n 1. G \n 2. PG \n 3. PG13 \n 4. NC16 \n 5. M18 \n 6. R21");
        String movieRating = sc.nextLine();
        System.out
                .println("Enter Movie Status: \n 1. Coming Soon \n 2. Preview \n 3. Now Showing");
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
        Movie newMovie = new Movie(movieType, movieTitle, movieStatus, movieSynopsis, movieDirector, movieCast,
                reviewsDB, movieRating);
        System.out.println();
        return newMovie;
    }
}
