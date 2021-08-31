package com.ycy.miaosha.service;

import com.ycy.miaosha.dao.MiaoshaUserMapper;
import com.ycy.miaosha.entity.MiaoshaUser;
import com.ycy.miaosha.exception.GlobalException;
import com.ycy.miaosha.result.CodeMsg;
import com.ycy.miaosha.util.MD5Util;
import com.ycy.miaosha.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ycy
 * @email 615336738@qq.com
 * @create 2021-08-15 11:17 下午
 */
@Service
public class MiaoshaUserService {

    @Autowired
    private MiaoshaUserMapper miaoshaUserMapper;

    public MiaoshaUser getById(Long id){
        return miaoshaUserMapper.getById(id);
    }

    public boolean login(LoginVo loginVo) {
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
        return true;
    }
}
