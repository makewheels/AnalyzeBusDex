package com.iflytek.cloud.p023b.p024e.p029a;

import android.util.Log;
import com.iflytek.cloud.Setting;

/* renamed from: com.iflytek.cloud.b.e.a.a */
public class C0939a {
    /* renamed from: a */
    private static String f4473a = "MscSpeechLog";
    /* renamed from: b */
    private static boolean f4474b = false;

    /* renamed from: a */
    public static void m7120a(String str) {
        if (Setting.f4356a) {
            Log.d(f4473a, str);
        }
        if (C0940b.m7124a()) {
            C0940b.m7123a("D", str, null);
        }
    }

    /* renamed from: a */
    public static void m7121a(String str, String str2) {
        if (Setting.f4356a) {
            Log.d(str, str2);
        }
        if (C0940b.m7124a()) {
            C0940b.m7123a("D", str2, null);
        }
    }

    /* renamed from: b */
    public static void m7122b(String str) {
        if (Setting.f4356a && f4474b) {
            Log.d(f4473a, str);
        }
        if (C0940b.m7124a()) {
            C0940b.m7123a("S", str, null);
        }
    }
}
