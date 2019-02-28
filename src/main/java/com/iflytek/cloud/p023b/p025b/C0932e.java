package com.iflytek.cloud.p023b.p025b;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.iflytek.cloud.p023b.p024e.p029a.C0939a;
import com.iflytek.cloud.p023b.p025b.C0931d.C0930a;
import com.iflytek.cloud.speech.SpeechError;

/* renamed from: com.iflytek.cloud.b.b.e */
final class C0932e extends Handler {
    /* renamed from: a */
    final /* synthetic */ C0930a f4445a;

    C0932e(C0930a c0930a, Looper looper) {
        this.f4445a = c0930a;
        super(looper);
    }

    public void handleMessage(Message message) {
        if (this.f4445a.f4439b != null) {
            C0939a.m7120a("SpeechListener onMsg = " + message.what);
            switch (message.what) {
                case 0:
                    this.f4445a.f4439b.onEvent(message.arg1, (Bundle) message.obj);
                    break;
                case 1:
                    this.f4445a.f4439b.onData((byte[]) message.obj);
                    break;
                case 2:
                    this.f4445a.f4439b.onCompleted((SpeechError) message.obj);
                    break;
            }
            super.handleMessage(message);
        }
    }
}
