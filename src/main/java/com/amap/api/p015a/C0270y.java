package com.amap.api.p015a;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.alipay.sdk.cons.C0108a;
import com.amap.api.p015a.p016a.C0184e;
import com.amap.api.p015a.p016a.C0203p;
import com.tencent.smtt.sdk.WebView;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Locale;

/* compiled from: CoreUtil */
/* renamed from: com.amap.api.a.y */
public class C0270y {
    /* renamed from: a */
    static float[] f1192a = new float[9];
    /* renamed from: b */
    private static String f1193b = null;

    /* renamed from: a */
    public static Proxy m1734a(Context context) {
        try {
            Proxy proxy;
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                String host;
                int port;
                if (activeNetworkInfo.getType() == 1) {
                    host = android.net.Proxy.getHost(context);
                    port = android.net.Proxy.getPort(context);
                } else {
                    host = android.net.Proxy.getDefaultHost();
                    port = android.net.Proxy.getDefaultPort();
                }
                if (host != null) {
                    proxy = new Proxy(Type.HTTP, new InetSocketAddress(host, port));
                    return proxy;
                }
            }
            proxy = null;
            return proxy;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static long m1730a(double d) {
        return (long) (1000000.0d * d);
    }

    /* renamed from: a */
    public static double m1729a(long j) {
        return ((double) j) / 1000000.0d;
    }

    /* renamed from: b */
    public static String m1735b(Context context) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                String toUpperCase = Integer.toHexString(b & WebView.NORMAL_MODE_ALPHA).toUpperCase(Locale.US);
                if (toUpperCase.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(toUpperCase);
                stringBuffer.append(":");
            }
            return stringBuffer.toString();
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static String m1732a(String str) {
        String[] split = str.split("&");
        Arrays.sort(split);
        StringBuffer stringBuffer = new StringBuffer();
        for (String append : split) {
            stringBuffer.append(append);
            stringBuffer.append("&");
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2.length() > 1) {
            return (String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1);
        }
        return str;
    }

    /* renamed from: b */
    public static String m1736b(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        String a = C0270y.m1731a();
        stringBuffer.append("&ts=" + a);
        stringBuffer.append("&scode=" + C0270y.m1733a(a, str));
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public static String m1731a() {
        String valueOf = String.valueOf(System.currentTimeMillis());
        String str = C0108a.f262e;
        int length = valueOf.length();
        return valueOf.substring(0, length - 2) + str + valueOf.substring(length - 1);
    }

    /* renamed from: a */
    public static String m1733a(String str, String str2) {
        return C0203p.m789a(C0184e.m646a(null).m653a() + ":" + str.substring(0, str.length() - 3) + ":" + str2);
    }
}
