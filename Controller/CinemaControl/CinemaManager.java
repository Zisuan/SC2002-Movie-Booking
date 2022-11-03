package Controller.CinemaControl;

import java.util.*;

import Controller.DatabaseManager;
import Model.*;
import java.io.IOException; // Import the IOException class to handle errors

public class CinemaManager extends CinemaPrinter {

    public void addCinema(ArrayList<Cinema> cinemaDB, String cinemaName, String cinemaCode, String cinemaType) {
        // int newID = cinemaDB.size() + 1;
        // check for duplicate cinema code
        Cinema newCinema = new Cinema(cinemaName, cinemaCode, cinemaType);
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

    public void addCinemaWithSeats(ArrayList<Cinema> cinemaDB, String cinemaName, String cinemaCode, String cinemaType,
            ArrayList<Seat> seatDB) {
        // int newID = cinemaDB.size() + 1;
        // check for duplicate cinema code
        Cinema newCinema = new Cinema(cinemaName, cinemaCode, cinemaType, seatDB);
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

    public Cinema getCinema(ArrayList<Cinema> cinemaDB, String cinemaCode) {
        Cinema cinema = null;
        for (Cinema c : cinemaDB) {
            if (c.getCinemaCode().equals(cinemaCode)) {
                cinema = c;
                break;
            }
        }
        return cinema;
    }

    public static Cinema getCinemaByName(ArrayList<Cinema> cinemaDB, String cinemaName) {
        for (Cinema c : cinemaDB) {
            if (c.getCinemaName().equals(cinemaName)) {
                System.out.println(c);
                return c;
            }
        }
        return null;
    }

    public void saveCinema(String filename, ArrayList<Cinema> cinemaDB) throws IOException {
        DatabaseManager.writeSerializedObject(filename, cinemaDB);

    }

    public ArrayList<Cinema> loadCinema(String filename)
            throws IOException, SecurityException, ClassNotFoundException {
        ArrayList<Cinema> cinemaDB = DatabaseManager.readSerializedObject(filename);
        if (cinemaDB == null) {
            cinemaDB = new ArrayList<Cinema>();
        }
        return cinemaDB;
    }
    // public void saveCinema(String filename, ArrayList<Cinema> cinemaDB) throws
    // IOException {
    // DatabaseManager.writeSerializedObject(filename, cinemaDB);

    // }

    // public ArrayList<Cinema> loadCinema(String filename, String className)
    // throws IOException, SecurityException, ClassNotFoundException {
    // return DatabaseManager.readCSV(filename, "Model.Cinema");
    // }

    // public ArrayList<Cinema> loadCinemaWithSeat(String filename, String
    // className, ArrayList<Seat> seatDB)
    // throws IOException, SecurityException, ClassNotFoundException {
    // ArrayList<Cinema> cinemaDB = DatabaseManager.readCSV(filename,
    // "Model.Cinema");
    // seatDB = SeatManager.loadSeat("Seat.csv", "Model.Seat");
    // // either make a db of seatdb or make a db of seats then add to cinema
    // for (Cinema cinema : cinemaDB) {
    // ArrayList<Seat> temp = new ArrayList<Seat>();
    // for (Seat seat : seatDB) {
    // if (cinema.getCinemaCode() == seat.getCinemaCode()) {
    // temp.add(seat);
    // seatDB.remove(seat);
    // }
    // cinema.setCinemaSeatDB(temp);
    // }
    // }
    // return cinemaDB;
    // }

}