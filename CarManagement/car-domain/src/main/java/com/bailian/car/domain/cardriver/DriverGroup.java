package com.bailian.car.domain.cardriver;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;

import lombok.NoArgsConstructor;

@Entity
@Table(name = "t_drivergroup")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "驾驶员分组")
public class DriverGroup implements Serializable {
	   
	private static final long serialVersionUID = 1L;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonBackReference
	public Set<Driver> getDriver() {
		return driver;
	}

	public void setDriver(Set<Driver> driver) {
		this.driver = driver;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false, length = 11)
	private Integer id;
	@NotBlank(message = "分组名称不能为空")
	@ApiModelProperty(value = "分组名称")
	private String name;
	@ApiModelProperty(value = "备注")
	private String remark;
	@ManyToMany(mappedBy = "groups")
	@Builder.Default
	private Set<Driver> driver = new HashSet<Driver>(0);

}
