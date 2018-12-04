package com.bailian.car.domain.cars.checktable;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
    * @ClassName: CarCheckRequest
    * @Description: 项目检查要求
    * @author itastro
    * @date 2018年3月23日
    *
 */
@Entity
@Table(name = "t_check_request")
public class CheckRequest implements Serializable {

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "C_ID", unique = true, nullable = false, length = 11)
	private Integer id;

	@Column(name = "REQUEST_NAME")
	private String request; // 要求名称

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
