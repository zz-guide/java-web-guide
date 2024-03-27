package org.zz.core.servlet.cookie;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet(urlPatterns = "/cookie")
public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        // 测试Cookie

        // 发送cookie给客户端

        String username = "许磊";
        // 通过编码解决cookie存储中文的问题
        String encode = URLEncoder.encode(username, StandardCharsets.UTF_8);
        Cookie cookie = new Cookie("username", encode);
        cookie.setMaxAge(50000); // 正数：持久化对应时间，到期浏览器自动删除；负数：内存中；0：删除对应cookie
        resp.addCookie(cookie);

        // 获取cookie
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie item: cookies) {
                System.out.println(item.getName()+"-->"+ item.getValue()); // username-->%E8%AE%B8%E7%A3%8A
            }
        }
    }
}
