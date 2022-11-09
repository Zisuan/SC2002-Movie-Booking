package View.MovieView;

import java.util.*;

import Controller.MovieControl.MovieManager;
import View.Helper;

import java.io.IOException;

public class MovieListing {

    public static final Scanner sc = new Scanner(System.in);

    public static void MovieMenu(MovieManager mm)
            throws SecurityException, ClassNotFoundException, IOException {

        int listing;
        do {
            Helper.clearConsole();
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
                    CreateMovie.createMovie(mm);
                    break;
                case 2:
                    UpdateMovie.updateMovie(mm);
                    break;
                case 3:
                    RemoveMovie.removeMovie(mm);
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option");
                    System.out.println("Please re-enter!");
                    break;
            }
        } while (listing != 4);
    }
}