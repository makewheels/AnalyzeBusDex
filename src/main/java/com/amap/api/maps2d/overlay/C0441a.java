package com.amap.api.maps2d.overlay;

import android.graphics.Bitmap;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AMapServicesUtil */
/* renamed from: com.amap.api.maps2d.overlay.a */
class C0441a {
    /* renamed from: a */
    public static int f2681a = 2048;

    C0441a() {
    }

    /* renamed from: a */
    public static LatLng m3817a(LatLonPoint latLonPoint) {
        return new LatLng(latLonPoint.getLatitude(), latLonPoint.getLongitude());
    }

    /* renamed from: a */
    public static ArrayList<LatLng> m3818a(List<LatLonPoint> list) {
        ArrayList<LatLng> arrayList = new ArrayList();
        for (LatLonPoint a : list) {
            arrayList.add(C0441a.m3817a(a));
        }
        return arrayList;
    }

    /* renamed from: a */
    public static Bitmap m3816a(Bitmap bitmap, float f) {
        if (bitmap == null) {
            return null;
        }
        return Bitmap.createScaledBitmap(bitmap, (int) (((float) bitmap.getWidth()) * f), (int) (((float) bitmap.getHeight()) * f), true);
    }
}
