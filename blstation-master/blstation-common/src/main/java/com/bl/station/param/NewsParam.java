package com.bl.station.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;


/**
 * @author itastro
 * @date 2018/8/16
 */
@ApiModel
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewsParam {


    /**
     * 新闻id
     */
    @ApiModelProperty(name = "id", value = "主键")
    private Integer id;
    /**
     * 新闻标题
     */
    @Length(max = 50, message = "不能大于50字")
    @ApiModelProperty(name = "title", value = "标题")
    private String title;

    /**
     * 显示起始日
     */
    @NotNull(message = "展示起始日不能为空")
    @ApiModelProperty(name = "starttime", value = "展示起始日")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date starttime;


    /**
     * 显示终止日
     */
    @NotNull(message = "展示结束日不能为空")
    @ApiModelProperty(name = "endtime", value = "展示结束日")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date endtime;

    /**
     * 摘要
     */
    @Length(max = 50, message = "不能大于50字")
    @ApiModelProperty(name = "summary", value = "摘要")
    private String summary;

    /**
     * 作者
     */
    @NotBlank(message = "作者不能为空")
    @Length(max = 50, message = "不能大于50字")
    @ApiModelProperty(name = "author", value = "作者")

    private String author;

    /**
     * 过期时间
     */
    @NotNull(message = "过期日不能为空")
    @ApiModelProperty(name = "expired", value = "过期时间")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date expired;

    /**
     * 内容
     */
    @NotBlank(message = "内容不能为空")
    @ApiModelProperty(name = "content", value = "内容")
    private String content;

    /**
     * 照片
     */
    private MultipartFile pic;
}
