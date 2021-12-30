package com.jacle.spboot.httpmodule.jsonconfig;

import com.jacle.spboot.httpmodule.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jacle
 * @version 1.0
 * @description: 测试Json的控制器
 * @date 2021/12/30 17:52
 */
@RestController
public class JsonController
{
    @GetMapping("/jsonuser")
    public ResponseEntity<User> showUser()
    {
        return ResponseEntity.ok(User.buildOne());
    }
}
