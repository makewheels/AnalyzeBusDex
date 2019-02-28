package com.aps;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

final class am extends BroadcastReceiver {
    /* renamed from: a */
    final /* synthetic */ ai f3364a;

    private am(ai aiVar) {
        this.f3364a = aiVar;
    }

    public final void onReceive(Context context, Intent intent) {
        if (context != null && intent != null) {
            try {
                if (this.f3364a.f3339d != null && this.f3364a.f3360z != null && this.f3364a.f3359y != null && intent.getAction() != null && "android.net.wifi.SCAN_RESULTS".equals(intent.getAction())) {
                    List scanResults = this.f3364a.f3339d.getScanResults();
                    synchronized (this) {
                        this.f3364a.f3359y.clear();
                        this.f3364a.f3353r = System.currentTimeMillis();
                        if (scanResults != null && scanResults.size() > 0) {
                            for (int i = 0; i < scanResults.size(); i++) {
                                this.f3364a.f3359y.add((ScanResult) scanResults.get(i));
                            }
                        }
                    }
                    TimerTask anVar = new an(this);
                    if (this.f3364a.f3360z != null) {
                        this.f3364a.f3360z.cancel();
                        this.f3364a.f3360z = null;
                    }
                    this.f3364a.f3360z = new Timer();
                    this.f3364a.f3360z.schedule(anVar, (long) ai.f3332C);
                }
            } catch (Exception e) {
            }
        }
    }
}
