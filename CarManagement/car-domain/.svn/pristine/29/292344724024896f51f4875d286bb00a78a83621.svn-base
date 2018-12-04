package com.bailian.car.domain.system;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @ClassName: Permission
 * @Description: TODO(权限实体)
 * @author itastro
 * @date 2018年1月15日
 *
 */

@Entity
@Table(name = "t_permission")
public class Permission implements Serializable {
	private static final long serialVersionUID = 5807104793112621745L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "C_ID", unique = true, nullable = false)
	private Integer pid; // 权限id
	@Column(name = "C_NAME", nullable = false, columnDefinition = "varchar(50) default ''")
	private String name;// 权限名称
	@Column(name = "C_KEYWORD", nullable = false, columnDefinition = "varchar(50) default ''")
	private String keyWord;// 权限关键字
	@Column(name = "C_REMARK", columnDefinition = "varchar(255) default ''")
	private String remark; // 权限备注

	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@Column(name = "C_CREATETIME")
	private Date createTime; // 创建时间

	@Column(name = "C_OPERATOR", columnDefinition = "varchar(50) default ''")
	private String operator; // 操作者
	@Column(name = "C_OPERATE_IP", columnDefinition = "varchar(50) default ''")
	private String operate_ip; // 操作者ip
	@JsonIgnoreProperties(value = { "roles" })
	@ManyToMany(mappedBy = "permissions")
	private Set<Role> roles = new HashSet<Role>(0); // 权限角色关联

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getOperate_ip() {
		return operate_ip;
	}

	public void setOperate_ip(String operate_ip) {
		this.operate_ip = operate_ip;
	}

	@JsonBackReference
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
