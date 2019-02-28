package com.amap.api.p015a;

import android.os.Handler;
import android.os.Looper;

/* compiled from: AnimBase */
/* renamed from: com.amap.api.a.f */
abstract class C0237f {
    /* renamed from: a */
    protected int f966a = 0;
    /* renamed from: b */
    public boolean f967b = false;
    /* renamed from: c */
    protected int f968c;
    /* renamed from: d */
    protected int f969d;
    /* renamed from: e */
    private Handler f970e = null;
    /* renamed from: f */
    private Runnable f971f = new C0245g(this);

    /* renamed from: a */
    protected abstract void mo235a();

    /* renamed from: b */
    protected abstract void mo236b();

    public C0237f(int i, int i2) {
        this.f968c = i;
        this.f969d = i2;
    }

    /* renamed from: c */
    public void m1583c() {
        if (!m1586f()) {
            this.f970e = new Handler(Looper.getMainLooper());
            this.f967b = true;
            this.f966a = 0;
        }
        m1587g();
    }

    /* renamed from: d */
    public void m1584d() {
        C0263u.m1701a().m1703b();
        mo237h();
        this.f971f.run();
    }

    /* renamed from: h */
    private void mo237h() {
        this.f967b = false;
    }

    /* renamed from: e */
    protected void m1585e() {
        this.f966a += this.f969d;
        if (this.f968c != -1 && this.f966a > this.f968c) {
            mo237h();
        }
    }

    /* renamed from: a */
    public void m1581a(boolean z) {
        this.f967b = z;
    }

    /* renamed from: f */
    public boolean m1586f() {
        return this.f967b;
    }

    /* renamed from: g */
    protected void m1587g() {
        this.f970e.post(this.f971f);
    }
}
