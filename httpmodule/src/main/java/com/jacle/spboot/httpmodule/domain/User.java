package com.jacle.spboot.httpmodule.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

@Slf4j
@Data
public class User
{

    private String name;

    private Integer age;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
        user.setName("姓名-" + new Random(200).toString());
        user.setAge(new Random(100).nextInt());
        user.setBirthday(now);
        user.setFirstWorkDate(Calendar.getInstance());

        return user;
    }

    @PostConstruct
    public void prt()
    {
        log.info("create user bean ...");

    }
    //getter and setter...
}