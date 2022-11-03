package Controller.SeatControl;

import java.io.IOException;
import java.util.ArrayList;

import Controller.DatabaseManager;
import Model.*;

public class SeatManager {

    public static void addNewSeat(ArrayList<Seat> seatDB, String seatID, String seatType, String seatStatus) {
        Seat seat = new Seat(seatID);
        seatDB.add(seat);
    }

    public static void deleteSeat(ArrayList<Seat> seatDB, String seatID) {
        seatDB.remove(seatID);
    }

    public static void assignSeat(ArrayList<Seat> seatDB, String seatID, int customerId) {
        for (Seat seat : seatDB) {
            if (seat.getSeatID() == seatID) {
                seat.assign(customerId);
            }
        }
    }

    public static void unassignSeat(ArrayList<Seat> seatDB, String seatID) {
        for (Seat seat : seatDB) {
            if (seat.getSeatID().equals(seatID)) {
                seat.unassign();
            }
        }
    }

    public static boolean getSeatStatus(ArrayList<Seat> seatDB, String seatID) {
        for (Seat seat : seatDB) {
            if (seat.getSeatID().equals(seatID)) {
                return seat.isAssigned();
            }
        }
        return false;
    }

    public void saveSeat(String filename, ArrayList<Seat> seatDB) throws IOException {
        // save seatDB to file
        DatabaseManager.writeSerializedObject(filename, seatDB);
    }

    public ArrayList<Seat> loadSeat(String filename)
            throws IOException, SecurityException, ClassNotFoundException {
        // load seatDB from file
        return DatabaseManager.readSerializedObject(filename);
    }

    public ArrayList<Seat> getSeatsByHall(ArrayList<Seat> seatDB, String cinemaCode) {
        ArrayList<Seat> temp = new ArrayList<Seat>();
        for (Seat seat : seatDB) {
            if (seat.getCinemaCode() == cinemaCode) {
                temp.add(seat);
            }
        }
        return temp;
    }

}
