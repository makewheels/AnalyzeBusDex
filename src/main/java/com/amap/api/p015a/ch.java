package com.amap.api.p015a;

import android.graphics.Matrix;
import android.graphics.Point;
import android.view.animation.Animation.AnimationListener;

/* compiled from: ZoomCtlAnim */
/* renamed from: com.amap.api.a.ch */
class ch extends C0237f {
    /* renamed from: h */
    static float f1018h = 1.0f;
    /* renamed from: e */
    public C0222b f1019e;
    /* renamed from: f */
    public float f1020f;
    /* renamed from: g */
    public float f1021g;
    /* renamed from: i */
    public int f1022i = -1;
    /* renamed from: j */
    public boolean f1023j = false;
    /* renamed from: k */
    private AnimationListener f1024k;
    /* renamed from: l */
    private float f1025l;
    /* renamed from: m */
    private float f1026m;
    /* renamed from: n */
    private float f1027n;
    /* renamed from: o */
    private boolean f1028o;
    /* renamed from: p */
    private boolean f1029p = false;

    public ch(C0222b c0222b, AnimationListener animationListener) {
        super(160, 40);
        this.f1019e = c0222b;
        this.f1024k = animationListener;
    }

    /* renamed from: a */
    protected void mo235a() {
        if (this.f1028o) {
            f1018h += this.f1027n;
        } else {
            f1018h -= this.f1027n;
        }
        Matrix matrix = new Matrix();
        matrix.setScale(f1018h, f1018h, this.f1020f, this.f1021g);
        this.f1019e.mo124c(f1018h);
        this.f1019e.mo119b(matrix);
    }

    /* renamed from: b */
    protected void mo236b() {
        if (!this.f1029p) {
            Point point;
            ac a;
            this.f1019e.mo84a().f839d.f808b = false;
            if (this.f1023j) {
                point = new Point((int) this.f1020f, (int) this.f1021g);
                a = this.f1019e.mo144s().mo183a((int) this.f1020f, (int) this.f1021g);
                this.f1019e.mo84a().f843h.f761j = this.f1019e.mo84a().f843h.m1288a(a);
                this.f1019e.mo84a().f843h.m1291a(point);
                this.f1019e.mo84a().f837b.m1387a(false, false);
            }
            this.f1019e.m1176D().m1089c(this.f1022i);
            this.f1024k.onAnimationEnd(null);
            if (this.f1023j) {
                point = new Point(this.f1019e.mo84a().f837b.m1391c() / 2, this.f1019e.mo84a().f837b.m1393d() / 2);
                a = this.f1019e.mo144s().mo183a(this.f1019e.mo84a().f837b.m1391c() / 2, this.f1019e.mo84a().f837b.m1393d() / 2);
                this.f1019e.mo84a().f843h.f761j = this.f1019e.mo84a().f843h.m1288a(a);
                this.f1019e.mo84a().f843h.m1291a(point);
                this.f1019e.mo84a().f837b.m1387a(false, false);
            }
            this.f1019e.m1256e(0);
            f1018h = 1.0f;
            bg.f845k = 1.0f;
            this.f1019e.mo84a().m1407a(true);
        }
    }

    /* renamed from: a */
    public void m1635a(float f, int i, boolean z, float f2, float f3) {
        this.f1028o = z;
        this.f1020f = f2;
        this.f1021g = f3;
        this.f1025l = f;
        f1018h = this.f1025l;
        if (this.f1028o) {
            this.f1027n = (this.f1025l * ((float) this.d)) / ((float) this.c);
            this.f1026m = this.f1025l * 2.0f;
            return;
        }
        this.f1027n = ((this.f1025l * 0.5f) * ((float) this.d)) / ((float) this.c);
        this.f1026m = this.f1025l * 0.5f;
    }

    /* renamed from: a */
    public void m1636a(int i, boolean z, float f, float f2) {
        this.f1019e.f723b[0] = this.f1019e.f723b[1];
        this.f1019e.f723b[1] = i;
        if (this.f1019e.f723b[0] != this.f1019e.f723b[1]) {
            this.f1019e.mo84a().m1407a(this.f1019e.m1174B());
            if (m1586f()) {
                this.f1029p = true;
                m1584d();
                m1635a(this.f1026m, i, z, f, f2);
                this.f1019e.mo84a().f839d.m1365a(true);
                this.f1019e.mo84a().f839d.f808b = true;
                this.f1024k.onAnimationStart(null);
                super.m1583c();
                this.f1029p = false;
                return;
            }
            this.c = 160;
            m1635a(this.f1019e.m1180H(), i, z, f, f2);
            this.f1019e.mo84a().f839d.m1365a(true);
            this.f1019e.mo84a().f839d.f808b = true;
            this.f1024k.onAnimationStart(null);
            super.m1583c();
        }
    }
}
