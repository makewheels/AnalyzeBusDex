package com.tencent.smtt.sdk.p052b;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.p051a.C1085a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* renamed from: com.tencent.smtt.sdk.b.c */
public class C1098c {
    /* renamed from: a */
    private static char[] f5010a = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    /* renamed from: b */
    private Bundle f5011b = new Bundle();

    /* renamed from: a */
    public static String m7825a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            int i3 = bArr[i] & WebView.NORMAL_MODE_ALPHA;
            if (i2 == length) {
                stringBuffer.append(f5010a[i3 >>> 2]);
                stringBuffer.append(f5010a[(i3 & 3) << 4]);
                stringBuffer.append("==");
                break;
            }
            int i4 = i2 + 1;
            i2 = bArr[i2] & WebView.NORMAL_MODE_ALPHA;
            if (i4 == length) {
                stringBuffer.append(f5010a[i3 >>> 2]);
                stringBuffer.append(f5010a[((i3 & 3) << 4) | ((i2 & 240) >>> 4)]);
                stringBuffer.append(f5010a[(i2 & 15) << 2]);
                stringBuffer.append("=");
                break;
            }
            i = i4 + 1;
            i4 = bArr[i4] & WebView.NORMAL_MODE_ALPHA;
            stringBuffer.append(f5010a[i3 >>> 2]);
            stringBuffer.append(f5010a[((i3 & 3) << 4) | ((i2 & 240) >>> 4)]);
            stringBuffer.append(f5010a[((i2 & 15) << 2) | ((i4 & 192) >>> 6)]);
            stringBuffer.append(f5010a[i4 & 63]);
        }
        return stringBuffer.toString();
    }

    /* renamed from: b */
    private String m7826b(String str) {
        try {
            return C1098c.m7825a(C1085a.m7680a("24Xdf8j6".getBytes("utf-8"), str.getBytes("utf-8"), 1));
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    /* renamed from: a */
    public C1098c m7827a(String str, String str2) {
        this.f5011b.putCharSequence(str, str2);
        return this;
    }

    /* renamed from: a */
    public String m7828a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str2 : this.f5011b.keySet()) {
            Object string = this.f5011b.getString(str2);
            if (!TextUtils.isEmpty(string)) {
                if (stringBuilder.length() != 0) {
                    stringBuilder.append('&');
                }
                stringBuilder.append(str2).append('=').append(URLEncoder.encode(string));
            }
        }
        return str + "?p=" + URLEncoder.encode(m7826b(stringBuilder.toString()));
    }
}
