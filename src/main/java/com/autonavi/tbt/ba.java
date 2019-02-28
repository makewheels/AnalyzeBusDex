package com.autonavi.tbt;

/* compiled from: ThreadTask */
public abstract class ba implements Runnable {
    /* renamed from: m */
    C0611a f3662m;

    /* compiled from: ThreadTask */
    /* renamed from: com.autonavi.tbt.ba$a */
    interface C0611a {
        /* renamed from: a */
        void mo746a(ba baVar);

        /* renamed from: b */
        void mo747b(ba baVar);
    }

    /* renamed from: a */
    public abstract void mo737a();

    public final void run() {
        try {
            if (this.f3662m != null) {
                this.f3662m.mo746a(this);
            }
            if (!Thread.interrupted()) {
                mo737a();
                if (!Thread.interrupted() && this.f3662m != null) {
                    this.f3662m.mo747b(this);
                }
            }
        } catch (Throwable th) {
            ae.m4671a(th, "ThreadTask", "run");
            th.printStackTrace();
        }
    }
}
