package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.C1183b;
import com.tencent.wxop.stat.common.C1186e;
import com.tencent.wxop.stat.common.C1192k;
import com.tencent.wxop.stat.common.C1197p;
import com.tencent.wxop.stat.common.StatConstants;
import com.tencent.wxop.stat.common.StatLogger;
import com.tencent.wxop.stat.p053a.C1167a;
import com.tencent.wxop.stat.p053a.C1169c;
import com.tencent.wxop.stat.p053a.C1174i;
import com.tencent.wxop.stat.p053a.C1177l;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
import p054u.aly.bi_常量类;

public class StatServiceImpl {
    /* renamed from: a */
    static volatile int f5259a = 0;
    /* renamed from: b */
    static volatile long f5260b = 0;
    /* renamed from: c */
    static volatile long f5261c = 0;
    /* renamed from: d */
    private static C1186e f5262d;
    /* renamed from: e */
    private static volatile Map<C1169c, Long> f5263e = new ConcurrentHashMap();
    /* renamed from: f */
    private static volatile Map<String, Properties> f5264f = new ConcurrentHashMap();
    /* renamed from: g */
    private static volatile Map<Integer, Integer> f5265g = new ConcurrentHashMap(10);
    /* renamed from: h */
    private static volatile long f5266h = 0;
    /* renamed from: i */
    private static volatile long f5267i = 0;
    /* renamed from: j */
    private static volatile long f5268j = 0;
    /* renamed from: k */
    private static String f5269k = bi_常量类.f6358b;
    /* renamed from: l */
    private static volatile int f5270l = 0;
    /* renamed from: m */
    private static volatile String f5271m = bi_常量类.f6358b;
    /* renamed from: n */
    private static volatile String f5272n = bi_常量类.f6358b;
    /* renamed from: o */
    private static Map<String, Long> f5273o = new ConcurrentHashMap();
    /* renamed from: p */
    private static Map<String, Long> f5274p = new ConcurrentHashMap();
    /* renamed from: q */
    private static StatLogger f5275q = C1192k.m8283b();
    /* renamed from: r */
    private static UncaughtExceptionHandler f5276r = null;
    /* renamed from: s */
    private static volatile boolean f5277s = true;
    /* renamed from: t */
    private static Context f5278t = null;

    /* renamed from: a */
    static int m8105a(Context context, boolean z, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        int i = 1;
        long currentTimeMillis = System.currentTimeMillis();
        if (!z || currentTimeMillis - f5267i < ((long) StatConfig.getSessionTimoutMillis())) {
            boolean z2 = false;
        } else {
            int i2 = 1;
        }
        f5267i = currentTimeMillis;
        if (f5268j == 0) {
            f5268j = C1192k.m8285c();
        }
        if (currentTimeMillis >= f5268j) {
            f5268j = C1192k.m8285c();
            if (au.m8199a(context).m8232b(context).m8250d() != 1) {
                au.m8199a(context).m8232b(context).m8247a(1);
            }
            StatConfig.m8100b(0);
            f5259a = 0;
            f5269k = C1192k.m8274a(0);
            i2 = 1;
        }
        Object obj = f5269k;
        if (C1192k.m8280a(statSpecifyReportedInfo)) {
            obj = statSpecifyReportedInfo.getAppKey() + f5269k;
        }
        if (f5274p.containsKey(obj)) {
            i = i2;
        }
        if (i != 0) {
            if (C1192k.m8280a(statSpecifyReportedInfo)) {
                m8110a(context, statSpecifyReportedInfo);
            } else if (StatConfig.m8103c() < StatConfig.getMaxDaySessionNumbers()) {
                C1192k.m8313x(context);
                m8110a(context, null);
            } else {
                f5275q.m8241e((Object) "Exceed StatConfig.getMaxDaySessionNumbers().");
            }
            f5274p.put(obj, Long.valueOf(1));
        }
        if (f5277s) {
            testSpeed(context);
            f5277s = false;
        }
        return f5270l;
    }

    /* renamed from: a */
    static synchronized void m8108a(Context context) {
        synchronized (StatServiceImpl.class) {
            if (context != null) {
                if (f5262d == null && m8117b(context)) {
                    Context applicationContext = context.getApplicationContext();
                    f5278t = applicationContext;
                    f5262d = new C1186e();
                    f5269k = C1192k.m8274a(0);
                    f5266h = System.currentTimeMillis() + StatConfig.f5236i;
                    f5262d.m8255a(new C1207l(applicationContext));
                }
            }
        }
    }

    /* renamed from: a */
    static void m8110a(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (m8118c(context) != null) {
            if (StatConfig.isDebugEnable()) {
                f5275q.m8240d("start new session.");
            }
            if (statSpecifyReportedInfo == null || f5270l == 0) {
                f5270l = C1192k.m8271a();
            }
            StatConfig.m8089a(0);
            StatConfig.m8099b();
            new aq(new C1177l(context, f5270l, m8115b(), statSpecifyReportedInfo)).m8190a();
        }
    }

    /* renamed from: a */
    static void m8111a(Context context, Throwable th) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f5275q.error((Object) "The Context of StatService.reportSdkSelfException() can not be null!");
            } else if (m8118c(context2) != null) {
                f5262d.m8255a(new C1212q(context2, th));
            }
        }
    }

    /* renamed from: a */
    static boolean m8112a() {
        if (f5259a < 2) {
            return false;
        }
        f5260b = System.currentTimeMillis();
        return true;
    }

    /* renamed from: a */
    static boolean m8113a(String str) {
        return str == null || str.length() == 0;
    }

    /* renamed from: b */
    static JSONObject m8115b() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (StatConfig.f5229b.f5514d != 0) {
                jSONObject2.put("v", StatConfig.f5229b.f5514d);
            }
            jSONObject.put(Integer.toString(StatConfig.f5229b.f5511a), jSONObject2);
            jSONObject2 = new JSONObject();
            if (StatConfig.f5228a.f5514d != 0) {
                jSONObject2.put("v", StatConfig.f5228a.f5514d);
            }
            jSONObject.put(Integer.toString(StatConfig.f5228a.f5511a), jSONObject2);
        } catch (Throwable e) {
            f5275q.m8242e(e);
        }
        return jSONObject;
    }

    /* renamed from: b */
    private static void m8116b(Context context, StatAccount statAccount, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        try {
            new aq(new C1167a(context, m8105a(context, false, statSpecifyReportedInfo), statAccount, statSpecifyReportedInfo)).m8190a();
        } catch (Throwable th) {
            f5275q.m8242e(th);
            m8111a(context, th);
        }
    }

    /* renamed from: b */
    static boolean m8117b(Context context) {
        boolean z = false;
        long a = C1197p.m8322a(context, StatConfig.f5230c, 0);
        long b = C1192k.m8282b(StatConstants.VERSION);
        boolean z2 = true;
        if (b <= a) {
            f5275q.error("MTA is disable for current version:" + b + ",wakeup version:" + a);
            z2 = false;
        }
        a = C1197p.m8322a(context, StatConfig.f5231d, 0);
        if (a > System.currentTimeMillis()) {
            f5275q.error("MTA is disable for current time:" + System.currentTimeMillis() + ",wakeup time:" + a);
        } else {
            z = z2;
        }
        StatConfig.setEnableStatService(z);
        return z;
    }

    /* renamed from: c */
    static C1186e m8118c(Context context) {
        if (f5262d == null) {
            synchronized (StatServiceImpl.class) {
                if (f5262d == null) {
                    try {
                        m8108a(context);
                    } catch (Throwable th) {
                        f5275q.error(th);
                        StatConfig.setEnableStatService(false);
                    }
                }
            }
        }
        return f5262d;
    }

    /* renamed from: c */
    static void m8120c() {
        f5259a = 0;
        f5260b = 0;
    }

    public static void commitEvents(Context context, int i) {
        if (StatConfig.isEnableStatService()) {
            if (StatConfig.isDebugEnable()) {
                f5275q.m8243i("commitEvents, maxNumber=" + i);
            }
            Context context2 = getContext(context);
            if (context2 == null) {
                f5275q.error((Object) "The Context of StatService.commitEvents() can not be null!");
            } else if (i < -1 || i == 0) {
                f5275q.error((Object) "The maxNumber of StatService.commitEvents() should be -1 or bigger than 0.");
            } else if (C1178a.m8165a(f5278t).m8178f() && m8118c(context2) != null) {
                f5262d.m8255a(new ad(context2, i));
            }
        }
    }

    /* renamed from: d */
    static void m8121d() {
        f5259a++;
        f5260b = System.currentTimeMillis();
        flushDataToDB(f5278t);
    }

    /* renamed from: d */
    static void m8122d(Context context) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f5275q.error((Object) "The Context of StatService.sendNetworkDetector() can not be null!");
                return;
            }
            try {
                C1204i.m8353b(context2).m8354a(new C1174i(context2), new C1215t());
            } catch (Throwable th) {
                f5275q.m8242e(th);
            }
        }
    }

    /* renamed from: e */
    static void m8124e(Context context) {
        f5261c = System.currentTimeMillis() + ((long) (60000 * StatConfig.getSendPeriodMinutes()));
        C1197p.m8326b(context, "last_period_ts", f5261c);
        commitEvents(context, -1);
    }

    public static void flushDataToDB(Context context) {
        if (StatConfig.isEnableStatService() && StatConfig.f5240m > 0) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f5275q.error((Object) "The Context of StatService.testSpeed() can not be null!");
            } else {
                au.m8199a(context2).m8233c();
            }
        }
    }

    public static Properties getCommonKeyValueForKVEvent(String str) {
        return (Properties) f5264f.get(str);
    }

    public static Context getContext(Context context) {
        return context != null ? context : f5278t;
    }

    public static void onLowMemory(Context context) {
        if (StatConfig.isEnableStatService() && m8118c(getContext(context)) != null) {
            f5262d.m8255a(new C1210o(context));
        }
    }

    public static void onPause(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService() && m8118c(context) != null) {
            f5262d.m8255a(new C1208m(context, statSpecifyReportedInfo));
        }
    }

    public static void onResume(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService() && m8118c(context) != null) {
            f5262d.m8255a(new aj(context, statSpecifyReportedInfo));
        }
    }

    public static void onStop(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (m8118c(context2) != null) {
                f5262d.m8255a(new C1209n(context2));
            }
        }
    }

    public static void reportAccount(Context context, StatAccount statAccount, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f5275q.m8241e((Object) "context is null in reportAccount.");
            } else if (m8118c(context2) != null) {
                f5262d.m8255a(new al(statAccount, context2, statSpecifyReportedInfo));
            }
        }
    }

    public static void reportAppMonitorStat(Context context, StatAppMonitor statAppMonitor, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f5275q.error((Object) "The Context of StatService.reportAppMonitorStat() can not be null!");
            } else if (statAppMonitor == null) {
                f5275q.error((Object) "The StatAppMonitor of StatService.reportAppMonitorStat() can not be null!");
            } else if (statAppMonitor.getInterfaceName() == null) {
                f5275q.error((Object) "The interfaceName of StatAppMonitor on StatService.reportAppMonitorStat() can not be null!");
            } else {
                StatAppMonitor clone = statAppMonitor.clone();
                if (m8118c(context2) != null) {
                    f5262d.m8255a(new aa(context2, statSpecifyReportedInfo, clone));
                }
            }
        }
    }

    public static void reportError(Context context, String str, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f5275q.error((Object) "The Context of StatService.reportError() can not be null!");
            } else if (m8118c(context2) != null) {
                f5262d.m8255a(new C1211p(str, context2, statSpecifyReportedInfo));
            }
        }
    }

    public static void reportException(Context context, Throwable th, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f5275q.error((Object) "The Context of StatService.reportException() can not be null!");
            } else if (m8118c(context2) != null) {
                f5262d.m8255a(new C1213r(th, context2, statSpecifyReportedInfo));
            }
        }
    }

    public static void reportGameUser(Context context, StatGameUser statGameUser, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f5275q.error((Object) "The Context of StatService.reportGameUser() can not be null!");
            } else if (m8118c(context2) != null) {
                f5262d.m8255a(new am(statGameUser, context2, statSpecifyReportedInfo));
            }
        }
    }

    public static void reportQQ(Context context, String str, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f5275q.error((Object) "context is null in reportQQ()");
            } else if (m8118c(context2) != null) {
                f5262d.m8255a(new ak(str, context2, statSpecifyReportedInfo));
            }
        }
    }

    public static void setCommonKeyValueForKVEvent(String str, Properties properties) {
        if (!C1192k.m8287c(str)) {
            f5275q.m8241e((Object) "event_id or commonProp for setCommonKeyValueForKVEvent is invalid.");
        } else if (properties == null || properties.size() <= 0) {
            f5264f.remove(str);
        } else {
            f5264f.put(str, (Properties) properties.clone());
        }
    }

    public static void setContext(Context context) {
        if (context != null) {
            f5278t = context.getApplicationContext();
        }
    }

    public static void setEnvAttributes(Context context, Map<String, String> map) {
        if (map == null || map.size() > 512) {
            f5275q.error((Object) "The map in setEnvAttributes can't be null or its size can't exceed 512.");
            return;
        }
        try {
            C1183b.m8252a(context, (Map) map);
        } catch (Throwable e) {
            f5275q.m8242e(e);
        }
    }

    public static void startNewSession(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f5275q.error((Object) "The Context of StatService.startNewSession() can not be null!");
            } else if (m8118c(context2) != null) {
                f5262d.m8255a(new ai(context2, statSpecifyReportedInfo));
            }
        }
    }

    public static boolean startStatService(Context context, String str, String str2, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        try {
            if (StatConfig.isEnableStatService()) {
                String str3 = StatConstants.VERSION;
                if (StatConfig.isDebugEnable()) {
                    f5275q.m8240d("MTA SDK version, current: " + str3 + " ,required: " + str2);
                }
                if (context == null || str2 == null) {
                    f5275q.error((Object) "Context or mtaSdkVersion in StatService.startStatService() is null, please check it!");
                    StatConfig.setEnableStatService(false);
                    return false;
                } else if (C1192k.m8282b(str3) < C1192k.m8282b(str2)) {
                    f5275q.error(("MTA SDK version conflicted, current: " + str3 + ",required: " + str2) + ". please delete the current SDK and download the latest one. official website: http://mta.qq.com/ or http://mta.oa.com/");
                    StatConfig.setEnableStatService(false);
                    return false;
                } else {
                    str3 = StatConfig.getInstallChannel(context);
                    if (str3 == null || str3.length() == 0) {
                        StatConfig.setInstallChannel("-");
                    }
                    if (str != null) {
                        StatConfig.setAppKey(context, str);
                    }
                    if (m8118c(context) != null) {
                        f5262d.m8255a(new an(context, statSpecifyReportedInfo));
                    }
                    return true;
                }
            }
            f5275q.error((Object) "MTA StatService is disable.");
            return false;
        } catch (Throwable th) {
            f5275q.m8242e(th);
            return false;
        }
    }

    public static void stopSession() {
        f5267i = 0;
    }

    public static void testSpeed(Context context) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f5275q.error((Object) "The Context of StatService.testSpeed() can not be null!");
            } else if (m8118c(context2) != null) {
                f5262d.m8255a(new ae(context2));
            }
        }
    }

    public static void testSpeed(Context context, Map<String, Integer> map, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f5275q.error((Object) "The Context of StatService.testSpeed() can not be null!");
            } else if (map == null || map.size() == 0) {
                f5275q.error((Object) "The domainMap of StatService.testSpeed() can not be null or empty!");
            } else {
                Map hashMap = new HashMap(map);
                if (m8118c(context2) != null) {
                    f5262d.m8255a(new af(context2, hashMap, statSpecifyReportedInfo));
                }
            }
        }
    }

    public static void trackBeginPage(Context context, String str, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null || str == null || str.length() == 0) {
                f5275q.error((Object) "The Context or pageName of StatService.trackBeginPage() can not be null or empty!");
                return;
            }
            String str2 = new String(str);
            if (m8118c(context2) != null) {
                f5262d.m8255a(new C1218w(str2, context2, statSpecifyReportedInfo));
            }
        }
    }

    public static void trackCustomBeginEvent(Context context, String str, StatSpecifyReportedInfo statSpecifyReportedInfo, String... strArr) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f5275q.error((Object) "The Context of StatService.trackCustomBeginEvent() can not be null!");
                return;
            }
            C1169c c1169c = new C1169c(str, strArr, null);
            if (m8118c(context2) != null) {
                f5262d.m8255a(new C1217v(str, c1169c, context2));
            }
        }
    }

    public static void trackCustomBeginKVEvent(Context context, String str, Properties properties, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f5275q.error((Object) "The Context of StatService.trackCustomBeginEvent() can not be null!");
                return;
            }
            C1169c c1169c = new C1169c(str, null, properties);
            if (m8118c(context2) != null) {
                f5262d.m8255a(new C1220y(str, c1169c, context2));
            }
        }
    }

    public static void trackCustomEndEvent(Context context, String str, StatSpecifyReportedInfo statSpecifyReportedInfo, String... strArr) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f5275q.error((Object) "The Context of StatService.trackCustomEndEvent() can not be null!");
                return;
            }
            C1169c c1169c = new C1169c(str, strArr, null);
            if (m8118c(context2) != null) {
                f5262d.m8255a(new C1219x(str, c1169c, context2, statSpecifyReportedInfo));
            }
        }
    }

    public static void trackCustomEndKVEvent(Context context, String str, Properties properties, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f5275q.error((Object) "The Context of StatService.trackCustomEndEvent() can not be null!");
                return;
            }
            C1169c c1169c = new C1169c(str, null, properties);
            if (m8118c(context2) != null) {
                f5262d.m8255a(new C1221z(str, c1169c, context2, statSpecifyReportedInfo));
            }
        }
    }

    public static void trackCustomEvent(Context context, String str, StatSpecifyReportedInfo statSpecifyReportedInfo, String... strArr) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f5275q.error((Object) "The Context of StatService.trackCustomEvent() can not be null!");
            } else if (m8113a(str)) {
                f5275q.error((Object) "The event_id of StatService.trackCustomEvent() can not be null or empty.");
            } else {
                C1169c c1169c = new C1169c(str, strArr, null);
                if (m8118c(context2) != null) {
                    f5262d.m8255a(new C1214s(context2, statSpecifyReportedInfo, c1169c));
                }
            }
        }
    }

    public static void trackCustomKVEvent(Context context, String str, Properties properties, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f5275q.error((Object) "The Context of StatService.trackCustomEvent() can not be null!");
            } else if (m8113a(str)) {
                f5275q.error((Object) "The event_id of StatService.trackCustomEvent() can not be null or empty.");
            } else {
                C1169c c1169c = new C1169c(str, null, properties);
                if (m8118c(context2) != null) {
                    f5262d.m8255a(new C1216u(context2, statSpecifyReportedInfo, c1169c));
                }
            }
        }
    }

    public static void trackCustomKVTimeIntervalEvent(Context context, String str, Properties properties, int i, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f5275q.error((Object) "The Context of StatService.trackCustomEndEvent() can not be null!");
            } else if (m8113a(str)) {
                f5275q.error((Object) "The event_id of StatService.trackCustomEndEvent() can not be null or empty.");
            } else {
                C1169c c1169c = new C1169c(str, null, properties);
                if (m8118c(context2) != null) {
                    f5262d.m8255a(new ac(context2, statSpecifyReportedInfo, c1169c, i));
                }
            }
        }
    }

    public static void trackCustomTimeIntervalEvent(Context context, int i, String str, String... strArr) {
        if (!StatConfig.isEnableStatService()) {
            return;
        }
        if (i <= 0) {
            f5275q.error((Object) "The intervalSecond of StatService.trackCustomTimeIntervalEvent() can must bigger than 0!");
            return;
        }
        Context context2 = getContext(context);
        if (context2 == null) {
            f5275q.error((Object) "The Context of StatService.trackCustomTimeIntervalEvent() can not be null!");
        } else if (m8118c(context2) != null) {
            f5262d.m8255a(new ab());
        }
    }

    public static void trackEndPage(Context context, String str, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null || str == null || str.length() == 0) {
                f5275q.error((Object) "The Context or pageName of StatService.trackEndPage() can not be null or empty!");
                return;
            }
            String str2 = new String(str);
            if (m8118c(context2) != null) {
                f5262d.m8255a(new ah(context2, str2, statSpecifyReportedInfo));
            }
        }
    }
}
