package org.zz.web.guide.servlet.http.json;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;

public class JsonResponseHttpServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 528497637582934924L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String jsonResponse = "{\"name\":\"用户\"}";

        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setStatus(200);
        out.print(jsonResponse);
    }
}
