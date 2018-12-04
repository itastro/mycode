package com.bl.station.SecurityManager;

import com.bl.station.constant.SysConstant;
import com.bl.station.entity.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class TokenManger {


    //获取session
    private static HttpSession getSession() {
        HttpSession session = null;
        try {
            session = getRequest().getSession();
        } catch (Exception e) {
        }
        return session;
    }

    //获取request域
    public static HttpServletRequest getRequest() {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attrs.getRequest();
    }


    //获取当前登录的用户
    public static User getToken() {
        User user = (User) getSession().getAttribute("user");
        return user;
    }

    //设置用户的session
    public static void setUser(User user) {
        getSession().setAttribute(SysConstant.USER, user);

    }

    //删除用户的session
    public static void removeUser() {
        HttpSession session = getSession();
        session.removeAttribute(SysConstant.USER);
        session.invalidate();
    }
}
