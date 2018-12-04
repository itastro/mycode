package com.bl.station.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @ClassName BannerParam
 * @Description TODO
 * @Date 2018/9/6 20:40
 * @Author itastro
 * @Version 1.0
 **/
@ApiModel
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BannerParam {

    private Integer id;

    @NotBlank(message = "模块名不能为空")
    @ApiModelProperty(name = "moudle", value = "模块名")
    private String moudle;

    @Length(max = 250, message = "不能超过250个字")
    private String remark;

    @ApiModelProperty(name = "pic", value = "照片")
    @NotNull(message = "照片不能为空")
    private MultipartFile pic;

    private String content;
}
