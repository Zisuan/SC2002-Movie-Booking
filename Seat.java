import java.util.*;

public class Seat {
    private String seatID;
    private boolean assigned;
    private String customerId;

    public Seat(String seatID) {
        this.seatID = seatID;
        this.assigned = false;
        this.customerId = "0";
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

    public void unassign() {
        this.assigned = false;
        this.customerId = "0";
    }

}