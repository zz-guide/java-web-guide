package org.zz.core.servlet.redirect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/red2")
public class RedirectServlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 方式一 重定向
//        resp.setStatus(301); // 永久重定向
        // 需要加上虚拟目录,因为是url发生变化
//        resp.setHeader("location", req.getContextPath()+"/red1");

        // 方式二 重定向
        resp.sendRedirect(req.getContextPath()+"/red1");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
