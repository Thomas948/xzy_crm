package com.xzy.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Contract {

    private Integer contractId;//合同编号,主键
    private String contractName;//合同名称
    private Double contractMoney;//合同金额
    private String customerSigner;//客户签约人

    private Integer customerId;//客户id
    private Customer customer;//客户

    private Integer employeeSignerId;//公司签约人id
    private Employee employeeSigner;//公司签约人

    private Integer employeeResponsibleId;//公司负责人id
    private Employee employeeResponsible;//公司负责人

    private Integer employee01Id;//审批人1id
    private Employee employee01;//审批人1

    private Integer employee02Id;//审批人2id
    private Employee employee02;//审批人2
    private Integer flag;//审批状态,0: 默认值,已提交 1: 审批人1通过; 2:审批人1不通过; 3:审批人2通过 ;4:审批人2不通过
    private Date startTime;//生效时间
    private Date endTime;//结束时间
    private String contractUrl;// 附件地址

    private List<Map<String, Integer>> productStockList = new ArrayList<>();
    private List<Product> productList = new ArrayList<>();


    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Double getContractMoney() {
        return contractMoney;
    }

    public void setContractMoney(Double contractMoney) {
        this.contractMoney = contractMoney;
    }

    public String getCustomerSigner() {
        return customerSigner;
    }

    public void setCustomerSigner(String customerSigner) {
        this.customerSigner = customerSigner;
    }

    public Integer getEmployeeSignerId() {
        return employeeSignerId;
    }

    public void setEmployeeSignerId(Integer employeeSignerId) {
        this.employeeSignerId = employeeSignerId;
    }

    public Integer getEmployeeResponsibleId() {
        return employeeResponsibleId;
    }

    public void setEmployeeResponsibleId(Integer employeeResponsibleId) {
        this.employeeResponsibleId = employeeResponsibleId;
    }

    public Integer getEmployee01Id() {
        return employee01Id;
    }

    public void setEmployee01Id(Integer employee01Id) {
        this.employee01Id = employee01Id;
    }

    public Integer getEmployee02Id() {
        return employee02Id;
    }

    public void setEmployee02Id(Integer employee02Id) {
        this.employee02Id = employee02Id;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployeeSigner() {
        return employeeSigner;
    }

    public void setEmployeeSigner(Employee employeeSigner) {
        this.employeeSigner = employeeSigner;
    }

    public Employee getEmployeeResponsible() {
        return employeeResponsible;
    }

    public void setEmployeeResponsible(Employee employeeResponsible) {
        this.employeeResponsible = employeeResponsible;
    }

    public Employee getEmployee01() {
        return employee01;
    }

    public void setEmployee01(Employee employee01) {
        this.employee01 = employee01;
    }

    public Employee getEmployee02() {
        return employee02;
    }

    public void setEmployee02(Employee employee02) {
        this.employee02 = employee02;
    }

    public String getContractUrl() {
        return contractUrl;
    }

    public void setContractUrl(String contractUrl) {
        this.contractUrl = contractUrl;
    }

    public List<Map<String, Integer>> getProductStockList() {
        return productStockList;
    }

    public void setProductStockList(List<Map<String, Integer>> productStockList) {
        this.productStockList = productStockList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "contractId=" + contractId +
                ", contractName='" + contractName + '\'' +
                ", contractMoney=" + contractMoney +
                ", customerSigner='" + customerSigner + '\'' +
                ", customerId=" + customerId +
                ", customer=" + customer +
                ", employeeSignerId=" + employeeSignerId +
                ", employeeSigner=" + employeeSigner +
                ", employeeResponsibleId=" + employeeResponsibleId +
                ", employeeResponsible=" + employeeResponsible +
                ", employee01Id=" + employee01Id +
                ", employee01=" + employee01 +
                ", employee02Id=" + employee02Id +
                ", employee02=" + employee02 +
                ", flag=" + flag +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", contractUrl='" + contractUrl + '\'' +
                ", productStockList=" + productStockList +
                ", productList=" + productList +
                '}';
    }
}
