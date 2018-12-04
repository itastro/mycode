package com.bailian.car.param;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "驾驶员查询参数")
public class DriverSearchParam {

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	private String groupName;

	private String driverName;

}
