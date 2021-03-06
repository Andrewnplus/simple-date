package skyline.tw.simple.date.service;

import org.joda.time.DateTime;
import skyline.tw.simple.date.model.User;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class UserInfoRetrieveService {

    private String userSignature;
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

    public UserInfoRetrieveService(DateService dateService) {

        this.dateService = dateService;
    }

    // String, int, double, Map List Set
    public Map<Integer, String> getWeekDayOfBirthday(User user){
        Map<Integer, String> ans = new HashMap<>();
        Date oneYearBirthday = user.getBirthday();
        LocalDate localDate = oneYearBirthday.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int startYear  = localDate.getYear();
        int month = localDate.getMonthValue();
        int day   = localDate.getDayOfMonth();
        int hisAge   = user.getAge();
        int yearNow = Calendar.getInstance().get(Calendar.YEAR);


        for ( int i =0; i<=hisAge; i++){
            int year = yearNow - (hisAge - i);
            Date date = new GregorianCalendar(year, month, day).getTime();
            String finalDay=DateService.getWeekDay(date);
            ans.put(i, finalDay);
        }
        return ans;
    }

    // String, int, double, Map List Set
    public Map<Integer, String> getWeekDayOfBirthday2(User user) {
        Map<Integer, String> results = new HashMap<>();
        DateTime oneYearBirthday = new DateTime(user.birthday);
        int startYear = oneYearBirthday.getYear();
        for (int i = 0; i <= user.getAge(); i++) {
            int year = i + startYear;
            results.put(i, dateService.getWeekDay(new DateTime(oneYearBirthday).withYear(year).toDate()));
        }
        return results;
    }

    public void updateUserSignature(User user) {
        userSignature = user.getName();
    }

    public String getUserSignature() {
        return this.userSignature;
    }

}
