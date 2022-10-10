import java.util.*;

public class MovieSeat {
    private int seatNumber;
    private boolean assigned;
    private int customerId;

    public MovieSeat(int seatNumber) {
        this.seatNumber = seatNumber;
        this.assigned = false;
        this.customerId = 0;
    }

    public int getSeatNumber() {
        return seatNumber;
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

}