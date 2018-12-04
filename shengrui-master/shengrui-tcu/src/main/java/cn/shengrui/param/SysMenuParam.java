package cn.shengrui.param;

import io.swagger.annotations.ApiModelProperty;
import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.*;
import org.hibernate.validator.constraints.Length;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @ClassName SysMenuParam
 * @Description TODO
 * @Date 2018/10/25 11:03
 * @Author itastro
 * @Version 1.0
 **/
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SysMenuParam {

    private Integer id;


    @ApiModelProperty(name = "pic", value = "菜单名称")
    @NotBlank(message = "菜单名称不可以为空")
    @Length(max = 15, min = 2, message = "菜单名称长度需要在2-15个字之间")
    private String name;

    @ApiModelProperty(name = "parentId", value = "父菜单id")
    private Integer parentId = 0;

    @ApiModelProperty(name = "seq", value = "菜单分类的展示顺序")
    @NotNull(message = "展示顺序不可以为空")
    private Integer seq=1;

    @Length(max = 150, message = "备注的长度需要在150个字以内")
    @ApiModelProperty(name = "remark", value = "产品分类的备注")
    private String remark;

    @NotNull(message = "菜单类型不能为空")
    @ApiModelProperty(name = "type", value = "菜单类型")
    private Integer type;

    @ApiModelProperty(name = "url", value = "菜单url")
    private String url;

}
