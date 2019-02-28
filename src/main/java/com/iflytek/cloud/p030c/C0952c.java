package com.iflytek.cloud.p030c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.alipay.sdk.cons.C0108a;
import com.iflytek.cloud.Setting;
import com.iflytek.cloud.Setting.LOG_LEVEL;
import com.iflytek.cloud.Version;
import com.iflytek.cloud.p022a.C0913a;
import com.iflytek.cloud.p023b.p024e.C0942a;
import com.iflytek.cloud.p023b.p024e.C0945d;
import com.iflytek.cloud.p023b.p024e.C0949h;
import com.iflytek.cloud.p023b.p025b.C0923a;
import com.iflytek.cloud.p023b.p026a.C0921a;
import com.iflytek.cloud.speech.ErrorCode;
import com.iflytek.cloud.speech.SpeechConstant;
import com.iflytek.cloud.speech.SpeechError;
import com.iflytek.cloud.speech.SpeechUser;
import p054u.aly.bi_常量类;

/* renamed from: com.iflytek.cloud.c.c */
public class C0952c {
    /* renamed from: a */
    private static String f4503a = "xiaoyan";
    /* renamed from: b */
    private static int f4504b = 50;
    /* renamed from: c */
    private static int f4505c = 50;
    /* renamed from: d */
    private static int f4506d = 50;

    /* renamed from: a */
    public static String m7181a() {
        return SpeechUser.getUser().getInitParam().m7179d(SpeechConstant.APPID);
    }

    /* renamed from: a */
    public static String m7182a(int i) {
        return i >= 100 ? "10" : i <= 0 ? "0" : bi_常量类.f6358b_空串 + (i / 10);
    }

    /* renamed from: a */
    public static String m7183a(Context context) {
        if (context == null) {
            return "null";
        }
        C0950a a = C0942a.m7128a(context);
        String str = a.m7179d("os.imsi") + "|" + a.m7179d("os.imei");
        if (str.length() < 10) {
            str = a.m7179d("net.mac");
        }
        return (TextUtils.isEmpty(str) || str.length() <= 0) ? null : str;
    }

    /* renamed from: a */
    public static String m7184a(Context context, C0923a c0923a) throws SpeechError {
        if (context == null) {
            throw new SpeechError((int) ErrorCode.ERROR_INVALID_PARAM);
        }
        C0950a w = c0923a.m7049w();
        C0952c.m7186a(context, w);
        w.m7171a(SpeechConstant.NET_TIMEOUT, "20000", false);
        w.m7171a("auth", C0108a.f262e, false);
        w.m7170a("msc.ver", Version.getVersion());
        C0950a a = C0942a.m7128a(context);
        w.m7171a("mac", a.m7179d("net.mac"), false);
        w.m7171a("dvc", C0952c.m7183a(context), false);
        w.m7171a("msc.lat", bi_常量类.f6358b_空串 + C0913a.m6973a(context).m6976a("msc.lat"), false);
        w.m7171a("msc.lng", bi_常量类.f6358b_空串 + C0913a.m6973a(context).m6976a("msc.lng"), false);
        w.m7168a(a, "app.name");
        w.m7168a(a, "app.path");
        w.m7168a(a, "app.pkg");
        w.m7168a(a, "app.ver.name");
        w.m7168a(a, "app.ver.code");
        w.m7168a(a, "os.system");
        w.m7168a(a, "os.resolution");
        w.m7168a(a, "os.density");
        w.m7168a(a, "net.mac");
        w.m7168a(a, "os.imei");
        w.m7168a(a, "os.imsi");
        w.m7168a(a, "os.version");
        w.m7168a(a, "os.release");
        w.m7168a(a, "os.incremental");
        w.m7168a(a, C0942a.f4485a[0][0]);
        w.m7168a(a, C0942a.f4485a[1][0]);
        w.m7168a(a, C0942a.f4485a[2][0]);
        w.m7168a(a, C0942a.f4485a[3][0]);
        C0952c.m7191b(w);
        return w.toString();
    }

    /* renamed from: a */
    public static String m7185a(Context context, String str, C0923a c0923a) {
        C0950a w = c0923a.m7049w();
        C0952c.m7186a(context, w);
        w.m7171a("rst", "json", false);
        w.m7171a("rse", c0923a.m7044r(), false);
        w.m7171a("tte", c0923a.mo1578q(), false);
        w.m7171a("ssm", C0108a.f262e, false);
        if (TextUtils.isEmpty(str)) {
            w.m7171a("sub", "iat", false);
        } else {
            w.m7171a("sub", "asr", false);
        }
        int s = c0923a.m7045s();
        w.m7171a("auf=audio/L16;rate", Integer.toString(s), false);
        if (s == ErrorCode.MSP_ERROR_LMOD_BASE) {
            w.m7171a("aue", "speex-wb", false);
        } else {
            w.m7171a("aue", "speex", false);
        }
        if (c0923a.mo1574j()) {
            w.m7171a("vad_timeout", "5000", false);
            w.m7171a("vad_speech_tail", "1800", false);
            w.m7171a("eos", "1800", false);
        } else {
            w.m7171a("vad_timeout", "4000", false);
            w.m7171a("vad_speech_tail", "700", false);
            w.m7171a("eos", "700", false);
        }
        return w.toString();
    }

    /* renamed from: a */
    public static void m7186a(Context context, C0950a c0950a) {
        if (context == null) {
            c0950a.m7171a(SpeechConstant.WAP_PROXY, "none", false);
            return;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            c0950a.m7171a(SpeechConstant.WAP_PROXY, "none", false);
            return;
        }
        c0950a.m7171a(SpeechConstant.WAP_PROXY, C0949h.m7163a(activeNetworkInfo), false);
        c0950a.m7171a("net_subtype", C0949h.m7165b(activeNetworkInfo), false);
    }

    /* renamed from: a */
    public static boolean m7187a(C0950a c0950a) {
        return !c0950a.m7173a("net_enabled", true);
    }

    /* renamed from: a */
    public static boolean m7188a(String str) {
        return TextUtils.isEmpty(str) ? false : str.contains("sms") || str.contains("iat");
    }

    /* renamed from: b */
    public static String m7189b() {
        return C0921a.m7016e("md5");
    }

    /* renamed from: b */
    public static String m7190b(Context context, C0923a c0923a) {
        C0950a w = c0923a.m7049w();
        C0952c.m7186a(context, w);
        w.m7171a("ssm", C0108a.f262e, false);
        w.m7171a("rst", "json", false);
        w.m7171a("rse", c0923a.m7044r(), false);
        w.m7171a("tte", c0923a.mo1578q(), false);
        return w.toString();
    }

    /* renamed from: b */
    private static void m7191b(C0950a c0950a) {
        if (c0950a != null && Setting.f4359d != LOG_LEVEL.none) {
            String str = Setting.f4360e;
            if (TextUtils.isEmpty(str)) {
                str = "/sdcard/msc/msc.log";
            }
            int i = -1;
            if (Setting.f4359d == LOG_LEVEL.detail) {
                i = 31;
            } else if (Setting.f4359d == LOG_LEVEL.normal) {
                i = 15;
            } else if (Setting.f4359d == LOG_LEVEL.low) {
                i = 7;
            }
            C0945d.m7144c(str);
            c0950a.m7170a("log", str);
            c0950a.m7170a("lvl", bi_常量类.f6358b_空串 + i);
            c0950a.m7171a("output", C0108a.f262e, false);
        }
    }

    /* renamed from: c */
    public static String m7192c(Context context, C0923a c0923a) {
        C0950a w = c0923a.m7049w();
        C0952c.m7186a(context, w);
        w.m7172a(C0951b.f4502a);
        w.m7171a("ssm", C0108a.f262e, false);
        int s = c0923a.m7045s();
        w.m7170a("auf=audio/L16;rate", Integer.toString(s));
        if (s == ErrorCode.MSP_ERROR_LMOD_BASE) {
            w.m7171a("aue", "speex-wb", false);
        } else {
            w.m7171a("aue", "speex", false);
        }
        w.m7171a("vcn", w.m7175b("vcn", f4503a), true);
        w.m7171a("spd", C0952c.m7182a(w.m7166a("spd", f4504b)), true);
        w.m7171a("vol", C0952c.m7182a(w.m7166a("vol", f4506d)), true);
        w.m7171a("pit", C0952c.m7182a(w.m7166a("pit", f4505c)), true);
        w.m7171a("tte", c0923a.mo1578q(), false);
        return w.toString();
    }
}
