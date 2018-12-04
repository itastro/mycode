package com.bailian.car.domain.cars.carmaintenance;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
    * @ClassName: MaintenanceItem
    * @Description: 保养项目
    * @author itastro
    * @date 2018年4月16日
    *
 */
@Entity
@Table(name = "t_maintenanceitem")
@ApiModel(value = "保养项目模型")
public class MaintenanceItem implements Serializable {

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getBrandAndlabel() {
		return brandAndlabel;
	}

	public void setBrandAndlabel(String brandAndlabel) {
		this.brandAndlabel = brandAndlabel;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "C_ID", unique = true, nullable = false, length = 11)
	private Integer id;

	@ApiModelProperty(value = "保养项目名称")
	@Column(columnDefinition = "varchar(50) default ''")
	private String itemName; // 保养项目名称
	@Column(columnDefinition = "varchar(50) default ''")
	@ApiModelProperty(value = "品牌及标号")
	private String brandAndlabel; // 品牌及其标号

}
