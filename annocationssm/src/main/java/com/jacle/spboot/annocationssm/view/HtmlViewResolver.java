package com.jacle.spboot.annocationssm.view;

import org.springframework.http.MediaType;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class HtmlViewResolver implements View
{

    @Override
    public String getContentType()
    {
        return MediaType.TEXT_HTML_VALUE;
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        response.getWriter()
                .write("<html><body style='color:green'>This is [HTML] view!</body></html>");
    }

}