package org.zz.web.guide.servlet.servlet;

import jakarta.servlet.*;

import java.io.IOException;

public class ExampleServlet implements Servlet {
    private ServletConfig config;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("=== " + this.getClass().getName() + " init() ===");
        config = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        // 最根本的方法就是service方法
        System.out.println("=== " + this.getClass().getName() + " service() ===");
        // 读取servlet内定义的 <init-param>参数
        String name = this.config.getInitParameter("name");
        System.out.println("name:"+ name);
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("=== " + this.getClass().getName() + " destroy() ===");
    }
}
