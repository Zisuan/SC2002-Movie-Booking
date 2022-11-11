package View;

import java.util.*;

import Controller.PriceControl.PriceManager;

import java.io.*;
import java.text.ParseException;
import View.TicketView.TicketPriceView;

public class ConfigureSystemSettings {

    public static final String FILEPATH = "./database/";

    public static void configureSystemSettings(Scanner sc, PriceManager pm)
            throws SecurityException, ClassNotFoundException, IOException, ParseException {
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_CYAN = "\u001B[36m";
        int choice;
        do {
            System.out.println(
                    ANSI_BLUE + "=====================================================================");
            System.out.println("                 Configure System Settings Menu                   ");
            System.out.println("=====================================================================" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "1. Configure Holidays");
            System.out.println("2. Configure Price Model");
            System.out.println("3. Return to Main Menu" + ANSI_RESET);
            System.out.println(ANSI_BLUE + "=====================================================================");
            System.out.println("                           Enter Option:                             ");
            System.out.println("=====================================================================" + ANSI_RESET);
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    HolidayView.HolidayMenu();
                    break;
                case 2:
                    TicketPriceView.PriceMenu(sc, pm);
                    break;
                case 3:
                    System.out.println(ANSI_BLUE + "Returning to main menu..." + ANSI_RESET);
                    break;
                default:
                    System.out.println(ANSI_BLUE + "Invalid option");
                    System.out.println("Please re-enter!" + ANSI_RESET);
                    break;
            }
        } while (choice != 3);
    }
}
