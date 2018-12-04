package com.bl.station.param;

import io.swagger.annotations.ApiModel;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @ClassName PatentParam
 * @Description TODO
 * @Date 2018/9/2 22:52
 * @Author itastro
 * @Version 1.0
 **/
@ApiModel
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PatentParam {

    private Integer id;

    @NotBlank(message = "专利名称不能为空")
    private String name;

    @NotNull(message = "专利类型不能为空")
    private Integer type;

    private MultipartFile pic;

    private String remark;
    @NotBlank(message = "专利描述不能为空")
    private String descn;

}
