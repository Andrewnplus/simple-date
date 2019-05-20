package skyline.tw.simple.date.service;

import lombok.extern.log4j.Log4j;
import org.junit.Test;
import skyline.tw.simple.date.model.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Log4j
public class MultiThreadTest {

    @Test
    public void test() throws Exception {

        log.info("Main thread starts!!!!!!!");
        DateService dateService = new DateService();
        UserInfoRetrieveService userInfoRetrieveService = new UserInfoRetrieveService(dateService);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        User john = new User(dateFormat.parse("1996/01/01"), "John", "Mayer", "GuitarGod");
        User mary = new User(dateFormat.parse("1994/07/01"), "Mary", "Wang", "GuitarGod");
        User mark = new User(dateFormat.parse("2000/12/01"), "Mark", "Jackson", "GuitarGod");

        Thread t1 = new Thread(new MyRunnable(userInfoRetrieveService, john));
        Thread t2 = new Thread(new MyRunnable(userInfoRetrieveService, mark));
        Thread t3 = new Thread(new MyRunnable(userInfoRetrieveService, mary));

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
        log.info("Main thread is ready to leave!!!!!!!");
    }


    private static class MyRunnable implements Runnable {

        private UserInfoRetrieveService userInfoRetrieveService;
        private User user;

        public MyRunnable(UserInfoRetrieveService dateService, User user){
            this.userInfoRetrieveService = dateService;
            this.user = user;
        }

        @Override
        public void run() {
            // log.info(user);
            // log.info(userInfoRetrieveService.getWeekDayOfBirthday(user));
            // NOTE: race condition happened
            userInfoRetrieveService.updateUserSignature(user);
            String userSignature = userInfoRetrieveService.getUserSignature();
            if (userSignature.equals(user.getName())) {
                log.info(userInfoRetrieveService.getUserSignature() + " signed!!!");
            } else {
                log.error("user " + user.getName() + " should sign but signature is " + userSignature);
            }
        }
    }
}
