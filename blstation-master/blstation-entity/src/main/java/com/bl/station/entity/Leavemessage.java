package com.bl.station.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @author itastro
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Leavemessage {
    /**
     * id 留言id
     */
    private Integer id;
    @NotBlank(message = "留言内容不能为空")
    @Length(min = 10, max = 150, message = "留言不能小于10个字或超过150个字")
    /**
     * 留言内容
     */
    private String content;


    /**
     * 创建时间
     */
    private Date createtime;

    @NotBlank(message = "电话不能为空")
    @Length(max = 11, message = "电话不能超过11位")
    /**
     *  移动电话
     */
    private String tel;
    @NotBlank(message = "邮箱不能为空")
    /**
     * 邮箱
     */
    private String email;
    //@NotBlank(message = "标题不能为空")

    @Length(max = 15, message = "标题不能超过15个字")
    private String title;

    @NotBlank(message = "地址不能为空")
    /**
     * 地址
     */
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
}