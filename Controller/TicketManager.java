package Controller;

import java.util.ArrayList;

import Model.*;

public class TicketManager {

    public static void addNewTicket(ArrayList<Ticket> ticketDB, String ticketId, double ticketPrice, String ticketType,
            String ticketStatus, String ticketSeat, Showtime ticketShowtime, String customerId) {
        Ticket ticket = new Ticket(ticketId, ticketPrice, ticketType, ticketStatus, ticketSeat, ticketShowtime,
                customerId);
        ticketDB.add(ticket);
    }

    public static void removeTicket(ArrayList<Ticket> ticketDB, String ticketId) {
        for (int i = 0; i < ticketDB.size(); i++) {
            if (ticketDB.get(i).getTicketId().equals(ticketId)) {
                ticketDB.remove(i);
            }
        }
    }

    public static void updateTicket(ArrayList<Ticket> ticketDB, String ticketId, double ticketPrice, String ticketType,
            String ticketStatus, String ticketSeat, Showtime ticketShowtime, Customer ticketCustomer) {
        for (int i = 0; i < ticketDB.size(); i++) {
            if (ticketDB.get(i).getTicketId().equals(ticketId)) {
                ticketDB.get(i).setTicketPrice(ticketPrice);
                ticketDB.get(i).setTicketType(ticketType);
                ticketDB.get(i).setTicketStatus(ticketStatus);
                ticketDB.get(i).setTicketSeat(ticketSeat);
                ticketDB.get(i).setTicketShowtime(ticketShowtime);
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
        for (int i = 0; i < ticketDB.size(); i++) {
            if (ticketDB.get(i).getCustomerId().equals(customerId)) {
                System.out.println(ticketDB.get(i).toString());
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

}
