package com.tencent.wxop.stat.common;

import java.io.File;

/* renamed from: com.tencent.wxop.stat.common.o */
class C1196o {
    /* renamed from: a */
    private static int f5504a = -1;

    /* renamed from: a */
    public static boolean m8320a() {
        if (f5504a == 1) {
            return true;
        }
        if (f5504a == 0) {
            return false;
        }
        String[] strArr = new String[]{"/bin", "/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
        int i = 0;
        while (i < 6) {
            try {
                if (new File(strArr[i] + "su").exists()) {
                    f5504a = 1;
                    return true;
                }
                i++;
            } catch (Exception e) {
            }
        }
        f5504a = 0;
        return false;
    }
}
