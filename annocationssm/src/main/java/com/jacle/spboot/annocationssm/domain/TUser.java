package com.jacle.spboot.annocationssm.domain;

import lombok.Data;
import org.springframework.stereotype.Controller;

/**
 * @author Jacle
 * @version 1.0
 * @description: 测试内容协商机制
 * @date 2021/12/24 15:41
 */

@Data
@Controller
public class TUser
{
    private String name;
    private int age;
}
