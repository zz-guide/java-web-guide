package org.zz.servlet.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/session2")
public class SessionServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // session 一次会话多次请求间的数据共享
        HttpSession session = req.getSession();
        // 发现换个浏览器就不行了
        String username = (String)session.getAttribute("username");
        System.out.println(username);
    }
}
