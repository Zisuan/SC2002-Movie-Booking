import java.io.IOException;
import java.util.*;

import Controller.CinemaManager;
import Controller.DatabaseManager;
import Controller.LoginManager;

import Model.*;

public class MovieBookingApp {

    public static final String FILEPATH = "./database/";

    public static void main(String[] args) throws IOException, SecurityException, ClassNotFoundException {
        int option;
        Scanner sc = new Scanner(System.in);
        System.out.println("=====================================================================");
        System.out.println("Welcome to MOBLIMA\n");
        System.out.println("(1) Use App as Admin");
        System.out.println("(2) Use App as Movie-goer");
        System.out.println("(3) Exit");
        System.out.println();

        do {
            System.out.print("Enter the number of your choice: ");
            option = sc.nextInt();
            if (option == 1) {
                LoginManager.login();
            } else if (option == 2) {
                LoginManager.login();
            } else if (option == 3) {
                System.out.println("Thank you for using MOBLIMA!");
                System.exit(0);
            } else {
                System.out.println("Invalid option");
            }
        } while (option != 3);
        sc.close();

        // CinemaManager cm = new CinemaManager();
        // ArrayList<Cinema> cinemaDB = new ArrayList<Cinema>();
        // String dbPath = FILEPATH + "Cinemas.csv";
        // cinemaDB = cm.loadCinema(dbPath, "Model.Cinema");
        // // cm.printCinemas(cinemaDB);
        // cm.addCinema(cinemaDB, "Cathay", "004", "3D", 4);
        // cm.addCinema(cinemaDB, "Cathay", "004", "2D", 5);
        // // cm.printCinemas(cinemaDB);
        // cm.saveCinema(dbPath, cinemaDB);
        // cm.printCinemas(cinemaDB);

    }
}
