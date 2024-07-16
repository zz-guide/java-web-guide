package org.zz.web.guide.servlet.filter;

import jakarta.servlet.*;

import java.io.IOException;

public class PreFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("====== PreFilter doFilter before ======");
        chain.doFilter(request, response);
        System.out.println("====== PreFilter doFilter after ======");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
