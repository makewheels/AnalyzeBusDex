package com.amap.api.location.core;

import com.alipay.sdk.cons.C0108a;
import com.tencent.smtt.sdk.WebView;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import p054u.aly.bi_常量类;

/* compiled from: MD5 */
/* renamed from: com.amap.api.location.core.g */
public class C0288g {
    /* renamed from: a */
    private static final String[] f1316a = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", C0108a.f262e, "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    /* renamed from: a */
    public static String m1861a(byte[] bArr) {
        if (bArr == null) {
            return bi_常量类.f6358b_空串;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & WebView.NORMAL_MODE_ALPHA);
            if (toHexString.length() == 1) {
                toHexString = '0' + toHexString;
            }
            stringBuilder.append(toHexString);
        }
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public static String m1860a(String str) {
        MessageDigest instance;
        byte[] bArr = null;
        try {
            instance = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            instance = null;
        }
        if (instance != null) {
            try {
                instance.update(str.getBytes("utf-8"));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        if (instance != null) {
            bArr = instance.digest();
        }
        return C0288g.m1861a(bArr);
    }
}
