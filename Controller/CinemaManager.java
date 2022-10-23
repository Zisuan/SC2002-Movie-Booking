package Controller;

import java.util.*;
import Model.Cinema;
import java.io.IOException; // Import the IOException class to handle errors

public class CinemaManager implements SeatManager {

    public void addCinema(ArrayList<Cinema> cinemaDB, String cinemaName, String cinemaCode, String cinemaType,
            int cinemaSeatDBID) {
        // int newID = cinemaDB.size() + 1;
        // check for duplicate cinema code
        Cinema newCinema = new Cinema(cinemaName, cinemaCode, cinemaType, cinemaSeatDBID);
        boolean exists = false;
        for (Cinema cinema : cinemaDB) {
            if (cinema.getCinemaCode().equals(cinemaCode)) {
                System.out.println("Cinema code already exists");
                exists = true;
                break;
            }
        }
        if (!exists) {
            cinemaDB.add(newCinema);
        }
    }

    public static void updateCinema(int upadateCase, ArrayList<Cinema> cinemaDB, int cinemaID, String cinemaName,
            String cinemaCode, String cinemaType) {
        switch (upadateCase) {
            case 1:
                cinemaDB.get(cinemaID - 1).setCinemaName(cinemaName);
                break;
            case 2:
                cinemaDB.get(cinemaID - 1).setCinemaCode(cinemaCode);
                break;
            case 3:
                cinemaDB.get(cinemaID - 1).setCinemaType(cinemaType);
                break;
            case 4:
                cinemaDB.get(cinemaID - 1).setCinemaName(cinemaName);
                cinemaDB.get(cinemaID - 1).setCinemaCode(cinemaCode);
                cinemaDB.get(cinemaID - 1).setCinemaType(cinemaType);
                break;
        }
    }

    public static void deleteCinema(ArrayList<Cinema> cinemaDB, int cinemaID) {
        cinemaDB.remove(cinemaID - 1);
    }

    public static Cinema getCinema(ArrayList<Cinema> cinemaDB, int cinemaID) {
        return cinemaDB.get(cinemaID - 1);
    }

    public static void printCinema(Cinema cinema) {
        // System.out.println("Cinema ID: " + cinema.getCinemaID());
        System.out.println("Cinema Name: " + cinema.getCinemaName());
        System.out.println("Cinema Code: " + cinema.getCinemaCode());
        System.out.println("Cinema Type: " + cinema.getCinemaType());
        System.out.println("Cinema Type: " + cinema.getCinemaSeatDBID());
    }

    public void printCinemas(ArrayList<Cinema> cinemaDB) {
        for (int i = 0; i < cinemaDB.size(); i++) {
            printCinema(cinemaDB.get(i));
            System.out.println();
        }
    }

    public void saveCinema(String filename, ArrayList<Cinema> cinemaDB) throws IOException {
        DatabaseManager.saveArray(filename, cinemaDB);

    }

    public ArrayList<Cinema> loadCinema(String filename, String className)
            throws IOException, SecurityException, ClassNotFoundException {
        return DatabaseManager.readCSV(filename, "Model.Cinema");
    }

}
