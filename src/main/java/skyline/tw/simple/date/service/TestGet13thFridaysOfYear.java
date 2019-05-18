package skyline.tw.simple.date.service;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestGet13thFridaysOfYear {
    public static void main(String[] args) {
        // implement me
        String thisYear = "2019";
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
        System.out.println(fridays);
    }
}
