package com.bailian.car.domain.cars.checktable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * 
 * @ClassName: CarCheckParentItem
 * @Description: 车辆检查父项目
 * @author itastro
 * @date 2018年3月23日
 *
 */
@Entity
@Table(name = "t_check_p_item")
public class CheckParentItem implements Serializable {
	
	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "C_ID", unique = true, nullable = false, length = 11)
	private Integer id;
	@Column(name = "P_ITEM_NAME")
	private String pname; // 父项目名称
	@OneToMany(mappedBy = "carCheckParentItem", fetch = FetchType.LAZY)
	private List<CheckItem> CarCheckItems = new ArrayList<CheckItem>();

	@OneToOne
	@JoinColumn(name = "RQ_ID") // 检查要求
	private CheckRequest carCheckRequest;

	@ManyToOne
	@JoinColumn(name = "CHECK_ID")
	private CheckType carCheckName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<CheckItem> getCarCheckItems() {
		return CarCheckItems;
	}

	public void setCarCheckItems(List<CheckItem> carCheckItems) {
		CarCheckItems = carCheckItems;
	}

	public CheckRequest getCarCheckRequest() {
		return carCheckRequest;
	}

	public void setCarCheckRequest(CheckRequest carCheckRequest) {
		this.carCheckRequest = carCheckRequest;
	}

	@JsonBackReference
	public CheckType getCarCheckName() {
		return carCheckName;
	}

	public void setCarCheckName(CheckType carCheckName) {
		this.carCheckName = carCheckName;
	}

}
