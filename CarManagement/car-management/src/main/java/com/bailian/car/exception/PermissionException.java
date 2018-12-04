package com.bailian.car.exception;

/**
 * @ClassName: PermissionException
 * @Description: 异常处理
 * @author itastro
 * @date 2017年12月15日
 * 
 */

public class PermissionException extends RuntimeException {

	private static final long serialVersionUID = -1667324027695912335L;

	public PermissionException() {
		super();
	}

	public PermissionException(String message) {
		super(message);
	}

	public PermissionException(String message, Throwable cause) {
		super(message, cause);
	}

	public PermissionException(Throwable cause) {
		super(cause);
	}

	protected PermissionException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
