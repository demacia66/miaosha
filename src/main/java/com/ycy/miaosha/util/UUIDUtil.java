package com.ycy.miaosha.util;

import java.util.UUID;

/**
 * @author ycy
 * @email 615336738@qq.com
 * @create 2021-08-31 9:30 下午
 */
public class UUIDUtil {
    public static String uuid(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
