package View;

import java.util.*;
import java.io.IOException;
import Controller.MovieManager;
import Model.Movie;

public class ShowtimeListing {
    public static void ShowtimeMenu() {
        int choice;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("1. Add Showtime");
            System.out.println("2. Update Showtime");
            System.out.println("3. Remove Showtime");
            System.out.println("4. Back");
            System.out.println("Option: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    CreateShowTime.addShowtime();
                    break;
                case 2:
                    UpdateShowtime.updateShowtime();
                    break;
                case 3:
                    RemoveShowtime.removeShowtime();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option");
                    System.out.println("Please re-enter!");
                    break;
            }
        } while (choice != 4);

    }

}
