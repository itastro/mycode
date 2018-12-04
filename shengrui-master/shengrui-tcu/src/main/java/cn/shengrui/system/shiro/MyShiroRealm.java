package cn.shengrui.system.shiro;

import cn.shengrui.common.constant.SysUserConstant;
import cn.shengrui.system.entity.SysAcl;
import cn.shengrui.system.entity.SysRole;
import cn.shengrui.system.entity.SysUser;
import cn.shengrui.system.mapper.SysAclMapper;
import cn.shengrui.system.mapper.SysRoleMapper;
import cn.shengrui.system.mapper.SysUserMapper;
import cn.shengrui.system.service.SysCoreService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName MyShiroRealm
 * @Description 自定义shiroReam
 * @Date 2018/10/7 23:45
 * @Author itastro
 * @Version 1.0
 **/
public class MyShiroRealm extends AuthorizingRealm {
    private final static Logger LOGGER = LoggerFactory.getLogger(MyShiroRealm.class);



    @Resource
    private SysCoreService sysCoreService;

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Resource
    private SysAclMapper sysAclMapper;

    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        //授权
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //获取当前的用户
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        if (SysUserConstant.USERNAME.equals(sysUser.getUsername())) {
            List<SysRole> sysRoles = sysRoleMapper.findAllRole();
            for (SysRole sysRole : sysRoles) {
                authorizationInfo.addRole(sysRole.getKeyword());
            }

            List<SysAcl> sysAcls = sysAclMapper.findAll();
            for (SysAcl sysAcl : sysAcls) {
                authorizationInfo.addStringPermission(sysAcl.getKeyword());
            }

        } else {
            //调用业务层查询角色
            List<SysRole> roles = (List<SysRole>) sysCoreService.userInRole(sysUser.getId()).getData();
            for (SysRole sysRole : roles) {
                //添加角色
                authorizationInfo.addRole(sysRole.getKeyword());
            }
            //调用业务成查询权限
            List<SysAcl> acls = (List<SysAcl>) sysCoreService.userInAcl(sysUser.getId()).getData();
            for (SysAcl sysAcl : acls) {
                authorizationInfo.addStringPermission(sysAcl.getKeyword());
            }
        }
        return authorizationInfo;
    }


    /**
     * 认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //初始用户为null
        //初始用户为null
        SysUser sysUser = null;
        //根据用名查询用户
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String userName = usernamePasswordToken.getUsername();
        //查询用户
        sysUser = sysUserMapper.selectByUsername(userName);
        // 判空  防止空指针
        if (sysUser == null) {
            return null;
        }
        //如果用户的状态被冻结 抛出异常
        if (sysUser.getStatus() == 0) {
            throw new LockedAccountException();
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                sysUser,
                sysUser.getPassword(),
                this.getClass().getName()
        );
        return authenticationInfo;
    }
}
