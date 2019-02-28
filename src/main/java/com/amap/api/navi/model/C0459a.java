package com.amap.api.navi.model;

import com.autonavi.tbt.NaviGuideItem;

/* compiled from: NaviGuide */
/* renamed from: com.amap.api.navi.model.a */
public class C0459a extends NaviGuideItem {
    /* renamed from: a */
    public AMapNaviGuide f2769a;
    /* renamed from: b */
    private NaviLatLng f2770b;

    /* renamed from: a */
    public NaviLatLng m3921a() {
        return this.f2770b;
    }

    public C0459a(NaviGuideItem naviGuideItem) {
        this.m_Length = naviGuideItem.m_Length;
        this.m_Icon = naviGuideItem.m_Icon;
        this.m_Name = naviGuideItem.m_Name;
        this.f2770b = new NaviLatLng(naviGuideItem.m_Latitude, naviGuideItem.m_Longitude);
        this.f2769a = new AMapNaviGuide(this);
    }

    public C0459a(com.autonavi.wtbt.NaviGuideItem naviGuideItem) {
        this.m_Length = naviGuideItem.m_Length;
        this.m_Icon = naviGuideItem.m_Icon;
        this.m_Name = naviGuideItem.m_Name;
        this.f2770b = new NaviLatLng(naviGuideItem.m_Latitude, naviGuideItem.m_Longitude);
        this.f2769a = new AMapNaviGuide(this);
    }

    public C0459a() {
        this.f2769a = new AMapNaviGuide();
    }
}
