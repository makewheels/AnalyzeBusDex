package com.iflytek.cloud.p023b.p025b;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.iflytek.cloud.p022a.C0913a;
import com.iflytek.cloud.p023b.p024e.p029a.C0939a;
import com.iflytek.cloud.p023b.p025b.C0923a.C0927a;
import com.iflytek.cloud.p030c.C0950a;
import com.iflytek.cloud.speech.ErrorCode;
import com.iflytek.cloud.speech.SpeechConstant;
import com.iflytek.cloud.speech.SpeechError;
import com.iflytek.cloud.speech.SpeechListener;

/* renamed from: com.iflytek.cloud.b.b.d */
public abstract class C0931d {
    /* renamed from: a */
    protected Context f4441a = null;
    /* renamed from: b */
    protected Object f4442b = new Object();
    /* renamed from: c */
    protected C0950a f4443c = new C0950a();
    /* renamed from: d */
    protected volatile C0923a f4444d = null;

    /* renamed from: com.iflytek.cloud.b.b.d$a */
    protected class C0930a implements SpeechListener {
        /* renamed from: a */
        final /* synthetic */ C0931d f4438a;
        /* renamed from: b */
        private SpeechListener f4439b = null;
        /* renamed from: c */
        private Handler f4440c = new C0932e(this, Looper.getMainLooper());

        public C0930a(C0931d c0931d, SpeechListener speechListener) {
            this.f4438a = c0931d;
            this.f4439b = speechListener;
        }

        public void onCompleted(SpeechError speechError) {
            this.f4440c.sendMessage(this.f4440c.obtainMessage(2, speechError));
        }

        public void onData(byte[] bArr) {
            this.f4440c.sendMessage(this.f4440c.obtainMessage(1, bArr));
        }

        public void onEvent(int i, Bundle bundle) {
            this.f4440c.sendMessage(this.f4440c.obtainMessage(0, i, 0, bundle));
        }
    }

    protected C0931d(Context context) {
        if (context != null) {
            C0913a.m6973a(context.getApplicationContext());
            this.f4441a = context.getApplicationContext();
            try {
                m7088a();
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        this.f4441a = null;
    }

    /* renamed from: a */
    protected void m7088a() throws Exception {
    }

    /* renamed from: b */
    protected String m7089b() {
        return getClass().toString();
    }

    /* renamed from: c */
    protected boolean m7090c() {
        return (this.f4444d == null || this.f4444d.m7048v() == C0927a.idle || this.f4444d.m7048v() == C0927a.exited) ? false : true;
    }

    public void cancel() {
        if (this.f4444d != null) {
            this.f4444d.mo1569c();
        }
    }

    /* renamed from: d */
    protected boolean mo1579d() {
        return true;
    }

    public boolean destroy() {
        boolean z;
        synchronized (this.f4442b) {
            if (m7090c()) {
                this.f4444d.mo1569c();
                z = false;
            } else {
                z = mo1579d();
                C0939a.m7122b(m7089b() + "destory =" + z);
            }
        }
        return z;
    }

    protected void finalize() throws Throwable {
        C0939a.m7120a(m7089b() + " finalize called");
        super.finalize();
    }

    public String getParameter(String str) {
        return this.f4443c.m7179d(str);
    }

    public int getSampleRate() {
        return this.f4443c.m7166a(SpeechConstant.SAMPLE_RATE, (int) ErrorCode.MSP_ERROR_LMOD_BASE);
    }

    public boolean setParameter(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.equals("params")) {
            if (TextUtils.isEmpty(str2)) {
                this.f4443c.m7167a();
                return true;
            }
            this.f4443c.m7176b(str2);
            return true;
        } else if (TextUtils.isEmpty(str2)) {
            return this.f4443c.m7177c(str).booleanValue();
        } else {
            this.f4443c.m7170a(str, str2);
            return true;
        }
    }
}
