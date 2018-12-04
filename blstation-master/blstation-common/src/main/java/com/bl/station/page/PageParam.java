package com.bl.station.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class PageParam {

    private static final long serialVersionUID = 1L;
    /**
     * 页码
     */
    @ApiModelProperty(name = "page",value = "页码")
    private Integer page = 1;
    /**
     * 每页加载条数
     */
    @ApiModelProperty(name = "size",value = "每页条数")
    private Integer size = 10;

    /**
     * 排序参数
     */
    private String sort;

    /**
     * 排序命令
     */
    private String sortOder;

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getSortOder() {
        return sortOder;
    }

    public void setSortOder(String sortOder) {
        this.sortOder = sortOder;
    }

    public Integer getPage() {
        if (page == 0) {
            return 1;
        }
        if (page < 0) {
            return 1;
        }
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
