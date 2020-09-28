package com.xzy.entity;

public class Sources {

    private Integer sourceId;
    private String sourceName;

    public Sources(Integer sourceId, String sourceName) {
        this.sourceId = sourceId;
        this.sourceName = sourceName;
    }

    public Sources() {
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"sourceId\":")
                .append(sourceId);
        sb.append(",\"sourceName\":\"")
                .append(sourceName).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
