package com.tencent.wxop.stat.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

/* renamed from: com.tencent.wxop.stat.common.p */
public class C1197p {
    /* renamed from: a */
    private static SharedPreferences f5505a = null;

    /* renamed from: a */
    public static int m8321a(Context context, String str, int i) {
        return C1197p.m8323a(context).getInt(C1192k.m8276a(context, new StringBuilder(StatConstants.MTA_COOPERATION_TAG).append(str).toString()), i);
    }

    /* renamed from: a */
    public static long m8322a(Context context, String str, long j) {
        return C1197p.m8323a(context).getLong(C1192k.m8276a(context, new StringBuilder(StatConstants.MTA_COOPERATION_TAG).append(str).toString()), j);
    }

    /* renamed from: a */
    static synchronized SharedPreferences m8323a(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (C1197p.class) {
            sharedPreferences = context.getSharedPreferences(".mta-wxop", 0);
            f5505a = sharedPreferences;
            if (sharedPreferences == null) {
                f5505a = PreferenceManager.getDefaultSharedPreferences(context);
            }
            sharedPreferences = f5505a;
        }
        return sharedPreferences;
    }

    /* renamed from: a */
    public static String m8324a(Context context, String str, String str2) {
        return C1197p.m8323a(context).getString(C1192k.m8276a(context, new StringBuilder(StatConstants.MTA_COOPERATION_TAG).append(str).toString()), str2);
    }

    /* renamed from: b */
    public static void m8325b(Context context, String str, int i) {
        String a = C1192k.m8276a(context, new StringBuilder(StatConstants.MTA_COOPERATION_TAG).append(str).toString());
        Editor edit = C1197p.m8323a(context).edit();
        edit.putInt(a, i);
        edit.commit();
    }

    /* renamed from: b */
    public static void m8326b(Context context, String str, long j) {
        String a = C1192k.m8276a(context, new StringBuilder(StatConstants.MTA_COOPERATION_TAG).append(str).toString());
        Editor edit = C1197p.m8323a(context).edit();
        edit.putLong(a, j);
        edit.commit();
    }

    /* renamed from: b */
    public static void m8327b(Context context, String str, String str2) {
        String a = C1192k.m8276a(context, new StringBuilder(StatConstants.MTA_COOPERATION_TAG).append(str).toString());
        Editor edit = C1197p.m8323a(context).edit();
        edit.putString(a, str2);
        edit.commit();
    }
}
