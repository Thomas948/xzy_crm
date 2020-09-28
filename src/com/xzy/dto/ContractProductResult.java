package com.xzy.dto;

import com.xzy.entity.Contract;

import java.util.List;

/**
 * 向前端展示数据的模板类
 */
public class ContractProductResult {

    private Contract contract;

    private List<ProductResult> productResults;

    public ContractProductResult() {
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public List<ProductResult> getProductResults() {
        return productResults;
    }

    public void setProductResults(List<ProductResult> productResults) {
        this.productResults = productResults;
    }

    @Override
    public String toString() {
        return "ContractProductResult{" +
                "contract=" + contract +
                ", productResults=" + productResults +
                '}';
    }
}
