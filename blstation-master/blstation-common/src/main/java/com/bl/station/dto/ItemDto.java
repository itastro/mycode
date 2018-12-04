package com.bl.station.dto;

import com.bl.station.entity.Item;
import com.bl.station.entity.ItemdescWithBLOBs;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @ClassName ItemDto
 * @Description TODO
 * @Date 2018/9/2 18:57
 * @Author itastro
 * @Version 1.0
 **/
@ApiModel
@AllArgsConstructor
@Getter
@Setter
public class ItemDto {
    @ApiModelProperty(name = "id", value = "id")
    private Integer id;
    @ApiModelProperty(name = "name", value = "产品名称")
    private String name;
    @ApiModelProperty(name = "itemcatId", value = "产品分类id")
    private Integer itemcatId;
    @ApiModelProperty(name = "picurl", value = "产品的url")
    private String picurl;
    @ApiModelProperty(name = "status", value = "产品的状态")
    private Byte status;
    @ApiModelProperty(name = "descn", value = "产品简介")
    private String descn;
    @ApiModelProperty(name = "function", value = "产品功能")
    private String function;
    @ApiModelProperty(name = "application", value = "应用场景")
    private String application;
    @ApiModelProperty(name = "param", value = "茶品参数")
    private String param;

    private Date creattime;

    public ItemDto() {
    }

    ;

    public static ItemDto getItemDto(ItemdescWithBLOBs itemdescWithBLOBs, Item item) {

        ItemDto itemDto = new ItemDto();
        itemDto.setId(item.getId());
        itemDto.setName(item.getName());
        itemDto.setItemcatId(item.getItemcatId());
        itemDto.setPicurl(item.getPicurl());
        itemDto.setStatus(item.getStatus());
        itemDto.setDescn(itemdescWithBLOBs.getDescn());
        itemDto.setFunction(itemdescWithBLOBs.getFunction());
        itemDto.setApplication(itemdescWithBLOBs.getApplication());
        itemDto.setParam(itemdescWithBLOBs.getParam());
        itemDto.setCreattime(item.getCreatetime());
        return itemDto;
    }

}
