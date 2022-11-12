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
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_CYAN = "\u001B[36m";
    public static void createMovie(MovieManager mm)
            throws SecurityException, ClassNotFoundException, IOException {

        ArrayList<Movie> movieDB = new ArrayList<Movie>();
        movieDB = mm.loadObjects(DatabaseFilePath.Movies.getFilePath());
        System.out.println(
                ANSI_BLUE + "=====================================================================");
        System.out.println("                    Create New Movie Listing                       ");
        System.out.println("=====================================================================" + ANSI_RESET);
        Movie newMovie = fullMoviePrompt();
        if (newMovie == null) {
            System.out.println(ANSI_BLUE + "Movie creation cancelled" + ANSI_RESET);
            return;
        }
        MovieManager.printMovie(newMovie);

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


    public static Movie fullMoviePrompt() {
        System.out.println(ANSI_BLUE + "Enter 0 to return to main menu." + ANSI_RESET);
        System.out.println(ANSI_BLUE + "Enter Movie Type: \n 1. 3D \n 2. Blockbuster \n 3. Normal" + ANSI_RESET);
        String movieType = sc.nextLine();
        if (movieType.equals("0")) {
            return null;
        }
        System.out.println(ANSI_BLUE + "Enter Movie Title: " + ANSI_RESET);
        String movieTitle = sc.nextLine();
        if (movieTitle.equals("0")) {
            return null;
        }
        System.out.println(ANSI_BLUE + "Enter Movie Rating: \n 1. G \n 2. PG \n 3. PG13 \n 4. NC16 \n 5. M18 \n 6. R21"
                + ANSI_RESET);
        String movieRating = sc.nextLine();
        if (movieRating.equals("0")) {
            return null;
        }
        System.out
                .println(ANSI_BLUE + "Enter Movie Status: \n 1. Coming Soon \n 2. Preview \n 3. Now Showing"
                        + ANSI_RESET);
        String movieStatus = sc.nextLine();
        if (movieStatus.equals("0")) {
            return null;
        }
        System.out.println(ANSI_BLUE + "Enter Movie Synopsis: " + ANSI_RESET);
        String movieSynopsis = sc.nextLine();
        if (movieSynopsis.equals("0")) {
            return null;
        }
        System.out.println(ANSI_BLUE + "Enter Movie Director: " + ANSI_RESET);
        String movieDirector = sc.nextLine();
        if (movieDirector.equals("0")) {
            return null;
        }
        System.out.println(ANSI_BLUE + "Enter Number of Movie Casts: " + ANSI_RESET);
        ArrayList<String> movieCast = new ArrayList<String>();
        ArrayList<Review> reviewsDB = new ArrayList<Review>();
        int cast = sc.nextInt();
        sc.nextLine();
        if (cast == 0) {
            return null;
        }
        for (int i = 0; i < cast; i++) {
            System.out.println(ANSI_BLUE + "Enter Movie Cast: " + ANSI_RESET);
            String castName = sc.nextLine();
            movieCast.add(castName);
        }
        Movie newMovie = new Movie(movieType, movieTitle, movieStatus, movieSynopsis, movieDirector, movieCast,
                reviewsDB, movieRating);
        System.out.println();
        System.out.println(ANSI_RESET);
        return newMovie;
    }

}
