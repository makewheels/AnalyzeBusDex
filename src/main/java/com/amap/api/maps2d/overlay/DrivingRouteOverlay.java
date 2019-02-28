package com.amap.api.maps2d.overlay;

import android.content.Context;
import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.MarkerOptions;
import com.amap.api.maps2d.model.PolylineOptions;
import com.amap.api.p015a.C0269x;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.DrivePath;
import com.amap.api.services.route.DriveStep;
import java.util.List;

public class DrivingRouteOverlay extends RouteOverlay {
    /* renamed from: a */
    private DrivePath f2676a;

    public DrivingRouteOverlay(Context context, AMap aMap, DrivePath drivePath, LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
        super(context);
        this.mAMap = aMap;
        this.f2676a = drivePath;
        this.startPoint = C0441a.m3817a(latLonPoint);
        this.endPoint = C0441a.m3817a(latLonPoint2);
    }

    public void addToMap() {
        List steps = this.f2676a.getSteps();
        for (int i = 0; i < steps.size(); i++) {
            DriveStep driveStep = (DriveStep) steps.get(i);
            LatLng a = C0441a.m3817a((LatLonPoint) driveStep.getPolyline().get(0));
            LatLng a2;
            if (i < steps.size() - 1) {
                if (i == 0) {
                    this.allPolyLines.add(this.mAMap.addPolyline(new PolylineOptions().add(this.startPoint, a).color(getDriveColor()).width(getBuslineWidth())));
                }
                if (!C0441a.m3817a((LatLonPoint) driveStep.getPolyline().get(driveStep.getPolyline().size() - 1)).equals(C0441a.m3817a((LatLonPoint) ((DriveStep) steps.get(i + 1)).getPolyline().get(0)))) {
                    this.allPolyLines.add(this.mAMap.addPolyline(new PolylineOptions().add(r6, a2).color(getDriveColor()).width(getBuslineWidth())));
                }
            } else {
                a2 = C0441a.m3817a((LatLonPoint) driveStep.getPolyline().get(driveStep.getPolyline().size() - 1));
                this.allPolyLines.add(this.mAMap.addPolyline(new PolylineOptions().add(a2, this.endPoint).color(getDriveColor()).width(getBuslineWidth())));
            }
            this.stationMarkers.add(this.mAMap.addMarker(new MarkerOptions().position(a).title("方向:" + driveStep.getAction() + "\n道路:" + driveStep.getRoad()).snippet(driveStep.getInstruction()).anchor(0.5f, 0.5f).icon(getDriveBitmapDescriptor())));
            this.allPolyLines.add(this.mAMap.addPolyline(new PolylineOptions().addAll(C0441a.m3818a(driveStep.getPolyline())).color(getDriveColor()).width(getBuslineWidth())));
        }
        addStartAndEndMarker();
    }

    protected float getBuslineWidth() {
        return C0269x.f1181b;
    }
}
