package cn.shengrui.param;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @ClassName
 * @Description TODO
 * @Date 2018/11/23 10:58
 * @Author itastro
 * @Version 1.0
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskEchartInfo {

    private int failCount;

    private int successCount;

    private int flashCount;

    private String successPct;

    private String failPct;
}
