package Controller.SeatControl;

import java.util.ArrayList;

import Controller.ObjectControl.ObjectManager;
import Model.*;
import Model.Seat.SeatType;
import View.Helper;

public class SeatManager extends ObjectManager<Seat> {

    public ArrayList<Seat> generateSeats(int rows, int columns, String cinemaCode) {
        String rowString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        ArrayList<Seat> seats = new ArrayList<Seat>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                String seatID = rowString.charAt(i) + String.format("%02d", j + 1);
                Seat seat = new Seat(seatID, cinemaCode, rowString.charAt(i) + "", String.format("%02d", j + 1),
                        SeatType.NORMAL, false, 0);
                seats.add(seat);
            }
        }
        return seats;
    }

    public void addNewSeat(ArrayList<Seat> seatDB, String seatID, String seatType, boolean assigned) {
        Seat seat = new Seat(seatID);
        if (objectExists(seatDB, seat)) {
            seatDB.add(seat);
        }
    }

    public static void deleteSeat(ArrayList<Seat> seatDB, String seatID) {
        for (Seat seat : seatDB) {
            if (seat.getSeatID().equals(seatID)) {
                seatDB.remove(seat);
                break;
            }
        }
    }

    public static void assignSeat(ArrayList<Seat> seatDB, String seatID, int customerId) {
        for (Seat seat : seatDB) {
            if (seat.getSeatID().equalsIgnoreCase(seatID)) {
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

    public static String getSessionSeatsInGrid(ArrayList<Seat> sessionSeats) {
        int seatCount = 0;
        String seatGrid = "  ";
        String row = sessionSeats.get(sessionSeats.size() - 1).getSeatRow();
        String column = sessionSeats.get(sessionSeats.size() - 1).getSeatColumn();
        int rowCount = Helper.getIntFromCharacter(row);
        int columnCount = Integer.parseInt(column);
        for (int f = 1; f < columnCount + 1; f++) {
            seatGrid += " " + f;
        }
        for (int i = 0; i < rowCount; i++) {
            seatGrid += "\n" + Helper.getCharacterFromInt(i) + ": ";
            for (int j = 0; j < columnCount; j++) {
                if (sessionSeats.get(seatCount).isAssigned()) {
                    seatGrid += "X ";
                } else {
                    seatGrid += "O ";
                }
                seatCount++;
            }
        }
        return seatGrid;
    }

    @Override
    public boolean objectExists(ArrayList<Seat> objectDB, Seat object) {
        for (Seat seat : objectDB) {
            if (seat.getSeatID().equals(object.getSeatID())) {
                return true;
            }
        }
        return false;
    }

}
