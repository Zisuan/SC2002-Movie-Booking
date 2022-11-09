package View.ShowtimeView;

import java.util.*;
import java.io.IOException;
import java.time.LocalDate;

import Controller.CinemaControl.CinemaManager;
import Controller.Helpers.DatabaseFilePath;
import Controller.MovieControl.MovieManager;
import Controller.MovieSessionControl.MovieSessionManager;
import Controller.SeatControl.SeatManager;
import Model.Movie;
import Model.MovieSession;
import Model.Seat;
import Model.Cinema;

public class CreateShowTime {

    public static final Scanner sc = new Scanner(System.in);

    public static void CreateShowTime(MovieSessionManager msm, MovieManager mm, CinemaManager cm, SeatManager sm)
            throws SecurityException, ClassNotFoundException, IOException {

        ArrayList<MovieSession> movieSessionDB = msm.loadObjects(DatabaseFilePath.MovieSessions.getFilePath());
        ArrayList<Movie> movieDB = mm.loadObjects(DatabaseFilePath.Movies.getFilePath());
        movieDB = mm.filterMovieByBookableStatus(movieDB);
        ArrayList<Cinema> cinemaDB = cm.loadObjects(DatabaseFilePath.Cinemas.getFilePath());
        System.out.println("====CREATE NEW SHOWTIME LISTING====");
        MovieSession movieSession = fullMovieSessionPrompt(movieDB, cinemaDB, sm);
        msm.addMovieSession(movieSessionDB, movieSession);
        msm.saveObjects(DatabaseFilePath.MovieSessions.getFilePath(), movieSessionDB);
        System.out.println("Showtime Listing for " + movieSession.getMovie().getMovieTitle() + " Created!");

    }

    public static MovieSession fullMovieSessionPrompt(ArrayList<Movie> movieDB, ArrayList<Cinema> cinemaDB,
            SeatManager sm) throws IOException {
        Movie movie = null;
        Cinema cinema = null;
        do {
            System.out.println("Choose a movie: ");
            MovieManager.printMovieTitlesAndCode(movieDB);
            String movieIndex = sc.nextLine();
            movie = MovieManager.getMovieByIndex(movieDB, movieIndex);
        } while (movie == null);

        System.out.println("Enter New Showtime Date: (YYYY-MM-DD)");
        String movieDate = sc.nextLine();
        LocalDate showtimeDate = LocalDate.parse(movieDate);
        System.out.print("Enter New Showtime Timing: ");
        String movieTime = sc.nextLine();

        cinema = chooseACinema(cinemaDB);

        System.out.println("Please enter the number of seats for this showtime: ");
        System.out.println("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.println("Enter number of columns: ");
        int cols = sc.nextInt();
        ArrayList<Seat> sessionSeatsDB = sm.generateSeats(rows, cols, cinema);

        MovieSession movieSession = new MovieSession(movie, cinema, showtimeDate, movieTime, sessionSeatsDB);
        return movieSession;
    }

    public static Movie chooseAMovie(ArrayList<Movie> movieDB) {
        Movie movie = null;
        do {
            System.out.println("Choose a movie: ");
            MovieManager.printMovieTitlesAndCode(movieDB);
            String movieIndex = sc.nextLine();
            movie = MovieManager.getMovieByIndex(movieDB, movieIndex);
        } while (movie == null);
        return movie;
    }

    public static Cinema chooseACinema(ArrayList<Cinema> cinemaDB) {
        Cinema cinema = null;
        do {
            System.out.println("Enter Cinema Code: ");
            CinemaManager.printCinemaTitlesAndCode(cinemaDB);
            String cinemaCode = sc.nextLine();
            cinemaCode = cinemaDB.get(Integer.parseInt(cinemaCode) - 1).getCinemaCode();
            cinema = CinemaManager.searchCinemaByCode(cinemaDB, cinemaCode);
        } while (cinema == null);
        return cinema;
    }
}
