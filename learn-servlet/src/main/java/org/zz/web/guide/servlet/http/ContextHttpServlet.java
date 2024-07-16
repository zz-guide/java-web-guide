package org.zz.web.guide.servlet.http;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.Serial;

public class ContextHttpServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = -8392945042705283830L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("=== " + this.getClass().getName() + " doGet() ===");
        System.out.println("=== 初步了解 getServletContext === ");

        // 读取 <context-param> 定义的数据
        ServletContext servletContext = this.getServletContext();
        String username = servletContext.getInitParameter("username");
        System.out.println("username:"+ username);
    }
}
