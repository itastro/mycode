package cn.shengrui.param;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @ClassName RoleParam
 * @Description TODO
 * @Date 2018/10/23 9:36
 * @Author itastro
 * @Version 1.0
 **/
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleParam {

    private Integer id;

    @NotBlank(message = "角色名称不能为空")
    private String name;

    @NotBlank(message = "角色关键字不能为空")
    private String keyword;
    
    @Length(max = 200, message = "备注不能大于200个字")
    private String remark;

}
