package com.alipay.security.mobile.module.p013c;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import java.util.Map;

/* renamed from: com.alipay.security.mobile.module.c.c */
public final class C0169c {
    /* renamed from: a */
    public static String m616a(Context context, String str, String str2, String str3) {
        return context.getSharedPreferences(str, 0).getString(str2, str3);
    }

    /* renamed from: a */
    public static void m617a(Context context, String str, Map<String, String> map) {
        Editor edit = context.getSharedPreferences(str, 0).edit();
        if (edit != null) {
            edit.clear();
            for (String str2 : map.keySet()) {
                edit.putString(str2, (String) map.get(str2));
            }
            edit.commit();
        }
    }
}
