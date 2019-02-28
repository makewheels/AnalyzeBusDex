package com.iflytek.cloud.speech.p031a;

import android.os.Handler;
import android.os.Message;
import com.iflytek.cloud.p023b.p028d.C0937b;
import com.iflytek.cloud.speech.ErrorCode;
import com.iflytek.cloud.speech.SpeechError;
import com.iflytek.cloud.speech.p031a.C0970c.C0969a;
import java.io.IOException;
import java.util.ArrayList;

/* renamed from: com.iflytek.cloud.speech.a.h */
final class C0975h implements C0937b {
    /* renamed from: a */
    final /* synthetic */ Handler f4607a;
    /* renamed from: b */
    final /* synthetic */ C0969a f4608b;

    C0975h(C0969a c0969a, Handler handler) {
        this.f4608b = c0969a;
        this.f4607a = handler;
    }

    /* renamed from: a */
    public void mo1605a(SpeechError speechError) {
        if (this.f4608b.f4593i != null) {
            Message.obtain(this.f4607a, 6, speechError).sendToTarget();
        }
    }

    /* renamed from: a */
    public void mo1606a(ArrayList<byte[]> arrayList, int i, int i2, int i3, String str) {
        try {
            this.f4608b.f4591g.m7231a(arrayList, i, i2, i3);
            if (i >= 100 && !this.f4608b.f4591g.m7234b()) {
                throw new IOException();
            } else if (this.f4608b.f4593i != null) {
                Message.obtain(this.f4607a, 2, i, 0).sendToTarget();
            }
        } catch (IOException e) {
            e.printStackTrace();
            this.f4608b.cancel();
            this.f4608b.f4591g.m7240h();
            if (this.f4608b.f4593i != null) {
                Message.obtain(this.f4607a, 6, new SpeechError((int) ErrorCode.ERROR_FILE_ACCESS)).sendToTarget();
            }
        }
    }
}
