package org.zz.web.guide.fud.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8"); // 放行前一般对req进行处理,resp此时不存在
        System.out.println("=== CharacterEncodingFilter ===");
        chain.doFilter(request, response); // 处理完放行或者不放行

        response.setCharacterEncoding("UTF-8"); // 放行后才对resp进行处理
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
