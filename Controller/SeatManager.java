package Controller;

import java.io.IOException;
import java.util.ArrayList;
import Model.*;

public class SeatManager {

    // public static ArrayList<Seat> createSeatList(){

    // }

    public static void addNewSeat(ArrayList<Seat> seatDB, int seatID, String seatType, String seatStatus) {
        Seat seat = new Seat(seatID);
        seatDB.add(seat);
    }

    public static void deleteSeat(ArrayList<Seat> seatDB, int seatID) {
        seatDB.remove(seatID);
    }

    public static void assignSeat(ArrayList<Seat> seatDB, int seatID, int customerId) {
        for (Seat seat : seatDB) {
            if (seat.getSeatID() == seatID) {
                seat.assign(customerId);
            }
        }
    }

    public static void unassignSeat(ArrayList<Seat> seatDB, int seatID) {
        for (Seat seat : seatDB) {
            if (seat.getSeatID() == seatID) {
                seat.unassign();
            }
        }
    }

    public static boolean getSeatStatus(ArrayList<Seat> seatDB, int seatID) {
        for (Seat seat : seatDB) {
            if (seat.getSeatID() == seatID) {
                return seat.isAssigned();
            }
        }
        return false;
    }

    public void saveSeat(String filename, ArrayList<Seat> seatDB) throws IOException {
        // save seatDB to file
        DatabaseManager.saveArray(filename, seatDB);
    }

    public static ArrayList<Seat> loadSeat(String filename, String className)
            throws IOException, SecurityException, ClassNotFoundException {
        // load seatDB from file
        return DatabaseManager.readCSV(filename, "Model.Seat");
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

    public static void printSeat(Seat seat) {
        System.out.println("Seat ID: " + seat.getSeatID());
        System.out.println("Seat Type: " + seat.getSeatType());
        System.out.println("Seat Status: " + seat.isAssigned());
    }

    public void printSeat3DGrid(ArrayList<Seat> seatDB) {
        int seatCount = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (seatDB.get(seatCount).isAssigned()) {
                    System.out.print("X ");
                } else {
                    System.out.print("O ");
                }
                seatCount++;
            }
            System.out.println();
        }
    }

}
