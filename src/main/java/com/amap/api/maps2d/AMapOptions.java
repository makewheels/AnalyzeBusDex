package com.amap.api.maps2d;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.maps2d.model.CameraPosition;

public class AMapOptions implements Parcelable {
    public static final AMapOptionsCreator CREATOR = new AMapOptionsCreator();
    public static final int LOGO_POSITION_BOTTOM_CENTER = 1;
    public static final int LOGO_POSITION_BOTTOM_LEFT = 0;
    public static final int LOGO_POSITION_BOTTOM_RIGHT = 2;
    public static final int ZOOM_POSITION_RIGHT_BUTTOM = 0;
    public static final int ZOOM_POSITION_RIGHT_CENTER = 1;
    /* renamed from: a */
    private int f2550a = 1;
    /* renamed from: b */
    private boolean f2551b = true;
    /* renamed from: c */
    private boolean f2552c = true;
    /* renamed from: d */
    private boolean f2553d = true;
    /* renamed from: e */
    private boolean f2554e = false;
    /* renamed from: f */
    private CameraPosition f2555f;
    /* renamed from: g */
    private boolean f2556g = false;
    /* renamed from: h */
    private boolean f2557h = false;
    /* renamed from: i */
    private int f2558i = 0;

    public AMapOptions logoPosition(int i) {
        this.f2558i = i;
        return this;
    }

    public AMapOptions zOrderOnTop(boolean z) {
        this.f2554e = z;
        return this;
    }

    public AMapOptions mapType(int i) {
        this.f2550a = i;
        return this;
    }

    public AMapOptions camera(CameraPosition cameraPosition) {
        this.f2555f = cameraPosition;
        return this;
    }

    public AMapOptions scaleControlsEnabled(boolean z) {
        this.f2557h = z;
        return this;
    }

    public AMapOptions zoomControlsEnabled(boolean z) {
        this.f2553d = z;
        return this;
    }

    public AMapOptions compassEnabled(boolean z) {
        this.f2556g = z;
        return this;
    }

    public AMapOptions scrollGesturesEnabled(boolean z) {
        this.f2551b = z;
        return this;
    }

    public AMapOptions zoomGesturesEnabled(boolean z) {
        this.f2552c = z;
        return this;
    }

    public int getLogoPosition() {
        return this.f2558i;
    }

    public Boolean getZOrderOnTop() {
        return Boolean.valueOf(this.f2554e);
    }

    public int getMapType() {
        return this.f2550a;
    }

    public CameraPosition getCamera() {
        return this.f2555f;
    }

    public Boolean getScaleControlsEnabled() {
        return Boolean.valueOf(this.f2557h);
    }

    public Boolean getZoomControlsEnabled() {
        return Boolean.valueOf(this.f2553d);
    }

    public Boolean getCompassEnabled() {
        return Boolean.valueOf(this.f2556g);
    }

    public Boolean getScrollGesturesEnabled() {
        return Boolean.valueOf(this.f2551b);
    }

    public Boolean getZoomGesturesEnabled() {
        return Boolean.valueOf(this.f2552c);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f2555f, i);
        parcel.writeInt(this.f2550a);
        parcel.writeBooleanArray(new boolean[]{this.f2551b, this.f2552c, this.f2553d, this.f2554e, this.f2556g, this.f2557h});
    }
}
