package com.iflytek.cloud.util.p032a.p033a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* renamed from: com.iflytek.cloud.util.a.a.a */
public class C0978a implements Parcelable {
    public static final Creator<C0978a> CREATOR = new C0979b();
    /* renamed from: a */
    private String f4610a = null;
    /* renamed from: b */
    private String f4611b = null;
    /* renamed from: c */
    private String f4612c = null;
    /* renamed from: d */
    private String f4613d = null;
    /* renamed from: e */
    private String f4614e = null;
    /* renamed from: f */
    private String f4615f = null;
    /* renamed from: g */
    private String f4616g = null;

    public C0978a(String str, String str2, String str3, String str4, String str5, String str6) {
        this.f4610a = str;
        this.f4611b = str2;
        this.f4612c = str3;
        this.f4613d = str4;
        this.f4614e = str5;
        this.f4616g = str6;
    }

    /* renamed from: a */
    public String m7306a() {
        return this.f4610a;
    }

    /* renamed from: b */
    public String m7307b() {
        return this.f4611b;
    }

    /* renamed from: c */
    public String m7308c() {
        return this.f4613d;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4610a);
        parcel.writeString(this.f4611b);
        parcel.writeString(this.f4612c);
        parcel.writeString(this.f4613d);
        parcel.writeString(this.f4614e);
        parcel.writeString(this.f4615f);
        parcel.writeString(this.f4616g);
    }
}
