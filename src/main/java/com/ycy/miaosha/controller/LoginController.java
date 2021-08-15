package com.ycy.miaosha.controller;

import com.ycy.miaosha.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ycy
 * @email 615336738@qq.com
 * @create 2021-08-15 10:18 下午
 */
@Controller
public class LoginController {

    @RequestMapping("/to_login")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/do_login")
    public Result<Boolean> error(){
        return null;
    }

}
