package com.tencent.p041a.p042a.p043a.p044a;

import android.content.Context;
import android.provider.Settings.System;
import android.util.Log;

/* renamed from: com.tencent.a.a.a.a.e */
public final class C1041e extends C1037f {
    public C1041e(Context context) {
        super(context);
    }

    /* renamed from: a */
    protected final void mo1704a(String str) {
        synchronized (this) {
            Log.i("MID", "write mid to Settings.System");
            System.putString(this.a.getContentResolver(), C1043h.m7502f("4kU71lN96TJUomD1vOU9lgj9Tw=="), str);
        }
    }

    /* renamed from: a */
    protected final boolean mo1705a() {
        return C1043h.m7498a(this.a, "android.permission.WRITE_SETTINGS");
    }

    /* renamed from: b */
    protected final String mo1706b() {
        String string;
        synchronized (this) {
            Log.i("MID", "read mid from Settings.System");
            string = System.getString(this.a.getContentResolver(), C1043h.m7502f("4kU71lN96TJUomD1vOU9lgj9Tw=="));
        }
        return string;
    }
}
