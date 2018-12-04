package com.bailian.car.param;

import java.io.Serializable;

/**
 * 
    * @ClassName: UserSearchParam
    * @Description: 用户查询参数
    * @author itastro
    * @date 2018年6月21日
    *
 */
public class UserSearchParam implements Serializable {

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	private static final long serialVersionUID = 1L;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNetid() {
		return netid;
	}

	public void setNetid(String netid) {
		this.netid = netid;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	private String name;

	private String netid;

	private String roleName;
	
	private String team;

}
