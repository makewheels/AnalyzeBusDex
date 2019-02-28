package com.alipay.security.mobile.module.p013c;

import android.os.Environment;
import com.alipay.security.mobile.module.p013c.p014a.C0166a;
import java.io.File;

/* renamed from: com.alipay.security.mobile.module.c.b */
public final class C0168b {
    /* renamed from: a */
    public static String m614a(String str) {
        try {
            if (C0168b.m615a()) {
                File file = new File(Environment.getExternalStorageDirectory(), str);
                if (file.exists()) {
                    return C0166a.m611b(file.getAbsolutePath());
                }
            }
        } catch (Exception e) {
        }
        return null;
    }

    /* renamed from: a */
    public static boolean m615a() {
        String externalStorageState = Environment.getExternalStorageState();
        return externalStorageState != null && externalStorageState.length() > 0 && ((externalStorageState.equals("mounted") || externalStorageState.equals("mounted_ro")) && Environment.getExternalStorageDirectory() != null);
    }
}
