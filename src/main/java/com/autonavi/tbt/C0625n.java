package com.autonavi.tbt;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: MD5 */
/* renamed from: com.autonavi.tbt.n */
public class C0625n {
    /* renamed from: a */
    public static String m4917a(String str) {
        if (str == null) {
            return null;
        }
        return C0630q.m4947b(C0625n.m4919c(str));
    }

    /* renamed from: b */
    public static String m4918b(String str) {
        return C0630q.m4948c(C0625n.m4920d(str));
    }

    /* renamed from: c */
    public static byte[] m4919c(String str) {
        try {
            return C0625n.m4921e(str);
        } catch (Throwable e) {
            ae.m4671a(e, "MD5", "getMd5Bytes");
            e.printStackTrace();
            return new byte[0];
        } catch (Throwable e2) {
            ae.m4671a(e2, "MD5", "getMd5Bytes");
            e2.printStackTrace();
            return new byte[0];
        } catch (Throwable e22) {
            ae.m4671a(e22, "MD5", "getMd5Bytes");
            e22.printStackTrace();
            return new byte[0];
        }
    }

    /* renamed from: d */
    private static byte[] m4920d(String str) {
        try {
            return C0625n.m4921e(str);
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
    private static byte[] m4921e(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        MessageDigest instance = MessageDigest.getInstance("MD5");
        instance.update(str.getBytes("utf-8"));
        return instance.digest();
    }
}
