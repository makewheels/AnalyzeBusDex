package com.amap.api.navi.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.NavigateArrow;
import com.amap.api.maps.model.NavigateArrowOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.navi.AMapNavi;
import com.amap.api.navi.model.AMapNaviPath;
import com.amap.api.navi.model.AMapNaviStep;
import com.amap.api.navi.model.AMapTrafficStatus;
import com.amap.api.navi.model.NaviLatLng;
import com.autonavi.tbt.C0615f;
import com.autonavi.tbt.C0617g;
import com.e4a.runtime.components.Component;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class RouteOverLay {
    private AMap aMap;
    private BitmapDescriptor aolrResource = null;
    private int arrowHLen = 50;
    private BitmapDescriptor badResource = null;
    private boolean emulateGPSLocationVisibility = true;
    Bitmap endBitmap;
    private Marker endMarker;
    private List<Circle> gpsCircles = null;
    private BitmapDescriptor grayredResource = null;
    private BitmapDescriptor greenResource = null;
    private Polyline guideLink = null;
    private boolean isTrafficLine = false;
    private Context mContext;
    private Polyline mPolyline;
    private AMapNaviPath mRouteInfo = null;
    private float mWidth = 35.0f;
    private List<LatLng> mapList;
    private NavigateArrow naviArrow = null;
    private BitmapDescriptor noResource = null;
    List<Polyline> polylineList = new ArrayList();
    BitmapDescriptor routeResource = null;
    private BitmapDescriptor slowResource = null;
    Bitmap startBitmap;
    private Marker startMarker;
    Bitmap wayBitmap;
    private List<Marker> wayMarker;

    void setRouteResource(BitmapDescriptor bitmapDescriptor) {
        this.routeResource = bitmapDescriptor;
    }

    public void setRouteInfo(AMapNaviPath aMapNaviPath) {
        this.mRouteInfo = aMapNaviPath;
    }

    public RouteOverLay(AMap aMap, AMapNaviPath aMapNaviPath) {
        init(aMap, aMapNaviPath);
    }

    public RouteOverLay(AMap aMap, AMapNaviPath aMapNaviPath, Context context) {
        this.mContext = context;
        init(aMap, aMapNaviPath);
    }

    private void init(AMap aMap, AMapNaviPath aMapNaviPath) {
        try {
            this.aMap = aMap;
            this.mRouteInfo = aMapNaviPath;
            this.routeResource = BitmapDescriptorFactory.fromAsset("custtexture.png");
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
        this.aolrResource = BitmapDescriptorFactory.fromAsset("custtexture_aolr.png");
        this.greenResource = BitmapDescriptorFactory.fromAsset("custtexture_green.png");
        this.noResource = BitmapDescriptorFactory.fromAsset("custtexture_no.png");
        this.slowResource = BitmapDescriptorFactory.fromAsset("custtexture_slow.png");
        this.badResource = BitmapDescriptorFactory.fromAsset("custtexture_bad.png");
        this.grayredResource = BitmapDescriptorFactory.fromAsset("custtexture_grayred.png");
    }

    public void addToMap() {
        LatLng latLng = null;
        try {
            if (this.aMap != null) {
                if (this.mPolyline != null) {
                    this.mPolyline.remove();
                    this.mPolyline = null;
                }
                if (this.mWidth != 0.0f && this.mRouteInfo != null && this.routeResource != null) {
                    if (this.naviArrow != null) {
                        this.naviArrow.setVisible(false);
                    }
                    List<NaviLatLng> coordList = this.mRouteInfo.getCoordList();
                    if (coordList != null) {
                        this.mapList = new ArrayList(coordList.size());
                        for (NaviLatLng naviLatLng : coordList) {
                            this.mapList.add(new LatLng(naviLatLng.getLatitude(), naviLatLng.getLongitude(), false));
                        }
                        if (this.mapList.size() != 0) {
                            LatLng latLng2;
                            colorWayClear();
                            this.mPolyline = this.aMap.addPolyline(new PolylineOptions().addAll(this.mapList).setCustomTexture(this.routeResource).width(this.mWidth));
                            this.mPolyline.setVisible(true);
                            List list;
                            if (this.mRouteInfo.getStartPoint() == null || this.mRouteInfo.getEndPoint() == null) {
                                list = null;
                                latLng2 = null;
                            } else {
                                LatLng latLng3 = new LatLng(this.mRouteInfo.getStartPoint().getLatitude(), this.mRouteInfo.getStartPoint().getLongitude());
                                latLng = new LatLng(this.mRouteInfo.getEndPoint().getLatitude(), this.mRouteInfo.getEndPoint().getLongitude());
                                list = this.mRouteInfo.getWayPoint();
                                latLng2 = latLng3;
                            }
                            if (this.startMarker != null) {
                                this.startMarker.remove();
                                this.startMarker = null;
                            }
                            if (this.endMarker != null) {
                                this.endMarker.remove();
                                this.endMarker = null;
                            }
                            if (this.wayMarker != null && this.wayMarker.size() > 0) {
                                for (int i = 0; i < this.wayMarker.size(); i++) {
                                    Marker marker = (Marker) this.wayMarker.get(i);
                                    if (marker != null) {
                                        marker.remove();
                                    }
                                }
                            }
                            if (this.startBitmap == null) {
                                this.startMarker = this.aMap.addMarker(new MarkerOptions().position(latLng2).icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(C0617g.m4842a(), 2130837639))));
                            } else {
                                this.startMarker = this.aMap.addMarker(new MarkerOptions().position(latLng2).icon(BitmapDescriptorFactory.fromBitmap(this.startBitmap)));
                            }
                            if (r3 != null && r3.size() > 0) {
                                int size = r3.size();
                                if (this.wayMarker == null) {
                                    this.wayMarker = new ArrayList(size);
                                }
                                for (NaviLatLng naviLatLng2 : r3) {
                                    Object addMarker;
                                    LatLng latLng4 = new LatLng(naviLatLng2.getLatitude(), naviLatLng2.getLongitude());
                                    if (this.wayBitmap == null) {
                                        addMarker = this.aMap.addMarker(new MarkerOptions().position(latLng4).icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(C0617g.m4842a(), 2130837648))));
                                    } else {
                                        addMarker = this.aMap.addMarker(new MarkerOptions().position(latLng4).icon(BitmapDescriptorFactory.fromBitmap(this.wayBitmap)));
                                    }
                                    this.wayMarker.add(addMarker);
                                }
                            }
                            if (this.endBitmap == null) {
                                this.endMarker = this.aMap.addMarker(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(C0617g.m4842a(), 2130837517))));
                            } else {
                                this.endMarker = this.aMap.addMarker(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromBitmap(this.endBitmap)));
                            }
                            if (this.isTrafficLine) {
                                setTrafficLine(Boolean.valueOf(this.isTrafficLine));
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
    }

    public void drawGuideLink(LatLng latLng, LatLng latLng2, boolean z) {
        if (z) {
            Object arrayList = new ArrayList(2);
            arrayList.add(latLng);
            arrayList.add(latLng2);
            if (this.guideLink == null) {
                this.guideLink = this.aMap.addPolyline(new PolylineOptions().addAll(arrayList).width(this.mWidth / 3.0f).setDottedLine(true));
            } else {
                this.guideLink.setPoints(arrayList);
            }
            this.guideLink.setVisible(true);
        } else if (this.guideLink != null) {
            this.guideLink.setVisible(false);
        }
    }

    public void drawEmulateGPSLocation(Vector<String> vector) {
        try {
            if (this.gpsCircles == null) {
                this.gpsCircles = new ArrayList(vector.size());
            } else {
                for (Circle remove : this.gpsCircles) {
                    remove.remove();
                }
                this.gpsCircles.clear();
            }
            Iterator it = vector.iterator();
            while (it.hasNext()) {
                String[] split = ((String) it.next()).split(",");
                if (split != null && split.length >= 11) {
                    this.gpsCircles.add(this.aMap.addCircle(new CircleOptions().center(new LatLng(Double.parseDouble(split[0]), Double.parseDouble(split[1]))).radius(1.5d).strokeWidth(0.0f).fillColor(Component.f3916)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setEmulateGPSLocationVisible() {
        if (this.gpsCircles != null) {
            this.emulateGPSLocationVisibility = !this.emulateGPSLocationVisibility;
            for (Circle visible : this.gpsCircles) {
                visible.setVisible(this.emulateGPSLocationVisibility);
            }
        }
    }

    public void setStartPointBitmap(Bitmap bitmap) {
        this.startBitmap = bitmap;
    }

    public void setWayPointBitmap(Bitmap bitmap) {
        this.wayBitmap = bitmap;
    }

    public void setEndPointBitmap(Bitmap bitmap) {
        this.endBitmap = bitmap;
    }

    public void removeFromMap() {
        try {
            if (this.mPolyline != null) {
                this.mPolyline.setVisible(false);
            }
            if (this.startMarker != null) {
                this.startMarker.setVisible(false);
            }
            if (this.wayMarker != null) {
                for (Marker visible : this.wayMarker) {
                    visible.setVisible(false);
                }
            }
            if (this.endMarker != null) {
                this.endMarker.setVisible(false);
            }
            if (this.naviArrow != null) {
                this.naviArrow.remove();
            }
            if (this.guideLink != null) {
                this.guideLink.setVisible(false);
            }
            if (this.gpsCircles != null) {
                for (Circle visible2 : this.gpsCircles) {
                    visible2.setVisible(false);
                }
            }
            colorWayClear();
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
    }

    private void colorWayClear() {
        if (this.polylineList.size() > 0) {
            for (int i = 0; i < this.polylineList.size(); i++) {
                if (this.polylineList.get(i) != null) {
                    ((Polyline) this.polylineList.get(i)).remove();
                }
            }
        }
        this.polylineList.clear();
    }

    private void colorWayUpdate(List<AMapTrafficStatus> list) {
        if (this.aMap != null && this.mapList != null && this.mapList.size() > 0 && list != null && list.size() > 0) {
            colorWayClear();
            int i = 0;
            LatLng latLng = (LatLng) this.mapList.get(0);
            double d = 0.0d;
            Object arrayList = new ArrayList();
            Object obj = null;
            int i2 = 0;
            LatLng latLng2 = latLng;
            while (i2 < this.mapList.size()) {
                int i3;
                LatLng latLng3;
                int i4;
                int i5;
                AMapTrafficStatus aMapTrafficStatus = (AMapTrafficStatus) list.get(i);
                LatLng latLng4 = (LatLng) this.mapList.get(i2);
                NaviLatLng naviLatLng = new NaviLatLng(latLng2.latitude, latLng2.longitude);
                NaviLatLng naviLatLng2 = new NaviLatLng(latLng4.latitude, latLng4.longitude);
                double a = (double) C0615f.m4826a(naviLatLng, naviLatLng2);
                d += a;
                if (d > ((double) (aMapTrafficStatus.getLength() + 1))) {
                    NaviLatLng a2 = C0615f.m4828a(naviLatLng, naviLatLng2, a - (d - ((double) aMapTrafficStatus.getLength())));
                    latLng2 = new LatLng(a2.getLatitude(), a2.getLongitude());
                    arrayList.add(latLng2);
                    i3 = i2 - 1;
                    latLng3 = latLng2;
                } else {
                    arrayList.add(latLng4);
                    i4 = i2;
                    latLng3 = latLng4;
                    i3 = i4;
                }
                if (d >= ((double) aMapTrafficStatus.getLength()) || i3 == this.mapList.size() - 1) {
                    Object addPolyline;
                    int i6 = i + 1;
                    if (i6 == list.size() - 1 && i3 < this.mapList.size() - 1) {
                        int i7 = i3 + 1;
                        while (i7 < this.mapList.size()) {
                            arrayList.add((LatLng) this.mapList.get(i7));
                            i7++;
                        }
                        i3 = i7;
                    }
                    switch (aMapTrafficStatus.getStatus()) {
                        case 0:
                            addPolyline = this.aMap.addPolyline(new PolylineOptions().addAll(arrayList).width(this.mWidth).setCustomTexture(this.noResource));
                            break;
                        case 1:
                            addPolyline = this.aMap.addPolyline(new PolylineOptions().addAll(arrayList).width(this.mWidth).setCustomTexture(this.greenResource));
                            break;
                        case 2:
                            addPolyline = this.aMap.addPolyline(new PolylineOptions().addAll(arrayList).width(this.mWidth).setCustomTexture(this.slowResource));
                            break;
                        case 3:
                            addPolyline = this.aMap.addPolyline(new PolylineOptions().addAll(arrayList).width(this.mWidth).setCustomTexture(this.badResource));
                            break;
                        case 4:
                            addPolyline = this.aMap.addPolyline(new PolylineOptions().addAll(arrayList).width(this.mWidth).setCustomTexture(this.grayredResource));
                            break;
                        default:
                            addPolyline = obj;
                            break;
                    }
                    this.polylineList.add(addPolyline);
                    arrayList.clear();
                    arrayList.add(latLng3);
                    i4 = i3;
                    i3 = i6;
                    Object obj2 = addPolyline;
                    i5 = i4;
                    d = 0.0d;
                    obj = obj2;
                } else {
                    i5 = i3;
                    i3 = i;
                }
                latLng2 = latLng3;
                i = i3;
                i2 = i5 + 1;
            }
            this.polylineList.add(this.aMap.addPolyline(new PolylineOptions().addAll(this.mapList).width(this.mWidth).setCustomTexture(this.aolrResource)));
        }
    }

    public void zoomToSpan() {
        try {
            if (this.mRouteInfo != null) {
                this.aMap.animateCamera(CameraUpdateFactory.newLatLngBounds(this.mRouteInfo.getBoundsForPath(), 100), 1000, null);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
    }

    public void destroy() {
        try {
            if (this.mPolyline != null) {
                this.mPolyline.remove();
            }
            this.mRouteInfo = null;
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
    }

    public void drawArrow(List<NaviLatLng> list) {
        if (list == null) {
            try {
                this.naviArrow.setVisible(false);
                return;
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        Object arrayList = new ArrayList(list.size());
        for (NaviLatLng naviLatLng : list) {
            arrayList.add(new LatLng(naviLatLng.getLatitude(), naviLatLng.getLongitude(), false));
        }
        if (this.naviArrow == null) {
            this.naviArrow = this.aMap.addNavigateArrow(new NavigateArrowOptions().addAll(arrayList).width(20.0f));
        } else {
            this.naviArrow.setPoints(arrayList);
        }
        this.naviArrow.setZIndex(1.0f);
        this.naviArrow.setVisible(true);
    }

    public List<NaviLatLng> getArrowPoints(int i) {
        int i2 = 0;
        if (this.mRouteInfo == null) {
            return null;
        }
        try {
            if (i >= this.mRouteInfo.getStepsCount()) {
                return null;
            }
            List coordList = this.mRouteInfo.getCoordList();
            int size = coordList.size();
            int endIndex = ((AMapNaviStep) this.mRouteInfo.getSteps().get(i)).getEndIndex();
            NaviLatLng naviLatLng = (NaviLatLng) coordList.get(endIndex);
            Vector vector = new Vector();
            int i3 = endIndex - 1;
            int i4 = 0;
            NaviLatLng naviLatLng2 = naviLatLng;
            while (i3 >= 0) {
                NaviLatLng naviLatLng3 = (NaviLatLng) coordList.get(i3);
                int a = C0615f.m4826a(naviLatLng2, naviLatLng3);
                i4 += a;
                if (i4 >= this.arrowHLen) {
                    vector.add(C0615f.m4828a(naviLatLng2, naviLatLng3, (double) ((this.arrowHLen + a) - i4)));
                    break;
                }
                vector.add(naviLatLng3);
                i3--;
                naviLatLng2 = naviLatLng3;
            }
            Collections.reverse(vector);
            vector.add(naviLatLng);
            int i5 = endIndex + 1;
            NaviLatLng naviLatLng4 = naviLatLng;
            while (i5 < size) {
                naviLatLng = (NaviLatLng) coordList.get(i5);
                i4 = C0615f.m4826a(naviLatLng4, naviLatLng);
                i2 += i4;
                if (i2 >= this.arrowHLen) {
                    vector.add(C0615f.m4828a(naviLatLng4, naviLatLng, (double) ((this.arrowHLen + i4) - i2)));
                    break;
                }
                vector.add(naviLatLng);
                i5++;
                naviLatLng4 = naviLatLng;
            }
            if (vector.size() > 2) {
                return vector;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setTrafficLine(Boolean bool) {
        try {
            if (this.mContext != null) {
                this.isTrafficLine = bool.booleanValue();
                List list = null;
                colorWayClear();
                if (this.isTrafficLine) {
                    if (this.mRouteInfo != null) {
                        list = AMapNavi.getInstance(this.mContext).getTrafficStatuses(0, this.mRouteInfo.getAllLength());
                    }
                    colorWayUpdate(list);
                } else if (this.mPolyline != null) {
                    this.mPolyline.setVisible(true);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean isTrafficLine() {
        return this.isTrafficLine;
    }
}
