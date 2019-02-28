package com.iflytek.cloud;

import com.iflytek.msc.MSC;

public class Setting {
    /* renamed from: a */
    public static boolean f4356a = true;
    /* renamed from: b */
    public static boolean f4357b = true;
    /* renamed from: c */
    public static boolean f4358c = true;
    /* renamed from: d */
    public static LOG_LEVEL f4359d = LOG_LEVEL.none;
    /* renamed from: e */
    public static String f4360e = null;

    public enum LOG_LEVEL {
        all,
        detail,
        normal,
        low,
        none
    }

    private Setting() {
    }

    public static void checkNetwork(boolean z) {
        f4357b = z;
    }

    public static void saveLogFile(LOG_LEVEL log_level, String str) {
        f4359d = log_level;
        f4360e = str;
    }

    public static void setLocationEnable(boolean z) {
        f4358c = z;
    }

    public static void showLogcat(boolean z) {
        f4356a = z;
        MSC.DebugLog(z);
    }
}
