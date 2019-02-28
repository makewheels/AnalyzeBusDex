package com.amap.api.mapcore.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: MD5 */
public class ab {
    /* renamed from: a */
    public static String m3010a(String str) {
        if (str == null) {
            return null;
        }
        return ae.m3043c(m3014c(str));
    }

    /* renamed from: a */
    public static String m3011a(byte[] bArr) {
        return ae.m3043c(m3013b(bArr));
    }

    /* renamed from: b */
    public static String m3012b(String str) {
        return ae.m3044d(m3015d(str));
    }

    /* renamed from: b */
    private static byte[] m3013b(byte[] bArr) {
        byte[] bArr2 = null;
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            bArr2 = instance.digest();
        } catch (Throwable e) {
            az.m3143a(e, "MD5", "getMd5Bytes");
            e.printStackTrace();
        } catch (Throwable e2) {
            az.m3143a(e2, "MD5", "getMd5Bytes1");
            e2.printStackTrace();
        }
        return bArr2;
    }

    /* renamed from: c */
    public static byte[] m3014c(String str) {
        try {
            return m3016e(str);
        } catch (Throwable e) {
            az.m3143a(e, "MD5", "getMd5Bytes");
            e.printStackTrace();
            return new byte[0];
        } catch (Throwable e2) {
            az.m3143a(e2, "MD5", "getMd5Bytes");
            e2.printStackTrace();
            return new byte[0];
        } catch (Throwable e22) {
            az.m3143a(e22, "MD5", "getMd5Bytes");
            e22.printStackTrace();
            return new byte[0];
        }
    }

    /* renamed from: d */
    private static byte[] m3015d(String str) {
        try {
            return m3016e(str);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return new byte[0];
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return new byte[0];
        } catch (Throwable th) {
            th.printStackTrace();
            return new byte[0];
        }
    }

    /* renamed from: e */
    private static byte[] m3016e(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        MessageDigest instance = MessageDigest.getInstance("MD5");
        instance.update(str.getBytes("utf-8"));
        return instance.digest();
    }
}
