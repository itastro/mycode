package com.bl.station.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @ClassName CarouselParam
 * @Description TODO
 * @Date 2018/9/6 21:48
 * @Author itastro
 * @Version 1.0
 **/
@ApiModel
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CarouselParam {
    private Integer id;

    @NotBlank(message = "轮播图标题不能为空")
    @ApiModelProperty(name = "title", value = "标题")
    private String title;
    @Length(max = 250,message = "备注不能多与250个字")
    private String remark;

    @ApiModelProperty(name = "pic", value = "照片")
    @NotNull(message = "照片不能为空")
    private MultipartFile pic;
    @ApiModelProperty(name = "content", value = "内容")
    private String content;
}
