package com.jacle.spboot.annocationssm.controller;

import com.jacle.spboot.annocationssm.domain.TUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class NegotiationController
{

    @ResponseBody
    @GetMapping(value = "/show")
    public TUser showUser()
    {
        TUser tuser = new TUser();

        tuser.setAge(23);
        tuser.setName("jacle");

        return tuser;
    }

    //rest接口方式
    @ResponseBody
    @GetMapping(value = "/show/{id}")
    public TUser showUserName(@PathVariable(value = "id", required = false) String id)
    {
        log.warn("id={}", id);
        TUser tuser = new TUser();

        tuser.setAge(23);
        tuser.setName("jacle");
        return tuser;
    }


}