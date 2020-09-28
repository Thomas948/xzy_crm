package com.xzy.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.format.NumberFormat;

import java.util.Date;

public class Product {

    private Integer productId;
    @ExcelProperty("产品名称")
    private String productName;
    @ExcelProperty("产品编号")
    private String productCode;

    @ExcelProperty("类别编号")
    private Integer productCategoryId;
    @NumberFormat("#.##")
    @ExcelProperty("价格")
    private Double price;
    @ExcelProperty("创建人id")
    private Integer founderId;
    @DateTimeFormat("yyyy-MM-dd")
    @ExcelProperty("创建时间")
    private Date createTime;
    @DateTimeFormat("yyyy-MM-dd")
    @ExcelProperty("更新时间")
    private Date updateTime;
    @ExcelProperty("上下架状态")
    private Integer flag;
    @ExcelProperty("库存")
    private Integer stock;

    private Category category;
    private Employee founder;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

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

    public Integer getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Integer productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getFounderId() {
        return founderId;
    }

    public void setFounderId(Integer founderId) {
        this.founderId = founderId;
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

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Employee getFounder() {
        return founder;
    }

    public void setFounder(Employee founder) {
        this.founder = founder;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productCode='" + productCode + '\'' +
                ", productCategoryId=" + productCategoryId +
                ", price=" + price +
                ", founderId=" + founderId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", flag=" + flag +
                ", stock=" + stock +
                ", category=" + category +
                ", founder=" + founder +
                '}';
    }
}
