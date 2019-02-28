package com.amap.api.mapcore;

import android.content.Context;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/* compiled from: CameraAnimator */
/* renamed from: com.amap.api.mapcore.j */
public class C0336j {
    /* renamed from: J */
    private static float f1776J = ((float) (Math.log(0.78d) / Math.log(0.9d)));
    /* renamed from: K */
    private static final float[] f1777K = new float[101];
    /* renamed from: L */
    private static final float[] f1778L = new float[101];
    /* renamed from: Q */
    private static float f1779Q = 8.0f;
    /* renamed from: R */
    private static float f1780R;
    /* renamed from: A */
    private float f1781A;
    /* renamed from: B */
    private float f1782B;
    /* renamed from: C */
    private boolean f1783C;
    /* renamed from: D */
    private Interpolator f1784D;
    /* renamed from: E */
    private boolean f1785E;
    /* renamed from: F */
    private float f1786F;
    /* renamed from: G */
    private float f1787G;
    /* renamed from: H */
    private int f1788H;
    /* renamed from: I */
    private float f1789I;
    /* renamed from: M */
    private float f1790M;
    /* renamed from: N */
    private final float f1791N;
    /* renamed from: O */
    private float f1792O;
    /* renamed from: P */
    private boolean f1793P;
    /* renamed from: a */
    private int f1794a;
    /* renamed from: b */
    private int f1795b;
    /* renamed from: c */
    private int f1796c;
    /* renamed from: d */
    private float f1797d;
    /* renamed from: e */
    private float f1798e;
    /* renamed from: f */
    private float f1799f;
    /* renamed from: g */
    private int f1800g;
    /* renamed from: h */
    private int f1801h;
    /* renamed from: i */
    private float f1802i;
    /* renamed from: j */
    private float f1803j;
    /* renamed from: k */
    private float f1804k;
    /* renamed from: l */
    private int f1805l;
    /* renamed from: m */
    private int f1806m;
    /* renamed from: n */
    private int f1807n;
    /* renamed from: o */
    private int f1808o;
    /* renamed from: p */
    private int f1809p;
    /* renamed from: q */
    private int f1810q;
    /* renamed from: r */
    private float f1811r;
    /* renamed from: s */
    private float f1812s;
    /* renamed from: t */
    private float f1813t;
    /* renamed from: u */
    private long f1814u;
    /* renamed from: v */
    private long f1815v;
    /* renamed from: w */
    private float f1816w;
    /* renamed from: x */
    private float f1817x;
    /* renamed from: y */
    private float f1818y;
    /* renamed from: z */
    private float f1819z;

    static {
        float f = 0.0f;
        int i = 0;
        float f2 = 0.0f;
        while (i < 100) {
            float f3;
            float f4 = ((float) i) / 100.0f;
            float f5 = 1.0f;
            float f6 = f2;
            while (true) {
                f2 = ((f5 - f6) / 2.0f) + f6;
                f3 = (3.0f * f2) * (1.0f - f2);
                float f7 = ((((1.0f - f2) * 0.175f) + (0.35000002f * f2)) * f3) + ((f2 * f2) * f2);
                if (((double) Math.abs(f7 - f4)) < 1.0E-5d) {
                    break;
                } else if (f7 > f4) {
                    f5 = f2;
                } else {
                    f6 = f2;
                }
            }
            f1777K[i] = (f2 * (f2 * f2)) + (f3 * (((1.0f - f2) * 0.5f) + f2));
            f5 = 1.0f;
            while (true) {
                f2 = ((f5 - f) / 2.0f) + f;
                f3 = (3.0f * f2) * (1.0f - f2);
                f7 = ((((1.0f - f2) * 0.5f) + f2) * f3) + ((f2 * f2) * f2);
                if (((double) Math.abs(f7 - f4)) < 1.0E-5d) {
                    break;
                } else if (f7 > f4) {
                    f5 = f2;
                } else {
                    f = f2;
                }
            }
            f1778L[i] = (f2 * (f2 * f2)) + ((((1.0f - f2) * 0.175f) + (0.35000002f * f2)) * f3);
            i++;
            f2 = f6;
        }
        float[] fArr = f1777K;
        f1778L[100] = 1.0f;
        fArr[100] = 1.0f;
        f1780R = 1.0f;
        f1780R = 1.0f / C0336j.m2854a(1.0f);
    }

    public C0336j(Context context) {
        this(context, null);
    }

    public C0336j(Context context, Interpolator interpolator) {
        this(context, interpolator, context.getApplicationInfo().targetSdkVersion >= 11);
    }

    public C0336j(Context context, Interpolator interpolator, boolean z) {
        this.f1789I = ViewConfiguration.getScrollFriction();
        this.f1783C = true;
        this.f1784D = interpolator;
        this.f1791N = context.getResources().getDisplayMetrics().density * 160.0f;
        this.f1790M = m2855b(ViewConfiguration.getScrollFriction());
        this.f1785E = z;
        this.f1792O = m2855b(0.84f);
    }

    /* renamed from: a */
    public void m2861a(Interpolator interpolator) {
        this.f1784D = interpolator;
    }

    /* renamed from: b */
    private float m2855b(float f) {
        return (386.0878f * this.f1791N) * f;
    }

    /* renamed from: a */
    public final boolean m2863a() {
        return this.f1783C;
    }

    /* renamed from: a */
    public final void m2862a(boolean z) {
        this.f1783C = z;
    }

    /* renamed from: b */
    public final int m2864b() {
        return this.f1809p;
    }

    /* renamed from: c */
    public final int m2866c() {
        return this.f1810q;
    }

    /* renamed from: d */
    public final float m2867d() {
        return this.f1811r;
    }

    /* renamed from: e */
    public final float m2868e() {
        return this.f1812s;
    }

    /* renamed from: f */
    public final float m2869f() {
        return this.f1813t;
    }

    /* renamed from: g */
    public float m2870g() {
        return this.f1794a == 1 ? this.f1787G : this.f1786F - ((this.f1790M * ((float) m2872i())) / 2000.0f);
    }

    /* renamed from: h */
    public boolean m2871h() {
        if (this.f1783C) {
            return false;
        }
        int currentAnimationTimeMillis = (int) (AnimationUtils.currentAnimationTimeMillis() - this.f1814u);
        if (((long) currentAnimationTimeMillis) < this.f1815v) {
            float f;
            switch (this.f1794a) {
                case 1:
                    float f2 = ((float) currentAnimationTimeMillis) / ((float) this.f1815v);
                    int i = (int) (100.0f * f2);
                    float f3 = 1.0f;
                    f = 0.0f;
                    if (i < 100) {
                        f3 = ((float) i) / 100.0f;
                        f = ((float) (i + 1)) / 100.0f;
                        float f4 = f1777K[i];
                        f = (f1777K[i + 1] - f4) / (f - f3);
                        f3 = ((f2 - f3) * f) + f4;
                    }
                    this.f1787G = ((f * ((float) this.f1788H)) / ((float) this.f1815v)) * 1000.0f;
                    this.f1809p = this.f1795b + Math.round(((float) (this.f1800g - this.f1795b)) * f3);
                    this.f1809p = Math.min(this.f1809p, this.f1806m);
                    this.f1809p = Math.max(this.f1809p, this.f1805l);
                    this.f1810q = this.f1796c + Math.round(f3 * ((float) (this.f1801h - this.f1796c)));
                    this.f1810q = Math.min(this.f1810q, this.f1808o);
                    this.f1810q = Math.max(this.f1810q, this.f1807n);
                    if (this.f1809p == this.f1800g && this.f1810q == this.f1801h) {
                        this.f1783C = true;
                        break;
                    }
                case 2:
                    f = ((float) currentAnimationTimeMillis) * this.f1816w;
                    if (this.f1784D == null) {
                        f = C0336j.m2854a(f);
                    } else {
                        f = this.f1784D.getInterpolation(f);
                    }
                    this.f1809p = this.f1795b + Math.round(this.f1817x * f);
                    this.f1810q = this.f1796c + Math.round(this.f1818y * f);
                    this.f1811r = this.f1797d + (this.f1819z * f);
                    this.f1812s = this.f1798e + (this.f1781A * f);
                    this.f1813t = (f * this.f1782B) + this.f1799f;
                    break;
            }
        }
        this.f1809p = this.f1800g;
        this.f1810q = this.f1801h;
        this.f1811r = this.f1802i;
        this.f1812s = this.f1803j;
        this.f1813t = this.f1804k;
        this.f1783C = true;
        return true;
    }

    /* renamed from: a */
    public void m2859a(int i, int i2, float f, float f2, float f3, int i3, int i4, float f4, float f5, float f6, long j) {
        this.f1794a = 2;
        this.f1783C = false;
        this.f1815v = j;
        this.f1814u = AnimationUtils.currentAnimationTimeMillis();
        this.f1795b = i;
        this.f1796c = i2;
        this.f1797d = f;
        this.f1798e = f2;
        this.f1799f = f3;
        this.f1800g = i + i3;
        this.f1801h = i2 + i4;
        this.f1802i = f + f4;
        this.f1803j = f2 + f5;
        this.f1804k = f3 + f6;
        this.f1817x = (float) i3;
        this.f1818y = (float) i4;
        this.f1819z = f4;
        this.f1781A = f5;
        this.f1782B = f6;
        this.f1816w = 1.0f / ((float) this.f1815v);
    }

    /* renamed from: a */
    public void m2860a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        float g;
        float f;
        float f2 = 1.0f;
        if (this.f1785E && !this.f1783C) {
            g = m2870g();
            f = (float) (this.f1800g - this.f1795b);
            float f3 = (float) (this.f1801h - this.f1796c);
            float sqrt = (float) Math.sqrt((double) ((f * f) + (f3 * f3)));
            f = (f / sqrt) * g;
            g *= f3 / sqrt;
            if (Math.signum((float) i3) == Math.signum(f) && Math.signum((float) i4) == Math.signum(g)) {
                i3 = (int) (f + ((float) i3));
                i4 = (int) (g + ((float) i4));
            }
        }
        this.f1794a = 1;
        this.f1783C = false;
        f = (float) Math.sqrt((double) ((i3 * i3) + (i4 * i4)));
        this.f1786F = f;
        this.f1815v = (long) m2857d(f);
        this.f1814u = AnimationUtils.currentAnimationTimeMillis();
        this.f1795b = i;
        this.f1796c = i2;
        g = f == 0.0f ? 1.0f : ((float) i3) / f;
        if (f != 0.0f) {
            f2 = ((float) i4) / f;
        }
        double e = m2858e(f);
        this.f1788H = (int) (((double) Math.signum(f)) * e);
        this.f1805l = i5;
        this.f1806m = i6;
        this.f1807n = i7;
        this.f1808o = i8;
        this.f1800g = ((int) Math.round(((double) g) * e)) + i;
        this.f1800g = Math.min(this.f1800g, this.f1806m);
        this.f1800g = Math.max(this.f1800g, this.f1805l);
        this.f1801h = ((int) Math.round(((double) f2) * e)) + i2;
        this.f1801h = Math.min(this.f1801h, this.f1808o);
        this.f1801h = Math.max(this.f1801h, this.f1807n);
    }

    /* renamed from: c */
    private double m2856c(float f) {
        return Math.log((double) ((0.35f * Math.abs(f)) / (this.f1789I * this.f1792O)));
    }

    /* renamed from: d */
    private int m2857d(float f) {
        return (int) (Math.exp(m2856c(f) / (((double) f1776J) - 1.0d)) * 1000.0d);
    }

    /* renamed from: e */
    private double m2858e(float f) {
        return Math.exp(m2856c(f) * (((double) f1776J) / (((double) f1776J) - 1.0d))) * ((double) (this.f1789I * this.f1792O));
    }

    /* renamed from: a */
    static float m2854a(float f) {
        float f2 = f1779Q * f;
        if (f2 < 1.0f) {
            f2 -= 1.0f - ((float) Math.exp((double) (-f2)));
        } else {
            f2 = ((1.0f - ((float) Math.exp((double) (1.0f - f2)))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return f2 * f1780R;
    }

    /* renamed from: i */
    public int m2872i() {
        return (int) (AnimationUtils.currentAnimationTimeMillis() - this.f1814u);
    }

    /* renamed from: j */
    public final int m2873j() {
        return this.f1794a;
    }

    /* renamed from: b */
    public void m2865b(boolean z) {
        this.f1793P = z;
    }

    /* renamed from: k */
    public boolean m2874k() {
        return this.f1793P;
    }
}
