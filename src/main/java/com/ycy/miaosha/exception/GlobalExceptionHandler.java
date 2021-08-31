package com.ycy.miaosha.exception;

import com.ycy.miaosha.result.CodeMsg;
import com.ycy.miaosha.result.Result;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * @author ycy
 * @email 615336738@qq.com
 * @create 2021-08-19 11:32 下午
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result<String> exceptionHandler(HttpServletRequest request, Exception e) {
        if (e instanceof GlobalException) {
            GlobalException ex = (GlobalException) e;
            CodeMsg cm = ex.getCm();
            return Result.error(ex.getCm());
        } else if (e instanceof BindException) {
            //绑定异常
            BindException bex = (BindException) e;
            List<ObjectError> errors = bex.getAllErrors();
            ObjectError error = errors.get(0);
            String msg = error.getDefaultMessage();
            return Result.error(CodeMsg.BIND_ERROR.fillArgs(msg));
        } else {
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }
}
