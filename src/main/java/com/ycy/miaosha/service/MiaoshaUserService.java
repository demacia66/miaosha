package com.ycy.miaosha.service;

import com.ycy.miaosha.dao.MiaoshaUserMapper;
import com.ycy.miaosha.entity.MiaoshaUser;
import com.ycy.miaosha.exception.GlobalException;
import com.ycy.miaosha.redis.MiaoshaUserKey;
import com.ycy.miaosha.redis.RedisService;
import com.ycy.miaosha.result.CodeMsg;
import com.ycy.miaosha.util.MD5Util;
import com.ycy.miaosha.util.UUIDUtil;
import com.ycy.miaosha.vo.LoginVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ycy
 * @email 615336738@qq.com
 * @create 2021-08-15 11:17 下午
 */
@Service
public class MiaoshaUserService {

    public static final String COOKIE_NAME_TOKEN = "token";

    @Autowired
    private MiaoshaUserMapper miaoshaUserMapper;

    @Autowired
    private RedisService redisService;

    public MiaoshaUser getById(Long id){
        return miaoshaUserMapper.getById(id);
    }

    public boolean login(HttpServletResponse response,LoginVo loginVo) {
        if (loginVo == null){
//            return CodeMsg.SERVER_ERROR;
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }
        String mobileNo = loginVo.getMobile();
        String formPass = loginVo.getPassword();
        //判断手机号是否存在
        MiaoshaUser user = getById(Long.valueOf(mobileNo));
        if (user == null){
            throw  new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
        }
        //验证密码
        String dbPassword = user.getPassword();
        String salt = user.getSalt();
        String calPass = MD5Util.formPassToDBPass(formPass, salt);
        if (!dbPassword.equals(calPass)){
            throw new GlobalException(CodeMsg.PASSWORD_ERROR);
        }
        addCookie(response,user);
        return true;
    }


    private void addCookie(HttpServletResponse response,MiaoshaUser user){
        //生成cookie
        String token = UUIDUtil.uuid();
        redisService.set(MiaoshaUserKey.token,token,user);
        Cookie cookie = new Cookie(COOKIE_NAME_TOKEN,token);
        cookie.setMaxAge(MiaoshaUserKey.token.expiredSeconds());
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    public MiaoshaUser getByToken(HttpServletResponse response,String token) {
        if (StringUtils.isEmpty(token)){
            return null;
        }
        MiaoshaUser user = redisService.get(MiaoshaUserKey.token, token, MiaoshaUser.class);
        //延长有效期
        if (user != null){
            addCookie(response,user);
        }
        return user;
    }


}
