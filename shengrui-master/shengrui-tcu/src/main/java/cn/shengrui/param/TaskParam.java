package cn.shengrui.param;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @ClassName ParamTask
 * @Description TODO
 * @Date 2018/10/15 16:54
 * @Author itastro
 * @Version 1.0
 **/
@Data
public class TaskParam {

    /**
     * 任务id
     */
    private Integer id;


    /**
     * 任务名称
     */
    private String name;
    /**
     * 项目id
     */
    @NotNull(message = "项目id不能为空")
    private Integer projectId;


    /**
     * 批次号
     */
    @NotBlank(message = "批次号不能为空")
    private String batchNo;

    /**
     * 批次数量
     */
    @NotNull(message = "批次数量不能为空")
    private Integer batchNumber;

    /**
     * 流水号
     */
    @NotNull(message = "流水号不能为空")
    private Integer serialNumber;

    /**
     * 生产时间
     */
    @NotNull(message = "生产时间不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date producedTime;

    /**
     * tcu软件编号
     */
    @NotBlank(message = "tcu软件编号不能为空")
    private String tcuSoftwareNo;



}
