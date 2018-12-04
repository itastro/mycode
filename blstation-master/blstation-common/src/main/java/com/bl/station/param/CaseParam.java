package com.bl.station.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @ClassName CaseParam
 * @Description TODO
 * @Date 2018/9/6 9:20
 * @Author itastro
 * @Version 1.0
 **/
@ApiModel
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CaseParam {


    private Integer id;
    @NotBlank(message = "名称不能为空")
    @ApiModelProperty(value = "案例名称", name = "name")
    private String name;

    @ApiModelProperty(value = "项目创建时间", name = "createtime")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    @NotBlank(message = "案例描述不能为空")
    @ApiModelProperty(value = "案例描述", name = "descn")
    private String descn;

    @ApiModelProperty(name = "pic", value = "案例照片")
    private MultipartFile pic;

    @ApiModelProperty(name = "remark", value = "备注")
    private String remark;
}
