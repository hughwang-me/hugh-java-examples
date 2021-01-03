package com.uwjx.easyexceltesting.util;

/**
 * @author Wang Huan
 * @author 18501667737@163.com
 * @date 2021/1/3 21:56
 */
public class TextUtil {

    public static String buildLikeRegex(String key) {
        return "^.*" + key + ".*$";
    }
}
