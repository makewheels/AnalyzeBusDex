package com.iflytek.cloud.p023b.p027c;

import android.content.Context;
import android.text.TextUtils;
import com.iflytek.cloud.p023b.p024e.p029a.C0939a;
import com.iflytek.cloud.p023b.p025b.C0923a;
import com.iflytek.cloud.p030c.C0952c;
import com.iflytek.cloud.speech.SpeechError;
import com.iflytek.msc.MSC;
import com.iflytek.msc.MSCSessionInfo;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/* renamed from: com.iflytek.cloud.b.c.a */
public class C0933a {
    /* renamed from: a */
    public static Object f4446a = new Object();
    /* renamed from: b */
    private MSCSessionInfo f4447b = new MSCSessionInfo();

    /* renamed from: a */
    public static void m7092a(Context context, String str, String str2, C0923a c0923a) throws SpeechError, IOException {
        byte[] bArr = null;
        synchronized (f4446a) {
            byte[] bytes;
            String a = C0952c.m7184a(context, c0923a);
            if (!TextUtils.isEmpty(str)) {
                bytes = str.getBytes("utf-8");
            } else if (context != null) {
                Object a2 = C0952c.m7183a(context);
                bytes = TextUtils.isEmpty(a2) ? null : a2.getBytes(c0923a.m7042p());
            } else {
                bytes = null;
            }
            if (!TextUtils.isEmpty(str2)) {
                bArr = str2.getBytes(c0923a.m7042p());
            }
            int QMSPLogin = MSC.QMSPLogin(bytes, bArr, a.getBytes(c0923a.m7042p()));
            C0939a.m7120a("[MSPLogin]ret:" + QMSPLogin);
            if (QMSPLogin != 0) {
                throw new SpeechError(QMSPLogin);
            }
        }
    }

    /* renamed from: a */
    public static boolean m7093a() {
        boolean z;
        synchronized (f4446a) {
            z = MSC.QMSPLogOut() == 0;
        }
        return z;
    }

    /* renamed from: a */
    public synchronized byte[] m7094a(Context context, C0923a c0923a) throws SpeechError, UnsupportedEncodingException {
        byte[] QMSPDownloadData;
        synchronized (f4446a) {
            String b = C0952c.m7190b(context, c0923a);
            C0939a.m7120a("[MSPSession downloadData]enter time:" + System.currentTimeMillis());
            QMSPDownloadData = MSC.QMSPDownloadData(b.getBytes(c0923a.m7042p()), this.f4447b);
            C0939a.m7120a("[MSPSession downloadData]leavel:" + this.f4447b.errorcode + ",data len = " + (QMSPDownloadData == null ? 0 : QMSPDownloadData.length));
            int i = this.f4447b.errorcode;
            if (i != 0 || QMSPDownloadData == null) {
                throw new SpeechError(i);
            }
        }
        return QMSPDownloadData;
    }

    /* renamed from: a */
    public synchronized byte[] m7095a(Context context, C0923a c0923a, String str) throws SpeechError, UnsupportedEncodingException {
        byte[] QMSPSearch;
        synchronized (f4446a) {
            String b = C0952c.m7190b(context, c0923a);
            C0939a.m7120a("[MSPSession searchResult]enter time:" + System.currentTimeMillis());
            QMSPSearch = MSC.QMSPSearch(b.getBytes(c0923a.m7042p()), str.getBytes("utf-8"), this.f4447b);
            C0939a.m7120a("[QMSPSearch searchResult]leavel:" + this.f4447b.errorcode + ",data len = " + (QMSPSearch == null ? 0 : QMSPSearch.length));
            int i = this.f4447b.errorcode;
            if (i != 0 || QMSPSearch == null) {
                throw new SpeechError(i);
            }
        }
        return QMSPSearch;
    }

    /* renamed from: a */
    public synchronized byte[] m7096a(Context context, String str, byte[] bArr, C0923a c0923a) throws SpeechError, UnsupportedEncodingException {
        byte[] QMSPUploadData;
        synchronized (f4446a) {
            String b = C0952c.m7190b(context, c0923a);
            C0939a.m7120a("[MSPSession uploadData]enter time:" + System.currentTimeMillis());
            QMSPUploadData = MSC.QMSPUploadData(str.getBytes(c0923a.m7042p()), bArr, bArr.length, b.getBytes("utf-8"), this.f4447b);
            C0939a.m7120a("[MSPSession uploaddData]leavel:" + this.f4447b.errorcode + ",data len = " + (QMSPUploadData == null ? 0 : QMSPUploadData.length));
            int i = this.f4447b.errorcode;
            if (i != 0 || QMSPUploadData == null) {
                throw new SpeechError(i);
            }
        }
        return QMSPUploadData;
    }
}
