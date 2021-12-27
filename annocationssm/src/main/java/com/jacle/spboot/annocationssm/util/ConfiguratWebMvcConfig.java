package com.jacle.spboot.annocationssm.util;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author Jacle
 * @version 1.0
 * @description: 配置类2
 *          WebMvcConfigurationSupport的处理?
 * @date 2021/12/26 20:56
 */
public class ConfiguratWebMvcConfig extends WebMvcConfigurationSupport
{
 /*   @Override
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
    }*/


    //注册视图处理器
    //同一个rest接口，通过不同的视图来响应
  /*  @Override
    protected void configureViewResolvers(ViewResolverRegistry registry)
    {
        registry.enableContentNegotiation(new PdfViewResolver());
        registry.enableContentNegotiation(new ExcelViewResolver());
        registry.enableContentNegotiation(new HtmlViewResolver());

        //注册之后
        registry.enableContentNegotiation(false);
    }*/
}
