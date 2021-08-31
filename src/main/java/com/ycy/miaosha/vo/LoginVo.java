package com.ycy.miaosha.vo;

import com.ycy.miaosha.validator.isMobile;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @author ycy
 * @email 615336738@qq.com
 * @create 2021-08-15 10:48 下午
 */
@Data
public class LoginVo {

    @NotNull
    @isMobile
    private String mobile;

    @NotNull
    @Length(min = 32)
    private String password;
}
