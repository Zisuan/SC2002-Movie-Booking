package Model;

import java.util.*;

public class Seat {
    private int seatID;
    private String seatType;
    private boolean assigned;
    private String customerId;

    public Seat(int seatID) {
        this.seatID = seatID;
        this.assigned = false;
        this.customerId = "0";
    }

    public int getSeatID() {
        return seatID;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void assign(String customerId) {
        this.assigned = true;
        this.customerId = customerId;
    }

    public void unassign() {
        this.assigned = false;
        this.customerId = "0";
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

}