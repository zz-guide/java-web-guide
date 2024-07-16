package org.zz.web.guide.fud.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@WebServlet("/file/upload")
// 文件上传必须要开启该注解
@MultipartConfig(maxFileSize=102400000,maxRequestSize=1024000000,fileSizeThreshold=0)
public class FileUploadServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = -5728969577475974524L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        System.out.println("=== 文件上传 ===");

        // 1. 通过req.getPart读取文件数据
        Part file = req.getPart("file");
        String submittedFileName = file.getSubmittedFileName();
        System.out.println("submittedFileName:"+submittedFileName);

        String filenameExtension = getFilenameExtension(submittedFileName);
        System.out.println("filenameExtension:"+filenameExtension);

        // 2. 准备上传目录，将图片数据保存到该目录
        ServletContext servletContext = req.getServletContext();
        String serverUploadDir = servletContext.getRealPath("/upload");
        System.out.println("serverUploadDir:"+serverUploadDir);
        File serverUploadFile = new File(serverUploadDir);
        if (!serverUploadFile.exists()) {
            serverUploadFile.mkdirs();
        }

        // 准备把文件读取到上传目录，文件名必须进行重命名
        String newFilename = String.format("%s.%s", UUID.randomUUID(), filenameExtension);
        String serverUploadFilePath = serverUploadFile.getAbsolutePath() + "/" +newFilename;
        System.out.println("serverUploadFilePath:"+serverUploadFilePath);

        // 3. 将Part数据直接写入一个路径
        file.write(serverUploadFilePath);

        // 4. 理论上应该同时copy一份到本地目录，防止重启导致文件丢失
        String destinationPath = "E:\\jungle\\github\\zz-guide\\java-web-guide\\learn-servlet-fud\\src\\main\\webapp\\upload\\"+newFilename;
        Files.copy(Paths.get(serverUploadFilePath), Paths.get(destinationPath), StandardCopyOption.REPLACE_EXISTING);
    }

    public static String getFilenameExtension(String path) {
        if (path == null) {
            return null;
        } else {
            int extIndex = path.lastIndexOf(46);
            if (extIndex == -1) {
                return null;
            } else {
                int folderIndex = path.lastIndexOf(47);
                return folderIndex > extIndex ? null : path.substring(extIndex + 1);
            }
        }
    }
}
