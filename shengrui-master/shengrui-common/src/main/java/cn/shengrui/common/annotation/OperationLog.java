package cn.shengrui.common.annotation;

import cn.shengrui.common.enums.OperationType;

import java.lang.annotation.*;

/**
 * @ClassName OperationLog
 * @Description 自定义操作日志注解
 * @Date 2018/10/16 11:12
 * @Author itastro
 * @Version 1.0
 **/

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OperationLog {

    String medoule() default "";

    String action() default "";

    OperationType type() ;


}
