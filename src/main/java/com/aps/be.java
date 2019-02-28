package com.aps;

import android.content.Context;
import android.util.Log;
import p054u.aly.bi_常量类;

public final class be {
    /* renamed from: a */
    private static String f3416a = bi_常量类.f6358b_空串;

    /* renamed from: a */
    protected static void m4426a(String str) {
        if (!str.equals("GPS_SATELLITE")) {
        }
    }

    /* renamed from: a */
    protected static boolean m4427a(Context context) {
        if (context != null) {
            f3416a = context.getPackageName();
            return true;
        }
        Log.d(f3416a, "Error: No SD Card!");
        return false;
    }
}
