package com.amap.api.p015a;

import android.content.Context;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/* compiled from: CameraAnimator */
/* renamed from: com.amap.api.a.r */
public class C0259r {
    /* renamed from: I */
    private static float f1080I = ((float) (Math.log(0.78d) / Math.log(0.9d)));
    /* renamed from: J */
    private static final float[] f1081J = new float[101];
    /* renamed from: K */
    private static final float[] f1082K = new float[101];
    /* renamed from: O */
    private static float f1083O = 8.0f;
    /* renamed from: P */
    private static float f1084P;
    /* renamed from: A */
    private float f1085A;
    /* renamed from: B */
    private float f1086B;
    /* renamed from: C */
    private boolean f1087C;
    /* renamed from: D */
    private Interpolator f1088D;
    /* renamed from: E */
    private boolean f1089E;
    /* renamed from: F */
    private float f1090F;
    /* renamed from: G */
    private int f1091G;
    /* renamed from: H */
    private float f1092H;
    /* renamed from: L */
    private float f1093L;
    /* renamed from: M */
    private final float f1094M;
    /* renamed from: N */
    private float f1095N;
    /* renamed from: a */
    private int f1096a;
    /* renamed from: b */
    private int f1097b;
    /* renamed from: c */
    private int f1098c;
    /* renamed from: d */
    private float f1099d;
    /* renamed from: e */
    private float f1100e;
    /* renamed from: f */
    private float f1101f;
    /* renamed from: g */
    private int f1102g;
    /* renamed from: h */
    private int f1103h;
    /* renamed from: i */
    private float f1104i;
    /* renamed from: j */
    private float f1105j;
    /* renamed from: k */
    private float f1106k;
    /* renamed from: l */
    private int f1107l;
    /* renamed from: m */
    private int f1108m;
    /* renamed from: n */
    private int f1109n;
    /* renamed from: o */
    private int f1110o;
    /* renamed from: p */
    private int f1111p;
    /* renamed from: q */
    private int f1112q;
    /* renamed from: r */
    private float f1113r;
    /* renamed from: s */
    private float f1114s;
    /* renamed from: t */
    private float f1115t;
    /* renamed from: u */
    private long f1116u;
    /* renamed from: v */
    private long f1117v;
    /* renamed from: w */
    private float f1118w;
    /* renamed from: x */
    private float f1119x;
    /* renamed from: y */
    private float f1120y;
    /* renamed from: z */
    private float f1121z;

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
            f1081J[i] = (f2 * (f2 * f2)) + (f3 * (((1.0f - f2) * 0.5f) + f2));
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
            f1082K[i] = (f2 * (f2 * f2)) + ((((1.0f - f2) * 0.175f) + (0.35000002f * f2)) * f3);
            i++;
            f2 = f6;
        }
        float[] fArr = f1081J;
        f1082K[100] = 1.0f;
        fArr[100] = 1.0f;
        f1084P = 1.0f;
        f1084P = 1.0f / C0259r.m1671a(1.0f);
    }

    public C0259r(Context context) {
        this(context, null);
    }

    public C0259r(Context context, Interpolator interpolator) {
        this(context, interpolator, context.getApplicationInfo().targetSdkVersion >= 11);
    }

    public C0259r(Context context, Interpolator interpolator, boolean z) {
        this.f1092H = ViewConfiguration.getScrollFriction();
        this.f1087C = true;
        this.f1088D = interpolator;
        this.f1094M = context.getResources().getDisplayMetrics().density * 160.0f;
        this.f1093L = m1672b(ViewConfiguration.getScrollFriction());
        this.f1089E = z;
        this.f1095N = m1672b(0.84f);
    }

    /* renamed from: b */
    private float m1672b(float f) {
        return (386.0878f * this.f1094M) * f;
    }

    /* renamed from: a */
    public final boolean m1674a() {
        return this.f1087C;
    }

    /* renamed from: a */
    public final void m1673a(boolean z) {
        this.f1087C = z;
    }

    /* renamed from: b */
    public final int m1675b() {
        return this.f1111p;
    }

    /* renamed from: c */
    public final int m1676c() {
        return this.f1112q;
    }

    /* renamed from: d */
    public final float m1677d() {
        return this.f1113r;
    }

    /* renamed from: e */
    public final float m1678e() {
        return this.f1114s;
    }

    /* renamed from: f */
    public final float m1679f() {
        return this.f1115t;
    }

    /* renamed from: g */
    public boolean m1680g() {
        if (this.f1087C) {
            return false;
        }
        int currentAnimationTimeMillis = (int) (AnimationUtils.currentAnimationTimeMillis() - this.f1116u);
        if (((long) currentAnimationTimeMillis) < this.f1117v) {
            float f;
            switch (this.f1096a) {
                case 1:
                    float f2 = ((float) currentAnimationTimeMillis) / ((float) this.f1117v);
                    int i = (int) (100.0f * f2);
                    float f3 = 1.0f;
                    f = 0.0f;
                    if (i < 100) {
                        f3 = ((float) i) / 100.0f;
                        f = ((float) (i + 1)) / 100.0f;
                        float f4 = f1081J[i];
                        f = (f1081J[i + 1] - f4) / (f - f3);
                        f3 = ((f2 - f3) * f) + f4;
                    }
                    this.f1090F = ((f * ((float) this.f1091G)) / ((float) this.f1117v)) * 1000.0f;
                    this.f1111p = this.f1097b + Math.round(((float) (this.f1102g - this.f1097b)) * f3);
                    this.f1111p = Math.min(this.f1111p, this.f1108m);
                    this.f1111p = Math.max(this.f1111p, this.f1107l);
                    this.f1112q = this.f1098c + Math.round(f3 * ((float) (this.f1103h - this.f1098c)));
                    this.f1112q = Math.min(this.f1112q, this.f1110o);
                    this.f1112q = Math.max(this.f1112q, this.f1109n);
                    if (this.f1111p == this.f1102g && this.f1112q == this.f1103h) {
                        this.f1087C = true;
                        break;
                    }
                case 2:
                    f = ((float) currentAnimationTimeMillis) * this.f1118w;
                    if (this.f1088D == null) {
                        f = C0259r.m1671a(f);
                    } else {
                        f = this.f1088D.getInterpolation(f);
                    }
                    this.f1111p = this.f1097b + Math.round(this.f1119x * f);
                    this.f1112q = this.f1098c + Math.round(this.f1120y * f);
                    this.f1113r = this.f1099d + (this.f1121z * f);
                    this.f1114s = this.f1100e + (this.f1085A * f);
                    this.f1115t = (f * this.f1086B) + this.f1101f;
                    break;
            }
        }
        this.f1111p = this.f1102g;
        this.f1112q = this.f1103h;
        this.f1113r = this.f1104i;
        this.f1114s = this.f1105j;
        this.f1115t = this.f1106k;
        this.f1087C = true;
        return true;
    }

    /* renamed from: a */
    static float m1671a(float f) {
        float f2 = f1083O * f;
        if (f2 < 1.0f) {
            f2 -= 1.0f - ((float) Math.exp((double) (-f2)));
        } else {
            f2 = ((1.0f - ((float) Math.exp((double) (1.0f - f2)))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return f2 * f1084P;
    }

    /* renamed from: h */
    public final int m1681h() {
        return this.f1096a;
    }
}
