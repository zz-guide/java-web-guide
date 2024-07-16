package org.zz.web.guide.freemarker.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;

@WebServlet(urlPatterns = "/")
public class IndexServlet extends ViewBaseServlet{
    @Serial
    private static final long serialVersionUID = 1137217978107820921L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setAttribute("msg", "欢迎练习thymeleaf");
        processTemplate("index", req, resp);
    }
}
