package com.tencent.wxop.stat;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.p041a.p042a.p043a.p044a.C1042g;
import com.tencent.wxop.stat.common.C1192k;
import com.tencent.wxop.stat.common.C1197p;
import com.tencent.wxop.stat.common.C1198q;
import com.tencent.wxop.stat.common.StatConstants;
import com.tencent.wxop.stat.common.StatLogger;
import java.net.URI;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import p054u.aly.bi_常量类;

public class StatConfig {
    /* renamed from: A */
    private static String f5209A = null;
    /* renamed from: B */
    private static String f5210B;
    /* renamed from: C */
    private static String f5211C;
    /* renamed from: D */
    private static String f5212D = "mta_channel";
    /* renamed from: E */
    private static int f5213E = 180;
    /* renamed from: F */
    private static int f5214F = 1024;
    /* renamed from: G */
    private static long f5215G = 0;
    /* renamed from: H */
    private static long f5216H = 300000;
    /* renamed from: I */
    private static volatile String f5217I = StatConstants.MTA_REPORT_FULL_URL;
    /* renamed from: J */
    private static int f5218J = 0;
    /* renamed from: K */
    private static volatile int f5219K = 0;
    /* renamed from: L */
    private static int f5220L = 20;
    /* renamed from: M */
    private static int f5221M = 0;
    /* renamed from: N */
    private static boolean f5222N = false;
    /* renamed from: O */
    private static int f5223O = 4096;
    /* renamed from: P */
    private static boolean f5224P = false;
    /* renamed from: Q */
    private static String f5225Q = null;
    /* renamed from: R */
    private static boolean f5226R = false;
    /* renamed from: S */
    private static C1203g f5227S = null;
    /* renamed from: a */
    static C1202f f5228a = new C1202f(2);
    /* renamed from: b */
    static C1202f f5229b = new C1202f(1);
    /* renamed from: c */
    static String f5230c = "__HIBERNATE__";
    /* renamed from: d */
    static String f5231d = "__HIBERNATE__TIME";
    /* renamed from: e */
    static String f5232e = "__MTA_KILL__";
    /* renamed from: f */
    static String f5233f = bi_常量类.f6358b;
    /* renamed from: g */
    static boolean f5234g = false;
    /* renamed from: h */
    static int f5235h = 100;
    /* renamed from: i */
    static long f5236i = 10000;
    public static boolean isAutoExceptionCaught = true;
    /* renamed from: j */
    static boolean f5237j = true;
    /* renamed from: k */
    static volatile String f5238k = StatConstants.MTA_SERVER;
    /* renamed from: l */
    static boolean f5239l = true;
    /* renamed from: m */
    static int f5240m = 0;
    /* renamed from: n */
    static long f5241n = 10000;
    /* renamed from: o */
    static int f5242o = 512;
    /* renamed from: p */
    private static StatLogger f5243p = C1192k.m8283b();
    /* renamed from: q */
    private static StatReportStrategy f5244q = StatReportStrategy.APP_LAUNCH;
    /* renamed from: r */
    private static boolean f5245r = false;
    /* renamed from: s */
    private static boolean f5246s = true;
    /* renamed from: t */
    private static int f5247t = 30000;
    /* renamed from: u */
    private static int f5248u = 100000;
    /* renamed from: v */
    private static int f5249v = 30;
    /* renamed from: w */
    private static int f5250w = 10;
    /* renamed from: x */
    private static int f5251x = 100;
    /* renamed from: y */
    private static int f5252y = 30;
    /* renamed from: z */
    private static int f5253z = 1;

    /* renamed from: a */
    static int m8086a() {
        return f5249v;
    }

    /* renamed from: a */
    static String m8087a(Context context) {
        return C1198q.m8329a(C1197p.m8324a(context, "_mta_ky_tag_", null));
    }

    /* renamed from: a */
    static String m8088a(String str, String str2) {
        try {
            String string = f5229b.f5512b.getString(str);
            return string != null ? string : str2;
        } catch (Throwable th) {
            f5243p.m8245w("can't find custom key:" + str);
            return str2;
        }
    }

    /* renamed from: a */
    static synchronized void m8089a(int i) {
        synchronized (StatConfig.class) {
            f5219K = i;
        }
    }

    /* renamed from: a */
    static void m8090a(long j) {
        C1197p.m8326b(C1204i.m8350a(), f5230c, j);
        setEnableStatService(false);
        f5243p.warn("MTA is disable for current SDK version");
    }

    /* renamed from: a */
    static void m8091a(Context context, C1202f c1202f) {
        if (c1202f.f5511a == f5229b.f5511a) {
            f5229b = c1202f;
            m8095a(c1202f.f5512b);
            if (!f5229b.f5512b.isNull("iplist")) {
                C1178a.m8165a(context).m8173a(f5229b.f5512b.getString("iplist"));
            }
        } else if (c1202f.f5511a == f5228a.f5511a) {
            f5228a = c1202f;
        }
    }

    /* renamed from: a */
    static void m8092a(Context context, C1202f c1202f, JSONObject jSONObject) {
        Object obj = null;
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                if (str.equalsIgnoreCase("v")) {
                    int i = jSONObject.getInt(str);
                    Object obj2 = c1202f.f5514d != i ? 1 : obj;
                    c1202f.f5514d = i;
                    obj = obj2;
                } else if (str.equalsIgnoreCase("c")) {
                    str = jSONObject.getString("c");
                    if (str.length() > 0) {
                        c1202f.f5512b = new JSONObject(str);
                    }
                } else if (str.equalsIgnoreCase("m")) {
                    c1202f.f5513c = jSONObject.getString("m");
                }
            }
            if (obj == 1) {
                au a = au.m8199a(C1204i.m8350a());
                if (a != null) {
                    a.m8229a(c1202f);
                }
                if (c1202f.f5511a == f5229b.f5511a) {
                    m8095a(c1202f.f5512b);
                    m8102b(c1202f.f5512b);
                }
            }
            m8091a(context, c1202f);
        } catch (Throwable e) {
            f5243p.m8242e(e);
        } catch (Throwable e2) {
            f5243p.m8242e(e2);
        }
    }

    /* renamed from: a */
    static void m8093a(Context context, String str) {
        if (str != null) {
            C1197p.m8327b(context, "_mta_ky_tag_", C1198q.m8334b(str));
        }
    }

    /* renamed from: a */
    static void m8094a(Context context, JSONObject jSONObject) {
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                if (str.equalsIgnoreCase(Integer.toString(f5229b.f5511a))) {
                    m8092a(context, f5229b, jSONObject.getJSONObject(str));
                } else if (str.equalsIgnoreCase(Integer.toString(f5228a.f5511a))) {
                    m8092a(context, f5228a, jSONObject.getJSONObject(str));
                } else if (str.equalsIgnoreCase("rs")) {
                    StatReportStrategy statReportStrategy = StatReportStrategy.getStatReportStrategy(jSONObject.getInt(str));
                    if (statReportStrategy != null) {
                        f5244q = statReportStrategy;
                        if (isDebugEnable()) {
                            f5243p.m8240d("Change to ReportStrategy:" + statReportStrategy.name());
                        }
                    }
                } else {
                    return;
                }
            }
        } catch (Throwable e) {
            f5243p.m8242e(e);
        }
    }

    /* renamed from: a */
    static void m8095a(JSONObject jSONObject) {
        try {
            StatReportStrategy statReportStrategy = StatReportStrategy.getStatReportStrategy(jSONObject.getInt("rs"));
            if (statReportStrategy != null) {
                setStatSendStrategy(statReportStrategy);
            }
        } catch (JSONException e) {
            if (isDebugEnable()) {
                f5243p.m8243i("rs not found.");
            }
        }
    }

    /* renamed from: a */
    static boolean m8096a(int i, int i2, int i3) {
        return i >= i2 && i <= i3;
    }

    /* renamed from: a */
    private static boolean m8097a(String str) {
        if (str == null) {
            return false;
        }
        if (f5210B == null) {
            f5210B = str;
            return true;
        } else if (f5210B.contains(str)) {
            return false;
        } else {
            f5210B += "|" + str;
            return true;
        }
    }

    /* renamed from: a */
    static boolean m8098a(JSONObject jSONObject, String str, String str2) {
        if (!jSONObject.isNull(str)) {
            String optString = jSONObject.optString(str);
            if (C1192k.m8287c(str2) && C1192k.m8287c(optString) && str2.equalsIgnoreCase(optString)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    static void m8099b() {
        f5221M++;
    }

    /* renamed from: b */
    static void m8100b(int i) {
        if (i >= 0) {
            f5221M = i;
        }
    }

    /* renamed from: b */
    static void m8101b(Context context, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString(f5232e);
            if (C1192k.m8287c(optString)) {
                JSONObject jSONObject2 = new JSONObject(optString);
                if (jSONObject2.length() != 0) {
                    Object obj;
                    if (!jSONObject2.isNull("sm")) {
                        obj = jSONObject2.get("sm");
                        int intValue = obj instanceof Integer ? ((Integer) obj).intValue() : obj instanceof String ? Integer.valueOf((String) obj).intValue() : 0;
                        if (intValue > 0) {
                            if (isDebugEnable()) {
                                f5243p.m8243i("match sleepTime:" + intValue + " minutes");
                            }
                            C1197p.m8326b(context, f5231d, System.currentTimeMillis() + ((long) ((intValue * 60) * 1000)));
                            setEnableStatService(false);
                            f5243p.warn("MTA is disable for current SDK version");
                        }
                    }
                    if (m8098a(jSONObject2, "sv", StatConstants.VERSION)) {
                        f5243p.m8243i("match sdk version:2.0.3");
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (m8098a(jSONObject2, "md", Build.MODEL)) {
                        f5243p.m8243i("match MODEL:" + Build.MODEL);
                        obj = 1;
                    }
                    if (m8098a(jSONObject2, "av", C1192k.m8299j(context))) {
                        f5243p.m8243i("match app version:" + C1192k.m8299j(context));
                        obj = 1;
                    }
                    if (m8098a(jSONObject2, "mf", Build.MANUFACTURER)) {
                        f5243p.m8243i("match MANUFACTURER:" + Build.MANUFACTURER);
                        obj = 1;
                    }
                    if (m8098a(jSONObject2, "osv", VERSION.SDK_INT)) {
                        f5243p.m8243i("match android SDK version:" + VERSION.SDK_INT);
                        obj = 1;
                    }
                    if (m8098a(jSONObject2, "ov", VERSION.SDK_INT)) {
                        f5243p.m8243i("match android SDK version:" + VERSION.SDK_INT);
                        obj = 1;
                    }
                    if (m8098a(jSONObject2, "ui", au.m8199a(context).m8232b(context).m8248b())) {
                        f5243p.m8243i("match imei:" + au.m8199a(context).m8232b(context).m8248b());
                        obj = 1;
                    }
                    if (m8098a(jSONObject2, "mid", getLocalMidOnly(context))) {
                        f5243p.m8243i("match mid:" + getLocalMidOnly(context));
                        obj = 1;
                    }
                    if (obj != null) {
                        m8090a(C1192k.m8282b(StatConstants.VERSION));
                    }
                }
            }
        } catch (Throwable e) {
            f5243p.m8242e(e);
        }
    }

    /* renamed from: b */
    static void m8102b(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() != 0) {
            try {
                m8101b(C1204i.m8350a(), jSONObject);
                String string = jSONObject.getString(f5230c);
                if (isDebugEnable()) {
                    f5243p.m8240d("hibernateVer:" + string + ", current version:2.0.3");
                }
                long b = C1192k.m8282b(string);
                if (C1192k.m8282b(StatConstants.VERSION) <= b) {
                    m8090a(b);
                }
            } catch (JSONException e) {
                f5243p.m8240d("__HIBERNATE__ not found.");
            }
        }
    }

    /* renamed from: c */
    static int m8103c() {
        return f5221M;
    }

    public static synchronized String getAppKey(Context context) {
        String str;
        synchronized (StatConfig.class) {
            if (f5210B != null) {
                str = f5210B;
            } else {
                if (context != null) {
                    if (f5210B == null) {
                        f5210B = C1192k.m8293f(context);
                    }
                }
                if (f5210B == null || f5210B.trim().length() == 0) {
                    f5243p.error((Object) "AppKey can not be null or empty, please read Developer's Guide first!");
                }
                str = f5210B;
            }
        }
        return str;
    }

    public static int getCurSessionStatReportCount() {
        return f5219K;
    }

    public static C1203g getCustomLogger() {
        return f5227S;
    }

    public static String getCustomProperty(String str) {
        try {
            return f5228a.f5512b.getString(str);
        } catch (Throwable th) {
            f5243p.m8242e(th);
            return null;
        }
    }

    public static String getCustomProperty(String str, String str2) {
        try {
            String string = f5228a.f5512b.getString(str);
            return string != null ? string : str2;
        } catch (Throwable th) {
            f5243p.m8242e(th);
            return str2;
        }
    }

    public static String getCustomUserId(Context context) {
        if (context == null) {
            f5243p.error((Object) "Context for getCustomUid is null.");
            return null;
        }
        if (f5225Q == null) {
            f5225Q = C1197p.m8324a(context, "MTA_CUSTOM_UID", bi_常量类.f6358b);
        }
        return f5225Q;
    }

    public static long getFlushDBSpaceMS() {
        return f5241n;
    }

    public static synchronized String getInstallChannel(Context context) {
        String str;
        synchronized (StatConfig.class) {
            if (f5211C != null) {
                str = f5211C;
            } else {
                str = C1197p.m8324a(context, f5212D, bi_常量类.f6358b);
                f5211C = str;
                if (str == null || f5211C.trim().length() == 0) {
                    f5211C = C1192k.m8294g(context);
                }
                if (f5211C == null || f5211C.trim().length() == 0) {
                    f5243p.m8245w("installChannel can not be null or empty, please read Developer's Guide first!");
                }
                str = f5211C;
            }
        }
        return str;
    }

    public static String getLocalMidOnly(Context context) {
        return context != null ? C1042g.m7491E(context).m7494p().m7484a() : "0";
    }

    public static int getMaxBatchReportCount() {
        return f5252y;
    }

    public static int getMaxDaySessionNumbers() {
        return f5220L;
    }

    public static int getMaxImportantDataSendRetryCount() {
        return f5251x;
    }

    public static int getMaxParallelTimmingEvents() {
        return f5214F;
    }

    public static int getMaxReportEventLength() {
        return f5223O;
    }

    public static int getMaxSendRetryCount() {
        return f5250w;
    }

    public static int getMaxSessionStatReportCount() {
        return f5218J;
    }

    public static int getMaxStoreEventCount() {
        return f5248u;
    }

    public static String getMid(Context context) {
        return getLocalMidOnly(context);
    }

    public static long getMsPeriodForMethodsCalledLimitClear() {
        return f5236i;
    }

    public static int getNumEventsCachedInMemory() {
        return f5240m;
    }

    public static int getNumEventsCommitPerSec() {
        return f5253z;
    }

    public static int getNumOfMethodsCalledLimit() {
        return f5235h;
    }

    public static String getQQ(Context context) {
        return C1197p.m8324a(context, "mta.acc.qq", f5233f);
    }

    public static int getReportCompressedSize() {
        return f5242o;
    }

    public static int getSendPeriodMinutes() {
        return f5213E;
    }

    public static int getSessionTimoutMillis() {
        return f5247t;
    }

    public static String getStatReportHost() {
        return f5238k;
    }

    public static String getStatReportUrl() {
        return f5217I;
    }

    public static StatReportStrategy getStatSendStrategy() {
        return f5244q;
    }

    public static boolean isAutoExceptionCaught() {
        return isAutoExceptionCaught;
    }

    public static boolean isDebugEnable() {
        return f5245r;
    }

    public static boolean isEnableConcurrentProcess() {
        return f5224P;
    }

    public static boolean isEnableSmartReporting() {
        return f5237j;
    }

    public static boolean isEnableStatService() {
        return f5246s;
    }

    public static boolean isReportEventsByOrder() {
        return f5239l;
    }

    public static boolean isXGProMode() {
        return f5226R;
    }

    public static void setAppKey(Context context, String str) {
        if (context == null) {
            f5243p.error((Object) "ctx in StatConfig.setAppKey() is null");
        } else if (str == null || str.length() > 256) {
            f5243p.error((Object) "appkey in StatConfig.setAppKey() is null or exceed 256 bytes");
        } else {
            if (f5210B == null) {
                f5210B = m8087a(context);
            }
            if ((m8097a(str) | m8097a(C1192k.m8293f(context))) != 0) {
                m8093a(context, f5210B);
            }
        }
    }

    public static void setAppKey(String str) {
        if (str == null) {
            f5243p.error((Object) "appkey in StatConfig.setAppKey() is null");
        } else if (str.length() > 256) {
            f5243p.error((Object) "The length of appkey cann't exceed 256 bytes.");
        } else {
            f5210B = str;
        }
    }

    public static void setAutoExceptionCaught(boolean z) {
        isAutoExceptionCaught = z;
    }

    public static void setCustomLogger(C1203g c1203g) {
        f5227S = c1203g;
    }

    public static void setCustomUserId(Context context, String str) {
        if (context == null) {
            f5243p.error((Object) "Context for setCustomUid is null.");
            return;
        }
        C1197p.m8327b(context, "MTA_CUSTOM_UID", str);
        f5225Q = str;
    }

    public static void setDebugEnable(boolean z) {
        f5245r = z;
        C1192k.m8283b().setDebugEnable(z);
    }

    public static void setEnableConcurrentProcess(boolean z) {
        f5224P = z;
    }

    public static void setEnableSmartReporting(boolean z) {
        f5237j = z;
    }

    public static void setEnableStatService(boolean z) {
        f5246s = z;
        if (!z) {
            f5243p.warn("!!!!!!MTA StatService has been disabled!!!!!!");
        }
    }

    public static void setFlushDBSpaceMS(long j) {
        if (j > 0) {
            f5241n = j;
        }
    }

    public static void setInstallChannel(Context context, String str) {
        if (str.length() > 128) {
            f5243p.error((Object) "the length of installChannel can not exceed the range of 128 bytes.");
            return;
        }
        f5211C = str;
        C1197p.m8327b(context, f5212D, str);
    }

    public static void setInstallChannel(String str) {
        if (str.length() > 128) {
            f5243p.error((Object) "the length of installChannel can not exceed the range of 128 bytes.");
        } else {
            f5211C = str;
        }
    }

    public static void setMaxBatchReportCount(int i) {
        if (m8096a(i, 2, 1000)) {
            f5252y = i;
        } else {
            f5243p.error((Object) "setMaxBatchReportCount can not exceed the range of [2,1000].");
        }
    }

    public static void setMaxDaySessionNumbers(int i) {
        if (i <= 0) {
            f5243p.m8241e((Object) "maxDaySessionNumbers must be greater than 0.");
        } else {
            f5220L = i;
        }
    }

    public static void setMaxImportantDataSendRetryCount(int i) {
        if (i > 100) {
            f5251x = i;
        }
    }

    public static void setMaxParallelTimmingEvents(int i) {
        if (m8096a(i, 1, 4096)) {
            f5214F = i;
        } else {
            f5243p.error((Object) "setMaxParallelTimmingEvents can not exceed the range of [1, 4096].");
        }
    }

    public static void setMaxReportEventLength(int i) {
        if (i <= 0) {
            f5243p.error((Object) "maxReportEventLength on setMaxReportEventLength() must greater than 0.");
        } else {
            f5223O = i;
        }
    }

    public static void setMaxSendRetryCount(int i) {
        if (m8096a(i, 1, 1000)) {
            f5250w = i;
        } else {
            f5243p.error((Object) "setMaxSendRetryCount can not exceed the range of [1,1000].");
        }
    }

    public static void setMaxSessionStatReportCount(int i) {
        if (i < 0) {
            f5243p.error((Object) "maxSessionStatReportCount cannot be less than 0.");
        } else {
            f5218J = i;
        }
    }

    public static void setMaxStoreEventCount(int i) {
        if (m8096a(i, 0, 500000)) {
            f5248u = i;
        } else {
            f5243p.error((Object) "setMaxStoreEventCount can not exceed the range of [0, 500000].");
        }
    }

    public static void setNumEventsCachedInMemory(int i) {
        if (i >= 0) {
            f5240m = i;
        }
    }

    public static void setNumEventsCommitPerSec(int i) {
        if (i > 0) {
            f5253z = i;
        }
    }

    public static void setNumOfMethodsCalledLimit(int i, long j) {
        f5235h = i;
        if (j >= 1000) {
            f5236i = j;
        }
    }

    public static void setQQ(Context context, String str) {
        C1197p.m8327b(context, "mta.acc.qq", str);
        f5233f = str;
    }

    public static void setReportCompressedSize(int i) {
        if (i > 0) {
            f5242o = i;
        }
    }

    public static void setReportEventsByOrder(boolean z) {
        f5239l = z;
    }

    public static void setSendPeriodMinutes(int i) {
        if (m8096a(i, 1, 10080)) {
            f5213E = i;
        } else {
            f5243p.error((Object) "setSendPeriodMinutes can not exceed the range of [1, 7*24*60] minutes.");
        }
    }

    public static void setSessionTimoutMillis(int i) {
        if (m8096a(i, 1000, 86400000)) {
            f5247t = i;
        } else {
            f5243p.error((Object) "setSessionTimoutMillis can not exceed the range of [1000, 24 * 60 * 60 * 1000].");
        }
    }

    public static void setStatReportUrl(String str) {
        if (str == null || str.length() == 0) {
            f5243p.error((Object) "statReportUrl cannot be null or empty.");
            return;
        }
        f5217I = str;
        try {
            f5238k = new URI(f5217I).getHost();
        } catch (Exception e) {
            f5243p.m8245w(e);
        }
        if (isDebugEnable()) {
            f5243p.m8243i("url:" + f5217I + ", domain:" + f5238k);
        }
    }

    public static void setStatSendStrategy(StatReportStrategy statReportStrategy) {
        f5244q = statReportStrategy;
        if (statReportStrategy != StatReportStrategy.PERIOD) {
            StatServiceImpl.f5261c = 0;
        }
        if (isDebugEnable()) {
            f5243p.m8240d("Change to statSendStrategy: " + statReportStrategy);
        }
    }

    public static void setXGProMode(boolean z) {
        f5226R = z;
    }
}
