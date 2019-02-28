package com.amap.api.location;

/* compiled from: RequestLocationEntity */
/* renamed from: com.amap.api.location.g */
public class C0292g {
    /* renamed from: a */
    long f1325a;
    /* renamed from: b */
    public AMapLocationListener f1326b;
    /* renamed from: c */
    Boolean f1327c;

    public C0292g(long j, float f, AMapLocationListener aMapLocationListener, String str, boolean z) {
        this.f1325a = j;
        this.f1326b = aMapLocationListener;
        this.f1327c = Boolean.valueOf(z);
    }

    public int hashCode() {
        return (this.f1326b == null ? 0 : this.f1326b.hashCode()) + 31;
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
        C0292g c0292g = (C0292g) obj;
        if (this.f1326b == null) {
            if (c0292g.f1326b != null) {
                return false;
            }
            return true;
        } else if (this.f1326b.equals(c0292g.f1326b)) {
            return true;
        } else {
            return false;
        }
    }
}
