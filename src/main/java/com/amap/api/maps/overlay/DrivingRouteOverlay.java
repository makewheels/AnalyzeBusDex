package com.amap.api.maps.overlay;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.amap.api.mapcore.C0344n;
import com.amap.api.mapcore.util.C0402s;
import com.amap.api.mapcore.util.C0405u;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.LatLngBounds.Builder;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.DrivePath;
import com.amap.api.services.route.DriveStep;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class DrivingRouteOverlay extends RouteOverlay {
    /* renamed from: a */
    private DrivePath f2536a;
    /* renamed from: b */
    private List<LatLonPoint> f2537b;
    /* renamed from: c */
    private List<Marker> f2538c;
    /* renamed from: d */
    private boolean f2539d;
    /* renamed from: e */
    private Context f2540e;

    public DrivingRouteOverlay(Context context, AMap aMap, DrivePath drivePath, LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
        this(context, aMap, drivePath, latLonPoint, latLonPoint2, null);
        this.f2540e = context;
    }

    public DrivingRouteOverlay(Context context, AMap aMap, DrivePath drivePath, LatLonPoint latLonPoint, LatLonPoint latLonPoint2, List<LatLonPoint> list) {
        super(context);
        this.f2538c = new ArrayList();
        this.f2539d = true;
        this.mAMap = aMap;
        this.f2536a = drivePath;
        this.startPoint = C0439a.m3780a(latLonPoint);
        this.endPoint = C0439a.m3780a(latLonPoint2);
        this.f2537b = list;
        this.f2540e = context;
    }

    public void addToMap() {
        try {
            List steps = this.f2536a.getSteps();
            for (int i = 0; i < steps.size(); i++) {
                DriveStep driveStep = (DriveStep) steps.get(i);
                LatLng a = C0439a.m3780a((LatLonPoint) driveStep.getPolyline().get(0));
                LatLng a2;
                if (i < steps.size() - 1) {
                    if (i == 0) {
                        this.allPolyLines.add(this.mAMap.addPolyline(new PolylineOptions().add(this.startPoint, a).color(getDriveColor()).width(getBuslineWidth())));
                    }
                    if (!C0439a.m3780a((LatLonPoint) driveStep.getPolyline().get(driveStep.getPolyline().size() - 1)).equals(C0439a.m3780a((LatLonPoint) ((DriveStep) steps.get(i + 1)).getPolyline().get(0)))) {
                        this.allPolyLines.add(this.mAMap.addPolyline(new PolylineOptions().add(r5, a2).color(getDriveColor()).width(getBuslineWidth())));
                    }
                } else {
                    a2 = C0439a.m3780a((LatLonPoint) driveStep.getPolyline().get(driveStep.getPolyline().size() - 1));
                    this.allPolyLines.add(this.mAMap.addPolyline(new PolylineOptions().add(a2, this.endPoint).color(getDriveColor()).width(getBuslineWidth())));
                }
                this.stationMarkers.add(this.mAMap.addMarker(new MarkerOptions().position(a).title("方向:" + driveStep.getAction() + "\n道路:" + driveStep.getRoad()).snippet(driveStep.getInstruction()).visible(this.nodeIconVisible).anchor(0.5f, 0.5f).icon(getDriveBitmapDescriptor())));
                this.allPolyLines.add(this.mAMap.addPolyline(new PolylineOptions().addAll(C0439a.m3781a(driveStep.getPolyline())).color(getDriveColor()).width(getBuslineWidth())));
            }
            addStartAndEndMarker();
            m3776a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m3776a() {
        if (this.f2537b != null && this.f2537b.size() > 0) {
            for (int i = 0; i < this.f2537b.size(); i++) {
                LatLonPoint latLonPoint = (LatLonPoint) this.f2537b.get(i);
                if (latLonPoint != null) {
                    this.f2538c.add(this.mAMap.addMarker(new MarkerOptions().position(new LatLng(latLonPoint.getLatitude(), latLonPoint.getLongitude())).visible(this.f2539d).icon(m3777b()).title("途经点")));
                }
            }
        }
    }

    protected LatLngBounds getLatLngBounds() {
        Builder builder = LatLngBounds.builder();
        builder.include(new LatLng(this.startPoint.latitude, this.startPoint.longitude));
        builder.include(new LatLng(this.endPoint.latitude, this.endPoint.longitude));
        if (this.f2537b != null && this.f2537b.size() > 0) {
            for (int i = 0; i < this.f2537b.size(); i++) {
                builder.include(new LatLng(((LatLonPoint) this.f2537b.get(i)).getLatitude(), ((LatLonPoint) this.f2537b.get(i)).getLongitude()));
            }
        }
        return builder.build();
    }

    public void setThroughPointIconVisibility(boolean z) {
        try {
            this.f2539d = z;
            if (this.f2538c != null && this.f2538c.size() > 0) {
                for (int i = 0; i < this.f2538c.size(); i++) {
                    ((Marker) this.f2538c.get(i)).setVisible(z);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    private BitmapDescriptor m3777b() {
        InputStream open;
        Throwable th;
        Throwable th2;
        Throwable th3;
        Bitmap a;
        InputStream inputStream = null;
        try {
            Bitmap decodeStream;
            open = C0402s.m3433a(this.f2540e).open("amap_throughpoint.png");
            try {
                decodeStream = BitmapFactory.decodeStream(open);
            } catch (Throwable th22) {
                th = th22;
                Object obj = inputStream;
                th3 = th;
                try {
                    th3.printStackTrace();
                    if (open != null) {
                        try {
                            open.close();
                        } catch (Throwable th32) {
                            th32.printStackTrace();
                        }
                    }
                    return BitmapDescriptorFactory.fromBitmap(a);
                } catch (Throwable th4) {
                    th22 = th4;
                    if (open != null) {
                        try {
                            open.close();
                        } catch (Throwable th322) {
                            th322.printStackTrace();
                        }
                    }
                    throw th22;
                }
            }
            try {
                a = C0405u.m3451a(decodeStream, C0344n.f1878a);
                if (open != null) {
                    try {
                        open.close();
                    } catch (Throwable th3222) {
                        th3222.printStackTrace();
                    }
                }
            } catch (Throwable th222) {
                th = th222;
                a = decodeStream;
                th3222 = th;
                th3222.printStackTrace();
                if (open != null) {
                    open.close();
                }
                return BitmapDescriptorFactory.fromBitmap(a);
            }
        } catch (Throwable th5) {
            th222 = th5;
            open = inputStream;
            if (open != null) {
                open.close();
            }
            throw th222;
        }
        return BitmapDescriptorFactory.fromBitmap(a);
    }

    protected float getBuslineWidth() {
        return 18.0f;
    }

    public void removeFromMap() {
        try {
            super.removeFromMap();
            if (this.f2538c != null && this.f2538c.size() > 0) {
                for (int i = 0; i < this.f2538c.size(); i++) {
                    ((Marker) this.f2538c.get(i)).remove();
                }
                this.f2538c.clear();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
