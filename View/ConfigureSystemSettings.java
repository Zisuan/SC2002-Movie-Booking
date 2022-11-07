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

        int choice;
        do {
            System.out.println("====Configure System Settings====");
            System.out.println("1. Configure Holidays");
            System.out.println("2. Configure Price Model");
            System.out.println("3. Return to Main Menu");
            System.out.println("Option: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    HolidayView.HolidayMenu();
                    break;
                case 2:
                    TicketPriceView.PriceMenu(sc, pm);
                    break;
                case 3:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid option");
                    System.out.println("Please re-enter!");
                    break;
            }
        } while (choice != 3);
    }
}
