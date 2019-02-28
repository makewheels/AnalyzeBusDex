package com.amap.api.mapcore.util;

/* compiled from: EarClippingTriangulator */
/* renamed from: com.amap.api.mapcore.util.i */
public class C0388i {
    /* renamed from: a */
    private final C0403t f2134a = new C0403t();
    /* renamed from: b */
    private short[] f2135b;
    /* renamed from: c */
    private float[] f2136c;
    /* renamed from: d */
    private int f2137d;
    /* renamed from: e */
    private final C0398n f2138e = new C0398n();
    /* renamed from: f */
    private final C0403t f2139f = new C0403t();

    /* renamed from: a */
    public C0403t m3340a(float[] fArr) {
        return m3341a(fArr, 0, fArr.length);
    }

    /* renamed from: a */
    public C0403t m3341a(float[] fArr, int i, int i2) {
        int i3;
        this.f2136c = fArr;
        int i4 = i2 / 2;
        this.f2137d = i4;
        int i5 = i / 2;
        C0403t c0403t = this.f2134a;
        c0403t.m3435a();
        c0403t.m3438c(i4);
        c0403t.f2185b = i4;
        short[] sArr = c0403t.f2184a;
        this.f2135b = sArr;
        if (C0388i.m3336b(fArr, i, i2)) {
            for (i3 = 0; i3 < i4; i3 = (short) (i3 + 1)) {
                sArr[i3] = (short) (i5 + i3);
            }
        } else {
            int i6 = i4 - 1;
            for (i3 = 0; i3 < i4; i3++) {
                sArr[i3] = (short) ((i5 + i6) - i3);
            }
        }
        C0398n c0398n = this.f2138e;
        c0398n.m3417a();
        c0398n.m3420c(i4);
        for (i3 = 0; i3 < i4; i3++) {
            c0398n.m3418a(m3332a(i3));
        }
        c0403t = this.f2139f;
        c0403t.m3435a();
        c0403t.m3438c(Math.max(0, i4 - 2) * 3);
        m3333a();
        return c0403t;
    }

    /* renamed from: a */
    private void m3333a() {
        int[] iArr = this.f2138e.f2176a;
        while (this.f2137d > 3) {
            int b = m3334b();
            m3337c(b);
            int d = m3338d(b);
            if (b == this.f2137d) {
                b = 0;
            }
            iArr[d] = m3332a(d);
            iArr[b] = m3332a(b);
        }
        if (this.f2137d == 3) {
            C0403t c0403t = this.f2139f;
            short[] sArr = this.f2135b;
            c0403t.m3436a(sArr[0]);
            c0403t.m3436a(sArr[1]);
            c0403t.m3436a(sArr[2]);
        }
    }

    /* renamed from: a */
    private int m3332a(int i) {
        short[] sArr = this.f2135b;
        int i2 = sArr[m3338d(i)] * 2;
        int i3 = sArr[i] * 2;
        int i4 = sArr[m3339e(i)] * 2;
        float[] fArr = this.f2136c;
        return C0388i.m3331a(fArr[i2], fArr[i2 + 1], fArr[i3], fArr[i3 + 1], fArr[i4], fArr[i4 + 1]);
    }

    /* renamed from: b */
    private int m3334b() {
        int i;
        int i2 = this.f2137d;
        for (i = 0; i < i2; i++) {
            if (m3335b(i)) {
                return i;
            }
        }
        int[] iArr = this.f2138e.f2176a;
        for (i = 0; i < i2; i++) {
            if (iArr[i] != -1) {
                return i;
            }
        }
        return 0;
    }

    /* renamed from: b */
    private boolean m3335b(int i) {
        int[] iArr = this.f2138e.f2176a;
        if (iArr[i] == -1) {
            return false;
        }
        int d = m3338d(i);
        int e = m3339e(i);
        short[] sArr = this.f2135b;
        int i2 = sArr[d] * 2;
        int i3 = sArr[i] * 2;
        int i4 = sArr[e] * 2;
        float[] fArr = this.f2136c;
        float f = fArr[i2];
        float f2 = fArr[i2 + 1];
        float f3 = fArr[i3];
        float f4 = fArr[i3 + 1];
        float f5 = fArr[i4];
        float f6 = fArr[i4 + 1];
        int e2 = m3339e(e);
        while (e2 != d) {
            if (iArr[e2] != 1) {
                i4 = sArr[e2] * 2;
                float f7 = fArr[i4];
                float f8 = fArr[i4 + 1];
                if (C0388i.m3331a(f5, f6, f, f2, f7, f8) >= 0 && C0388i.m3331a(f, f2, f3, f4, f7, f8) >= 0 && C0388i.m3331a(f3, f4, f5, f6, f7, f8) >= 0) {
                    return false;
                }
            }
            e2 = m3339e(e2);
        }
        return true;
    }

    /* renamed from: c */
    private void m3337c(int i) {
        short[] sArr = this.f2135b;
        C0403t c0403t = this.f2139f;
        c0403t.m3436a(sArr[m3338d(i)]);
        c0403t.m3436a(sArr[i]);
        c0403t.m3436a(sArr[m3339e(i)]);
        this.f2134a.m3437b(i);
        this.f2138e.m3419b(i);
        this.f2137d--;
    }

    /* renamed from: d */
    private int m3338d(int i) {
        if (i == 0) {
            i = this.f2137d;
        }
        return i - 1;
    }

    /* renamed from: e */
    private int m3339e(int i) {
        return (i + 1) % this.f2137d;
    }

    /* renamed from: b */
    private static boolean m3336b(float[] fArr, int i, int i2) {
        if (i2 <= 2) {
            return false;
        }
        int i3 = (i + i2) - 3;
        float f = 0.0f;
        for (int i4 = i; i4 < i3; i4 += 2) {
            f += (fArr[i4] * fArr[i4 + 3]) - (fArr[i4 + 1] * fArr[i4 + 2]);
        }
        float f2 = fArr[(i + i2) - 2];
        float f3 = fArr[(i + i2) - 1];
        if (((f2 * fArr[i + 1]) + f) - (fArr[i] * f3) < 0.0f) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private static int m3331a(float f, float f2, float f3, float f4, float f5, float f6) {
        return (int) Math.signum((((f6 - f4) * f) + ((f2 - f6) * f3)) + ((f4 - f2) * f5));
    }
}
