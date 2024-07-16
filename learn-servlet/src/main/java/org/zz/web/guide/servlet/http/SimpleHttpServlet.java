package org.zz.web.guide.servlet.http;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;

public class SimpleHttpServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = -7555457103901191185L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("=== " + this.getClass().getName() + " doGet() ===");
        System.out.println("=== 初步了解 servlet === ");
    }
}
