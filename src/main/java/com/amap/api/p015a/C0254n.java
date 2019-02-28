package com.amap.api.p015a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;

/* compiled from: BitmapDrawer */
/* renamed from: com.amap.api.a.n */
class C0254n {
    /* renamed from: a */
    protected Bitmap f1055a = null;
    /* renamed from: b */
    protected Canvas f1056b = null;
    /* renamed from: c */
    protected Config f1057c;

    public C0254n(Config config) {
        this.f1057c = config;
    }

    /* renamed from: a */
    public void m1651a(Bitmap bitmap) {
        this.f1055a = bitmap;
        this.f1056b = new Canvas(this.f1055a);
    }

    /* renamed from: a */
    public void m1650a(int i, int i2) {
        m1649a();
        this.f1055a = Bitmap.createBitmap(i, i2, this.f1057c);
        this.f1056b = new Canvas(this.f1055a);
    }

    /* renamed from: a */
    public void m1649a() {
        if (this.f1055a != null) {
            this.f1055a.recycle();
        }
        this.f1055a = null;
        this.f1056b = null;
    }

    /* renamed from: a */
    public void m1652a(C0250o c0250o) {
        this.f1056b.save(1);
        c0250o.mo256a(this.f1056b);
        this.f1056b.restore();
    }

    /* renamed from: b */
    public Bitmap m1653b() {
        return this.f1055a;
    }
}
