package com.bailian.car.domain.cars.checktable;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "t_check_item")
public class CheckItem implements Serializable {

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "C_ID", unique = true, nullable = false, length = 11)
	private Integer id;
	@Column(name = "ITEM_NAME")
	private String cname; // 检查项目名称

	@ManyToOne
	@JoinColumn(name = "P_ID")
	private CheckParentItem carCheckParentItem;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@JsonBackReference
	public CheckParentItem getCarCheckParentItem() {
		return carCheckParentItem;
	}

	public void setCarCheckParentItem(CheckParentItem carCheckParentItem) {
		this.carCheckParentItem = carCheckParentItem;
	}
}
