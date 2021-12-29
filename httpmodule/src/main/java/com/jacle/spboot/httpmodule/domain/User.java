package com.jacle.spboot.httpmodule.domain;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

@Data
public class User
{

    private String name;

    private Integer age;

    private LocalDateTime birthday;

    private Date studyDate;

    private LocalDate workDate;

    private Calendar firstWorkDate;

    public static User buildOne()
    {
        User user = new User();
        LocalDateTime now = LocalDateTime.now();
        user.setWorkDate(now.plusYears(25).toLocalDate());
        user.setStudyDate(Date.from(now.plusYears(5).atZone(ZoneId.systemDefault()).toInstant()));
//        user.setName("姓名-" + RandomUtil.randomString(5));
//        user.setAge(RandomUtil.randomInt(0, 100));
        user.setBirthday(now);
        user.setFirstWorkDate(Calendar.getInstance());
        return user;
    }

    //getter and setter...
}