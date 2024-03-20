package com.xulei.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class FirstFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("======First过滤器前======");
        chain.doFilter(request, response);
        System.out.println("======First过滤器后======");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
