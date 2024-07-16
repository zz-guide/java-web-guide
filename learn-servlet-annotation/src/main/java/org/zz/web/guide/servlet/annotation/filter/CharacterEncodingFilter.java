package org.zz.web.guide.servlet.annotation.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;

@WebFilter("/*")
public class CharacterEncodingFilter extends HttpFilter {
    @Serial
    private static final long serialVersionUID = 1612694576603764990L;

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        chain.doFilter(req, res);

        res.setCharacterEncoding("UTF-8");
    }
}
