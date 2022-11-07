package Model;

import java.util.*;
import java.io.*;
import java.time.LocalDate;

public class Holiday implements Serializable {

    // date of holiday
    private LocalDate holidayDate;
    // name of holiday
    private String holidayName;

    public Holiday(LocalDate holidayDate, String holidayName) {
        this.holidayDate = holidayDate;
        this.holidayName = holidayName;
    }

    public LocalDate getHolidayDate() {
        return holidayDate;
    }

    public String getHolidayName() {
        return holidayName;
    }

    public void setHolidayDate(LocalDate holidayDate) {
        holidayDate = this.holidayDate;
    }

    public void setHolidayName(String holidayName) {
        holidayName = this.holidayName;
    }

}
