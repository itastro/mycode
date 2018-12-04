package com.bl.station.entity;

import java.util.Date;

/**
 * @author itastro
 */

public class Job {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 创建时间
     */

    private Date createtime;
    /**
     * 薪资
     */

    private String salary;
    /**
     * 过期时间
     */

    private Date expired;
    /**
     * 工作名称
     */

    private String jobname;
    /**
     * 招聘状态
     */
    private String status;
    /**
     * 学历
     */

    private String education;
    /**
     * 工作年限
     */

    private String years;
    /**
     * 工作地址
     */

    private String address;
    /**
     * 在招人数
     */

    private Integer number;
    /**
     * 职位描述
     */

    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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