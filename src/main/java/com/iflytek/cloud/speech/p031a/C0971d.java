package com.iflytek.cloud.speech.p031a;

import android.os.Bundle;
import android.os.Message;
import com.iflytek.cloud.p023b.p028d.C0937b;
import com.iflytek.cloud.speech.ErrorCode;
import com.iflytek.cloud.speech.SpeechError;
import com.iflytek.cloud.speech.p031a.C0970c.C0969a;
import java.io.IOException;
import java.util.ArrayList;

/* renamed from: com.iflytek.cloud.speech.a.d */
final class C0971d implements C0937b {
    /* renamed from: a */
    final /* synthetic */ C0969a f4602a;

    C0971d(C0969a c0969a) {
        this.f4602a = c0969a;
    }

    /* renamed from: a */
    public void mo1605a(SpeechError speechError) {
        if (this.f4602a.f4592h != null && speechError != null) {
            Message.obtain(this.f4602a.f4598n, 6, speechError).sendToTarget();
            this.f4602a.f4590f.m7225e();
        }
    }

    /* renamed from: a */
    public void mo1606a(ArrayList<byte[]> arrayList, int i, int i2, int i3, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("percent", i);
        bundle.putInt("begpos", i2);
        bundle.putInt("endpos", i3);
        bundle.putString("spellinfo", str);
        if (this.f4602a.f4592h != null) {
            Message.obtain(this.f4602a.f4598n, 2, bundle).sendToTarget();
        }
        try {
            this.f4602a.f4591g.m7231a(arrayList, i, i2, i3);
            if (i >= 100) {
                this.f4602a.f4591g.m7234b();
            }
            if (!this.f4602a.f4595k && this.f4602a.f4591g.m7232a(this.f4602a.f4594j)) {
                this.f4602a.f4595k = true;
                this.f4602a.f4590f.m7220a(this.f4602a.f4591g, this.f4602a.f4597m);
                if (this.f4602a.f4592h != null) {
                    Message.obtain(this.f4602a.f4598n, 1).sendToTarget();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            Message.obtain(this.f4602a.f4598n, 6, new SpeechError((int) ErrorCode.ERROR_FILE_ACCESS)).sendToTarget();
            this.f4602a.cancel();
        }
    }
}
