package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Looper;

/* compiled from: ExceptionLogUpDateProcessor */
class be extends bh {
    /* renamed from: a */
    private static boolean f2026a = true;

    protected be(Context context) {
        super(context);
    }

    /* renamed from: a */
    protected String mo596a() {
        return bg.f2037b;
    }

    /* renamed from: b */
    protected int mo598b() {
        return 1;
    }

    /* renamed from: a */
    protected boolean mo597a(Context context) {
        if (C0411z.m3521g(context) != 1 || !f2026a) {
            return false;
        }
        f2026a = false;
        synchronized (Looper.getMainLooper()) {
            ar arVar = new ar(context);
            at a = arVar.m3112a();
            if (a == null) {
                return true;
            } else if (a.m3123b()) {
                a.m3122b(false);
                arVar.m3113a(a);
                return true;
            } else {
                return false;
            }
        }
    }
}
