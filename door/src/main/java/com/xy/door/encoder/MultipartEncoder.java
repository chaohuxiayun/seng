package com.xy.door.encoder;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

import feign.RequestTemplate;
import feign.codec.EncodeException;
import feign.form.spring.SpringFormEncoder;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

/**
 * @Classname MultipartEncoder
 * @Description
 * @Date 2019/11/27 14:38
 * @Author xiayun
 */
public class MultipartEncoder extends SpringFormEncoder {

    @SuppressWarnings("unchecked")
    @Override
    public void encode (Object object, Type bodyType, RequestTemplate template) throws EncodeException {
        if (((ParameterizedTypeImpl) bodyType).getRawType().equals(Map.class)) {
            Map<String,Object> data = (Map<String, Object>) object;
            Set<String> nullSet = new HashSet<>();
            for (Map.Entry<String, Object> entry : data.entrySet()) {
                if (entry.getValue() == null) {
                    nullSet.add(entry.getKey());
                }
            }
            for (String s : nullSet) {
                data.remove(s);
            }
            super.encode(data, MAP_STRING_WILDCARD, template);
            return;
        } else if (bodyType.equals(MultipartFile.class)) {
            MultipartFile file = (MultipartFile) object;

            Map<String,Object> data = new HashMap<>();
            data.put(file.getName(), object);
            super.encode(data, MAP_STRING_WILDCARD, template);
            return;
        } else if (bodyType.equals(MultipartFile[].class)) {
            MultipartFile[] file = (MultipartFile[]) object;
            if (file != null) {
                Map<String,Object> data = new HashMap<>();
                data.put(file.length == 0 ? "" : file[0].getName(), object);
                super.encode(data, MAP_STRING_WILDCARD, template);
                return;
            }
        }
        super.encode(object, bodyType, template);
    }

}
