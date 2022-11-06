package Controller.Helpers;

import java.util.*;
import java.text.*;

public class DateHelper {

    public String dateToString(Date date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String stringDate = dateFormat.format(date);
        return stringDate;
    }

    public Date createDate(int year, int month, int day) {
        Calendar c = new GregorianCalendar(year, month - 1, day, 0, 0, 0);
        // c.set(year, month, day);
        // System.out.println(c.get(Calendar.YEAR) + c.get(Calendar.MONTH) +
        // c.get(Calendar.DAY_OF_MONTH));
        Date createdDate = c.getTime();
        return createdDate;
    }
}
