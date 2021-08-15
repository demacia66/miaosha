package com.ycy.miaosha.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author ycy
 * @email 615336738@qq.com
 * @create 2021-08-15 10:02 下午
 */
public class MD5Util {

    public static String md5(String src){
        return DigestUtils.md5Hex(src);
    }

    //盐

    private static final String SALT = "1a2b3c4d";

    /**
     * 第一次md5
     * @param inputPass 输入的密码
     * @return 结果
     */
    public static String inputPassFormPass(String inputPass){
        String str = "" + SALT.charAt(0) + SALT.charAt(2) + inputPass + SALT.charAt(5) + SALT.charAt(4);
        return md5(str);
    }

    public static String formPassToDBPass(String inputPass,String salt){
        String str = "" + salt.charAt(0) + salt.charAt(2) + inputPass + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }

    /**
     * 从表单到数据库密码
     * @param inputPass 表单上的密码
     * @param salt 盐
     * @return 加密后的密码
     */
    public static String inputPassToDBPass(String inputPass,String salt){
        String str = inputPassFormPass(inputPass);
        return formPassToDBPass(str,salt);
    }

    public static void main(String[] args) {
//        System.out.println(inputPassFormPass("123456"));
        //d3b1294a61a07da9b49b6e22b2cbd7f9

        System.out.println(inputPassToDBPass("123456","1a2b3c4d"));
    }

}
