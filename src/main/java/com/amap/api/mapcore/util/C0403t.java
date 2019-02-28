package com.amap.api.mapcore.util;

/* compiled from: ShortArray */
/* renamed from: com.amap.api.mapcore.util.t */
public class C0403t {
    /* renamed from: a */
    public short[] f2184a;
    /* renamed from: b */
    public int f2185b;
    /* renamed from: c */
    public boolean f2186c;

    public C0403t() {
        this(true, 16);
    }

    public C0403t(boolean z, int i) {
        this.f2186c = z;
        this.f2184a = new short[i];
    }

    /* renamed from: a */
    public void m3436a(short s) {
        short[] sArr = this.f2184a;
        if (this.f2185b == sArr.length) {
            sArr = m3439d(Math.max(8, (int) (((float) this.f2185b) * 1.75f)));
        }
        int i = this.f2185b;
        this.f2185b = i + 1;
        sArr[i] = s;
    }

    /* renamed from: a */
    public short m3434a(int i) {
        if (i < this.f2185b) {
            return this.f2184a[i];
        }
        throw new IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.f2185b);
    }

    /* renamed from: b */
    public short m3437b(int i) {
        if (i >= this.f2185b) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.f2185b);
        }
        Object obj = this.f2184a;
        short s = obj[i];
        this.f2185b--;
        if (this.f2186c) {
            System.arraycopy(obj, i + 1, obj, i, this.f2185b - i);
        } else {
            obj[i] = obj[this.f2185b];
        }
        return s;
    }

    /* renamed from: a */
    public void m3435a() {
        this.f2185b = 0;
    }

    /* renamed from: c */
    public short[] m3438c(int i) {
        int i2 = this.f2185b + i;
        if (i2 > this.f2184a.length) {
            m3439d(Math.max(8, i2));
        }
        return this.f2184a;
    }

    /* renamed from: d */
    protected short[] m3439d(int i) {
        Object obj = new short[i];
        System.arraycopy(this.f2184a, 0, obj, 0, Math.min(this.f2185b, obj.length));
        this.f2184a = obj;
        return obj;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0403t)) {
            return false;
        }
        C0403t c0403t = (C0403t) obj;
        int i = this.f2185b;
        if (i != c0403t.f2185b) {
            return false;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (this.f2184a[i2] != c0403t.f2184a[i2]) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        if (this.f2185b == 0) {
            return "[]";
        }
        short[] sArr = this.f2184a;
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append('[');
        stringBuilder.append(sArr[0]);
        for (int i = 1; i < this.f2185b; i++) {
            stringBuilder.append(", ");
            stringBuilder.append(sArr[i]);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
