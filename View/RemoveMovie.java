package View;

import java.util.*;
import java.io.IOException;
import Controller.MovieManager;
import Model.Movie;

public class RemoveMovie {

    public static final String FILEPATH = "./database/";

    public static void removeMovie() throws IOException, SecurityException, ClassNotFoundException {
        MovieManager mm = new MovieManager();
        ArrayList<Movie> movieDB = new ArrayList<Movie>();
        String dbPath = FILEPATH + "Movies.csv";
        movieDB = mm.loadMovie(dbPath, "Model.Movie");

        Scanner sc = new Scanner(System.in);
        System.out.println("DELETE MOVIE");
        System.out.println("Enter Movie ID: ");
        int movieID = sc.nextInt();
        mm.removeMovie(movieDB, movieID);
        mm.saveMovie(dbPath, movieDB);
        sc.close();
    }
}
