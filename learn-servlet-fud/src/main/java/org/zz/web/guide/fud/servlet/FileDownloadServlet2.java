package org.zz.web.guide.fud.servlet;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.Serial;
import java.net.HttpURLConnection;
import java.net.URL;

@WebServlet("/file/download/t2")
public class FileDownloadServlet2 extends HttpServlet {
    @Serial
    private static final long serialVersionUID = -4786755649966184752L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("=== 下载其他远程服务器文件 ===");
        String remoteUrl = "https://i0.hdslb.com/bfs/archive/6e8e16d02a0f0c1cf0b246e13a5bf3eadef52d4e.jpg";
        String[] bb = remoteUrl.split("[?]")[0].split("/");
        String filename = bb[bb.length - 1];

        URL url = new URL(remoteUrl);
        HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
        urlConnection.setRequestMethod("GET");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(urlConnection.getInputStream());

        resp.setContentType("application/octet-stream");
        resp.setHeader("Content-Disposition", "attachment;filename="+filename);

        ServletOutputStream outputStream = resp.getOutputStream();
        outputStream.write(bufferedInputStream.readAllBytes());

        outputStream.flush();
        outputStream.close();
        bufferedInputStream.close();

        System.out.println("文件下载成功");
    }
}
