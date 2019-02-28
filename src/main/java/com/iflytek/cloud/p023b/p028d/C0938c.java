package com.iflytek.cloud.p023b.p028d;

import android.content.Context;
import android.text.TextUtils;
import com.iflytek.cloud.p023b.p024e.p029a.C0939a;
import com.iflytek.cloud.p023b.p025b.C0920c;
import com.iflytek.cloud.p023b.p025b.C0923a;
import com.iflytek.cloud.p030c.C0950a;
import com.iflytek.cloud.p030c.C0952c;
import com.iflytek.cloud.speech.ErrorCode;
import com.iflytek.cloud.speech.SpeechError;
import com.iflytek.msc.MSC;
import com.iflytek.msc.MSCSessionInfo;
import java.io.UnsupportedEncodingException;
import p054u.aly.bi_常量类;

/* renamed from: com.iflytek.cloud.b.d.c */
public class C0938c extends C0920c {
    /* renamed from: b */
    private MSCSessionInfo f4472b = new MSCSessionInfo();

    /* renamed from: d */
    public static int m7109d(String str) {
        int i = 0;
        try {
            Object e = C0938c.m7110e(str);
            if (!TextUtils.isEmpty(e)) {
                i = Integer.parseInt(e);
            }
        } catch (Exception e2) {
        }
        return i;
    }

    /* renamed from: e */
    public static String m7110e(String str) {
        String str2 = null;
        try {
            MSCSessionInfo mSCSessionInfo = new MSCSessionInfo();
            if (MSC.QTTSGetParam(null, str.getBytes(), mSCSessionInfo) == 0) {
                str2 = new String(mSCSessionInfo.buffer).trim();
            }
        } catch (Exception e) {
        }
        return str2;
    }

    /* renamed from: a */
    public int m7111a(Context context, String str, C0923a c0923a) throws SpeechError, UnsupportedEncodingException {
        this.a = null;
        String c = C0952c.m7192c(context, c0923a);
        C0939a.m7120a("QTTSSessionBegin enter  params:" + c);
        this.a = MSC.QTTSSessionBegin(c.getBytes(c0923a.m7042p()), this.f4472b);
        C0939a.m7120a("QTTSSessionBegin leave:" + this.f4472b.errorcode + " ErrorCode:" + this.f4472b.errorcode);
        int i = this.f4472b.errorcode;
        if (i == 0 || i == ErrorCode.MSP_ERROR_CREATE_HANDLE) {
            return i;
        }
        throw new SpeechError(this.f4472b.errorcode);
    }

    /* renamed from: a */
    public void m7112a(String str) {
        if (this.a != null) {
            if (TextUtils.isEmpty(str)) {
                str = "unknown";
            }
            C0939a.m7120a("QTTSSessionEnd enter");
            C0939a.m7120a("QTTSSessionEnd leavel:" + MSC.QTTSSessionEnd(this.a, str.getBytes()));
            this.a = null;
        }
    }

    /* renamed from: a */
    public synchronized void m7113a(byte[] bArr) throws SpeechError {
        C0939a.m7120a("QTTSTextPut enter");
        int QTTSTextPut = MSC.QTTSTextPut(this.a, bArr);
        C0939a.m7120a("QTTSTextPut leavel:" + QTTSTextPut);
        if (QTTSTextPut != 0) {
            throw new SpeechError(QTTSTextPut);
        }
    }

    /* renamed from: a */
    public synchronized byte[] m7114a() throws SpeechError {
        byte[] QTTSAudioGet;
        if (this.a == null) {
            throw new SpeechError((int) ErrorCode.ERROR_NET_EXPECTION);
        }
        C0939a.m7120a("QTTSAudioGet enter");
        QTTSAudioGet = MSC.QTTSAudioGet(this.a, this.f4472b);
        C0939a.m7120a("QTTSAudioGet leavel:" + this.f4472b.errorcode + "value len = " + (QTTSAudioGet == null ? 0 : QTTSAudioGet.length));
        int i = this.f4472b.errorcode;
        if (i != 0) {
            throw new SpeechError(i);
        }
        return QTTSAudioGet;
    }

    /* renamed from: b */
    public int m7115b() {
        try {
            return new C0950a(new String(MSC.QTTSAudioInfo(this.a)), (String[][]) null).m7166a("ced", 0);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: b */
    public synchronized int m7116b(String str) {
        int i = 0;
        synchronized (this) {
            if (this.a != null) {
                try {
                    Object c = m7118c(str);
                    if (!TextUtils.isEmpty(c)) {
                        i = Integer.parseInt(new String(c));
                    }
                } catch (Exception e) {
                }
            }
        }
        return i;
    }

    /* renamed from: c */
    public String m7117c() {
        String str;
        Exception exception;
        String str2 = bi_常量类.f6358b_空串;
        try {
            String str3 = new String(MSC.QTTSAudioInfo(this.a));
            try {
                return new String(str3.getBytes("iso8859-1"), "gb2312");
            } catch (Exception e) {
                Exception exception2 = e;
                str = str3;
                exception = exception2;
            }
        } catch (Exception e2) {
            exception = e2;
            str = str2;
            exception.printStackTrace();
            return str;
        }
    }

    /* renamed from: c */
    public synchronized String m7118c(String str) {
        String str2 = null;
        synchronized (this) {
            if (this.a != null) {
                try {
                    if (MSC.QTTSGetParam(this.a, str.getBytes(), this.f4472b) == 0) {
                        str2 = new String(this.f4472b.buffer);
                    }
                } catch (Exception e) {
                }
            }
        }
        return str2;
    }

    /* renamed from: d */
    public synchronized boolean m7119d() {
        return 2 == this.f4472b.sesstatus;
    }
}
