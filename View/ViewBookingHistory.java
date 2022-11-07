package View;

import java.util.*;
import java.io.*;
import java.text.ParseException;

import Controller.*;
import Controller.Helpers.DatabaseFilePath;
import Controller.PriceControl.PriceManager;
import Controller.TicketControl.TicketManager;
import Model.*;

public class ViewBookingHistory {
    private static String dbPath = DatabaseFilePath.Tickets.getFilePath();

    public static void viewBookingHistory(String customerId, TicketManager ticketManager)
            throws SecurityException, ClassNotFoundException, IOException {
        Helper.clearConsole();
        ArrayList<Ticket> ticketDB = new ArrayList<Ticket>();
        ticketDB = ticketManager.loadObjects(dbPath);
        System.out.println("Booking History");
        System.out.println("---------------");
        TicketManager.printAllTicketsByCustomer(ticketDB, customerId);
        System.out.println("Press enter to return to main menu");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        sc.close();
    }
}
