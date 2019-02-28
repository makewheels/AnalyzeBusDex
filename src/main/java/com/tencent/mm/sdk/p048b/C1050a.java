package com.tencent.mm.sdk.p048b;

import android.os.Bundle;

/* renamed from: com.tencent.mm.sdk.b.a */
public final class C1050a {
    /* renamed from: a */
    public static int m7508a(Bundle bundle, String str) {
        int i = -1;
        if (bundle != null) {
            try {
                i = bundle.getInt(str, -1);
            } catch (Exception e) {
                C1052b.m7514a("MicroMsg.IntentUtil", "getIntExtra exception:%s", e.getMessage());
            }
        }
        return i;
    }

    /* renamed from: b */
    public static String m7509b(Bundle bundle, String str) {
        String str2 = null;
        if (bundle != null) {
            try {
                str2 = bundle.getString(str);
            } catch (Exception e) {
                C1052b.m7514a("MicroMsg.IntentUtil", "getStringExtra exception:%s", e.getMessage());
            }
        }
        return str2;
    }
}
