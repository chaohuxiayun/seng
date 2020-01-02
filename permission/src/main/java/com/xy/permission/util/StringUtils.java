package com.xy.permission.util;

/**
 * @author xiayun
 * @version V1.0.0
 * @description StringUtils
 * @date   2019/12/11 13:19
 */
public class StringUtils {

    public static boolean isEmpty(String str) {
        if (str == null || str.equals("")) {
            return true;
        }
        return false;
    }

}
