package com.amap.api.navi.model;

import com.autonavi.tbt.TmcBarItem;

/* compiled from: TrafficStatus */
/* renamed from: com.amap.api.navi.model.e */
public class C0463e extends TmcBarItem {
    /* renamed from: a */
    public AMapTrafficStatus f2792a;

    public C0463e(TmcBarItem tmcBarItem) {
        this.m_Status = tmcBarItem.m_Status;
        this.m_Length = tmcBarItem.m_Length;
        this.f2792a = new AMapTrafficStatus(tmcBarItem);
    }
}
