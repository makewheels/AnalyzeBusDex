package com.amap.api.mapcore.util;

/* compiled from: IntArray */
/* renamed from: com.amap.api.mapcore.util.n */
public class C0398n {
    /* renamed from: a */
    public int[] f2176a;
    /* renamed from: b */
    public int f2177b;
    /* renamed from: c */
    public boolean f2178c;

    public C0398n() {
        this(true, 16);
    }

    public C0398n(boolean z, int i) {
        this.f2178c = z;
        this.f2176a = new int[i];
    }

    /* renamed from: a */
    public void m3418a(int i) {
        int[] iArr = this.f2176a;
        if (this.f2177b == iArr.length) {
            iArr = m3421d(Math.max(8, (int) (((float) this.f2177b) * 1.75f)));
        }
        int i2 = this.f2177b;
        this.f2177b = i2 + 1;
        iArr[i2] = i;
    }

    /* renamed from: b */
    public int m3419b(int i) {
        if (i >= this.f2177b) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.f2177b);
        }
        Object obj = this.f2176a;
        int i2 = obj[i];
        this.f2177b--;
        if (this.f2178c) {
            System.arraycopy(obj, i + 1, obj, i, this.f2177b - i);
        } else {
            obj[i] = obj[this.f2177b];
        }
        return i2;
    }

    /* renamed from: a */
    public void m3417a() {
        this.f2177b = 0;
    }

    /* renamed from: c */
    public int[] m3420c(int i) {
        int i2 = this.f2177b + i;
        if (i2 > this.f2176a.length) {
            m3421d(Math.max(8, i2));
        }
        return this.f2176a;
    }

    /* renamed from: d */
    protected int[] m3421d(int i) {
        Object obj = new int[i];
        System.arraycopy(this.f2176a, 0, obj, 0, Math.min(this.f2177b, obj.length));
        this.f2176a = obj;
        return obj;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0398n)) {
            return false;
        }
        C0398n c0398n = (C0398n) obj;
        int i = this.f2177b;
        if (i != c0398n.f2177b) {
            return false;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (this.f2176a[i2] != c0398n.f2176a[i2]) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        if (this.f2177b == 0) {
            return "[]";
        }
        int[] iArr = this.f2176a;
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append('[');
        stringBuilder.append(iArr[0]);
        for (int i = 1; i < this.f2177b; i++) {
            stringBuilder.append(", ");
            stringBuilder.append(iArr[i]);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
