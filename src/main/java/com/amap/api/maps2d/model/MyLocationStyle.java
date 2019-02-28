package com.amap.api.maps2d.model;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.sdk.WebView;

public class MyLocationStyle implements Parcelable {
    /* renamed from: a */
    private BitmapDescriptor f2616a;
    /* renamed from: b */
    private float f2617b = 0.5f;
    /* renamed from: c */
    private float f2618c = 0.5f;
    /* renamed from: d */
    private int f2619d = Color.argb(100, 0, 0, 180);
    /* renamed from: e */
    private int f2620e = Color.argb(WebView.NORMAL_MODE_ALPHA, 0, 0, ErrorCode.COPY_INSTALL_SUCCESS);
    /* renamed from: f */
    private float f2621f = 1.0f;

    public MyLocationStyle myLocationIcon(BitmapDescriptor bitmapDescriptor) {
        this.f2616a = bitmapDescriptor;
        return this;
    }

    public MyLocationStyle anchor(float f, float f2) {
        this.f2617b = f;
        this.f2618c = f2;
        return this;
    }

    public MyLocationStyle radiusFillColor(int i) {
        this.f2619d = i;
        return this;
    }

    public MyLocationStyle strokeColor(int i) {
        this.f2620e = i;
        return this;
    }

    public MyLocationStyle strokeWidth(float f) {
        this.f2621f = f;
        return this;
    }

    public BitmapDescriptor getMyLocationIcon() {
        return this.f2616a;
    }

    public float getAnchorU() {
        return this.f2617b;
    }

    public float getAnchorV() {
        return this.f2618c;
    }

    public int getRadiusFillColor() {
        return this.f2619d;
    }

    public int getStrokeColor() {
        return this.f2620e;
    }

    public float getStrokeWidth() {
        return this.f2621f;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f2616a, i);
        parcel.writeFloat(this.f2617b);
        parcel.writeFloat(this.f2618c);
        parcel.writeInt(this.f2619d);
        parcel.writeInt(this.f2620e);
        parcel.writeFloat(this.f2621f);
    }
}
