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
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @ClassName: User
 * @Description: TODO(用户实体)
 * @author itastro
 * @date 2018年1月15日
 *
 */

@Entity
@Table(name = "t_user")
public class User implements Serializable {

	public String getNetid() {
		return netid;
	}

	public void setNetid(String netid) {
		this.netid = netid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getEmployeeCard() {
		return employeeCard;
	}

	public void setEmployeeCard(String employeeCard) {
		this.employeeCard = employeeCard;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = -863466514638657592L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "C_ID", unique = true, nullable = false, length = 11)
	private Integer uid; // 主键

	@Column(name = "C_PASSWORD", columnDefinition = "varchar(50) default ''")
	private String password; // 密码
	@Column(name = "C_TELEPHONE", columnDefinition = "varchar(50) default ''")
	private String telephone; // 电话
	@Column(name = "C_EMAIL", columnDefinition = "varchar(50) default ''")
	private String email; // 邮箱

	@Column(name = "C_SEX", columnDefinition = "varchar(50) default ''")
	private String sex;

	@Column(name = "C_REMARK", columnDefinition = "varchar(255) default ''")
	private String remark; // 备注

	@Column(name = "C_NICKNAME", columnDefinition = "varchar(50) default ''")
	private String nickname; // 用户名
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@Column(name = "C_CREATETIME")
	private Date createTime; // 创建时间
	@Column(name = "C_OPERATOR", columnDefinition = "varchar(50) default ''")
	private String operator; // 操作者

	private String netid;

	@Column(name = "C_OPERATE_ID", columnDefinition = "varchar(50) default ''")

	private String operate_id; // 操作者ID
	@ManyToMany
	@JoinTable(name = "t_user_role", joinColumns = {
			@JoinColumn(name = "C_USER_ID", referencedColumnName = "C_ID") }, inverseJoinColumns = {
					@JoinColumn(name = "C_ROLE_ID", referencedColumnName = "C_ID") })
	private Set<Role> roles = new HashSet<Role>(0); // 角色

	private String employeeCard; // 员工卡号

	private String team; // 所在team

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getOperate_id() {
		return operate_id;
	}

	public void setOperate_id(String operate_id) {
		this.operate_id = operate_id;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
