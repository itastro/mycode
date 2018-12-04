package com.bl.station.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @ClassName HonorParam
 * @Description TODO
 * @Date 2018/8/13 15:01
 * @Author itastro
 * @Version 1.0
 **/
@ApiModel
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HonorParam {
    @ApiModelProperty(name = "pic", value = "荣誉资质照片")
    @NotNull(message = "照片不能为空")
    private MultipartFile pic;

    private Integer id;
    @ApiModelProperty(name = "title", value = "荣誉资质标题")
    @Length(max = 50, message = "标题不能大于50个字")
    @NotBlank(message = "标题不能为空")
    private String title;
    @Length(max = 250, message = "备注不能超过250个字")
    @ApiModelProperty(name = "remark", value = "荣誉资质备注")
    private String remark;
    @ApiModelProperty(name = "expired", value = "荣誉资质过期日期")
    @NotNull(message = "过期日不能为空")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date expired;
    @ApiModelProperty(name = "content", value = "荣誉资质内容")
    @NotBlank(message = "内容不能为空")
    private String content;
}
