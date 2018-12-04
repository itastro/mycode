package cn.shengrui.param;

import cn.shengrui.management.entity.TaskLog;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;

/**
 * @ClassName
 * @Description TODO
 * @Date 2018/11/23 18:33
 * @Author itastro
 * @Version 1.0
 **/

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskLogParam {

    private HashMap<String, String> logList;
}
