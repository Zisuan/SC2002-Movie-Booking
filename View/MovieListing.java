package View;

import java.util.*;
import java.io.IOException;
import Controller.MovieManager;
import Model.Movie;

public class MovieListing {

    public static final String FILEPATH = "./database/";

    public static void MovieMenu() throws SecurityException, ClassNotFoundException, IOException {

        int listing;
        do {
            System.out.print("\033[H\033[2J");
            Scanner sc = new Scanner(System.in);
            listing = 0;
            // print movie menu to staff
            System.out.println("MOVIE LISTING");
            System.out.println("1. Create New Movie Listing");
            System.out.println("2. Update Current Movie Listing");
            System.out.println("3. Remove Movie Listing");
            System.out.println("4. Back");
            System.out.println("Option: ");

            listing = sc.nextInt();
            switch (listing) {
                case 1:
                    CreateMovie.createMovie();
                    break;
                case 2:
                    UpdateMovie.updateMovie();
                    break;
                case 3:
                    RemoveMovie.removeMovie();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option");
                    System.out.println("Please re-enter!");
                    break;
            }
            // sc.close();
        } while (listing != 4);
    }
}