package View.ShowtimeView;

import java.util.*;

import Controller.MovieControl.MovieManager;
import Model.Cinema;
import Model.Movie;

import java.io.IOException;

public class RemoveShowTime {

    public static final Scanner sc = new Scanner(System.in);

    public static void removeShowTime(MovieManager mm) throws IOException, SecurityException, ClassNotFoundException {
        ArrayList<Movie> movieDB = new ArrayList<Movie>();
        System.out.println("=====REMOVE SHOWTIME=====");
        // show showtimes for movie
        // ask for showtime id to delete
        Movie movie = CreateShowTime.chooseAMovie(movieDB);
        Cinema cinema = null;

        System.out.println("Enter Showtime ID to delete movie showtime: ");
        // delete showtime
        // save showtime
        // System.out.println("Showtime Listing for todo" + showtimeMovie + "
        // Deleted!");
        System.out.println("Showtime Listing for todo" + " Deleted!");

        // sc.close();
    }
}
