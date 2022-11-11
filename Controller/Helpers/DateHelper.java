package Controller.Helpers;

import java.util.*;
import java.text.*;
import java.time.*;
import java.time.temporal.ChronoField;

public class DateHelper {

    public String dateToString(Date date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String stringDate = dateFormat.format(date);
        return stringDate;
    }

    public LocalDate stringToDate(String stringDate) {
        LocalDate date = LocalDate.parse(stringDate);
        return date;
    }

    public Date createDate(int year, int month, int day) {
        Calendar c = new GregorianCalendar(year, month - 1, day, 0, 0, 0);
        // c.set(year, month, day);
        // System.out.println(c.get(Calendar.YEAR) + c.get(Calendar.MONTH) +
        // c.get(Calendar.DAY_OF_MONTH));
        Date createdDate = c.getTime();
        return createdDate;
    }

    public static boolean isWeekend(final LocalDate ld) {
        DayOfWeek day = DayOfWeek.of(ld.get(ChronoField.DAY_OF_WEEK));
        return day == DayOfWeek.SUNDAY || day == DayOfWeek.SATURDAY;
    }

    public static String getAlphaNumericString(int n) {

        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index = (int) (AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
}
