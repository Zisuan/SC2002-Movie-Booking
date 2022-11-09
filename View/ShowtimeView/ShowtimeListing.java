package View.ShowtimeView;

import java.util.*;

import Controller.CinemaControl.CinemaManager;
import Controller.MovieControl.MovieManager;
import Controller.MovieSessionControl.MovieSessionManager;
import Controller.SeatControl.SeatManager;

import java.io.IOException;

import Model.Movie;

public class ShowtimeListing {
    public static final Scanner sc = new Scanner(System.in);

    public static void ShowtimeMenu() throws SecurityException, ClassNotFoundException, IOException {
        MovieSessionManager msm = new MovieSessionManager();
        MovieManager mm = new MovieManager();
        CinemaManager cm = new CinemaManager();
        SeatManager sm = new SeatManager();
        int choice;
        do {
            System.out.println("1. Add Showtime");
            System.out.println("2. Update Showtime");
            System.out.println("3. Remove Showtime");
            System.out.println("4. Back");
            System.out.println("Option: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    CreateShowTime.CreateShowTime(msm, mm, cm, sm);
                    break;
                case 2:
                    UpdateShowTime.updateShowTime(msm, cm, mm, sm);
                    break;
                case 3:
                    RemoveShowTime.removeShowTime(mm);
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
