package com.amap.api.navi.model;

import com.autonavi.tbt.TmcBarItem;

public class AMapTrafficStatus {
    public int m_Length;
    public int m_Status;

    public int getStatus() {
        return this.m_Status;
    }

    void setStatus(int i) {
        this.m_Status = i;
    }

    public int getLength() {
        return this.m_Length;
    }

    void setLength(int i) {
        this.m_Length = i;
    }

    AMapTrafficStatus(TmcBarItem tmcBarItem) {
        this.m_Status = tmcBarItem.m_Status;
        this.m_Length = tmcBarItem.m_Length;
    }
}
