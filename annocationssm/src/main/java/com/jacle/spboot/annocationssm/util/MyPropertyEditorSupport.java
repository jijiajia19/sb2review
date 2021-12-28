package com.jacle.spboot.annocationssm.util;

import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author Jacle
 * @version 1.0
 * @description: PropertyEditor属性编辑器
 * @date 2021/12/28 13:30
 */
public class MyPropertyEditorSupport extends PropertyEditorSupport
{
    /**
     * @see java.beans.PropertyEditorSupport#setAsText(java.lang.String)
     * 前端传入的是unix时间戳,也就是long型,然后后台接收到前端传入的这个参数时会先被转换为String类型,
     * 默认情况下,是不能将String转为Date类型的,所以我们再这里将String字符串变为Date类型!
     */
    //后端接收
    @Override
    public void setAsText(String text) throws IllegalArgumentException
    {
        setValue(new Date(Long.decode(text)));
    }

    /**
     * @see java.beans.PropertyEditorSupport#getAsText()
     * 后台给前端返回响应信息,也要处理Date类型,将Date类型转为String.
     */
    //前端显示
    @Override
    public String getAsText()
    {
        Date value = (Date) getValue();
        return (value != null ? String.valueOf(TimeUnit.MILLISECONDS.toSeconds(value.getTime())) : "");
    }

}
