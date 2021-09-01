package com.ycy.miaosha.controller;

import com.ycy.miaosha.entity.MiaoshaUser;
import com.ycy.miaosha.redis.RedisService;
import com.ycy.miaosha.service.MiaoshaUserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;


/**
 * @author ycy
 * @email 615336738@qq.com
 * @create 2021-08-31 10:11 下午
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private RedisService redisService;

    @Autowired
    private MiaoshaUserService userService;

    private static Logger log = LoggerFactory.getLogger(GoodsController.class);

    @RequestMapping("/to_list")
    public String list(Model model, MiaoshaUser user) {
//        if (StringUtils.isEmpty(token) && StringUtils.isEmpty(paramToken)){
//            return "login";
//        }
//        String finalToken = StringUtils.isEmpty(paramToken)? token : paramToken;
//        MiaoshaUser user = userService.getByToken(response,finalToken);
        model.addAttribute("user",user);
        return "goods_list";
    }



}
