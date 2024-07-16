package org.zz.web.guide.servlet.http.forward;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;

public class ForwardJspHttpServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = -2667326455907818736L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("=== " + this.getClass().getName() + " doGet() ===");
        // WEB-INF 下的资源只能通过转发访问, 并且路径要写全
        // springmvc 可通过配置prefix参数，不用写/WEB-INF/
        req.getRequestDispatcher("/WEB-INF/jsp/forward_ok.jsp").forward(req, resp);
    }
}
