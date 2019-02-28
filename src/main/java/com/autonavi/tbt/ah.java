package com.autonavi.tbt;

/* compiled from: ExceptionLogWriter */
class ah extends aj {
    /* renamed from: a */
    private C0601a f3700a;

    /* compiled from: ExceptionLogWriter */
    /* renamed from: com.autonavi.tbt.ah$a */
    class C0601a implements ao {
        /* renamed from: a */
        final /* synthetic */ ah f3698a;
        /* renamed from: b */
        private C0638x f3699b;

        C0601a(ah ahVar, C0638x c0638x) {
            this.f3698a = ahVar;
            this.f3699b = c0638x;
        }

        /* renamed from: a */
        public void mo741a(String str) {
            try {
                this.f3699b.m4977a(str, this.f3698a.mo742a());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    ah() {
    }

    /* renamed from: a */
    protected int mo742a() {
        return 1;
    }

    /* renamed from: a */
    protected String mo744a(String str) {
        return C0625n.m4918b(str);
    }

    /* renamed from: b */
    protected String mo745b() {
        return ai.f3707b;
    }

    /* renamed from: a */
    protected ao mo743a(C0638x c0638x) {
        try {
            if (this.f3700a == null) {
                this.f3700a = new C0601a(this, c0638x);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.f3700a;
    }
}
