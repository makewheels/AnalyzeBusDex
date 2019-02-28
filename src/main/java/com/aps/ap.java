package com.aps;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class ap extends BroadcastReceiver {
    ap(C0588y c0588y) {
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent != null) {
            try {
                if (intent.getAction().equals("android.location.GPS_FIX_CHANGE")) {
                    C0588y.f3583b = false;
                }
            } catch (Exception e) {
            }
        }
    }
}
