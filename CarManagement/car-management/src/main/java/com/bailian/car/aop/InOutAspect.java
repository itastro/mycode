package com.bailian.car.aop;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.bailian.car.common.LedResult;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Aspect
public class InOutAspect  extends HttpServlet{
	 private final static Logger LOGGER = LoggerFactory.getLogger(InOutAspect.class);
	String code1="";
	String code2="";
	String Io="";
	
    LedResult ledResult;
    
    Long cruenttime;
    
    Long lasttime;
	
	  /**
	    * @Fields field:field:{todo}(用一句话描述这个变量表示什么)
	    */
	    
	private static final long serialVersionUID = 1L;
	    
	    @Pointcut(("execution(* com.bailian.car.controller.iccard.IccardController.searchAuth())"))
		private void inOut() {

		}
	    
	    @Before("inOut()")
	    public void doBefor(JoinPoint joinPoint) {

	        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	        HttpServletRequest request = attributes.getRequest();
	        //url
	        LOGGER.info("url={}", request.getRequestURL());
	        //methods
	        LOGGER.info("method={}", request.getMethod());
	        //ip
	        LOGGER.info("ip={}", request.getRemoteAddr());
	        //类方法
	        LOGGER.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
	        //参数
	        LOGGER.info("args={}", joinPoint.getArgs());
	        
	        request.getParameter("codeOne");
	       
	    }
	    @Around("inOut()")
		public Object around(ProceedingJoinPoint pjp) throws Throwable {
	    	//if(ledResult==)
	       //ledResult = new LedResult();
	    	
			Object obj = null;
			ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	        HttpServletRequest request = attributes.getRequest();
	        String url = request.getRequestURI().toString();
	        String codeOne = request.getParameter("codeOne");
	        String codeTwo = request.getParameter("codeTwo");
	        String io = request.getParameter("io");
	        
	        cruenttime= System.currentTimeMillis(); //获取当前系统的时间
	        if (url.equals("/car-management/iccard/searchAuth.action")) {
	        	
	      	  if (code1.equals(codeOne)&&code2.equals(codeTwo)&Io.equals(io)) {
	      			return ledResult;   
	  			} else {
	  				if (lasttime==null) {
						lasttime= (long) 0;
					}
	  				
	  				if (cruenttime-lasttime<10000) {
	  					if (ledResult.getCarAuth()==0&&ledResult.getDriverAuth()==0) {
	  						lasttime=cruenttime;
		  					return  ledResult;
	  						
						}
					}
	  				lasttime=cruenttime;
		  			obj = pjp.proceed();
		  		  } 
	  		  }
	        code1=codeOne;
	        code2=codeTwo;
	        Io=io;
			return obj;
			
		}
	    
	    /**
	     * 拿到返回的参数
	     * @param object
	     */
	 @AfterReturning(returning = "object", pointcut = "inOut()")
	    public void doAfterReturning(Object object) {
	    	
		  if(object==null) {
			  object=ledResult;
		  }
	    ledResult=(LedResult)object;
	    	
	    } 
	    
}
