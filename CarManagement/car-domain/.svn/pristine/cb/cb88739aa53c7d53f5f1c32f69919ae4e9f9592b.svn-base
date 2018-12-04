package com.bailian.car.domain.carmaintain;

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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
    * @ClassName: Employee
    * @Description: 维修员工
    * @author itastro
    * @date 2018年5月15日
    *
 */
@ApiModel
@Entity
@Table(name = "t_employee")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Employee implements Serializable{
	
	    
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false, length = 11)
	private int id;
	@ApiModelProperty(value = "维修工名称")
	@NotBlank(message = "维修工姓名不能为空")
	private String name;

	@ApiModelProperty(value = "电话")
	@NotBlank(message = "电话")
	private String tel;

	@ApiModelProperty(value = "维修工备注")
	private String remark;
}
