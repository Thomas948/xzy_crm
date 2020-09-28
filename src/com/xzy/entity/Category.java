package com.xzy.entity;

public class Category {

    private Integer categoryId;
    private String categoryName;

    public Category() {
    }

    public Category(Integer categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"categoryId\":")
                .append(categoryId);
        sb.append(",\"categoryName\":\"")
                .append(categoryName).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
