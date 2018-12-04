package com.bl.station.param;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Api
@Getter
@Setter
public class MenuParam {

    private Integer id;
    @NotBlank(message = "菜单名称不能为空")
    @Length(max = 15, min = 2, message = "菜单名称需要在2-15个字之间")
    /**
     * 菜单名称
     */
    @ApiModelProperty(name = "name", value = "菜单的名称")
    private String name;
    @Length(max = 150, message = "路径不能超过250个字")
    /**
     * 菜单路径
     */
    @ApiModelProperty(name = "url", value = "菜单的路径")
    private String url;
    /**
     * 父菜单id
     */
    @ApiModelProperty(name = "parentId", value = "父菜单id")
    private Integer parentId = 0;

    @NotNull(message = "展示顺序不能为空")
    /**
     *顺序
     */
    @ApiModelProperty(name = "seq", value = "菜单的展示顺序")
    private Integer seq;
    @Length(max = 150, message = "备注不能超过250个字")
    /**
     * 备注
     */
    @ApiModelProperty(name = "remark", value = "菜单的备注")
    private String remark;

    /**
     * 图标
     */
    @ApiModelProperty(name = "icon", value = "惨淡图标的url")
    private String icon;
}
