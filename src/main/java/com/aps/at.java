package com.aps;

public final class at extends Thread {
    /* renamed from: a */
    private /* synthetic */ C0588y f3377a;

    public final void run() {
        while (this.f3377a.f3607k) {
            try {
                C0588y.m4603a(this.f3377a, this.f3377a.f3595D, 1, System.currentTimeMillis());
                try {
                    Thread.sleep((long) this.f3377a.f3612p);
                } catch (Exception e) {
                }
            } catch (Exception e2) {
                return;
            }
        }
    }
}
