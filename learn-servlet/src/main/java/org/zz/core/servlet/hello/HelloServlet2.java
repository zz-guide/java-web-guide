package org.zz.core.servlet.hello;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * servlet内置方法介绍
 */
@WebServlet(urlPatterns = "/hello2", initParams = {@WebInitParam(name = "name", value = "仔仔"),
        @WebInitParam(name = "password", value = "123456")
})
public class HelloServlet2 extends HttpServlet {
    /**
     * 1. init() 只会调用一次
     * 2. 可以简单地创建或加载一些数据，这些数据将被用于 Servlet 的整个生命周期
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("======= init() 只执行一次=======");
        System.out.println("name:" + config.getInitParameter("name"));
        System.out.println("password:" + config.getInitParameter("password"));
        // 其他方法使用可通过this.getServletConfig()获取
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("this.getServletName():" + this.getServletName());
        System.out.println("this.getServletInfo():" + this.getServletInfo());
        // 本质山还是从getServletConfig获取
        System.out.println("this.getInitParameter(\"password\"):" + this.getInitParameter("password"));
        System.out.println("[注解方式定义servlet] doGet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("[注解方式定义servlet] doPost");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println(this.getClass().toString() + " destroy");
    }
}
