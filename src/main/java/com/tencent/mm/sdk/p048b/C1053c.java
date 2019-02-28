package com.tencent.mm.sdk.p048b;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.tencent.mm.sdk.p048b.C1052b.C1051a;

/* renamed from: com.tencent.mm.sdk.b.c */
final class C1053c implements C1051a {
    private Handler handler = new Handler(Looper.getMainLooper());

    C1053c() {
    }

    /* renamed from: f */
    public final void mo1707f(String str, String str2) {
        if (C1052b.level <= 2) {
            Log.i(str, str2);
        }
    }

    /* renamed from: g */
    public final void mo1708g(String str, String str2) {
        if (C1052b.level <= 1) {
            Log.d(str, str2);
        }
    }

    public final int getLogLevel() {
        return C1052b.level;
    }

    /* renamed from: h */
    public final void mo1710h(String str, String str2) {
        if (C1052b.level <= 3) {
            Log.w(str, str2);
        }
    }

    /* renamed from: i */
    public final void mo1711i(String str, String str2) {
        if (C1052b.level <= 4) {
            Log.e(str, str2);
        }
    }
}
