package com.jacle.spboot.annocationssm.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Jacle
 * @version 1.0
 * @description: 自定义Servlet
 * @date 2021/12/29 13:33
 */
@Slf4j
public class MyServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String name = getServletConfig().getInitParameter("name");
        String sex = getServletConfig().getInitParameter("sex");

        resp.setContentType("text/html;charset=UTF-8");

        //二进制输出方式
        resp.getWriter().println("name is " + name);
        resp.getWriter().println("sex is " + sex);

        log.warn("第一种Servlet实现方式-->组件注册方式");
        //文本输出方式
//        resp.getWriter().write("success");
    }
}
