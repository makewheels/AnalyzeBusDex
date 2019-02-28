package com.amap.api.maps2d.overlay;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.model.BitmapDescriptor;
import com.amap.api.maps2d.model.BitmapDescriptorFactory;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.LatLngBounds;
import com.amap.api.maps2d.model.LatLngBounds.Builder;
import com.amap.api.maps2d.model.Marker;
import com.amap.api.maps2d.model.MarkerOptions;
import com.amap.api.maps2d.model.Polyline;
import com.amap.api.p015a.C0269x;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class RouteOverlay {
    /* renamed from: a */
    private Context f2667a;
    protected List<Polyline> allPolyLines = new ArrayList();
    /* renamed from: b */
    private Bitmap f2668b;
    /* renamed from: c */
    private Bitmap f2669c;
    /* renamed from: d */
    private Bitmap f2670d;
    /* renamed from: e */
    private Bitmap f2671e;
    protected Marker endMarker;
    protected LatLng endPoint;
    /* renamed from: f */
    private Bitmap f2672f;
    /* renamed from: g */
    private AssetManager f2673g;
    protected AMap mAMap;
    protected Marker startMarker;
    protected LatLng startPoint;
    protected List<Marker> stationMarkers = new ArrayList();

    public RouteOverlay(Context context) {
        this.f2667a = context;
        this.f2673g = this.f2667a.getResources().getAssets();
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
        m3809a();
    }

    /* renamed from: a */
    private void m3809a() {
        if (this.f2668b != null) {
            this.f2668b.recycle();
            this.f2668b = null;
        }
        if (this.f2669c != null) {
            this.f2669c.recycle();
            this.f2669c = null;
        }
        if (this.f2670d != null) {
            this.f2670d.recycle();
            this.f2670d = null;
        }
        if (this.f2671e != null) {
            this.f2671e.recycle();
            this.f2671e = null;
        }
        if (this.f2672f != null) {
            this.f2672f.recycle();
            this.f2672f = null;
        }
    }

    protected BitmapDescriptor getStartBitmapDescriptor() {
        return m3808a(this.f2668b, "amap_start.png");
    }

    protected BitmapDescriptor getEndBitmapDescriptor() {
        return m3808a(this.f2669c, "amap_end.png");
    }

    protected BitmapDescriptor getBusBitmapDescriptor() {
        return m3808a(this.f2670d, "amap_bus.png");
    }

    protected BitmapDescriptor getWalkBitmapDescriptor() {
        return m3808a(this.f2671e, "amap_man.png");
    }

    protected BitmapDescriptor getDriveBitmapDescriptor() {
        return m3808a(this.f2672f, "amap_car.png");
    }

    /* renamed from: a */
    private BitmapDescriptor m3808a(Bitmap bitmap, String str) {
        Bitmap a;
        IOException e;
        try {
            InputStream open = this.f2673g.open(str);
            bitmap = BitmapFactory.decodeStream(open);
            a = C0441a.m3816a(bitmap, C0269x.f1180a);
            try {
                open.close();
            } catch (IOException e2) {
                e = e2;
                e.printStackTrace();
            } catch (Exception e3) {
            }
        } catch (IOException e4) {
            e = e4;
            a = bitmap;
            e.printStackTrace();
        } catch (Exception e5) {
            a = bitmap;
        }
        return BitmapDescriptorFactory.fromBitmap(a);
    }

    protected void addStartAndEndMarker() {
        this.startMarker = this.mAMap.addMarker(new MarkerOptions().position(this.startPoint).icon(getStartBitmapDescriptor()).title("起点"));
        this.endMarker = this.mAMap.addMarker(new MarkerOptions().position(this.endPoint).icon(getEndBitmapDescriptor()).title("终点"));
    }

    public void zoomToSpan() {
        if (this.startPoint != null && this.endPoint != null && this.mAMap != null) {
            this.mAMap.moveCamera(CameraUpdateFactory.newLatLngBounds(getLatLngBounds(), 50));
        }
    }

    protected LatLngBounds getLatLngBounds() {
        Builder builder = LatLngBounds.builder();
        builder.include(new LatLng(this.startPoint.latitude, this.startPoint.longitude));
        builder.include(new LatLng(this.endPoint.latitude, this.endPoint.longitude));
        return builder.build();
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
