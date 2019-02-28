package com.ta.utdid2.p036a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.util.Base64;
import android.util.Log;
import com.ta.utdid2.p037b.p038a.C1014b;
import com.ta.utdid2.p037b.p038a.C1015c;
import com.ta.utdid2.p037b.p038a.C1019g;
import com.ta.utdid2.p037b.p038a.C1020h;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import p054u.aly.bi_常量类;

/* compiled from: AidStorageController */
/* renamed from: com.ta.utdid2.a.c */
public class C1009c {
    /* renamed from: a */
    private static final String f4678a = C1009c.class.getName();
    /* renamed from: b */
    private static Map<String, String> f4679b = new ConcurrentHashMap();
    /* renamed from: c */
    private static Map<String, Long> f4680c = new ConcurrentHashMap();

    /* renamed from: a */
    public static void m7364a(Context context, String str, String str2, String str3) {
        if (context == null) {
            Log.e(f4678a, "no context!");
            return;
        }
        String a = C1009c.m7363a(str, str3);
        long currentTimeMillis = System.currentTimeMillis();
        f4679b.put(a, str2);
        f4680c.put(a, Long.valueOf(currentTimeMillis));
        SharedPreferences sharedPreferences = context.getSharedPreferences("UTCommon", 0);
        if (VERSION.SDK_INT >= 9) {
            C1019g.m7382a(sharedPreferences.edit().putString("EvQwnbilKezpOJey".concat(a), str2));
            C1019g.m7382a(sharedPreferences.edit().putLong("rKrMJgyAEbVtSQGi".concat(a), currentTimeMillis));
            return;
        }
        sharedPreferences.edit().putString("EvQwnbilKezpOJey".concat(a), str2).commit();
        sharedPreferences.edit().putLong("rKrMJgyAEbVtSQGi".concat(a), currentTimeMillis).commit();
    }

    /* renamed from: a */
    public static String m7362a(Context context, String str, String str2) {
        if (context == null) {
            Log.e(f4678a, "no context!");
            return bi_常量类.f6358b;
        }
        String a = C1009c.m7363a(str, str2);
        String str3 = (String) f4679b.get(a);
        if (C1015c.f4699a) {
            Log.d(f4678a, "cache AID:" + str3);
        }
        if (!C1020h.m7383a(str3)) {
            return str3;
        }
        str3 = context.getSharedPreferences("UTCommon", 0).getString("EvQwnbilKezpOJey".concat(a), bi_常量类.f6358b);
        f4679b.put(a, str3);
        return str3;
    }

    /* renamed from: b */
    public static long m7365b(Context context, String str, String str2) {
        if (context == null) {
            Log.e(f4678a, "no context!");
            return 0;
        }
        String a = C1009c.m7363a(str, str2);
        Long valueOf = Long.valueOf(f4680c.containsKey(a) ? ((Long) f4680c.get(a)).longValue() : 0);
        if (C1015c.f4699a) {
            Log.d(f4678a, "cache AIDGenTime:" + valueOf);
        }
        if (valueOf.longValue() == 0) {
            valueOf = Long.valueOf(context.getSharedPreferences("UTCommon", 0).getLong("rKrMJgyAEbVtSQGi".concat(a), 0));
            f4680c.put(a, valueOf);
        }
        return valueOf.longValue();
    }

    /* renamed from: a */
    private static String m7363a(String str, String str2) {
        String encodeToString;
        if (VERSION.SDK_INT >= 8) {
            encodeToString = Base64.encodeToString(str.concat(str2).getBytes(), 2);
        } else {
            encodeToString = C1014b.m7372a(str.concat(str2).getBytes(), 2);
        }
        if (C1015c.f4699a) {
            Log.d(f4678a, "encodedName:" + encodeToString);
        }
        return encodeToString;
    }
}
