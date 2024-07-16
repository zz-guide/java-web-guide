package org.zz.web.guide.servlet.http.session;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.Serial;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class CookieHttpServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = -6847390956300559941L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String username = "用户123";
        // 通过编码解决cookie存储中文的问题
        String encode = URLEncoder.encode(username, StandardCharsets.UTF_8);
        Cookie cookie = new Cookie("username", encode);
        // 正数：持久化对应时间，到期浏览器自动删除；负数：内存中；0：删除对应cookie
        cookie.setMaxAge(50000);

        // path如何设置的不是同源的话，获取不到，同时也设置不成功
        cookie.setPath("/123");
        resp.addCookie(cookie);
    }
}
