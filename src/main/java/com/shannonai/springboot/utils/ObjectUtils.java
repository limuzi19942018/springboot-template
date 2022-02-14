package com.shannonai.springboot.utils;

import cn.hutool.core.util.StrUtil;

import java.util.UUID;

/**
 * 对象工具类
 *
 * @author ligang
 * @create 2020-10-14 9:51
 */
public class ObjectUtils {

    /**
     * 获取UUID
     * @return
     */
    public static String getShortUuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * object转字符串
     * @return
     */
    public static String nullToStr(Object obj) {
        String objStr = String.valueOf(obj);
        if (StrUtil.isBlank(objStr) || "null".equals(objStr)) {
            return "";
        }
        return objStr.trim();
    }

    /**
     * object转字符串
     * @return
     */
    public static String nullToStrDecimal(Object obj) {
        String objStr = String.valueOf(obj);
        if (StrUtil.isBlank(objStr) || "null".equals(objStr)) {
            return "";
        }
        return objStr.trim()+"%";
    }

}


