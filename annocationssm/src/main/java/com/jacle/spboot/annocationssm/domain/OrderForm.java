package com.jacle.spboot.annocationssm.domain;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @author Jacle
 * @version 1.0
 * @description: 全局请求参数类型转换器使用，实体类
 * @date 2021/12/28 13:20
 */

@Data
@ToString
public class OrderForm
{
    @NotBlank(message = "不能为空")
    private String id;

    private String userName;

    private Date addTime;
}
