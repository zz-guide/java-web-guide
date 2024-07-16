package org.zz.web.guide.servlet.http.session;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.Serial;

public class CookieHttpServlet2 extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 7060720677407891344L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        // 获取cookie
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie item: cookies) {
                System.out.println(item.getName()+"-->"+ item.getValue()); // username-->%E8%AE%B8%E7%A3%8A
            }
        }
    }
}
