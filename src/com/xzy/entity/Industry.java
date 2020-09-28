package com.xzy.entity;

public class Industry {

    private Integer industryId;
    private String industryName;

    public Industry() {
    }

    public Industry(Integer industryId, String industryName) {
        this.industryId = industryId;
        this.industryName = industryName;
    }

    public Integer getIndustryId() {
        return industryId;
    }

    public void setIndustryId(Integer industryId) {
        this.industryId = industryId;
    }

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"industryId\":")
                .append(industryId);
        sb.append(",\"industryName\":\"")
                .append(industryName).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
