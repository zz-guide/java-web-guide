package org.zz.web.guide.fud.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;

@WebServlet("/file/download/t2")
public class FileDownloadServlet2 extends HttpServlet {
    @Serial
    private static final long serialVersionUID = -4786755649966184752L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("=== 下载其他远程服务器文件 ===");
    }
}
