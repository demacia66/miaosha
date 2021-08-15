package com.ycy.miaosha.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author ycy
 * @email 615336738@qq.com
 * @create 2021-08-15 11:10 下午
 */
@Data
public class MiaoshaUser {
    private Long id;
    private String nickname;
    private String password;
    private String salt;
    private String head;
    private Date registerDate;
    private Date lastLoginDate;
    private Integer loginCount;
}
