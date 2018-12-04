package cn.shengrui.param;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @ClassName ProjectDetails
 * @Description TODO
 * @Date 2018/10/22 10:22
 * @Author itastro
 * @Version 1.0
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDetails {


    private Integer ptfId;
    /**
     * 项目ID
     */
    private Integer projectId;

    /**
     * 项目名称
     */
    private String pname;
    /**
     * tcuID
     */
    private Integer tcuId;

    /**
     * 文件id
     */
    private Integer fileId;

    /**
     * tcu代码
     */
    private String tcuCode;

    /**
     * tcuID
     */
    private Integer tcuType;

    /**
     * 文件名称
     */
    private String fileName;


    /**
     * 状态
     */
    private Integer status;
}
