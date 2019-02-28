package com.autonavi.tbt;

import android.content.Context;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: Log */
public class ai {
    /* renamed from: a */
    static final String f3706a = "/a/";
    /* renamed from: b */
    static final String f3707b = "b";
    /* renamed from: c */
    static final String f3708c = "c";
    /* renamed from: d */
    static final String f3709d = "d";

    /* renamed from: a */
    static void m4708a(Context context, Throwable th, int i, String str, String str2) {
        try {
            ExecutorService a = ae.m4669a();
            if (a != null && !a.isShutdown()) {
                final int i2 = i;
                final Context context2 = context;
                final Throwable th2 = th;
                final String str3 = str;
                final String str4 = str2;
                a.submit(new Runnable() {
                    public void run() {
                        try {
                            aj a = aj.m4676a(i2);
                            if (a != null) {
                                a.m4690a(context2, th2, str3, str4);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }
        } catch (RejectedExecutionException e) {
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }
}
