package Controller;

import java.util.ArrayList;

import Controller.ObjectControl.ObjectManager;
import Model.Booking;
import Model.Customer;
import Model.MovieSession;
import Model.Ticket;

public class BookingManager extends ObjectManager<Booking> {

    public void addBooking(ArrayList<Booking> bookingDB, Customer customer, MovieSession bookedSession, Ticket ticket) {
        int ticketSales = bookedSession.getMovie().getTicketSales();
        bookedSession.getMovie().setTicketSales(ticketSales + 1);
        Booking booking = new Booking(customer, bookedSession, ticket);
        addObject(bookingDB, booking);
    }

    public void updateBooking(ArrayList<Booking> bookingDB, Customer customer, MovieSession bookedSession,
            Ticket ticket) {
        for (Booking booking : bookingDB) {
            if (booking.getCustomer().equals(customer) && booking.getBookedSession().equals(bookedSession)) {
                booking.setTicket(ticket);
            }
        }
    }

    public void removeBooking(ArrayList<Booking> bookingDB, String customerName, String movieTitle, String movieDate,
            String movieTime) {
        int i = 0;
        boolean exists = false;
        for (i = 0; i < bookingDB.size(); i++) {
            if (bookingDB.get(i).getCustomerName().equals(customerName)
                    && bookingDB.get(i).getMovieTitle().equals(movieTitle)
                    && bookingDB.get(i).getMovieDate().equals(movieDate)
                    && bookingDB.get(i).getMovieTime().equals(movieTime)) {
                exists = true;
                break;
            }
        }
        if (exists) {
            bookingDB.remove(i);
            System.out.println("Booking successfully removed!");
        } else
            System.out.println("Booking does not exist!");
    }

    public Booking searchBooking(ArrayList<Booking> bookingDB, String bookingID) {
        for (Booking booking : bookingDB) {
            if (booking.getBookingId().equals(bookingID)) {
                return booking;
            }
        }
        return null;
    }

    @Override
    public boolean objectExists(ArrayList<Booking> objectDB, Booking object) {
        for (Booking booking : objectDB) {
            if (booking.getCustomer().equals(object.getCustomer())
                    && booking.getBookedSession().equals(object.getBookedSession())
                    && booking.getTicket().equals(object.getTicket())) {
                return true;
            }
        }
        return false;
    }

}