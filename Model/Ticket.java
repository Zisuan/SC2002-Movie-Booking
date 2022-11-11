package Model;

import java.io.Serializable;
import java.util.UUID;

public class Ticket implements Serializable {

    public enum TicketType {
        STUDENT {
            @Override
            public String toString() {
                return "Student";
            }
        },
        SENIOR {
            @Override
            public String toString() {
                return "Senior";
            }
        },
        NORMAL {
            @Override
            public String toString() {
                return "Normal";
            }
        }
    }

    // create ticket id
    private String ticketId;
    // create ticket price
    private double ticketPrice;
    // create ticket type
    private TicketType ticketType;
    // create ticket status
    private String ticketStatus;
    // create ticket seat
    private String ticketSeatID;
    // create ticket showtime
    private MovieSession movieSession;
    // create ticket customer
    private Customer ticketCustomer;
    private String customerId;

    // create ticket constructor
    public Ticket(String ticketID, double ticketPrice, String ticketType, String ticketStatus, String ticketSeatID,
            MovieSession ticketShowtime, Customer ticketCustomer) {
        this.ticketId = ticketID;
        this.ticketPrice = ticketPrice;
        this.ticketStatus = ticketStatus;
        this.ticketSeatID = ticketSeatID;
        this.movieSession = ticketShowtime;
        this.ticketCustomer = ticketCustomer;
        this.customerId = ticketCustomer.getUsername();
        setTicketType(ticketType);

    }

    // create ticket constructor
    public Ticket(double ticketPrice, String ticketType, String ticketStatus, String ticketSeatID,
            MovieSession ticketShowtime, Customer ticketCustomer) {
        this.ticketId = null;
        this.ticketPrice = ticketPrice;
        this.ticketStatus = ticketStatus;
        this.ticketSeatID = ticketSeatID;
        this.movieSession = ticketShowtime;
        this.ticketCustomer = ticketCustomer;
        this.customerId = ticketCustomer.getUsername();
        setTicketType(ticketType);

    }

    // create ticket id getter
    public String getTicketId() {
        return ticketId;
    }

    // create ticket price getter
    public double getTicketPrice() {
        return ticketPrice;
    }

    // create ticket type getter
    public TicketType getTicketType() {
        return ticketType;
    }

    // create ticket status getter
    public String getTicketStatus() {
        return ticketStatus;
    }

    // create ticket seat getter
    public String getTicketSeatID() {
        return ticketSeatID;
    }

    // create ticket showtime getter
    public MovieSession getMovieSession() {
        return movieSession;
    }

    // create ticket customer getter
    public Customer getTicketCustomer() {
        return ticketCustomer;
    }

    // create ticket id setter
    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    // create ticket price setter
    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    // create ticket type setter
    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public void setTicketType(String ticketType) {
        switch (Integer.parseInt(ticketType)) {
            case 1:
                this.ticketType = TicketType.STUDENT;
                break;
            case 2:
                this.ticketType = TicketType.SENIOR;
                break;
            case 3:
                this.ticketType = TicketType.NORMAL;
                break;
        }
    }

    // create ticket status setter
    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    // create ticket seat setter
    public void setTicketSeatID(String ticketSeatID) {
        this.ticketSeatID = ticketSeatID;
    }

    // create ticket showtime setter
    public void setMovieSession(MovieSession movieSession) {
        this.movieSession = movieSession;
    }

    // create ticket customer setter
    public void setTicketCustomer(Customer ticketCustomer) {
        this.ticketCustomer = ticketCustomer;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    // create cinema toString
    @Override
    public String toString() {
        return "Ticket Id: " + getTicketId() + "\n" +
                "Movie Title: " + getMovieSession().getMovie().getMovieTitle() + "\n" +
                "Cinema: " + getMovieSession().getCinema().getCinemaName() + "\n" +
                "Movie Showtime: " + getMovieSession().getMovieDate() + " @ " + getMovieSession().getMovieTime()
                + "\n" +
                "Ticket Price: " + getTicketPrice() + "\n" +
                "Ticket Type: " + getTicketType().toString() + "\n" +
                "Ticket Status: " + getTicketStatus() + "\n" +
                "Ticket Seat: " + getTicketSeatID() + "\n" +
                "Customer Id: " + getCustomerId();
    }

}
