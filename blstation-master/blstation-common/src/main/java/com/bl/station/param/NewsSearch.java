package com.bl.station.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author itastro
 */
@ApiModel
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewsSearch {
    /**
     * 摘要
     */

    @ApiModelProperty(name = "summary",value = "摘要")
    private String summary;
    /**
     * 开始时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
    @ApiModelProperty(name = "startTime",value = "开始显示时间")
    private Date  startTime;
    /**
     * 结束时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
    @ApiModelProperty(name = "endTime",value = "结束日期")
    private Date endTime;
}
