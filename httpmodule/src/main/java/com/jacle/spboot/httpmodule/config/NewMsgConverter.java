package com.jacle.spboot.httpmodule.config;

import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jacle
 * @version 1.0
 * @description: 新转换器
 * @date 2022/1/5 15:50
 */
@Slf4j
@Configuration
public class NewMsgConverter implements WebMvcConfigurer
{
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters)
    {
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        /*fastJsonConfig.setSerializeFilters(new ValueFilter()
        {
            @Override
            public Object process(Object object, String name, Object value)
            {
                if (value == null)
                {
                    return "-fastjson prefix-";
                }
                if (value instanceof Date)
                {
                    return DateFormatUtils.format((Date) value, "yyyy-MM-dd hh:mm:ss");
                }
                return value;
            }
        });*/

        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.QuoteFieldNames,
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteEnumUsingToString,
//                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat
        );

        SerializeConfig serializeConfig = SerializeConfig.globalInstance;
        serializeConfig.put(BigInteger.class, ToStringSerializer.instance);
        serializeConfig.put(Long.class, ToStringSerializer.instance);
        //将int类型变为了字符串
        serializeConfig.put(Integer.class, ToStringSerializer.instance);
        serializeConfig.put(Long.TYPE, ToStringSerializer.instance);
        fastJsonConfig.setSerializeConfig(serializeConfig);

        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        List<MediaType> mediaTypes = new ArrayList<>();
//        mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        mediaTypes.add(new MediaType("application", "json", StandardCharsets.UTF_8));
        fastJsonHttpMessageConverter.setSupportedMediaTypes(mediaTypes);
        log.info("--------fastjson init--------");

        converters.add(0, fastJsonHttpMessageConverter);
    }
}
