package View.ShowtimeView;

import java.util.*;

import Controller.CinemaControl.CinemaManager;
import Controller.Helpers.DatabaseFilePath;
import Controller.MovieControl.MovieManager;
import Controller.MovieSessionControl.MovieSessionManager;
import Controller.SeatControl.SeatManager;
import Model.Cinema;
import Model.Movie;
import Model.MovieSession;

import java.io.IOException;
import java.time.LocalDate;

public class UpdateShowTime {

    public static final Scanner sc = new Scanner(System.in);

    public static void updateShowTime(MovieSessionManager msm, CinemaManager cm, MovieManager mm, SeatManager sm)
            throws SecurityException, ClassNotFoundException, IOException {
        // update show time
        ArrayList<MovieSession> movieSessionDB = msm.loadObjects(DatabaseFilePath.MovieSessions.getFilePath());
        ArrayList<Cinema> cinemaDB = cm.loadObjects(DatabaseFilePath.Cinemas.getFilePath());
        ArrayList<Movie> movieDB = mm.loadObjects(DatabaseFilePath.Movies.getFilePath());
        System.out.print("====UPDATE SHOWTIME LISTING====");

        Movie movie = CreateShowTime.chooseAMovie(movieDB);

        ArrayList<MovieSession> movieSessionsByMovie = msm.filterSessionsByMovie(movieSessionDB, movie);

        System.out.println("Enter Showtime ID to update movie showtime: ");
        msm.printShowtimes(movieSessionsByMovie);
        int showtimeID = sc.nextInt();
        MovieSession movieSession = movieSessionsByMovie.get(showtimeID - 1);

        System.out.println("Select Update case");
        System.out.println("1. Update Movie Date");
        System.out.println("2. Update Movie Time");
        System.out.println("3. Update Movie Cinema");
        System.out.println("4. Update All");
        System.out.println("5. Back");
        System.out.println("Option: ");
        int updateCase = sc.nextInt();
        sc.nextLine();
        switch (updateCase) {
            case 1:
                System.out.println("Enter New Showtime Date: (YYYY-MM-DD)");
                String movieDate = sc.nextLine();
                LocalDate showtimeDate = LocalDate.parse(movieDate);
                movieSession.setMovieDate(showtimeDate);
                System.out.println("Showtime Date Updated!");
                break;
            case 2:
                System.out.print("Enter New Showtime Timing: ");
                String movieTime = sc.nextLine();
                movieSession.setMovieTime(movieTime);
                System.out.println("Showtime Time Updated!");
                break;
            case 3:
                Cinema cinema = CreateShowTime.chooseACinema(cinemaDB);
                movieSession.setCinema(cinema);
                System.out.println("Showtime Cinema Updated!");
                break;
            case 4:
                CreateShowTime.fullMovieSessionPrompt(movieDB, cinemaDB, sm);
                break;
            case 5:
                break;
            default:
                System.out.println("Invalid Option");
                break;
        }
        msm.saveObjects(DatabaseFilePath.MovieSessions.getFilePath(), movieSessionDB);
        // case options for update
        // System.out.println("Showtime Listing for " + showtimeMovie + " Updated!");
    }
}