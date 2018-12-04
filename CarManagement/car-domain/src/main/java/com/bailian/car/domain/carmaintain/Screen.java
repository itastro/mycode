package com.bailian.car.domain.carmaintain;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "t_screen")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Screen implements Serializable{
	    
	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;

	public String getWorkContent() {
		return workContent;
	}

	public void setWorkContent(String workContent) {
		this.workContent = workContent;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getvSn() {
		return vSn;
	}

	public void setvSn(String vSn) {
		this.vSn = vSn;
	}

	public String getApplyPeople() {
		return applyPeople;
	}

	public void setApplyPeople(String applyPeople) {
		this.applyPeople = applyPeople;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public Date getForecastTime() {
		return forecastTime;
	}

	public void setForecastTime(Date forecastTime) {
		this.forecastTime = forecastTime;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFin_park() {
		return fin_park;
	}

	public void setFin_park(String fin_park) {
		this.fin_park = fin_park;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false, length = 11)
	private Integer id;

	private String vSn;

	private String applyPeople;

	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date applyTime; // 申请时间

	@JsonFormat(pattern = "MM-dd HH:mm", timezone = "GMT+8")
	private Date forecastTime; // 预计完成时间

	@Column(columnDefinition = "varchar(20) default ''")
	private String operator; // 操作人

	private String status; // 状态

	private String fin_park; // 停发地点

	private String workContent; // 维修项目
	
	
	private Integer mid; //维修列表id

}
