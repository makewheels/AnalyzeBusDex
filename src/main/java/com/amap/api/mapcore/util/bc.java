package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Looper;

/* compiled from: CrashLogUpDateProcessor */
class bc extends bh {
    /* renamed from: a */
    private static boolean f2022a = true;

    protected bc(Context context) {
        super(context);
    }

    /* renamed from: a */
    protected String mo596a() {
        return bg.f2038c;
    }

    /* renamed from: b */
    protected int mo598b() {
        return 0;
    }

    /* renamed from: a */
    protected boolean mo597a(Context context) {
        if (!f2022a) {
            return false;
        }
        f2022a = false;
        synchronized (Looper.getMainLooper()) {
            ar arVar = new ar(context);
            at a = arVar.m3112a();
            if (a == null) {
                return true;
            } else if (a.m3121a()) {
                a.m3120a(false);
                arVar.m3113a(a);
                return true;
            } else {
                return false;
            }
        }
    }
}
