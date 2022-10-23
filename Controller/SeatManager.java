package Controller;

import java.util.ArrayList;
import Model.*;

public interface SeatManager {

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
}
