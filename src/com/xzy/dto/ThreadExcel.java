package com.xzy.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;

import java.util.Date;

public class ThreadExcel {

    @ExcelProperty("线索名称")
    private String ThreadName;
    @ExcelProperty("手机")
    private String phone;
    @ExcelProperty("负责人")
    private String personLiable;
    @ExcelProperty("创建人")
    private String founder;
    @ExcelProperty("线索来源")
    private String source;
    @ExcelProperty("行业")
    private String industry;
    @ExcelProperty("级别")
    private String level;
    @DateTimeFormat("yyyy年MM月dd日")
    @ExcelProperty("创建时间")
    private Date createTime;
    @DateTimeFormat("yyyy年MM月dd日")
    @ExcelProperty("更新时间")
    private Date updateTime;
    @DateTimeFormat("yyyy年MM月dd日")
    @ExcelProperty("下次联系时间")
    private Date nextContactTime;

    public String getThreadName() {
        return ThreadName;
    }

    public void setThreadName(String threadName) {
        ThreadName = threadName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPersonLiable() {
        return personLiable;
    }

    public void setPersonLiable(String personLiable) {
        this.personLiable = personLiable;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"ThreadName\":\"")
                .append(ThreadName).append('\"');
        sb.append(",\"phone\":\"")
                .append(phone).append('\"');
        sb.append(",\"personLiable\":\"")
                .append(personLiable).append('\"');
        sb.append(",\"founder\":\"")
                .append(founder).append('\"');
        sb.append(",\"source\":\"")
                .append(source).append('\"');
        sb.append(",\"industry\":\"")
                .append(industry).append('\"');
        sb.append(",\"level\":\"")
                .append(level).append('\"');
        sb.append(",\"createTime\":\"")
                .append(createTime).append('\"');
        sb.append(",\"updateTime\":\"")
                .append(updateTime).append('\"');
        sb.append(",\"nextContactTime\":\"")
                .append(nextContactTime).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
