package com.ycy.miaosha.service;

import com.ycy.miaosha.dao.UserMapper;
import com.ycy.miaosha.entity.User;
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

}
