package com.bl.station.param;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import javax.validation.constraints.NotBlank;

/**
 * @author itastro
 */
@ApiModel
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InformationParam {

    /**
     * 留言信息id
     */
    private Integer id;

    /**
     * 地址
     */
    @NotBlank(message = "地址不能为空")
    @ApiModelProperty(name = "address",value = "公司地址")
    private String address;

    /**
     * 邮箱
     */
    @NotBlank(message = "邮箱不能为空")
    @ApiModelProperty(name = "email",value = "公司邮箱")
    private String email;
    /**
     * 移动电话
     */
    @NotBlank(message = "电话不能为空")
    @ApiModelProperty(name = "tel",value = "移动电话")
    private String tel;
    /**
     * 座机
     */
    @NotBlank(message = "座机不能为空")
    @ApiModelProperty(name = "phone",value = "座机号码")
    private String phone;


    /**
     * 公司名称
     */
    @NotBlank(message = "公司名称不能为空")
    @ApiModelProperty(name = "name",value = "公司名称")
    private String name;
    /**
     * 公司信息
     */
    @ApiModelProperty(name = "content",value = "公司介绍信息")
    @NotBlank(message = "公司信息不能为空")
    private String content;
    /**
     * 公司照片
     */
    private MultipartFile pic;
    /**
     * 公司二维码
     */
    private MultipartFile qrpic;

    /**
     * 合作商数量
     */
    @ApiModelProperty(name = "cooperation",value = "合作商数量")
    private Integer cooperation;

    /**
     * 专利数
     */
    @ApiModelProperty(name = "patents",value = "专利数")
    private Integer patents;

    /**
     * 行业第一专利数
     */
    @ApiModelProperty(name = "firstpatents",value = "行业第一专利数")
    private Integer firstpatents;



}
