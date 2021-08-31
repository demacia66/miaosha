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

    //登录模块

    public static CodeMsg SERVER_ERROR = new CodeMsg(500100,"服务器异常");
    public static CodeMsg BIND_ERROR = new CodeMsg(500101,"参数校验异常:%s");

    public static CodeMsg PASSWORD_EMPTY = new CodeMsg(500211,"密码不能为空");
    public static CodeMsg MOBILE_EMPTY = new CodeMsg(500212,"手机号不能为空");
    public static CodeMsg MOBILE_ERROR = new CodeMsg(500213,"手机号格式错误");
    public static CodeMsg MOBILE_NOT_EXIST = new CodeMsg(500214,"手机号不存在");
    public static CodeMsg PASSWORD_ERROR = new CodeMsg(500215,"密码错误");

    public CodeMsg fillArgs(Object... args){
        int code = this.code;
        String message = String.format(this.msg,args);
        return new CodeMsg(code,message);
    }
}
