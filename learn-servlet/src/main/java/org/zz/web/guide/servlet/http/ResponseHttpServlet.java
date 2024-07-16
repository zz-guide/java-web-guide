package org.zz.web.guide.servlet.http;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;

public class ResponseHttpServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = -6535579523080161333L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("=== " + this.getClass().getName() + " doGet() ===");
        System.out.println("=== 初步了解 HttpServletResponse === ");

        PrintWriter out = resp.getWriter();
        out.print("hello world 你好");
    }
}
