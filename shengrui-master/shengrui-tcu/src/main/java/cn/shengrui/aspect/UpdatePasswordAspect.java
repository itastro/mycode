package cn.shengrui.aspect;

import cn.shengrui.common.enums.ResultEnum;
import cn.shengrui.common.exception.ParamException;
import cn.shengrui.common.exception.SystemException;
import cn.shengrui.system.entity.SysUser;
import cn.shengrui.system.service.SysUserService;
import cn.shengrui.system.shiro.ShiroUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName UpdateUserAspect
 * @Description TODO
 * @Date 2018/10/24 16:35
 * @Author itastro
 * @Version 1.0
 **/

@Aspect
@Component
public class UpdatePasswordAspect {


    @Autowired
    private HttpServletRequest request;
    @Autowired
    private SysUserService sysUserService;

    private final static Logger LOGGER = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * cn.shengrui.system.controller.SysUserController.updatePassword(..)))")
    public void updatePassword() {
        LOGGER.info("进入请求");

    }


    @Before("updatePassword()")
    public void doBefor(JoinPoint joinPoint) {

        SysUser sysUser = (SysUser) ShiroUtils.getSubject().getPrincipal();

        if (sysUser == null) {
            throw new SystemException(ResultEnum.NOLOGIN_ERROR);
        }
        Object[] strings = joinPoint.getArgs();
        String username = (String) strings[0];
        if (StringUtils.isBlank(username)) {
            throw new ParamException(ResultEnum.PARAMS_ERROR);
        }
        //参数
        LOGGER.info("telephone:{}", username);
        if (!username.equals(sysUser.getUsername())) {
            throw new SystemException(ResultEnum.UPDATE_PASS_ERROR);
        }


    }

    @After("updatePassword()")
    public void doAfter() {


    }

    /**
     * 拿到返回的参数
     *
     * @param object
     */
    @AfterReturning(returning = "object", pointcut = "updatePassword()")
    public void doAfterReturning(Object object) {

    }
}
