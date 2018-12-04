package com.bailian.car.domain.iccard;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "iccard")
public class Iccard implements Serializable {

	public Integer getCardType() {
		return cardType;
	}

	public void setCardType(Integer cardType) {
		this.cardType = cardType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIccard() {
		return iccard;
	}

	public void setIccard(String iccard) {
		this.iccard = iccard;
	}

	public Integer getIcauthority() {
		return icauthority;
	}

	public void setIcauthority(Integer icauthority) {
		this.icauthority = icauthority;
	}

	public String getDriversn() {
		return driversn;
	}

	public void setDriversn(String driversn) {
		this.driversn = driversn;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false, length = 11)
	private Integer id; // 卡的id
	@NotBlank(message = "ic卡号不能为空")
	@Column(name = "ICID")
	private String iccard; // ic卡号
	@Column(name = "ICAUTHORITY")
	private Integer icauthority;
	@Column(name = "DRIVERSN")
	private String driversn;
	@Column(name = "CARDTYPE")
	private Integer cardType; // 卡的类型

}
