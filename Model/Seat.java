package Model;

import java.io.Serializable;
import java.util.*;

public class Seat implements Serializable {
    private String seatID;
    private Cinema cinema;
    private String cinemaCode;
    private String seatRow;
    private String seatColumn;
    private SeatType seatType;
    private boolean assigned;
    private String customerId;
    private Customer customer;

    public enum SeatType {
        NORMAL, COUPLE
    }

    public Seat(String seatID) {
        this.seatID = seatID;
        this.seatRow = this.seatColumn = "";
        this.assigned = false;
        this.customerId = null;
        this.cinema = null;
    }

    public Seat(String seatID, Cinema cinema, String seatRow, String seatColumn, Boolean assigned,
            String customerId) {
        this.seatID = seatID;
        this.cinema = cinema;
        this.seatRow = seatRow;
        this.seatColumn = seatColumn;
        this.assigned = assigned;
        this.customerId = customerId;
    }

    public Seat(String seatID, Cinema cinema, String seatRow, String seatColumn, Customer customer) {
        this.seatID = seatID;
        this.cinema = cinema;
        this.seatRow = seatRow;
        this.seatColumn = seatColumn;
        this.assigned = false;
        this.customer = customer;
        this.customerId = customer.getUsername();
    }

    public Seat(String seatID, Cinema cinema, String seatRow, String seatColumn) {
        this.seatID = seatID;
        this.cinema = cinema;
        this.seatRow = seatRow;
        this.seatColumn = seatColumn;
        this.assigned = false;
        this.customer = null;
        this.customerId = null;
    }

    public String getSeatID() {
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

    public void assign() {
        this.assigned = true;
    }

    public void unassign() {
        this.assigned = false;
        this.customerId = null;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
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

    public void setCinemaCode(String cinemaCode) {
        this.cinemaCode = cinemaCode;
    }

    public Cinema getCinema() {
        return cinema;
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