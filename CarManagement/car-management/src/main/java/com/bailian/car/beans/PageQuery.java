package com.bailian.car.beans;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
    * @ClassName: PegeQuery
    * @Description: 查询页码实体类
    * @author itastro
    * @date 2018年4月23日
    *
 */
@ApiModel(value = "分页参数")
public class PageQuery implements Serializable{
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "页码，默认1")
	private Integer page = 1; // 默认为1
	@ApiModelProperty(value = "每页显示数，默认10")
	private Integer size = 100000; // 默认每页加载10条数据
	@ApiModelProperty(value = "进行排序的参数")
	private String sort; // 排序参数
	@ApiModelProperty(value = "排序命令,desc  asc")
	private String sortOder; // 排序命令 desc asc

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
			return 0;
		}
		if (page < 0) {
			return 0;
		}
		return page - 1;
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