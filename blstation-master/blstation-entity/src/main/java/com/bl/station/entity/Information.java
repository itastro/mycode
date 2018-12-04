package com.bl.station.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Information {
    private Integer id;

    private String address;

    private String email;

    private String tel;

    private String phone;

    private String picurl;

    private String name;

    private String qrcode;

    private Integer cooperation;

    private Integer patents;

    private Integer firstpatents;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl == null ? null : picurl.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode == null ? null : qrcode.trim();
    }

    public Integer getCooperation() {
        return cooperation;
    }

    public void setCooperation(Integer cooperation) {
        this.cooperation = cooperation;
    }

    public Integer getPatents() {
        return patents;
    }

    public void setPatents(Integer patents) {
        this.patents = patents;
    }

    public Integer getFirstpatents() {
        return firstpatents;
    }

    public void setFirstpatents(Integer firstpatents) {
        this.firstpatents = firstpatents;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}