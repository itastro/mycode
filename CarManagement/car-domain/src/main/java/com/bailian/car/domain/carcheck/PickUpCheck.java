package com.bailian.car.domain.carcheck;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @ClassName: PickUpCheck
 * @Description: 接车点检
 * @author itastro
 * @date 2018年3月19日
 *
 */
@Entity
@Table(name = "t_upcheck")
public class PickUpCheck implements Serializable {

	public String getOdometer() {
		return odometer;
	}

	public void setOdometer(String odometer) {
		this.odometer = odometer;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getBrandModelone() {
		return brandModelone;
	}

	public void setBrandModelone(String brandModelone) {
		this.brandModelone = brandModelone;
	}

	public String getvSn() {
		return vSn;
	}

	public void setvSn(String vSn) {
		this.vSn = vSn;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Integer getKeyy() {
		return keyy;
	}

	public void setKeyy(Integer keyy) {
		this.keyy = keyy;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFacade() {
		return facade;
	}

	public void setFacade(String facade) {
		this.facade = facade;
	}

	public Integer getTools() {
		return tools;
	}

	public void setTools(Integer tools) {
		this.tools = tools;
	}

	public Integer getSparetyre() {
		return sparetyre;
	}

	public void setSparetyre(Integer sparetyre) {
		this.sparetyre = sparetyre;
	}

	public Integer getJack() {
		return jack;
	}

	public void setJack(Integer jack) {
		this.jack = jack;
	}

	public Integer getWarningboard() {
		return warningboard;
	}

	public void setWarningboard(Integer warningboard) {
		this.warningboard = warningboard;
	}

	public Integer getFire() {
		return fire;
	}

	public void setFire(Integer fire) {
		this.fire = fire;
	}

	public String getPickone() {
		return pickone;
	}

	public void setPickone(String pickone) {
		this.pickone = pickone;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getSend_p() {
		return send_p;
	}

	public void setSend_p(String send_p) {
		this.send_p = send_p;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getEngineNumber() {
		return engineNumber;
	}

	public void setEngineNumber(String engineNumber) {
		this.engineNumber = engineNumber;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false, length = 11)

	private Integer id;
	@NotBlank(message = "车辆编号不能为空")
	private String vSn; // 车辆编号

	private String facade; // 车辆外观 1:正常 2：见下页说明

	private String item; // 随车物品

	private Integer tools; // 随车工具

	private Integer sparetyre; // 备用轮胎

	private Integer jack; // 千斤顶

	private Integer warningboard; // 紧急停车警示牌

	private Integer fire; // 车用灭火器

	private Integer keyy; // 钥匙数量

	@NotBlank(message = "里程表不能为空")
	private String odometer;// 里程表

	private String pickone; // 接车人

	@NotBlank(message = "送车人电话不能为空")
	private String telephone;// 电话号码

	@NotBlank(message = "送车人不能为空")
	private String send_p; // 送车人
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date time; // 时间

	@NotBlank(message = "车架号不能为空")
	private String vin; // 车架号

	@NotBlank(message = "发动机号不能为空")
	private String engineNumber;// 发动机号

	@NotBlank(message = "厂牌型号不能为空")
	private String brandModelone; // 厂牌型号

	private String explanation; // 说明

	private String remark; // 备注

}
