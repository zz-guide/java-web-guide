package org.zz.web.guide.fud.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.io.Serial;
import java.nio.file.Files;

@WebServlet("/file/download")
public class FileDownloadServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 7431298204626500016L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("=== 文件下载 ===");

        ServletContext servletContext = req.getServletContext();
        String realPath = servletContext.getRealPath("/upload/"+"1.jpeg");
        System.out.println("realPath:"+realPath);
        File file = new File(realPath);
        if (file.exists()) {
            resp.setContentType("application/octet-stream");
            resp.setHeader("Content-Disposition", "attachment;filename="+file.getName());

            // 最后切记别忘了用输出流将数据输出
            ServletOutputStream outputStream = resp.getOutputStream();
            outputStream.write(Files.readAllBytes(file.toPath()));

            outputStream.flush();
            outputStream.close();
        } else{
            resp.getWriter().write("文件不存在, 下载失败");
        }
    }
}
