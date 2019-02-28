package com.amap.api.mapcore.util;

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
/* renamed from: com.amap.api.mapcore.util.y */
public class C0409y {
    /* renamed from: a */
    public static String m3505a(Context context, ad adVar, Map<String, String> map) {
        String str = null;
        try {
            String b = C0409y.m3508b(context, adVar, map);
            if (!bi_常量类.f6358b_空串.equals(b)) {
                str = C0409y.m3509b(context, b.getBytes("utf-8"));
            }
        } catch (Throwable e) {
            az.m3143a(e, "CInfo", "rsaInfo");
            e.printStackTrace();
        }
        return str;
    }

    /* renamed from: c */
    private static String m3510c(Context context, byte[] bArr) throws InvalidKeyException, IOException, InvalidKeySpecException, NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, CertificateException {
        KeyGenerator instance = KeyGenerator.getInstance("AES");
        if (instance == null) {
            return null;
        }
        instance.init(256);
        byte[] encoded = instance.generateKey().getEncoded();
        Key a = ae.m3040a(context);
        if (a == null) {
            return null;
        }
        Object a2 = aa.m3004a(encoded, a);
        Object a3 = aa.m3005a(encoded, bArr);
        byte[] bArr2 = new byte[(a2.length + a3.length)];
        System.arraycopy(a2, 0, bArr2, 0, a2.length);
        System.arraycopy(a3, 0, bArr2, a2.length, a3.length);
        byte[] a4 = ae.m3041a(bArr2);
        if (a4 != null) {
            return aa.m3003a(a4);
        }
        return bi_常量类.f6358b_空串;
    }

    /* renamed from: a */
    public static String m3507a(Context context, byte[] bArr) {
        try {
            return C0409y.m3510c(context, bArr);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
            return bi_常量类.f6358b_空串;
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return bi_常量类.f6358b_空串;
        } catch (NoSuchPaddingException e3) {
            e3.printStackTrace();
            return bi_常量类.f6358b_空串;
        } catch (IllegalBlockSizeException e4) {
            e4.printStackTrace();
            return bi_常量类.f6358b_空串;
        } catch (BadPaddingException e5) {
            e5.printStackTrace();
            return bi_常量类.f6358b_空串;
        } catch (InvalidKeySpecException e6) {
            e6.printStackTrace();
            return bi_常量类.f6358b_空串;
        } catch (CertificateException e7) {
            e7.printStackTrace();
            return bi_常量类.f6358b_空串;
        } catch (IOException e8) {
            e8.printStackTrace();
            return bi_常量类.f6358b_空串;
        } catch (Throwable th) {
            th.printStackTrace();
            return bi_常量类.f6358b_空串;
        }
    }

    /* renamed from: b */
    public static String m3509b(Context context, byte[] bArr) {
        try {
            return C0409y.m3510c(context, bArr);
        } catch (Throwable e) {
            az.m3143a(e, "CInfo", "AESData");
            e.printStackTrace();
            return bi_常量类.f6358b_空串;
        } catch (Throwable e2) {
            az.m3143a(e2, "CInfo", "AESData");
            e2.printStackTrace();
            return bi_常量类.f6358b_空串;
        } catch (Throwable e22) {
            az.m3143a(e22, "CInfo", "AESData");
            e22.printStackTrace();
            return bi_常量类.f6358b_空串;
        } catch (Throwable e222) {
            az.m3143a(e222, "CInfo", "AESData");
            e222.printStackTrace();
            return bi_常量类.f6358b_空串;
        } catch (Throwable e2222) {
            az.m3143a(e2222, "CInfo", "AESData");
            e2222.printStackTrace();
            return bi_常量类.f6358b_空串;
        } catch (Throwable e22222) {
            az.m3143a(e22222, "CInfo", "AESData");
            e22222.printStackTrace();
            return bi_常量类.f6358b_空串;
        } catch (Throwable e222222) {
            az.m3143a(e222222, "CInfo", "AESData");
            e222222.printStackTrace();
            return bi_常量类.f6358b_空串;
        } catch (Throwable e2222222) {
            az.m3143a(e2222222, "CInfo", "AESData");
            e2222222.printStackTrace();
            return bi_常量类.f6358b_空串;
        } catch (Throwable e22222222) {
            az.m3143a(e22222222, "CInfo", "AESData");
            e22222222.printStackTrace();
            return bi_常量类.f6358b_空串;
        }
    }

    /* renamed from: a */
    public static String m3504a(Context context, ad adVar) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append("\"sim\":\"").append(C0411z.m3531q(context)).append("\",\"av\":\"").append(adVar.f1925a).append("\",\"pro\":\"").append(adVar.f1927c).append("\",\"ed\":\"").append(adVar.m3036d()).append("\",\"nt\":\"").append(C0411z.m3525k(context)).append("\",\"np\":\"").append(C0411z.m3530p(context)).append("\",\"mnc\":\"").append(C0411z.m3519e(context)).append("\",\"lnt\":\"").append(C0411z.m3520f(context)).append("\",\"ant\":\"").append(C0411z.m3522h(context)).append("\"");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public static String m3503a(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append("\"key\":\"").append(C0407w.m3495f(context)).append("\",\"ct\":\"android\",\"ime\":\"").append(C0411z.m3527m(context)).append("\",\"pkg\":\"").append(C0407w.m3491b(context)).append("\",\"mod\":\"").append(Build.MODEL).append("\",\"apn\":\"").append(C0407w.m3489a(context)).append("\",\"apv\":\"").append(C0407w.m3492c(context)).append("\",\"sv\":\"").append(VERSION.RELEASE).append("\",");
        } catch (Throwable th) {
            az.m3143a(th, "CInfo", "getPublicJSONInfo");
            th.printStackTrace();
        }
        return stringBuilder.toString();
    }

    /* renamed from: b */
    private static String m3508b(Context context, ad adVar, Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            String m = C0411z.m3527m(context);
            stringBuilder.append("ct=android");
            stringBuilder.append("&ime=").append(m);
            stringBuilder.append("&pkg=").append(C0407w.m3491b(context));
            stringBuilder.append("&mod=");
            stringBuilder.append(Build.MODEL);
            stringBuilder.append("&apn=").append(C0407w.m3489a(context));
            stringBuilder.append("&apv=").append(C0407w.m3492c(context));
            stringBuilder.append("&sv=");
            stringBuilder.append(VERSION.RELEASE);
            stringBuilder.append("&sim=").append(C0411z.m3528n(context));
            stringBuilder.append("&av=").append(adVar.f1925a);
            stringBuilder.append("&pro=").append(adVar.f1927c);
            stringBuilder.append("&cid=").append(C0411z.m3518d(context));
            stringBuilder.append("&dmac=").append(C0411z.m3517c(context));
            stringBuilder.append("&wmac=").append(C0411z.m3516b(context));
            stringBuilder.append("&nt=");
            stringBuilder.append(C0411z.m3526l(context));
            m = C0411z.m3529o(context);
            stringBuilder.append("&np=");
            stringBuilder.append(m);
            stringBuilder.append("&ia=1&");
            m = C0411z.m3511a(context);
            if (m == null) {
                m = bi_常量类.f6358b_空串;
            }
            stringBuilder.append("utd=").append(m).append("&");
            m = C0407w.m3495f(context);
            if (m != null && m.length() > 0) {
                stringBuilder.append("key=");
                stringBuilder.append(m);
                stringBuilder.append("&");
            }
            stringBuilder.append("ctm=" + System.currentTimeMillis());
            stringBuilder.append("&re=" + C0411z.m3524j(context));
            if (map != null) {
                for (Entry entry : map.entrySet()) {
                    stringBuilder.append("&").append((String) entry.getKey()).append("=").append((String) entry.getValue());
                }
            }
        } catch (Throwable th) {
            az.m3143a(th, "CInfo", "InitXInfo");
            th.printStackTrace();
        }
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public static String m3502a() {
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
                az.m3143a(th2, "CInfo", "getTS");
                th2.printStackTrace();
                return str;
            }
        } catch (Throwable th32) {
            th = th32;
            str = str2;
            th2 = th;
            az.m3143a(th2, "CInfo", "getTS");
            th2.printStackTrace();
            return str;
        }
        return str;
    }

    /* renamed from: a */
    public static String m3506a(Context context, String str, String str2) {
        String str3 = null;
        try {
            str3 = ab.m3010a(C0407w.m3493d(context) + ":" + str.substring(0, str.length() - 3) + ":" + str2);
        } catch (Throwable th) {
            az.m3143a(th, "CInfo", "Scode");
            th.printStackTrace();
        }
        return str3;
    }
}
