package View.MovieView;

import java.util.*;

import Controller.MovieControl.MovieManager;
import Controller.MovieSessionControl.MovieSessionManager;
import View.Helper;

import java.io.IOException;

public class MovieListing {

    public static final Scanner sc = new Scanner(System.in);

    public static void MovieMenu(MovieManager mm, MovieSessionManager msm)
            throws SecurityException, ClassNotFoundException, IOException {
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_CYAN = "\u001B[36m";

        int listing;
        do {
            // Helper.clearConsole();
            listing = 0;
            // print movie menu to staff
            System.out.println(
                    ANSI_BLUE + "=====================================================================");
            System.out.println("                       Movie Listings Menu                        ");
            System.out.println("=====================================================================" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "1. Create New Movie Listing");
            System.out.println("2. Update Current Movie Listing");
            System.out.println("3. Remove Movie Listing");
            System.out.println("4. Back" + ANSI_RESET);
            System.out.println(ANSI_BLUE + "=====================================================================");
            System.out.println("                           Enter Option:                             ");
            System.out.println("=====================================================================" + ANSI_RESET);
            listing = sc.nextInt();
            switch (listing) {
                case 1:
                    CreateMovie.createMovie(mm);
                    break;
                case 2:
                    UpdateMovie.updateMovie(mm, msm);
                    break;
                case 3:
                    RemoveMovie.removeMovie(mm);
                    break;
                case 4:
                    System.out.println(ANSI_BLUE+"Goodbye!"+ANSI_RESET);
                    break;
                default:
                    System.out.println(ANSI_BLUE+"Invalid option");
                    System.out.println("Please re-enter!"+ANSI_RESET);
                    break;
            }
        } while (listing != 4);
    }
}