package com.bailian.car.param;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class WriteCarCard {

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Integer getCardType() {
		return cardType;
	}

	public void setCardType(Integer cardType) {
		this.cardType = cardType;
	}

	public String getOtherNumber() {
		return otherNumber;
	}

	public void setOtherNumber(String otherNumber) {
		this.otherNumber = otherNumber;
	}

	@NotBlank(message = "卡号不能为空")
	private String cardNumber; // 标签卡号

	@NotNull(message = "卡类型不能为空") // 卡类型 0: 车卡 1：驾驶员卡
	private Integer cardType;

	@NotBlank(message = "卡号不能为空")
	private String otherNumber; // 车辆编号

}
