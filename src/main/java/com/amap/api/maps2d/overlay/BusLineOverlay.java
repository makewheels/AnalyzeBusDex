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
import com.amap.api.maps2d.model.PolylineOptions;
import com.amap.api.p015a.C0269x;
import com.amap.api.p015a.p016a.C0204q;
import com.amap.api.services.busline.BusLineItem;
import com.amap.api.services.busline.BusStationItem;
import com.amap.api.services.core.LatLonPoint;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p054u.aly.bi_常量类;

public class BusLineOverlay {
    /* renamed from: a */
    private BusLineItem f2657a;
    /* renamed from: b */
    private AMap f2658b;
    /* renamed from: c */
    private ArrayList<Marker> f2659c = new ArrayList();
    /* renamed from: d */
    private Polyline f2660d;
    /* renamed from: e */
    private List<BusStationItem> f2661e;
    /* renamed from: f */
    private BitmapDescriptor f2662f;
    /* renamed from: g */
    private BitmapDescriptor f2663g;
    /* renamed from: h */
    private BitmapDescriptor f2664h;
    /* renamed from: i */
    private AssetManager f2665i;
    /* renamed from: j */
    private Context f2666j;

    public BusLineOverlay(Context context, AMap aMap, BusLineItem busLineItem) {
        this.f2666j = context;
        this.f2657a = busLineItem;
        this.f2658b = aMap;
        this.f2661e = this.f2657a.getBusStations();
        this.f2665i = this.f2666j.getResources().getAssets();
    }

    public void addToMap() {
        int i = 1;
        this.f2660d = this.f2658b.addPolyline(new PolylineOptions().addAll(C0441a.m3818a(this.f2657a.getDirectionsCoordinates())).color(getBusColor()).width(getBuslineWidth()));
        if (this.f2661e.size() >= 1) {
            while (i < this.f2661e.size() - 1) {
                this.f2659c.add(this.f2658b.addMarker(m3806a(i)));
                i++;
            }
            this.f2659c.add(this.f2658b.addMarker(m3806a(0)));
            this.f2659c.add(this.f2658b.addMarker(m3806a(this.f2661e.size() - 1)));
        }
    }

    public void removeFromMap() {
        if (this.f2660d != null) {
            this.f2660d.remove();
        }
        Iterator it = this.f2659c.iterator();
        while (it.hasNext()) {
            ((Marker) it.next()).remove();
        }
        m3807a();
    }

    /* renamed from: a */
    private void m3807a() {
        if (this.f2662f != null) {
            this.f2662f.recycle();
            this.f2662f = null;
        }
        if (this.f2663g != null) {
            this.f2663g.recycle();
            this.f2663g = null;
        }
        if (this.f2664h != null) {
            this.f2664h.recycle();
            this.f2664h = null;
        }
    }

    public void zoomToSpan() {
        if (this.f2658b != null) {
            List directionsCoordinates = this.f2657a.getDirectionsCoordinates();
            if (directionsCoordinates != null && directionsCoordinates.size() > 0) {
                this.f2658b.moveCamera(CameraUpdateFactory.newLatLngBounds(m3805a(directionsCoordinates), 5));
            }
        }
    }

    /* renamed from: a */
    private LatLngBounds m3805a(List<LatLonPoint> list) {
        Builder builder = LatLngBounds.builder();
        for (int i = 0; i < list.size(); i++) {
            builder.include(new LatLng(((LatLonPoint) list.get(i)).getLatitude(), ((LatLonPoint) list.get(i)).getLongitude()));
        }
        return builder.build();
    }

    /* renamed from: a */
    private MarkerOptions m3806a(int i) {
        MarkerOptions snippet = new MarkerOptions().position(new LatLng(((BusStationItem) this.f2661e.get(i)).getLatLonPoint().getLatitude(), ((BusStationItem) this.f2661e.get(i)).getLatLonPoint().getLongitude())).title(getTitle(i)).snippet(getSnippet(i));
        if (i == 0) {
            snippet.icon(getStartBitmapDescriptor());
        } else if (i == this.f2661e.size() - 1) {
            snippet.icon(getEndBitmapDescriptor());
        } else {
            snippet.anchor(0.5f, 0.5f);
            snippet.icon(getBusBitmapDescriptor());
        }
        return snippet;
    }

    protected BitmapDescriptor getStartBitmapDescriptor() {
        this.f2662f = m3804a("amap_start.png");
        return this.f2662f;
    }

    protected BitmapDescriptor getEndBitmapDescriptor() {
        this.f2663g = m3804a("amap_end.png");
        return this.f2663g;
    }

    protected BitmapDescriptor getBusBitmapDescriptor() {
        this.f2664h = m3804a("amap_bus.png");
        return this.f2664h;
    }

    protected String getTitle(int i) {
        return ((BusStationItem) this.f2661e.get(i)).getBusStationName();
    }

    protected String getSnippet(int i) {
        return bi_常量类.f6358b_空串;
    }

    public int getBusStationIndex(Marker marker) {
        for (int i = 0; i < this.f2659c.size(); i++) {
            if (((Marker) this.f2659c.get(i)).equals(marker)) {
                return i;
            }
        }
        return -1;
    }

    public BusStationItem getBusStationItem(int i) {
        if (i < 0 || i >= this.f2661e.size()) {
            return null;
        }
        return (BusStationItem) this.f2661e.get(i);
    }

    protected int getBusColor() {
        return Color.parseColor("#537edc");
    }

    protected float getBuslineWidth() {
        return C0269x.f1181b;
    }

    /* renamed from: a */
    private BitmapDescriptor m3804a(String str) {
        InputStream open;
        Bitmap a;
        IOException e;
        IOException iOException;
        Throwable th;
        InputStream inputStream = null;
        try {
            open = this.f2665i.open(str);
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(open);
                try {
                    a = C0204q.m795a(decodeStream, C0269x.f1180a);
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (IOException e3) {
                    iOException = e3;
                    a = decodeStream;
                    e2 = iOException;
                    try {
                        e2.printStackTrace();
                        if (open != null) {
                            try {
                                open.close();
                            } catch (IOException e22) {
                                e22.printStackTrace();
                            }
                        }
                        return BitmapDescriptorFactory.fromBitmap(a);
                    } catch (Throwable th2) {
                        th = th2;
                        if (open != null) {
                            try {
                                open.close();
                            } catch (IOException e222) {
                                e222.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            } catch (IOException e32) {
                iOException = e32;
                Object obj = inputStream;
                e222 = iOException;
                e222.printStackTrace();
                if (open != null) {
                    open.close();
                }
                return BitmapDescriptorFactory.fromBitmap(a);
            }
        } catch (IOException e322) {
            open = inputStream;
            InputStream inputStream2 = inputStream;
            e222 = e322;
            a = inputStream2;
            e222.printStackTrace();
            if (open != null) {
                open.close();
            }
            return BitmapDescriptorFactory.fromBitmap(a);
        } catch (Throwable th3) {
            th = th3;
            open = inputStream;
            if (open != null) {
                open.close();
            }
            throw th;
        }
        return BitmapDescriptorFactory.fromBitmap(a);
    }
}
