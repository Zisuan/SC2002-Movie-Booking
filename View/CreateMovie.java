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
        String dbPath = FILEPATH + "Movies.dat";
        movieDB = mm.loadMovie(dbPath);
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
        int cast = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < cast; i++) {
            System.out.println("Enter Movie Cast: ");
            String castName = sc.nextLine();
            movieCast.add(castName);
        }
        mm.addMovie(movieDB, movieType, movieTitle, movieCode, movieRating, movieStatus, movieSynopsis, movieDirector,
                movieCast);
        mm.saveMovie(dbPath, movieDB);
        // sc.close();
    }
}
