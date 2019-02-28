package com.iflytek.cloud.speech.p031a;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.iflytek.cloud.speech.SpeechError;
import com.iflytek.cloud.speech.p031a.C0970c.C0969a;

/* renamed from: com.iflytek.cloud.speech.a.f */
final class C0973f extends Handler {
    /* renamed from: a */
    final /* synthetic */ C0969a f4604a;

    C0973f(C0969a c0969a, Looper looper) {
        this.f4604a = c0969a;
        super(looper);
    }

    public void handleMessage(Message message) {
        if (this.f4604a.f4592h != null) {
            switch (message.what) {
                case 1:
                    this.f4604a.f4592h.onSpeakBegin();
                    return;
                case 2:
                    Bundle bundle = (Bundle) message.obj;
                    int i = bundle.getInt("percent");
                    int i2 = bundle.getInt("begpos");
                    int i3 = bundle.getInt("endpos");
                    String string = bundle.getString("spellinfo");
                    if (this.f4604a.f4592h != null) {
                        this.f4604a.f4592h.onBufferProgress(i, i2, i3, string);
                        return;
                    }
                    return;
                case 3:
                    this.f4604a.f4592h.onSpeakPaused();
                    return;
                case 4:
                    this.f4604a.f4592h.onSpeakResumed();
                    return;
                case 5:
                    int intValue = ((Integer) message.obj).intValue();
                    if (this.f4604a.f4592h != null) {
                        this.f4604a.f4592h.onSpeakProgress(message.arg1, message.arg2, intValue);
                        return;
                    }
                    return;
                case 6:
                    this.f4604a.f4592h.onCompleted((SpeechError) message.obj);
                    return;
                default:
                    return;
            }
        }
    }
}
