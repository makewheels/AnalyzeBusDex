package com.iflytek.cloud.speech.p031a;

import android.os.Message;
import com.iflytek.cloud.record.PcmPlayer.C0953a;
import com.iflytek.cloud.speech.SpeechError;
import com.iflytek.cloud.speech.p031a.C0970c.C0969a;

/* renamed from: com.iflytek.cloud.speech.a.e */
final class C0972e implements C0953a {
    /* renamed from: a */
    final /* synthetic */ C0969a f4603a;

    C0972e(C0969a c0969a) {
        this.f4603a = c0969a;
    }

    /* renamed from: a */
    public void mo1607a() {
        if (this.f4603a.f4592h != null) {
            Message.obtain(this.f4603a.f4598n, 3).sendToTarget();
        }
    }

    /* renamed from: a */
    public void mo1608a(int i, int i2, int i3) {
        Message.obtain(this.f4603a.f4598n, 5, i, i2, Integer.valueOf(i3)).sendToTarget();
    }

    /* renamed from: a */
    public void mo1609a(SpeechError speechError) {
        Message.obtain(this.f4603a.f4598n, 6, speechError).sendToTarget();
        if (this.f4603a.f4590f != null) {
            this.f4603a.f4590f.m7225e();
        }
        this.f4603a.cancel();
    }

    /* renamed from: b */
    public void mo1610b() {
        if (this.f4603a.f4592h != null) {
            Message.obtain(this.f4603a.f4598n, 4).sendToTarget();
        }
    }

    /* renamed from: c */
    public void mo1611c() {
        Message.obtain(this.f4603a.f4598n, 6, null).sendToTarget();
    }
}
