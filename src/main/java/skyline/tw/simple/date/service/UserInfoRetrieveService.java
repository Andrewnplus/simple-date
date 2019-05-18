package skyline.tw.simple.date.service;

import skyline.tw.simple.date.model.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class UserInfoRetrieveService {

    /**
     * display week day of user's birthday for each age
     * 
     * Map will like
     * age 1 => Monday
     * age 2 => Friday
     * ...
     * 
     * @param user
     * @return
     */
    private DateService dateService;
    // String, int, double, Map List Set
    public Map<Integer, String> getWeekDayOfBirthday(User user){
        Map<Integer, String> ans = new HashMap<>();
        Date oneYearBirthday = user.birthday;
        LocalDate localDate = oneYearBirthday.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int startYear  = localDate.getYear();
        int month = localDate.getMonthValue();
        int day   = localDate.getDayOfMonth();

        for ( int i =0; i<=100; i++){
            int year = i + startYear;
            Date date = new GregorianCalendar(year, month, day).getTime();
            DateFormat format2=new SimpleDateFormat("EEEE");
            String finalDay=format2.format(date);
            ans.put(i, finalDay);
        }
        return ans;
    }

}
