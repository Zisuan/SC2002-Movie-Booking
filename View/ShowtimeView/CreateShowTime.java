package View.ShowtimeView;

import java.util.*;
import java.io.IOException;
import java.time.LocalDate;

import Controller.CinemaControl.CinemaManager;
import Controller.MovieControl.MovieManager;
import Controller.MovieSessionControl.MovieSessionManager;
import Model.Movie;
import Model.MovieSession;
import Model.Seat;
import Model.Cinema;

public class CreateShowTime {

    public static final String FILEPATH = "./database/";

    public static void CreateShowTime() throws SecurityException, ClassNotFoundException, IOException {

        Scanner sc = new Scanner(System.in);

        MovieSessionManager msm = new MovieSessionManager();
        MovieManager mm = new MovieManager();
        CinemaManager cm = new CinemaManager();
        ArrayList<MovieSession> movieSessionDB = new ArrayList<MovieSession>();
        ArrayList<Movie> movieDB = new ArrayList<Movie>();
        ArrayList<Cinema> cinemaDB = new ArrayList<Cinema>();
        ArrayList<Seat> sessionSeats = null;
        String dbPath = FILEPATH + "Showtime.dat";
        movieSessionDB = msm.loadObjects(dbPath);
        movieDB = mm.loadObjects(FILEPATH + "Movies.dat");
        cinemaDB = cm.loadObjects(FILEPATH + "Cinemas.dat");
        System.out.print("====CREATE NEW SHOWTIME LISTING====");
        System.out.print("Enter Movie Name: ");
        String showtimeMovie = sc.nextLine();
        System.out.println("Enter New Showtime Date: ");
        String movieDate = sc.nextLine();
        LocalDate showtimeDate = LocalDate.parse(movieDate);
        System.out.print("Enter New Showtime Timing: ");
        String movieTime = sc.nextLine();
        Movie movie = mm.searchMovie(movieDB, showtimeMovie);
        System.out.print("Enter New Showtime Cinema: ");
        String showtimeCinema = sc.nextLine();
        Cinema cinema = cm.getCinemaByName(cinemaDB, showtimeCinema);
        msm.addMovieSession(movieSessionDB, movie, cinema, showtimeDate, movieTime, sessionSeats);
        msm.saveObjects(dbPath, movieSessionDB);
        System.out.println("Showtime Listing for " + showtimeMovie + " Created!");

    }
}
