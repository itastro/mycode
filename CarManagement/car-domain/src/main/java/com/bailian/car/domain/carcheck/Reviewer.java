package com.bailian.car.domain.carcheck;

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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @ClassName: Reviewer
 * @Description: 车辆审核实体类
 * @author itastro
 * @date 2018年5月15日
 *
 */
@Entity
@Table(name = "t_reviewer")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Reviewer implements Serializable {

	    
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false, length = 11)
	private Integer id;

	private String vSn; // 车辆编号

	private String safeCheckPerson; // 安全检查人

	private String safeCheckingPerson; // 安全核对人

	private String hiCheckPerson; // 线束检查人

	private String hiCheckingPerson; // 线束核对人

	private String bomCheckPerson; // bom检查人

	private String bomCheckingPerson; // bom 核对人

	private String status; // 审核状态

	private String explanation; // 审核说明

	private String reviewerPerson; //人
	
	
    private  String confirmPerson;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date reviewerTime; // 审核时间

}
