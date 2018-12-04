package com.bl.station.param;

import io.swagger.annotations.ApiModel;
import lombok.*;

/**
 * @ClassName CaseSearch
 * @Description TODO
 * @Date 2018/9/7 14:01
 * @Author itastro
 * @Version 1.0
 **/

@ApiModel
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CaseSearch {

    private String name;
}
