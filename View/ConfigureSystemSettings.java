package View;

import java.util.*;

import Controller.Helpers.DatabaseFilePath;
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
            System.out.println("3. Configure MovieGoer Ranking Display Settings");
            System.out.println("4. Return to Main Menu" + ANSI_RESET);
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
                    displayConfigRankingMenu();
                    break;
                case 4:
                    System.out.println(ANSI_BLUE + "Returning to main menu..." + ANSI_RESET);
                    break;
                default:
                    System.out.println(ANSI_BLUE + "Invalid option");
                    System.out.println("Please re-enter!" + ANSI_RESET);
                    break;
            }
        } while (choice != 4);
    }

    private static void displayConfigRankingMenu() {
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_CYAN = "\u001B[36m";
        ArrayList<String> settings = new ArrayList<String>();
        System.out.println(ANSI_BLUE + "Which ranking type would you like the user to see?" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "1. Top 5 Movies By Sales Only");
        System.out.println("2. Top 5 Movie By Overall Ratings Only");
        System.out.println("3. Both" + ANSI_RESET);
        String option = new Scanner(System.in).nextLine();
        settings.add(option);
        writeSettings(settings);
    }

    // write to csv file with string as input
    private static void writeSettings(ArrayList<String> settings) {
        try {
            FileWriter writer = new FileWriter(DatabaseFilePath.Settings.getFilePath());
            for (String setting : settings) {
                writer.write(setting);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> getSettings() {
        ArrayList<String> settings = new ArrayList<String>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(DatabaseFilePath.Settings.getFilePath()));
            String line = "";
            int i = 0;
            while ((line = br.readLine()) != null) {
                String values[] = line.split(",");
                settings.add(values[i]);
            }
            br.close();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return settings;
    }
}
