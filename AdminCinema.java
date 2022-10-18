import java.util.*;
import java.io.File; // Import the File class
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException; // Import the IOException class to handle errors
import java.io.Reader; // Import the File class

public class AdminCinema extends Cinema {

    public AdminCinema(String cinemaName, String cinemaCode, String cinemaType) {
        super(cinemaName, cinemaCode, cinemaType); //
    }

    // create cinema
    public static void addCinema() {

        File csvFile = new File("Cinemas.csv");
        try (FileWriter fileWriter = new FileWriter(csvFile, true)) {
            Scanner sc = new Scanner(System.in);
            String cinemaName, cinemaCode, cinemaType;
            System.out.println("Enter cinema name: ");
            cinemaName = sc.nextLine();
            System.out.println("Enter cinema code: ");
            cinemaCode = sc.nextLine();
            System.out.println("Enter cinema type: ");
            cinemaType = sc.nextLine();
            fileWriter.append((System.getProperty("line.separator")));
            fileWriter.append(cinemaName + "," + cinemaCode + "," + cinemaType);
            System.out.println("Cinema added successfully");
            fileWriter.close();
            sc.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    // update cinema
    public static void updateCinema() {
        File csvFile = new File("Cinemas.csv");
        try (Scanner reader = new Scanner(csvFile)) {
            Scanner sc = new Scanner(System.in);
            String cinemaName, cinemaCode, cinemaType;
            System.out.println("Enter cinema name: ");
            cinemaName = sc.nextLine();
            System.out.println("Enter cinema code: ");
            cinemaCode = sc.nextLine();
            System.out.println("Enter cinema type: ");
            cinemaType = sc.nextLine();
            Cinema cinema = new Cinema(cinemaName, cinemaCode, cinemaType);
            while (reader.hasNext()) {
                String data = reader.nextLine();
                String[] values = data.split(",");
                if (values[0].equals(cinemaName)) {
                    values[0] = cinemaName;
                    values[1] = cinemaCode;
                    values[2] = cinemaType;
                }
            }
            // no clue la sia fk this shyt
            System.out.println("Cinema updated successfully");
            sc.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // remove cinema
    public static void removeCinema() {
        Scanner sc = new Scanner(System.in);
        String cinemaName, cinemaCode, cinemaType;
        System.out.println("Enter cinema name: ");
        cinemaName = sc.nextLine();
        System.out.println("Enter cinema code: ");
        cinemaCode = sc.nextLine();
        System.out.println("Enter cinema type: ");
        cinemaType = sc.nextLine();
        Cinema cinema = new Cinema(cinemaName, cinemaCode, cinemaType);
        System.out.println("Cinema removed successfully");
        sc.close();
    }
}
