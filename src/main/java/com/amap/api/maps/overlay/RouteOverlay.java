package com.amap.api.maps.overlay;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.LatLngBounds.Builder;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.Polyline;
import java.util.ArrayList;
import java.util.List;

public class RouteOverlay {
    /* renamed from: a */
    private Context f2528a;
    protected List<Polyline> allPolyLines = new ArrayList();
    /* renamed from: b */
    private Bitmap f2529b;
    /* renamed from: c */
    private Bitmap f2530c;
    /* renamed from: d */
    private Bitmap f2531d;
    /* renamed from: e */
    private Bitmap f2532e;
    protected Marker endMarker;
    protected LatLng endPoint;
    /* renamed from: f */
    private Bitmap f2533f;
    protected AMap mAMap;
    protected boolean nodeIconVisible = true;
    protected Marker startMarker;
    protected LatLng startPoint;
    protected List<Marker> stationMarkers = new ArrayList();

    public RouteOverlay(Context context) {
        this.f2528a = context;
    }

    public void removeFromMap() {
        if (this.startMarker != null) {
            this.startMarker.remove();
        }
        if (this.endMarker != null) {
            this.endMarker.remove();
        }
        for (Marker remove : this.stationMarkers) {
            remove.remove();
        }
        for (Polyline remove2 : this.allPolyLines) {
            remove2.remove();
        }
        m3771a();
    }

    /* renamed from: a */
    private void m3771a() {
        if (this.f2529b != null) {
            this.f2529b.recycle();
            this.f2529b = null;
        }
        if (this.f2530c != null) {
            this.f2530c.recycle();
            this.f2530c = null;
        }
        if (this.f2531d != null) {
            this.f2531d.recycle();
            this.f2531d = null;
        }
        if (this.f2532e != null) {
            this.f2532e.recycle();
            this.f2532e = null;
        }
        if (this.f2533f != null) {
            this.f2533f.recycle();
            this.f2533f = null;
        }
    }

    protected BitmapDescriptor getStartBitmapDescriptor() {
        return m3770a(this.f2529b, "amap_start.png");
    }

    protected BitmapDescriptor getEndBitmapDescriptor() {
        return m3770a(this.f2530c, "amap_end.png");
    }

    protected BitmapDescriptor getBusBitmapDescriptor() {
        return m3770a(this.f2531d, "amap_bus.png");
    }

    protected BitmapDescriptor getWalkBitmapDescriptor() {
        return m3770a(this.f2532e, "amap_man.png");
    }

    protected BitmapDescriptor getDriveBitmapDescriptor() {
        return m3770a(this.f2533f, "amap_car.png");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private com.amap.api.maps.model.BitmapDescriptor m3770a(android.graphics.Bitmap r4, java.lang.String r5) {
        /*
        r3 = this;
        r1 = 0;
        r0 = r3.f2528a;	 Catch:{ IOException -> 0x0024, all -> 0x0036 }
        r0 = com.amap.api.mapcore.util.C0402s.m3433a(r0);	 Catch:{ IOException -> 0x0024, all -> 0x0036 }
        r1 = r0.open(r5);	 Catch:{ IOException -> 0x0024, all -> 0x0036 }
        r4 = android.graphics.BitmapFactory.decodeStream(r1);	 Catch:{ IOException -> 0x0045, all -> 0x0036 }
        r0 = com.amap.api.mapcore.C0344n.f1878a;	 Catch:{ IOException -> 0x0045, all -> 0x0036 }
        r0 = com.amap.api.mapcore.util.C0405u.m3451a(r4, r0);	 Catch:{ IOException -> 0x0045, all -> 0x0036 }
        if (r1 == 0) goto L_0x001a;
    L_0x0017:
        r1.close();	 Catch:{ IOException -> 0x001f }
    L_0x001a:
        r0 = com.amap.api.maps.model.BitmapDescriptorFactory.fromBitmap(r0);
        return r0;
    L_0x001f:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x001a;
    L_0x0024:
        r0 = move-exception;
        r2 = r1;
        r1 = r0;
        r0 = r4;
    L_0x0028:
        r1.printStackTrace();	 Catch:{ all -> 0x0042 }
        if (r2 == 0) goto L_0x001a;
    L_0x002d:
        r2.close();	 Catch:{ IOException -> 0x0031 }
        goto L_0x001a;
    L_0x0031:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x001a;
    L_0x0036:
        r0 = move-exception;
    L_0x0037:
        if (r1 == 0) goto L_0x003c;
    L_0x0039:
        r1.close();	 Catch:{ IOException -> 0x003d }
    L_0x003c:
        throw r0;
    L_0x003d:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x003c;
    L_0x0042:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0037;
    L_0x0045:
        r0 = move-exception;
        r2 = r1;
        r1 = r0;
        r0 = r4;
        goto L_0x0028;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.maps.overlay.RouteOverlay.a(android.graphics.Bitmap, java.lang.String):com.amap.api.maps.model.BitmapDescriptor");
    }

    protected void addStartAndEndMarker() {
        this.startMarker = this.mAMap.addMarker(new MarkerOptions().position(this.startPoint).icon(getStartBitmapDescriptor()).title("起点"));
        this.endMarker = this.mAMap.addMarker(new MarkerOptions().position(this.endPoint).icon(getEndBitmapDescriptor()).title("终点"));
    }

    public void zoomToSpan() {
        if (this.startPoint != null && this.mAMap != null) {
            try {
                this.mAMap.animateCamera(CameraUpdateFactory.newLatLngBounds(getLatLngBounds(), 50));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    protected LatLngBounds getLatLngBounds() {
        Builder builder = LatLngBounds.builder();
        builder.include(new LatLng(this.startPoint.latitude, this.startPoint.longitude));
        builder.include(new LatLng(this.endPoint.latitude, this.endPoint.longitude));
        return builder.build();
    }

    public void setNodeIconVisibility(boolean z) {
        try {
            this.nodeIconVisible = z;
            if (this.stationMarkers != null && this.stationMarkers.size() > 0) {
                for (int i = 0; i < this.stationMarkers.size(); i++) {
                    ((Marker) this.stationMarkers.get(i)).setVisible(z);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    protected int getWalkColor() {
        return Color.parseColor("#6db74d");
    }

    protected int getBusColor() {
        return Color.parseColor("#537edc");
    }

    protected int getDriveColor() {
        return Color.parseColor("#537edc");
    }
}
