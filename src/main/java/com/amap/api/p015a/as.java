package com.amap.api.p015a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import com.amap.api.p015a.C0253m.C0252a;
import java.util.Iterator;
import p054u.aly.bi_常量类;

/* compiled from: LayerPropertys */
/* renamed from: com.amap.api.a.as */
public class as extends at {
    /* renamed from: a */
    public String f636a = bi_常量类.f6358b;
    /* renamed from: b */
    public int f637b = 18;
    /* renamed from: c */
    public int f638c = 3;
    /* renamed from: d */
    public boolean f639d = true;
    /* renamed from: e */
    public boolean f640e = true;
    /* renamed from: f */
    public boolean f641f = false;
    /* renamed from: g */
    public boolean f642g = false;
    /* renamed from: h */
    public boolean f643h = false;
    /* renamed from: i */
    public long f644i = 0;
    /* renamed from: j */
    public cd f645j = null;
    /* renamed from: k */
    public int f646k = -1;
    /* renamed from: l */
    public String f647l = bi_常量类.f6358b;
    /* renamed from: m */
    C0257p f648m = null;
    /* renamed from: n */
    C0258q f649n = null;
    /* renamed from: o */
    bq<C0252a> f650o = null;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof as)) {
            return false;
        }
        return this.f636a.equals(((as) obj).f636a);
    }

    public int hashCode() {
        return this.f646k;
    }

    public String toString() {
        return this.f636a;
    }

    /* renamed from: a */
    protected void m1060a(Canvas canvas) {
        if (this.f650o != null) {
            Iterator it = this.f650o.iterator();
            while (it.hasNext()) {
                Bitmap a;
                C0252a c0252a = (C0252a) it.next();
                if (c0252a.f1051g >= 0) {
                    a = this.f648m.m1660a(c0252a.f1051g);
                } else if (this.f640e) {
                    a = C0253m.m1648c();
                }
                PointF pointF = c0252a.f1050f;
                if (!(a == null || pointF == null)) {
                    canvas.drawBitmap(a, pointF.x, pointF.y, null);
                }
            }
        }
    }
}
