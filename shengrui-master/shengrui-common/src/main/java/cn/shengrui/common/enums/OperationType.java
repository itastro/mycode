package cn.shengrui.common.enums;


/**
 * @author itastro
 * 操作日志
 */
public enum OperationType {
    /**
     * 增加
     */
    ADD("增加"),
    /**
     * 删除
     */
    DELETE("删除"),
    /**
     * 更新
     */
    UPDATE("更新"),
    /**
     * 查询
     */
    QUERY("查询"),
    /**
     * 其他
     */
    OTHERT("其他");
    private String type;

    private OperationType(String type) {
        this.type = type;
    }


    private String getType() {
        return type;
    }


}
