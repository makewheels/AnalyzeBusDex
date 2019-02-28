package com.tencent.smtt.utils;

import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.smtt.utils.c */
public class C1136c {
    /* renamed from: a */
    public static String m7956a(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            if ((bArr[i] & WebView.NORMAL_MODE_ALPHA) < 16) {
                stringBuffer.append("0");
            }
            stringBuffer.append(Long.toString((long) (bArr[i] & WebView.NORMAL_MODE_ALPHA), 16));
        }
        return stringBuffer.toString();
    }
}
