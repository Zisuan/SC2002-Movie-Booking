package View;

import java.util.*;
import java.io.IOException;
import Controller.MovieManager;
import Controller.ShowtimeManager;
import Model.Movie;
import Model.Showtime;
import Model.Cinema;

public class CreateShowTime {

    public static final String FILEPATH = "./database/";

    public static void CreateShowTime() throws SecurityException, ClassNotFoundException, IOException {

        Scanner sc = new Scanner(System.in);

        ShowtimeManager sm = new ShowtimeManager();
        ArrayList<Showtime> showtimeDB = new ArrayList<Showtime>();
        String dbPath = FILEPATH + "Showtime.dat";
        showtimeDB = sm.loadShowtime(dbPath);
        System.out.print("CREATE NEW SHOWTIME LISTING");
        System.out.println("Enter Showtime Date: ");
        String movieDate = sc.nextLine();
        System.out.print("Enter Showtime: ");
        String showtimeTime = sc.nextLine();
        System.out.print("Enter Showtime Movie: ");
        String showtimeMovie = sc.nextLine();
        System.out.print("Enter Showtime Cinema: ");
        String showtimeCinema = sc.nextLine();
        sm.addShowtime(showtimeDB, showtimeMovie, showtimeCinema, movieDate, showtimeTime);
        sm.saveShowtime(dbPath, showtimeDB);

    }
}
