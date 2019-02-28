package com.amap.api.mapcore.util;

/* compiled from: ThreadTask */
public abstract class ay implements Runnable {
    /* renamed from: a */
    C0357a f1994a;

    /* compiled from: ThreadTask */
    /* renamed from: com.amap.api.mapcore.util.ay$a */
    interface C0357a {
        /* renamed from: a */
        void mo593a(ay ayVar);

        /* renamed from: b */
        void mo594b(ay ayVar);
    }

    /* renamed from: a */
    public abstract void mo606a();

    public final void run() {
        try {
            if (this.f1994a != null) {
                this.f1994a.mo593a(this);
            }
            if (!Thread.interrupted()) {
                mo606a();
                if (!Thread.interrupted() && this.f1994a != null) {
                    this.f1994a.mo594b(this);
                }
            }
        } catch (Throwable th) {
            az.m3143a(th, "ThreadTask", "run");
            th.printStackTrace();
        }
    }
}
