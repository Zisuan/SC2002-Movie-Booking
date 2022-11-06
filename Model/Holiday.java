package Model;

import java.util.*;
import java.io.*;


public class Holiday implements Serializable{

    // date of holiday
    private Date holidayDate;
    // name of holiday
    private String holidayName;

    public Holiday(Date holidayDate, String holidayName){
        this.holidayDate=holidayDate;
        this.holidayName=holidayName;
    }

    public Date getHolidayDate(){
        return holidayDate;
    }

    public String getHolidayName(){
        return holidayName;
    }

    public void setHolidayDate(Date holidayDate){
        holidayDate=this.holidayDate;
    }

    public void setHolidayName(String holidayName){
        holidayName=this.holidayName;
    }

}
