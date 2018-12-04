package cn.shengrui.param;

import lombok.*;

/**
 * @ClassName RoleSearch
 * @Description TODO
 * @Date 2018/10/26 9:40
 * @Author itastro
 * @Version 1.0
 **/

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RoleSearch {

    /**
     * 角色名称
     */
    private String name;
}
