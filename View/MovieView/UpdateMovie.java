package View.MovieView;

import java.util.*;

import Controller.Helpers.DatabaseFilePath;
import Controller.MovieControl.MovieManager;
import Controller.MovieSessionControl.MovieSessionManager;

import java.io.IOException;

import Model.Movie;
import Model.MovieSession;
import Model.Movie.MovieStatus;
import Model.Movie.MovieType;

public class UpdateMovie {

    public static final Scanner sc = new Scanner(System.in);

    // TODO: poor ui
    public static void updateMovie(MovieManager mm, MovieSessionManager msm)
            throws SecurityException, ClassNotFoundException, IOException {
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_CYAN = "\u001B[36m";
        ArrayList<Movie> movieDB = new ArrayList<Movie>();
        int select;
        boolean updated = false;
        do {
            movieDB = mm.loadObjects(DatabaseFilePath.Movies.getFilePath());
            System.out.println(
                    ANSI_BLUE + "=====================================================================");
            System.out.println("                    Update Current Movie Listing                    ");
            System.out.println("=====================================================================" + ANSI_RESET);

            System.out.println(ANSI_BLUE + "Enter Movie ID to update movie: " + ANSI_RESET);
            System.out.println(ANSI_BLUE + "Enter 0 to return to main menu." + ANSI_RESET);
            MovieManager.printMovieTitlesAndCodeAndStatus(movieDB);
            String selectedMovieIndex = sc.nextLine();
            Movie selectedMovie = mm.getMovieByIndex(movieDB, selectedMovieIndex);
            ArrayList<MovieSession> movieSessionDB = msm.loadObjects(DatabaseFilePath.MovieSessions.getFilePath());
            // if (selectedMovieIndex.equals("0")) {
            // break;
            // }
            System.out.println(
                    ANSI_BLUE + "=====================================================================" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "1. Update Movie Type");
            System.out.println("2. Update Movie Title");
            System.out.println("3. Update Movie Code");
            System.out.println("4. Update Movie Rating");
            System.out.println("5. Update Movie Status");
            System.out.println("6. Update Movie Synopsis");
            System.out.println("7. Update Movie Director");
            System.out.println("8. Update Movie Cast");
            System.out.println("9. Update Everything");
            System.out.println("10. Exit" + ANSI_RESET);
            System.out.println(ANSI_BLUE + "=====================================================================");
            System.out.println("                           Select Update Case:                       ");
            System.out.println("=====================================================================" + ANSI_RESET);
            select = sc.nextInt();
            sc.nextLine();
            switch (select) {
                case 1:
                    System.out.println(ANSI_CYAN + "---------------UPDATE MOVIE TYPE---------------");
                    System.out.println("Enter Movie Type: \n 1. 3D \n 2. Blockbuster \n 3. Normal");
                    String movieType = sc.nextLine();
                    mm.updateMovie(select, movieDB, selectedMovie, movieType, null, movieSessionDB);
                    System.out.println("Movie Type Updated!" + ANSI_RESET);
                    updated = true;
                    break;
                case 2:
                    System.out.println(ANSI_CYAN + "---------------UPDATE MOVIE TITLE---------------");
                    System.out.println("Enter Movie Title: ");
                    String movieTitle2 = sc.nextLine();
                    mm.updateMovie(select, movieDB, selectedMovie, movieTitle2, null, movieSessionDB);
                    System.out.println("Movie Title Updated!" + ANSI_RESET);
                    updated = true;
                    break;
                case 3:
                    System.out.println(ANSI_CYAN + "---------------UPDATE MOVIE CODE---------------");
                    System.out.println("Enter Movie Code: ");
                    String movieCode3 = sc.nextLine();
                    mm.updateMovie(select, movieDB, selectedMovie, movieCode3, null, movieSessionDB);
                    System.out.println("Movie Code Updated!" + ANSI_RESET);
                    updated = true;
                    break;
                case 4:
                    System.out.println(ANSI_CYAN + "---------------UPDATE MOVIE RATING---------------");
                    System.out
                            .println("Enter Movie Rating: \n 1. G \n 2. PG \n 3. PG13 \n 4. NC16 \n 5. M18 \n 6. R21");
                    String movieRating4 = sc.nextLine();
                    mm.updateMovie(select, movieDB, selectedMovie, movieRating4, null, movieSessionDB);
                    System.out.println("Movie Rating Updated!" + ANSI_RESET);
                    updated = true;
                    break;
                case 5:
                    System.out.println(ANSI_CYAN + "---------------UPDATE MOVIE STATUS---------------");
                    System.out.println(
                            "Enter Movie Status: \n 1. Coming Soon \n 2. Preview \n 3. Now Showing \n 4. End of Showing");
                    String movieStatus5 = sc.nextLine();
                    mm.updateMovie(select, movieDB, selectedMovie, movieStatus5, null, movieSessionDB);
                    System.out.println("Movie Status Updated!" + ANSI_RESET);
                    updated = true;
                    break;
                case 6:
                    System.out.println(ANSI_CYAN + "---------------UPDATE MOVIE SYNOPSIS---------------");
                    System.out.println("Enter Movie Synopsis: ");
                    String movieSynopsis6 = sc.nextLine();
                    mm.updateMovie(select, movieDB, selectedMovie, movieSynopsis6, null, movieSessionDB);
                    System.out.println("Movie Synopsis Updated!" + ANSI_RESET);
                    updated = true;
                    break;
                case 7:
                    System.out.println(ANSI_CYAN + "---------------UPDATE MOVIE DIRECTOR---------------");
                    System.out.println("Enter Movie Director: ");
                    String movieDirector7 = sc.nextLine();
                    mm.updateMovie(select, movieDB, selectedMovie, movieDirector7, null, movieSessionDB);
                    System.out.println("Movie Director Updated!" + ANSI_RESET);
                    updated = true;
                    break;
                case 8:
                    System.out.println(ANSI_CYAN + "---------------UPDATE MOVIE CAST---------------");
                    System.out.println("Enter Number of Movie Cast: ");
                    int numCast = sc.nextInt();
                    ArrayList<String> movieCast = new ArrayList<String>();
                    for (int i = 0; i < numCast; i++) {
                        System.out.println("Enter Movie Cast: ");
                        String movieCast8 = sc.nextLine();
                        movieCast.add(movieCast8);
                    }
                    mm.updateMovie(select, movieDB, selectedMovie, null, movieCast, movieSessionDB);
                    System.out.println("Movie Cast Updated!" + ANSI_RESET);
                    updated = true;
                    break;
                case 9:
                    System.out.println(ANSI_CYAN + "---------------UPDATE EVERYTHING---------------");

                    Movie oldMovie = selectedMovie;
                    Movie updatedMovie = CreateMovie.fullMoviePrompt();
                    mm.updateWholeMovie(movieDB, updatedMovie, oldMovie);
                    mm.printMovies(movieDB);
                    System.out.println("Movie Updated!" + ANSI_RESET);
                    updated = true;
                    break;
                case 10:
                    System.out.println(ANSI_CYAN + "Exit" + ANSI_RESET);
                    break;
                default:
                    System.out.println(ANSI_CYAN + "Invalid Input" + ANSI_RESET);
                    break;
            }
        } while (updated == false && select != 10);
        mm.saveObjects(DatabaseFilePath.Movies.getFilePath(), movieDB);
    }
}