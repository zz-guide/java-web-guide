package org.zz.web.guide.fud.utils;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

public class FileUploadUtils {
    public static final String UPLOAD_PATH = "/static/upload"; // 相对webapp的路径
    public static final String DOWNLOAD_PATH = "/static/download"; // 相对webapp的路径
    public static final String LOCAL_UPLOAD_PATH = "E:\\jungle\\github\\zz-guide\\java-web-guide\\learn-servlet-fud\\src\\main\\webapp\\static\\upload"; // 本机upload全路径

    public static String getClassesPath() {
        // getResource("/") 本质上获取的也是 /WEB-INF/classes/, 可参考 ResourceUtils.getURL
        String classPath = Objects.requireNonNull(FileUploadUtils.class.getResource("/")).getPath();
        System.out.println("getClassesPath:" + classPath); // /target/learn-servlet-fud-1.0-SNAPSHOT/WEB-INF/classes/
        return classPath;
    }

    public static String getJarPath(HttpServletRequest req) {
        ServletContext servletContext = req.getServletContext();
        String jarPath = servletContext.getRealPath(""); // 这里不能填null,应该填空字符串
        System.out.println("getJarPath:" + jarPath);
        return jarPath;
    }

    public static String getUploadDirPath(HttpServletRequest req) {
        String uploadDirPath = Paths.get(getJarPath(req), UPLOAD_PATH).normalize().toString();
        System.out.println("getUploadDirPath:" + uploadDirPath);
        return uploadDirPath;
    }

    public static String getUserDirProperty() {
        String property = System.getProperty("user.dir");
        System.out.println("user.dir:" + property); // E:\tools\apache-tomcat-10.1.25\bin
        return property;
    }

    public static void copy(String source, String newFilename) throws IOException {
        Files.copy(Paths.get(source), Paths.get(FileUploadUtils.LOCAL_UPLOAD_PATH, newFilename), StandardCopyOption.REPLACE_EXISTING);
    }

    public static String getDownloadDirPath(HttpServletRequest req) {
        String uploadDirPath = Paths.get(getJarPath(req), DOWNLOAD_PATH).normalize().toString();
        System.out.println("getDownloadDirPath:" + uploadDirPath);
        return uploadDirPath;
    }

    public static String getFilenameExtension(String path){
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

    public static String getFilenameExtension2(String originalFilename) {
        String filenameExtension = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        System.out.println("getFilenameExtension2:" + filenameExtension);
        return filenameExtension;
    }
}
