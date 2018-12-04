package com.bailian.car.domain.cars.car;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "t_carposition")
public class CarPosition implements Serializable {

	public Double getTowards() {
		return towards;
	}

	public void setTowards(Double towards) {
		this.towards = towards;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setBatteryvoltage(Double batteryvoltage) {
		this.batteryvoltage = batteryvoltage;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCarcode() {
		return carcode;
	}

	public void setCarcode(String carcode) {
		this.carcode = carcode;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude2() {
		return longitude2;
	}

	public void setLongitude2(Double longitude2) {
		this.longitude2 = longitude2;
	}

	public Double getLatitude2() {
		return latitude2;
	}

	public void setLatitude2(Double latitude2) {
		this.latitude2 = latitude2;
	}

	public Double getSpeed() {
		return speed;
	}

	public void setSpeed(Double speed) {
		this.speed = speed;
	}

	public Date getColltime() {
		return colltime;
	}

	public void setColltime(Date colltime) {
		this.colltime = colltime;
	}

	public String getAUTHORITY() {
		return AUTHORITY;
	}

	public void setAUTHORITY(String aUTHORITY) {
		AUTHORITY = aUTHORITY;
	}

	public String getRunStatic() {
		return runStatic;
	}

	public void setRunStatic(String runStatic) {
		this.runStatic = runStatic;
	}

	public double getBatteryvoltage() {
		return batteryvoltage;
	}

	public void setBatteryvoltage(double batteryvoltage) {
		this.batteryvoltage = batteryvoltage;
	}

	public String getIccard() {
		return iccard;
	}

	public void setIccard(String iccard) {
		this.iccard = iccard;
	}

	public String getIostatic() {
		return iostatic;
	}

	public void setIostatic(String iostatic) {
		this.iostatic = iostatic;
	}

	private static final long serialVersionUID = -801058207162818717L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CARPOSITIONID", unique = true, nullable = false, length = 11)
	private Integer id;
	@Column(name = "CAR_CODE")

	private String carcode;

	@Column(name = "LONGITUDE")

	private Double longitude;
	@Column(name = "LATITUDE")

	private Double latitude;
	@Column(name = "LONGITUDE2")

	private Double longitude2;
	@Column(name = "LATITUDE2")

	private Double latitude2;
	@Column(name = "SPEED")

	private Double speed;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@Column(name = "coll_time")
	private Date colltime;

	private String AUTHORITY;
	@Column(name = "RUNSTATIC")

	private String runStatic;
	@Column(name = "BATTERYVOLTAGE")

	private Double batteryvoltage;
	@Column(name = "ICCARD")

	private String iccard;
	@Column(name = "IOSTATIC")

	private String iostatic;

	@Column(name = "TOWARDS")
	private Double towards;

}
