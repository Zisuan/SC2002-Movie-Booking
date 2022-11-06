package Controller.CinemaControl;

import java.util.*;

import javax.crypto.AEADBadTagException;

import Controller.ObjectControl.ObjectManager;
import Model.*;

public class CinemaManager extends ObjectManager<Cinema> {

    public void addCinema(ArrayList<Cinema> cinemaDB, String cinemaName, String cinemaCode, String cinemaType) {
        // int newID = cinemaDB.size() + 1;
        // check for duplicate cinema code
        Cinema newCinema = new Cinema(cinemaName, cinemaCode, cinemaType);
        addObject(cinemaDB, newCinema);
    }

    public void addCinemaWithSeats(ArrayList<Cinema> cinemaDB, String cinemaName, String cinemaCode, String cinemaType,
            ArrayList<Seat> seatDB) {
        // int newID = cinemaDB.size() + 1;
        // check for duplicate cinema code
        Cinema newCinema = new Cinema(cinemaName, cinemaCode, cinemaType, seatDB);
        addObject(cinemaDB, newCinema);
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

    public void printCinemaNamesWithMovie(ArrayList<Cinema> cinemaDB, String movieName) {
        int i = 0;
        for (Cinema c : cinemaDB) {
            ArrayList<Movie> movieDB = c.getCinemaMovieDB();
            for (Movie m : movieDB) {
                if (m.getMovieName().equals(movieName)) {
                    i++;
                    System.out.println(i + ". " + c.getCinemaName() + "- " + c.getCinemaType());

                }

            }
        }
    }
    // public void saveCinema(String filename, ArrayList<Cinema> cinemaDB) throws
    // IOException {
    // DatabaseManager.writeSerializedObject(filename, cinemaDB);

    @Override
    public boolean objectExists(ArrayList<Cinema> objectDB, Cinema object) {
        for (Cinema cinema : objectDB) {
            if (cinema.getCinemaCode().equals(object.getCinemaCode())) {
                return true;
            }
        }
        return false;
    }

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
