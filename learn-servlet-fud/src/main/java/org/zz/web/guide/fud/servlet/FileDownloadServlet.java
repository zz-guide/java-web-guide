package org.zz.web.guide.fud.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.zz.web.guide.fud.utils.FileUploadUtils;

import java.io.File;
import java.io.IOException;
import java.io.Serial;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@WebServlet("/file/download/t1")
public class FileDownloadServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 7431298204626500016L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("=== 下载本地服务器文件 ===");

        Path downloadFilePath = Paths.get(FileUploadUtils.getJarPath(req), FileUploadUtils.DOWNLOAD_PATH, "test.jpg");
        File file = new File(downloadFilePath.toString());
        if (!file.exists()) {
            resp.getWriter().write("文件不存在, 下载失败");
            return;
        }

        resp.setContentType("application/octet-stream");
        resp.setHeader("Content-Disposition", "attachment;filename="+file.getName());

        // 最后切记别忘了用输出流将数据输出
        ServletOutputStream outputStream = resp.getOutputStream();
        outputStream.write(Files.readAllBytes(file.toPath()));

        outputStream.flush();
        outputStream.close();

        System.out.println("文件下载成功");
    }
}
