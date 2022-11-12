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
import View.SelectionView.SelectionView;

public class CreateMovie {

    public static final Scanner sc = new Scanner(System.in);

    public static void createMovie(MovieManager mm)
            throws SecurityException, ClassNotFoundException, IOException {
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_CYAN = "\u001B[36m";
        ArrayList<Movie> movieDB = new ArrayList<Movie>();
        movieDB = mm.loadObjects(DatabaseFilePath.Movies.getFilePath());
        System.out.println(
                ANSI_BLUE + "=====================================================================");
        System.out.println("                    Create New Movie Listing                       ");
        System.out.println("=====================================================================" + ANSI_RESET);
        Movie newMovie = SelectionView.fullMoviePrompt();
        if (newMovie == null) {
            System.out.println(ANSI_BLUE + "Movie creation cancelled" + ANSI_RESET);
            return;
        }
        mm.printMovie(newMovie);

        System.out.println(ANSI_CYAN + "\nConfirm to add this movie? (Y/N)" + ANSI_RESET);
        String confirm = sc.nextLine();
        if (confirm.equalsIgnoreCase("Y")) {
            movieDB.add(newMovie);
            mm.saveObjects(DatabaseFilePath.Movies.getFilePath(), movieDB);
            System.out.println(ANSI_BLUE + "Movie Added!" + ANSI_RESET);
        } else {
            System.out.println(ANSI_BLUE + "Movie not added!" + ANSI_RESET);
        }
        // sc.close();
        System.out.println(ANSI_BLUE + "Press enter to return to main menu" + ANSI_RESET);
        sc.nextLine();
        Helper.clearConsole();
    }

}
