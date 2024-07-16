package org.zz.web.guide.servlet.filter;

import jakarta.servlet.*;

import java.io.IOException;

public class PostFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // filter是栈结构，先进后出
        System.out.println("====== PostFilter doFilter before ======");
        chain.doFilter(request, response);
        System.out.println("====== PostFilter doFilter after ======");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
