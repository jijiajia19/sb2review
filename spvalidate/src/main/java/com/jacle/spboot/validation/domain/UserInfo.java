package com.jacle.spboot.validation.domain;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

@Data
public class UserInfo
{
    //分组校验，通过分组校验，对于同一份dto，配置不同的校验策略，缺点，每个校验策略，都需要书写一份
    @NotBlank(message = "年龄不为空",groups = User.Default.class)
    @Max(value = 18, message = "不能超过18岁", groups = User.Default.class)
    @Max(value = 28, message = "不能超过18岁", groups = User.Init.class)
    private String age;
    @NotBlank(message = "性别不能为空")
    private String gender;
}