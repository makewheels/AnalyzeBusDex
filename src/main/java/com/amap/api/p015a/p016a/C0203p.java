package com.amap.api.p015a.p016a;

import com.alipay.sdk.cons.C0108a;
import com.tencent.smtt.sdk.WebView;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: MD5 */
/* renamed from: com.amap.api.a.a.p */
public class C0203p {
    /* renamed from: a */
    private static final String[] f598a = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", C0108a.f262e, "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    /* renamed from: a */
    public static String m790a(byte[] bArr) {
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
    public static String m789a(String str) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {
            messageDigest.update(str.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        return C0203p.m790a(messageDigest.digest());
    }
}
