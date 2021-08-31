package com.ycy.miaosha.validator;

import com.ycy.miaosha.util.ValidatorUtil;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author ycy
 * @email 615336738@qq.com
 * @create 2021-08-19 11:11 下午
 */
//校验器
public class isMobileValidator implements ConstraintValidator<isMobile, String> {

    private boolean required = false;

    @Override
    public void initialize(isMobile isMobile) {
        required = isMobile.required();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (required) {
            //值是必须的
            return ValidatorUtil.isMobile(s);
        } else {

            if (StringUtils.isEmpty(s)) {
                return true;
            } else {
                return ValidatorUtil.isMobile(s);
            }
        }

    }
}
