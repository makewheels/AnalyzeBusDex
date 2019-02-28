package com.amap.api.maps.overlay;

import com.amap.api.maps.model.LatLng;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AMapServicesUtil */
/* renamed from: com.amap.api.maps.overlay.a */
class C0439a {
    /* renamed from: a */
    public static int f2545a = 2048;

    C0439a() {
    }

    /* renamed from: a */
    public static LatLng m3780a(LatLonPoint latLonPoint) {
        return new LatLng(latLonPoint.getLatitude(), latLonPoint.getLongitude());
    }

    /* renamed from: a */
    public static ArrayList<LatLng> m3781a(List<LatLonPoint> list) {
        ArrayList<LatLng> arrayList = new ArrayList();
        for (LatLonPoint a : list) {
            arrayList.add(C0439a.m3780a(a));
        }
        return arrayList;
    }
}
