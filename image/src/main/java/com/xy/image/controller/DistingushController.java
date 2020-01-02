package com.xy.image.controller;

import com.xy.image.util.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Classname ClassifyController
 * @Description
 * @Date 2019/11/11 16:28
 * @Author xiayun
 */
@Controller
@RequestMapping(value = "/distingush")
public class DistingushController {

    @Autowired
    private ImageUtils imageUtils;

    @RequestMapping(value = "/advancedGeneral",method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String advancedGeneral(@RequestParam(value = "file") MultipartFile file){
        System.out.println("----收到请求！");
        try {
            return imageUtils.advancedGeneral(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
