package com.xy.image.util;

import com.baidu.aip.imageclassify.AipImageClassify;
import com.xy.image.constants.BaseConstant;
import net.sourceforge.tess4j.Tesseract;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.HashMap;

/**
 * @Classname ImageUtils
 * @Description
 * @Date 2019/11/11 17:22
 * @Author xiayun
 */
@Component
public class ImageUtils {

    @Autowired
    private BaseConstant baseConstant;


    public String advancedGeneral(byte[] bytes) {
        try {

            // 初始化一个AipImageClassify
            AipImageClassify client = AipImageClassifyUtil.getInstance(baseConstant.getBaiduAppID(), baseConstant.getBaiduApiKey(), baseConstant.getBaiduSecretKey());

            // 可选：设置网络连接参数
            client.setConnectionTimeoutInMillis(2000);
            client.setSocketTimeoutInMillis(60000);


            HashMap<String, String> options = new HashMap<>(1);
            options.put("baike_num", "5");

            JSONObject res = client.advancedGeneral(bytes, options);
            System.out.println(res.toString(2));

            return res.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 识别图片中的文本---识别率较低
     * @param imagePath : 图片的路径
     * @param dataPath : testdata包路径，
     * @return
     */
    public static String image2Txt(String imagePath, String dataPath) {
        String result = "";
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath(dataPath);
        //tesseract.setDatapath("D://DataScience//tessdata");
        tesseract.setLanguage("chi_sim");
        try {
            result = tesseract.doOCR(new File(imagePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
