package Model;

import java.io.Serializable;
import java.util.UUID;

public class Booking implements Serializable {

    private MovieSession bookedSession;
    private Customer customer;
    private Ticket ticket;
    private String bookingId;

    public Booking(Customer customer, MovieSession bookedSession, Ticket ticket) {
        this.bookingId = UUID.randomUUID().toString();
        this.customer = customer;
        this.bookedSession = bookedSession;

    }

    public Object getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public MovieSession getBookedSession() {
        return bookedSession;
    }

    public void setBookedSession(MovieSession bookedSession) {
        this.bookedSession = bookedSession;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Object getCustomerName() {
        return customer.getUsername();
    }

    public Object getMovieTitle() {
        return bookedSession.getMovie().getMovieTitle();
    }

    public Object getMovieDate() {
        return bookedSession.getMovieDate();
    }

    public Object getMovieTime() {
        return bookedSession.getMovieTime();
    }

    public Object getCinemaName() {
        return bookedSession.getCinema().getCinemaName();
    }

    public String getSeatID() {
        return ticket.getTicketSeatID();
    }

    public void setSeatID(String seatID) {
        ticket.setTicketSeatID(seatID);
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

}
