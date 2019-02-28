package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Looper;

/* compiled from: ANRLogUpDateProcessor */
class ba extends bh {
    /* renamed from: a */
    private static boolean f2013a = true;

    protected ba(Context context) {
        super(context);
    }

    /* renamed from: a */
    protected String mo596a() {
        return bg.f2039d;
    }

    /* renamed from: b */
    protected int mo598b() {
        return 2;
    }

    /* renamed from: a */
    protected boolean mo597a(Context context) {
        if (C0411z.m3521g(context) != 1 || !f2013a) {
            return false;
        }
        f2013a = false;
        synchronized (Looper.getMainLooper()) {
            ar arVar = new ar(context);
            at a = arVar.m3112a();
            if (a == null) {
                return true;
            } else if (a.m3125c()) {
                a.m3124c(false);
                arVar.m3113a(a);
                return true;
            } else {
                return false;
            }
        }
    }
}
