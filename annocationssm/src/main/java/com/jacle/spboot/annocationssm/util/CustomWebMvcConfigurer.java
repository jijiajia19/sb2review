package com.jacle.spboot.annocationssm.util;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.util.List;

@Configuration
public class CustomWebMvcConfigurer implements WebMvcConfigurer
{

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters)
    {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();

        FastJsonConfig config = new FastJsonConfig();
        config.setSerializerFeatures(SerializerFeature.DisableCircularReferenceDetect);

        converter.setFastJsonConfig(config);
        converter.setDefaultCharset(Charset.forName("UTF-8"));
        converters.add(converter);
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer)
    {
        configurer.favorPathExtension(true)   //是否支持后缀的方式
                .favorParameter(true)        //是否支持请求参数的方式
//                    .ignoreAcceptHeader(true)
                .parameterName("format")    //请求参数名
                .defaultContentType(MediaType.APPLICATION_JSON)
//                .defaultContentType(MediaType.ALL)
                .mediaType("json", MediaType.APPLICATION_JSON)
                .mediaType("xml", MediaType.APPLICATION_ATOM_XML);
    }

/*    @Override
    public void configureViewResolvers(ViewResolverRegistry registry)
    {
        registry.enableContentNegotiation(new PdfViewResolver());
        registry.enableContentNegotiation(new ExcelViewResolver());
        registry.enableContentNegotiation(new HtmlViewResolver());

        //注册之后
        registry.enableContentNegotiation(false);
    }*/
}