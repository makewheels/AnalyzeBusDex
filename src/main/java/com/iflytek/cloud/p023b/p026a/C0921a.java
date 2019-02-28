package com.iflytek.cloud.p023b.p026a;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.iflytek.cloud.p023b.p024e.p029a.C0939a;
import com.iflytek.cloud.p023b.p025b.C0920c;
import com.iflytek.cloud.p023b.p025b.C0920c.C0929a;
import com.iflytek.cloud.p023b.p025b.C0923a;
import com.iflytek.cloud.p030c.C0952c;
import com.iflytek.cloud.speech.ErrorCode;
import com.iflytek.cloud.speech.SpeechConstant;
import com.iflytek.cloud.speech.SpeechError;
import com.iflytek.msc.MSC;
import com.iflytek.msc.MSCSessionInfo;
import java.io.UnsupportedEncodingException;
import java.util.Date;

/* renamed from: com.iflytek.cloud.b.a.a */
public class C0921a extends C0920c {
    /* renamed from: b */
    private MSCSessionInfo f4387b = new MSCSessionInfo();
    /* renamed from: c */
    private MSCSessionInfo f4388c = new MSCSessionInfo();
    /* renamed from: d */
    private byte[] f4389d = null;

    /* renamed from: a */
    private synchronized void m7014a(byte[] bArr, int i, int i2) throws SpeechError {
        int QISRAudioWrite = MSC.QISRAudioWrite(this.a, bArr, i, i2, this.f4388c);
        this.f4387b.sesstatus = this.f4388c.sesstatus;
        C0939a.m7120a("QISRAudioWrite length:" + i);
        if (QISRAudioWrite != 0) {
            throw new SpeechError(this.f4388c.errorcode);
        }
    }

    /* renamed from: d */
    public static int m7015d(String str) {
        int i = 0;
        try {
            Object e = C0921a.m7016e(str);
            if (!TextUtils.isEmpty(e)) {
                i = Integer.parseInt(e);
            }
        } catch (Exception e2) {
        }
        return i;
    }

    /* renamed from: e */
    public static String m7016e(String str) {
        String str2 = null;
        try {
            MSCSessionInfo mSCSessionInfo = new MSCSessionInfo();
            if (MSC.QISRGetParam(null, str.getBytes(), mSCSessionInfo) == 0) {
                str2 = new String(mSCSessionInfo.buffer).trim();
            }
        } catch (Exception e) {
        }
        return str2;
    }

    /* renamed from: a */
    public int m7017a(Context context, String str, C0923a c0923a) throws SpeechError, UnsupportedEncodingException {
        String a = C0952c.m7185a(context, str, c0923a);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (TextUtils.isEmpty(str)) {
            this.a = MSC.QISRSessionBegin(null, a.getBytes(c0923a.m7042p()), this.f4387b);
        } else {
            this.a = MSC.QISRSessionBegin(str.getBytes(c0923a.m7042p()), a.getBytes(c0923a.m7042p()), this.f4387b);
            C0939a.m7120a("sessionBegin grammarId:" + str);
        }
        C0939a.m7120a("sessionBegin ErrCode:" + this.f4387b.errorcode + " time:" + (SystemClock.elapsedRealtime() - elapsedRealtime));
        int i = this.f4387b.errorcode;
        if (i == 0 || i == ErrorCode.MSP_ERROR_CREATE_HANDLE || i == ErrorCode.MSP_ERROR_OVERFLOW || i == ErrorCode.MSP_ERROR_INVALID_OPERATION) {
            return i;
        }
        throw new SpeechError(i);
    }

    /* renamed from: a */
    public synchronized void m7018a() throws SpeechError {
        m7014a(new byte[0], 0, 4);
    }

    /* renamed from: a */
    public void m7019a(String str) {
        if (this.a != null) {
            C0939a.m7120a("sessionEnd enter ");
            C0939a.m7120a("sessionEnd leavel:" + (MSC.QISRSessionEnd(this.a, str.getBytes()) == 0) + " time:" + (System.currentTimeMillis() - System.currentTimeMillis()));
            this.a = null;
        }
    }

    /* renamed from: a */
    public synchronized void m7020a(byte[] bArr, int i) throws SpeechError {
        m7014a(bArr, i, 2);
    }

    /* renamed from: a */
    public synchronized boolean m7021a(String str, String str2) {
        boolean z = false;
        synchronized (this) {
            if (!(TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || this.a == null)) {
                int QISRSetParam;
                C0939a.m7120a("setParam:" + str + "," + str2);
                try {
                    QISRSetParam = MSC.QISRSetParam(this.a, str.getBytes("utf-8"), str2.getBytes("utf-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    QISRSetParam = -1;
                }
                if (QISRSetParam == 0) {
                    z = true;
                }
            }
        }
        return z;
    }

    /* renamed from: b */
    public synchronized int m7022b() {
        return this.f4388c.epstatues;
    }

    /* renamed from: b */
    public synchronized int m7023b(String str) {
        int i = 0;
        synchronized (this) {
            if (this.a != null) {
                try {
                    Object c = m7025c(str);
                    if (!TextUtils.isEmpty(c)) {
                        i = Integer.parseInt(new String(c));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return i;
    }

    /* renamed from: c */
    public synchronized int m7024c() {
        int QISRGetParam;
        int i = 0;
        synchronized (this) {
            try {
                QISRGetParam = MSC.QISRGetParam(this.a, SpeechConstant.VOLUME.getBytes(), this.f4388c);
                if (QISRGetParam == 0) {
                    try {
                        i = Integer.parseInt(new String(new String(this.f4388c.buffer)));
                    } catch (Exception e) {
                        C0939a.m7120a("getAudioVolume Exception vadret = " + QISRGetParam);
                        return i;
                    }
                } else {
                    C0939a.m7120a("VAD CHECK FALSE");
                }
            } catch (Exception e2) {
                QISRGetParam = i;
                C0939a.m7120a("getAudioVolume Exception vadret = " + QISRGetParam);
                return i;
            }
        }
        return i;
    }

    /* renamed from: c */
    public synchronized String m7025c(String str) {
        String str2 = null;
        synchronized (this) {
            if (this.a != null) {
                try {
                    if (MSC.QISRGetParam(this.a, str.getBytes(), this.f4387b) == 0) {
                        str2 = new String(this.f4387b.buffer);
                    }
                } catch (Exception e) {
                }
            }
        }
        return str2;
    }

    /* renamed from: d */
    public synchronized boolean m7026d() {
        return this.f4387b.sesstatus == 0;
    }

    /* renamed from: e */
    public byte[] m7027e() {
        return this.f4389d;
    }

    /* renamed from: f */
    public C0929a m7028f() throws SpeechError {
        Date date = new Date();
        this.f4389d = MSC.QISRGetResult(this.a, this.f4387b);
        C0939a.m7120a("QISRGetResult leavel:" + (this.f4389d != null) + " time:" + (new Date().getTime() - date.getTime()));
        int i = this.f4387b.errorcode;
        if (i == 0) {
            i = this.f4387b.rsltstatus;
            switch (i) {
                case 0:
                    C0939a.m7120a("ResultStatus: hasResult" + i);
                    return C0929a.hasResult;
                case 2:
                    C0939a.m7120a("ResultStatus: noResult" + i);
                    return C0929a.noResult;
                case 5:
                    C0939a.m7120a("ResultStatus: resultOver" + i);
                    return C0929a.resultOver;
                default:
                    return C0929a.noResult;
            }
        }
        C0939a.m7120a("Result: error errorcode is " + i);
        throw new SpeechError(i);
    }
}
