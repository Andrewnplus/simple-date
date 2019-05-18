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
        Date oneYearBirthday = User.getBirthday();
        LocalDate localDate = oneYearBirthday.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int startYear  = localDate.getYear();
        int month = localDate.getMonthValue();
        int day   = localDate.getDayOfMonth();
        int hisAge   = User.getAge();
        int yearNow = Calendar.getInstance().get(Calendar.YEAR);


        for ( int i =0; i<=hisAge; i++){
            int year = yearNow - (hisAge - i);
            Date date = new GregorianCalendar(year, month, day).getTime();
            String finalDay=DateService.getWeekDay(date);
            ans.put(i, finalDay);
        }
        return ans;
    }

}
