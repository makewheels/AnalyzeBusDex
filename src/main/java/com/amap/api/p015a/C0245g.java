package com.amap.api.p015a;

/* compiled from: AnimBase */
/* renamed from: com.amap.api.a.g */
class C0245g implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0237f f1033a;

    C0245g(C0237f c0237f) {
        this.f1033a = c0237f;
    }

    public void run() {
        this.f1033a.m1585e();
        if (this.f1033a.m1586f()) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f1033a.mo235a();
            this.f1033a.m1587g();
            long currentTimeMillis2 = System.currentTimeMillis();
            if (currentTimeMillis2 - currentTimeMillis < ((long) this.f1033a.f969d)) {
                try {
                    Thread.sleep(((long) this.f1033a.f969d) - (currentTimeMillis2 - currentTimeMillis));
                    return;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        this.f1033a.f970e.removeCallbacks(this);
        this.f1033a.f970e = null;
        this.f1033a.mo236b();
    }
}
