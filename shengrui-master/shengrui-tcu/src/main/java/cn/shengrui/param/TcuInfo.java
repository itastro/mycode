package cn.shengrui.param;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @ClassName TcuInfo
 * @Description TODO
 * @Date 2018/11/22 16:34
 * @Author itastro
 * @Version 1.0
 **/
public class TcuInfo {

    private Integer id;

    private String tcuType;

    private String tcuCode;

    private String supplier;

    private String supCode;

    private String bootVersion;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    private String operator;

    private String operatorIp;

    private Integer tcuStatus;

    private String bfcFileName;

    private String bfcUrl;

    private Integer fileId;
}
