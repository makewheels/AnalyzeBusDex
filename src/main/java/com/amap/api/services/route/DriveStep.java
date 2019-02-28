package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.core.LatLonPoint;
import java.util.List;

public class DriveStep implements Parcelable {
    public static final Creator<DriveStep> CREATOR = new C0535h();
    /* renamed from: a */
    private String f3194a;
    /* renamed from: b */
    private String f3195b;
    /* renamed from: c */
    private String f3196c;
    /* renamed from: d */
    private float f3197d;
    /* renamed from: e */
    private float f3198e;
    /* renamed from: f */
    private float f3199f;
    /* renamed from: g */
    private String f3200g;
    /* renamed from: h */
    private float f3201h;
    /* renamed from: i */
    private List<LatLonPoint> f3202i;
    /* renamed from: j */
    private String f3203j;
    /* renamed from: k */
    private String f3204k;
    /* renamed from: l */
    private List<RouteSearchCity> f3205l;

    public String getInstruction() {
        return this.f3194a;
    }

    public void setInstruction(String str) {
        this.f3194a = str;
    }

    public String getOrientation() {
        return this.f3195b;
    }

    public void setOrientation(String str) {
        this.f3195b = str;
    }

    public String getRoad() {
        return this.f3196c;
    }

    public void setRoad(String str) {
        this.f3196c = str;
    }

    public float getDistance() {
        return this.f3197d;
    }

    public void setDistance(float f) {
        this.f3197d = f;
    }

    public float getTolls() {
        return this.f3198e;
    }

    public void setTolls(float f) {
        this.f3198e = f;
    }

    public float getTollDistance() {
        return this.f3199f;
    }

    public void setTollDistance(float f) {
        this.f3199f = f;
    }

    public String getTollRoad() {
        return this.f3200g;
    }

    public void setTollRoad(String str) {
        this.f3200g = str;
    }

    public float getDuration() {
        return this.f3201h;
    }

    public void setDuration(float f) {
        this.f3201h = f;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f3202i;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f3202i = list;
    }

    public String getAction() {
        return this.f3203j;
    }

    public void setAction(String str) {
        this.f3203j = str;
    }

    public String getAssistantAction() {
        return this.f3204k;
    }

    public void setAssistantAction(String str) {
        this.f3204k = str;
    }

    public List<RouteSearchCity> getRouteSearchCityList() {
        return this.f3205l;
    }

    public void setRouteSearchCityList(List<RouteSearchCity> list) {
        this.f3205l = list;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3194a);
        parcel.writeString(this.f3195b);
        parcel.writeString(this.f3196c);
        parcel.writeFloat(this.f3197d);
        parcel.writeFloat(this.f3198e);
        parcel.writeFloat(this.f3199f);
        parcel.writeString(this.f3200g);
        parcel.writeFloat(this.f3201h);
        parcel.writeTypedList(this.f3202i);
        parcel.writeString(this.f3203j);
        parcel.writeString(this.f3204k);
        parcel.writeTypedList(this.f3205l);
    }

    public DriveStep(Parcel parcel) {
        this.f3194a = parcel.readString();
        this.f3195b = parcel.readString();
        this.f3196c = parcel.readString();
        this.f3197d = parcel.readFloat();
        this.f3198e = parcel.readFloat();
        this.f3199f = parcel.readFloat();
        this.f3200g = parcel.readString();
        this.f3201h = parcel.readFloat();
        this.f3202i = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.f3203j = parcel.readString();
        this.f3204k = parcel.readString();
        this.f3205l = parcel.createTypedArrayList(RouteSearchCity.CREATOR);
    }
}
