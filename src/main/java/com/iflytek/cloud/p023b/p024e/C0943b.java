package com.iflytek.cloud.p023b.p024e;

import android.util.DisplayMetrics;
import java.text.SimpleDateFormat;
import java.util.Random;

/* renamed from: com.iflytek.cloud.b.e.b */
public class C0943b {
    /* renamed from: a */
    public static DisplayMetrics f4489a = null;

    /* renamed from: a */
    public static int m7132a(int i, int i2) {
        return new Random().nextInt(i2 - i) + i;
    }

    /* renamed from: a */
    public static String m7133a(long j) {
        return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss SSS").format(Long.valueOf(j));
    }

    /* renamed from: b */
    public static String m7134b(long j) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(j));
    }
}
