package View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.net.ssl.TrustManager;

import Controller.Helpers.DatabaseFilePath;
import Controller.MovieControl.MovieManager;
import Controller.ReviewControl.ReviewManager;
import Controller.TicketControl.TicketManager;
import Model.Movie;
import Model.Ticket;
import Model.Movie.MovieStatus;

public class ListTop5Movie {
    private static String dbPath = DatabaseFilePath.MovieSessions.getFilePath();

    public static final Scanner sc = new Scanner(System.in);

    public static void listTop5RankingMovieByOverallReviews(MovieManager mm, ReviewManager rm) {

    }

    public static void listTop5RankingMovieByTicketSales(MovieManager mm, TicketManager tm)
            throws SecurityException, ClassNotFoundException, IOException {
        ArrayList<Ticket> ticketList = tm.loadObjects(DatabaseFilePath.Tickets.getFilePath());
        ArrayList<Movie> movieList = mm.loadObjects(DatabaseFilePath.Movies.getFilePath());
        ArrayList<Movie> movieInSessionList = mm.getMoviesByStatus(movieList, MovieStatus.NOW_SHOWING);

        for (Movie movie : movieInSessionList) {
            Movie TopMovie = null;
            int ticketSales = 0;
            ticketSales = tm.getNumberOfTicketSales(ticketList, movie.getMovieTitle());

        }
    }

}