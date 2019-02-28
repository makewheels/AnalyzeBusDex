package com.amap.api.maps2d.overlay;

import android.content.Context;
import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.MarkerOptions;
import com.amap.api.maps2d.model.PolylineOptions;
import com.amap.api.p015a.C0269x;
import com.amap.api.services.busline.BusStationItem;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.BusPath;
import com.amap.api.services.route.BusStep;
import com.amap.api.services.route.Doorway;
import com.amap.api.services.route.RouteBusLineItem;
import com.amap.api.services.route.WalkStep;
import java.util.List;

public class BusRouteOverlay extends RouteOverlay {
    /* renamed from: a */
    private BusPath f2674a;
    /* renamed from: b */
    private LatLng f2675b;

    public BusRouteOverlay(Context context, AMap aMap, BusPath busPath, LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
        super(context);
        this.f2674a = busPath;
        this.startPoint = C0441a.m3817a(latLonPoint);
        this.endPoint = C0441a.m3817a(latLonPoint2);
        this.mAMap = aMap;
    }

    public void addToMap() {
        List steps = this.f2674a.getSteps();
        for (int i = 0; i < steps.size(); i++) {
            LatLng a;
            LatLng a2;
            BusStep busStep = (BusStep) steps.get(i);
            if (i < steps.size() - 1) {
                LatLng a3;
                LatLonPoint b;
                BusStep busStep2 = (BusStep) steps.get(i + 1);
                if (!(busStep.getWalk() == null || busStep.getBusLine() == null)) {
                    a3 = C0441a.m3817a((LatLonPoint) ((WalkStep) busStep.getWalk().getSteps().get(busStep.getWalk().getSteps().size() - 1)).getPolyline().get(((WalkStep) busStep.getWalk().getSteps().get(busStep.getWalk().getSteps().size() - 1)).getPolyline().size() - 1));
                    b = m3813b(busStep);
                    if (b == null) {
                        b = (LatLonPoint) busStep.getBusLine().getPolyline().get(0);
                    }
                    a = C0441a.m3817a(b);
                    this.allPolyLines.add(this.mAMap.addPolyline(new PolylineOptions().add(a3, a).width(getBuslineWidth()).color(getWalkColor())));
                }
                if (!(busStep.getBusLine() == null || busStep2.getWalk() == null)) {
                    LatLonPoint a4 = m3810a(busStep);
                    b = (LatLonPoint) busStep.getBusLine().getPolyline().get(busStep.getBusLine().getPolyline().size() - 1);
                    if (a4 != null) {
                        a = C0441a.m3817a(b);
                        LatLng a5 = C0441a.m3817a(a4);
                        this.allPolyLines.add(this.mAMap.addPolyline(new PolylineOptions().add(a, a5).width(getBuslineWidth()).color(getWalkColor())));
                        b = a4;
                    }
                    a3 = C0441a.m3817a(b);
                    a = C0441a.m3817a((LatLonPoint) ((WalkStep) busStep2.getWalk().getSteps().get(0)).getPolyline().get(0));
                    this.allPolyLines.add(this.mAMap.addPolyline(new PolylineOptions().add(a3, a).width(getBuslineWidth()).color(getWalkColor())));
                }
                if (!(busStep.getBusLine() == null || busStep2.getWalk() != null || busStep2.getBusLine() == null)) {
                    b = m3810a(busStep);
                    if (b == null) {
                        b = (LatLonPoint) busStep.getBusLine().getPolyline().get(busStep.getBusLine().getPolyline().size() - 1);
                    }
                    a3 = C0441a.m3817a(b);
                    b = m3813b(busStep2);
                    if (b == null) {
                        b = (LatLonPoint) busStep2.getBusLine().getPolyline().get(0);
                    }
                    drawLineArrow(a3, C0441a.m3817a(b));
                }
                if (!(busStep.getBusLine() == null || busStep2.getWalk() != null || busStep2.getBusLine() == null)) {
                    a = C0441a.m3817a((LatLonPoint) busStep.getBusLine().getPolyline().get(busStep.getBusLine().getPolyline().size() - 1));
                    a2 = C0441a.m3817a((LatLonPoint) busStep2.getBusLine().getPolyline().get(0));
                    if (a2.latitude - a.latitude > 1.0E-4d || a2.longitude - a.longitude > 1.0E-4d) {
                        drawLineArrow(a, a2);
                    }
                }
                if (!(busStep.getWalk() == null || busStep.getBusLine() == null)) {
                    LatLonPoint b2 = m3813b(busStep);
                    if (b2 == null) {
                        b2 = (LatLonPoint) ((WalkStep) busStep.getWalk().getSteps().get(busStep.getWalk().getSteps().size() - 1)).getPolyline().get(((WalkStep) busStep.getWalk().getSteps().get(busStep.getWalk().getSteps().size() - 1)).getPolyline().size() - 1);
                    }
                    a = C0441a.m3817a(b2);
                    a2 = C0441a.m3817a((LatLonPoint) busStep.getBusLine().getPolyline().get(0));
                    this.allPolyLines.add(this.mAMap.addPolyline(new PolylineOptions().add(a, a2).width(3.0f).color(getWalkColor()).width(getBuslineWidth())));
                }
            }
            if (busStep.getWalk() != null && busStep.getWalk().getSteps().size() > 0) {
                List steps2 = busStep.getWalk().getSteps();
                for (int i2 = 0; i2 < steps2.size(); i2++) {
                    WalkStep walkStep = (WalkStep) steps2.get(i2);
                    a = C0441a.m3817a((LatLonPoint) walkStep.getPolyline().get(0));
                    String road = walkStep.getRoad();
                    String a6 = m3812a(steps2);
                    List a7 = C0441a.m3818a(walkStep.getPolyline());
                    this.f2675b = (LatLng) a7.get(a7.size() - 1);
                    if (i2 == 0) {
                        this.stationMarkers.add(this.mAMap.addMarker(new MarkerOptions().position(a).title(road).snippet(a6).anchor(0.5f, 0.5f).icon(getWalkBitmapDescriptor())));
                    }
                    this.allPolyLines.add(this.mAMap.addPolyline(new PolylineOptions().addAll(a7).color(getWalkColor()).width(getBuslineWidth())));
                    if (i2 < steps2.size() - 1) {
                        if (!((LatLng) a7.get(a7.size() - 1)).equals(C0441a.m3817a((LatLonPoint) ((WalkStep) steps2.get(i2 + 1)).getPolyline().get(0)))) {
                            this.allPolyLines.add(this.mAMap.addPolyline(new PolylineOptions().add(a2, a).width(getBuslineWidth()).color(getWalkColor())));
                        }
                    }
                }
            } else if (busStep.getBusLine() == null) {
                this.allPolyLines.add(this.mAMap.addPolyline(new PolylineOptions().add(this.f2675b, this.endPoint).color(getWalkColor()).width(getBuslineWidth())));
            }
            if (busStep.getBusLine() != null) {
                RouteBusLineItem busLine = busStep.getBusLine();
                Iterable a8 = C0441a.m3818a(busLine.getPolyline());
                BusStationItem departureBusStation = busLine.getDepartureBusStation();
                this.allPolyLines.add(this.mAMap.addPolyline(new PolylineOptions().addAll(a8).color(getBusColor()).width(getBuslineWidth())));
                this.stationMarkers.add(this.mAMap.addMarker(new MarkerOptions().position(C0441a.m3817a(departureBusStation.getLatLonPoint())).title(busLine.getBusLineName()).snippet(m3811a(busLine)).anchor(0.5f, 0.5f).icon(getBusBitmapDescriptor())));
            }
        }
        addStartAndEndMarker();
    }

    /* renamed from: a */
    private String m3812a(List<WalkStep> list) {
        float f = 0.0f;
        for (WalkStep distance : list) {
            f = distance.getDistance() + f;
        }
        return "步行" + f + "米";
    }

    public void drawLineArrow(LatLng latLng, LatLng latLng2) {
        this.mAMap.addPolyline(new PolylineOptions().add(latLng, latLng2).width(3.0f).color(getBusColor()).width(getBuslineWidth()));
    }

    /* renamed from: a */
    private String m3811a(RouteBusLineItem routeBusLineItem) {
        return "(" + routeBusLineItem.getDepartureBusStation().getBusStationName() + "-->" + routeBusLineItem.getArrivalBusStation().getBusStationName() + ") 经过" + (routeBusLineItem.getPassStationNum() + 1) + "站";
    }

    protected float getBuslineWidth() {
        return C0269x.f1181b;
    }

    /* renamed from: a */
    private LatLonPoint m3810a(BusStep busStep) {
        Doorway exit = busStep.getExit();
        if (exit == null) {
            return null;
        }
        return exit.getLatLonPoint();
    }

    /* renamed from: b */
    private LatLonPoint m3813b(BusStep busStep) {
        Doorway entrance = busStep.getEntrance();
        if (entrance == null) {
            return null;
        }
        return entrance.getLatLonPoint();
    }
}
