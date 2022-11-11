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
            // TODO : FIX REMOVE MOVIE WITH INCORRECT MOVIE CODE
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
        System.out.println(ANSI_BLUE + "Enter 0 to exit" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "Enter Movie Code to delete movie: " + ANSI_RESET);
        MovieManager.printMovieTitlesAndCode(movieDB);
        String code = sc.nextLine();
        if (code.equals("0")) {
            System.out.println(ANSI_BLUE + "Movie deletion cancelled" + ANSI_RESET);
            return;
        }
        MovieManager.removeMovie(movieDB, MovieManager.getMovieByIndex(movieDB, code));
        mm.saveObjects(DatabaseFilePath.Movies.getFilePath(), movieDB);
        System.out.println(ANSI_BLUE + "Movie Deleted!" + ANSI_RESET);

        // sc.close();
    }
}
