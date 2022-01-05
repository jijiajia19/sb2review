package com.jacle.spboot.httpmodule.jsonconfig;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.jacle.spboot.httpmodule.domain.Fuser;
import com.jacle.spboot.httpmodule.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;
import java.util.Date;

/**
 * @author Jacle
 * @version 1.0
 * @description: 测试Json的控制器
 * @date 2021/12/30 17:52
 */
@Slf4j
@RestController
public class JsonController
{
    @GetMapping("/jsonuser")
    public ResponseEntity<User> showUser()
    {
        return ResponseEntity.ok(User.buildOne());
    }


    @GetMapping("/fuser")
    public ResponseEntity<Fuser> showFuser(@RequestParam(required = false) String username, @DateTimeFormat(pattern = "yyyy-MM-dd") Date date)
    {
        Fuser fuser = new Fuser();

        fuser.setName(username);
        fuser.setParamDate(date);

        log.info(fuser.toString());
        return ResponseEntity.ok(fuser);
    }

    @GetMapping("/jsonmap")
    public ResponseEntity<Fuser> showFuser2(Fuser fuser) throws JsonProcessingException
    {
        JsonMapDomain bean = new JsonMapDomain("My bean");
        bean.add("attr1", "val1");
        bean.add("attr2", "val2");

        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);

        String result = objectMapper.writeValueAsString(bean);

        log.info(fuser.toString()+"\n"+result);

        //messageformat.format格式化输出
        log.info(MessageFormat.format("{0}开始进行反序列化",fuser));
        String jsonStr=new ObjectMapper().writeValueAsString(fuser);

        log.info(jsonStr);
        Fuser fu=new ObjectMapper().readValue(jsonStr,Fuser.class);
        log.info(fu.getName());
        log.info(fu.getParamDate().toString());

        return ResponseEntity.ok(fuser);
    }
}
