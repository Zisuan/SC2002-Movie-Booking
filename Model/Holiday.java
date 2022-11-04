package Model;

import java.util.*;

public class Holiday {

    // date of holiday
    private Date holidayDate;
    // name of holiday
    private String holidayName;

    public Holiday(Date holidayDate, String holidayName){
        holidayDate=this.holidayDate;
        holidayName=this.holidayName;
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
