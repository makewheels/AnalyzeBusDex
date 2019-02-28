package com.amap.api.location.core;

import android.content.Context;
import android.util.Log;
import com.aps.C0569l;
import java.util.Arrays;
import org.json.JSONObject;
import p054u.aly.bi_常量类;

/* compiled from: AuthManager */
/* renamed from: com.amap.api.location.core.a */
public class C0282a {
    /* renamed from: a */
    static String f1292a = bi_常量类.f6358b;
    /* renamed from: b */
    private static int f1293b = -1;

    /* renamed from: a */
    public static int m1814a() {
        return f1293b;
    }

    /* renamed from: a */
    public static synchronized boolean m1816a(Context context) {
        boolean c;
        synchronized (C0282a.class) {
            try {
                byte[] c2 = C0282a.m1820c();
                String a = C0569l.m4533a().m4540a(context, C0282a.m1817b(), c2, "loc");
                if (a != null) {
                    c = C0282a.m1819c(a);
                } else {
                    f1293b = 0;
                    c = true;
                }
                if (f1293b != 1) {
                    f1293b = 0;
                }
            } catch (Throwable th) {
                if (f1293b != 1) {
                    f1293b = 0;
                }
            }
        }
        return c;
    }

    /* renamed from: b */
    private static String m1817b() {
        return "http://apiinit.amap.com/v3/log/init";
    }

    /* renamed from: c */
    private static boolean m1819c(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("status")) {
                int i = jSONObject.getInt("status");
                if (i == 1) {
                    f1293b = 1;
                } else if (i == 0) {
                    f1293b = 0;
                }
            }
            if (jSONObject.has("info")) {
                f1292a = jSONObject.getString("info");
            }
            if (f1293b == 0) {
                Log.i("AuthFailure", f1292a);
            }
        } catch (Exception e) {
            e.printStackTrace();
            f1293b = 0;
        }
        if (f1293b == 1) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    private static byte[] m1820c() {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("resType=json&encode=UTF-8&ec=1");
            return C0282a.m1818b(C0282a.m1815a(stringBuffer.toString())).toString().getBytes("UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static String m1815a(String str) {
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
    public static String m1818b(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        String a = C0285d.m1841a();
        stringBuffer.append("&ts=" + a);
        stringBuffer.append("&scode=" + C0285d.m1842a(a, str));
        return stringBuffer.toString();
    }
}
