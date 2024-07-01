package org.zz.servlet.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(urlPatterns = "/session")
public class SessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // session 一次会话多次请求间的数据共享
        HttpSession session = req.getSession();
        session.setAttribute("username", "仔仔");
    }
}
