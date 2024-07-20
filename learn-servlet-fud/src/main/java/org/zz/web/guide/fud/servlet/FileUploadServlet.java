package org.zz.web.guide.fud.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.zz.web.guide.fud.utils.FileUploadUtils;

import java.io.*;

@WebServlet("/file/upload/t1")
// 文件上传必须要开启该注解
@MultipartConfig(maxFileSize=102400000,maxRequestSize=1024000000,fileSizeThreshold=0)
public class FileUploadServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = -5728969577475974524L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        System.out.println("=== 文件上传, 测试参数 ===");
        // 1. 通过req.getPart读取文件数据
        Part file = req.getPart("file");
        if (file == null) {
            System.out.println("文件必传");
            return;
        }

        String submittedFileName = file.getSubmittedFileName();
        System.out.println("submittedFileName:"+submittedFileName);

        String filenameExtension = FileUploadUtils.getFilenameExtension(submittedFileName);
        System.out.println("filenameExtension:"+filenameExtension);
    }
}
