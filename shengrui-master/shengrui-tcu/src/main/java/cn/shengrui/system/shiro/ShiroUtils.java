package cn.shengrui.system.shiro;

import cn.shengrui.common.constant.SysUserConstant;
import cn.shengrui.common.enums.ResultEnum;
import cn.shengrui.common.exception.SystemException;
import cn.shengrui.common.util.HttpContextUtils;
import cn.shengrui.system.entity.SysUser;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;


/**
 * @ClassName ShiroUtils
 * @Description TODO
 * @Date 2018/10/12 15:28
 * @Author itastro
 * @Version 1.0
 **/
public class ShiroUtils {


    @Autowired
    private HttpServletRequest request;

    public static HttpServletRequest getRequest() {
        return HttpContextUtils.getHttpServletRequest();
    }

    /**
     * 加密算法
     */
    public final static String hashAlgorithmName = "SHA-256";
    /**
     * 循环次数
     */
    public final static int hashIterations = 16;

    public static String sha256(String password, String salt) {
        return new SimpleHash(hashAlgorithmName, password, salt, hashIterations).toString();
    }

    /**
     * 获取session
     *
     * @return
     */
    public static Session getSession() {

        return SecurityUtils.getSubject().getSession();

    }

    /**
     * 获取主体
     *
     * @return
     */
    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    /**
     * 获取当前用户
     *
     * @return
     */
    public static SysUser getUserEntity() {
        return (SysUser) SecurityUtils.getSubject().getPrincipal();
    }

    public static String getUserName() {
        SysUser sysUser = getUserEntity();
        SysUser sysUser1 = (SysUser) getRequest().getSession().getAttribute("user");
        if (sysUser != null) {
            return sysUser.getUsername();
        } else if (sysUser1 != null) {

            return sysUser1.getUsername();
        }
        return "未登录";
    }

    /**
     * 获取用户id
     *
     * @return id
     */
    public static Integer getUserId() throws Exception{

            return getUserEntity().getId();

    }

    /**
     * 设置session
     *
     * @param key
     * @param value
     */
    public static void setSessionAttribute(Object key, Object value) {
        getSession().setAttribute(key, value);
    }

    /**
     * 获取session
     *
     * @param key
     * @return
     */
    public static Object getSessionAttribute(Object key) {
        return getSession().getAttribute(key);
    }

    /**
     * 判断用户是否登录
     *
     * @return
     */
    public static boolean isLogin() {
        return SecurityUtils.getSubject().getPrincipal() != null;
    }

    /**
     * 用户退出
     */
    public static void logout() {
        SecurityUtils.getSubject().logout();
    }


    public static boolean supUser() {
        try {
            SysUser sysUser = getUserEntity();
            if (sysUser.getUsername().equals(SysUserConstant.USERNAME)) {
                return true;
            }
            return false;
        } catch (SystemException ex) {

            throw new SystemException(ResultEnum.NOLOGIN_ERROR);
        }

    }

    public static void main(String[] args) {
        String usname = "admin";
        String password = ShiroUtils.sha256("15691812098", SysUserConstant.SALT);

        System.out.println(password);
    }
}
