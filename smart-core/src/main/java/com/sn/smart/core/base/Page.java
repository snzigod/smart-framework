package com.sn.smart.core.base;

import java.io.Serializable;
import java.util.List;

/**
 * 分页对象
 * 
 * @author snzigod@hotmail.com
 *
 * @param <T>
 */
public class Page<T extends Object> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6959258982795077523L;

	/**
	 * 总页数
	 */
	private Integer totalPage;
	/**
	 * 当前页码
	 */
	private Integer pageIndex;
	/**
	 * 每页记录数
	 */
	private Integer pageSize;
	/**
	 * 总记录数
	 */
	private Integer totalRow;
	/**
	 * 结果集合
	 */
	private List<T> rows;

	public Page() {
		super();
	}

	public Integer getStart() {
		return pageIndex == null ? 0 : pageSize == null ? 0 : (pageSize * (pageIndex - 1));
	}

	public void nextPage() {
		if (pageIndex == null || totalPage == null || pageIndex.intValue() >= totalPage.intValue()) {
			return;
		}
		++pageIndex;
	}

	public void previousPage() {
		if (pageIndex == null || pageIndex.intValue() <= 0) {
			return;
		}
		--pageIndex;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalRow() {
		return totalRow;
	}

	public void setTotalRow(Integer totalRow) {
		if (pageSize != null && pageSize != 0 && totalRow != null) {
			totalPage = totalRow / pageSize;
			if (totalRow % pageSize != 0) {
				totalPage++;
			}
		}
		this.totalRow = totalRow;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}
}
