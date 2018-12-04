package com.bailian.car.annotation;

import java.lang.annotation.*;

import com.bailian.car.emnu.OperationType;

/**
 * 
 * @ClassName: SystemLog
 * @Description: 自定义日志注解类
 * @author itastro
 * @date 2018年2月2日
 *
 */

@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemLog {

	String medoule() default "";

	String methods() default "";

	OperationType type() ;

}
