package com.ycy.miaosha.dao;

import com.ycy.miaosha.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author ycy
 */
@Mapper
@Repository
public interface UserMapper {

    /**
     * 通过id得到user
     * @param id 用户id
     * @return user信息
     */
    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id") Integer id);

    @Insert("insert into user(id,name) values(#{id},#{name})")
    int insert(User user);
}
