package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

public final class MarkerOptions implements Parcelable {
    public static final MarkerOptionsCreator CREATOR = new MarkerOptionsCreator();
    /* renamed from: a */
    String f2605a;
    /* renamed from: b */
    private LatLng f2606b;
    /* renamed from: c */
    private String f2607c;
    /* renamed from: d */
    private String f2608d;
    /* renamed from: e */
    private float f2609e = 0.5f;
    /* renamed from: f */
    private float f2610f = 1.0f;
    /* renamed from: g */
    private boolean f2611g = false;
    /* renamed from: h */
    private boolean f2612h = true;
    /* renamed from: i */
    private boolean f2613i = false;
    /* renamed from: j */
    private ArrayList<BitmapDescriptor> f2614j = new ArrayList();
    /* renamed from: k */
    private int f2615k = 20;

    public MarkerOptions icons(ArrayList<BitmapDescriptor> arrayList) {
        this.f2614j = arrayList;
        return this;
    }

    public ArrayList<BitmapDescriptor> getIcons() {
        return this.f2614j;
    }

    public MarkerOptions period(int i) {
        if (i <= 1) {
            this.f2615k = 1;
        } else {
            this.f2615k = i;
        }
        return this;
    }

    public int getPeriod() {
        return this.f2615k;
    }

    public MarkerOptions position(LatLng latLng) {
        this.f2606b = latLng;
        return this;
    }

    public MarkerOptions icon(BitmapDescriptor bitmapDescriptor) {
        m3797a();
        this.f2614j.clear();
        this.f2614j.add(bitmapDescriptor);
        return this;
    }

    public MarkerOptions anchor(float f, float f2) {
        this.f2609e = f;
        this.f2610f = f2;
        return this;
    }

    public MarkerOptions title(String str) {
        this.f2607c = str;
        return this;
    }

    public MarkerOptions snippet(String str) {
        this.f2608d = str;
        return this;
    }

    public MarkerOptions draggable(boolean z) {
        this.f2611g = z;
        return this;
    }

    public MarkerOptions visible(boolean z) {
        this.f2612h = z;
        return this;
    }

    public MarkerOptions setGps(boolean z) {
        this.f2613i = z;
        return this;
    }

    public LatLng getPosition() {
        return this.f2606b;
    }

    public String getTitle() {
        return this.f2607c;
    }

    public String getSnippet() {
        return this.f2608d;
    }

    public BitmapDescriptor getIcon() {
        if (this.f2614j == null || this.f2614j.size() == 0) {
            return null;
        }
        return (BitmapDescriptor) this.f2614j.get(0);
    }

    public float getAnchorU() {
        return this.f2609e;
    }

    public float getAnchorV() {
        return this.f2610f;
    }

    public boolean isDraggable() {
        return this.f2611g;
    }

    public boolean isVisible() {
        return this.f2612h;
    }

    public boolean isGps() {
        return this.f2613i;
    }

    /* renamed from: a */
    private void m3797a() {
        if (this.f2614j == null) {
            this.f2614j = new ArrayList();
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeParcelable(this.f2606b, i);
        if (!(this.f2614j == null || this.f2614j.size() == 0)) {
            parcel.writeParcelable((Parcelable) this.f2614j.get(0), i);
        }
        parcel.writeString(this.f2607c);
        parcel.writeString(this.f2608d);
        parcel.writeFloat(this.f2609e);
        parcel.writeFloat(this.f2610f);
        parcel.writeByte((byte) (this.f2612h ? 1 : 0));
        if (this.f2611g) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (!this.f2613i) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeString(this.f2605a);
        parcel.writeList(this.f2614j);
    }
}
