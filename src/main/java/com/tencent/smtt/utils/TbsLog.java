package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import android.widget.TextView;
import com.tencent.smtt.sdk.TbsConfig;

public class TbsLog {
    /* renamed from: a */
    private static boolean f5109a = false;
    /* renamed from: b */
    private static TbsLogClient f5110b = null;

    static {
        if (f5110b == null) {
            setTbsLogClient(TbsLogClient.getIntance());
        }
    }

    public static void app_extra(String str, Context context) {
        int i = 0;
        try {
            Context applicationContext = context.getApplicationContext();
            String[] strArr = new String[]{TbsConfig.APP_DEMO, TbsConfig.APP_QB, "com.tencent.mm", TbsConfig.APP_QQ, TbsConfig.APP_DEMO_TEST, TbsConfig.APP_QZONE};
            String[] strArr2 = new String[]{"DEMO", "QB", "WX", "QQ", "TEST", "QZ"};
            while (i < strArr.length) {
                if (applicationContext.getPackageName().contains(strArr[i])) {
                    m7927i(str, "app_extra pid:" + Process.myPid() + "; APP_TAG:" + strArr2[i] + "!");
                    break;
                }
                i++;
            }
            if (i == strArr.length) {
                m7927i(str, "app_extra pid:" + Process.myPid() + "; APP_TAG:OTHER!");
            }
        } catch (Throwable th) {
            m7931w(str, "app_extra exception:" + Log.getStackTraceString(th));
        }
    }

    /* renamed from: d */
    public static void m7923d(String str, String str2) {
        f5110b.m7933d(str, "TBS:" + str2);
    }

    /* renamed from: d */
    public static void m7924d(String str, String str2, boolean z) {
        m7923d(str, str2);
        if (f5109a && z) {
            f5110b.showLog(str + ": " + str2);
        }
    }

    /* renamed from: e */
    public static void m7925e(String str, String str2) {
        f5110b.m7934e(str, "TBS:" + str2);
        f5110b.writeLog("(E)-" + str + "-TBS:" + str2);
    }

    /* renamed from: e */
    public static void m7926e(String str, String str2, boolean z) {
        m7925e(str, str2);
        if (f5109a && z) {
            f5110b.showLog(str + ": " + str2);
        }
    }

    public static String getTbsLogFilePath() {
        return TbsLogClient.f5114c != null ? TbsLogClient.f5114c.getAbsolutePath() : null;
    }

    /* renamed from: i */
    public static void m7927i(String str, String str2) {
        f5110b.m7935i(str, "TBS:" + str2);
        f5110b.writeLog("(I)-" + str + "-TBS:" + str2);
    }

    /* renamed from: i */
    public static void m7928i(String str, String str2, boolean z) {
        m7927i(str, str2);
        if (f5109a && z) {
            f5110b.showLog(str + ": " + str2);
        }
    }

    public static void setLogView(TextView textView) {
        if (textView != null) {
            f5110b.setLogView(textView);
        }
    }

    public static boolean setTbsLogClient(TbsLogClient tbsLogClient) {
        if (tbsLogClient == null) {
            return false;
        }
        f5110b = tbsLogClient;
        return true;
    }

    /* renamed from: v */
    public static void m7929v(String str, String str2) {
        f5110b.m7936v(str, "TBS:" + str2);
    }

    /* renamed from: v */
    public static void m7930v(String str, String str2, boolean z) {
        m7929v(str, str2);
        if (f5109a && z) {
            f5110b.showLog(str + ": " + str2);
        }
    }

    /* renamed from: w */
    public static void m7931w(String str, String str2) {
        f5110b.m7937w(str, "TBS:" + str2);
        f5110b.writeLog("(W)-" + str + "-TBS:" + str2);
    }

    /* renamed from: w */
    public static void m7932w(String str, String str2, boolean z) {
        m7931w(str, str2);
        if (f5109a && z) {
            f5110b.showLog(str + ": " + str2);
        }
    }
}
