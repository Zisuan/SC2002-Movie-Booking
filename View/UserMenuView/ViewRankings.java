package View.UserMenuView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import Controller.BookingManager;
import Controller.Helpers.DatabaseFilePath;
import Controller.MovieControl.MovieManager;
import Controller.ReviewControl.ReviewManager;
import Controller.TicketControl.TicketManager;
import Model.Movie;
import Model.Ticket;
import Model.Movie.MovieStatus;
import View.ConfigureSystemSettings;
import View.Helper;

public class ViewRankings {
    private static String dbPath = DatabaseFilePath.MovieSessions.getFilePath();

    public static final Scanner sc = new Scanner(System.in);

    public static void listRankingMenu() throws SecurityException, ClassNotFoundException, IOException {
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_CYAN = "\u001B[36m";
        final String FILEPATH = "./database/";
        String choice;
        MovieManager mm = new MovieManager();
        ReviewManager rm = new ReviewManager();
        TicketManager tm = new TicketManager();
        BookingManager bm = new BookingManager();
        String whatToDisplay = ConfigureSystemSettings.getSettings().get(0);
        do {
            Helper.clearConsole();
            System.out.println(
                    ANSI_BLUE + "=====================================================================");
            System.out.println("                         Top 5 Movie Rankings              ");
            System.out.println("=====================================================================" + ANSI_RESET);
            int i = 1;
            switch (Integer.parseInt(whatToDisplay)) {
                case 1:
                    System.out.println(ANSI_CYAN + i + ". List the Top 5 ranking movie by ticket sales");
                    break;
                case 2:
                    System.out.println(ANSI_CYAN + i + ". List the Top 5 ranking movie by overall ratings");
                    break;
                case 3:
                    System.out.println(ANSI_CYAN + i + ". List the Top 5 ranking movie by ticket sales");
                    System.out.println(ANSI_CYAN + (++i) + ". List the Top 5 ranking movie by overall ratings");
                    break;
            }
            System.out.println(++i + ". Back to Main Menu");
            System.out.println(++i + ". Exit");
            System.out.println("=====================================================================");
            System.out.println("                           Enter Option:                             ");
            System.out.println("=====================================================================" + ANSI_RESET);
            choice = sc.nextLine();
            if (whatToDisplay != null) {
                switch (choice) {
                    case "1":
                        if (Integer.parseInt(whatToDisplay) == 1) {
                            listTop5ByTicketSales(bm, tm);
                        } else {
                            listTop5ByOverallRatings(mm);
                        }
                        break;
                    case "2":
                        if (Integer.parseInt(whatToDisplay) == 1) {
                            return;
                        } else {
                            listTop5ByOverallRatings(mm);
                        }
                        break;
                    case "3":
                        if (Integer.parseInt(whatToDisplay) == 1) {
                            System.exit(0);
                        } else {
                            return;
                        }
                        return;
                    case "4":
                        System.exit(0);
                    default:
                        System.out.println("Invalid Input");
                        break;
                }
            }
        } while (true);
    }

    public static void listTop5ByTicketSales(BookingManager bm, TicketManager tm)
            throws SecurityException, ClassNotFoundException, IOException {
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_CYAN = "\u001B[36m";
        ArrayList<Ticket> tickets = tm.loadObjects(DatabaseFilePath.Tickets.getFilePath());
        ArrayList<Movie> movies = new ArrayList<Movie>();
        for (Ticket ticket : tickets) {
            if (movies.size() == 0) {
                movies.add(ticket.getMovieSession().getMovie());
            } else {
                boolean isExist = false;
                for (Movie movie : movies) {
                    if (movie.getMovieCode().equals(ticket.getMovieSession().getMovie().getMovieCode())) {
                        isExist = true;
                        break;
                    }
                }
                if (!isExist) {
                    movies.add(ticket.getMovieSession().getMovie());
                }
            }
        }
        for (

        Movie movie : movies) {
            int count = 0;
            for (Ticket ticket : tickets) {
                if (ticket.getMovieSession().getMovie().getMovieTitle().equals(movie.getMovieTitle())) {
                    count++;
                }
            }
            movie.setTicketSales(count);
        }
        for (int i = 0; i < movies.size() - 1; i++) {
            for (int j = i + 1; j < movies.size(); j++) {
                if (movies.get(i).getTicketSales() < movies.get(j).getTicketSales()) {
                    Movie temp = movies.get(i);
                    movies.set(i, movies.get(j));
                    movies.set(j, temp);
                }
            }
        }
        System.out.println(
                ANSI_BLUE + "=====================================================================");
        System.out.println("                    TOp 5 Movies by Ticket Sales              ");
        System.out.println("=====================================================================" + ANSI_RESET);

        MovieManager.printMovieTitlesAndSales(movies);

        System.out.println(
                ANSI_BLUE + "=====================================================================");
        System.out.println("                    Press Enter to Continue              ");
        System.out.println("=====================================================================" + ANSI_RESET);
        sc.nextLine();

    }

    public static void listTop5ByOverallRatings(MovieManager mm)
            throws SecurityException, ClassNotFoundException, IOException {
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_CYAN = "\u001B[36m";
        ArrayList<Movie> movies = mm.loadObjects(DatabaseFilePath.Movies.getFilePath());
        // use insertion sort to sort the movies by overall rating
        for (int i = 1; i < movies.size(); i++) {
            Movie temp = movies.get(i);
            int j = i - 1;
            while (j >= 0 && movies.get(j).getMovieOverallRating() < temp.getMovieOverallRating()) {
                movies.set(j + 1, movies.get(j));
                j--;
            }
            movies.set(j + 1, temp);
        }
        System.out.println(
                ANSI_BLUE + "=====================================================================");
        System.out.println("                    TOp 5 Movies by Overall Ratings              ");
        System.out.println("=====================================================================" + ANSI_RESET);
        MovieManager.printMovieTitlesAndOverallRatings(movies);

        System.out.println(
                ANSI_BLUE + "=====================================================================");
        System.out.println("                    Press Enter to Continue              ");
        System.out.println("=====================================================================" + ANSI_RESET);
        sc.nextLine();

    }

}
