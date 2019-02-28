package com.tencent.smtt.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;

/* renamed from: com.tencent.smtt.utils.z */
public class C1164z {
    /* renamed from: a */
    private static File f5192a = null;

    /* renamed from: a */
    public static long m8080a() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return (((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / 1024;
    }

    /* renamed from: a */
    public static long m8081a(File file) {
        long j = 0;
        if (file == null || !file.isDirectory()) {
            return 0;
        }
        for (File length : file.listFiles()) {
            j += length.length();
        }
        return j / 1024;
    }

    /* renamed from: a */
    public static long m8082a(String str) {
        if (str != null && str.length() > 0) {
            File file = new File(str);
            if (file.exists()) {
                return file.length() / 1024;
            }
        }
        return 0;
    }

    @TargetApi(9)
    /* renamed from: a */
    public static boolean m8083a(Context context) {
        if (context == null) {
            return false;
        }
        if (f5192a == null) {
            try {
                if (!context.getApplicationInfo().processName.contains("com.tencent.mm")) {
                    return false;
                }
                File dir = context.getDir("tbs", 0);
                if (dir == null || !dir.isDirectory()) {
                    return false;
                }
                File file = new File(dir, "share");
                if (file != null) {
                    if (!file.isDirectory() && !file.mkdir()) {
                        return false;
                    }
                    f5192a = file;
                    file.setExecutable(true, false);
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }
}
