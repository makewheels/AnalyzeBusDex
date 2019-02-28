package com.amap.api.navi.view;

import android.graphics.BitmapFactory;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.autonavi.tbt.C0617g;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: NaviCarOverlay */
/* renamed from: com.amap.api.navi.view.c */
public class C0467c {
    /* renamed from: a */
    boolean f2814a;
    /* renamed from: b */
    LatLng f2815b;
    /* renamed from: c */
    double f2816c;
    /* renamed from: d */
    double f2817d;
    /* renamed from: e */
    float f2818e;
    /* renamed from: f */
    float f2819f;
    /* renamed from: g */
    int f2820g;
    /* renamed from: h */
    boolean f2821h;
    /* renamed from: i */
    LatLng f2822i;
    /* renamed from: j */
    int f2823j;
    /* renamed from: k */
    Timer f2824k;
    /* renamed from: l */
    float f2825l;
    /* renamed from: m */
    int f2826m;
    /* renamed from: n */
    private BitmapDescriptor f2827n;
    /* renamed from: o */
    private BitmapDescriptor f2828o;
    /* renamed from: p */
    private Marker f2829p;
    /* renamed from: q */
    private Marker f2830q;
    /* renamed from: r */
    private Marker f2831r;
    /* renamed from: s */
    private AMap f2832s;
    /* renamed from: t */
    private MapView f2833t;
    /* renamed from: u */
    private boolean f2834u;
    /* renamed from: v */
    private LatLng f2835v;
    /* renamed from: w */
    private Polyline f2836w;
    /* renamed from: x */
    private List<LatLng> f2837x;

    /* compiled from: NaviCarOverlay */
    /* renamed from: com.amap.api.navi.view.c$1 */
    class C04661 extends TimerTask {
        /* renamed from: a */
        final /* synthetic */ C0467c f2813a;

        C04661(C0467c c0467c) {
            this.f2813a = c0467c;
        }

        public void run() {
            this.f2813a.m3958e();
        }
    }

    /* renamed from: a */
    public void m3964a(boolean z) {
        float f = 19.0f;
        float f2 = 15.0f;
        this.f2814a = z;
        if (this.f2829p != null && this.f2832s != null && this.f2831r != null && this.f2830q != null) {
            if (this.f2814a) {
                LatLng position = this.f2829p.getPosition();
                float f3 = this.f2832s.getCameraPosition().zoom;
                if (f3 <= 19.0f) {
                    f = f3;
                }
                if (f >= 15.0f) {
                    f2 = f;
                }
                this.f2832s.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(position, f2, this.f2832s.getCameraPosition().tilt, this.f2825l)));
                this.f2830q.setPosition(position);
                this.f2829p.setPositionByPixels(this.f2833t.getWidth() / 2, (this.f2833t.getHeight() / 3) * 2);
                this.f2829p.setRotateAngle(0.0f);
                this.f2829p.setFlat(false);
                if (this.f2834u) {
                    this.f2831r.setVisible(true);
                    return;
                } else {
                    this.f2831r.setVisible(false);
                    return;
                }
            }
            this.f2829p.setFlat(true);
            this.f2831r.setVisible(false);
            this.f2829p.setPosition(this.f2830q.getPosition());
            this.f2829p.setRotateAngle(this.f2830q.getRotateAngle());
        }
    }

    public C0467c(MapView mapView) {
        this.f2827n = null;
        this.f2828o = null;
        this.f2814a = true;
        this.f2832s = null;
        this.f2834u = true;
        this.f2835v = null;
        this.f2815b = null;
        this.f2818e = 0.0f;
        this.f2821h = false;
        this.f2822i = null;
        this.f2823j = 10;
        this.f2825l = 0.0f;
        this.f2836w = null;
        this.f2837x = new ArrayList();
        this.f2826m = -1;
        this.f2827n = BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(C0617g.m4842a(), 2130837511));
        this.f2828o = BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(C0617g.m4842a(), 2130837586));
        this.f2833t = mapView;
    }

    /* renamed from: a */
    public void m3959a() {
        if (this.f2829p != null) {
            this.f2829p.remove();
        }
        if (this.f2831r != null) {
            this.f2831r.remove();
        }
        if (this.f2830q != null) {
            this.f2830q.remove();
        }
        if (this.f2836w != null) {
            this.f2836w.remove();
        }
        this.f2836w = null;
        this.f2829p = null;
        this.f2831r = null;
        this.f2830q = null;
    }

    /* renamed from: a */
    public void m3962a(AMap aMap, LatLng latLng, float f, float f2) {
        if (aMap != null && latLng != null && this.f2827n != null) {
            this.f2832s = aMap;
            if (this.f2829p == null) {
                this.f2829p = aMap.addMarker(new MarkerOptions().anchor(0.5f, 0.5f).setFlat(true).icon(this.f2827n).position(latLng));
            }
            if (this.f2830q == null) {
                this.f2830q = aMap.addMarker(new MarkerOptions().anchor(0.5f, 0.5f).setFlat(true).icon(this.f2827n).position(latLng));
                this.f2830q.setVisible(false);
            }
            if (this.f2831r == null) {
                this.f2831r = aMap.addMarker(new MarkerOptions().anchor(0.5f, 0.5f).setFlat(true).icon(this.f2828o).position(latLng));
                if (this.f2834u) {
                    this.f2831r.setVisible(true);
                } else {
                    this.f2831r.setVisible(false);
                }
                this.f2831r.setPositionByPixels(this.f2833t.getWidth() / 2, (this.f2833t.getHeight() / 3) * 2);
            }
            this.f2829p.setVisible(true);
            m3955a(latLng, f, f2);
            m3957d();
        }
    }

    /* renamed from: a */
    public void m3963a(LatLng latLng) {
        this.f2835v = latLng;
    }

    /* renamed from: b */
    public void m3965b() {
        if (this.f2829p != null) {
            this.f2829p.remove();
        }
        if (this.f2830q != null) {
            this.f2830q.remove();
        }
        if (this.f2831r != null) {
            this.f2831r.remove();
        }
        this.f2827n = null;
        if (this.f2824k != null) {
            this.f2824k.cancel();
        }
    }

    /* renamed from: a */
    private void m3955a(LatLng latLng, float f, float f2) {
        if (this.f2829p != null) {
            this.f2822i = this.f2830q.getPosition();
            if (this.f2822i == null || this.f2822i.latitude == 0.0d || this.f2822i.longitude == 0.0d) {
                this.f2822i = new LatLng(latLng.latitude, latLng.longitude);
            }
            this.f2820g = 0;
            if (AMapUtils.calculateLineDistance(this.f2822i, latLng) > 200.0f) {
                this.f2822i = latLng;
                this.f2820g = this.f2823j - 1;
            }
            this.f2815b = this.f2822i;
            this.f2816c = (latLng.latitude - this.f2822i.latitude) / ((double) this.f2823j);
            this.f2817d = (latLng.longitude - this.f2822i.longitude) / ((double) this.f2823j);
            this.f2818e = this.f2830q.getRotateAngle();
            this.f2818e = 360.0f - this.f2818e;
            float f3 = f - this.f2818e;
            if (f3 > 180.0f) {
                f3 -= 360.0f;
            } else if (f3 < -180.0f) {
                f3 += 360.0f;
            }
            this.f2819f = f3 / ((float) this.f2823j);
            this.f2821h = true;
        }
    }

    /* renamed from: d */
    private void m3957d() {
        if (this.f2824k == null) {
            this.f2824k = new Timer();
            this.f2824k.schedule(new C04661(this), 0, 100);
        }
    }

    /* renamed from: e */
    private void m3958e() {
        float f = 19.0f;
        float f2 = 15.0f;
        if (this.f2821h && this.f2829p != null && this.f2832s != null) {
            try {
                LatLng position = this.f2829p.getPosition();
                int i = this.f2820g;
                this.f2820g = i + 1;
                if (i < this.f2823j) {
                    LatLng latLng;
                    double d = this.f2815b.latitude + (this.f2816c * ((double) this.f2820g));
                    double d2 = this.f2815b.longitude + (this.f2817d * ((double) this.f2820g));
                    this.f2825l = this.f2818e + (this.f2819f * ((float) this.f2820g));
                    this.f2825l %= 360.0f;
                    if (d == 0.0d && d2 == 0.0d) {
                        latLng = position;
                    } else {
                        latLng = new LatLng(d, d2);
                    }
                    if (this.f2814a) {
                        float f3 = this.f2832s.getCameraPosition().zoom;
                        if (f3 <= 19.0f) {
                            f = f3;
                        }
                        if (f >= 15.0f) {
                            f2 = f;
                        }
                        this.f2832s.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(latLng, f2, this.f2832s.getCameraPosition().tilt, this.f2825l)));
                        int width = this.f2833t.getWidth() / 2;
                        int height = (this.f2833t.getHeight() / 3) * 2;
                        this.f2829p.setPositionByPixels(width, height);
                        this.f2829p.setRotateAngle(0.0f);
                        this.f2829p.setFlat(false);
                        if (this.f2831r != null) {
                            this.f2831r.setPositionByPixels(width, height);
                            if (this.f2834u) {
                                this.f2831r.setVisible(true);
                            } else {
                                this.f2831r.setVisible(false);
                            }
                        }
                    } else {
                        this.f2829p.setPosition(latLng);
                        this.f2829p.setFlat(true);
                        this.f2829p.setRotateAngle(360.0f - this.f2825l);
                        if (this.f2831r != null) {
                            this.f2831r.setVisible(false);
                        }
                    }
                    if (this.f2830q != null) {
                        this.f2830q.setPosition(latLng);
                    }
                    if (this.f2830q != null) {
                        this.f2830q.setRotateAngle(360.0f - this.f2825l);
                    }
                    m3966b(latLng);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    void m3966b(LatLng latLng) {
        try {
            if (this.f2826m != -1) {
                if (this.f2835v != null) {
                    this.f2837x.clear();
                    this.f2837x.add(latLng);
                    this.f2837x.add(this.f2835v);
                    if (this.f2836w == null) {
                        this.f2836w = this.f2832s.addPolyline(new PolylineOptions().add(latLng).add(this.f2835v).color(this.f2826m).width(5.0f));
                    } else {
                        this.f2836w.setPoints(this.f2837x);
                    }
                } else if (this.f2836w != null) {
                    this.f2836w.remove();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: c */
    public void m3967c() {
        if (this.f2836w != null) {
            this.f2836w.remove();
        }
    }

    /* renamed from: a */
    public void m3960a(int i) {
        if (i == -1 && this.f2836w != null) {
            this.f2836w.remove();
        }
        this.f2826m = i;
    }

    /* renamed from: a */
    public void m3961a(int i, int i2) {
        float f = 19.0f;
        float f2 = 15.0f;
        if (this.f2829p != null) {
            int i3 = i2 / 2;
            int i4 = (i / 3) * 2;
            if (this.f2814a) {
                LatLng position = this.f2830q.getPosition();
                float f3 = this.f2832s.getCameraPosition().zoom;
                if (f3 <= 19.0f) {
                    f = f3;
                }
                if (f >= 15.0f) {
                    f2 = f;
                }
                this.f2832s.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(position, f2, this.f2832s.getCameraPosition().tilt, this.f2825l)));
                this.f2829p.setPositionByPixels(i3, i4);
            }
            if (this.f2831r != null) {
                this.f2831r.setPositionByPixels(i3, i4);
                if (this.f2834u && this.f2814a) {
                    this.f2831r.setVisible(true);
                } else {
                    this.f2831r.setVisible(false);
                }
            }
        }
    }
}
