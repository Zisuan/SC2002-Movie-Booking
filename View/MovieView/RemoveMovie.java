package View.MovieView;

import java.util.*;

import Controller.Helpers.DatabaseFilePath;
import Controller.MovieControl.MovieManager;

import java.io.IOException;

import Model.Movie;

public class RemoveMovie {

    public static final Scanner sc = new Scanner(System.in);

    public static void removeMovie(
            MovieManager mm) throws IOException, SecurityException, ClassNotFoundException {
        ArrayList<Movie> movieDB = new ArrayList<Movie>();
        movieDB = mm.loadObjects(DatabaseFilePath.Movies.getFilePath());
        System.out.println("DELETE MOVIE");
        System.out.println("Enter Movie Code to delete movie: ");
        MovieManager.printMovieTitlesAndCode(movieDB);
        String code = sc.nextLine();
        MovieManager.removeMovie(movieDB, code);
        mm.saveObjects(DatabaseFilePath.Movies.getFilePath(), movieDB);
        // sc.close();
    }
}
