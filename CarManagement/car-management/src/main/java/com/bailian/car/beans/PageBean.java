package com.bailian.car.beans;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @ClassName: PageBean
 * @Description:分页结果集
 * @author itastro
    * @date 2018年6月21日
    *
    * @param <T>
 */
public class PageBean<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public void setCountPage(int countPage) {
		this.countPage = countPage;
	}

	private Long total; // 总记录数

	private List<T> rows; // 当前页数据

	private double countPage; // 总页数

	private double currentPage; // 当前页码

	public double getCurrentPage() {

		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public double getCountPage() {

		return countPage;
	}

}