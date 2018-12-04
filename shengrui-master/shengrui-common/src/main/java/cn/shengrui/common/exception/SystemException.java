package cn.shengrui.common.exception;


import cn.shengrui.common.enums.ResultEnum;

/**
 * @ClassName ParamException
 * @Description TODO
 * @Date 2018/10/6 22:06
 * @Author itastro
 * @Version 1.0
 **/
public class SystemException extends RuntimeException {

	private Integer code;



	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public SystemException(ResultEnum resultEnum){

		//父类本来就有一个message
		super(resultEnum.getMessage());
		this.code=resultEnum.getCode();
	}
}
