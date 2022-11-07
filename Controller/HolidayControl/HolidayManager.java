package Controller.HolidayControl;

import java.util.*;
import java.text.*;
import java.time.LocalDate;

import Model.*;
import Controller.ObjectControl.ObjectManager;

public class HolidayManager extends ObjectManager<Holiday> {

    public void addHoliday(ArrayList<Holiday> holidayDB, LocalDate holidayDate, String holidayName) {

        Holiday holiday = new Holiday(holidayDate, holidayName);
        addObject(holidayDB, holiday);
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

    public boolean isPublicHoliday(ArrayList<Holiday> holidayDB, LocalDate date) {
        boolean isPublicHoliday = false;
        for (Holiday holiday : holidayDB) {
            if (holiday.getHolidayDate().equals(date)) {
                isPublicHoliday = true;
                break;
            }
        }
        return isPublicHoliday;
    }

    public void removeHoliday(ArrayList<Holiday> holidayDB, LocalDate holidayDate) {
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

    public void listHolidays(ArrayList<Holiday> holidayDB) {
        System.out.println("Public Holidays:");
        for (int i = 0; i < holidayDB.size(); i++) {
            System.out.printf("%s   %s\n", holidayDB.get(i).getHolidayName(),
                    holidayDB.get(i).getHolidayDate()).toString();
        }
    }

    @Override
    public boolean objectExists(ArrayList<Holiday> objectDB, Holiday object) {
        for (int i = 0; i < objectDB.size(); i++) {
            if (object.getHolidayDate().equals(objectDB.get(i).getHolidayDate())) {
                return true;
            }
        }
        return false;
    }
}
