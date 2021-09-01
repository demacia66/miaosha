package com.ycy.miaosha.service;

import com.ycy.miaosha.dao.UserMapper;
import com.ycy.miaosha.entity.MiaoshaUser;
import com.ycy.miaosha.entity.User;
import com.ycy.miaosha.redis.MiaoshaUserKey;
import com.ycy.miaosha.redis.RedisService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ycy
 * @email 615336738@qq.com
 * @create 2021-08-15 9:55 上午
 */
@Service
public class UserService {

    @Autowired
    private UserMapper mapper;

    @Autowired
    private RedisService redisService;

    public User getByUserId(Integer id){
        return mapper.getUserById(id);
    }


    @Transactional(rollbackFor = Exception.class)
    public boolean tx(){
        User user1 = new User();
        user1.setId(2);
        user1.setName("2222");
        mapper.insert(user1);
        User user2= new User();
        user2.setId(1);
        user2.setName("1111");
        mapper.insert(user2);
        return true;
    }

    public MiaoshaUser getByToken(String token) {
        if (StringUtils.isEmpty(token)){
            return null;
        }
        MiaoshaUser user = redisService.get(MiaoshaUserKey.token, token, MiaoshaUser.class);
        //延长有效期

        return user;
    }
}
