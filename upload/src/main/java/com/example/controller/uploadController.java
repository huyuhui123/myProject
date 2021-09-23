package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.server.PathParam;
import java.io.File;
import java.io.IOException;

@Controller
public class uploadController {
    @RequestMapping("/")
    public String toupload(){
        return "/upload";
    }
    /**
     * 单文件、多文件上传
     * @RequestPart 和RequestParam、PathParam的区别
     * 习惯：做好非空判断、
     * 还可以获得大小、个数等文件信息
     * 原理*/
    @RequestMapping("/upload")
    @ResponseBody
    public String upload(@RequestPart("file") MultipartFile handfile,
                         @RequestPart("files") MultipartFile[] multipartFiles) throws IOException {
        //报错1，没得到，所以先只返回名字   原因：没加 enctype="multipart/form-data"
       // System.out.println(file.getOriginalFilename());
        String originalFilename = handfile.getOriginalFilename();
        handfile.transferTo(new File("D:\\"+originalFilename));

        //多文件
        //一定要有文件夹，如果有图片则会覆盖
        //多文件上传input的后缀名multiple要有，这是区别单文件
        if(multipartFiles.length>0)
            for (MultipartFile multipartFile : multipartFiles){
                String originalFilename1 = multipartFile.getOriginalFilename();
                multipartFile.transferTo(new File("D:\\cache\\"+originalFilename1));
            }

        return "123";
    }

}
