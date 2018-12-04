package cn.shengrui.param;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @ClassName TcuParam
 * @Description TODO
 * @Date 2018/10/14 12:47
 * @Author itastro
 * @Version 1.0
 **/

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TcuParam {

    private Integer id;
    /**
     * tcu型号
     */
    @NotBlank(message = "tcu型号不能为空")
    private String tcuType;

    /**
     * tcu代码
     */
    @NotBlank(message = "tcu代码不能为空")
    private String tcuCode;

    /**
     * 供应商
     */
    @NotBlank(message = "供应商不能为空")
    private String supplier;

    /**
     * 供应商代码
     */
    @NotBlank(message = "供应商代码不能为空")
    private String supCode;

    /**
     * boot版本
     */
    @NotBlank(message = "boot版本不能为空")
    private String bootVersion;

    @NotNull(message = "bfc文件不能为空")
    private Integer fileId;


}
