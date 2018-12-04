package com.bailian.car.domain.carcheck;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 * @ClassName: ClacyLindersss
 * @Description: 车辆缸检查
 * @author itastro
 * @date 2018年3月22日
 *
 */
@Entity
@Table(name = "t_clacylindersss")
public class ClacyLindersss implements Serializable {
	public String getvSn() {
		return vSn;
	}

	public void setvSn(String vSn) {
		this.vSn = vSn;
	}

	private static final long serialVersionUID = 1L;

	public Double getCylinder_p() {
		return cylinder_p;
	}

	public void setCylinder_p(Double cylinder_p) {
		this.cylinder_p = cylinder_p;
	}

	public Double getOne_p() {
		return one_p;
	}

	public void setOne_p(Double one_p) {
		this.one_p = one_p;
	}

	public Double getTwo_p() {
		return two_p;
	}

	public void setTwo_p(Double two_p) {
		this.two_p = two_p;
	}

	public Double getThree_p() {
		return three_p;
	}

	public void setThree_p(Double three_p) {
		this.three_p = three_p;
	}

	public Double getFour_p() {
		return four_p;
	}

	public void setFour_p(Double four_p) {
		this.four_p = four_p;
	}

	public Double getFuel_p() {
		return fuel_p;
	}

	public void setFuel_p(Double fuel_p) {
		this.fuel_p = fuel_p;
	}

	public Double getActual_p() {
		return actual_p;
	}

	public void setActual_p(Double actual_p) {
		this.actual_p = actual_p;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false, length = 11)
	private Integer id;
	@NotBlank(message = "车辆编号不能为空")
	private String vSn; // 车辆编号

	private Double cylinder_p; // 缸压

	private Double one_p; // 1缸压力

	private Double two_p; // 2 缸压力

	private Double three_p; // 3 缸压力

	private Double four_p; // 4 缸压力

	private Double fuel_p; // 燃油压力

	private Double actual_p; // 实测压力

}
