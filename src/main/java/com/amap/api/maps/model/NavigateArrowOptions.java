package com.amap.api.maps.model;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class NavigateArrowOptions implements Parcelable {
    public static final NavigateArrowOptionsCreator CREATOR = new NavigateArrowOptionsCreator();
    /* renamed from: a */
    String f2335a;
    /* renamed from: b */
    private final List<LatLng> f2336b = new ArrayList();
    /* renamed from: c */
    private float f2337c = 10.0f;
    /* renamed from: d */
    private int f2338d = Color.argb(ErrorCode.INCRUPDATE_INSTALL_SUCCESS, 87, 235, ErrorCode.APK_INVALID);
    /* renamed from: e */
    private int f2339e = Color.argb(170, 0, 172, 146);
    /* renamed from: f */
    private float f2340f = 0.0f;
    /* renamed from: g */
    private boolean f2341g = true;

    public NavigateArrowOptions add(LatLng latLng) {
        this.f2336b.add(latLng);
        return this;
    }

    public NavigateArrowOptions add(LatLng... latLngArr) {
        this.f2336b.addAll(Arrays.asList(latLngArr));
        return this;
    }

    public NavigateArrowOptions addAll(Iterable<LatLng> iterable) {
        for (LatLng add : iterable) {
            this.f2336b.add(add);
        }
        return this;
    }

    public NavigateArrowOptions width(float f) {
        this.f2337c = f;
        return this;
    }

    public NavigateArrowOptions topColor(int i) {
        this.f2338d = i;
        return this;
    }

    public NavigateArrowOptions sideColor(int i) {
        this.f2339e = i;
        return this;
    }

    public NavigateArrowOptions zIndex(float f) {
        this.f2340f = f;
        return this;
    }

    public NavigateArrowOptions visible(boolean z) {
        this.f2341g = z;
        return this;
    }

    public List<LatLng> getPoints() {
        return this.f2336b;
    }

    public float getWidth() {
        return this.f2337c;
    }

    public int getTopColor() {
        return this.f2338d;
    }

    public int getSideColor() {
        return this.f2339e;
    }

    public float getZIndex() {
        return this.f2340f;
    }

    public boolean isVisible() {
        return this.f2341g;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f2336b);
        parcel.writeFloat(this.f2337c);
        parcel.writeInt(this.f2338d);
        parcel.writeInt(this.f2339e);
        parcel.writeFloat(this.f2340f);
        parcel.writeByte((byte) (this.f2341g ? 1 : 0));
        parcel.writeString(this.f2335a);
    }
}
