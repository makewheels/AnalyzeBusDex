package com.iflytek.cloud.p023b.p027c;

import android.content.Context;
import android.text.TextUtils;
import com.iflytek.cloud.p023b.p024e.p029a.C0941c;
import com.iflytek.cloud.p023b.p025b.C0923a;
import com.iflytek.cloud.p023b.p025b.C0923a.C0927a;
import com.iflytek.cloud.p030c.C0950a;
import com.iflytek.cloud.speech.ErrorCode;
import com.iflytek.cloud.speech.SpeechError;
import com.iflytek.cloud.speech.SpeechListener;
import p054u.aly.bi_常量类;

/* renamed from: com.iflytek.cloud.b.c.b */
public class C0935b extends C0923a {
    /* renamed from: a */
    private String f4453a = bi_常量类.f6358b_空串;
    /* renamed from: b */
    private C0934a f4454b = C0934a.upload;
    /* renamed from: c */
    private byte[] f4455c = null;
    /* renamed from: d */
    private String f4456d = bi_常量类.f6358b_空串;
    /* renamed from: e */
    private String f4457e = bi_常量类.f6358b_空串;
    /* renamed from: f */
    private String f4458f = bi_常量类.f6358b_空串;
    /* renamed from: g */
    private C0933a f4459g = new C0933a();
    /* renamed from: h */
    private SpeechListener f4460h = null;

    /* renamed from: com.iflytek.cloud.b.c.b$a */
    enum C0934a {
        login,
        upload,
        download,
        search
    }

    public C0935b(Context context, C0950a c0950a) {
        super(context);
        m7033a(c0950a);
    }

    /* renamed from: a */
    public void m7097a(SpeechListener speechListener) {
        this.f4460h = speechListener;
        this.f4454b = C0934a.download;
        m7050x();
    }

    /* renamed from: a */
    public void m7098a(SpeechListener speechListener, String str) {
        this.f4460h = speechListener;
        this.f4454b = C0934a.search;
        this.f4453a = str;
        m7050x();
    }

    /* renamed from: a */
    public void m7099a(SpeechListener speechListener, String str, String str2) {
        this.f4457e = str;
        this.f4458f = str2;
        this.f4460h = speechListener;
        this.f4454b = C0934a.login;
        m7050x();
    }

    /* renamed from: a */
    public void m7100a(SpeechListener speechListener, String str, byte[] bArr) {
        this.f4460h = speechListener;
        this.f4456d = str;
        this.f4455c = bArr;
        this.f4454b = C0934a.upload;
        m7050x();
    }

    /* renamed from: e */
    protected void mo1571e() throws Exception {
        byte[] bArr = null;
        if (m7048v() == C0927a.init) {
            m7032a(C0927a.start);
        } else if (m7048v() == C0927a.start) {
            if (this.f4454b == C0934a.login) {
                C0941c.m7127a("QMSPLogin", null);
                C0933a.m7092a(this.t, this.f4457e, this.f4458f, (C0923a) this);
            } else if (this.f4454b == C0934a.upload) {
                if (this.f4455c == null || this.f4455c.length <= 0) {
                    throw new SpeechError((int) ErrorCode.ERROR_EMPTY_UTTERANCE);
                }
                C0941c.m7127a("QMSPUploadData", null);
                bArr = this.f4459g.m7096a(this.t, this.f4456d, this.f4455c, (C0923a) this);
            } else if (this.f4454b == C0934a.download) {
                C0941c.m7127a("QMSPDownloadData", null);
                bArr = this.f4459g.m7094a(this.t, this);
            } else if (this.f4454b == C0934a.search) {
                if (TextUtils.isEmpty(this.f4453a)) {
                    throw new SpeechError((int) ErrorCode.ERROR_EMPTY_UTTERANCE);
                }
                C0941c.m7127a("QMSPSearch", null);
                bArr = this.f4459g.m7095a(this.t, this, this.f4453a);
            }
            if (this.f4454b != C0934a.login) {
                if (bArr == null) {
                    throw new SpeechError((int) ErrorCode.ERROR_INVALID_RESULT);
                } else if (this.f4460h != null) {
                    this.f4460h.onData(bArr);
                }
            }
            m7046t();
        }
        super.mo1571e();
    }

    /* renamed from: f */
    protected void mo1572f() {
        super.mo1572f();
        if (this.f4460h != null && !this.u) {
            this.f4460h.onCompleted(this.x);
        }
    }
}
