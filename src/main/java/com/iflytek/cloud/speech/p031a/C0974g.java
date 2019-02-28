package com.iflytek.cloud.speech.p031a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.iflytek.cloud.speech.SpeechError;
import com.iflytek.cloud.speech.p031a.C0970c.C0969a;

/* renamed from: com.iflytek.cloud.speech.a.g */
final class C0974g extends Handler {
    /* renamed from: a */
    final /* synthetic */ String f4605a;
    /* renamed from: b */
    final /* synthetic */ C0969a f4606b;

    C0974g(C0969a c0969a, Looper looper, String str) {
        this.f4606b = c0969a;
        this.f4605a = str;
        super(looper);
    }

    public void handleMessage(Message message) {
        if (this.f4606b.f4593i != null) {
            switch (message.what) {
                case 2:
                    this.f4606b.f4593i.onBufferProgress(message.arg1);
                    return;
                case 6:
                    this.f4606b.f4593i.onSynthesizeCompleted(this.f4605a, (SpeechError) message.obj);
                    return;
                default:
                    return;
            }
        }
    }
}
