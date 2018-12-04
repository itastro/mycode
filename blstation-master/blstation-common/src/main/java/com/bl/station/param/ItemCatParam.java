package com.bl.station.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @ClassName ItemCatParam
 * @Description TODO
 * @Date 2018/8/14 12:33
 * @Author itastro
 * @Version 1.0
 **/
@ApiModel
@Getter
@Setter
public class ItemCatParam {


    private Integer id;
    @NotBlank(message = "产品分类名称不能为空")
    @Length(max = 15, min = 2, message = "菜单名称需要在2-15个字之间")
    /**
     * 产品分类名称
     */
    @ApiModelProperty(name = "name", value = "产品分类的名称")
    private String name;


    /**
     * 产品分类id
     */
    @ApiModelProperty(name = "parentId", value = "父菜单id")
    private Integer parentId = 0;


    /**
     *顺序
     */
    @NotNull(message = "展示顺序不能为空")
    @ApiModelProperty(name = "seq", value = "产品分类的展示顺序")
    private Integer seq=1;
    @Length(max = 150, message = "备注不能超过250个字")
    /**
     * 备注
     */
    @ApiModelProperty(name = "remark", value = "产品分类的备注")
    private String remark;

    /**
     * 图标
     */
    @ApiModelProperty(name = "icon", value = "产品分类图标的url")
    private String iconurl;


}
