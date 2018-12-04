package cn.shengrui.param;

import lombok.*;

/**
 * @ClassName AclParam
 * @Description TODO
 * @Date 2018/10/22 17:28
 * @Author itastro
 * @Version 1.0
 **/

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AclParam {

    private Integer id;

    private String name;

    private String keyword;

    private String remark;

}
