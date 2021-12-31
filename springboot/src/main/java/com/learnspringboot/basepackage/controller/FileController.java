package com.learnspringboot.basepackage.controller;

import cn.hutool.core.util.ZipUtil;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
@RequestMapping("/file")
@RestController
public class FileController {
    //测试文件下载download
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

    @RequestMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") CommonsMultipartFile file) throws IOException {
        long startTime = System.currentTimeMillis();
        System.out.println("fileName：" + file.getOriginalFilename());
        String path = "D://test/" + file.getOriginalFilename();
        File newFile = new File(path);
        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        file.transferTo(newFile);
        long endTime = System.currentTimeMillis();
        System.out.println("方法二的运行时间：" + (endTime - startTime) + "ms");
        return "success";
    }
}
