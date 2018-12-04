package cn.shengrui.param;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @ClassName ProjectParam
 * @Description TODO
 * @Date 2018/10/14 20:37
 * @Author itastro
 * @Version 1.0
 **/
@Getter
@Setter
public class ProjectParam {

    private Integer id;
    /**
     * 项目名称
     */
    @NotBlank(message = "项目名称不能为空")
    @Length(min = 2, max = 20, message = "项目名称不能小于两个字或者大于20个字")
    private String name;

    /**
     * 车企id
     */
    @NotNull(message = "车企不能为空")
    private Integer company_id;

    /**
     * 标签零部件号
     */
    @NotBlank(message = "标签零部件号不能为空")
    private String labelPartsNo;
    /**
     * 写入零部件号
     */
    @NotBlank(message = "写入零部件号不能为空")
    private String writePartsNo;
    /**
     * 客户条码类型
     */
    @NotNull(message = "客户条码类型不能为空")
    private Integer customerBarcodeType;
    /**
     * 客户条码数量
     */
    @NotNull(message = "客户条码数量不能为空")
    private Integer customerBarcodeCount;
    /**
     * 盛瑞脚本
     */
    private Integer shengruiScriptId;
    /**
     * 客户脚本
     */
    private Integer customerScriptId;

    /**
     * 盛瑞脚本名称
     */
    private String shengruiScriptName;

    /**
     * 客户脚本名称
     */
    private String customerScriptName;


}
