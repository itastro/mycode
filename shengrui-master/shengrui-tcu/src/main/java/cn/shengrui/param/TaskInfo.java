package cn.shengrui.param;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @ClassName TaskInfo
 * @Description TODO
 * @Date 2018/10/15 18:20
 * @Author itastro
 * @Version 1.0
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskInfo {

    /**
     * 生产任务id
     */
    private Integer taskId;

    /**
     * 项目id
     */
    private Integer projectId;


    /**
     * 项目名称
     */
    private String projectName;


    /**
     * tcu代码
     */

    private String tcuCode;
    /**
     * 批次号
     */
    private String batchNo;

    /**
     * 批次数量
     */
    private Integer batchNumber;


    /**
     * 完成数量
     */
    private Integer completeNumber;


    /**
     * 任务状态
     */
    private Integer status;

    /**
     * 流水号
     */
    private String serialNumber;

    /**
     * 创建时间
     */

    private Date createTime;

    /**
     * 生产时间
     */
    private Date producedTime;

    /**
     * 操作者
     */
    private String operator;

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 文件路径
     */

    private String url;

    /**
     * 盛瑞打印脚本
     */
    private String shengruiScriptName;


    /**
     * 供应商打印脚本
     */
    private String customerScriptName;


    /**
     * boot版本号
     */
    private String bootCode;

    /**
     * 写入零部件号
     */
    private String writePartsNo;

    /**
     * 标签零部件号
     */
    private String labelPartsNo;

    /**
     * 客户零部数量
     */
    private Integer customerBarcodeCount;

    /**
     * 供应商
     */
    private String supplier;

    /**
     * 供应商代码
     */
    private String supCode;

    /**
     * TCU类型
     */
    private String tcuType;

    /**
     * tcu软件编号
     */
    private String tcuSoftwareNo;


    /**
     * tcuID
     */
    private Integer tcuId;

    /**
     * bfcUrl
     */
    private String bfcUrl;


}
