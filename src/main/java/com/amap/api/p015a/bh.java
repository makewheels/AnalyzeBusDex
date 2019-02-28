package com.amap.api.p015a;

import android.graphics.Color;
import android.os.RemoteException;
import com.amap.api.maps2d.model.BitmapDescriptorFactory;
import com.amap.api.maps2d.model.CircleOptions;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.MarkerOptions;
import com.amap.api.maps2d.model.MyLocationStyle;
import com.amap.api.p015a.ao.C0207a;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.sdk.WebView;

/* compiled from: MyLocationOverlay */
/* renamed from: com.amap.api.a.bh */
class bh {
    /* renamed from: a */
    private af f869a;
    /* renamed from: b */
    private aj f870b;
    /* renamed from: c */
    private ag f871c;
    /* renamed from: d */
    private MyLocationStyle f872d;
    /* renamed from: e */
    private LatLng f873e;
    /* renamed from: f */
    private double f874f;

    bh(af afVar) {
        this.f869a = afVar;
    }

    /* renamed from: a */
    public void m1424a(MyLocationStyle myLocationStyle) {
        this.f872d = myLocationStyle;
        if (this.f870b != null || this.f871c != null) {
            try {
                m1421a();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            m1420d();
        }
    }

    /* renamed from: a */
    public void m1423a(LatLng latLng, double d) {
        this.f873e = latLng;
        this.f874f = d;
        if (this.f870b == null && this.f871c == null) {
            m1418b();
        }
        if (this.f870b != null) {
            this.f870b.mo154a(latLng);
            try {
                this.f871c.mo259a(latLng);
                if (d != -1.0d) {
                    this.f871c.mo257a(d);
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    private void m1418b() {
        if (this.f872d == null) {
            m1419c();
        } else {
            m1420d();
        }
    }

    /* renamed from: a */
    public void m1421a() throws RemoteException {
        if (this.f871c != null) {
            this.f869a.mo112a(this.f871c.mo47c());
            this.f871c = null;
        }
        if (this.f870b != null) {
            this.f869a.mo120b(this.f870b.mo167e());
            this.f870b = null;
        }
    }

    /* renamed from: c */
    private void m1419c() {
        try {
            this.f871c = this.f869a.mo80a(new CircleOptions().strokeWidth(1.0f).fillColor(Color.argb(20, 0, 0, 180)).strokeColor(Color.argb(WebView.NORMAL_MODE_ALPHA, 0, 0, ErrorCode.COPY_INSTALL_SUCCESS)).center(new LatLng(0.0d, 0.0d)));
            this.f871c.mo257a(200.0d);
            this.f870b = this.f869a.mo114b(new MarkerOptions().anchor(0.5f, 0.5f).icon(BitmapDescriptorFactory.fromAsset(C0207a.marker_gps_no_sharing.name() + ".png")).position(new LatLng(0.0d, 0.0d)));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: d */
    private void m1420d() {
        if (this.f872d != null) {
            try {
                this.f871c = this.f869a.mo80a(new CircleOptions().strokeWidth(this.f872d.getStrokeWidth()).fillColor(this.f872d.getRadiusFillColor()).strokeColor(this.f872d.getStrokeColor()).center(new LatLng(0.0d, 0.0d)));
                if (this.f873e != null) {
                    this.f871c.mo259a(this.f873e);
                }
                this.f871c.mo257a(this.f874f);
                this.f870b = this.f869a.mo114b(new MarkerOptions().anchor(this.f872d.getAnchorU(), this.f872d.getAnchorV()).icon(this.f872d.getMyLocationIcon()).position(new LatLng(0.0d, 0.0d)));
                if (this.f873e != null) {
                    this.f870b.mo154a(this.f873e);
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public void m1422a(float f) {
        if (this.f870b != null) {
            try {
                this.f870b.mo149a(f);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
