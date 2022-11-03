package View;

import java.util.*;
import java.io.IOException;

public class UpdateShowTime {

    public static final String FILEPATH = "./database/";

    public static void updateShowTime() throws SecurityException, ClassNotFoundException, IOException {
        // update show time
        Scanner sc = new Scanner(System.in);
      
        System.out.print("====UPDATE SHOWTIME LISTING====");
        System.out.println("Enter Movie Code to update Movie Showtimes: ");
         // show showtimes for movie
        // ask for showtime id to delete
        System.out.println("Enter Showtime ID to update movie showtime: ");
        System.out.println("Select Update case");
        System.out.println("1. Update Movie Date");
        System.out.println("2. Update Movie Time");
        System.out.println("3. Update Movie Cinema");
        System.out.println("4. Update All");
        System.out.println("5. Back");
        System.out.println("Option: ");
        int updateCase = sc.nextInt();
        // case options for update
        System.out.println("Showtime Listing for " + showtimeMovie + " Updated!");
}