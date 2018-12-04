package cn.shengrui.common.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component("applicationContextHelper")
public class ApplicationContextHelper implements ApplicationContextAware {
	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		// TODO Auto-generated method stub
		applicationContext = context;
	}

	public static <T> T popBean(Class<T> claszz) {
		if (applicationContext == null) {
			return null;
		}
		return applicationContext.getBean(claszz);
	}

	public static <T> T popBean(String name, Class<T> clazz) {
		if (applicationContext == null) {
			return null;
		}
		return applicationContext.getBean(name,clazz);
	}
}
