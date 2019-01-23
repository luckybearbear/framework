package com.zj.common.annotation;

import java.lang.annotation.*;

/**
 * 初始化继承BaseService的service
 * @author zj
 * @date 2019/01/23
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BaseService {
}
