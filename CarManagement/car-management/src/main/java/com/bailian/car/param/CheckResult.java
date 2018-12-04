package com.bailian.car.param;

import java.io.Serializable;
import java.util.List;
/**
 * 
    * @ClassName: CheckResult
    * @Description: 返回结果
    * @author itastro
    * @date 2018年6月21日
    *
 */
public class CheckResult implements Serializable{

	    
	private static final long serialVersionUID = 1L;

	public Object getCheck() {
		return check;
	}

	public void setCheck(Object check) {
		this.check = check;
	}

	public List<?> getCheckResults() {
		return checkResults;
	}

	public void setCheckResults(List<?> checkResults) {
		this.checkResults = checkResults;
	}

	private List<?> checkResults;

	private Object check;

}
