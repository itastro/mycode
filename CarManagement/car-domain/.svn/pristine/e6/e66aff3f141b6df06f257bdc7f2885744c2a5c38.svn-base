package com.bailian.car.domain.Log;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 * 系统日志
 * 
 * @ClassName: Log
 * @Description:日志记录
 * @author itastro
 * @date 2018年1月15日
 *
 */
@Data
@Entity
@Table(name = "t_log")
public class SysLog implements Serializable {
	private static final long serialVersionUID = 6624546559697488917L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "C_ID", unique = true, nullable = false)
	private Integer id; // 主键

	@Column(name = "C_MOUDLE", columnDefinition = "varchar(50) default ''")
	private String module; // 模块

	@Column(name = "C_METHOD", columnDefinition = "varchar(50) default ''")
	private String method; // 方法

	private String params; // 提交参数
	@Column(name = "C_RMETHOD", columnDefinition = "varchar(500) default ''")

	private String requestMethod; // 请求方法

	@Column(name = "C_URL", columnDefinition = "varchar(255) default ''")
	private String requestUrl; // 请求连接

	@Column(name = "C_EX", columnDefinition = "varchar(255) default ''")
	private String exception; // 请求异常

	@Column(name = "C_REPONSE_DATA", columnDefinition = "varchar(255) default ''")
	private String rsponse_date; // 响应时间

	@JsonFormat(pattern = "yyyy-MM-dd HH", timezone = "GMT+8")
	@Column(name = "C_CREATETIME")

	private Date createTime;// 执行时间

	@Column(name = "C_OPERATOR", columnDefinition = "varchar(50) default ''")
	private String operator; // 操作者

	@Column(name = "C_OPERATE_IP", columnDefinition = "varchar(50) default ''") // 操作IP
	private String operate_ip; // 操作者ip

	@Column(name = "C_DESCRIPTION", columnDefinition = "varchar(255) default ''")
	private String description; // 执行描述

	private String methodType;  //方法类型

	/**
	* 设置请求参数
	* @param paramMap
	*/
	public void setMapToParams(Map<String, String[]> paramMap) {
		if (paramMap == null) {
			return;
		}
		StringBuilder params = new StringBuilder();
		for (Map.Entry<String, String[]> param : ((Map<String, String[]>) paramMap).entrySet()) {
			params.append(("".equals(params.toString()) ? "" : "&") + param.getKey() + "=");
			String paramValue = (param.getValue() != null && param.getValue().length > 0 ? param.getValue()[0] : "");
			params.append(StringUtils
					.abbreviate(StringUtils.endsWithIgnoreCase(param.getKey(), "password") ? "" : paramValue, 100));
		}
		this.params = params.toString();
	}

}
