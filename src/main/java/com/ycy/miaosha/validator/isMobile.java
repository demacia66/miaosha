package com.ycy.miaosha.validator;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author ycy
 * @email 615336738@qq.com
 * @create 2021-08-19 11:04 下午
 */
//自定义校验

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = {isMobileValidator.class}
)
public @interface isMobile {

    //是否可以为空
    boolean required() default true;

    //没有通过报错
    String message() default "手机号码格式错误";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
