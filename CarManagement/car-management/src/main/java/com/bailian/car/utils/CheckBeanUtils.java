package com.bailian.car.utils;

import java.lang.reflect.Field;

public class CheckBeanUtils {

	public static boolean isAllFieldNull(Object obj) {
		Class<? extends Object> stuCla = (Class<? extends Object>) obj.getClass();// 得到类对象
		Field[] fs = stuCla.getDeclaredFields();// 得到属性集合
		boolean flag = true;
		for (Field f : fs) {// 遍历属性
			f.setAccessible(true); // 设置属性是可以访问的(私有的也可以)
			Object val;
			try {
				val = f.get(obj);
				if (val == null) {// 只要有1个属性为空,返回false
					flag = false;
					break;
				}
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 得到此属性的值

		}
		return flag;
	}

}
