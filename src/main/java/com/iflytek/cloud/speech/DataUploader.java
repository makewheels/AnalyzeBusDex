package com.iflytek.cloud.speech;

import android.content.Context;
import com.iflytek.cloud.p023b.p025b.C0931d;
import com.iflytek.cloud.p023b.p025b.C0931d.C0930a;
import com.iflytek.cloud.p023b.p027c.C0935b;

public class DataUploader extends C0931d {
    public DataUploader(Context context) {
        super(context);
    }

    /* renamed from: d */
    protected boolean mo1579d() {
        return true;
    }

    public void uploadData(SpeechListener speechListener, String str, byte[] bArr) {
        this.d = new C0935b(this.a, this.c);
        ((C0935b) this.d).m7100a(new C0930a(this, speechListener), str, bArr);
    }
}
