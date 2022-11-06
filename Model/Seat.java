package Model;

import java.io.Serializable;
import java.util.*;

public class Seat implements Serializable {
    private String seatID;
    private String cinemaCode;
    private String seatRow;
    private String seatColumn;
    private String seatType;
    private boolean assigned;
    private int customerId;

    // public Seat(ArrayList<String> fieldTokens) {
    // this.seatID = Integer.parseInt(fieldTokens.get(0));
    // this.cinemaCode = fieldTokens.get(1);
    // this.seatRow = fieldTokens.get(2);
    // this.seatColumn = fieldTokens.get(3);
    // this.seatType = fieldTokens.get(4);
    // this.assigned = Boolean.parseBoolean(fieldTokens.get(5));
    // this.customerId = Integer.parseInt(fieldTokens.get(6));
    // }

    public Seat(String seatID) {
        this.seatID = seatID;
        this.seatRow = this.seatColumn = "";
        this.assigned = false;
        this.customerId = 0;
        this.cinemaCode = null;
    }

    public Seat(String seatID, String cinemaCode, String seatRow, String seatColumn, String seatType, Boolean assigned,
            int customerId) {
        this.seatID = seatID;
        this.cinemaCode = cinemaCode;
        this.seatRow = seatRow;
        this.seatColumn = seatColumn;
        this.assigned = assigned;
        this.customerId = customerId;
    }

    public String getSeatID() {
        return seatID;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void assign(int customerId) {
        this.assigned = true;
        this.customerId = customerId;
    }

    public void unassign() {
        this.assigned = false;
        this.customerId = 0;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public String getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(String seatRow) {
        this.seatRow = seatRow;
    }

    public String getSeatColumn() {
        return seatColumn;
    }

    public void setSeatColumn(String seatColumn) {
        this.seatColumn = seatColumn;
    }

    public String getCinemaCode() {
        return cinemaCode;
    }

    public void setCinemaCode(String cinemaID) {
        this.cinemaCode = cinemaID;
    }

    // to String
    @Override
    public String toString() {
        return "Seat ID: " + getSeatID() + "\n" +
                "Seat Row: " + getSeatRow() + "\n" +
                "Seat Column: " + getSeatColumn() + "\n" +
                "Seat Status: " + isAssigned();
    }

}