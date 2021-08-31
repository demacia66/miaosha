package com.ycy.miaosha.controller;
import com.ycy.miaosha.result.CodeMsg;
import com.ycy.miaosha.result.Result;
import com.ycy.miaosha.service.MiaoshaUserService;
import com.ycy.miaosha.vo.LoginVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author ycy
 * @email 615336738@qq.com
 * @create 2021-08-15 10:18 下午
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private MiaoshaUserService userService;

    private static Logger log = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/to_login")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/do_login")
    @ResponseBody
    //注解进行校验
    public Result<Boolean> doLogin(@Validated LoginVo loginVo){
        log.info(loginVo.toString());
//        //参数校验
//        String passInput = loginVo.getPassword();
//        String mobile = loginVo.getMobile();
//        if (StringUtils.isEmpty(passInput)){
//            return Result.error(CodeMsg.PASSWORD_EMPTY);
//        }
//        if (StringUtils.isEmpty(mobile)){
//            return Result.error(CodeMsg.MOBILE_ERROR);
//        }

        //登录
        userService.login(loginVo);
//        if (cm.getCode() == 0){
//            return Result.success(true);
//        }else {
//            return Result.error(cm);
//        }
        return Result.success(true);
    }

}
