package com.iflytek.cloud.p023b.p028d;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.iflytek.cloud.p023b.p024e.C0949h;
import com.iflytek.cloud.p023b.p024e.p029a.C0939a;
import com.iflytek.cloud.p023b.p024e.p029a.C0941c;
import com.iflytek.cloud.p023b.p025b.C0923a;
import com.iflytek.cloud.p023b.p025b.C0923a.C0927a;
import com.iflytek.cloud.p030c.C0950a;
import com.iflytek.cloud.p030c.C0952c;
import com.iflytek.cloud.speech.ErrorCode;
import com.iflytek.cloud.speech.SpeechError;
import java.util.ArrayList;
import p054u.aly.bi_常量类;

/* renamed from: com.iflytek.cloud.b.d.a */
public class C0936a extends C0923a {
    /* renamed from: a */
    public static int f4461a = 0;
    /* renamed from: b */
    public static int f4462b = 0;
    /* renamed from: c */
    private String f4463c;
    /* renamed from: d */
    private C0938c f4464d;
    /* renamed from: e */
    private C0937b f4465e;
    /* renamed from: f */
    private ArrayList<byte[]> f4466f;
    /* renamed from: g */
    private int f4467g;
    /* renamed from: h */
    private int f4468h;
    /* renamed from: i */
    private long f4469i;
    /* renamed from: j */
    private StringBuilder f4470j;
    /* renamed from: k */
    private boolean f4471k;

    public C0936a(Context context, C0950a c0950a) {
        super(context);
        this.f4463c = bi_常量类.f6358b;
        this.f4464d = null;
        this.f4465e = null;
        this.f4466f = null;
        this.f4467g = 0;
        this.f4468h = 0;
        this.f4469i = 0;
        this.f4470j = null;
        this.f4471k = false;
        this.f4464d = new C0938c();
        this.f4466f = new ArrayList();
        this.f4470j = new StringBuilder();
        m7033a(c0950a);
    }

    /* renamed from: a */
    public void m7103a(String str, C0937b c0937b) {
        this.f4463c = str;
        this.f4465e = c0937b;
        if (str == null || TextUtils.isEmpty(str)) {
            this.x = new SpeechError((int) ErrorCode.ERROR_EMPTY_UTTERANCE);
            this.f4465e.mo1605a(this.x);
            return;
        }
        this.f4471k = m7049w().m7173a("tts_spell_info", false);
        m7050x();
    }

    /* renamed from: e */
    protected void mo1571e() throws Exception {
        if (m7048v() == C0927a.init) {
            if (!C0952c.m7187a(m7049w())) {
                C0949h.m7164a(this.t);
            }
            C0941c.m7127a("QTTSInit", null);
            this.f4469i = SystemClock.elapsedRealtime();
            m7032a(C0927a.start);
        } else if (m7048v() == C0927a.start) {
            C0941c.m7127a("QTTSSessionBegin", null);
            if (this.f4464d.m7111a(this.t, null, this) == 0) {
                C0941c.m7127a("QTTSTextPut", null);
                r0 = this.f4463c.getBytes("unicode");
                byte[] bArr = new byte[(r0.length - 2)];
                System.arraycopy(r0, 2, bArr, 0, r0.length - 2);
                this.f4464d.m7113a(bArr);
                m7032a(C0927a.waitresult);
            } else {
                Thread.sleep(50);
                C0923a.m7031a(this.f4469i, this.w);
            }
        } else if (m7048v() == C0927a.waitresult) {
            if (!this.f4464d.m7119d()) {
                Object a = this.f4464d.m7114a();
                if (!(a == null || this.f4465e == null)) {
                    C0941c.m7127a("QTTSAudioGet", bi_常量类.f6358b + a.length);
                    int b = (this.f4464d.m7115b() / 2) - 1;
                    if (this.f4471k) {
                        r0 = this.f4464d.m7117c();
                        if (!TextUtils.isEmpty(r0)) {
                            this.f4470j.append(r0);
                            this.f4470j.append("#\n");
                        }
                    }
                    if (!(this.f4467g == 0 || b == this.f4467g || this.f4466f.size() <= 0)) {
                        this.f4465e.mo1606a(this.f4466f, (this.f4467g * 100) / this.f4463c.length(), this.f4468h, this.f4467g, this.f4470j.toString());
                        this.f4470j.delete(0, this.f4470j.length());
                        this.f4466f = new ArrayList();
                        this.f4468h = this.f4467g;
                    }
                    this.f4469i = SystemClock.elapsedRealtime();
                    this.f4467g = b;
                    this.f4466f.add(a);
                }
                C0923a.m7031a(this.f4469i, this.w);
            } else if (this.f4465e != null) {
                this.f4465e.mo1606a(this.f4466f, 100, this.f4468h, this.f4463c.length() - 1, this.f4470j.toString());
                m7046t();
            }
        }
        super.mo1571e();
    }

    /* renamed from: f */
    protected void mo1572f() {
        f4461a = this.f4464d.m7116b("upflow");
        f4462b = this.f4464d.m7116b("downflow");
        this.s = this.f4464d.m7118c("sid");
        C0941c.m7127a("QTTSSessionEnd", null);
        if (this.f4465e == null) {
            this.f4464d.m7112a("user abort");
        } else if (this.x != null) {
            this.f4464d.m7112a("error" + this.x.getErrorCode());
            C0939a.m7120a("QTts Error Code = " + this.x.getErrorCode());
        } else {
            this.f4464d.m7112a("success");
        }
        super.mo1572f();
        if (this.f4465e == null) {
            return;
        }
        if (this.u) {
            C0939a.m7120a("SynthesizerPlayer#onCancel");
            return;
        }
        C0939a.m7120a("SynthesizerPlayer#onEnd");
        this.f4465e.mo1605a(this.x);
    }

    /* renamed from: q */
    public String mo1578q() {
        return "unicode";
    }
}
