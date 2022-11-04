package View;

import java.util.*;
import java.io.*;
import java.text.ParseException;

import Controller.*;
import Model.*;

public class HolidayView {

    public static final String FILEPATH = "./src/database/";

    public static void HolidayMenu() throws SecurityException, ClassNotFoundException, IOException, ParseException {
        Scanner sc = new Scanner(System.in);
        String dbPath = "";
        String holidayName = "";
        dbPath = FILEPATH + "Holidays.dat";
        ArrayList<Holiday> holidayDB = new ArrayList<Holiday>();
        HolidayManager hm = new HolidayManager();
        DateHelper dh=new DateHelper();
        holidayDB = hm.loadHolidays(dbPath);
        int sel2, year, month, day;
        do {
            System.out.println("====PUBLIC HOLIDAYS====");
            System.out.println("1. List Public Holidays");
            System.out.println("2. Add Public Holiday");
            System.out.println("3. Delete Public Holiday");
            System.out.println("4. Exit");
            sel2 = sc.nextInt();
            sc.nextLine();
            switch (sel2) {
                case 1:
                    hm.listHolidays(holidayDB);
                    break;
                case 2:
                    System.out.println("Enter New Public Holiday Name:");
                    holidayName = sc.nextLine();
                    System.out.println("Enter Year:");
                    year=sc.nextInt();
                    System.out.println("Enter Month:");
                    month=sc.nextInt();
                    System.out.println("Enter Day of month:");
                    day=sc.nextInt();
                    Date newDate=dh.createDate(year, month, day);
                    hm.addHoliday(holidayDB, newDate, holidayName);
                    hm.saveHolidays(dbPath, holidayDB);
                    break;
                case 3:
                    System.out.println("Remove a Public Holiday");
                    System.out.println("Enter Year:");
                    year=sc.nextInt();
                    System.out.println("Enter Month:");
                    month=sc.nextInt();
                    System.out.println("Enter Day of month:");
                    day=sc.nextInt();
                    Date removeDate=dh.createDate(year, month, day);
                    hm.removeHoliday(holidayDB, removeDate);
                    hm.saveHolidays(dbPath, holidayDB);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option");
                    System.out.println("Please re-enter!");
                    break;
            }
        }while(sel2!=4);
    }
}