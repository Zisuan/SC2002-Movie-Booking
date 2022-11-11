package Controller.TicketControl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import Controller.ObjectControl.ObjectManager;
import Model.*;

public class TicketManager extends ObjectManager<Ticket> {

    // public void addNewTicket(ArrayList<Ticket> ticketDB, String ticketID, double
    // ticketPrice, String ticketType,
    // String ticketStatus, String ticketSeat, MovieSession ticketShowtime, Customer
    // customer) {
    // Ticket ticket = new Ticket(ticketPrice, ticketType, ticketStatus, ticketSeat,
    // ticketShowtime,
    // customer);
    // if (!objectExists(ticketDB, ticket)) {
    // ticketDB.add(ticket);
    // }
    // }

    public void addNewTicket(ArrayList<Ticket> ticketDB, Ticket newTicket) {
        Cinema ticketCinema = newTicket.getMovieSession().getCinema();
        newTicket.setTicketId(generateTicketID(ticketCinema));
        if (!objectExists(ticketDB, newTicket)) {
            ticketDB.add(newTicket);
        }
    }

    public void removeTicket(ArrayList<Ticket> ticketDB, String ticketId) {
        for (int i = 0; i < ticketDB.size(); i++) {
            if (ticketDB.get(i).getTicketId().equals(ticketId)) {
                ticketDB.remove(i);
            }
        }
    }

    public static void updateTicket(ArrayList<Ticket> ticketDB, String ticketId, double ticketPrice, String ticketType,
            String ticketStatus, String ticketSeat, MovieSession ticketShowtime, Customer ticketCustomer) {
        for (int i = 0; i < ticketDB.size(); i++) {
            if (ticketDB.get(i).getTicketId().equals(ticketId)) {
                ticketDB.get(i).setTicketPrice(ticketPrice);
                ticketDB.get(i).setTicketType(ticketType);
                ticketDB.get(i).setTicketStatus(ticketStatus);
                ticketDB.get(i).setTicketSeatID(ticketSeat);
                ticketDB.get(i).setMovieSession(ticketShowtime);
                ticketDB.get(i).setTicketCustomer(ticketCustomer);
            }
        }
    }

    public static void printTicket(ArrayList<Ticket> ticketDB, String ticketId) {
        for (int i = 0; i < ticketDB.size(); i++) {
            if (ticketDB.get(i).getTicketId().equals(ticketId)) {
                System.out.println(ticketDB.get(i).toString());
            }
        }
    }

    public static void printAllTickets(ArrayList<Ticket> ticketDB) {
        for (int i = 0; i < ticketDB.size(); i++) {
            System.out.println(ticketDB.get(i).toString());
        }
    }

    public static void printAllTicketsByCustomer(ArrayList<Ticket> ticketDB, String customerId) {
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_CYAN = "\u001B[36m";
        for (int i = 0; i < ticketDB.size(); i++) {
            if (ticketDB.size() == 0) {
                System.out.println(ANSI_BLUE + "No tickets found" + ANSI_RESET);
                break;
            } else if (ticketDB.get(i).getCustomerId().equals(customerId)) {
                System.out.println(ANSI_BLUE + "-------------Ticket " + (i + 1) + "-------------" + ANSI_RESET);
                System.out.println(ANSI_CYAN + ticketDB.get(i).toString() + ANSI_RESET);
                System.out.println(ANSI_BLUE + "----------------------------------" + ANSI_RESET);
            }
        }
    }

    public ArrayList<Ticket> getTicketsByCustomer(ArrayList<Ticket> ticketDB, String customerId) {
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        for (int i = 0; i < ticketDB.size(); i++) {
            if (ticketDB.get(i).getCustomerId().equals(customerId)) {
                tickets.add(ticketDB.get(i));
            }
        }
        return tickets;
    }

    public ArrayList<Ticket> getTicketsByMovie(ArrayList<Ticket> ticketDB, String movieTitle) {
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        for (int i = 0; i < ticketDB.size(); i++) {
            if (ticketDB.get(i).getMovieSession().getMovie().getMovieTitle().equalsIgnoreCase(movieTitle)) {
                tickets.add(ticketDB.get(i));
            }
        }
        return tickets;
    }

    public int getNumberOfTicketSales(ArrayList<Ticket> ticketDB, String movieTitle) {
        int numberOfTicketSales = getTicketsByMovie(ticketDB, movieTitle).size();
        return numberOfTicketSales;
    }

    public String generateTicketID(Cinema cinema) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYYMMddHHmm");
        String dateTime = LocalDateTime.now().format(formatter).toString();
        String cinemaCode = cinema.getCinemaCode();
        String ticketID = cinemaCode + dateTime;
        return ticketID;
    }

    @Override
    public boolean objectExists(ArrayList<Ticket> objectDB, Ticket object) {
        for (int i = 0; i < objectDB.size(); i++) {
            if (objectDB.get(i).getTicketId().equals(object.getTicketId())) {
                return true;
            }
        }
        return false;
    }

}
