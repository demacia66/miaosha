package com.ycy.miaosha.controller;

import com.ycy.miaosha.entity.User;
import com.ycy.miaosha.redis.RedisService;
import com.ycy.miaosha.redis.UserKey;
import com.ycy.miaosha.result.Result;
import com.ycy.miaosha.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ycy
 * @email 615336738@qq.com
 * @create 2021-08-15 9:42 上午
 */
@Controller
@RequestMapping("/test")
@Slf4j
public class TestController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisService redisService;

    @GetMapping("/db/get")
    @ResponseBody
    public Result<User> dbGet(Integer id) {
        User user = userService.getByUserId(id);
        log.info(user.toString());
        return Result.success(user);
    }

    @GetMapping("/db/insert")
    @ResponseBody
    public Result<Boolean> dbTx() {
        boolean tx = userService.tx();
        return Result.success(true);
    }

    @GetMapping("/redis/get")
    @ResponseBody
    public Result<User> redisGet(){
        User user = redisService.get(UserKey.getById ,"1",User.class);
        return Result.success(user);
    }

    @GetMapping("/redis/set")
    @ResponseBody
    public Result<Boolean> redisSet(){
        User user = new User(1,"ycy");
        boolean result = redisService.set(UserKey.getById,"1", user);
        return Result.success(result);
    }
}
