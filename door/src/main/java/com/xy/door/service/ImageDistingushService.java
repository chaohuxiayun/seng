package com.xy.door.service;

import com.xy.door.configuration.FeignMultipartConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;


/**
 * @Classname ImageDistingushService
 * @Description
 * @Date 2019/11/19 10:30
 * @Author xiayun
 */
@FeignClient(value = "zuul", configuration = FeignMultipartConfig.class)
public interface ImageDistingushService {

    @RequestMapping(value = "/api-image/distingush/advancedGeneral", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String distingdush(@RequestPart(value = "file") MultipartFile file);


}
