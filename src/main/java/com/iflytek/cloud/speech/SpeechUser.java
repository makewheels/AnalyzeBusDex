package com.iflytek.cloud.speech;

import android.content.Context;
import com.iflytek.cloud.p023b.p024e.p029a.C0939a;
import com.iflytek.cloud.p023b.p024e.p029a.C0941c;
import com.iflytek.cloud.p023b.p025b.C0931d;
import com.iflytek.cloud.p023b.p025b.C0931d.C0930a;
import com.iflytek.cloud.p023b.p027c.C0933a;
import com.iflytek.cloud.p023b.p027c.C0935b;
import com.iflytek.cloud.p030c.C0950a;
import p054u.aly.bi_常量类;

public class SpeechUser extends C0931d {
    /* renamed from: e */
    private static SpeechUser f4575e = new SpeechUser();
    /* renamed from: f */
    private String f4576f = bi_常量类.f6358b_空串;
    /* renamed from: g */
    private String f4577g = bi_常量类.f6358b_空串;
    /* renamed from: h */
    private C0950a f4578h = new C0950a();
    /* renamed from: i */
    private Login_State f4579i = Login_State.Unlogin;

    public enum Login_State {
        Logined,
        Unlogin
    }

    /* renamed from: com.iflytek.cloud.speech.SpeechUser$a */
    private class C0964a extends C0930a {
        /* renamed from: b */
        final /* synthetic */ SpeechUser f4574b;

        public C0964a(SpeechUser speechUser, SpeechListener speechListener) {
            this.f4574b = speechUser;
            super(speechUser, speechListener);
        }

        public void onCompleted(SpeechError speechError) {
            if (speechError == null) {
                this.f4574b.f4579i = Login_State.Logined;
            }
            super.onCompleted(speechError);
        }
    }

    private SpeechUser() {
        super(null);
    }

    public static SpeechUser getUser() {
        if (f4575e == null) {
            f4575e = new SpeechUser();
        }
        return f4575e;
    }

    /* renamed from: a */
    protected void m7251a(String str) {
        this.f4578h.m7169a(str);
    }

    /* renamed from: d */
    protected boolean mo1579d() {
        boolean z = true;
        if (f4575e != null) {
            z = logout();
        }
        if (z) {
            f4575e = null;
            C0939a.m7120a(m7089b() + " destory mInstance=null");
        }
        return z;
    }

    public C0950a getInitParam() {
        return this.f4578h;
    }

    public Login_State getLoginState() {
        return this.f4579i;
    }

    public boolean login(Context context, String str, String str2, String str3, SpeechListener speechListener) {
        C0939a.m7120a("SpeechUser Login isLogined=" + this.f4579i);
        if (this.f4579i == Login_State.Logined) {
            return false;
        }
        if (m7090c()) {
            new C0964a(this, speechListener).onCompleted(new SpeechError((int) ErrorCode.ERROR_INTERRUPT));
            return true;
        }
        this.f4576f = str;
        this.f4577g = str2;
        this.a = context;
        m7251a(str3);
        this.d = new C0935b(this.a, getInitParam());
        this.f4578h.m7170a("crt", "0");
        ((C0935b) this.d).m7099a(new C0964a(this, speechListener), this.f4576f, this.f4577g);
        return true;
    }

    public boolean logout() {
        if (this.f4579i != Login_State.Logined) {
            return true;
        }
        C0941c.m7127a("QMSPLogOut", null);
        boolean a = C0933a.m7093a();
        if (!a) {
            return a;
        }
        this.f4579i = Login_State.Unlogin;
        return a;
    }
}
