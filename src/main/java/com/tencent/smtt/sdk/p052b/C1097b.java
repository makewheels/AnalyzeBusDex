package com.tencent.smtt.sdk.p052b;

import android.content.Context;
import android.net.ConnectivityManager;

/* renamed from: com.tencent.smtt.sdk.b.b */
public class C1097b {
    /* renamed from: a */
    private static Context f5008a;
    /* renamed from: b */
    private static ConnectivityManager f5009b;

    /* renamed from: a */
    public static ConnectivityManager m7823a() {
        if (f5009b == null && f5008a != null) {
            f5009b = (ConnectivityManager) f5008a.getSystemService("connectivity");
        }
        return f5009b;
    }

    /* renamed from: a */
    public static void m7824a(Context context) {
        f5008a = context;
    }
}
