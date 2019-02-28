package com.aps;

import com.tencent.smtt.sdk.WebView;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/* compiled from: Storage */
/* renamed from: com.aps.q */
public class C0579q {
    /* renamed from: a */
    private static C0579q f3544a = null;

    private C0579q() {
    }

    /* renamed from: a */
    static String m4558a(Object obj, String str) {
        DecimalFormat decimalFormat = new DecimalFormat("#", new DecimalFormatSymbols(Locale.US));
        decimalFormat.applyPattern(str);
        return decimalFormat.format(obj);
    }

    /* renamed from: a */
    static byte[] m4561a(String str) {
        return C0579q.m4559a(Integer.parseInt(str));
    }

    /* renamed from: a */
    static byte[] m4559a(int i) {
        return new byte[]{(byte) (i & WebView.NORMAL_MODE_ALPHA), (byte) ((i >> 8) & WebView.NORMAL_MODE_ALPHA), (byte) ((i >> 16) & WebView.NORMAL_MODE_ALPHA), (byte) ((i >> 24) & WebView.NORMAL_MODE_ALPHA)};
    }

    /* renamed from: b */
    static byte[] m4563b(String str) {
        return C0579q.m4562b(Integer.parseInt(str));
    }

    /* renamed from: b */
    static byte[] m4562b(int i) {
        return new byte[]{(byte) (i & WebView.NORMAL_MODE_ALPHA), (byte) ((i >> 8) & WebView.NORMAL_MODE_ALPHA)};
    }

    /* renamed from: a */
    public static byte[] m4560a(long j) {
        byte[] bArr = new byte[8];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) ((int) ((j >> (i * 8)) & 255));
        }
        return bArr;
    }
}
