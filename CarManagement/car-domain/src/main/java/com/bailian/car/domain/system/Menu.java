package com.bailian.car.domain.system;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 菜单实体
 * 
 * @ClassName: Menu
 * @Description: TODO(菜单类)
 * @author itastro
 * @date 2018年1月15日
 *
 */

@Entity
@Table(name = "t_menu")
public class Menu implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "C_ID", unique = true, nullable = false)
	private Integer mid; // 菜单id
	@Column(name = "C_NAME", nullable = false, columnDefinition = "varchar(50) default ''")
	private String name; // 菜单名称
	@Column(name = "C_URL", nullable = false, columnDefinition = "varchar(255) default ''")
	private String url; // 访问路径
	@Column(name = "C_PRIORITY", columnDefinition = "varchar(50) default ''")
	private String priority; // 优先级
	@Column(name = "C_REMARK", columnDefinition = "varchar(255) default ''")
	private String remark; // 备注
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@Column(name = "C_CREATETIME", nullable = false)
	private Date createTime; // 创建时间
	@Column(name = "C_OPERATOR", columnDefinition = "varchar(50) default ''")
	private String operator; // 操作者
	@Column(name = "C_OPERATOR_IP", columnDefinition = "varchar(50) default ''")
	private String operate_ip; // 操作者ip

	@JsonIgnoreProperties(value = { "roles" })
	@ManyToMany(mappedBy = "menus")
	private Set<Role> roles = new HashSet<Role>(0); // 菜单角色关联

	@OneToMany(mappedBy = "parentMenu", fetch = FetchType.EAGER)
	private Set<Menu> childrenMenus = new HashSet<Menu>();

	@ManyToOne
	@JoinColumn(name = "C_PID")
	private Menu parentMenu; // 顶级菜单

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
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

	public Set<Menu> getChildrenMenus() {

		return childrenMenus;
	}

	public void setChildrenMenus(Set<Menu> childrenMenus) {
		this.childrenMenus = childrenMenus;
	}

	@JsonBackReference
	public Menu getParentMenu() {

		return parentMenu;
	}

	public void setParentMenu(Menu parentMenu) {
		this.parentMenu = parentMenu;
	}
}
