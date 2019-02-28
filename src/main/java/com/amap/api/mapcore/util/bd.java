package com.amap.api.mapcore.util;

import java.util.Date;
import java.util.List;

/* compiled from: CrashLogWriter */
class bd extends bj {
    /* renamed from: a */
    private C0363a f2025a;

    /* compiled from: CrashLogWriter */
    /* renamed from: com.amap.api.mapcore.util.bd$a */
    class C0363a implements bo {
        /* renamed from: a */
        final /* synthetic */ bd f2023a;
        /* renamed from: b */
        private al f2024b;

        C0363a(bd bdVar, al alVar) {
            this.f2023a = bdVar;
            this.f2024b = alVar;
        }

        /* renamed from: a */
        public void mo599a(String str) {
            try {
                this.f2024b.m3089b(str, this.f2023a.mo600a());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    bd() {
    }

    /* renamed from: a */
    protected int mo600a() {
        return 0;
    }

    /* renamed from: a */
    protected String mo602a(String str) {
        return ab.m3012b(str + bk.m3224a(new Date().getTime()));
    }

    /* renamed from: b */
    protected String mo604b() {
        return bg.f2038c;
    }

    /* renamed from: a */
    protected bo mo601a(al alVar) {
        try {
            if (this.f2025a == null) {
                this.f2025a = new C0363a(this, alVar);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.f2025a;
    }

    /* renamed from: a */
    protected String mo603a(List<ad> list) {
        return null;
    }
}
