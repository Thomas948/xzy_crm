package com.xzy.dto;

public class Page {

    private Integer pageNo;
    private Integer pageSize;
    private Integer pageCount;
    private boolean hasPre;
    private boolean hasNext;

    private Object obj;

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public boolean isHasPre() {
        return hasPre;
    }

    public void setHasPre(boolean hasPre) {
        this.hasPre = hasPre;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"pageNo\":")
                .append(pageNo);
        sb.append(",\"pageSize\":")
                .append(pageSize);
        sb.append(",\"pageCount\":")
                .append(pageCount);
        sb.append(",\"hasPre\":")
                .append(hasPre);
        sb.append(",\"hasNext\":")
                .append(hasNext);
        sb.append(",\"obj\":")
                .append(obj);
        sb.append('}');
        return sb.toString();
    }
}

