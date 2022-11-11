package View.ShowtimeView;

import java.util.*;

import Controller.Helpers.DatabaseFilePath;
import Controller.MovieControl.MovieManager;
import Controller.MovieSessionControl.MovieSessionManager;
import Controller.ObjectControl.ObjectManager;
import Model.Cinema;
import Model.Movie;
import Model.MovieSession;

import java.io.IOException;

public class RemoveShowTime {
    public static final Scanner sc = new Scanner(System.in);

    public static void removeShowTime(MovieManager mm, MovieSessionManager msm)
            throws IOException, SecurityException, ClassNotFoundException {
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_CYAN = "\u001B[36m";
        ArrayList<Movie> movieDB = mm.loadObjects(DatabaseFilePath.Movies.getFilePath());
        ArrayList<MovieSession> movieSessionDB = msm.loadObjects(DatabaseFilePath.MovieSessions.getFilePath());
        System.out.println(
                ANSI_BLUE + "=====================================================================");
        System.out.println("                         Remove Show Time                       ");
        System.out.println("=====================================================================" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "Enter 0 to return to main menu." + ANSI_RESET);
        // show showtimes for movie
        // ask for showtime id to delete
        Movie movie = CreateShowTime.chooseAMovie(movieDB);
        if (movie == null) {
            System.out.println(ANSI_BLUE + "Showtime removal cancelled" + ANSI_RESET);
            return;
        }
        ArrayList<MovieSession> movieSessionsByMovie = msm.filterSessionsByMovie(movieSessionDB, movie);
        if (movieSessionsByMovie.size() == 0) {
            System.out.println(ANSI_BLUE + "No showtime listing for " + movie.getMovieTitle() + " found!" + ANSI_RESET);
            return;
        }

        Cinema cinema = null;

        System.out.println(ANSI_BLUE + "Enter Showtime ID to delete movie showtime: " + ANSI_RESET);
        MovieSession selectedSession = UpdateShowTime.chooseAShowtime(movieSessionsByMovie, msm);
        if (selectedSession == null) {
            System.out.println(ANSI_BLUE + "Showtime removal cancelled" + ANSI_RESET);
            return;
        }
        // delete showtime
        msm.removeMovieSession(movieSessionDB, selectedSession);
        msm.saveObjects(DatabaseFilePath.MovieSessions.getFilePath(), movieSessionDB);
        // save showtime
        // System.out.println("Showtime Listing for todo" + showtimeMovie + "
        // Deleted!");
        System.out.println(ANSI_BLUE + "Showtime Listing for " + selectedSession.getMovie().getMovieTitle() + " on "
                + selectedSession.getMovieDate() + "@" + selectedSession.getMovieTime() + " has been deleted!"
                + ANSI_RESET);

        // sc.close();
    }
}
