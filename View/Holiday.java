package View;

import java.util.*;
import java.io.*;
import Controller.*;
import Model.*;

public class Holiday {

    public static final String FILEPATH = "./database/";

    public static void HolidayMenu() throws SecurityException, ClassNotFoundException, IOException {
        Scanner sc = new Scanner(System.in);
        String dbPath = "";
        String holiday = "";
        dbPath = FILEPATH + "PublicHolidays.csv";
        ArrayList<String> holidayDB = new ArrayList<String>();
        PriceManager pm = new PriceManager();
        pm.loadHolidays(dbPath, holidayDB);
        int sel2;
        System.out.println("PUBLIC HOLIDAYS");
        System.out.println("1. List Public Holidays");
        System.out.println("2. Add Public Holiday");
        System.out.println("3. Delete Public Holiday");
        System.out.println("4. Exit");
        sel2 = sc.nextInt();
        sc.nextLine();
        switch (sel2) {
            case 1:
                pm.listHolidays(holidayDB);
                break;
            case 2:
                System.out.println("Enter New Public Holiday YYYY/MM/DD:");
                holiday = sc.nextLine();
                pm.addHoliday(holidayDB, holiday);
                pm.saveHolidays(dbPath, holidayDB);
                break;
            case 3:
                System.out.println("Enter Public Holiday To Remove YYYY/MM/DD:");
                holiday = sc.nextLine();
                pm.removeHoliday(holidayDB, holiday);
                pm.saveHolidays(dbPath, holidayDB);
                break;
            case 4:
                System.out.println("Exiting...");
                break;
        }
    }
}