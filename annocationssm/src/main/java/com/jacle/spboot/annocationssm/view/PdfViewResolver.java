package com.jacle.spboot.annocationssm.view;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Slf4j
public class PdfViewResolver implements View
{

    @Override
    public String getContentType()
    {
        return MediaType.APPLICATION_PDF_VALUE;
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        log.info(model.toString());
        response.getWriter().write("<html><body style='color:red'>This is [PDF] view</body></html>");
    }
}