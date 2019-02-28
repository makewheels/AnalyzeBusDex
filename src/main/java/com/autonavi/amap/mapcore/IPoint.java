package com.autonavi.amap.mapcore;

public class IPoint implements Cloneable {
    /* renamed from: x */
    public int f3639x;
    /* renamed from: y */
    public int f3640y;

    public IPoint(int i, int i2) {
        this.f3639x = i;
        this.f3640y = i2;
    }

    public Object clone() {
        try {
            return (IPoint) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
