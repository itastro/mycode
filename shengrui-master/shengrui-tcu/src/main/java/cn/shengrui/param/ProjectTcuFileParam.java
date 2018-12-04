package cn.shengrui.param;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @ClassName ProjectTcuFileParam
 * @Description 关联tcu和project和File
 * @Date 2018/10/18 16:16
 * @Author itastro
 * @Version 1.0
 **/

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ProjectTcuFileParam implements Serializable{

    private Integer ptfId;

    /**
     * 项目ID
     */
    @NotNull(message = "项目ID不能为空")
    private Integer pId;

    /**
     * tcuID
     */
    @NotNull(message = "TCU ID 不能为空")
    private Integer tId;

    /**
     * 文件id
     */
    @NotNull(message = "文件 ID 不能为空")
    private Integer fId;

    /**
     * 状态
     * 1：可用
     * 0：不可用
     */
    @NotNull(message = "状态不能为空")
    private Integer status;

}
