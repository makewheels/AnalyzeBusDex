package com.tencent.smtt.sdk;

import android.database.sqlite.SQLiteException;
import java.lang.Thread.UncaughtExceptionHandler;

/* renamed from: com.tencent.smtt.sdk.j */
public class C1111j implements UncaughtExceptionHandler {
    public void uncaughtException(Thread thread, Throwable th) {
        if (!(th instanceof SQLiteException)) {
            throw new RuntimeException(th);
        }
    }
}
