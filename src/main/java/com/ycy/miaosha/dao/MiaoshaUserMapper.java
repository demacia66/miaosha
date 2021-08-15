package com.ycy.miaosha.dao;

/**
 * @author ycy
 * @email 615336738@qq.com
 * @create 2021-08-15 11:13 下午
 */

import com.ycy.miaosha.entity.MiaoshaUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
@Repository
@Mapper
public interface MiaoshaUserMapper {

    /**
     *
     * @param id 手机号
     * @return 用户信息
     */
    @Select(("select * from miaosha_user where id = #{id}"))
    MiaoshaUser getById(@Param("id") long id);


}
