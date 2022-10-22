package View;

import java.util.*;
import java.io.IOException;
import Controller.MovieManager;
import Model.Movie;

public class StaffMenu {

    public static final String FILEPATH = "./database/";

    public static void adminMenu() throws SecurityException, ClassNotFoundException, IOException {
        Scanner sc = new Scanner(System.in);
        int choice;
        System.out.println("Welcome to Staff Menu");
        System.out.println("Select an option: ");
        System.out.println("1. Movie Listings");
        System.out.println("2. Showtimes");
        System.out.println("3. System Setting");
        System.out.println("4. Logout");
        System.out.println("Option: ");

        choice = sc.nextInt();
        switch (choice) {
            case 1:
                MovieManager mm = new MovieManager(choice, null, null, null, null, null, null, null, null,
                        null, null);
                ArrayList<Movie> movieDB = new ArrayList<Movie>();
                String dbPath = FILEPATH + "Movies.csv";
                movieDB = mm.loadMovie(dbPath, "Model.Movie");
                System.out.println("MOVIE LISTING");
                System.out.println("1. Create New Movie Listing");
                System.out.println("2. Update Current Movie Listing");
                System.out.println("3. Remove Movie Listing");
                System.out.println("4. Exit");
                System.out.println("Option > ");
                int listing = sc.nextInt();
                switch (listing) {
                    case 1:
                        // mm.addMovie(movieDB, "Avengers", "PG13", "Action", "English", "2D", "1hr
                        // 30min", "2019-05-01", "2019-05-31", "2019-05-01", "2019-05-31");
                        System.out.println("CREATE NEW MOVIE LISTING");
                        System.out.println("Enter Movie ID: ");
                        int movieID = sc.nextInt();
                        System.out.println("Enter Movie Type: ");
                        String movieType = sc.next();
                        System.out.println("Enter Movie Title: ");
                        String movieTitle = sc.next();
                        System.out.println("Enter Movie Code: ");
                        String movieCode = sc.next();
                        System.out.println("Enter Movie Rating: ");
                        String movieRating = sc.next();
                        System.out.println("Enter Movie Status: ");
                        String movieStatus = sc.next();
                        System.out.println("Enter Movie Synopsis: ");
                        String movieSynopsis = sc.next();
                        System.out.println("Enter Movie Director: ");
                        String movieDirector = sc.next();
                        System.out.println("Enter Movie Cast: ");
                        String movieCast = sc.next();
                        System.out.println("Enter Movie Review: ");
                        String movieReview = sc.next();
                        System.out.println("Enter Overall Rating: ");
                        String overallRating = sc.next();
                        mm.addMovie(movieDB, movieID, movieType, movieTitle, movieCode, movieRating, movieStatus,
                                movieSynopsis,
                                movieDirector, movieCast, movieReview, overallRating);
                        mm.saveMovie(dbPath, movieDB);

                        break;
                    case 2:
                        int select;
                        System.out.println("UPDATE CURRENT MOVIE LISTING");
                        System.out.println("Select Update case");
                        System.out.println("1. Update Movie Type");
                        System.out.println("2. Update Movie Title");
                        System.out.println("3. Update Movie Code");
                        System.out.println("4. Update Movie Rating");
                        System.out.println("5. Update Movie Status");
                        System.out.println("6. Update Movie Synopsis");
                        System.out.println("7. Update Movie Director");
                        System.out.println("8. Update Movie Cast");
                        System.out.println("9. Update Movie Review");
                        System.out.println("10. Update Overall Rating");
                        System.out.println("11. Update Everything");
                        System.out.println("12. Exit");
                        select = sc.nextInt();
                        switch (select) {
                            case 1:
                                System.out.println("UPDATE MOVIE TYPE");
                                System.out.println("Enter Movie ID: ");
                                int movieID1 = sc.nextInt();
                                System.out.println("Enter Movie Type: ");
                                String movieType1 = sc.next();
                                mm.updateMovie(select, movieDB, movieID1, movieType1, dbPath, dbPath, dbPath, dbPath,
                                        dbPath, dbPath, dbPath, dbPath, dbPath);
                                mm.saveMovie(dbPath, movieDB);
                                break;
                            case 2:
                                System.out.println("UPDATE MOVIE TITLE");
                                System.out.println("Enter Movie ID: ");
                                int movieID2 = sc.nextInt();
                                System.out.println("Enter Movie Title: ");
                                String movieTitle2 = sc.next();
                                mm.updateMovie(listing, movieDB, movieID2, dbPath, movieTitle2, dbPath, dbPath, dbPath,
                                        dbPath, dbPath, dbPath, dbPath, dbPath);
                                mm.saveMovie(dbPath, movieDB);
                                break;
                            case 3:
                                System.out.println("UPDATE MOVIE CODE");
                                System.out.println("Enter Movie ID: ");
                                int movieID3 = sc.nextInt();
                                System.out.println("Enter Movie Code: ");
                                String movieCode3 = sc.next();
                                mm.updateMovie(listing, movieDB, movieID3, dbPath, dbPath, movieCode3, dbPath, dbPath,
                                        dbPath, dbPath, dbPath, dbPath, dbPath);
                                mm.saveMovie(dbPath, movieDB);
                                break;
                            case 4:
                                System.out.println("UPDATE MOVIE RATING");
                                System.out.println("Enter Movie ID: ");
                                int movieID4 = sc.nextInt();
                                System.out.println("Enter Movie Rating: ");
                                String movieRating4 = sc.next();
                                mm.updateMovie(listing, movieDB, movieID4, dbPath, dbPath, dbPath, movieRating4, dbPath,
                                        dbPath, dbPath, dbPath, dbPath, dbPath);
                                mm.saveMovie(dbPath, movieDB);
                                break;
                            case 5:
                                System.out.println("UPDATE MOVIE STATUS");
                                System.out.println("Enter Movie ID: ");
                                int movieID5 = sc.nextInt();
                                System.out.println("Enter Movie Status: ");
                                String movieStatus5 = sc.next();
                                mm.updateMovie(listing, movieDB, movieID5, dbPath, dbPath, dbPath, dbPath, movieStatus5,
                                        dbPath, dbPath, dbPath, dbPath, dbPath);
                                mm.saveMovie(dbPath, movieDB);
                                break;
                            case 6:
                                System.out.println("UPDATE MOVIE SYNOPSIS");
                                System.out.println("Enter Movie ID: ");
                                int movieID6 = sc.nextInt();
                                System.out.println("Enter Movie Synopsis: ");
                                String movieSynopsis6 = sc.next();
                                mm.updateMovie(listing, movieDB, movieID6, dbPath, dbPath, dbPath, dbPath,
                                        dbPath, movieSynopsis6, dbPath, dbPath, dbPath, dbPath);
                                mm.saveMovie(dbPath, movieDB);
                                break;
                            case 7:
                                System.out.println("UPDATE MOVIE DIRECTOR");
                                System.out.println("Enter Movie ID: ");
                                int movieID7 = sc.nextInt();
                                System.out.println("Enter Movie Director: ");
                                String movieDirector7 = sc.next();
                                mm.updateMovie(listing, movieDB, movieID7, dbPath, dbPath, dbPath, dbPath,
                                        dbPath, dbPath, movieDirector7, dbPath, dbPath, dbPath);
                                mm.saveMovie(dbPath, movieDB);
                                break;
                            case 8:
                                System.out.println("UPDATE MOVIE CAST");
                                System.out.println("Enter Movie ID: ");
                                int movieID8 = sc.nextInt();
                                System.out.println("Enter Movie Cast: ");
                                String movieCast8 = sc.next();
                                mm.updateMovie(listing, movieDB, movieID8, dbPath, dbPath, dbPath, dbPath, dbPath,
                                        dbPath, dbPath, movieCast8, dbPath, dbPath);
                                mm.saveMovie(dbPath, movieDB);
                                break;
                            case 9:
                                System.out.println("UPDATE MOVIE REVIEW");
                                System.out.println("Enter Movie ID: ");
                                int movieID9 = sc.nextInt();
                                System.out.println("Enter Movie Review: ");
                                String movieReview9 = sc.next();
                                mm.updateMovie(listing, movieDB, movieID9, dbPath, dbPath, dbPath, dbPath, dbPath,
                                        dbPath, dbPath, dbPath, movieReview9, dbPath);
                                mm.saveMovie(dbPath, movieDB);
                                break;
                            case 10:
                                System.out.println("UPDATE OVERALL RATING");
                                System.out.println("Enter Movie ID: ");
                                int movieID10 = sc.nextInt();
                                System.out.println("Enter Overall Rating: ");
                                String overallRating10 = sc.next();
                                mm.updateMovie(listing, movieDB, movieID10, dbPath, dbPath, dbPath, dbPath,
                                        dbPath, dbPath, dbPath, dbPath, dbPath, overallRating10);
                                mm.saveMovie(dbPath, movieDB);
                                break;
                            case 11:
                                System.out.println("UPDATE EVERYTHING");
                                System.out.println("Enter Movie ID: ");
                                int movieID11 = sc.nextInt();
                                System.out.println("Enter Movie Type: ");
                                String movieType11 = sc.next();
                                System.out.println("Enter Movie Title: ");
                                String movieTitle11 = sc.next();
                                System.out.println("Enter Movie Code: ");
                                String movieCode11 = sc.next();
                                System.out.println("Enter Movie Rating: ");
                                String movieRating11 = sc.next();
                                System.out.println("Enter Movie Status: ");
                                String movieStatus11 = sc.next();
                                System.out.println("Enter Movie Synopsis: ");
                                String movieSynopsis11 = sc.next();
                                System.out.println("Enter Movie Director: ");
                                String movieDirector11 = sc.next();
                                System.out.println("Enter Movie Cast: ");
                                String movieCast11 = sc.next();
                                System.out.println("Enter Movie Review: ");
                                String movieReview11 = sc.next();
                                System.out.println("Enter Overall Rating: ");
                                String overallRating11 = sc.next();
                                mm.updateMovie(listing, movieDB, movieID11, movieType11, movieTitle11, movieCode11,
                                        movieRating11, movieStatus11, movieSynopsis11, movieDirector11, movieCast11,
                                        movieReview11, overallRating11);
                                mm.saveMovie(dbPath, movieDB);
                                break;
                        }
                        break;
                    case 3:
                        System.out.println("DELETE MOVIE");
                        System.out.println("Enter Movie ID: ");
                        int movieID10 = sc.nextInt();
                        mm.removeMovie(movieDB, movieID10);
                        mm.saveMovie(dbPath, movieDB);
                        break;
                    case 4:
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option");
                        System.out.println("Please re-enter!");
                        break;
                }
                break;
            case 2:
                System.out.println("SHOWTIMES");
                System.out.println("1. Create New Showtime");
                System.out.println("2. Update Current Showtime");
                System.out.println("3. Remove Showtime");
                System.out.println("4. Exit");
                System.out.println("Option: ");
                int showtime = sc.nextInt();
                switch (showtime) {
                    // case 1:
                    // MovieManager.addShowtime();
                    // break;
                    // case 2:
                    // MovieManager.updateShowtime();
                    // break;
                    // case 3:
                    // MovieManager.removeShowtime();
                    // break;
                    case 4:
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option");
                        System.out.println("Please re-enter!");
                        break;
                }
                break;
            case 3:
                System.out.println("SYSTEM SETTINGS");
                System.out.println("1. Configure System Settings");
                System.out.println("2. Exit");
                System.out.println("Option: ");
                int system = sc.nextInt();
                switch (system) {
                    case 1:
                        ConfigureSystemSettings.configureSystemSettings();
                        break;
                    case 2:
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option");
                        System.out.println("Please re-enter!");
                        break;
                }
                break;
            case 4:
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Invalid option");
                System.out.println("Please re-enter!");
                break;
        }
    }
}
