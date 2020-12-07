package com.yuk.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

/**
 * @author yuk
 * @version 1.0
 * @date 2020/11/12 9:13
 */
public class WebUtils {
    public static <T> T copyParamToBean(Map map, T bean){
        try {
//            System.out.println("注入之前"+bean);
            BeanUtils.populate(bean,map);
//            System.out.println("注入之后"+bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static Integer parseInt(String str,Integer defaultValue){
        if (str==null){
            return defaultValue;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return defaultValue;
    }
}
