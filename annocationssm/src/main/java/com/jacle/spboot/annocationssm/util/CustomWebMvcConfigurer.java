package com.jacle.spboot.annocationssm.util;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.jacle.spboot.annocationssm.servlet.MyServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.Validator;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.util.Date;
import java.util.List;

@Configuration
public class CustomWebMvcConfigurer implements WebMvcConfigurer
{

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters)
    {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();

        FastJsonConfig config = new FastJsonConfig();
        // 避免循环引用
        config.setSerializerFeatures(SerializerFeature.WriteNullStringAsEmpty);
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

    //类似初始化方法
/*    @Autowired
    public void setWebBindingInitializer(RequestMappingHandlerAdapter requestMappingHandlerAdapter)
    {
        //将自定义的CustomDateWebBindingInitializer属性编辑器绑定到RequestMappingHandlerAdapter里面.
        //全局的请求参数类型转换器
        requestMappingHandlerAdapter.setWebBindingInitializer(new CustomDateWebBindingInitializer());
    }*/

    //新的API:ConfigurableWebBindingInitializer
    @Bean
    ConfigurableWebBindingInitializer setcwbInitializer(FormattingConversionService mvcConversionService, Validator mvcValidator)
    {
        ConfigurableWebBindingInitializer initializer = new ConfigurableWebBindingInitializer();
        initializer.setConversionService(mvcConversionService);
        initializer.setValidator(mvcValidator);

        //装配自定义属性编辑器
        initializer.setPropertyEditorRegistrar(propertyEditorRegistry ->
        {
            //PropertyEditors并不是线程安全的，对于每一个请求，我们都需要new一个PropertyEditor对象
            propertyEditorRegistry.registerCustomEditor(Date.class, new MyPropertyEditorSupport());
        });

        return initializer;
    }

    //全局注册Servlet
    @Bean
    public ServletRegistrationBean getServletRegistrationBean()
    {
        ServletRegistrationBean s = new ServletRegistrationBean(new MyServlet(), "/myservlet");

        //设置servlet初始化参数
        s.addInitParameter("name", "一一哥");
        s.addInitParameter("sex", "man");

        return s;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry)
    {
        registry.addMapping("/**")
                //针对的origin域名
                .allowedOrigins("*")
                //针对的方法
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                //是否允许发送Cookie
                .allowCredentials(true)
                //从预检请求得到相应的最大时间,默认30分钟
                .maxAge(3600)
                //针对的请求头
                .allowedHeaders("*");
    }
}