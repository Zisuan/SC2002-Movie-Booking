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
        ArrayList<Movie> movieDB = mm.loadObjects(DatabaseFilePath.Movies.getFilePath());
        ArrayList<MovieSession> movieSessionDB = msm.loadObjects(DatabaseFilePath.MovieSessions.getFilePath());
        System.out.println("=====REMOVE SHOWTIME=====");
        // show showtimes for movie
        // ask for showtime id to delete
        Movie movie = CreateShowTime.chooseAMovie(movieDB);
        Cinema cinema = null;

        System.out.println("Enter Showtime ID to delete movie showtime: ");
        MovieSession selectedSession = UpdateShowTime.chooseAShowtime(movieSessionDB, msm);
        // delete showtime
        msm.removeMovieSession(movieSessionDB, selectedSession);
        // save showtime
        // System.out.println("Showtime Listing for todo" + showtimeMovie + "
        // Deleted!");
        System.out.println("Showtime Listing for" + selectedSession.getMovie().getMovieTitle() + " on "
                + selectedSession.getMovieDate() + "@" + selectedSession.getMovieTime() + " has been deleted!");

        // sc.close();
    }
}
