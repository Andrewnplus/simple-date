package skyline.tw.simple.date.service;

import java.text.SimpleDateFormat;
import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

// JodaTime, Guava
public class DateService {

    // scope: private, public, protected, package private
    public static String getWeekDay(Date date) {
        // implement me
        SimpleDateFormat format = new SimpleDateFormat("EEEE");
        return format.format(date);
    }

    //
    public boolean isLeapYear(int year) {
        // implement me
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        return cal.getActualMaximum(Calendar.DAY_OF_YEAR) > 365;
    }

    private static Calendar cacheCalendar;

    public List<String> get13thFridaysOfYear(int year) {
        // implement me
        String targetDate = "/13";
        String thisYear = Integer.toString(year);
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy/MM/dd");
        List<String> fridays = new ArrayList<>();
        for (int i =1; i<=12; i++){
            String stringDate  = Integer.toString(year) + "/" + Integer.toString(i) + targetDate;
            DateTime date =formatter.parseDateTime(stringDate);
            if (date.getDayOfWeek() == DateTimeConstants.FRIDAY){
                fridays.add(stringDate);
            }
        }
        return fridays;
    }

}
