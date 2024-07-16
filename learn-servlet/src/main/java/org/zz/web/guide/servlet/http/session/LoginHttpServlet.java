package org.zz.web.guide.servlet.http.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import org.zz.web.guide.servlet.pojo.SessionUser;

import java.io.IOException;
import java.io.Serial;

public class LoginHttpServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 9177383320604698344L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("=== " + this.getClass().getName() + " doGet() ===");
        String role = req.getParameter("role");

        HttpSession session = req.getSession();
        String sessionKey = "userInfo";
        Object sessionUserInfo = session.getAttribute(sessionKey);
        if (sessionUserInfo == null) {
            // 说明没登录
            SessionUser sessionUser = new SessionUser();
            if (role == null) {
                // 没传role认为是超管
                sessionUser.setId(1L);
                sessionUser.setName("超级管理员");
                sessionUser.setRoleName("超管");
            } else {
                sessionUser.setId(10L);
                sessionUser.setName("用户1");
                sessionUser.setRoleName("普通用户");
            }

            session.setAttribute(sessionKey, sessionUser);
        } else {
            System.out.println("=== 已经登录 ===");
        }

        req.getRequestDispatcher("/WEB-INF/jsp/login_ok.jsp").forward(req, resp);
    }
}
