package com.tencent.wxop.stat.common;

import android.util.Log;
import com.tencent.wxop.stat.C1203g;
import com.tencent.wxop.stat.StatConfig;
import p054u.aly.bi_常量类;

public final class StatLogger {
    /* renamed from: a */
    private String f5427a = "default";
    /* renamed from: b */
    private boolean f5428b = true;
    /* renamed from: c */
    private int f5429c = 2;

    public StatLogger(String str) {
        this.f5427a = str;
    }

    /* renamed from: a */
    private String m8239a() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null) {
            return null;
        }
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (!stackTraceElement.isNativeMethod() && !stackTraceElement.getClassName().equals(Thread.class.getName()) && !stackTraceElement.getClassName().equals(getClass().getName())) {
                return "[" + Thread.currentThread().getName() + "(" + Thread.currentThread().getId() + "): " + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + "]";
            }
        }
        return null;
    }

    /* renamed from: d */
    public final void m8240d(Object obj) {
        if (isDebugEnable()) {
            debug(obj);
        }
    }

    public final void debug(Object obj) {
        if (this.f5429c <= 3) {
            String a = m8239a();
            a = a == null ? obj.toString() : a + " - " + obj;
            Log.d(this.f5427a, a);
            C1203g customLogger = StatConfig.getCustomLogger();
            if (customLogger != null) {
                customLogger.m8349e(a);
            }
        }
    }

    /* renamed from: e */
    public final void m8241e(Object obj) {
        if (isDebugEnable()) {
            error(obj);
        }
    }

    /* renamed from: e */
    public final void m8242e(Throwable th) {
        if (isDebugEnable()) {
            error(th);
        }
    }

    public final void error(Object obj) {
        if (this.f5429c <= 6) {
            String a = m8239a();
            a = a == null ? obj.toString() : a + " - " + obj;
            Log.e(this.f5427a, a);
            C1203g customLogger = StatConfig.getCustomLogger();
            if (customLogger != null) {
                customLogger.m8348d(a);
            }
        }
    }

    public final void error(Throwable th) {
        if (this.f5429c <= 6) {
            Log.e(this.f5427a, bi_常量类.f6358b_空串, th);
            C1203g customLogger = StatConfig.getCustomLogger();
            if (customLogger != null) {
                customLogger.m8348d(th);
            }
        }
    }

    public final int getLogLevel() {
        return this.f5429c;
    }

    /* renamed from: i */
    public final void m8243i(Object obj) {
        if (isDebugEnable()) {
            info(obj);
        }
    }

    public final void info(Object obj) {
        if (this.f5429c <= 4) {
            String a = m8239a();
            a = a == null ? obj.toString() : a + " - " + obj;
            Log.i(this.f5427a, a);
            C1203g customLogger = StatConfig.getCustomLogger();
            if (customLogger != null) {
                customLogger.m8345a(a);
            }
        }
    }

    public final boolean isDebugEnable() {
        return this.f5428b;
    }

    public final void setDebugEnable(boolean z) {
        this.f5428b = z;
    }

    public final void setLogLevel(int i) {
        this.f5429c = i;
    }

    public final void setTag(String str) {
        this.f5427a = str;
    }

    /* renamed from: v */
    public final void m8244v(Object obj) {
        if (isDebugEnable()) {
            verbose(obj);
        }
    }

    public final void verbose(Object obj) {
        if (this.f5429c <= 2) {
            String a = m8239a();
            a = a == null ? obj.toString() : a + " - " + obj;
            Log.v(this.f5427a, a);
            C1203g customLogger = StatConfig.getCustomLogger();
            if (customLogger != null) {
                customLogger.m8346b(a);
            }
        }
    }

    /* renamed from: w */
    public final void m8245w(Object obj) {
        if (isDebugEnable()) {
            warn(obj);
        }
    }

    public final void warn(Object obj) {
        if (this.f5429c <= 5) {
            String a = m8239a();
            a = a == null ? obj.toString() : a + " - " + obj;
            Log.w(this.f5427a, a);
            C1203g customLogger = StatConfig.getCustomLogger();
            if (customLogger != null) {
                customLogger.m8347c(a);
            }
        }
    }
}
