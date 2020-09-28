package com.xzy.entity;

public class Levels {

    private Integer levelId;
    private String levelName;

    public Levels() {
    }

    public Levels(Integer levelId, String levelName) {
        this.levelId = levelId;
        this.levelName = levelName;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"levelId\":")
                .append(levelId);
        sb.append(",\"levelName\":\"")
                .append(levelName).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
