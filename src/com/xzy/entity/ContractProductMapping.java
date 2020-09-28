package com.xzy.entity;

public class ContractProductMapping {

    private Integer contractProductId;
    private Integer contractId;
    private Integer productId;

    private String productName;
    private Integer num;//产品数量

    public Integer getContractProductId() {
        return contractProductId;
    }

    public void setContractProductId(Integer contractProductId) {
        this.contractProductId = contractProductId;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"contractProductId\":")
                .append(contractProductId);
        sb.append(",\"contractId\":")
                .append(contractId);
        sb.append(",\"productId\":")
                .append(productId);
        sb.append(",\"productName\":\"")
                .append(productName).append('\"');
        sb.append(",\"num\":")
                .append(num);
        sb.append('}');
        return sb.toString();
    }
}
