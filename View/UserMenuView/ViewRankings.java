package View.UserMenuView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Controller.BookingManager;
import Controller.Helpers.DatabaseFilePath;
import Controller.MovieControl.MovieManager;
import Controller.ReviewControl.ReviewManager;
import Controller.TicketControl.TicketManager;
import Model.Movie;
import Model.Ticket;
import Model.Movie.MovieStatus;
import View.Helper;

public class ViewRankings {
    private static String dbPath = DatabaseFilePath.MovieSessions.getFilePath();

    public static final Scanner sc = new Scanner(System.in);

    public static void listRankingMenu() {
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_CYAN = "\u001B[36m";
        final String FILEPATH = "./database/";
        String choice;
        MovieManager mm = new MovieManager();
        ReviewManager rm = new ReviewManager();
        TicketManager tm = new TicketManager();
        do {
            Helper.clearConsole();
            System.out.println("=====================================================================" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "1. List the Top 5 ranking movie by ticket sales");
            System.out.println("2. List the Top 5 ranking movie by overall ratings");
            System.out.println("3. Back to Main Menu");
            System.out.println("4. Exit");
            System.out.println("=====================================================================");
            System.out.println("                           Enter Option:                             ");
            System.out.println("=====================================================================" + ANSI_RESET);
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    listTop5ByTicketSales();
                    break;
                case "2":
                    listTop5ByOverallRatings(mm, rm);
                    break;
                case "3":
                    return;
                case "4":
                    System.exit(0);
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        } while (true);
    }

    private static void listTop5ByTicketSales(BookingManager bm, TicketManager tm) {
        ArrayList<Ticket> tickets = tm.loadObjects(DatabaseFilePath.Tickets.getFilePath());
        ArrayList<Movie> movies = new ArrayList<Movie>();
        for (Ticket ticket : tickets) {
            if (!movies.contains(ticket.getMovieSession().getMovie())) {
                movies.add(ticket.getMovieSession().getMovie());
            }
        }
        for (Movie movie : movies) {
            int count = 0;
            for (Ticket ticket : tickets) {
                if (ticket.getMovieSession().getMovie().equals(movie)) {
                    count++;
                }
            }
            movie.setTicketSales(count);
        }
        movies.sort((Movie m1, Movie m2) -> m2.getTicketSales() - m1.getTicketSales());
        System.out.println("Top 5 Movies by Ticket Sales");
        for (int i = 0; i < 5; i++) {
            System.out.println((i + 1) + ". " + movies.get(i).getTitle());
        }

    }

    public static void listTop5ByOverallRatings(MovieManager mm, ReviewManager rm) {

    }

    public static void listTop5RankingMovieByTicketSales(MovieManager mm, TicketManager tm)
            throws SecurityException, ClassNotFoundException, IOException {
        var ticketList = tm.loadObjects(DatabaseFilePath.Tickets.getFilePath());
        ArrayList<Movie> movieList = mm.loadObjects(DatabaseFilePath.Movies.getFilePath());
        ArrayList<Movie> movieInSessionList = mm.getMoviesByStatus(movieList, MovieStatus.NOW_SHOWING);

        for (Movie movie : movieInSessionList) {
            Movie TopMovie = null;
            int ticketSales = 0;
            ticketSales = tm.getNumberOfTicketSales(ticketList, movie.getMovieTitle());

        }
    }

}
