package com.bl.station.dto;

import com.bl.station.entity.Item;

import java.util.Date;

/**
 * @ClassName ItemReturn
 * @Description TODO
 * @Date 2018/9/18 16:40
 * @Author itastro
 * @Version 1.0
 **/
public class ItemReturn extends Item {

    private  String itemcatname;

    public String getItemcatname() {
        return itemcatname;
    }

    public void setItemcatname(String itemcatname) {
        this.itemcatname = itemcatname;
    }

    public ItemReturn(Integer id, String name, Date createtime, Integer itemcatId, String picurl, Byte status, String itemcatname) {
        super(id, name, createtime, itemcatId, picurl, status);
        this.itemcatname = itemcatname;
    }
}
