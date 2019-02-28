package com.amap.api.maps.overlay;

import android.content.Context;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.WalkPath;
import com.amap.api.services.route.WalkStep;
import java.util.List;

public class WalkRouteOverlay extends RouteOverlay {
    /* renamed from: a */
    private WalkPath f2544a;

    public WalkRouteOverlay(Context context, AMap aMap, WalkPath walkPath, LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
        super(context);
        this.mAMap = aMap;
        this.f2544a = walkPath;
        this.startPoint = C0439a.m3780a(latLonPoint);
        this.endPoint = C0439a.m3780a(latLonPoint2);
    }

    public void addToMap() {
        try {
            List steps = this.f2544a.getSteps();
            for (int i = 0; i < steps.size(); i++) {
                WalkStep walkStep = (WalkStep) steps.get(i);
                LatLng a = C0439a.m3780a((LatLonPoint) walkStep.getPolyline().get(0));
                LatLng a2;
                if (i < steps.size() - 1) {
                    if (i == 0) {
                        this.allPolyLines.add(this.mAMap.addPolyline(new PolylineOptions().add(this.startPoint, a).color(getWalkColor()).width(getBuslineWidth())));
                    }
                    if (!C0439a.m3780a((LatLonPoint) walkStep.getPolyline().get(walkStep.getPolyline().size() - 1)).equals(C0439a.m3780a((LatLonPoint) ((WalkStep) steps.get(i + 1)).getPolyline().get(0)))) {
                        this.allPolyLines.add(this.mAMap.addPolyline(new PolylineOptions().add(r5, a2).color(getWalkColor()).width(getBuslineWidth())));
                    }
                } else {
                    a2 = C0439a.m3780a((LatLonPoint) walkStep.getPolyline().get(walkStep.getPolyline().size() - 1));
                    this.allPolyLines.add(this.mAMap.addPolyline(new PolylineOptions().add(a2, this.endPoint).color(getWalkColor()).width(getBuslineWidth())));
                }
                this.stationMarkers.add(this.mAMap.addMarker(new MarkerOptions().position(a).title("方向:" + walkStep.getAction() + "\n道路:" + walkStep.getRoad()).snippet(walkStep.getInstruction()).visible(this.nodeIconVisible).anchor(0.5f, 0.5f).icon(getWalkBitmapDescriptor())));
                this.allPolyLines.add(this.mAMap.addPolyline(new PolylineOptions().addAll(C0439a.m3781a(walkStep.getPolyline())).color(getWalkColor()).width(getBuslineWidth())));
            }
            addStartAndEndMarker();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    protected float getBuslineWidth() {
        return 18.0f;
    }
}
