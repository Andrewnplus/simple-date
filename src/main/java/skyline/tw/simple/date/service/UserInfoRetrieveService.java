package skyline.tw.simple.date.service;

import org.joda.time.DateTime;
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

    public UserInfoRetrieveService(DateService dateService) {

        this.dateService = dateService;
    }

    // String, int, double, Map List Set
    public Map<Integer, String> getWeekDayOfBirthday(User user) {
        Map<Integer, String> results = new HashMap<>();
        DateTime oneYearBirthday = new DateTime(user.birthday);
        int startYear = oneYearBirthday.getYear();
        for (int i = 0; i <= user.getAge(); i++) {
            int year = i + startYear;
            results.put(i, dateService.getWeekDay(new DateTime(oneYearBirthday).withYear(year).toDate()));
        }
        return results;
    }

}
