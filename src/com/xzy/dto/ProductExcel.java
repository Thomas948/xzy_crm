package com.xzy.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.format.NumberFormat;

import java.util.Date;

public class ProductExcel {

    @ExcelProperty("产品名称")
    private String productName;
    @ExcelProperty("产品编号")
    private String productCode;
    @ExcelProperty("产品类别")
    private String productCategory;
    @NumberFormat("#.##")
    @ExcelProperty("价格")
    private Double price;
    @ExcelProperty("创建人")
    private String founder;
    @DateTimeFormat("yyyy年MM月dd日")
    @ExcelProperty("创建时间")
    private Date createTime;
    @DateTimeFormat("yyyy年MM月dd日")
    @ExcelProperty("更新时间")
    private Date updateTime;
    @ExcelProperty("上下架状态")
    private String flag;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"productName\":\"")
                .append(productName).append('\"');
        sb.append(",\"productCode\":\"")
                .append(productCode).append('\"');
        sb.append(",\"productCategory\":\"")
                .append(productCategory).append('\"');
        sb.append(",\"price\":")
                .append(price);
        sb.append(",\"founder\":\"")
                .append(founder).append('\"');
        sb.append(",\"createTime\":\"")
                .append(createTime).append('\"');
        sb.append(",\"updateTime\":\"")
                .append(updateTime).append('\"');
        sb.append(",\"flag\":\"")
                .append(flag).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
