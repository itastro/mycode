package cn.shengrui.param;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @ClassName SysUserParam
 * @Description TODO
 * @Date 2018/10/22 17:06
 * @Author itastro
 * @Version 1.0
 **/

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SysUserParam {

    private Integer id;

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "用户姓名不能为空")
    private String nickname;

    private String mail;
    @Length(max = 200, message = "备注不能大于200个字")
    private String remark;
}
