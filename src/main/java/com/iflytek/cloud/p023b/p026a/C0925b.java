package com.iflytek.cloud.p023b.p026a;

import android.content.Context;
import android.os.SystemClock;
import com.alipay.sdk.cons.C0108a;
import com.iflytek.cloud.p022a.C0916d;
import com.iflytek.cloud.p023b.p024e.C0949h;
import com.iflytek.cloud.p023b.p024e.p029a.C0939a;
import com.iflytek.cloud.p023b.p024e.p029a.C0941c;
import com.iflytek.cloud.p023b.p025b.C0923a;
import com.iflytek.cloud.p023b.p025b.C0923a.C0927a;
import com.iflytek.cloud.p030c.C0950a;
import com.iflytek.cloud.p030c.C0952c;
import com.iflytek.cloud.record.C0959d;
import com.iflytek.cloud.record.C0959d.C0924a;
import com.iflytek.cloud.speech.ErrorCode;
import com.iflytek.cloud.speech.RecognizerListener;
import com.iflytek.cloud.speech.RecognizerResult;
import com.iflytek.cloud.speech.SpeechConstant;
import com.iflytek.cloud.speech.SpeechError;
import com.iflytek.cloud.speech.SpeechEvent;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;
import p054u.aly.bi_常量类;

/* renamed from: com.iflytek.cloud.b.a.b */
public class C0925b extends C0923a implements C0924a {
    /* renamed from: k */
    public static int f4405k = 0;
    /* renamed from: l */
    public static int f4406l = 0;
    /* renamed from: B */
    private long f4407B;
    /* renamed from: C */
    private long f4408C;
    /* renamed from: a */
    protected volatile RecognizerListener f4409a;
    /* renamed from: b */
    protected long f4410b;
    /* renamed from: c */
    protected boolean f4411c;
    /* renamed from: d */
    protected boolean f4412d;
    /* renamed from: e */
    protected boolean f4413e;
    /* renamed from: f */
    protected boolean f4414f;
    /* renamed from: g */
    protected int f4415g;
    /* renamed from: h */
    protected boolean f4416h;
    /* renamed from: i */
    protected C0921a f4417i;
    /* renamed from: j */
    protected C0959d f4418j;
    /* renamed from: m */
    protected String f4419m;
    /* renamed from: n */
    protected ConcurrentLinkedQueue<byte[]> f4420n;
    /* renamed from: o */
    protected ConcurrentLinkedQueue<byte[]> f4421o;
    /* renamed from: p */
    protected ArrayList<String> f4422p;

    public C0925b(Context context, C0950a c0950a) {
        super(context);
        this.f4409a = null;
        this.f4410b = 0;
        this.f4411c = false;
        this.f4412d = false;
        this.f4413e = false;
        this.f4414f = false;
        this.f4415g = 1;
        this.f4407B = 0;
        this.f4416h = true;
        this.f4417i = new C0921a();
        this.f4418j = null;
        this.f4419m = null;
        this.f4420n = null;
        this.f4421o = null;
        this.f4422p = null;
        this.f4408C = 0;
        this.f4420n = new ConcurrentLinkedQueue();
        this.f4421o = new ConcurrentLinkedQueue();
        this.f4422p = new ArrayList();
        this.f4414f = false;
        m7033a(c0950a);
    }

    /* renamed from: A */
    private void m7057A() throws SpeechError, UnsupportedEncodingException {
        switch (this.f4417i.m7028f()) {
            case hasResult:
                if (!this.f4413e) {
                    this.f4413e = true;
                    m7034a("app_frs");
                }
                m7059d(false);
                return;
            case resultOver:
                if (!this.f4413e) {
                    this.f4413e = true;
                    m7034a("app_frs");
                }
                m7034a("app_lrs");
                m7059d(true);
                return;
            default:
                return;
        }
    }

    /* renamed from: B */
    private void m7058B() {
        if (this.f4418j != null) {
            this.f4418j.m7243a();
            this.f4418j = null;
            m7034a("rec_close");
        }
    }

    /* renamed from: d */
    private void m7059d(boolean z) throws SpeechError, UnsupportedEncodingException {
        String str;
        C0941c.m7127a("QISRGetResult", null);
        this.v = SystemClock.elapsedRealtime();
        if (this.f4417i.m7027e() != null && this.f4417i.m7027e().length > 0) {
            str = new String(this.f4417i.m7027e(), "utf-8");
        } else if (this.f4422p.size() <= 0) {
            throw new SpeechError((int) ErrorCode.MSP_ERROR_NO_DATA);
        } else {
            str = bi_常量类.f6358b_空串;
        }
        this.f4422p.add(str);
        C0939a.m7120a("msc result time:" + System.currentTimeMillis());
        if (this.f4409a != null && m7047u()) {
            this.f4409a.onResult(new RecognizerResult(str), z);
        }
        if (z) {
            m7046t();
        }
    }

    /* renamed from: a */
    public int mo1566a() {
        return this.f4415g;
    }

    /* renamed from: a */
    public synchronized void m7061a(RecognizerListener recognizerListener) {
        this.f4409a = recognizerListener;
        C0939a.m7120a("startListening called");
        m7050x();
    }

    /* renamed from: a */
    public void mo1567a(SpeechError speechError) {
        this.x = speechError;
        m7046t();
    }

    /* renamed from: a */
    public void m7063a(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            this.f4420n.add(bArr);
        }
    }

    /* renamed from: a */
    public void m7064a(byte[] bArr, int i) {
        if (m7047u()) {
            this.f4409a.onVolumeChanged(i);
        }
    }

    /* renamed from: a */
    public void mo1568a(byte[] bArr, int i, int i2) {
        if (i2 > 0 && m7047u()) {
            if (!this.f4411c) {
                this.f4411c = true;
                m7034a("rec_start");
            }
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, i, bArr2, 0, i2);
            m7063a(bArr2);
        }
    }

    /* renamed from: a */
    protected void m7066a(byte[] bArr, boolean z) throws SpeechError {
        C0941c.m7127a("QISRAudioWrite", bi_常量类.f6358b_空串 + bArr.length);
        this.f4417i.m7020a(bArr, bArr.length);
        if (!z) {
            return;
        }
        if (this.f4417i.m7022b() == 3) {
            m7075g();
            return;
        }
        int c = this.f4417i.m7024c();
        C0939a.m7120a("QISRAudioWrite volume:" + c);
        m7064a(bArr, c);
    }

    /* renamed from: a */
    public synchronized boolean mo1576a(boolean z) {
        boolean z2;
        if (m7048v() != C0927a.recording) {
            C0939a.m7120a("stopRecognize fail  status is :" + m7048v());
            z2 = false;
        } else {
            m7034a("app_stop");
            m7058B();
            this.f4414f = z;
            m7032a(C0927a.stoprecord);
            z2 = true;
        }
        return z2;
    }

    /* renamed from: b */
    public ConcurrentLinkedQueue<byte[]> m7068b() {
        while (true) {
            byte[] bArr = (byte[]) this.f4420n.poll();
            if (bArr == null) {
                return this.f4421o;
            }
            this.f4421o.add(bArr);
        }
    }

    /* renamed from: b */
    public boolean m7069b(boolean z) throws SpeechError, InterruptedException {
        if (this.f4420n.size() == 0) {
            return false;
        }
        byte[] bArr = (byte[]) this.f4420n.poll();
        this.f4421o.add(bArr);
        if (!this.f4412d) {
            this.f4412d = true;
            m7034a("app_fau");
        }
        m7066a(bArr, z);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f4407B < 10 && this.f4420n.size() > 0) {
            Thread.sleep(10);
        }
        this.f4407B = currentTimeMillis;
        return true;
    }

    /* renamed from: c */
    public void mo1569c() {
        m7058B();
        if (m7048v() == C0927a.recording) {
            this.f4414f = true;
        }
        super.mo1569c();
    }

    /* renamed from: c */
    public void mo1570c(boolean z) {
        m7034a("rec_ready");
    }

    /* renamed from: d */
    public void m7072d() {
        if (this.f4408C == 0) {
            this.f4408C = SystemClock.elapsedRealtime();
        } else if (SystemClock.elapsedRealtime() - this.f4408C >= 100) {
            this.f4408C = SystemClock.elapsedRealtime();
            int b = this.f4417i.m7023b("netperf");
            if (this.f4409a != null) {
                this.f4409a.onEvent(SpeechEvent.EVENT_NETPREF, b, 0, null);
            }
        }
    }

    /* renamed from: e */
    protected void mo1571e() throws Exception {
        if (m7048v() == C0927a.init) {
            m7076h();
        } else if (m7048v() == C0927a.start) {
            mo1577k();
        } else if (m7048v() == C0927a.recording) {
            m7080l();
            m7072d();
        } else if (m7048v() == C0927a.stoprecord) {
            m7081m();
            m7072d();
        } else if (m7048v() == C0927a.waitresult) {
            m7082n();
            m7072d();
        }
        super.mo1571e();
    }

    /* renamed from: f */
    protected void mo1572f() {
        C0939a.m7120a("onSessionEnd");
        m7058B();
        f4405k = this.f4417i.m7023b("upflow");
        f4406l = this.f4417i.m7023b("downflow");
        this.s = this.f4417i.m7025c("sid");
        if (this.f4422p.size() <= 0 && this.x == null && m7049w().m7173a("asr_nme", true)) {
            this.x = new SpeechError((int) ErrorCode.MSP_ERROR_NO_DATA);
        }
        C0941c.m7127a("QISRSessionEnd", null);
        m7036a("rec_ustop", this.f4414f ? C0108a.f262e : "0", false);
        this.f4417i.m7021a("sessinfo", m7052z());
        if (this.u) {
            this.f4417i.m7019a("user abort");
        } else if (this.x != null) {
            this.f4417i.m7019a("error" + this.x.getErrorCode());
        } else {
            this.f4417i.m7019a("success");
        }
        super.mo1572f();
        if (this.f4409a != null) {
            if (this.u) {
                C0939a.m7120a("RecognizerListener#onCancel");
            } else {
                C0939a.m7120a("RecognizerListener#onEnd");
                if (this.x != null) {
                    this.f4409a.onError(this.x);
                }
            }
        }
        C0916d.m6991a().m6997a(this.t);
    }

    /* renamed from: g */
    public void m7075g() {
        if (C0927a.recording == m7048v()) {
            mo1576a(false);
            if (this.f4409a != null) {
                this.f4409a.onEndOfSpeech();
            }
        }
    }

    /* renamed from: h */
    void m7076h() throws SpeechError, IOException {
        C0939a.m7120a("start connecting");
        if (!C0952c.m7187a(m7049w())) {
            C0949h.m7164a(this.t);
        }
        m7032a(C0927a.start);
    }

    /* renamed from: i */
    protected void mo1573i() {
        this.f4419m = m7049w().m7179d(SpeechConstant.CLOUD_GRAMMAR);
        this.f4415g = m7049w().m7166a(SpeechConstant.AUDIO_SOURCE, 1);
        this.f4416h = C0952c.m7188a(m7049w().m7179d(SpeechConstant.DOMAIN));
        if (this.f4416h) {
            this.q = 30000;
        } else {
            this.q = BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT;
        }
        this.q = m7049w().m7166a(SpeechConstant.KEY_SPEECH_TIMEOUT, this.q);
        C0939a.m7120a("mSpeechTimeOut=" + this.q);
        super.mo1573i();
    }

    /* renamed from: j */
    public boolean mo1574j() {
        return this.f4416h;
    }

    /* renamed from: k */
    void mo1577k() throws SpeechError, IOException, InterruptedException {
        C0939a.m7120a("start  record");
        this.f4418j = new C0959d(m7045s(), m7049w().m7166a("record_read_rate", 40), this.f4415g);
        if (m7047u()) {
            m7034a("rec_open");
            this.f4418j.m7244a(this);
        }
        this.f4410b = SystemClock.elapsedRealtime();
        C0941c.m7127a("QISRSessionBegin", null);
        m7034a("app_ssb");
        int a = this.f4417i.m7017a(this.t, this.f4419m, (C0923a) this);
        while (a != 0 && m7048v() == C0927a.start) {
            if (SystemClock.elapsedRealtime() - this.f4410b < 800) {
                Thread.sleep(10);
                a = this.f4417i.m7017a(this.t, this.f4419m, (C0923a) this);
            } else {
                throw new SpeechError(a);
            }
        }
        m7032a(C0927a.recording);
        if (m7047u() && this.f4409a != null) {
            this.f4409a.onBeginOfSpeech();
        }
    }

    /* renamed from: l */
    void m7080l() throws SpeechError, IOException, InterruptedException {
        if (!m7069b(true)) {
            Thread.sleep(40);
        } else if (this.f4417i.m7026d()) {
            m7057A();
        }
        if (SystemClock.elapsedRealtime() - this.f4410b > ((long) this.q)) {
            m7075g();
        }
    }

    /* renamed from: m */
    void m7081m() throws SpeechError, IOException, InterruptedException {
        m7058B();
        if (!m7069b(true)) {
            m7034a("app_lau");
            this.f4417i.m7018a();
            m7032a(C0927a.waitresult);
        }
    }

    /* renamed from: n */
    void m7082n() throws SpeechError, InterruptedException, UnsupportedEncodingException {
        m7058B();
        m7057A();
        if (m7048v() == C0927a.waitresult) {
            Thread.sleep(40);
        }
        C0923a.m7031a(this.v, this.w);
    }

    /* renamed from: o */
    public void mo1575o() {
    }
}
