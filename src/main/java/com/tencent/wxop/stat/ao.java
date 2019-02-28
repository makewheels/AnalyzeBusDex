package com.tencent.wxop.stat;

import com.tencent.wxop.stat.p053a.C1170d;
import java.lang.Thread.UncaughtExceptionHandler;

class ao implements UncaughtExceptionHandler {
    ao() {
    }

    public void uncaughtException(Thread thread, Throwable th) {
        if (StatConfig.isEnableStatService() && StatServiceImpl.f5278t != null) {
            if (StatConfig.isAutoExceptionCaught()) {
                au.m8199a(StatServiceImpl.f5278t).m8228a(new C1170d(StatServiceImpl.f5278t, StatServiceImpl.m8105a(StatServiceImpl.f5278t, false, null), 2, th, thread, null), null, false, true);
                StatServiceImpl.f5275q.debug("MTA has caught the following uncaught exception:");
                StatServiceImpl.f5275q.error(th);
            }
            StatServiceImpl.flushDataToDB(StatServiceImpl.f5278t);
            if (StatServiceImpl.f5276r != null) {
                StatServiceImpl.f5275q.m8240d("Call the original uncaught exception handler.");
                if (!(StatServiceImpl.f5276r instanceof ao)) {
                    StatServiceImpl.f5276r.uncaughtException(thread, th);
                }
            }
        }
    }
}
