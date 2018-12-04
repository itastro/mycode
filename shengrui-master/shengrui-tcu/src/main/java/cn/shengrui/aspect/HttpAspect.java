package cn.shengrui.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName httpAspect
 * @Description http请求切面
 * @Date 2018/9/13 8:20
 * @Author itastro
 * @Version 1.0
 **/

@Aspect
@Component
public class HttpAspect {

    private final static Logger LOGGER = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * cn.shengrui.management.controller.*.*(..)))")
    public void http() {
        LOGGER.info("进入请求");

    }


    @Before("http()")
    public void doBefor(JoinPoint joinPoint) {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        LOGGER.info("url:{}", request.getRequestURL());
        //methods
        LOGGER.info("method:{}", request.getMethod());
        //ip
        LOGGER.info("ip:{}", request.getRemoteAddr());
        //类方法
        LOGGER.info("class_method:{}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //参数
        LOGGER.info("args:{}", joinPoint.getArgs());
    }

    @After("http()")
    public void doAfter() {


    }


    /**
     * 拿到返回的参数
     *
     * @param object
     */
    @AfterReturning(returning = "object", pointcut = "http()")
    public void doAfterReturning(Object object) {
        LOGGER.info("reponse={}", object.toString());
    }

}
