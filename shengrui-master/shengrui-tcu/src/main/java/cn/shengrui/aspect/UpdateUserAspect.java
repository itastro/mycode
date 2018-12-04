package cn.shengrui.aspect;

import cn.shengrui.common.constant.SysUserConstant;
import cn.shengrui.common.enums.ResultEnum;
import cn.shengrui.common.exception.SystemException;
import cn.shengrui.param.SysUserParam;
import cn.shengrui.system.entity.SysUser;
import cn.shengrui.system.mapper.SysUserMapper;
import cn.shengrui.system.shiro.ShiroUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @ClassName UpdateUserAspect
 * @Description 更新用户信息切面
 * @Date 2018/10/25 9:57
 * @Author itastro
 * @Version 1.0
 **/
@Component
@Aspect
public class UpdateUserAspect {


    @Autowired
    private SysUserMapper sysUserMapper;

    private final static Logger LOGGER = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * cn.shengrui.system.controller.UserController.userupdate(..)))")
    public void updateuser() {
        LOGGER.info("进入请求");

    }


    @Before("updateuser()")
    public void doBefor(JoinPoint joinPoint) {

        SysUser sysUser = (SysUser) ShiroUtils.getSubject().getPrincipal();
        if (sysUser == null) {
            throw new SystemException(ResultEnum.NOLOGIN_ERROR);
        }
        if (sysUser.getUsername().equals(SysUserConstant.USERNAME)) {
            throw new SystemException(ResultEnum.UPDATE_ERROR);
        }
        Object[] objects = joinPoint.getArgs();
        Object o = objects[0];
        SysUserParam sysUserParam = (SysUserParam) o;
        //sysUser.setUsername(sysUserParam.getUsername());
        sysUser.setNickname(sysUserParam.getNickname());
        sysUserMapper.updateByPrimaryKeySelective(sysUser);
    }

    @After("updateuser()")
    public void doAfter() {


    }

    /**
     * 拿到返回的参数
     *
     * @param object
     */
    @AfterReturning(returning = "object", pointcut = "updateuser()")
    public void doAfterReturning(Object object) {

    }
}
