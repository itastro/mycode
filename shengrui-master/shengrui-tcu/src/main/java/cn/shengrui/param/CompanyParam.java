package cn.shengrui.param;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @ClassName CompanyParams
 * @Description TODO
 * @Date 2018/10/12 13:17
 * @Author itastro
 * @Version 1.0
 **/
@Getter
@Setter
public class CompanyParam {
    /**
     * id
     */
    private Integer id;
    /**
     * 名称
     */
    @NotBlank(message = "车企名称不能为空")
    @Length(min = 2, max = 20, message = "车企名称长度需在2-20个字")
    private String name;

    /**
     * 备注
     */
    @Length(max = 200, message = "备注不能超过200个字")
    private String remark;

    @NotBlank(message = "车企代码不能为空")
    private String companyCode;

}
