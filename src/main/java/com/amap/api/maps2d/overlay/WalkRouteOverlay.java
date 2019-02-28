package com.amap.api.maps2d.overlay;

import android.content.Context;
import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.MarkerOptions;
import com.amap.api.maps2d.model.PolylineOptions;
import com.amap.api.p015a.C0269x;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.WalkPath;
import com.amap.api.services.route.WalkStep;
import java.util.List;

public class WalkRouteOverlay extends RouteOverlay {
    /* renamed from: a */
    private WalkPath f2680a;

    public WalkRouteOverlay(Context context, AMap aMap, WalkPath walkPath, LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
        super(context);
        this.mAMap = aMap;
        this.f2680a = walkPath;
        this.startPoint = C0441a.m3817a(latLonPoint);
        this.endPoint = C0441a.m3817a(latLonPoint2);
    }

    public void addToMap() {
        List steps = this.f2680a.getSteps();
        for (int i = 0; i < steps.size(); i++) {
            WalkStep walkStep = (WalkStep) steps.get(i);
            LatLng a = C0441a.m3817a((LatLonPoint) walkStep.getPolyline().get(0));
            LatLng a2;
            if (i < steps.size() - 1) {
                if (i == 0) {
                    this.allPolyLines.add(this.mAMap.addPolyline(new PolylineOptions().add(this.startPoint, a).color(getWalkColor()).width(getBuslineWidth())));
                }
                if (!C0441a.m3817a((LatLonPoint) walkStep.getPolyline().get(walkStep.getPolyline().size() - 1)).equals(C0441a.m3817a((LatLonPoint) ((WalkStep) steps.get(i + 1)).getPolyline().get(0)))) {
                    this.allPolyLines.add(this.mAMap.addPolyline(new PolylineOptions().add(r6, a2).color(getWalkColor()).width(getBuslineWidth())));
                }
            } else {
                a2 = C0441a.m3817a((LatLonPoint) walkStep.getPolyline().get(walkStep.getPolyline().size() - 1));
                this.allPolyLines.add(this.mAMap.addPolyline(new PolylineOptions().add(a2, this.endPoint).color(getWalkColor()).width(getBuslineWidth())));
            }
            this.stationMarkers.add(this.mAMap.addMarker(new MarkerOptions().position(a).title("方向:" + walkStep.getAction() + "\n道路:" + walkStep.getRoad()).snippet(walkStep.getInstruction()).anchor(0.5f, 0.5f).icon(getWalkBitmapDescriptor())));
            this.allPolyLines.add(this.mAMap.addPolyline(new PolylineOptions().addAll(C0441a.m3818a(walkStep.getPolyline())).color(getWalkColor()).width(getBuslineWidth())));
        }
        addStartAndEndMarker();
    }

    protected float getBuslineWidth() {
        return C0269x.f1181b;
    }
}
