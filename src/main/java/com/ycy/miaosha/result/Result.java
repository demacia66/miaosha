package com.ycy.miaosha.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ycy
 * @email 615336738@qq.com
 * @create 2021-08-13 12:07 上午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private int code;
    private String msg;
    private T data;

    private Result(T data) {
        this.code = 0;
        this.msg = "success";
        this.data = data;
    }

    //private防止访问
    private Result(CodeMsg cm) {
        if (cm == null){
            return;
        }
        this.msg = cm.getMsg();
        this.code = cm.getCode();
    }

    /**
     * 成功时候的调用
     * @param <T>
     * @return
     */
    public static<T> Result<T> success(T data){
        return new Result<T>(data);
    }

    /**
     * 失败时候的调用
     * @param <T>
     * @return
     */
    public static<T> Result<T> error(CodeMsg cm){
        return new Result<T>(cm);
    }

}
