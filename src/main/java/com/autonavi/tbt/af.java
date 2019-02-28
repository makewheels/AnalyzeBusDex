package com.autonavi.tbt;

/* compiled from: ANRLogWriter */
class af extends aj {
    /* renamed from: a */
    private String[] f3690a = new String[10];
    /* renamed from: b */
    private int f3691b = 0;
    /* renamed from: c */
    private boolean f3692c = false;
    /* renamed from: d */
    private int f3693d = 0;
    /* renamed from: e */
    private C0599a f3694e;

    /* compiled from: ANRLogWriter */
    /* renamed from: com.autonavi.tbt.af$a */
    private class C0599a implements ao {
        /* renamed from: a */
        final /* synthetic */ af f3687a;
        /* renamed from: b */
        private C0638x f3688b;

        private C0599a(af afVar, C0638x c0638x) {
            this.f3687a = afVar;
            this.f3688b = c0638x;
        }

        /* renamed from: a */
        public void mo741a(String str) {
            try {
                this.f3688b.m4977a(str, this.f3687a.mo742a());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    af() {
    }

    /* renamed from: a */
    protected int mo742a() {
        return 2;
    }

    /* renamed from: b */
    protected String mo745b() {
        return ai.f3709d;
    }

    /* renamed from: a */
    protected String mo744a(String str) {
        return C0625n.m4918b(str);
    }

    /* renamed from: a */
    protected ao mo743a(C0638x c0638x) {
        try {
            if (this.f3694e == null) {
                this.f3694e = new C0599a(c0638x);
            }
        } catch (Throwable th) {
            ae.m4671a(th, "ANRWriter", "getListener");
            th.printStackTrace();
        }
        return this.f3694e;
    }
}
