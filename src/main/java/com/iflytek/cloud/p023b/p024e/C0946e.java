package com.iflytek.cloud.p023b.p024e;

import android.content.Context;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.os.Build.VERSION;
import android.view.View;

/* renamed from: com.iflytek.cloud.b.e.e */
public class C0946e {
    /* renamed from: a */
    public static int f4491a = 9;
    /* renamed from: b */
    public static int f4492b = 14;

    /* renamed from: a */
    public static void m7145a(View view) {
        if (VERSION.SDK_INT >= f4492b) {
            C0947f.m7148a(view);
        }
    }

    /* renamed from: a */
    public static boolean m7146a(Context context, Boolean bool, OnAudioFocusChangeListener onAudioFocusChangeListener) {
        if (bool.booleanValue() && VERSION.SDK_INT >= f4491a) {
            C0947f.m7149a(context, onAudioFocusChangeListener);
        }
        return false;
    }

    /* renamed from: b */
    public static boolean m7147b(Context context, Boolean bool, OnAudioFocusChangeListener onAudioFocusChangeListener) {
        return (!bool.booleanValue() || VERSION.SDK_INT < f4491a) ? false : C0947f.m7150b(context, onAudioFocusChangeListener);
    }
}
