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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @ClassName: Role
 * @Description: TODO(角色实体)
 * @author itastro
 * @date 2018年1月15日
 *
 */
@Entity
@Table(name = "t_role")
public class Role implements Serializable {

	private static final long serialVersionUID = 5744572408300704622L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "C_ID", unique = true, nullable = false)
	private Integer rid; // 角色ID
	@Column(name = "C_NAME", nullable = false, columnDefinition = "varchar(50) default ''")
	private String name; // 角色名称
	@Column(name = "C_KEYWORD", nullable = false, columnDefinition = "varchar(50) default ''")
	private String keyWord; // 角色关键字，用于做权限控制
	@Column(name = "C_REMARK", columnDefinition = "varchar(255) default ''")
	private String remark; // 角色备注（描述）
	@Column(name = "C_CREATETIME")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date createTime; // 创建时间
	@Column(name = "C_OPERATOR", columnDefinition = "varchar(50) default ''")
	private String operator; // 操作者
	@Column(name = "C_OPERATOR_IP", columnDefinition = "varchar(50) default ''")
	private String operate_ip; // 操作者ip

	@JsonIgnoreProperties(value = { "users" })
	@ManyToMany(mappedBy = "roles")
	private Set<User> users = new HashSet<User>(0); // 角色用户关联

	@ManyToMany
	@JoinTable(name = "t_role_permissions", joinColumns = {
			@JoinColumn(name = "C_ROLE_ID", referencedColumnName = "C_ID") }, inverseJoinColumns = {
					@JoinColumn(name = "C_PERMISSION_ID", referencedColumnName = "C_ID") })
	private Set<Permission> permissions = new HashSet<Permission>(0); // 角色权限关联

	@ManyToMany
	@JoinTable(name = "t_role_menu", joinColumns = {
			@JoinColumn(name = "C_ROLE_ID", referencedColumnName = "C_ID") }, inverseJoinColumns = {
					@JoinColumn(name = "C_MENU_ID", referencedColumnName = "C_ID") })
	private Set<Menu> menus = new HashSet<Menu>(0); // 角色菜单关联

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
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
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@JsonBackReference
	public Set<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}

	@JsonBackReference
	public Set<Menu> getMenus() {
		return menus;
	}

	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}

}
