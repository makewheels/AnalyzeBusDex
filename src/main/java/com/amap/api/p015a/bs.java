package com.amap.api.p015a;

/* compiled from: ThreadPool */
/* renamed from: com.amap.api.a.bs */
class bs {
    /* renamed from: a */
    private Thread[] f923a;

    public bs(int i, Runnable runnable, Runnable runnable2) {
        this.f923a = new Thread[i];
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 != 0 || i <= 1) {
                this.f923a[i2] = new Thread(runnable2);
            } else {
                this.f923a[i2] = new Thread(runnable);
            }
        }
    }

    /* renamed from: a */
    public void m1508a() {
        for (Thread thread : this.f923a) {
            thread.setDaemon(true);
            thread.start();
        }
    }

    /* renamed from: b */
    public void m1509b() {
        if (this.f923a != null) {
            int length = this.f923a.length;
            for (int i = 0; i < length; i++) {
                this.f923a[i].interrupt();
                this.f923a[i] = null;
            }
            this.f923a = null;
        }
    }
}
