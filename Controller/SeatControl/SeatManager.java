package Controller.SeatControl;

import java.util.ArrayList;

import Controller.ObjectControl.ObjectManager;
import Model.*;

public class SeatManager extends ObjectManager<Seat> {

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

    public ArrayList<Seat> getSeatsByHall(ArrayList<Seat> seatDB, String cinemaCode) {
        ArrayList<Seat> temp = new ArrayList<Seat>();
        for (Seat seat : seatDB) {
            if (seat.getCinemaCode() == cinemaCode) {
                temp.add(seat);
            }
        }
        return temp;
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
