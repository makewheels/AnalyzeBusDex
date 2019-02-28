package com.aps;

import android.location.GpsStatus.NmeaListener;

final class al implements NmeaListener {
    /* renamed from: a */
    private /* synthetic */ ai f3363a;

    private al(ai aiVar) {
        this.f3363a = aiVar;
    }

    public final void onNmeaReceived(long j, String str) {
        try {
            this.f3363a.f3346k = j;
            this.f3363a.f3347l = str;
        } catch (Exception e) {
        }
    }
}
