package com.aps;

import java.util.TimerTask;

final class an extends TimerTask {
    /* renamed from: a */
    private /* synthetic */ am f3365a;

    an(am amVar) {
        this.f3365a = amVar;
    }

    public final void run() {
        try {
            if (this.f3365a.f3364a.f3339d != null) {
                this.f3365a.f3364a.f3339d.startScan();
            }
        } catch (Exception e) {
        }
    }
}
