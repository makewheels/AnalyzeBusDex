package com.iflytek.cloud.record;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.iflytek.cloud.speech.SpeechError;

/* renamed from: com.iflytek.cloud.record.c */
final class C0958c extends Handler {
    /* renamed from: a */
    final /* synthetic */ PcmPlayer f4541a;

    C0958c(PcmPlayer pcmPlayer, Looper looper) {
        this.f4541a = pcmPlayer;
        super(looper);
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                if (this.f4541a.f4514f != null) {
                    this.f4541a.f4514f.mo1609a((SpeechError) message.obj);
                    this.f4541a.f4514f = null;
                    return;
                }
                return;
            case 1:
                if (this.f4541a.f4514f != null) {
                    this.f4541a.f4514f.mo1607a();
                    return;
                }
                return;
            case 2:
                if (this.f4541a.f4514f != null) {
                    this.f4541a.f4514f.mo1610b();
                    return;
                }
                return;
            case 3:
                if (this.f4541a.f4514f != null) {
                    this.f4541a.f4514f.mo1608a(message.arg1, message.arg2, this.f4541a.f4522n);
                    return;
                }
                return;
            case 4:
                if (this.f4541a.f4514f != null) {
                    this.f4541a.f4514f.mo1611c();
                    this.f4541a.f4514f = null;
                    return;
                }
                return;
            default:
                return;
        }
    }
}
