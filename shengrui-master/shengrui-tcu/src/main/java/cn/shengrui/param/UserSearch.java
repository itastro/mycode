package cn.shengrui.param;

import lombok.*;

/**
 * @ClassName UserSearch
 * @Description TODO
 * @Date 2018/10/22 17:16
 * @Author itastro
 * @Version 1.0
 **/
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter

public class UserSearch {


    /**
     * 姓名
     */
    private String username;
}
