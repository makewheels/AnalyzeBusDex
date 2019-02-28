package com.e4a.runtime.components.impl.android;

public class Information {
    public int color;
    public String data;
    public String name;
    public String unit;

    public Information(String name, String data, String unit, int color) {
        this.name = name;
        this.data = data;
        this.unit = unit;
        this.color = color;
    }
}
