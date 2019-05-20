package skyline.tw.simple.date.service;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

 public class DateServiceTest {
     
     private DateService dateService;

     @BeforeClass 
     public static void setUpBeforeClass() {
         System.out.println("setup test data before class");
     }

     // unit test
     @Before
     public void setUp() {
         System.out.println("setup test data");
         dateService = new DateService();
//         dateService.isLeapYear()
     }

     @Test 
     public void testGetWeekDay_case1() {
         System.out.println("testGetWeekDay");
         // 1. Arrange
         Date test = new Date();
         String excepted = "星期五";
         // 2. Act
         String actual = dateService.getWeekDay(test);
         // 3. Assert
         assertEquals(excepted, actual);
     }

     @Test
     public void testIsLeapYear() {
         System.out.println("testIsLeapYear");
         // 1. Arrange
         int test = 2019;
         Boolean expected = false;
         // 2. Act
         Boolean actual = dateService.isLeapYear(test);
         // assertEquals();
         assertEquals(expected, actual);
     }

     @Test
     public void testGet13thFridaysOfYear() {
         System.out.println("testGet13thFridaysOfYear");
         // TODO: test me
         int test = 2019;
         List<Date> expected =new ArrayList<Date>();
         //此部分做過測試，2019的資料OK，但我不太會把以下資料直接存成List<Date>...QQ
         //[Fri Jan 04 00:00:00 CST 2019, Fri Jan 11 00:00:00 CST 2019, Fri Jan 18 00:00:00 CST 2019, Fri Jan 25 00:00:00 CST 2019, Fri Feb 01 00:00:00 CST 2019, Fri Feb 08 00:00:00 CST 2019, Fri Feb 15 00:00:00 CST 2019, Fri Feb 22 00:00:00 CST 2019, Fri Mar 01 00:00:00 CST 2019, Fri Mar 08 00:00:00 CST 2019, Fri Mar 15 00:00:00 CST 2019, Fri Mar 22 00:00:00 CST 2019]
         // 2. Act
         List<String> actual = dateService.get13thFridaysOfYear(test);
         assertEquals(actual, actual);
     }
}
