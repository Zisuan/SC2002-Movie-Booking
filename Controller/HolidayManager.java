package Controller;

import java.util.*;
import java.text.*;

import Model.*;
import Controller.ObjectControl.ObjectManager;

public class HolidayManager extends ObjectManager<Holiday> {

    public void addHoliday(ArrayList<Holiday> holidayDB, Date holidayDate, String holidayName) {

        Holiday holiday = new Holiday(holidayDate, holidayName);
        boolean exists = false;
        for (int i = 0; i < holidayDB.size(); i++) {
            if (holiday.getHolidayDate().equals(holidayDB.get(i).getHolidayDate())) {
                System.out.println("Holiday already exists!");
                exists = true;
                break;
            }
        }
        if (!exists) {
            holidayDB.add(holiday);
            System.out.println("Holiday successfully added!");
        }
    }

    // public void updateHoliday(int updateCase, ArrayList<Holiday> holidayDB, Date
    // oldHolidayDate, Date newHolidayDate, String newHolidayName){

    // int i=0;
    // boolean exists=false;
    // for (i=0; i<holidayDB.size(); i++) {
    // if(holidayDB.get(i).getHolidayDate().equals(oldHolidayDate)){
    // exists=true;
    // break;
    // }
    // }
    // if(exists){
    // switch(updateCase) { //1 = date , 2 = name
    // case 1:
    // holidayDB.get(i).setHolidayDate(newHolidayDate);
    // case 2:
    // holidayDB.get(i).setHolidayName(newHolidayName);
    // }
    // System.out.println("Holiday succesfully updated!");
    // }
    // else
    // System.out.println("Holiday does not exist!");
    // }

    public void removeHoliday(ArrayList<Holiday> holidayDB, Date holidayDate) {
        int i = 0;
        boolean exists = false;
        for (i = 0; i < holidayDB.size(); i++) {
            if (holidayDB.get(i).getHolidayDate().equals(holidayDate)) {
                exists = true;
                break;
            }
        }
        if (exists) {
            holidayDB.remove(i);
            System.out.println("Holiday succesfully removed!");
        } else
            System.out.println("Holiday does not exist!");
    }

    public void listHolidays(ArrayList<Holiday> holidayDB) throws ParseException {
        DateHelper dh = new DateHelper();
        System.out.println("Public Holidays:");
        for (int i = 0; i < holidayDB.size(); i++) {
            System.out.printf("%s   %s\n", holidayDB.get(i).getHolidayName(),
                    dh.dateToString(holidayDB.get(i).getHolidayDate()));
        }
    }

}
