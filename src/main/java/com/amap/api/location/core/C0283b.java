package com.amap.api.location.core;

import com.tencent.smtt.sdk.WebView;
import p054u.aly.bi_常量类;
import p054u.aly.df;

/* compiled from: Base64Util */
/* renamed from: com.amap.api.location.core.b */
public class C0283b {
    /* renamed from: a */
    private static final char[] f1294a = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    /* renamed from: b */
    private static byte[] f1295b = new byte[]{(byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) 62, (byte) -1, (byte) -1, (byte) -1, (byte) 63, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 58, (byte) 59, (byte) 60, (byte) 61, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) 0, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10, (byte) 11, (byte) 12, df.f6527k, df.f6528l, df.f6529m, df.f6530n, (byte) 17, (byte) 18, (byte) 19, (byte) 20, (byte) 21, (byte) 22, (byte) 23, (byte) 24, (byte) 25, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) 26, (byte) 27, (byte) 28, (byte) 29, (byte) 30, (byte) 31, (byte) 32, (byte) 33, (byte) 34, (byte) 35, (byte) 36, (byte) 37, (byte) 38, (byte) 39, (byte) 40, (byte) 41, (byte) 42, (byte) 43, (byte) 44, (byte) 45, (byte) 46, (byte) 47, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1};

    private C0283b() {
    }

    /* renamed from: a */
    public static String m1821a(byte[] bArr) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            int length = bArr.length;
            int i = 0;
            while (i < length) {
                int i2 = i + 1;
                int i3 = bArr[i] & WebView.NORMAL_MODE_ALPHA;
                if (i2 == length) {
                    stringBuffer.append(f1294a[i3 >>> 2]);
                    stringBuffer.append(f1294a[(i3 & 3) << 4]);
                    stringBuffer.append("==");
                    break;
                }
                int i4 = i2 + 1;
                i2 = bArr[i2] & WebView.NORMAL_MODE_ALPHA;
                if (i4 == length) {
                    stringBuffer.append(f1294a[i3 >>> 2]);
                    stringBuffer.append(f1294a[((i3 & 3) << 4) | ((i2 & 240) >>> 4)]);
                    stringBuffer.append(f1294a[(i2 & 15) << 2]);
                    stringBuffer.append("=");
                    break;
                }
                i = i4 + 1;
                i4 = bArr[i4] & WebView.NORMAL_MODE_ALPHA;
                stringBuffer.append(f1294a[i3 >>> 2]);
                stringBuffer.append(f1294a[((i3 & 3) << 4) | ((i2 & 240) >>> 4)]);
                stringBuffer.append(f1294a[((i2 & 15) << 2) | ((i4 & 192) >>> 6)]);
                stringBuffer.append(f1294a[i4 & 63]);
            }
            return stringBuffer.toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return bi_常量类.f6358b;
        }
    }
}
