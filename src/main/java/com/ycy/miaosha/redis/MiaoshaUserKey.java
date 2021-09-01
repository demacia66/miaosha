package com.ycy.miaosha.redis;

/**
 * @author ycy
 * @email 615336738@qq.com
 * @create 2021-08-31 9:55 下午
 */
public class MiaoshaUserKey extends BasePrefix {

    public static final int TOKEN_EXPIRE = 3600 * 24 * 2;

    private MiaoshaUserKey(String prefix) {
        super(prefix);
    }

    private MiaoshaUserKey(String prefix,int expireSeconds){
        super(expireSeconds, prefix);
    }


    public static MiaoshaUserKey token = new MiaoshaUserKey("tk",TOKEN_EXPIRE);

}
