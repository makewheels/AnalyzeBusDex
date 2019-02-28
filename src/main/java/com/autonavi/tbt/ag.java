package com.autonavi.tbt;

import java.util.Date;

/* compiled from: CrashLogWriter */
class ag extends aj {
    /* renamed from: a */
    private C0600a f3697a;

    /* compiled from: CrashLogWriter */
    /* renamed from: com.autonavi.tbt.ag$a */
    class C0600a implements ao {
        /* renamed from: a */
        final /* synthetic */ ag f3695a;
        /* renamed from: b */
        private C0638x f3696b;

        C0600a(ag agVar, C0638x c0638x) {
            this.f3695a = agVar;
            this.f3696b = c0638x;
        }

        /* renamed from: a */
        public void mo741a(String str) {
            try {
                this.f3696b.m4977a(str, this.f3695a.mo742a());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    ag() {
    }

    /* renamed from: a */
    protected int mo742a() {
        return 0;
    }

    /* renamed from: a */
    protected String mo744a(String str) {
        return C0625n.m4918b(str + ak.m4709a(new Date().getTime()));
    }

    /* renamed from: b */
    protected String mo745b() {
        return ai.f3708c;
    }

    /* renamed from: a */
    protected ao mo743a(C0638x c0638x) {
        try {
            if (this.f3697a == null) {
                this.f3697a = new C0600a(this, c0638x);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.f3697a;
    }
}
