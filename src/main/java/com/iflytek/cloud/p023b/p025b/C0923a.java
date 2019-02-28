package com.iflytek.cloud.p023b.p025b;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.iflytek.cloud.p023b.p024e.C0943b;
import com.iflytek.cloud.p023b.p024e.p029a.C0939a;
import com.iflytek.cloud.p030c.C0950a;
import com.iflytek.cloud.p030c.C0951b;
import com.iflytek.cloud.speech.ErrorCode;
import com.iflytek.cloud.speech.SpeechConstant;
import com.iflytek.cloud.speech.SpeechError;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.iflytek.cloud.b.b.a */
public abstract class C0923a {
    /* renamed from: A */
    long f4391A = 0;
    /* renamed from: a */
    private C0950a f4392a = new C0950a();
    /* renamed from: b */
    private volatile C0927a f4393b = C0927a.idle;
    /* renamed from: c */
    private Runnable f4394c = new C0928b(this);
    /* renamed from: q */
    protected int f4395q = 30000;
    /* renamed from: r */
    protected int f4396r = ErrorCode.MSP_ERROR_LMOD_BASE;
    /* renamed from: s */
    protected String f4397s = null;
    /* renamed from: t */
    protected Context f4398t = null;
    /* renamed from: u */
    protected volatile boolean f4399u = false;
    /* renamed from: v */
    protected long f4400v = 0;
    /* renamed from: w */
    protected int f4401w = BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT;
    /* renamed from: x */
    protected SpeechError f4402x = null;
    /* renamed from: y */
    JSONObject f4403y = new JSONObject();
    /* renamed from: z */
    long f4404z = 0;

    /* renamed from: com.iflytek.cloud.b.b.a$a */
    protected enum C0927a {
        idle,
        init,
        start,
        recording,
        stoprecord,
        waitresult,
        exiting,
        exited
    }

    public C0923a(Context context) {
        this.f4398t = context;
        this.f4399u = false;
    }

    /* renamed from: a */
    private void mo1566a() {
        this.f4391A = System.currentTimeMillis();
        this.f4404z = SystemClock.elapsedRealtime();
        m7036a("app_start", C0943b.m7133a(this.f4391A), false);
        String d = m7049w().m7179d("caller.appid");
        if (!TextUtils.isEmpty(d)) {
            m7036a("app_caller_appid", d, false);
        }
    }

    /* renamed from: a */
    public static void m7031a(long j, int i) throws SpeechError {
        if (SystemClock.elapsedRealtime() - j > ((long) i)) {
            throw new SpeechError((int) ErrorCode.ERROR_NETWORK_TIMEOUT);
        }
    }

    /* renamed from: a */
    protected synchronized void m7032a(C0927a c0927a) {
        C0939a.m7120a("curStatus=" + this.f4393b + ",setStatus=" + c0927a);
        if (this.f4393b != C0927a.exited) {
            if (this.f4393b != C0927a.exiting || c0927a == C0927a.exited) {
                C0939a.m7120a("setStatus success=" + c0927a);
                this.f4393b = c0927a;
                this.f4400v = SystemClock.elapsedRealtime();
            }
        }
    }

    /* renamed from: a */
    protected void m7033a(C0950a c0950a) {
        this.f4392a = c0950a.m7174b();
        this.f4392a.m7172a(C0951b.f4502a);
        mo1573i();
    }

    /* renamed from: a */
    public synchronized void m7034a(String str) {
        m7035a(str, SystemClock.elapsedRealtime() - this.f4404z, false);
    }

    /* renamed from: a */
    public synchronized void m7035a(String str, long j, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                JSONArray jSONArray = this.f4403y.getJSONArray(str);
                if (jSONArray == null) {
                    jSONArray = new JSONArray();
                    this.f4403y.put(str, jSONArray);
                }
                if (jSONArray != null) {
                    jSONArray.put(j);
                }
            } else {
                try {
                    this.f4403y.put(str, j);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    public synchronized void m7036a(String str, String str2, boolean z) {
        if (!(TextUtils.isEmpty(str) || TextUtils.isEmpty(str2))) {
            if (z) {
                JSONArray jSONArray = null;
                if (this.f4403y.has(str)) {
                    jSONArray = this.f4403y.getJSONArray(str);
                }
                if (jSONArray == null) {
                    jSONArray = new JSONArray();
                }
                if (jSONArray != null) {
                    jSONArray.put(str2);
                    this.f4403y.put(str, jSONArray);
                }
            } else {
                try {
                    this.f4403y.put(str, str2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: c */
    public void mo1569c() {
        this.f4399u = true;
        m7046t();
    }

    /* renamed from: e */
    protected void mo1571e() throws Exception {
    }

    /* renamed from: f */
    protected void mo1572f() {
        m7032a(C0927a.exited);
    }

    /* renamed from: i */
    protected void mo1573i() {
        this.f4401w = this.f4392a.m7166a(SpeechConstant.NET_TIMEOUT, this.f4401w);
        this.f4396r = this.f4392a.m7166a(SpeechConstant.SAMPLE_RATE, this.f4396r);
    }

    /* renamed from: j */
    public boolean mo1574j() {
        return false;
    }

    /* renamed from: p */
    public String m7042p() {
        return this.f4392a.m7175b("pte", "utf-8");
    }

    /* renamed from: q */
    public String mo1578q() {
        return this.f4392a.m7175b("tte", "utf-8");
    }

    /* renamed from: r */
    public String m7044r() {
        return this.f4392a.m7175b("rse", "utf-8");
    }

    /* renamed from: s */
    public int m7045s() {
        return this.f4396r;
    }

    /* renamed from: t */
    protected synchronized void m7046t() {
        if (this.f4393b != C0927a.idle) {
            m7032a(C0927a.exiting);
        }
    }

    /* renamed from: u */
    public boolean m7047u() {
        return (this.f4393b == C0927a.exited || this.f4393b == C0927a.exiting) ? false : true;
    }

    /* renamed from: v */
    protected synchronized C0927a m7048v() {
        return this.f4393b;
    }

    /* renamed from: w */
    public C0950a m7049w() {
        return this.f4392a;
    }

    /* renamed from: x */
    protected void m7050x() {
        mo1566a();
        m7032a(C0927a.init);
        if (this.f4392a.m7173a("crt", true)) {
            new Thread(this.f4394c).start();
        } else {
            this.f4394c.run();
        }
    }

    /* renamed from: y */
    protected String m7051y() {
        return getClass().toString();
    }

    /* renamed from: z */
    public synchronized String m7052z() {
        return this.f4403y.toString();
    }
}
