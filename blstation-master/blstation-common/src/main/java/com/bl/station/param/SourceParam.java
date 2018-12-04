package com.bl.station.param;

import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName SourceParam
 * @Description TODO
 * @Date 2018/8/20 14:54
 * @Author itastro
 * @Version 1.0
 **/
public class SourceParam {


    private Integer id;

    private String itemcat;

    private String item;

    private String type;

    private String title;


    private MultipartFile file;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemcat() {
        return itemcat;
    }

    public void setItemcat(String itemcat) {
        this.itemcat = itemcat == null ? null : itemcat.trim();
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item == null ? null : item.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
