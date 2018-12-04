package cn.shengrui.param;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName CompanySearch
 * @Description 车企查询参数
 * @Date 2018/10/12 13:45
 * @Author itastro
 * @Version 1.0
 **/
@Getter
@Setter
public class CompanySearch {

    /**
     * 名称
     */
    private String name;

    /**
     * 状态
     */
    private String status;
}
