package com.amap.api.maps2d.overlay;

import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.model.BitmapDescriptor;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.LatLngBounds;
import com.amap.api.maps2d.model.LatLngBounds.Builder;
import com.amap.api.maps2d.model.Marker;
import com.amap.api.maps2d.model.MarkerOptions;
import com.amap.api.services.core.PoiItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PoiOverlay {
    /* renamed from: a */
    private List<PoiItem> f2677a;
    /* renamed from: b */
    private AMap f2678b;
    /* renamed from: c */
    private ArrayList<Marker> f2679c = new ArrayList();

    public PoiOverlay(AMap aMap, List<PoiItem> list) {
        this.f2678b = aMap;
        this.f2677a = list;
    }

    public void addToMap() {
        for (int i = 0; i < this.f2677a.size(); i++) {
            Marker addMarker = this.f2678b.addMarker(m3815a(i));
            addMarker.setObject(Integer.valueOf(i));
            this.f2679c.add(addMarker);
        }
    }

    public void removeFromMap() {
        Iterator it = this.f2679c.iterator();
        while (it.hasNext()) {
            ((Marker) it.next()).remove();
        }
    }

    public void zoomToSpan() {
        if (this.f2677a != null && this.f2677a.size() > 0 && this.f2678b != null) {
            this.f2678b.moveCamera(CameraUpdateFactory.newLatLngBounds(m3814a(), 5));
        }
    }

    /* renamed from: a */
    private LatLngBounds m3814a() {
        Builder builder = LatLngBounds.builder();
        for (int i = 0; i < this.f2677a.size(); i++) {
            builder.include(new LatLng(((PoiItem) this.f2677a.get(i)).getLatLonPoint().getLatitude(), ((PoiItem) this.f2677a.get(i)).getLatLonPoint().getLongitude()));
        }
        return builder.build();
    }

    /* renamed from: a */
    private MarkerOptions m3815a(int i) {
        return new MarkerOptions().position(new LatLng(((PoiItem) this.f2677a.get(i)).getLatLonPoint().getLatitude(), ((PoiItem) this.f2677a.get(i)).getLatLonPoint().getLongitude())).title(getTitle(i)).snippet(getSnippet(i)).icon(getBitmapDescriptor(i));
    }

    protected BitmapDescriptor getBitmapDescriptor(int i) {
        return null;
    }

    protected String getTitle(int i) {
        return ((PoiItem) this.f2677a.get(i)).getTitle();
    }

    protected String getSnippet(int i) {
        return ((PoiItem) this.f2677a.get(i)).getSnippet();
    }

    public int getPoiIndex(Marker marker) {
        for (int i = 0; i < this.f2679c.size(); i++) {
            if (((Marker) this.f2679c.get(i)).equals(marker)) {
                return i;
            }
        }
        return -1;
    }

    public PoiItem getPoiItem(int i) {
        if (i < 0 || i >= this.f2677a.size()) {
            return null;
        }
        return (PoiItem) this.f2677a.get(i);
    }
}
