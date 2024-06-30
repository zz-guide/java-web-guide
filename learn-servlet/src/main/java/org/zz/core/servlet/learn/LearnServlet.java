package org.zz.core.servlet.learn;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * 认识servlet中的内置方法
 */
@WebServlet("/learn")
public class LearnServlet extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("servlet hello world");
        // 请求行数据
        HttpServletRequest httpServletRequest = (HttpServletRequest)req;
        String method = httpServletRequest.getMethod();
        System.out.println("请求方法:"+method);

        String contextPath = httpServletRequest.getContextPath();
        System.out.println("虚拟目录路径:"+contextPath);

        StringBuffer requestURL = httpServletRequest.getRequestURL();
        System.out.println("请求URL："+requestURL);

        String requestURI = httpServletRequest.getRequestURI();
        System.out.println("请求URI：" + requestURI);

        String queryString = httpServletRequest.getQueryString();
        System.out.println("请求参数字符串:"+queryString);

        // 请求头
        String header = httpServletRequest.getHeader("User-Agent");
        System.out.println("请求头:"+header);

        // 获取字符输入流
        BufferedReader reader = httpServletRequest.getReader();
        String s = reader.readLine();
        System.out.println("读取数据:"+s);
    }

    @Override
    public void destroy() {
        System.out.println("=======destroy=======");
    }
}
