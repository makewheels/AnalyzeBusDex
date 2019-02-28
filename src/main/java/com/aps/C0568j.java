package com.aps;

/* compiled from: Fence */
/* renamed from: com.aps.j */
public class C0568j {
    /* renamed from: a */
    public double f3502a = 0.0d;
    /* renamed from: b */
    public double f3503b = 0.0d;
    /* renamed from: c */
    public float f3504c = 0.0f;
    /* renamed from: d */
    int f3505d = -1;
    /* renamed from: e */
    private long f3506e = -1;

    /* renamed from: a */
    public long m4529a() {
        return this.f3506e;
    }

    /* renamed from: a */
    public void m4530a(long j) {
        if (j >= 0) {
            this.f3506e = C0583t.m4572a() + j;
        } else {
            this.f3506e = j;
        }
    }

    /* renamed from: b */
    public String m4531b() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f3502a).append("#").append(this.f3503b).append("#").append(this.f3504c);
        return stringBuilder.toString();
    }
}
