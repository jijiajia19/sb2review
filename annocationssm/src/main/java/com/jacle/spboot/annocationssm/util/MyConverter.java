package com.jacle.spboot.annocationssm.util;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;

import java.nio.charset.Charset;

/**
 * @author Jacle
 * @version 1.0
 * @description: 自定义转换器
 * @date 2021/12/23 13:18
 */

//springboot会自动扫描工程下面的configuration
//@Configuration
public class MyConverter
{

    @Bean
    public HttpMessageConverters fastJsonConverter()
    {
        //定义converter对象
        FastJsonHttpMessageConverter f = new FastJsonHttpMessageConverter();

        //2、添加fastjson的配置信息
        FastJsonConfig config = new FastJsonConfig();
        SerializerFeature[] serializerFeatures = new SerializerFeature[]{
                //    输出key是包含双引号
//                SerializerFeature.QuoteFieldNames,
                //    是否输出为null的字段,若为null 则显示该字段
//                SerializerFeature.WriteMapNullValue,
                //    数值字段如果为null，则输出为0
                SerializerFeature.WriteNullNumberAsZero,
                //     List字段如果为null,输出为[],而非null
                SerializerFeature.WriteNullListAsEmpty,
                //    字符类型字段如果为null,输出为"",而非null
                SerializerFeature.WriteNullStringAsEmpty,
                //    Boolean字段如果为null,输出为false,而非null
                SerializerFeature.WriteNullBooleanAsFalse,
                //    Date的日期转换器
                SerializerFeature.WriteDateUseDateFormat,
                //    循环引用
                SerializerFeature.DisableCircularReferenceDetect,
        };

        config.setSerializerFeatures(serializerFeatures);
        config.setCharset(Charset.forName("UTF-8"));

        //3、在convert中添加配置信息
        f.setFastJsonConfig(config);
        f.setDefaultCharset(Charset.forName("UTF-8"));

        //4、将convert添加到converters中
        HttpMessageConverter<?> converter = f;

        return new HttpMessageConverters(converter);
    }

}
