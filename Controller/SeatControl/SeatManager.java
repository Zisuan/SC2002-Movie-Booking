package Controller.SeatControl;

import java.util.ArrayList;

import Controller.ObjectControl.ObjectManager;
import Model.*;
import Model.Seat.SeatType;
import View.Helper;

public class SeatManager extends ObjectManager<Seat> {

    public ArrayList<Seat> generateSeats(int rows, int columns, Cinema cinema) {
        String rowString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        ArrayList<Seat> seats = new ArrayList<Seat>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                String seatID = rowString.charAt(i) + String.format("%02d", j + 1);
                Seat seat = new Seat(seatID, cinema, rowString.charAt(i) + "", String.format("%02d", j + 1));
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

    public static void assignSeat(ArrayList<Seat> seatDB, Seat selectedSeat) {
        String seatID = selectedSeat.getSeatID();
        for (Seat seat : seatDB) {
            if (seat.getSeatID().equalsIgnoreCase(seatID)) {
                if (!seat.isAssigned()) {
                    seat.assign();
                    break;
                } else {
                    System.out.println("Seat is already taken!");
                    break;
                }
            }
            // System.out.println("Seat does not exist!");
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
            if (seat.getSeatID().equalsIgnoreCase(seatID)) {
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
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_CYAN = "\u001B[36m";
        final String ANSI_GREEN = "\u001B[32m";
        int seatCount = 0;
        String seatGrid = "  ";
        String row = sessionSeats.get(sessionSeats.size() - 1).getSeatRow();
        String column = sessionSeats.get(sessionSeats.size() - 1).getSeatColumn();
        int rowCount = Helper.getIntFromCharacter(row);
        int columnCount = Integer.parseInt(column);
        for (int f = 1; f < columnCount + 1; f++) {
            seatGrid += " " + ANSI_CYAN + f + ANSI_RESET;
        }
        for (int i = 0; i < rowCount; i++) {
            seatGrid += ANSI_CYAN + "\n" + Helper.getCharacterFromInt(i) + ": " + ANSI_RESET;
            for (int j = 0; j < columnCount; j++) {
                if (sessionSeats.get(seatCount).isAssigned()) {
                    seatGrid += ANSI_RED + "X " + ANSI_RESET;
                } else {
                    seatGrid += ANSI_GREEN + "O " + ANSI_RESET;
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
