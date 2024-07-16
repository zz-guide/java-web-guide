package org.zz.web.guide.servlet.http;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Serial;

public class RequestHttpServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = -1230480683375512204L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("=== " + this.getClass().getName() + " doGet() ===");
        System.out.println("=== 初步了解 HttpServletRequest === ");

        // 请求行数据
        String method = req.getMethod();
        System.out.println("请求方法:"+method);

        String contextPath = req.getContextPath();
        System.out.println("虚拟目录路径[项目路径]:"+contextPath);

        StringBuffer requestURL = req.getRequestURL();
        System.out.println("请求URL："+requestURL);

        String requestURI = req.getRequestURI();
        System.out.println("请求URI：" + requestURI);

        String queryString = req.getQueryString();
        System.out.println("请求参数字符串:"+queryString);

        // 请求头
        String header = req.getHeader("User-Agent");
        System.out.println("请求头:"+header);

        // 获取字符输入流
        BufferedReader reader = req.getReader();
        String s = reader.readLine();
        System.out.println("读取数据:"+s);

    }
}
