package org.zz.web.guide.servlet.http.forward;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;

public class ForwardHttpServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = -2667326455907818736L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("=== " + this.getClass().getName() + " doGet() ===");

        // forward() forward是服务器请求资源，服务器直接访问目标地址的URL，把那个URL的响应内容读取过来,然后把这些内容再发给浏览器
        // 浏览器根本不知道服务器发送的内容从哪里来的，所以它的地址栏还是原来的地址
        // 可以共享request数据

        // 不能跨域
        // 客户端只发起一次请求
        // 请求地址不会变化
        // 转发请求到另一个servlet处理
        req.getRequestDispatcher("/forwardJsp").forward(req, resp);
    }
}
