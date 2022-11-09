package View.MovieView;

import java.util.*;

import Controller.Helpers.DatabaseFilePath;
import Controller.MovieControl.MovieManager;

import java.io.IOException;

import Model.Movie;

public class RemoveMovie {
    // TODO : FIX REMOVE MOVIE
    public static final Scanner sc = new Scanner(System.in);

    public static void removeMovie(
            MovieManager mm) throws IOException, SecurityException, ClassNotFoundException {
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_CYAN = "\u001B[36m";
        ArrayList<Movie> movieDB = new ArrayList<Movie>();
        movieDB = mm.loadObjects(DatabaseFilePath.Movies.getFilePath());
        System.out.println(
                ANSI_BLUE + "=====================================================================");
        System.out.println("                    DELETE MOVIE                                    ");
        System.out.println("=====================================================================" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "DELETE MOVIE");
        System.out.println("Enter Movie Code to delete movie: " + ANSI_RESET);
        MovieManager.printMovieTitlesAndCode(movieDB);
        String code = sc.nextLine();
        MovieManager.removeMovie(movieDB, code);
        mm.saveObjects(DatabaseFilePath.Movies.getFilePath(), movieDB);
        // sc.close();
    }
}
