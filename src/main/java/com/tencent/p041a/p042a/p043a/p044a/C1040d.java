package com.tencent.p041a.p042a.p043a.p044a;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.util.Log;

/* renamed from: com.tencent.a.a.a.a.d */
final class C1040d extends C1037f {
    public C1040d(Context context) {
        super(context);
    }

    /* renamed from: a */
    protected final void mo1704a(String str) {
        synchronized (this) {
            Log.i("MID", "write mid to sharedPreferences");
            Editor edit = PreferenceManager.getDefaultSharedPreferences(this.a).edit();
            edit.putString(C1043h.m7502f("4kU71lN96TJUomD1vOU9lgj9Tw=="), str);
            edit.commit();
        }
    }

    /* renamed from: a */
    protected final boolean mo1705a() {
        return true;
    }

    /* renamed from: b */
    protected final String mo1706b() {
        String string;
        synchronized (this) {
            Log.i("MID", "read mid from sharedPreferences");
            string = PreferenceManager.getDefaultSharedPreferences(this.a).getString(C1043h.m7502f("4kU71lN96TJUomD1vOU9lgj9Tw=="), null);
        }
        return string;
    }
}
