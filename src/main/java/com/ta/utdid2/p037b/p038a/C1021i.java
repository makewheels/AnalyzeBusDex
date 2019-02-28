package com.ta.utdid2.p037b.p038a;

import android.util.Log;
import com.umeng.analytics.C1233a;

/* compiled from: TimeUtils */
/* renamed from: com.ta.utdid2.b.a.i */
public class C1021i {
    /* renamed from: a */
    public static final String f4705a = C1021i.class.getName();

    /* renamed from: a */
    public static boolean m7385a(long j) {
        boolean z = (System.currentTimeMillis() - j) / C1233a.f5597m < 1;
        if (C1015c.f4699a) {
            Log.d(f4705a, "isUpToDate: " + z + "; oldTimestamp: " + j + "; currentTimestamp" + System.currentTimeMillis());
        }
        return z;
    }
}
