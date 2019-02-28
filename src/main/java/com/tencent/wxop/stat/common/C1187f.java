package com.tencent.wxop.stat.common;

import android.util.Base64;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.wxop.stat.common.f */
public class C1187f {
    /* renamed from: a */
    static byte[] m8256a() {
        return Base64.decode("MDNhOTc2NTExZTJjYmUzYTdmMjY4MDhmYjdhZjNjMDU=", 0);
    }

    /* renamed from: a */
    public static byte[] m8257a(byte[] bArr) {
        return C1187f.m8258a(bArr, C1187f.m8256a());
    }

    /* renamed from: a */
    static byte[] m8258a(byte[] bArr, byte[] bArr2) {
        int i = 0;
        int[] iArr = new int[256];
        int[] iArr2 = new int[256];
        int length = bArr2.length;
        if (length <= 0 || length > 256) {
            throw new IllegalArgumentException("key must be between 1 and 256 bytes");
        }
        int i2;
        for (i2 = 0; i2 < 256; i2++) {
            iArr[i2] = i2;
            iArr2[i2] = bArr2[i2 % length];
        }
        i2 = 0;
        for (length = 0; length < 256; length++) {
            i2 = ((i2 + iArr[length]) + iArr2[length]) & WebView.NORMAL_MODE_ALPHA;
            int i3 = iArr[length];
            iArr[length] = iArr[i2];
            iArr[i2] = i3;
        }
        byte[] bArr3 = new byte[bArr.length];
        i2 = 0;
        length = 0;
        while (i < bArr.length) {
            i2 = (i2 + 1) & WebView.NORMAL_MODE_ALPHA;
            length = (length + iArr[i2]) & WebView.NORMAL_MODE_ALPHA;
            i3 = iArr[i2];
            iArr[i2] = iArr[length];
            iArr[length] = i3;
            bArr3[i] = (byte) (iArr[(iArr[i2] + iArr[length]) & WebView.NORMAL_MODE_ALPHA] ^ bArr[i]);
            i++;
        }
        return bArr3;
    }

    /* renamed from: b */
    public static byte[] m8259b(byte[] bArr) {
        return C1187f.m8260b(bArr, C1187f.m8256a());
    }

    /* renamed from: b */
    static byte[] m8260b(byte[] bArr, byte[] bArr2) {
        return C1187f.m8258a(bArr, bArr2);
    }
}
