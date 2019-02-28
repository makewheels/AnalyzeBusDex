package com.amap.api.p015a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: GeoPoint */
/* renamed from: com.amap.api.a.ac */
public class ac implements Parcelable {
    /* renamed from: a */
    public static final Creator<ac> f610a = new ad();
    /* renamed from: b */
    private long f611b;
    /* renamed from: c */
    private long f612c;
    /* renamed from: d */
    private double f613d;
    /* renamed from: e */
    private double f614e;

    public ac() {
        this.f611b = Long.MIN_VALUE;
        this.f612c = Long.MIN_VALUE;
        this.f613d = Double.MIN_VALUE;
        this.f614e = Double.MIN_VALUE;
        this.f611b = 0;
        this.f612c = 0;
    }

    public ac(int i, int i2) {
        this.f611b = Long.MIN_VALUE;
        this.f612c = Long.MIN_VALUE;
        this.f613d = Double.MIN_VALUE;
        this.f614e = Double.MIN_VALUE;
        this.f611b = (long) i;
        this.f612c = (long) i2;
    }

    public ac(double d, double d2, boolean z) {
        this.f611b = Long.MIN_VALUE;
        this.f612c = Long.MIN_VALUE;
        this.f613d = Double.MIN_VALUE;
        this.f614e = Double.MIN_VALUE;
        if (z) {
            this.f611b = (long) (d * 1000000.0d);
            this.f612c = (long) (d2 * 1000000.0d);
            return;
        }
        this.f613d = d;
        this.f614e = d2;
    }

    /* renamed from: a */
    public void m822a(double d) {
        this.f614e = d;
    }

    /* renamed from: b */
    public void m824b(double d) {
        this.f613d = d;
    }

    public ac(double d, double d2, long j, long j2) {
        this.f611b = Long.MIN_VALUE;
        this.f612c = Long.MIN_VALUE;
        this.f613d = Double.MIN_VALUE;
        this.f614e = Double.MIN_VALUE;
        this.f613d = d;
        this.f614e = d2;
        this.f611b = j;
        this.f612c = j2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ac acVar = (ac) obj;
        if (this.f611b != acVar.f611b) {
            return false;
        }
        if (this.f612c != acVar.f612c) {
            return false;
        }
        if (Double.doubleToLongBits(this.f613d) != Double.doubleToLongBits(acVar.f613d)) {
            return false;
        }
        if (Double.doubleToLongBits(this.f614e) != Double.doubleToLongBits(acVar.f614e)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = ((((int) (this.f611b ^ (this.f611b >>> 32))) + 31) * 31) + ((int) (this.f612c ^ (this.f612c >>> 32)));
        long doubleToLongBits = Double.doubleToLongBits(this.f613d);
        i = (i * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
        doubleToLongBits = Double.doubleToLongBits(this.f614e);
        return (i * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
    }

    /* renamed from: a */
    public int m821a() {
        return (int) this.f612c;
    }

    /* renamed from: b */
    public int m823b() {
        return (int) this.f611b;
    }

    /* renamed from: c */
    public long m825c() {
        return this.f612c;
    }

    /* renamed from: d */
    public long m826d() {
        return this.f611b;
    }

    /* renamed from: e */
    public double m827e() {
        if (Double.doubleToLongBits(this.f614e) == Double.doubleToLongBits(Double.MIN_VALUE)) {
            this.f614e = (C0270y.m1729a(this.f612c) * 2.003750834E7d) / 180.0d;
        }
        return this.f614e;
    }

    /* renamed from: f */
    public double m828f() {
        if (Double.doubleToLongBits(this.f613d) == Double.doubleToLongBits(Double.MIN_VALUE)) {
            this.f613d = ((Math.log(Math.tan(((C0270y.m1729a(this.f611b) + 90.0d) * 3.141592653589793d) / 360.0d)) / 0.017453292519943295d) * 2.003750834E7d) / 180.0d;
        }
        return this.f613d;
    }

    /* renamed from: g */
    public ac m829g() {
        return new ac(this.f613d, this.f614e, this.f611b, this.f612c);
    }

    private ac(Parcel parcel) {
        this.f611b = Long.MIN_VALUE;
        this.f612c = Long.MIN_VALUE;
        this.f613d = Double.MIN_VALUE;
        this.f614e = Double.MIN_VALUE;
        this.f611b = parcel.readLong();
        this.f612c = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f611b);
        parcel.writeLong(this.f612c);
    }
}
