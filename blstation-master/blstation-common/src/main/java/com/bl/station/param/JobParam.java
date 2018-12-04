package com.bl.station.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @ClassName JobParam
 * @Description TODO
 * @Date 2018/8/16 18:23
 * @Author itastro
 * @Version 1.0
 **/
@ApiModel

public class JobParam {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 薪资
     */
    @NotBlank(message = "薪资不能为空")
    @Length(max = 20,message = "长度不能大于20")
    @ApiModelProperty(value = "薪水",name = "salary")
    private String salary;
    /**
     * 过期时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
    @NotNull(message = "过期时间不能为空")
    @ApiModelProperty(value = "过期时间",name = "expired")
    private Date expired;
    /**
     * 工作名称
     */
    @Length(max = 20,message = "长度不能大于20")
    @NotBlank(message = "工作名称不能为空")
    @ApiModelProperty(value = "工作名称",name = "jobname")
    private String jobname;

    /**
     * 学历
     */
    @NotBlank(message = "学历不能为空")
    @Length(max = 20,message = "长度不能大于20")
    @ApiModelProperty(value = "学历",name = "education")
    private String education;
    /**
     * 工作年限
     */
    @NotBlank(message = "工作年限不能为空")
    @Length(max = 20,message = "长度不能大于20")
    @ApiModelProperty(value = "工作年限",name = "years")
    private String years;
    /**
     * 工作地址
     */
    @NotBlank(message = "工作地址不能为空")
    @Length(max = 50,message = "长度不能大于20")
    @ApiModelProperty(value = "工作地址",name = "address")
    private String address;
    /**
     * 在招人数
     */
    @NotNull(message = "招聘人数不能为空")
    @ApiModelProperty(value = "招聘人数",name = "number")
    private Integer number;
    /**
     * 职位描述
     */
    @NotBlank(message = "职位描述不能为空")
    @Length(min = 50,message = "职位描述不能小于50个字")
    @ApiModelProperty(value = "职位描述",name = "description")
    private String description;

    /**
     * 招聘状态
     * @return
     */
    @ApiModelProperty(value = "招聘状态",name = "status")
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary == null ? null : salary.trim();
    }

    public Date getExpired() {
        return expired;
    }

    public void setExpired(Date expired) {
        this.expired = expired;
    }

    public String getJobname() {
        return jobname;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname == null ? null : jobname.trim();
    }



    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years == null ? null : years.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}
