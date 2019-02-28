package com.alipay.apmobilesecuritysdk.p009e;

import com.alipay.security.mobile.module.p010a.p011a.C0156a;
import com.tencent.smtt.sdk.WebView;
import java.util.Map;
import java.util.Set;
import p054u.aly.bi_常量类;

/* renamed from: com.alipay.apmobilesecuritysdk.e.a */
public final class C0069a {
    /* renamed from: a */
    public static String m184a(Map<String, Integer> map, String str, String str2) {
        if (str2 == null || str2.length() <= 0) {
            return bi_常量类.f6358b;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2 + ":");
        if (str == null || str.length() <= 0) {
            return stringBuilder.toString();
        }
        String[] split = str.split(",");
        if (split == null || split.length <= 0) {
            return stringBuilder.toString();
        }
        if (map == null || map.size() <= 0) {
            return stringBuilder.toString();
        }
        Set keySet = map.keySet();
        if (keySet == null || keySet.size() <= 0) {
            return stringBuilder.toString();
        }
        try {
            int i;
            byte[] bArr = new byte[((split.length / 8) + 1)];
            for (i = 0; i < bArr.length; i++) {
                bArr[i] = (byte) 0;
            }
            int i2 = 0;
            for (Object obj : split) {
                int i3 = bArr[i2 / 8];
                if (keySet.contains(obj)) {
                    i3 |= 128 >> (i2 % 8);
                    System.out.println(i2);
                }
                bArr[i2 / 8] = (byte) (i3 & WebView.NORMAL_MODE_ALPHA);
                i2++;
            }
            stringBuilder.append(C0156a.m548a(bArr));
        } catch (Throwable th) {
        }
        return stringBuilder.toString();
    }
}
