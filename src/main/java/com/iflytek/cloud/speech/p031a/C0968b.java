package com.iflytek.cloud.speech.p031a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.iflytek.cloud.speech.RecognizerResult;
import com.iflytek.cloud.speech.SpeechError;
import com.iflytek.cloud.speech.p031a.C0967a.C0966a;

/* renamed from: com.iflytek.cloud.speech.a.b */
final class C0968b extends Handler {
    /* renamed from: a */
    final /* synthetic */ C0966a f4588a;

    C0968b(C0966a c0966a, Looper looper) {
        this.f4588a = c0966a;
        super(looper);
    }

    public void handleMessage(Message message) {
        if (this.f4588a.f4584b != null) {
            switch (message.what) {
                case 0:
                    this.f4588a.f4584b.onError((SpeechError) message.obj);
                    break;
                case 1:
                    this.f4588a.f4584b.onVolumeChanged(message.arg1);
                    break;
                case 2:
                    this.f4588a.f4584b.onBeginOfSpeech();
                    break;
                case 3:
                    this.f4588a.f4584b.onEndOfSpeech();
                    break;
                case 4:
                    this.f4588a.f4584b.onResult((RecognizerResult) message.obj, message.arg1 == 1);
                    if (!this.f4588a.f4585c) {
                        this.f4588a.f4583a.m7261a("ui_frs");
                        this.f4588a.f4585c = true;
                    }
                    if (1 == message.arg1) {
                        this.f4588a.f4583a.m7261a("ui_lrs");
                        break;
                    }
                    break;
                case 6:
                    Message message2 = (Message) message.obj;
                    this.f4588a.f4584b.onEvent(message2.what, message2.arg1, message2.arg2, (String) message2.obj);
                    break;
            }
            super.handleMessage(message);
        }
    }
}
