package com.autonavi.tbt;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.alipay.sdk.cons.C0108a;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.util.Map;
import java.util.Map.Entry;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import p054u.aly.bi_常量类;

/* compiled from: ClientInfo */
/* renamed from: com.autonavi.tbt.k */
public class C0621k {
    /* renamed from: a */
    public static String m4876a(Context context, C0629p c0629p, Map<String, String> map) {
        String str = null;
        try {
            String b = C0621k.m4879b(context, c0629p, map);
            if (!bi_常量类.f6358b.equals(b)) {
                str = C0621k.m4880b(context, b.getBytes("utf-8"));
            }
        } catch (Throwable e) {
            ae.m4671a(e, "CInfo", "rsaInfo");
            e.printStackTrace();
        }
        return str;
    }

    /* renamed from: c */
    private static String m4881c(Context context, byte[] bArr) throws InvalidKeyException, IOException, InvalidKeySpecException, NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, CertificateException {
        KeyGenerator instance = KeyGenerator.getInstance("AES");
        if (instance == null) {
            return null;
        }
        instance.init(256);
        byte[] encoded = instance.generateKey().getEncoded();
        Key a = C0630q.m4945a(context);
        if (a == null) {
            return null;
        }
        Object a2 = C0624m.m4911a(encoded, a);
        Object a3 = C0624m.m4912a(encoded, bArr);
        byte[] bArr2 = new byte[(a2.length + a3.length)];
        System.arraycopy(a2, 0, bArr2, 0, a2.length);
        System.arraycopy(a3, 0, bArr2, a2.length, a3.length);
        byte[] a4 = C0630q.m4946a(bArr2);
        if (a4 != null) {
            return C0624m.m4910a(a4);
        }
        return bi_常量类.f6358b;
    }

    /* renamed from: a */
    public static String m4878a(Context context, byte[] bArr) {
        try {
            return C0621k.m4881c(context, bArr);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
            return bi_常量类.f6358b;
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return bi_常量类.f6358b;
        } catch (NoSuchPaddingException e3) {
            e3.printStackTrace();
            return bi_常量类.f6358b;
        } catch (IllegalBlockSizeException e4) {
            e4.printStackTrace();
            return bi_常量类.f6358b;
        } catch (BadPaddingException e5) {
            e5.printStackTrace();
            return bi_常量类.f6358b;
        } catch (InvalidKeySpecException e6) {
            e6.printStackTrace();
            return bi_常量类.f6358b;
        } catch (CertificateException e7) {
            e7.printStackTrace();
            return bi_常量类.f6358b;
        } catch (IOException e8) {
            e8.printStackTrace();
            return bi_常量类.f6358b;
        } catch (Throwable th) {
            th.printStackTrace();
            return bi_常量类.f6358b;
        }
    }

    /* renamed from: b */
    public static String m4880b(Context context, byte[] bArr) {
        try {
            return C0621k.m4881c(context, bArr);
        } catch (Throwable e) {
            ae.m4671a(e, "CInfo", "AESData");
            e.printStackTrace();
            return bi_常量类.f6358b;
        } catch (Throwable e2) {
            ae.m4671a(e2, "CInfo", "AESData");
            e2.printStackTrace();
            return bi_常量类.f6358b;
        } catch (Throwable e22) {
            ae.m4671a(e22, "CInfo", "AESData");
            e22.printStackTrace();
            return bi_常量类.f6358b;
        } catch (Throwable e222) {
            ae.m4671a(e222, "CInfo", "AESData");
            e222.printStackTrace();
            return bi_常量类.f6358b;
        } catch (Throwable e2222) {
            ae.m4671a(e2222, "CInfo", "AESData");
            e2222.printStackTrace();
            return bi_常量类.f6358b;
        } catch (Throwable e22222) {
            ae.m4671a(e22222, "CInfo", "AESData");
            e22222.printStackTrace();
            return bi_常量类.f6358b;
        } catch (Throwable e222222) {
            ae.m4671a(e222222, "CInfo", "AESData");
            e222222.printStackTrace();
            return bi_常量类.f6358b;
        } catch (Throwable e2222222) {
            ae.m4671a(e2222222, "CInfo", "AESData");
            e2222222.printStackTrace();
            return bi_常量类.f6358b;
        } catch (Throwable e22222222) {
            ae.m4671a(e22222222, "CInfo", "AESData");
            e22222222.printStackTrace();
            return bi_常量类.f6358b;
        }
    }

    /* renamed from: a */
    public static String m4875a(Context context, C0629p c0629p) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append("\"sim\":\"").append(C0623l.m4902q(context)).append("\",\"av\":\"").append(c0629p.f3837a).append("\",\"pro\":\"").append(c0629p.f3839c).append("\",\"ed\":\"").append(c0629p.m4941d()).append("\",\"nt\":\"").append(C0623l.m4896k(context)).append("\",\"np\":\"").append(C0623l.m4901p(context)).append("\",\"mnc\":\"").append(C0623l.m4890e(context)).append("\",\"lnt\":\"").append(C0623l.m4891f(context)).append("\",\"ant\":\"").append(C0623l.m4893h(context)).append("\"");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return stringBuilder.toString();
    }

    /* renamed from: b */
    private static String m4879b(Context context, C0629p c0629p, Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            String m = C0623l.m4898m(context);
            stringBuilder.append("ct=android");
            stringBuilder.append("&ime=").append(m);
            stringBuilder.append("&pkg=").append(C0619i.m4863b(context));
            stringBuilder.append("&mod=");
            stringBuilder.append(Build.MODEL);
            stringBuilder.append("&apn=").append(C0619i.m4862a(context));
            stringBuilder.append("&apv=").append(C0619i.m4864c(context));
            stringBuilder.append("&sv=");
            stringBuilder.append(VERSION.RELEASE);
            stringBuilder.append("&sim=").append(C0623l.m4899n(context));
            stringBuilder.append("&av=").append(c0629p.f3837a);
            stringBuilder.append("&pro=").append(c0629p.f3839c);
            stringBuilder.append("&cid=").append(C0623l.m4889d(context));
            stringBuilder.append("&dmac=").append(C0623l.m4888c(context));
            stringBuilder.append("&wmac=").append(C0623l.m4887b(context));
            stringBuilder.append("&nt=");
            stringBuilder.append(C0623l.m4897l(context));
            m = C0623l.m4900o(context);
            stringBuilder.append("&np=");
            stringBuilder.append(m);
            stringBuilder.append("&ia=1&");
            m = C0623l.m4882a(context);
            if (m == null) {
                m = bi_常量类.f6358b;
            }
            stringBuilder.append("utd=").append(m).append("&");
            m = C0619i.m4867f(context);
            if (m != null && m.length() > 0) {
                stringBuilder.append("key=");
                stringBuilder.append(m);
                stringBuilder.append("&");
            }
            stringBuilder.append("ctm=" + System.currentTimeMillis());
            stringBuilder.append("&re=" + C0623l.m4895j(context));
            if (map != null) {
                for (Entry entry : map.entrySet()) {
                    stringBuilder.append("&").append((String) entry.getKey()).append("=").append((String) entry.getValue());
                }
            }
        } catch (Throwable th) {
            ae.m4671a(th, "CInfo", "InitXInfo");
            th.printStackTrace();
        }
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public static String m4874a() {
        String str;
        Throwable th;
        Throwable th2;
        String str2 = null;
        try {
            str2 = String.valueOf(System.currentTimeMillis());
            try {
                str = C0108a.f262e;
                int length = str2.length();
                str = str2.substring(0, length - 2) + str + str2.substring(length - 1);
            } catch (Throwable th3) {
                th = th3;
                str = str2;
                th2 = th;
                ae.m4671a(th2, "CInfo", "getTS");
                th2.printStackTrace();
                return str;
            }
        } catch (Throwable th32) {
            th = th32;
            str = str2;
            th2 = th;
            ae.m4671a(th2, "CInfo", "getTS");
            th2.printStackTrace();
            return str;
        }
        return str;
    }

    /* renamed from: a */
    public static String m4877a(Context context, String str, String str2) {
        String str3 = null;
        try {
            str3 = C0625n.m4917a(C0619i.m4865d(context) + ":" + str.substring(0, str.length() - 3) + ":" + str2);
        } catch (Throwable th) {
            ae.m4671a(th, "CInfo", "Scode");
            th.printStackTrace();
        }
        return str3;
    }
}
