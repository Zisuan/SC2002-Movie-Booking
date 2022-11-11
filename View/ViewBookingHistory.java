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
    public static final Scanner sc = new Scanner(System.in);

    public static void viewBookingHistory(Customer customer, TicketManager ticketManager)
            throws SecurityException, ClassNotFoundException, IOException {
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";
        Helper.clearConsole();
        ArrayList<Ticket> ticketDB = new ArrayList<Ticket>();
        ticketDB = ticketManager.loadObjects(dbPath);
        System.out.println(
                ANSI_BLUE + "=====================================================================");
        System.out.println("                        Booking History              ");
        System.out.println("=====================================================================" + ANSI_RESET);

        TicketManager.printAllTicketsByCustomer(ticketDB, customer);
        System.out.println(ANSI_BLUE + "Press enter to return to main menu" + ANSI_RESET);
        sc.nextLine();
        Helper.clearConsole();
        // sc.close();
    }
}
