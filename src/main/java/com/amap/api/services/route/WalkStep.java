package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.core.LatLonPoint;
import java.util.List;

public class WalkStep implements Parcelable {
    public static final Creator<WalkStep> CREATOR = new C0549v();
    /* renamed from: a */
    private String f3245a;
    /* renamed from: b */
    private String f3246b;
    /* renamed from: c */
    private String f3247c;
    /* renamed from: d */
    private float f3248d;
    /* renamed from: e */
    private float f3249e;
    /* renamed from: f */
    private List<LatLonPoint> f3250f;
    /* renamed from: g */
    private String f3251g;
    /* renamed from: h */
    private String f3252h;

    public String getInstruction() {
        return this.f3245a;
    }

    public void setInstruction(String str) {
        this.f3245a = str;
    }

    public String getOrientation() {
        return this.f3246b;
    }

    public void setOrientation(String str) {
        this.f3246b = str;
    }

    public String getRoad() {
        return this.f3247c;
    }

    public void setRoad(String str) {
        this.f3247c = str;
    }

    public float getDistance() {
        return this.f3248d;
    }

    public void setDistance(float f) {
        this.f3248d = f;
    }

    public float getDuration() {
        return this.f3249e;
    }

    public void setDuration(float f) {
        this.f3249e = f;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f3250f;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f3250f = list;
    }

    public String getAction() {
        return this.f3251g;
    }

    public void setAction(String str) {
        this.f3251g = str;
    }

    public String getAssistantAction() {
        return this.f3252h;
    }

    public void setAssistantAction(String str) {
        this.f3252h = str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3245a);
        parcel.writeString(this.f3246b);
        parcel.writeString(this.f3247c);
        parcel.writeFloat(this.f3248d);
        parcel.writeFloat(this.f3249e);
        parcel.writeTypedList(this.f3250f);
        parcel.writeString(this.f3251g);
        parcel.writeString(this.f3252h);
    }

    public WalkStep(Parcel parcel) {
        this.f3245a = parcel.readString();
        this.f3246b = parcel.readString();
        this.f3247c = parcel.readString();
        this.f3248d = parcel.readFloat();
        this.f3249e = parcel.readFloat();
        this.f3250f = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.f3251g = parcel.readString();
        this.f3252h = parcel.readString();
    }
}
