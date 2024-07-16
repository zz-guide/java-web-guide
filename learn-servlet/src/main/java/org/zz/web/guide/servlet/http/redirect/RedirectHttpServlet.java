package org.zz.web.guide.servlet.http.redirect;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;

public class RedirectHttpServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = -1456758572114943867L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 客户端根据服务端响应的状态码进行重定向
        // 客户端会发起多次请求
        // 服务端也会多次响应
        // 可以跨域
        // 请求地址会变化
        // 302 Found , 临时重定向，可缓存
        System.out.println("=== " + this.getClass().getName() + " doGet() ===");
        resp.sendRedirect(String.format("%s/%s",req.getContextPath(), "redirectJsp"));
    }
}
