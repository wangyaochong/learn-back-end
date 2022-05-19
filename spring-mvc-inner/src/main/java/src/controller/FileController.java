package src.controller;

import cn.hutool.core.img.ImgUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

//文件上传
@Controller
@RequestMapping("/file")
public class FileController {
    @RequestMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") List<CommonsMultipartFile> files,  //这个地方也可以使用CommonsMultipartFile[]数组类型
                         @RequestParam("formParam") String formParam,
                         @RequestParam("urlParam") String urlParam
    ) throws IOException {
        System.out.println("formParam=" + formParam);
        System.out.println("urlParam=" + urlParam);
        for (CommonsMultipartFile file : files) {
            long startTime = System.currentTimeMillis();
            System.out.println("fileName：" + file.getOriginalFilename());
            String path = "D://test/" + file.getOriginalFilename();
            File newFile = new File(path);
            //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
            file.transferTo(newFile);
            long endTime = System.currentTimeMillis();
            System.out.println("方法二的运行时间：" + (endTime - startTime) + "ms");
        }
        return "success";
    }

    @GetMapping("/getImage")//下载图片
    public void file(HttpServletResponse request, HttpServletResponse response) throws IOException {
        String fileName = "/27a4c9246e34bfd632383d0e807a8270.jpeg";
//        File file = new File(FileController.class.getResource(fileName).getPath());
        InputStream resourceAsStream = FileController.class.getResourceAsStream(fileName);
        byte[] buffer = new byte[resourceAsStream.available()];
        resourceAsStream.read(buffer);
        resourceAsStream.close();
        ServletOutputStream outputStream = response.getOutputStream();
        response.reset();
        // 设置response的Header
        response.addHeader("Content-Disposition", "attachment;filename=xxx");//+ fileName.substring(1));
//        response.addHeader("Content-Length", "" + file.length());
        //System.out.println("文件长度=" + file.length());
        System.out.println("buffer长度=" + buffer.length);
        response.addHeader("Content-Length", "" + buffer.length);
        response.setCharacterEncoding("utf-8");
        OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
        response.setContentType("application/octet-stream");
        toClient.write(buffer);
        toClient.flush();
        toClient.close();
    }

    //有时候文件上传需要使用MultipartFile
    public String toBase64(@RequestParam("file") CommonsMultipartFile file) throws IOException {
        BufferedImage read = ImgUtil.read(file.getInputStream());
        String[] split = file.getOriginalFilename().split("\\.");
        if (split.length - 1 < 0) {
            return null;//没有文件后缀
        }
        String type = split[split.length - 1];
        List<String> availableList = new ArrayList<>();
        availableList.add(ImgUtil.IMAGE_TYPE_GIF);
        availableList.add(ImgUtil.IMAGE_TYPE_JPG);
        availableList.add(ImgUtil.IMAGE_TYPE_JPEG);
        if (availableList.contains(type)) {
            return null;//不支持的类型
        }
        return ImgUtil.toBase64(read, type);
    }

    public String fromBase64(HttpServletResponse response) throws IOException {
        String filename = "abc.png";
        String imgType = "png";
        String base64String = "base64String";
        response.setContentType("application/octet-stream");
        response.addHeader("Content-Disposition", "attachment:filename=" + filename);
        BufferedImage bufferedImage = ImgUtil.toImage(base64String);
        ImgUtil.write(bufferedImage, imgType, response.getOutputStream());
        return null;
    }


}
