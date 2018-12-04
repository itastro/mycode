package com.bailian.car.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

import com.bailian.car.domain.system.User;
import com.bailian.car.exception.PermissionException;;

public class TokenManagerUtils {
	/*
	 * 获取当前登录的用户User对象
	 * 
	 * @return
	 */
	public static User getToken() {
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		return user;
	}

	/**
	 * 获取当前用户的Session
	 * @return
	 */
	public static Session getSession() {
		return SecurityUtils.getSubject().getSession();
	}

	/**
	 * 获取当前用户NAME
	 * @return
	 */
	public static String getNickname() {
		try {
			return getToken().getNickname();
		} catch (Exception e) {
			//throw new PermissionException("请进行登陆");
			return null;
		}

	}

	/**
	 * 获取当前用户ID
	 * @return
	 */
	public static Integer getUserId() {
		return getToken() == null ? null : getToken().getUid();
	}

	/**
	 * 把值放入到当前登录用户的Session里
	 * @param key
	 * @param value
	 */
	public static void setVal2Session(Object key, Object value) {
		getSession().setAttribute(key, value);
	}

	/**
	 * 从当前登录用户的Session里取值
	 * @param key
	 * @return
	 */
	public static Object getVal2Session(Object key) {
		return getSession().getAttribute(key);
	}

	/**
	 * 获取验证码，获取一次后删除
	 * @return
	 */
	public static String getYZM() {
		String code = (String) getSession().getAttribute("code");
		getSession().removeAttribute("code");
		return code;
	}

	/**
	 * 判断是否登录
	 * @return
	 */
	public static boolean isLogin() {
		return null != SecurityUtils.getSubject().getPrincipal();
	}

	/**
	 * 退出登录
	 */
	public static void logout() {
		SecurityUtils.getSubject().logout();
	}

}
