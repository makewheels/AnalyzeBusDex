package com.aps;

import android.os.Looper;
import java.util.List;

final class aq extends Thread {
    /* renamed from: a */
    final /* synthetic */ C0588y f3367a;

    aq(C0588y c0588y, String str) {
        this.f3367a = c0588y;
        super(str);
    }

    public final void run() {
        try {
            Looper.prepare();
            this.f3367a.f3593B = Looper.myLooper();
            this.f3367a.f3596E = new as(this.f3367a);
            try {
                this.f3367a.f3615s.addGpsStatusListener(this.f3367a.f3596E);
                this.f3367a.f3615s.addNmeaListener(this.f3367a.f3596E);
            } catch (Exception e) {
            }
            this.f3367a.f3597F = new ar(this);
            List allProviders = this.f3367a.f3615s.getAllProviders();
            if (allProviders != null && allProviders.contains("gps")) {
                allProviders.contains("passive");
            }
            try {
                this.f3367a.f3615s.requestLocationUpdates("passive", 1000, (float) C0588y.f3584c, this.f3367a.f3599H);
            } catch (Exception e2) {
            }
            Looper.loop();
        } catch (Exception e3) {
        }
    }
}
