package com.aps;

import android.os.Handler;
import android.os.Message;

final class ar extends Handler {
    /* renamed from: a */
    private /* synthetic */ aq f3368a;

    ar(aq aqVar) {
        this.f3368a = aqVar;
    }

    public final void handleMessage(Message message) {
        try {
            switch (message.what) {
                case 1:
                    if (this.f3368a.f3367a.f3596E != null) {
                        this.f3368a.f3367a.f3596E.m4389a((String) message.obj);
                        return;
                    }
                    return;
                default:
                    return;
            }
        } catch (Exception e) {
        }
    }
}
