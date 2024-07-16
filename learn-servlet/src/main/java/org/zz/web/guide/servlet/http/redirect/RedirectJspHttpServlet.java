package org.zz.web.guide.servlet.http.redirect;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;

public class RedirectJspHttpServlet extends HttpServlet {

    @Serial
    private static final long serialVersionUID = -1615539442065340149L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("=== " + this.getClass().getName() + " doGet() ===");
        req.getRequestDispatcher("/WEB-INF/jsp/redirect_ok.jsp").forward(req, resp);
    }
}
