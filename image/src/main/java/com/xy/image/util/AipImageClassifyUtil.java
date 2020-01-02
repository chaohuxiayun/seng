package com.xy.image.util;

import com.baidu.aip.imageclassify.AipImageClassify;

/**
 * @Classname AipImageClassifyUtil
 * @Description
 * @Date 2019/11/18 10:27
 * @Author xiayun
 */
public class AipImageClassifyUtil {

    private static AipImageClassify client = null;

    private static boolean tokenIsUseAble = false;

    private AipImageClassifyUtil(){
    }

    public static AipImageClassify getInstance(String appId,String baiduApiKey ,String baiduSecretKey){

        if(client == null) {
            synchronized (AipImageClassifyUtil.class) {
                if(client == null) {
                    client = new AipImageClassify(appId, baiduApiKey, baiduSecretKey);
                }
            }
        }
        return client;
    }

}
