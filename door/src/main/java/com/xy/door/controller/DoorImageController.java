package com.xy.door.controller;

import com.xy.door.constant.Constants;
import com.xy.door.service.ImageDistingushService;
import org.apache.commons.io.FilenameUtils;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @Classname UploadImageController
 * @Description
 * @Date 2019/11/11 16:55
 * @Author xiayun
 */
@RequestMapping(value = "/doorImage")
@Controller
public class DoorImageController {

    @Autowired
    private ImageDistingushService imageDistingushService;

    @Autowired
    private Constants constants;

    @RequestMapping(value = "/uploadAndDistingdush", method = RequestMethod.POST)
    public String uploadAndDistingdush(MultipartFile file, HttpServletRequest req) {

        ServletContext context = req.getServletContext();

        //获取上传时的文件名称
        String filename = file.getOriginalFilename();
        //创建一个新的文件名称    getExtension(name):获取文件后缀名
        filename = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(filename);

        //File f = new File(constants.getImageUploadPath() + "/" + filename);
        //将上传的文件存储到指定位置
        try {
            //file.transferTo(f);
            //FileInputStream inputStream = new FileInputStream(f);
            //System.out.println(file.getContentType());
            //MultipartFile multipartFile = new MockMultipartFile("file", IOUtils.toByteArray(inputStream));
            String result = imageDistingushService.distingdush(file);
            //inputStream.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @RequestMapping(value = "/image")
    public String image() {
        return "image";
    }

}
