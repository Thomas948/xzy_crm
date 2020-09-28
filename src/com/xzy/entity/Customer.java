package com.xzy.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;

import java.util.Date;

public class Customer {

    private Integer customerId;
    @ExcelProperty("客户名称")
    private String customerName;
    @ExcelProperty("手机号")
    private String phone;
    @ExcelProperty("签约状态")
    private Integer status;
    @ExcelProperty("负责人id")
    private Integer personLiableId;
    @ExcelProperty("创建人id")
    private Integer founderId;
    @ExcelProperty("来源id")
    private Integer sourceId;
    @ExcelProperty("行业id")
    private Integer industryId;
    @ExcelProperty("级别id")
    private Integer levelId;

    private Employee personLiable;
    private Employee founder;
    private Sources source;
    private Industry industry;
    private Levels level;

    @DateTimeFormat("yyyy-MM-dd")
    @ExcelProperty("创建时间")
    private Date createTime;
    @DateTimeFormat("yyyy-MM-dd")
    @ExcelProperty("更新时间")
    private Date updateTime;
    @DateTimeFormat("yyyy-MM-dd")
    @ExcelProperty("下次联系时间")
    private Date nextContactTime;
    private Integer flag;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPersonLiableId() {
        return personLiableId;
    }

    public void setPersonLiableId(Integer personLiableId) {
        this.personLiableId = personLiableId;
    }

    public Integer getFounderId() {
        return founderId;
    }

    public void setFounderId(Integer founderId) {
        this.founderId = founderId;
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public Integer getIndustryId() {
        return industryId;
    }

    public void setIndustryId(Integer industryId) {
        this.industryId = industryId;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
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

    public Date getNextContactTime() {
        return nextContactTime;
    }

    public void setNextContactTime(Date nextContactTime) {
        this.nextContactTime = nextContactTime;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }


    public Employee getPersonLiable() {
        return personLiable;
    }

    public void setPersonLiable(Employee personLiable) {
        this.personLiable = personLiable;
    }

    public Employee getFounder() {
        return founder;
    }

    public void setFounder(Employee founder) {
        this.founder = founder;
    }

    public Sources getSource() {
        return source;
    }

    public void setSource(Sources source) {
        this.source = source;
    }

    public Industry getIndustry() {
        return industry;
    }

    public void setIndustry(Industry industry) {
        this.industry = industry;
    }

    public Levels getLevel() {
        return level;
    }

    public void setLevel(Levels level) {
        this.level = level;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"customerId\":")
                .append(customerId);
        sb.append(",\"customerName\":\"")
                .append(customerName).append('\"');
        sb.append(",\"phone\":\"")
                .append(phone).append('\"');
        sb.append(",\"status\":")
                .append(status);
        sb.append(",\"personLiableId\":")
                .append(personLiableId);
        sb.append(",\"founderId\":")
                .append(founderId);
        sb.append(",\"sourceId\":")
                .append(sourceId);
        sb.append(",\"industryId\":")
                .append(industryId);
        sb.append(",\"levelId\":")
                .append(levelId);
        sb.append(",\"personLiable\":")
                .append(personLiable);
        sb.append(",\"founder\":")
                .append(founder);
        sb.append(",\"source\":")
                .append(source);
        sb.append(",\"industry\":")
                .append(industry);
        sb.append(",\"level\":")
                .append(level);
        sb.append(",\"createTime\":\"")
                .append(createTime).append('\"');
        sb.append(",\"updateTime\":\"")
                .append(updateTime).append('\"');
        sb.append(",\"nextContactTime\":\"")
                .append(nextContactTime).append('\"');
        sb.append(",\"flag\":")
                .append(flag);
        sb.append('}');
        return sb.toString();
    }
}
