package com.amap.api.navi.view;

import android.graphics.BitmapFactory;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.autonavi.tbt.C0615f;
import com.autonavi.tbt.C0617g;

/* compiled from: CameraOverlay */
/* renamed from: com.amap.api.navi.view.a */
public class C0464a {
    /* renamed from: a */
    private BitmapDescriptor f2793a = null;
    /* renamed from: b */
    private Marker f2794b;
    /* renamed from: c */
    private LatLng f2795c = null;

    public C0464a() {
        try {
            this.f2793a = BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(C0617g.m4842a(), 2130837510));
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
    }

    /* renamed from: a */
    public void m3945a(BitmapDescriptor bitmapDescriptor) {
        this.f2793a = bitmapDescriptor;
    }

    /* renamed from: a */
    public void m3944a(AMap aMap, LatLng latLng) {
        if (aMap != null) {
            try {
                if (this.f2794b == null) {
                    this.f2794b = aMap.addMarker(new MarkerOptions().position(latLng).anchor(0.5f, 0.5f).icon(this.f2793a));
                } else if (!latLng.equals(this.f2795c)) {
                    this.f2794b.setPosition(latLng);
                } else {
                    return;
                }
                this.f2795c = latLng;
            } catch (Throwable th) {
                th.printStackTrace();
                C0615f.m4834a(th);
            }
        }
    }

    /* renamed from: a */
    public void m3946a(boolean z) {
        if (this.f2794b != null) {
            this.f2794b.setVisible(z);
        }
    }

    /* renamed from: a */
    public void m3943a() {
        if (this.f2794b != null) {
            this.f2794b.remove();
        }
        this.f2793a = null;
    }
}
