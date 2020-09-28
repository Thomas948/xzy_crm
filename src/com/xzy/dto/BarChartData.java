package com.xzy.dto;

public class BarChartData {

    private Double y;
    private String name;

    public BarChartData() {
    }

    public BarChartData(Double y, String name) {
        this.y = y;
        this.name = name;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BarChartData{" +
                "y=" + y +
                ", name='" + name + '\'' +
                '}';
    }
}
