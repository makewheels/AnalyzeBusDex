package com.autonavi.amap.mapcore;

public class MapSourceGridData {
    private String gridName;
    private int sourceType;

    public MapSourceGridData(String str, int i) {
        this.gridName = str;
        this.sourceType = i;
    }

    public String getKeyGridName() {
        return this.sourceType + "-" + this.gridName;
    }

    public int getSourceType() {
        return this.sourceType;
    }

    public String getGridName() {
        return this.gridName;
    }
}
