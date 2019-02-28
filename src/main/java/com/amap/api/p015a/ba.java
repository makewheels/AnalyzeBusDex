package com.amap.api.p015a;

import android.graphics.Point;
import android.graphics.PointF;
import com.amap.api.p015a.C0253m.C0252a;
import com.amap.api.p015a.bf.C0229d;
import java.util.ArrayList;

/* compiled from: MapProjection */
/* renamed from: com.amap.api.a.ba */
class ba {
    /* renamed from: a */
    double f752a = 156543.0339d;
    /* renamed from: b */
    int f753b = 0;
    /* renamed from: c */
    double f754c = -2.003750834E7d;
    /* renamed from: d */
    double f755d = 2.003750834E7d;
    /* renamed from: e */
    public int f756e = C0269x.f1183d;
    /* renamed from: f */
    public int f757f = C0269x.f1182c;
    /* renamed from: g */
    public int f758g = 10;
    /* renamed from: h */
    public double[] f759h = null;
    /* renamed from: i */
    public bb f760i = null;
    /* renamed from: j */
    public ac f761j = null;
    /* renamed from: k */
    public ac f762k = null;
    /* renamed from: l */
    public Point f763l = null;
    /* renamed from: m */
    public C0223a f764m = null;
    /* renamed from: n */
    C0229d f765n = null;
    /* renamed from: o */
    private double f766o = 116.39716d;
    /* renamed from: p */
    private double f767p = 39.91669d;
    /* renamed from: q */
    private double f768q = 0.01745329251994329d;

    /* compiled from: MapProjection */
    /* renamed from: com.amap.api.a.ba$a */
    static class C0223a {
        /* renamed from: a */
        float f748a;
        /* renamed from: b */
        float f749b;
        /* renamed from: c */
        float f750c;
        /* renamed from: d */
        float f751d;

        C0223a() {
        }
    }

    public ba(C0229d c0229d) {
        this.f765n = c0229d;
    }

    /* renamed from: a */
    public void m1290a() {
        if (this.f760i != null) {
            if (this.f760i.f769a > 0.0d) {
                this.f766o = this.f760i.f769a;
            }
            if (this.f760i.f770b > 0.0d) {
                this.f767p = this.f760i.f770b;
            }
            if (this.f760i.f771c > 0.0d) {
                this.f752a = this.f760i.f771c;
            }
            this.f753b = this.f760i.f772d;
            this.f754c = this.f760i.f773e;
            this.f755d = this.f760i.f774f;
            if (this.f760i.f775g >= 0) {
                this.f756e = this.f760i.f775g;
            }
            if (this.f760i.f776h >= 0) {
                this.f757f = this.f760i.f776h;
            }
            if (this.f760i.f777i >= 0) {
                this.f758g = this.f760i.f777i;
            }
        }
        this.f759h = new double[(this.f757f + 1)];
        for (int i = 0; i <= this.f757f; i++) {
            this.f759h[i] = this.f752a / ((double) m1283a(2, i));
        }
        this.f761j = m1288a(new ac(this.f767p, this.f766o, true));
        this.f762k = this.f761j.m829g();
        this.f763l = new Point(this.f765n.m1391c() / 2, this.f765n.m1393d() / 2);
        this.f764m = new C0223a();
        this.f764m.f748a = -2.0037508E7f;
        this.f764m.f749b = 2.0037508E7f;
        this.f764m.f750c = 2.0037508E7f;
        this.f764m.f751d = -2.0037508E7f;
    }

    /* renamed from: a */
    public void m1291a(Point point) {
        this.f763l = point;
    }

    /* renamed from: a */
    private int m1283a(int i, int i2) {
        int i3 = 1;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 *= i;
        }
        return i3;
    }

    /* renamed from: a */
    public ac m1288a(ac acVar) {
        if (acVar == null) {
            return null;
        }
        return new ac(((Math.log(Math.tan((((((double) acVar.m823b()) / 1000000.0d) + 90.0d) * 3.141592653589793d) / 360.0d)) / 0.017453292519943295d) * 2.003750834E7d) / 180.0d, ((((double) acVar.m821a()) / 1000000.0d) * 2.003750834E7d) / 180.0d, false);
    }

    /* renamed from: a */
    PointF m1286a(ac acVar, ac acVar2, Point point, double d) {
        PointF pointF = new PointF();
        pointF.x = (float) (((acVar.m827e() - acVar2.m827e()) / d) + ((double) point.x));
        pointF.y = (float) (((double) point.y) - ((acVar.m828f() - acVar2.m828f()) / d));
        return pointF;
    }

    /* renamed from: b */
    public ac m1295b(ac acVar) {
        return new ac((int) (((double) ((float) (57.29577951308232d * ((2.0d * Math.atan(Math.exp((((double) ((float) ((acVar.m828f() * 180.0d) / 2.003750834E7d))) * 3.141592653589793d) / 180.0d))) - 1.5707963267948966d)))) * 1000000.0d), (int) (((double) ((float) ((acVar.m827e() * 180.0d) / 2.003750834E7d))) * 1000000.0d));
    }

    /* renamed from: a */
    public ac m1287a(PointF pointF, ac acVar, Point point, double d, C0223a c0223a) {
        return m1295b(m1294b(pointF, acVar, point, d, c0223a));
    }

    /* renamed from: b */
    ac m1294b(PointF pointF, ac acVar, Point point, double d, C0223a c0223a) {
        PointF c = this.f765n.m1396g().m1247c(pointF);
        float f = c.y - ((float) point.y);
        double e = (((double) (c.x - ((float) point.x))) * d) + acVar.m827e();
        double f2 = acVar.m828f() - (((double) f) * d);
        while (e < ((double) c0223a.f748a)) {
            e += (double) (c0223a.f749b - c0223a.f748a);
        }
        double d2 = e;
        while (d2 > ((double) c0223a.f749b)) {
            d2 -= (double) (c0223a.f749b - c0223a.f748a);
        }
        e = f2;
        while (e < ((double) c0223a.f751d)) {
            e += (double) (c0223a.f750c - c0223a.f751d);
        }
        double d3 = e;
        while (d3 > ((double) c0223a.f750c)) {
            d3 -= (double) (c0223a.f750c - c0223a.f751d);
        }
        return new ac(d3, d2, false);
    }

    /* renamed from: b */
    public PointF m1293b(ac acVar, ac acVar2, Point point, double d) {
        return this.f765n.m1396g().m1234b(m1286a(m1288a(acVar), acVar2, point, d));
    }

    /* renamed from: a */
    public ArrayList<C0252a> m1289a(ac acVar, int i, int i2, int i3) {
        int i4;
        double d = this.f759h[this.f758g];
        int e = (int) ((acVar.m827e() - this.f754c) / (256.0d * d));
        double d2 = this.f754c + (((double) (e * 256)) * d);
        double d3 = 0.0d;
        int f;
        if (this.f753b == 0) {
            f = (int) ((this.f755d - acVar.m828f()) / (256.0d * d));
            d3 = this.f755d - (((double) (f * 256)) * d);
            i4 = f;
        } else if (this.f753b == 1) {
            f = (int) ((acVar.m828f() - this.f755d) / (256.0d * d));
            d3 = ((double) ((f + 1) * 256)) * d;
            i4 = f;
        } else {
            i4 = 0;
        }
        PointF a = m1286a(new ac(d3, d2, false), acVar, this.f763l, d);
        C0252a c0252a = new C0252a(e, i4, this.f758g, -1);
        c0252a.f1050f = a;
        ArrayList<C0252a> arrayList = new ArrayList();
        arrayList.add(c0252a);
        int i5 = 1;
        while (true) {
            int i6;
            Object obj = null;
            for (i6 = e - i5; i6 <= e + i5; i6++) {
                Object obj2;
                int i7 = i4 + i5;
                PointF a2 = m1285a(i6, i7, e, i4, a, i2, i3);
                if (a2 != null) {
                    if (obj == null) {
                        obj2 = 1;
                    } else {
                        obj2 = obj;
                    }
                    C0252a c0252a2 = new C0252a(i6, i7, this.f758g, -1);
                    c0252a2.f1050f = a2;
                    arrayList.add(c0252a2);
                    obj = obj2;
                }
                i7 = i4 - i5;
                PointF a3 = m1285a(i6, i7, e, i4, a, i2, i3);
                if (a3 != null) {
                    if (obj == null) {
                        obj = 1;
                    }
                    C0252a c0252a3 = new C0252a(i6, i7, this.f758g, -1);
                    c0252a3.f1050f = a3;
                    arrayList.add(c0252a3);
                }
            }
            for (i7 = (i4 + i5) - 1; i7 > i4 - i5; i7--) {
                i6 = e + i5;
                a2 = m1285a(i6, i7, e, i4, a, i2, i3);
                if (a2 != null) {
                    if (obj == null) {
                        obj2 = 1;
                    } else {
                        obj2 = obj;
                    }
                    c0252a2 = new C0252a(i6, i7, this.f758g, -1);
                    c0252a2.f1050f = a2;
                    arrayList.add(c0252a2);
                    obj = obj2;
                }
                i6 = e - i5;
                a3 = m1285a(i6, i7, e, i4, a, i2, i3);
                if (a3 != null) {
                    if (obj == null) {
                        obj = 1;
                    }
                    c0252a3 = new C0252a(i6, i7, this.f758g, -1);
                    c0252a3.f1050f = a3;
                    arrayList.add(c0252a3);
                }
            }
            if (obj == null) {
                return arrayList;
            }
            i5++;
        }
    }

    /* renamed from: a */
    PointF m1285a(int i, int i2, int i3, int i4, PointF pointF, int i5, int i6) {
        PointF pointF2 = new PointF();
        pointF2.x = ((float) ((i - i3) * 256)) + pointF.x;
        if (this.f753b == 0) {
            pointF2.y = ((float) ((i2 - i4) * 256)) + pointF.y;
        } else if (this.f753b == 1) {
            pointF2.y = pointF.y - ((float) ((i2 - i4) * 256));
        }
        if (pointF2.x + 256.0f <= 0.0f || pointF2.x >= ((float) i5) || pointF2.y + 256.0f <= 0.0f || pointF2.y >= ((float) i6)) {
            return null;
        }
        return pointF2;
    }

    /* renamed from: a */
    public void m1292a(PointF pointF, PointF pointF2, int i) {
        double d = this.f759h[i];
        ac b = m1294b(pointF, this.f761j, this.f763l, d, this.f764m);
        ac b2 = m1294b(pointF2, this.f761j, this.f763l, d, this.f764m);
        double f = b2.m828f() - b.m828f();
        double e = this.f761j.m827e() + (b2.m827e() - b.m827e());
        double f2 = this.f761j.m828f() + f;
        while (e < ((double) this.f764m.f748a)) {
            e += (double) (this.f764m.f749b - this.f764m.f748a);
        }
        while (e > ((double) this.f764m.f749b)) {
            e -= (double) (this.f764m.f749b - this.f764m.f748a);
        }
        while (f2 < ((double) this.f764m.f751d)) {
            f2 += (double) (this.f764m.f750c - this.f764m.f751d);
        }
        while (f2 > ((double) this.f764m.f750c)) {
            f2 -= (double) (this.f764m.f750c - this.f764m.f751d);
        }
        this.f761j.m824b(f2);
        this.f761j.m822a(e);
    }

    /* renamed from: a */
    public float m1284a(ac acVar, ac acVar2) {
        double a = C0270y.m1729a(acVar.m825c());
        double a2 = C0270y.m1729a(acVar.m826d());
        double a3 = C0270y.m1729a(acVar2.m825c());
        a *= this.f768q;
        a2 *= this.f768q;
        a3 *= this.f768q;
        double a4 = C0270y.m1729a(acVar2.m826d()) * this.f768q;
        double sin = Math.sin(a);
        double sin2 = Math.sin(a2);
        a = Math.cos(a);
        a2 = Math.cos(a2);
        double sin3 = Math.sin(a3);
        double sin4 = Math.sin(a4);
        a3 = Math.cos(a3);
        a4 = Math.cos(a4);
        r17 = new double[3];
        double[] dArr = new double[]{a * a2, a2 * sin, sin2};
        dArr[0] = a4 * a3;
        dArr[1] = a4 * sin3;
        dArr[2] = sin4;
        return (float) (Math.asin(Math.sqrt((((r17[0] - dArr[0]) * (r17[0] - dArr[0])) + ((r17[1] - dArr[1]) * (r17[1] - dArr[1]))) + ((r17[2] - dArr[2]) * (r17[2] - dArr[2]))) / 2.0d) * 1.27420015798544E7d);
    }
}
