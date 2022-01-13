package com.jacle.spboot.validation.crontab;

import org.apache.ibatis.annotations.Select;

public interface CronMapper
{
    @Select("select cron_expression from spring_scheduled_cron limit 1")
    public String getCron();
}
