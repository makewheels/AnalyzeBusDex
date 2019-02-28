package com.umeng.analytics;

/* compiled from: SafeRunnable */
/* renamed from: com.umeng.analytics.e */
public abstract class C1235e implements Runnable {
    /* renamed from: a */
    public abstract void mo1916a();

    public void run() {
        try {
            mo1916a();
        } catch (Throwable th) {
            if (th != null) {
                th.printStackTrace();
            }
        }
    }
}
