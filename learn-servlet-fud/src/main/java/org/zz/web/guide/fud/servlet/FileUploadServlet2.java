package org.zz.web.guide.fud.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.zz.web.guide.fud.utils.FileUploadUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@WebServlet("/file/upload/t2")
// 文件上传必须要开启该注解
@MultipartConfig(maxFileSize=102400000,maxRequestSize=1024000000,fileSizeThreshold=0)
public class FileUploadServlet2 extends HttpServlet {
    @Serial
    private static final long serialVersionUID = -6767153258611369648L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("=== 文件上传 ===");

        Part file = req.getPart("file2");
        if (file == null) {
            System.out.println("文件必传");
            return;
        }

        String filenameExtension = FileUploadUtils.getFilenameExtension(file.getSubmittedFileName());

        // 判断服务器上传路径是否存在，不存在就创建
        String serverUploadDir = FileUploadUtils.getUploadDirPath(req);
        File serverUploadDirFile = new File(serverUploadDir);
        if (!serverUploadDirFile.exists()) {
            serverUploadDirFile.mkdirs();
        }

        // 文件名必须进行重命名
        String newFilename = String.format("%s.%s", UUID.randomUUID(), filenameExtension);
        String serverUploadFilePath = Paths.get(serverUploadDir, newFilename).toString();
        // 使用 multipartFile 打开一个输入流准备读取
        BufferedInputStream bis = new BufferedInputStream(file.getInputStream());

        // 准备一个输出流写入
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(serverUploadFilePath));

        byte[] bytes = new byte[1024 * 100]; // 每次写100kb
        int readCount = 0;
        while ((readCount = bis.read(bytes)) != -1) {
            System.out.println("readCount:" + readCount);
            bos.write(bytes, 0, readCount);
        }

        bos.flush();
        bos.close();
        bis.close();

        // 最后保存到本机目录
        FileUploadUtils.copy(serverUploadFilePath, newFilename);
    }
}
