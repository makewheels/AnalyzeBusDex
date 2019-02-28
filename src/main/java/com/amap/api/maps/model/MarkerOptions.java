package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

public final class MarkerOptions implements Parcelable {
    public static final MarkerOptionsCreator CREATOR = new MarkerOptionsCreator();
    /* renamed from: a */
    String f2306a;
    /* renamed from: b */
    private LatLng f2307b;
    /* renamed from: c */
    private String f2308c;
    /* renamed from: d */
    private String f2309d;
    /* renamed from: e */
    private float f2310e = 0.5f;
    /* renamed from: f */
    private float f2311f = 1.0f;
    /* renamed from: g */
    private float f2312g = 0.0f;
    /* renamed from: h */
    private boolean f2313h = false;
    /* renamed from: i */
    private boolean f2314i = true;
    /* renamed from: j */
    private boolean f2315j = false;
    /* renamed from: k */
    private int f2316k = 0;
    /* renamed from: l */
    private int f2317l = 0;
    /* renamed from: m */
    private ArrayList<BitmapDescriptor> f2318m = new ArrayList();
    /* renamed from: n */
    private int f2319n = 20;
    /* renamed from: o */
    private boolean f2320o = false;
    /* renamed from: p */
    private boolean f2321p = false;

    public MarkerOptions icons(ArrayList<BitmapDescriptor> arrayList) {
        this.f2318m = arrayList;
        return this;
    }

    public ArrayList<BitmapDescriptor> getIcons() {
        return this.f2318m;
    }

    public MarkerOptions period(int i) {
        if (i <= 1) {
            this.f2319n = 1;
        } else {
            this.f2319n = i;
        }
        return this;
    }

    public int getPeriod() {
        return this.f2319n;
    }

    public boolean isPerspective() {
        return this.f2315j;
    }

    public MarkerOptions perspective(boolean z) {
        this.f2315j = z;
        return this;
    }

    public MarkerOptions position(LatLng latLng) {
        this.f2307b = latLng;
        return this;
    }

    public MarkerOptions setFlat(boolean z) {
        this.f2321p = z;
        return this;
    }

    /* renamed from: a */
    private void m3578a() {
        if (this.f2318m == null) {
            this.f2318m = new ArrayList();
        }
    }

    public MarkerOptions icon(BitmapDescriptor bitmapDescriptor) {
        m3578a();
        this.f2318m.clear();
        this.f2318m.add(bitmapDescriptor);
        return this;
    }

    public MarkerOptions anchor(float f, float f2) {
        this.f2310e = f;
        this.f2311f = f2;
        return this;
    }

    public MarkerOptions setInfoWindowOffset(int i, int i2) {
        this.f2316k = i;
        this.f2317l = i2;
        return this;
    }

    public MarkerOptions title(String str) {
        this.f2308c = str;
        return this;
    }

    public MarkerOptions snippet(String str) {
        this.f2309d = str;
        return this;
    }

    public MarkerOptions draggable(boolean z) {
        this.f2313h = z;
        return this;
    }

    public MarkerOptions visible(boolean z) {
        this.f2314i = z;
        return this;
    }

    public MarkerOptions setGps(boolean z) {
        this.f2320o = z;
        return this;
    }

    public LatLng getPosition() {
        return this.f2307b;
    }

    public String getTitle() {
        return this.f2308c;
    }

    public String getSnippet() {
        return this.f2309d;
    }

    public BitmapDescriptor getIcon() {
        if (this.f2318m == null || this.f2318m.size() == 0) {
            return null;
        }
        return (BitmapDescriptor) this.f2318m.get(0);
    }

    public float getAnchorU() {
        return this.f2310e;
    }

    public int getInfoWindowOffsetX() {
        return this.f2316k;
    }

    public int getInfoWindowOffsetY() {
        return this.f2317l;
    }

    public float getAnchorV() {
        return this.f2311f;
    }

    public boolean isDraggable() {
        return this.f2313h;
    }

    public boolean isVisible() {
        return this.f2314i;
    }

    public boolean isGps() {
        return this.f2320o;
    }

    public boolean isFlat() {
        return this.f2321p;
    }

    public MarkerOptions zIndex(float f) {
        this.f2312g = f;
        return this;
    }

    public float getZIndex() {
        return this.f2312g;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f2307b, i);
        if (!(this.f2318m == null || this.f2318m.size() == 0)) {
            parcel.writeParcelable((Parcelable) this.f2318m.get(0), i);
        }
        parcel.writeString(this.f2308c);
        parcel.writeString(this.f2309d);
        parcel.writeFloat(this.f2310e);
        parcel.writeFloat(this.f2311f);
        parcel.writeInt(this.f2316k);
        parcel.writeInt(this.f2317l);
        parcel.writeBooleanArray(new boolean[]{this.f2314i, this.f2313h, this.f2320o, this.f2321p});
        parcel.writeString(this.f2306a);
        parcel.writeInt(this.f2319n);
        parcel.writeList(this.f2318m);
        parcel.writeFloat(this.f2312g);
    }
}
