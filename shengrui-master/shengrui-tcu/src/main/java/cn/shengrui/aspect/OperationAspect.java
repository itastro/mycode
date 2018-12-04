package cn.shengrui.aspect;

import cn.shengrui.common.annotation.OperationLog;
import cn.shengrui.common.enums.OperationType;
import cn.shengrui.common.enums.ResultEnum;
import cn.shengrui.common.exception.PermissionException;
import cn.shengrui.common.util.IpUtil;
import cn.shengrui.management.entity.TOperationLog;
import cn.shengrui.management.service.OperationLogService;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @ClassName 操作日志拦截切面
 * @Description 操作日志请求切面
 * @Date 2018/10/16 12:28
 * @Author itastro
 * @Version 1.0
 **/

@Aspect
@Component
public class OperationAspect {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private OperationLogService operationLogService;

    private final static Logger LOGGER = LoggerFactory.getLogger(OperationAspect.class);

    @Pointcut("execution(public * cn.shengrui.*.controller.*.*(..)))")
    public void operationLog() {
        LOGGER.info("进入切面");

    }


    @Before("operationLog()")
    public void doBefor(JoinPoint joinPoint) {

        LOGGER.info("进行参数初始化");

    }


    @Around("operationLog()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Object obj = null;
        Method method = this.getMethod(pjp);
        //判断这个方法是否为空

        if (method == null) {
            obj = pjp.proceed();
            return obj;
        }
        //判断这个方法有没有注解
        if (!method.isAnnotationPresent(OperationLog.class)) {
            obj = pjp.proceed();
            return obj;
        }
        try {
            TOperationLog tOperationLog = new TOperationLog();
            obj = pjp.proceed();
            saveLog(pjp, tOperationLog);
        } catch (PermissionException e) {
            TOperationLog tOperationLog = new TOperationLog();
            obj = pjp.proceed();
            saveLog(pjp, tOperationLog);
        }
        return obj;
    }

    /**
     * 保存日志
     *
     * @param pjp
     * @param tOperationLog
     * @throws Exception
     */
    private void saveLog(ProceedingJoinPoint pjp, TOperationLog tOperationLog) throws Exception {
        tOperationLog.setOperateTime(new Date());
        tOperationLog.setOperator("admin");
        tOperationLog.setOperateIp(IpUtil.getUserIP(request));
        tOperationLog.setAction(this.getControllerMethod(pjp));
        tOperationLog.setActionType(this.getControllerType(pjp).toString());
        operationLogService.save(tOperationLog);
    }

    @After("operationLog()")
    public void doAfter() {
        LOGGER.info("执行后");

    }


    /**
     * 拿到返回的参数
     *
     * @param object
     */
    @AfterReturning(returning = "object", pointcut = "operationLog()")
    public void doAfterReturning(Object object) {
        LOGGER.info("reponse={}", object.toString());
    }


    /**
     * 获取拦截到的方法
     *
     * @param joinPoint
     * @return
     */
    public Method getMethod(JoinPoint joinPoint) {
        // 拦截实体类，就是当前正在执行Controller
        Object target = joinPoint.getTarget();
        // 拦截方法的名称 ，当前正在执行的方法
        String methodName = joinPoint.getSignature().getName();
        // 拦截方法的参数类型
        Signature sig = joinPoint.getSignature();

        MethodSignature msig = null;

        if (!(sig instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        // 获取方法的参数类型
        msig = (MethodSignature) sig;
        Class[] parameterTypes = msig.getMethod().getParameterTypes();
        // 获得被拦截的方法
        Method method = null;
        try {
            method = target.getClass().getMethod(methodName, parameterTypes);
            return method;
        } catch (NoSuchMethodException e1) {
            throw new PermissionException(ResultEnum.UNKONW_ERROR);

        } catch (SecurityException e1) {
            // TODO: handle exception
            throw new PermissionException(ResultEnum.UNKONW_ERROR);
        }
    }


    /**
     * 获取方法名称
     *
     * @param joinPoint
     * @return
     * @throws Exception
     */
    private String getControllerMethod(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String meth = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    meth = method.getAnnotation(OperationLog.class).action();
                    break;
                }
            }
        }
        return meth;
    }


    /**
     * 获取操作类型
     *
     * @param joinPoint
     * @return
     * @throws Exception
     */
    private OperationType getControllerType(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        OperationType type = null;
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    type = method.getAnnotation(OperationLog.class).type();
                    break;
                }
            }
        }
        return type;
    }
}
