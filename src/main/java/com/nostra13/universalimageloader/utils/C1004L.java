package com.nostra13.universalimageloader.utils;

import android.util.Log;
import com.nostra13.universalimageloader.core.ImageLoader;

/* renamed from: com.nostra13.universalimageloader.utils.L */
public final class C1004L {
    private static final String LOG_FORMAT = "%1$s\n%2$s";
    private static volatile boolean writeDebugLogs = false;
    private static volatile boolean writeLogs = true;

    private C1004L() {
    }

    @Deprecated
    public static void enableLogging() {
        C1004L.writeLogs(true);
    }

    @Deprecated
    public static void disableLogging() {
        C1004L.writeLogs(false);
    }

    public static void writeDebugLogs(boolean writeDebugLogs) {
        writeDebugLogs = writeDebugLogs;
    }

    public static void writeLogs(boolean writeLogs) {
        writeLogs = writeLogs;
    }

    /* renamed from: d */
    public static void m7342d(String message, Object... args) {
        if (writeDebugLogs) {
            C1004L.log(3, null, message, args);
        }
    }

    /* renamed from: i */
    public static void m7346i(String message, Object... args) {
        C1004L.log(4, null, message, args);
    }

    /* renamed from: w */
    public static void m7347w(String message, Object... args) {
        C1004L.log(5, null, message, args);
    }

    /* renamed from: e */
    public static void m7344e(Throwable ex) {
        C1004L.log(6, ex, null, new Object[0]);
    }

    /* renamed from: e */
    public static void m7343e(String message, Object... args) {
        C1004L.log(6, null, message, args);
    }

    /* renamed from: e */
    public static void m7345e(Throwable ex, String message, Object... args) {
        C1004L.log(6, ex, message, args);
    }

    private static void log(int priority, Throwable ex, String message, Object... args) {
        if (writeLogs) {
            String log;
            if (args.length > 0) {
                message = String.format(message, args);
            }
            if (ex == null) {
                log = message;
            } else {
                String logMessage;
                if (message == null) {
                    logMessage = ex.getMessage();
                } else {
                    logMessage = message;
                }
                String logBody = Log.getStackTraceString(ex);
                log = String.format(LOG_FORMAT, new Object[]{logMessage, logBody});
            }
            Log.println(priority, ImageLoader.TAG, log);
        }
    }
}
