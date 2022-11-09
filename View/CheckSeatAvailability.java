package View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Controller.Helpers.DatabaseFilePath;
import Controller.MovieControl.MovieManager;
import Controller.MovieSessionControl.MovieSessionManager;
import Model.Cinema;
import Model.Movie;
import Model.MovieSession;

public class CheckSeatAvailability {
    public static final Scanner sc = new Scanner(System.in);
    private static String dbPath = DatabaseFilePath.MovieSessions.getFilePath();

    public static void checkSeatAvailability(MovieManager mm, MovieSessionManager msm)
            throws IOException, ClassNotFoundException {
        ArrayList<Movie> movieDB = new ArrayList<Movie>();
        ArrayList<MovieSession> movieSessionDB = new ArrayList<MovieSession>();
        ArrayList<MovieSession> selectedMovieSessionDB = new ArrayList<MovieSession>();
        ArrayList<Cinema> cinemaDB = new ArrayList<Cinema>();
        movieSessionDB = msm.loadObjects(dbPath);

        System.out.println("---------Check Seat Availability---------");
        System.out.println("Please select the movie you want to check the seat availability for:");
        movieDB = msm.getMoviesInSession(movieSessionDB, mm);
        if (movieDB.size() == 0) {
            System.out.println("There are no movies in session at the moment.");
            System.out.println("Please come back later.");
            System.out.println("Press enter to return to main menu.");
            sc.nextLine();
            return;
        }
        mm.printMovieTitles(movieDB);
        // mm.printMovies(movieDB);
        String movieIndex = sc.nextLine();
        Movie selectedMovie = mm.getMovieByIndex(movieDB, movieIndex);
        cinemaDB = msm.filterSessionsByMovie(movieSessionDB, movieIndex);

        System.out.println("Please select the cinema you want to check the seat availability for:");
        msm.printCinemas(cinemaDB);
        String cinemaCode = sc.nextLine();
        Cinema selectedCinema = cinemaDB.get(Integer.parseInt(cinemaCode) - 1);

        System.out.println("Please select the date you want to check the seat availability for:");
        selectedMovieSessionDB = msm.filterSessionsByMovieAndCinema(movieSessionDB, selectedMovie.getMovieTitle(),
                selectedCinema.getCinemaCode());
        msm.printShowtimes(selectedMovieSessionDB);
        String showtime = sc.nextLine();
        MovieSession seletedShowtime = msm.getMovieSession(selectedMovieSessionDB, Integer.parseInt(showtime));
        msm.printSessionSeats(seletedShowtime);

    }
}