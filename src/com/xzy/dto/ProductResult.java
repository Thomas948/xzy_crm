package com.xzy.dto;

public class ProductResult {

    private String productCode;
    private String productName;
    private double price;
    private int num;
    private double total;

    public ProductResult() {
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "ProductResult{" +
                "productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", num=" + num +
                ", total=" + total +
                '}';
    }
}
