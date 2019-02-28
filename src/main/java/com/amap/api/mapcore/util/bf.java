package com.amap.api.mapcore.util;

import java.util.List;

/* compiled from: ExceptionLogWriter */
class bf extends bj {
    /* renamed from: a */
    private C0364a f2029a;

    /* compiled from: ExceptionLogWriter */
    /* renamed from: com.amap.api.mapcore.util.bf$a */
    class C0364a implements bo {
        /* renamed from: a */
        final /* synthetic */ bf f2027a;
        /* renamed from: b */
        private al f2028b;

        C0364a(bf bfVar, al alVar) {
            this.f2027a = bfVar;
            this.f2028b = alVar;
        }

        /* renamed from: a */
        public void mo599a(String str) {
            try {
                this.f2028b.m3089b(str, this.f2027a.mo600a());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    bf() {
    }

    /* renamed from: a */
    protected int mo600a() {
        return 1;
    }

    /* renamed from: a */
    protected String mo602a(String str) {
        return ab.m3012b(str);
    }

    /* renamed from: b */
    protected String mo604b() {
        return bg.f2037b;
    }

    /* renamed from: a */
    protected bo mo601a(al alVar) {
        try {
            if (this.f2029a == null) {
                this.f2029a = new C0364a(this, alVar);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.f2029a;
    }

    /* renamed from: a */
    protected String mo603a(List<ad> list) {
        return null;
    }
}
