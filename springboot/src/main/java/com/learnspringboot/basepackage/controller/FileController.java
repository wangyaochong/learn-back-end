package com.learnspringboot.basepackage.controller;

import cn.hutool.core.util.ZipUtil;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
@RequestMapping("/file")
@RestController
public class FileController {
    //测试文件下载
    @GetMapping("/get")
    public void file(HttpServletResponse request, HttpServletResponse response) throws IOException {
        String fileName = "/application.properties";
//        File file = new File(FileController.class.getResource(fileName).getPath());
        InputStream resourceAsStream = FileController.class.getResourceAsStream(fileName);
        byte[] buffer = new byte[resourceAsStream.available()];
        resourceAsStream.read(buffer);
        resourceAsStream.close();
        ServletOutputStream outputStream = response.getOutputStream();
        response.setContentType("application/octet-stream");
        response.reset();
        // 设置response的Header
        response.addHeader("Content-Disposition", "attachment;filename=" + fileName.substring(1));
//        response.addHeader("Content-Length", "" + file.length());
        //System.out.println("文件长度=" + file.length());
        System.out.println("buffer长度=" + buffer.length);
        response.addHeader("Content-Length", "" + buffer.length);
        OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
        response.setContentType("application/octet-stream");
        toClient.write(buffer);
        toClient.flush();
        toClient.close();
    }
    //下载压缩文件
    @GetMapping("/getZip")
    public void getZipFile(HttpServletResponse request, HttpServletResponse response) throws IOException {
        String fileName = "/application.properties";
        File path = new File(FileController.class.getResource(fileName).getPath());
        File zip = ZipUtil.zip(path);
        FileInputStream fileInputStream = new FileInputStream(zip);
//        InputStream resourceAsStream = FileController.class.getResourceAsStream(fileName);
        byte[] buffer = new byte[fileInputStream.available()];
        fileInputStream.read(buffer);
        fileInputStream.close();
        ServletOutputStream outputStream = response.getOutputStream();
        response.setContentType("application/octet-stream");
        response.reset();
        // 设置response的Header
        response.addHeader("Content-Disposition", "attachment;filename=" + fileName.substring(1)+".zip");
//        response.addHeader("Content-Length", "" + file.length());
        //System.out.println("文件长度=" + file.length());
        System.out.println("buffer长度=" + buffer.length);
        response.addHeader("Content-Length", "" + buffer.length);
        OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
        response.setContentType("application/octet-stream");
        toClient.write(buffer);
        toClient.flush();
        toClient.close();
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
