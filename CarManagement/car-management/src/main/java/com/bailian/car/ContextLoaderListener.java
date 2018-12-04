package com.bailian.car;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
public class ContextLoaderListener implements ServletContextListener{
	
	
	//InitializingBean ,ServletConfigAware
	
    private String code1;
	
	private String code2;	

	public String getCode1() {
		return code1;
	}

	public void setCode1(String code1) {
		this.code1 = code1;
	}

	public String getCode2() {
		return code2;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
	}

	public BlockingQueue<String> queue = new  LinkedBlockingQueue<String>();
	

	
	public BlockingQueue<String> getQueue() {
		return queue;
	}
 
	public void setQueue(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	// 实现全局上下文初始化方法
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		ServletContext servletContext = sce.getServletContext();
		//设置全局变量
		servletContext.setAttribute("code1", "0");
		servletContext.setAttribute("code2", "0");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
		//销毁全局变量
		sce.getServletContext().removeAttribute(code1);
		sce.getServletContext().removeAttribute(code2);
		
	}


}
