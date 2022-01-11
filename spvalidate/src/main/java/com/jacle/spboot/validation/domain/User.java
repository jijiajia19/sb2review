package com.jacle.spboot.validation.domain;

import lombok.Data;

import javax.validation.GroupSequence;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class User
{
    public interface Default{}

    public interface Init{}

    //组校验，另外的作用就是组织校验顺序
    @GroupSequence(value={Init.class,Default.class})
    public interface Second{}

    @NotBlank(message = "姓名不为空")
    private String username;
    @NotBlank(message = "密码不为空")
    private String password;
    // 嵌套必须加 @Valid，否则嵌套中的验证不生效
    @Valid
    @NotNull(message = "userinfo不能为空")
    private UserInfo userInfo;
}