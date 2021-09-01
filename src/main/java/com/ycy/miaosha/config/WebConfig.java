package com.ycy.miaosha.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * @author ycy
 * @email 615336738@qq.com
 * @create 2021-09-01 11:52 下午
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private UserArgumentResolver userArgumentResolver;

    //向controller的数据进行赋值

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(userArgumentResolver);
    }
}
