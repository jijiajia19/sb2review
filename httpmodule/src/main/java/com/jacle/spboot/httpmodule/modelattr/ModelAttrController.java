package com.jacle.spboot.httpmodule.modelattr;

import com.jacle.spboot.httpmodule.domain.Muser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Jacle
 * @version 1.0
 * @description: ModelAttrController
 * @date 2021/12/30 13:32
 */
@Slf4j
@Controller
public class ModelAttrController
{
    //添加了@ModelAttribute注解的方法，每次请求都会被调用执行

    //Model为模型，表示把数据放在返回的视图页面上
    @ModelAttribute
    public void testModeelAttribute(Model model)
    {
        log.info("run here testModeelAttribute...");
        model.addAttribute("username", "lzj");
    }

    //参数手动封装为对象，类似springboot的initBinder
    //通过自定义modelAttribute可以解决，属性名称一定要一致的问题
    @ModelAttribute("createU")
    //modelAttribute最好是属性名称跟对象名称一致
    //@requestParam默认required为true
    public Muser createMuser(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "age", required = false, defaultValue = "0") int age)
    {
        Muser muser = new Muser();
        muser.setUsername(name);
        muser.setAge(age);

        log.info("run here createMuser...");
        return muser;
    }

    @RequestMapping("/")
    public String hello()
    {
        return "msg";
    }


    @RequestMapping("/user")
    //模型中已经放入属性和值，model.addAttribute("testModeelAttribute", user)；然后通过@ModelAttribute("testModeelAttribute")标注在属性上，表示把模型中的testModeelAttribute键对应的value值赋给了usr。
    public String User(@ModelAttribute("createU") Muser usr, Model model)
    {
        model.addAttribute("user", usr);
        return "msg";
    }

    //当前页面返回给当前页面，类似ajax的效果，页面无同步刷新的效果
    @RequestMapping("/msg")
    @ModelAttribute("name1")
    public String login(@RequestParam(value = "n", required = false) String username)
    {
        System.out.println("--username-- : " + username);
        return username;
    }

}
