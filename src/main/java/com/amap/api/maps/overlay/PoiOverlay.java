package com.amap.api.maps.overlay;

import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.LatLngBounds.Builder;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.services.core.PoiItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PoiOverlay {
    /* renamed from: a */
    private List<PoiItem> f2541a;
    /* renamed from: b */
    private AMap f2542b;
    /* renamed from: c */
    private ArrayList<Marker> f2543c = new ArrayList();

    public PoiOverlay(AMap aMap, List<PoiItem> list) {
        this.f2542b = aMap;
        this.f2541a = list;
    }

    public void addToMap() {
        int i = 0;
        while (i < this.f2541a.size()) {
            try {
                Marker addMarker = this.f2542b.addMarker(m3779a(i));
                addMarker.setObject(Integer.valueOf(i));
                this.f2543c.add(addMarker);
                i++;
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
    }

    public void removeFromMap() {
        Iterator it = this.f2543c.iterator();
        while (it.hasNext()) {
            ((Marker) it.next()).remove();
        }
    }

    public void zoomToSpan() {
        try {
            if (this.f2541a != null && this.f2541a.size() > 0 && this.f2542b != null) {
                if (this.f2541a.size() == 1) {
                    this.f2542b.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(((PoiItem) this.f2541a.get(0)).getLatLonPoint().getLatitude(), ((PoiItem) this.f2541a.get(0)).getLatLonPoint().getLongitude()), 18.0f));
                    return;
                }
                this.f2542b.moveCamera(CameraUpdateFactory.newLatLngBounds(m3778a(), 5));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    private LatLngBounds m3778a() {
        Builder builder = LatLngBounds.builder();
        for (int i = 0; i < this.f2541a.size(); i++) {
            builder.include(new LatLng(((PoiItem) this.f2541a.get(i)).getLatLonPoint().getLatitude(), ((PoiItem) this.f2541a.get(i)).getLatLonPoint().getLongitude()));
        }
        return builder.build();
    }

    /* renamed from: a */
    private MarkerOptions m3779a(int i) {
        return new MarkerOptions().position(new LatLng(((PoiItem) this.f2541a.get(i)).getLatLonPoint().getLatitude(), ((PoiItem) this.f2541a.get(i)).getLatLonPoint().getLongitude())).title(getTitle(i)).snippet(getSnippet(i)).icon(getBitmapDescriptor(i));
    }

    protected BitmapDescriptor getBitmapDescriptor(int i) {
        return null;
    }

    protected String getTitle(int i) {
        return ((PoiItem) this.f2541a.get(i)).getTitle();
    }

    protected String getSnippet(int i) {
        return ((PoiItem) this.f2541a.get(i)).getSnippet();
    }

    public int getPoiIndex(Marker marker) {
        for (int i = 0; i < this.f2543c.size(); i++) {
            if (((Marker) this.f2543c.get(i)).equals(marker)) {
                return i;
            }
        }
        return -1;
    }

    public PoiItem getPoiItem(int i) {
        if (i < 0 || i >= this.f2541a.size()) {
            return null;
        }
        return (PoiItem) this.f2541a.get(i);
    }
}
