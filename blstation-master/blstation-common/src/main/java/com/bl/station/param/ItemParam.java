package com.bl.station.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @ClassName ItemParam
 * @Description TODO
 * @Date 2018/8/14 13:21
 * @Author itastro
 * @Version 1.0
 **/

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class ItemParam {
    /**
     *id
     */
    @ApiModelProperty(value = "产品id",name = "id")
    private Integer id;

    @NotBlank(message = "产品名称不能为空")
    @Length(max=20,message = "产品名称不能大于20个字")
    @ApiModelProperty(value = "产品名称",name = "name")
    /**
     * 商品名称
     */
    private String name;

    @NotNull(message = "商品分类id不能为空")
    @ApiModelProperty(value = "商品分类id",name = "itemcatId")
    /**
     * 商品分类id
     */
    private Integer itemcatId;
    /**
     * 照片
     */

    private MultipartFile pic;
    @NotBlank(message = "产品描述不能为空")
    /**
     *  描述
     */
    @ApiModelProperty(value = "描述",name = "desc")
    private String desc;

    /**
     * 商品功能
     */
    @ApiModelProperty(value = "功能描述",name = "function")
    private String function;

    /**
     * 商品应用场景
     */
    @ApiModelProperty(value = "应用场景",name = "application")
    private String application;


    /**
     * 商品参数
     */
    @ApiModelProperty(value = "产品参数。注意：需要以json字符串的形式传过来",name = "desc")
    private String param;
}
