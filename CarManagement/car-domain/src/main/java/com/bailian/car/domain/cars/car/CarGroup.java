package com.bailian.car.domain.cars.car;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "t_cargroup")
@ApiModel(value = "车辆分组")
public class CarGroup implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "C_ID", unique = true, nullable = false, length = 11)
	@ApiModelProperty(value = "分组id")
	private int id;

	@Column(columnDefinition = "varchar(20) default ''", nullable = false)
	@NotBlank(message = "分组名称不能为空")
	@ApiModelProperty(value = "分组名称")
	private String name;
	@ApiModelProperty(value = "分组备注")
	private String remark;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
