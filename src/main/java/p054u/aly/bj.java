package p054u.aly;

import android.util.Log;

/* compiled from: Log */
/* renamed from: u.aly.bj */
public class bj {
    /* renamed from: a */
    public static boolean f6362a = false;

    /* renamed from: a */
    public static void m10000a(String str, String str2) {
        if (f6362a) {
            Log.i(str, str2);
        }
    }

    /* renamed from: a */
    public static void m10001a(String str, String str2, Exception exception) {
        if (f6362a) {
            Log.i(str, exception.toString() + ":  [" + str2 + "]");
        }
    }

    /* renamed from: b */
    public static void m10002b(String str, String str2) {
        if (f6362a) {
            Log.e(str, str2);
        }
    }

    /* renamed from: b */
    public static void m10003b(String str, String str2, Exception exception) {
        if (f6362a) {
            Log.e(str, exception.toString() + ":  [" + str2 + "]");
            for (StackTraceElement stackTraceElement : exception.getStackTrace()) {
                Log.e(str, "        at\t " + stackTraceElement.toString());
            }
        }
    }

    /* renamed from: c */
    public static void m10004c(String str, String str2) {
        if (f6362a) {
            Log.d(str, str2);
        }
    }

    /* renamed from: c */
    public static void m10005c(String str, String str2, Exception exception) {
        if (f6362a) {
            Log.d(str, exception.toString() + ":  [" + str2 + "]");
        }
    }

    /* renamed from: d */
    public static void m10006d(String str, String str2) {
        if (f6362a) {
            Log.v(str, str2);
        }
    }

    /* renamed from: d */
    public static void m10007d(String str, String str2, Exception exception) {
        if (f6362a) {
            Log.v(str, exception.toString() + ":  [" + str2 + "]");
        }
    }

    /* renamed from: e */
    public static void m10008e(String str, String str2) {
        if (f6362a) {
            Log.w(str, str2);
        }
    }

    /* renamed from: e */
    public static void m10009e(String str, String str2, Exception exception) {
        if (f6362a) {
            Log.w(str, exception.toString() + ":  [" + str2 + "]");
            for (StackTraceElement stackTraceElement : exception.getStackTrace()) {
                Log.w(str, "        at\t " + stackTraceElement.toString());
            }
        }
    }
}
