package com.amap.api.maps.model;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public final class TextOptions implements Parcelable {
    public static final TextOptionsCreator CREATOR = new TextOptionsCreator();
    /* renamed from: a */
    String f2372a;
    /* renamed from: b */
    private LatLng f2373b;
    /* renamed from: c */
    private String f2374c;
    /* renamed from: d */
    private Typeface f2375d = Typeface.DEFAULT;
    /* renamed from: e */
    private float f2376e;
    /* renamed from: f */
    private int f2377f = 4;
    /* renamed from: g */
    private int f2378g = 32;
    /* renamed from: h */
    private int f2379h = -1;
    /* renamed from: i */
    private int f2380i = -16777216;
    /* renamed from: j */
    private Object f2381j;
    /* renamed from: k */
    private int f2382k = 20;
    /* renamed from: l */
    private float f2383l = 0.0f;
    /* renamed from: m */
    private boolean f2384m = true;

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2372a);
        Bundle bundle = new Bundle();
        if (this.f2373b != null) {
            bundle.putDouble("lat", this.f2373b.latitude);
            bundle.putDouble("lng", this.f2373b.longitude);
        }
        parcel.writeBundle(bundle);
        parcel.writeString(this.f2374c);
        parcel.writeInt(this.f2375d.getStyle());
        parcel.writeFloat(this.f2376e);
        parcel.writeInt(this.f2377f);
        parcel.writeInt(this.f2378g);
        parcel.writeInt(this.f2379h);
        parcel.writeInt(this.f2380i);
        parcel.writeInt(this.f2382k);
        parcel.writeFloat(this.f2383l);
        parcel.writeByte((byte) (this.f2384m ? 1 : 0));
        if (this.f2381j instanceof Parcelable) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("obj", (Parcelable) this.f2381j);
            parcel.writeBundle(bundle2);
        }
    }

    public int describeContents() {
        return 0;
    }

    public TextOptions position(LatLng latLng) {
        this.f2373b = latLng;
        return this;
    }

    public TextOptions text(String str) {
        this.f2374c = str;
        return this;
    }

    public TextOptions typeface(Typeface typeface) {
        if (typeface != null) {
            this.f2375d = typeface;
        }
        return this;
    }

    public TextOptions visible(boolean z) {
        this.f2384m = z;
        return this;
    }

    public TextOptions zIndex(float f) {
        this.f2383l = f;
        return this;
    }

    public TextOptions rotate(float f) {
        this.f2376e = f;
        return this;
    }

    public TextOptions align(int i, int i2) {
        this.f2377f = i;
        this.f2378g = i2;
        return this;
    }

    public TextOptions backgroundColor(int i) {
        this.f2379h = i;
        return this;
    }

    public TextOptions setObject(Object obj) {
        this.f2381j = obj;
        return this;
    }

    public TextOptions fontColor(int i) {
        this.f2380i = i;
        return this;
    }

    public TextOptions fontSize(int i) {
        this.f2382k = i;
        return this;
    }

    public LatLng getPosition() {
        return this.f2373b;
    }

    public String getText() {
        return this.f2374c;
    }

    public Typeface getTypeface() {
        return this.f2375d;
    }

    public float getRotate() {
        return this.f2376e;
    }

    public int getAlignX() {
        return this.f2377f;
    }

    public int getAlignY() {
        return this.f2378g;
    }

    public int getBackgroundColor() {
        return this.f2379h;
    }

    public int getFontColor() {
        return this.f2380i;
    }

    public Object getObject() {
        return this.f2381j;
    }

    public int getFontSize() {
        return this.f2382k;
    }

    public float getZIndex() {
        return this.f2383l;
    }

    public boolean isVisible() {
        return this.f2384m;
    }
}
