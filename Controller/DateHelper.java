package Controller;

import java.util.*;
import java.text.*;

public class DateHelper {
    
    public String dateToString (Date date) throws ParseException{
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String stringDate = dateFormat.format(date);
        return stringDate;
    }

    public Date createDate(int year, int month, int day){
        Calendar c=Calendar.getInstance();
        c.set(year, month, day);
        Date createdDate=new Date();
        createdDate=c.getTime();
        return createdDate;
    }
}
