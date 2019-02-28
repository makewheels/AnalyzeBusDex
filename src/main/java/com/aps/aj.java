package com.aps;

import android.os.Looper;
import java.util.Timer;

final class aj extends Thread {
    /* renamed from: a */
    private /* synthetic */ ai f3361a;

    aj(ai aiVar, String str) {
        this.f3361a = aiVar;
        super(str);
    }

    public final void run() {
        try {
            Looper.prepare();
            this.f3361a.f3335B = Looper.myLooper();
            this.f3361a.f3360z = new Timer();
            this.f3361a.f3355u = new ak(this.f3361a);
            ai.m4341a(this.f3361a, this.f3361a.f3355u);
            this.f3361a.f3356v = new al(this.f3361a);
            try {
                ai.m4340a(this.f3361a, this.f3361a.f3356v);
            } catch (Exception e) {
            }
            Looper.loop();
        } catch (Exception e2) {
        }
    }
}
