package com.jacle.spboot.annocationssm.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Jacle
 * @version 1.0
 * @description: 注解创建Servlet
 * @date 2021/12/29 14:06
 */

@Slf4j
@WebServlet(name="annotationServlet",urlPatterns = "/aservlet")
public class AnnotationServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        log.warn("第2种Servlet实现方式-->注解实现方式");
        resp.getWriter().write("success");
    }
}
