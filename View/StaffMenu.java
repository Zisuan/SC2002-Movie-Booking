package View;

import java.util.*;

import Controller.MovieManager;

public class StaffMenu {

    public static void adminMenu() {
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
                System.out.println("MOVIE LISTING");
                System.out.println("1. Create New Movie Listing");
                System.out.println("2. Update Current Movie Listing");
                System.out.println("3. Remove Movie Listing");
                System.out.println("4. Exit");
                System.out.println("Option > ");
                int listing = sc.nextInt();
                switch (listing) {
                    case 1:
                        System.out.println("CREATE NEW MOVIE LISTING");
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
                        MovieManager.addMovie(null, movieType, movieTitle, movieCode, movieRating, movieStatus,
                                movieSynopsis,
                                movieDirector, movieCast, movieReview, overallRating);

                        break;
                    // case 2:
                    // MovieManager.updateMovie();
                    // break;
                    // case 3:
                    // MovieManager.removeMovie();
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
