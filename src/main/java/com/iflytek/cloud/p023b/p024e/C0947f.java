package com.iflytek.cloud.p023b.p024e;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.view.View;

/* renamed from: com.iflytek.cloud.b.e.f */
public class C0947f {
    /* renamed from: a */
    private static int f4493a = 0;

    /* renamed from: a */
    public static void m7148a(View view) {
        view.setLayerType(1, null);
    }

    /* renamed from: a */
    public static boolean m7149a(Context context, OnAudioFocusChangeListener onAudioFocusChangeListener) {
        try {
            ((AudioManager) context.getSystemService("audio")).requestAudioFocus(onAudioFocusChangeListener, 3, 2);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m7150b(Context context, OnAudioFocusChangeListener onAudioFocusChangeListener) {
        try {
            ((AudioManager) context.getSystemService("audio")).abandonAudioFocus(onAudioFocusChangeListener);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
