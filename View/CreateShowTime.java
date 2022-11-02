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

    public static void CeateShowTime
    {

        Scanner sc = new Scanner(System.in);

        ShowtimeManager sm = new ShowtimeManager();
        ArrayList<Showtime> showtimeDB = new ArrayList<Showtime>();
        String dbPath = FILEPATH + "Showtime.dat";
        showtimeDB = sm.loadShowtime(dbPath);
        System.out.print("CREATE NEW SHOWTIME LISTING");
        System.out.print("Enter Showtime ID: ");
        String showtimeID = sc.nextLine();
        System.out.print("Enter Showtime Date: ");
        String showtimeDate = sc.nextLine();
        System.out.print("Enter Showtime Time: ");
        String showtimeTime = sc.nextLine();
        System.out.print("Enter Showtime Status: ");
        String showtimeStatus = sc.nextLine();
        System.out.print("Enter Showtime Type: ");
        String showtimeType = sc.nextLine();
        System.out.print("Enter Showtime Movie: ");
        String showtimeMovie = sc.nextLine();
        System.out.print("Enter Showtime Cinema: ");
        String showtimeCinema = sc.nextLine();
        System.out.print("Enter Showtime Price: ");
        double showtimePrice = sc.nextDouble();
        sm.addShowtime(showtimeDB, showtimeID, showtimeDate, showtimeTime, showtimeStatus, showtimeType, showtimeMovie,
                showtimeCinema, showtimePrice);
        sm.saveShowtime(dbPath, showtimeDB);

    }
}
