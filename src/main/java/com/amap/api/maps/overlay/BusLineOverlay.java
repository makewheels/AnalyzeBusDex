package com.amap.api.maps.overlay;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import com.amap.api.mapcore.C0344n;
import com.amap.api.mapcore.util.C0402s;
import com.amap.api.mapcore.util.C0405u;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.LatLngBounds.Builder;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
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
    private BusLineItem f2519a;
    /* renamed from: b */
    private AMap f2520b;
    /* renamed from: c */
    private ArrayList<Marker> f2521c = new ArrayList();
    /* renamed from: d */
    private Polyline f2522d;
    /* renamed from: e */
    private List<BusStationItem> f2523e;
    /* renamed from: f */
    private BitmapDescriptor f2524f;
    /* renamed from: g */
    private BitmapDescriptor f2525g;
    /* renamed from: h */
    private BitmapDescriptor f2526h;
    /* renamed from: i */
    private Context f2527i;

    public BusLineOverlay(Context context, AMap aMap, BusLineItem busLineItem) {
        this.f2527i = context;
        this.f2519a = busLineItem;
        this.f2520b = aMap;
        this.f2523e = this.f2519a.getBusStations();
    }

    public void addToMap() {
        int i = 1;
        try {
            this.f2522d = this.f2520b.addPolyline(new PolylineOptions().addAll(C0439a.m3781a(this.f2519a.getDirectionsCoordinates())).color(getBusColor()).width(getBuslineWidth()));
            if (this.f2523e.size() >= 1) {
                while (i < this.f2523e.size() - 1) {
                    this.f2521c.add(this.f2520b.addMarker(m3768a(i)));
                    i++;
                }
                this.f2521c.add(this.f2520b.addMarker(m3768a(0)));
                this.f2521c.add(this.f2520b.addMarker(m3768a(this.f2523e.size() - 1)));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void removeFromMap() {
        if (this.f2522d != null) {
            this.f2522d.remove();
        }
        try {
            Iterator it = this.f2521c.iterator();
            while (it.hasNext()) {
                ((Marker) it.next()).remove();
            }
            m3769a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m3769a() {
        if (this.f2524f != null) {
            this.f2524f.recycle();
            this.f2524f = null;
        }
        if (this.f2525g != null) {
            this.f2525g.recycle();
            this.f2525g = null;
        }
        if (this.f2526h != null) {
            this.f2526h.recycle();
            this.f2526h = null;
        }
    }

    public void zoomToSpan() {
        if (this.f2520b != null) {
            try {
                List directionsCoordinates = this.f2519a.getDirectionsCoordinates();
                if (directionsCoordinates != null && directionsCoordinates.size() > 0) {
                    this.f2520b.moveCamera(CameraUpdateFactory.newLatLngBounds(m3767a(directionsCoordinates), 5));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private LatLngBounds m3767a(List<LatLonPoint> list) {
        Builder builder = LatLngBounds.builder();
        for (int i = 0; i < list.size(); i++) {
            builder.include(new LatLng(((LatLonPoint) list.get(i)).getLatitude(), ((LatLonPoint) list.get(i)).getLongitude()));
        }
        return builder.build();
    }

    /* renamed from: a */
    private MarkerOptions m3768a(int i) {
        MarkerOptions snippet = new MarkerOptions().position(new LatLng(((BusStationItem) this.f2523e.get(i)).getLatLonPoint().getLatitude(), ((BusStationItem) this.f2523e.get(i)).getLatLonPoint().getLongitude())).title(getTitle(i)).snippet(getSnippet(i));
        if (i == 0) {
            snippet.icon(getStartBitmapDescriptor());
        } else if (i == this.f2523e.size() - 1) {
            snippet.icon(getEndBitmapDescriptor());
        } else {
            snippet.anchor(0.5f, 0.5f);
            snippet.icon(getBusBitmapDescriptor());
        }
        return snippet;
    }

    protected BitmapDescriptor getStartBitmapDescriptor() {
        this.f2524f = m3766a("amap_start.png");
        return this.f2524f;
    }

    protected BitmapDescriptor getEndBitmapDescriptor() {
        this.f2525g = m3766a("amap_end.png");
        return this.f2525g;
    }

    protected BitmapDescriptor getBusBitmapDescriptor() {
        this.f2526h = m3766a("amap_bus.png");
        return this.f2526h;
    }

    protected String getTitle(int i) {
        return ((BusStationItem) this.f2523e.get(i)).getBusStationName();
    }

    protected String getSnippet(int i) {
        return bi_常量类.f6358b;
    }

    public int getBusStationIndex(Marker marker) {
        for (int i = 0; i < this.f2521c.size(); i++) {
            if (((Marker) this.f2521c.get(i)).equals(marker)) {
                return i;
            }
        }
        return -1;
    }

    public BusStationItem getBusStationItem(int i) {
        if (i < 0 || i >= this.f2523e.size()) {
            return null;
        }
        return (BusStationItem) this.f2523e.get(i);
    }

    protected int getBusColor() {
        return Color.parseColor("#537edc");
    }

    protected float getBuslineWidth() {
        return 18.0f;
    }

    /* renamed from: a */
    private BitmapDescriptor m3766a(String str) {
        InputStream open;
        Bitmap a;
        IOException e;
        IOException iOException;
        Throwable th;
        Throwable th2;
        Throwable th3;
        Object obj;
        InputStream inputStream;
        InputStream inputStream2 = null;
        try {
            open = C0402s.m3433a(this.f2527i).open(str);
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(open);
                try {
                    a = C0405u.m3451a(decodeStream, C0344n.f1878a);
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
                    } catch (Throwable th4) {
                        th = th4;
                        if (open != null) {
                            try {
                                open.close();
                            } catch (IOException e222) {
                                e222.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th5) {
                    th2 = th5;
                    a = decodeStream;
                    th3 = th2;
                    th3.printStackTrace();
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException e2222) {
                            e2222.printStackTrace();
                        }
                    }
                    return BitmapDescriptorFactory.fromBitmap(a);
                }
            } catch (IOException e32) {
                iOException = e32;
                obj = inputStream2;
                e2222 = iOException;
                e2222.printStackTrace();
                if (open != null) {
                    open.close();
                }
                return BitmapDescriptorFactory.fromBitmap(a);
            } catch (Throwable th52) {
                th2 = th52;
                obj = inputStream2;
                th3 = th2;
                th3.printStackTrace();
                if (open != null) {
                    open.close();
                }
                return BitmapDescriptorFactory.fromBitmap(a);
            }
        } catch (IOException e322) {
            open = inputStream2;
            inputStream = inputStream2;
            e2222 = e322;
            a = inputStream;
            e2222.printStackTrace();
            if (open != null) {
                open.close();
            }
            return BitmapDescriptorFactory.fromBitmap(a);
        } catch (Throwable th6) {
            th52 = th6;
            open = inputStream2;
            if (open != null) {
                open.close();
            }
            throw th52;
        }
        return BitmapDescriptorFactory.fromBitmap(a);
    }
}
