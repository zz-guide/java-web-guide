package org.zz.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


public class ExampleServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("=== " + this.getClass().getName() + " doGet() ===");
        ServletContext servletContext = this.getServletContext();
        String username = servletContext.getInitParameter("username");
        System.out.println("username:"+ username);
    }
}
