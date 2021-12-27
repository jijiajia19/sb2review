package com.jacle.spboot.annocationssm.view;

import org.springframework.http.MediaType;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class ExcelViewResolver implements View
{

    @Override
    public String getContentType()
    {
        return MediaType.APPLICATION_JSON_UTF8_VALUE;
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        response.getWriter()
                .write("<html><body style='color:blue'>This is [JSON] view!</body></html>");
    }

}