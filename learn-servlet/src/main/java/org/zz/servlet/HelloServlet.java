package org.zz.servlet;

import jakarta.servlet.*;

import java.io.IOException;

public class HelloServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("=== " + this.getClass().getName() + " init() ===");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("=== " + this.getClass().getName() + " service() ===");
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
