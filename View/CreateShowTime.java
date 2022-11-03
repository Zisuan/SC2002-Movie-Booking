package View;

import java.util.*;
import java.io.IOException;
import Controller.MovieManager;
import Controller.CinemaControl.CinemaManager;
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
        movieSessionDB = msm.loadMovieSession(dbPath);
        movieDB = mm.loadMovie(FILEPATH + "Movies.dat");
        cinemaDB = cm.loadCinema(FILEPATH + "Cinemas.dat");
        System.out.print("====CREATE NEW SHOWTIME LISTING====");
        System.out.print("Enter Movie Name: ");
        String showtimeMovie = sc.nextLine();
        System.out.println("Enter New Showtime Date: ");
        String movieDate = sc.nextLine();
        System.out.print("Enter New Showtime Timing: ");
        String movieTime = sc.nextLine();
        Movie movie = mm.searchMovie(movieDB, showtimeMovie);
        System.out.print("Enter New Showtime Cinema: ");
        String showtimeCinema = sc.nextLine();
        Cinema cinema = cm.getCinemaByName(cinemaDB, showtimeCinema);
        msm.addMovieSession(movieSessionDB, movie, cinema, movieDate, movieTime, sessionSeats);
        msm.saveMovieSession(dbPath, movieSessionDB);
        System.out.println("Showtime Listing for " + showtimeMovie + " Created!");

    }
}
