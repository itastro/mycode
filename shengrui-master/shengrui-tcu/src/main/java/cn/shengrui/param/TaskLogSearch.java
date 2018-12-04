package cn.shengrui.param;

import lombok.*;


/**
 * @ClassName TaskLogSearch
 * @Description TODO
 * @Date 2018/10/26 18:03
 * @Author itastro
 * @Version 1.0
 **/
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskLogSearch {

    private String name;

    private String option;
}
