package com.bl.station.Bean;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName TreeNode
 * @Description TODO
 * @Date 2018/8/14 11:21
 * @Author itastro
 * @Version 1.0
 **/

@ApiModel
public class TreeNode {
    @ApiModelProperty(name = "id", value = "分类id")
    private Long id;
    @ApiModelProperty(name = "text", value = "分类名称")
    private String text;
    @ApiModelProperty(name = "state", value = "是否打开,close:关闭  open:打开")
    private String state;

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getState() {
        return state;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setState(String state) {
        this.state = state;
    }
}
