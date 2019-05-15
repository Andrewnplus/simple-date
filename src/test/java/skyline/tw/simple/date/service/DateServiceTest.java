package skyline.tw.simple.date.service;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
         // TODO: test me
         // dateService.getWeekDay()
         // assertEquals();
     }

     @Test
     public void testIsLeapYear() {
         System.out.println("testIsLeapYear");
         // TODO: test me
         // dateService.isLeapYear()
         // assertEquals();
     }

     @Test
     public void testGet13thFridaysOfYear() {
         System.out.println("testGet13thFridaysOfYear");
         // TODO: test me
         // dateService.get13thFridaysOfYear()
         // assertEquals();
     }
}
