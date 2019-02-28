package com.amap.api.services.core;

import com.tencent.smtt.sdk.WebView;

/* compiled from: Base64Util */
/* renamed from: com.amap.api.services.core.a */
public class C0475a {
    /* renamed from: a */
    private static final char[] f2931a = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    private C0475a() {
    }

    /* renamed from: a */
    public static String m3989a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            int i3 = bArr[i] & WebView.NORMAL_MODE_ALPHA;
            if (i2 == length) {
                stringBuffer.append(f2931a[i3 >>> 2]);
                stringBuffer.append(f2931a[(i3 & 3) << 4]);
                stringBuffer.append("==");
                break;
            }
            int i4 = i2 + 1;
            i2 = bArr[i2] & WebView.NORMAL_MODE_ALPHA;
            if (i4 == length) {
                stringBuffer.append(f2931a[i3 >>> 2]);
                stringBuffer.append(f2931a[((i3 & 3) << 4) | ((i2 & 240) >>> 4)]);
                stringBuffer.append(f2931a[(i2 & 15) << 2]);
                stringBuffer.append("=");
                break;
            }
            i = i4 + 1;
            i4 = bArr[i4] & WebView.NORMAL_MODE_ALPHA;
            stringBuffer.append(f2931a[i3 >>> 2]);
            stringBuffer.append(f2931a[((i3 & 3) << 4) | ((i2 & 240) >>> 4)]);
            stringBuffer.append(f2931a[((i2 & 15) << 2) | ((i4 & 192) >>> 6)]);
            stringBuffer.append(f2931a[i4 & 63]);
        }
        return stringBuffer.toString();
    }
}
