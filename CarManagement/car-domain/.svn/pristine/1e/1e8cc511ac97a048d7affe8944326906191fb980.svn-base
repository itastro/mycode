package com.bailian.car.domain.cars.checktable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * 
 * @ClassName: CarCheckName
 * @Description: 车辆价检查类别
 * @author itastro
 * @date 2018年3月23日
 *
 */
@Entity
@Table(name = "t_check_type")
public class CheckType implements Serializable {

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "C_ID", unique = true, nullable = false, length = 11)
	private Integer id;
	@Column(name = "CHECK_NAME") // 车辆检查类型名称
	private String name;

	private String url;

	@OneToMany(mappedBy = "carCheckName")
	private List<CheckParentItem> carCheckParentItems = new ArrayList<CheckParentItem>();

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
	public List<CheckParentItem> getCarCheckParentItems() {
		return carCheckParentItems;
	}

	public void setCarCheckParentItems(List<CheckParentItem> carCheckParentItems) {
		this.carCheckParentItems = carCheckParentItems;
	}
}
