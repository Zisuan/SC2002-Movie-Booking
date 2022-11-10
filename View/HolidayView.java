package View;

import java.util.*;
import java.io.*;
import java.text.ParseException;
import java.time.LocalDate;

import Controller.*;
import Controller.Helpers.DateHelper;
import Controller.HolidayControl.HolidayManager;
import Model.*;

public class HolidayView {
    // TODO: Cannot add holiday.
    // TODO: Can remove holiday but sus method to do so. Produces error as well.
    public static final String FILEPATH = "./database/";

    public static void HolidayMenu() throws SecurityException, ClassNotFoundException, IOException, ParseException {
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_CYAN = "\u001B[36m";
        Scanner sc = new Scanner(System.in);
        String dbPath = "";
        String holidayName = "";
        dbPath = FILEPATH + "Holidays.dat";
        ArrayList<Holiday> holidayDB = new ArrayList<Holiday>();
        HolidayManager hm = new HolidayManager();
        DateHelper dh = new DateHelper();
        holidayDB = hm.loadObjects(dbPath);
        int sel2, year, month, day;
        do {
            System.out.println(
                    ANSI_BLUE + "=====================================================================");
            System.out.println("                 Configure Public Holidays Menu                   ");
            System.out.println("=====================================================================" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "1. List Public Holidays");
            System.out.println("2. Add Public Holiday");
            System.out.println("3. Delete Public Holiday");
            System.out.println("4. Exit" + ANSI_RESET);
            System.out.println(ANSI_BLUE + "=====================================================================");
            System.out.println("                           Enter Option:                             ");
            System.out.println("=====================================================================" + ANSI_RESET);
            sel2 = sc.nextInt();
            sc.nextLine();
            switch (sel2) {
                case 1:
                    hm.listHolidays(holidayDB);
                    break;
                case 2:
                    System.out.println(ANSI_BLUE + "Enter New Public Holiday Name:" + ANSI_RESET);
                    holidayName = sc.nextLine();
                    System.out.println(ANSI_BLUE + "Enter Year:" + ANSI_RESET);
                    year = sc.nextInt();
                    System.out.println(ANSI_BLUE + "Enter Month:" + ANSI_RESET);
                    month = sc.nextInt();
                    System.out.println(ANSI_BLUE + "Enter Day of month:" + ANSI_RESET);
                    day = sc.nextInt();
                    LocalDate holidayDate = LocalDate.parse(year + "-" + month + "-" + day);
                    hm.addHoliday(holidayDB, holidayDate, holidayName);
                    hm.saveObjects(holidayName, holidayDB);
                    break;
                case 3:
                    System.out.println("Remove a Public Holiday");
                    System.out.println("Enter Year:");
                    year = sc.nextInt();
                    System.out.println("Enter Month:");
                    month = sc.nextInt();
                    System.out.println("Enter Day of month:");
                    day = sc.nextInt();
                    LocalDate removeDate = LocalDate.parse(year + "-" + month + "-" + day);
                    hm.removeHoliday(holidayDB, removeDate);
                    hm.saveObjects(holidayName, holidayDB);
                    break;
                case 4:
                    System.out.println(ANSI_BLUE + "Exiting..." + ANSI_RESET);
                    break;
                default:
                    System.out.println(ANSI_BLUE + "Invalid option");
                    System.out.println("Please re-enter!" + ANSI_RESET);
                    break;
            }
        } while (sel2 != 4);
    }
}