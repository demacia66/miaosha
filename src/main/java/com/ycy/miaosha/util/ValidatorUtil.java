package com.ycy.miaosha.util;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ycy
 * @email 615336738@qq.com
 * @create 2021-08-15 11:03 下午
 */
public class ValidatorUtil {

    private static final Pattern MOBILE_PATTERN = Pattern.compile("1\\d{10}");


    public static boolean isMobile(String src){
        if (StringUtils.isEmpty(src)){
            return false;
        }
        Matcher m = MOBILE_PATTERN.matcher(src);
        return m.matches();
    }

    public static void main(String[] args) {
        System.out.println(isMobile("11213224423"));
    }
}
