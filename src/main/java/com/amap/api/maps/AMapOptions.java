package com.amap.api.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.maps.model.CameraPosition;

public class AMapOptions implements Parcelable {
    public static final AMapOptionsCreator CREATOR = new AMapOptionsCreator();
    public static final int LOGO_POSITION_BOTTOM_CENTER = 1;
    public static final int LOGO_POSITION_BOTTOM_LEFT = 0;
    public static final int LOGO_POSITION_BOTTOM_RIGHT = 2;
    public static final int ZOOM_POSITION_RIGHT_BUTTOM = 1;
    public static final int ZOOM_POSITION_RIGHT_CENTER = 0;
    /* renamed from: a */
    private int f2214a = 1;
    /* renamed from: b */
    private boolean f2215b = true;
    /* renamed from: c */
    private boolean f2216c = true;
    /* renamed from: d */
    private boolean f2217d = true;
    /* renamed from: e */
    private boolean f2218e = true;
    /* renamed from: f */
    private boolean f2219f = true;
    /* renamed from: g */
    private boolean f2220g = false;
    /* renamed from: h */
    private CameraPosition f2221h;
    /* renamed from: i */
    private boolean f2222i = false;
    /* renamed from: j */
    private boolean f2223j = false;
    /* renamed from: k */
    private int f2224k = 0;

    public AMapOptions logoPosition(int i) {
        this.f2224k = i;
        return this;
    }

    public AMapOptions zOrderOnTop(boolean z) {
        this.f2220g = z;
        return this;
    }

    public AMapOptions mapType(int i) {
        this.f2214a = i;
        return this;
    }

    public AMapOptions camera(CameraPosition cameraPosition) {
        this.f2221h = cameraPosition;
        return this;
    }

    public AMapOptions scaleControlsEnabled(boolean z) {
        this.f2223j = z;
        return this;
    }

    public AMapOptions zoomControlsEnabled(boolean z) {
        this.f2219f = z;
        return this;
    }

    public AMapOptions compassEnabled(boolean z) {
        this.f2222i = z;
        return this;
    }

    public AMapOptions scrollGesturesEnabled(boolean z) {
        this.f2216c = z;
        return this;
    }

    public AMapOptions zoomGesturesEnabled(boolean z) {
        this.f2218e = z;
        return this;
    }

    public AMapOptions tiltGesturesEnabled(boolean z) {
        this.f2217d = z;
        return this;
    }

    public AMapOptions rotateGesturesEnabled(boolean z) {
        this.f2215b = z;
        return this;
    }

    public int getLogoPosition() {
        return this.f2224k;
    }

    public Boolean getZOrderOnTop() {
        return Boolean.valueOf(this.f2220g);
    }

    public int getMapType() {
        return this.f2214a;
    }

    public CameraPosition getCamera() {
        return this.f2221h;
    }

    public Boolean getScaleControlsEnabled() {
        return Boolean.valueOf(this.f2223j);
    }

    public Boolean getZoomControlsEnabled() {
        return Boolean.valueOf(this.f2219f);
    }

    public Boolean getCompassEnabled() {
        return Boolean.valueOf(this.f2222i);
    }

    public Boolean getScrollGesturesEnabled() {
        return Boolean.valueOf(this.f2216c);
    }

    public Boolean getZoomGesturesEnabled() {
        return Boolean.valueOf(this.f2218e);
    }

    public Boolean getTiltGesturesEnabled() {
        return Boolean.valueOf(this.f2217d);
    }

    public Boolean getRotateGesturesEnabled() {
        return Boolean.valueOf(this.f2215b);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f2221h, i);
        parcel.writeInt(this.f2214a);
        parcel.writeBooleanArray(new boolean[]{this.f2215b, this.f2216c, this.f2217d, this.f2218e, this.f2219f, this.f2220g, this.f2222i, this.f2223j});
    }
}
