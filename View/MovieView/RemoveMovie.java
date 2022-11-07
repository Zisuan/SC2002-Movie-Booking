package View.MovieView;

import java.util.*;

import Controller.MovieControl.MovieManager;

import java.io.IOException;

import Model.Movie;

public class RemoveMovie {

    public static final String FILEPATH = "./database/";

    public static void removeMovie(Scanner sc,
            MovieManager mm) throws IOException, SecurityException, ClassNotFoundException {
        ArrayList<Movie> movieDB = new ArrayList<Movie>();
        String dbPath = FILEPATH + "Movies.dat";
        movieDB = mm.loadObjects(dbPath);
        System.out.println("DELETE MOVIE");
        System.out.println("Enter Movie Code to delete movie: ");
        String code = sc.nextLine();
        mm.removeMovie(movieDB, code);
        mm.saveObjects(dbPath, movieDB);
        // sc.close();
    }
}
