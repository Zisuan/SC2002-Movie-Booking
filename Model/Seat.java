package Model;

import java.util.*;

public class Seat {
    private int seatID;
    private String seatRow;
    private String seatColumn;
    private String seatType;
    private boolean assigned;
    private int customerId;

    public Seat(ArrayList<String> fieldTokens) {
        this.seatID = Integer.parseInt(fieldTokens.get(0));
        this.seatRow = fieldTokens.get(1);
        this.seatColumn = fieldTokens.get(2);
        this.seatType = fieldTokens.get(3);
        this.assigned = Boolean.parseBoolean(fieldTokens.get(4));
        this.customerId = Integer.parseInt(fieldTokens.get(5));
    }

    public Seat(int seatID) {
        this.seatID = seatID;
        this.seatRow = this.seatColumn = "";
        this.assigned = false;
        this.customerId = 0;
    }

    public Seat(int seatID, String seatRow, String seatColumn, String seatType, Boolean assigned, int customerId) {
        this.seatID = seatID;
        this.seatRow = seatRow;
        this.seatColumn = seatColumn;
        this.assigned = assigned;
        this.customerId = customerId;
    }

    public int getSeatID() {
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

}