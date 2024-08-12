package com.msb.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: Nino
 * @Date: 2024/7/30 - 07 - 30 - 上午2:10
 * @Description: com.msb.dao
 * @version: 1.0
 */
public class PageBean<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<T> data;//当前页数据
    private int pageSize;//页大小
    private int currentPage;//当前页数
    private int totalPage;//总页数
    private int totalSize;//总记录条数

    public PageBean() {
    }

    public PageBean(List<T> data, int pageSize, int currentPage, int totalPage, int totalSize) {
        this.data = data;
        this.pageSize = pageSize;
        this.currentPage = currentPage;
        this.totalPage = totalPage;
        this.totalSize = totalSize;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "data=" + data +
                ", pageSize=" + pageSize +
                ", currentPage=" + currentPage +
                ", totalPage=" + totalPage +
                ", totalSize=" + totalSize +
                '}';
    }
}
