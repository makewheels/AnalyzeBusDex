package com.amap.api.p015a;

/* compiled from: TransAnim */
/* renamed from: com.amap.api.a.bz */
class bz extends C0237f {
    /* renamed from: e */
    private ac f972e;
    /* renamed from: f */
    private ac f973f;
    /* renamed from: g */
    private int f974g = ((int) this.f972e.m827e());
    /* renamed from: h */
    private int f975h = ((int) this.f972e.m828f());
    /* renamed from: i */
    private int f976i;
    /* renamed from: j */
    private int f977j;
    /* renamed from: k */
    private int f978k;
    /* renamed from: l */
    private int f979l;
    /* renamed from: m */
    private int f980m;
    /* renamed from: n */
    private ca f981n;

    public bz(int i, int i2, ac acVar, ac acVar2, int i3, ca caVar) {
        super(i, i2);
        this.f972e = acVar;
        this.f973f = acVar2;
        this.f981n = caVar;
        this.f978k = (int) Math.abs(acVar2.m827e() - this.f972e.m827e());
        this.f979l = (int) Math.abs(acVar2.m828f() - this.f972e.m828f());
        m1589a(i3);
    }

    /* renamed from: a */
    private void m1589a(int i) {
        int i2 = 2;
        int i3 = (i / 10) / 10;
        if (i3 >= 2) {
            i2 = i3;
        }
        this.f976i = this.f978k / i2;
        this.f977j = this.f979l / i2;
    }

    /* renamed from: b */
    protected void mo236b() {
        this.f981n.mo61b();
        C0260s.m1682a().m1684b();
    }

    /* renamed from: a */
    protected void mo235a() {
        int e = (int) this.f973f.m827e();
        int f = (int) this.f973f.m828f();
        if (m1586f()) {
            this.f980m++;
            this.f974g = m1588a(this.f974g, e, this.f976i);
            this.f975h = m1588a(this.f975h, f, this.f977j);
            this.f981n.mo60a(new ac((double) this.f975h, (double) this.f974g, false));
            if (this.f974g == e && this.f975h == f) {
                m1581a(false);
                mo237h();
                return;
            }
            return;
        }
        this.f974g = e;
        this.f975h = f;
        this.f981n.mo60a(new ac((double) this.f975h, (double) this.f974g, false));
    }

    /* renamed from: a */
    private int m1588a(int i, int i2, int i3) {
        int i4;
        if (i2 > i) {
            i4 = i + i3;
            if (i4 >= i2) {
                this.f980m = 0;
                return i2;
            }
        }
        i4 = i - i3;
        if (i4 <= i2) {
            this.f980m = 0;
            return i2;
        }
        return i4;
    }

    /* renamed from: h */
    protected void mo237h() {
        bp.m1498a().m1500b();
    }
}
