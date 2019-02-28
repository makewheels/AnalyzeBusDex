package com.tencent.smtt.sdk.p052b;

import android.net.NetworkInfo;
import android.net.Proxy;
import android.text.TextUtils;
import com.e4a.runtime.components.Component;
import p054u.aly.bi_常量类;

/* renamed from: com.tencent.smtt.sdk.b.a */
public class C1096a {
    /* renamed from: a */
    private static String f5003a = "Wlan";
    /* renamed from: b */
    private static String f5004b = bi_常量类.f6358b_空串;
    /* renamed from: c */
    private static int f5005c = 4;
    /* renamed from: d */
    private static int f5006d = 4;
    /* renamed from: e */
    private static C1095a f5007e = new C1095a();

    /* renamed from: com.tencent.smtt.sdk.b.a$a */
    private static class C1095a {
        /* renamed from: a */
        private String f4999a;
        /* renamed from: b */
        private int f5000b;
        /* renamed from: c */
        private byte f5001c;
        /* renamed from: d */
        private boolean f5002d;

        private C1095a() {
            this.f4999a = null;
            this.f5000b = 80;
            this.f5001c = (byte) 0;
            this.f5002d = false;
        }
    }

    /* renamed from: a */
    static synchronized int m7816a() {
        int a;
        synchronized (C1096a.class) {
            a = C1096a.m7817a(true);
        }
        return a;
    }

    /* renamed from: a */
    private static synchronized int m7817a(boolean z) {
        int i;
        synchronized (C1096a.class) {
            if (z) {
                C1096a.m7821c();
            }
            i = f5006d;
        }
        return i;
    }

    /* renamed from: a */
    static String m7818a(int i) {
        switch (i) {
            case 4:
                return "Wlan";
            case 8:
                return "cmwap";
            case 16:
                return "3gwap";
            case 32:
                return "uniwap";
            case Component.KEYCODE_EXPLORER /*64*/:
                return "ctwap";
            case 128:
                return "ctnet";
            case 256:
                return "uninet";
            case 512:
                return "3gnet";
            case 1024:
                return "cmnet";
            default:
                return "N/A";
        }
    }

    /* renamed from: b */
    public static boolean m7819b() {
        NetworkInfo d = C1096a.m7822d();
        return d != null && d.getType() == 1;
    }

    /* renamed from: b */
    private static boolean m7820b(int i) {
        return i == 2 || i == 0;
    }

    /* renamed from: c */
    private static void m7821c() {
        NetworkInfo d = C1096a.m7822d();
        int i = -1;
        try {
            f5005c = 0;
            f5006d = 0;
            String str = null;
            if (d != null) {
                i = d.getType();
                str = d.getExtraInfo();
                if (str == null) {
                    f5005c = 0;
                    f5006d = 0;
                } else {
                    str = str.trim().toLowerCase();
                }
            }
            if (i == 1) {
                f5005c = 4;
                f5006d = 4;
                f5007e.f5002d = false;
                f5004b = "Wlan-unknown";
                return;
            }
            if (str == null) {
                f5005c = 0;
                f5006d = 0;
            } else if (str.contains("cmwap")) {
                f5005c = 2;
                f5006d = 8;
            } else if (str.contains("uniwap")) {
                f5005c = 2;
                f5006d = 32;
            } else if (str.contains("3gwap")) {
                f5005c = 2;
                f5006d = 16;
            } else if (str.contains("ctwap")) {
                f5005c = 2;
                f5006d = 64;
            } else if (str.contains("cmnet")) {
                f5005c = 1;
                f5006d = 1024;
            } else if (str.contains("uninet")) {
                f5005c = 1;
                f5006d = 256;
            } else if (str.contains("3gnet")) {
                f5005c = 1;
                f5006d = 512;
            } else if (str.contains("ctnet")) {
                f5005c = 1;
                f5006d = 128;
            } else if (str.contains("#777")) {
                f5005c = 0;
                f5006d = 0;
            } else {
                f5005c = 0;
                f5006d = 0;
            }
            f5007e.f5002d = false;
            if (C1096a.m7820b(f5005c)) {
                f5007e.f4999a = Proxy.getDefaultHost();
                f5007e.f5000b = Proxy.getDefaultPort();
                if (f5007e.f4999a != null) {
                    f5007e.f4999a = f5007e.f4999a.trim();
                }
                if (TextUtils.isEmpty(f5007e.f4999a)) {
                    f5007e.f5002d = false;
                    f5005c = 1;
                    if (str != null && str.contains("#777")) {
                        f5006d = 128;
                    }
                } else {
                    f5007e.f5002d = true;
                    f5005c = 2;
                    if ("10.0.0.200".equals(f5007e.f4999a)) {
                        f5007e.f5001c = (byte) 1;
                        f5006d = 64;
                    } else {
                        f5007e.f5001c = (byte) 0;
                    }
                }
            }
            f5004b = C1096a.m7818a(f5006d) + "-" + (d != null ? d.getSubtypeName() : "unknown");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: d */
    private static NetworkInfo m7822d() {
        try {
            return C1097b.m7823a().getActiveNetworkInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
