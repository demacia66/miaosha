package com.ycy.miaosha.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ycy
 * @email 615336738@qq.com
 * @create 2021-08-13 12:15 上午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CodeMsg {
    private int code;
    private String msg;

    public static CodeMsg SUCCESS = new CodeMsg(0,"success");
    public static CodeMsg SERVER_ERROR = new CodeMsg(500100,"服务器异常");

}
