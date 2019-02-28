package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;

class TbsLinuxToolsJni {
    /* renamed from: a */
    private static boolean f4838a = false;
    /* renamed from: b */
    private static boolean f4839b = false;

    public TbsLinuxToolsJni(Context context) {
        m7586a(context);
    }

    private native int ChmodInner(String str, String str2);

    /* renamed from: a */
    private void m7586a(Context context) {
        synchronized (TbsLinuxToolsJni.class) {
            if (f4839b) {
                return;
            }
            f4839b = true;
            try {
                File file = TbsShareManager.isThirdPartyApp(context) ? new File(TbsShareManager.m7632b(context)) : ac.m7706a().m7747f(context);
                if (file != null) {
                    System.load(file.getAbsolutePath() + File.separator + "liblinuxtoolsfortbssdk_jni.so");
                    f4838a = true;
                }
                ChmodInner("/checkChmodeExists", "700");
            } catch (Throwable th) {
                th.printStackTrace();
                f4838a = false;
            }
        }
    }

    /* renamed from: a */
    public int m7587a(String str, String str2) {
        if (f4838a) {
            return ChmodInner(str, str2);
        }
        TbsLog.m7926e("TbsLinuxToolsJni", "jni not loaded!", true);
        return -1;
    }
}
