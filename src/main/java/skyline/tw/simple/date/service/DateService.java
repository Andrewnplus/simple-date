package skyline.tw.simple.date.service;

import java.text.Format;
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
    public String getWeekDay(Date date) {
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

    public List<Date> get13thFridaysOfYear(int year) {
        // implement me
        String thisYear = Integer.toString(year);
        String start = "01/01/" + thisYear;
        String end = "01/06/" + thisYear;
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
        DateTime startDate =formatter.parseDateTime(start);
        DateTime endDate = formatter.parseDateTime(end);
        List<Date> fridays = new ArrayList<>();
        boolean reachedAFriday = false;
        int fulfillMoment = 0;
        while (startDate.isBefore(endDate) && fulfillMoment <= 11){
            if ( startDate.getDayOfWeek() == DateTimeConstants.FRIDAY ){
                fridays.add(startDate.toDate());
                reachedAFriday = true;
                fulfillMoment += 1;
            }
            if ( reachedAFriday ){
                startDate = startDate.plusWeeks(1);
            } else {
                startDate = startDate.plusDays(1);
            }
        }
        return fridays;
    }


    // overloading ? override?
    
}
