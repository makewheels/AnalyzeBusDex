package com.autonavi.tbt;

import android.content.Context;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: SDKLogHandler */
public class ae implements UncaughtExceptionHandler {
    /* renamed from: a */
    private static ae f3683a;
    /* renamed from: d */
    private static ExecutorService f3684d;
    /* renamed from: b */
    private UncaughtExceptionHandler f3685b;
    /* renamed from: c */
    private Context f3686c;

    /* renamed from: a */
    static synchronized ExecutorService m4669a() {
        ExecutorService executorService;
        synchronized (ae.class) {
            try {
                if (f3684d == null || f3684d.isShutdown()) {
                    f3684d = Executors.newSingleThreadExecutor();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            executorService = f3684d;
        }
        return executorService;
    }

    /* renamed from: b */
    public static synchronized ae m4672b() {
        ae aeVar;
        synchronized (ae.class) {
            aeVar = f3683a;
        }
        return aeVar;
    }

    /* renamed from: a */
    public static void m4671a(Throwable th, String str, String str2) {
        if (f3683a != null) {
            f3683a.m4670a(th, 1, str, str2);
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        if (th != null) {
            m4670a(th, 0, null, null);
            if (this.f3685b != null) {
                this.f3685b.uncaughtException(thread, th);
            }
        }
    }

    /* renamed from: b */
    public void m4673b(Throwable th, String str, String str2) {
        if (th != null) {
            try {
                m4670a(th, 1, str, str2);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private void m4670a(Throwable th, int i, String str, String str2) {
        ai.m4708a(this.f3686c, th, i, str, str2);
    }
}
