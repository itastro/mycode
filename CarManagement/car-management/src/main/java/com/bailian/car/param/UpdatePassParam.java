package com.bailian.car.param;

import java.io.Serializable;

/**
 * 
    * @ClassName: UpdatePassParam
    * @Description: 密码更新参数
    * @author itastro
    * @date 2018年6月21日
    *
 */
public class UpdatePassParam implements Serializable {

	private static final long serialVersionUID = 1L;

	public String getNewPass() {
		return newPass;
	}

	public void setNewPass(String newPass) {
		this.newPass = newPass;
	}

	public String getOldPass() {
		return oldPass;
	}

	public void setOldPass(String oldPass) {
		this.oldPass = oldPass;
	}

	private String newPass;

	private String oldPass;

}
