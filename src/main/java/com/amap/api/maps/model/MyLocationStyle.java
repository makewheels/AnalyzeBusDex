package com.amap.api.maps.model;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.sdk.WebView;

public class MyLocationStyle implements Parcelable {
    /* renamed from: a */
    private BitmapDescriptor f2322a;
    /* renamed from: b */
    private float f2323b = 0.5f;
    /* renamed from: c */
    private float f2324c = 0.5f;
    /* renamed from: d */
    private int f2325d = Color.argb(100, 0, 0, 180);
    /* renamed from: e */
    private int f2326e = Color.argb(WebView.NORMAL_MODE_ALPHA, 0, 0, ErrorCode.COPY_INSTALL_SUCCESS);
    /* renamed from: f */
    private float f2327f = 1.0f;

    public MyLocationStyle myLocationIcon(BitmapDescriptor bitmapDescriptor) {
        this.f2322a = bitmapDescriptor;
        return this;
    }

    public MyLocationStyle anchor(float f, float f2) {
        this.f2323b = f;
        this.f2324c = f2;
        return this;
    }

    public MyLocationStyle radiusFillColor(int i) {
        this.f2325d = i;
        return this;
    }

    public MyLocationStyle strokeColor(int i) {
        this.f2326e = i;
        return this;
    }

    public MyLocationStyle strokeWidth(float f) {
        this.f2327f = f;
        return this;
    }

    public BitmapDescriptor getMyLocationIcon() {
        return this.f2322a;
    }

    public float getAnchorU() {
        return this.f2323b;
    }

    public float getAnchorV() {
        return this.f2324c;
    }

    public int getRadiusFillColor() {
        return this.f2325d;
    }

    public int getStrokeColor() {
        return this.f2326e;
    }

    public float getStrokeWidth() {
        return this.f2327f;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f2322a, i);
        parcel.writeFloat(this.f2323b);
        parcel.writeFloat(this.f2324c);
        parcel.writeInt(this.f2325d);
        parcel.writeInt(this.f2326e);
        parcel.writeFloat(this.f2327f);
    }
}
