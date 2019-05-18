package skyline.tw.simple.date.model;

import java.util.Date;

// domain model
public class User {


    private int age;
    private Date birthday;
    private String firstName;
    private String lastName;
    private String nickName;
    private String width;

    // will huang
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public Date getBirthday(){
        return this.birthday;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Integer getAge(){
        return this.age;
    }
}
