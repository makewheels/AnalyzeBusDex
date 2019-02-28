package com.iflytek.cloud.p023b.p026a;

import android.content.Context;
import android.os.SystemClock;
import com.iflytek.cloud.p023b.p024e.p029a.C0939a;
import com.iflytek.cloud.p023b.p024e.p029a.C0941c;
import com.iflytek.cloud.p023b.p025b.C0923a;
import com.iflytek.cloud.p023b.p025b.C0923a.C0927a;
import com.iflytek.cloud.p030c.C0950a;
import com.iflytek.cloud.speech.SpeechError;
import java.io.IOException;

/* renamed from: com.iflytek.cloud.b.a.c */
public class C0926c extends C0925b {
    /* renamed from: B */
    private volatile boolean f4423B = false;

    public C0926c(Context context, C0950a c0950a) {
        super(context, c0950a);
    }

    /* renamed from: a */
    public void mo1568a(byte[] bArr, int i, int i2) {
        if (bArr != null && i2 > 0 && bArr.length >= i2) {
            super.mo1568a(bArr, i, i2);
        }
    }

    /* renamed from: a */
    public synchronized boolean mo1576a(boolean z) {
        boolean a;
        a = super.mo1576a(z);
        if (!a) {
            this.f4423B = true;
        }
        return a;
    }

    /* renamed from: k */
    void mo1577k() throws SpeechError, IOException, InterruptedException {
        C0939a.m7120a(m7051y() + "onStart");
        this.b = SystemClock.elapsedRealtime();
        C0941c.m7127a("QISRSessionBegin", null);
        m7034a("app_ssb");
        int a = this.i.m7017a(this.t, this.m, (C0923a) this);
        while (a != 0 && m7048v() == C0927a.start) {
            if (SystemClock.elapsedRealtime() - this.b < 800) {
                Thread.sleep(10);
                a = this.i.m7017a(this.t, this.m, (C0923a) this);
            } else {
                throw new SpeechError(a);
            }
        }
        if (this.f4423B) {
            m7032a(C0927a.stoprecord);
        } else {
            m7032a(C0927a.recording);
        }
    }
}
