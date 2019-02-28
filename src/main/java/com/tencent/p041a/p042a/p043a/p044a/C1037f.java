package com.tencent.p041a.p042a.p043a.p044a;

import android.content.Context;

/* renamed from: com.tencent.a.a.a.a.f */
public abstract class C1037f {
    /* renamed from: a */
    protected Context f4763a = null;

    protected C1037f(Context context) {
        this.f4763a = context;
    }

    /* renamed from: a */
    public final void m7474a(C1039c c1039c) {
        if (c1039c != null) {
            String c1039c2 = c1039c.toString();
            if (mo1705a()) {
                mo1704a(C1043h.m7503g(c1039c2));
            }
        }
    }

    /* renamed from: a */
    protected abstract void mo1704a(String str);

    /* renamed from: a */
    protected abstract boolean mo1705a();

    /* renamed from: b */
    protected abstract String mo1706b();

    /* renamed from: o */
    public final C1039c m7478o() {
        String f = mo1705a() ? C1043h.m7502f(mo1706b()) : null;
        return f != null ? C1039c.m7482e(f) : null;
    }
}
