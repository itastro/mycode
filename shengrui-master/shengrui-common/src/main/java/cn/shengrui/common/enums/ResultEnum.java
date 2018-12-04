package cn.shengrui.common.enums;

/**
 * @author itastro
 */
public enum ResultEnum {
    //未知异常
    UNKONW_ERROR(500, "未知系统异常请联系管理员"),
    //成功
    PARAMS_ERROR(400, "参数异常"),

    UPDATE_PASS_ERROR(500, "请勿修改别人密码"),

    UPDATE_USER_ERROR(500, "请勿修改别人的信息"),

    NOLOGIN_ERROR(300, "请登录"),

    UPDATE_ERROR(500, "系统超级管理员不允许修改"),

    ACL_ERROR(301, "此用户无权限操作");

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {

        this.code = code;

        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
