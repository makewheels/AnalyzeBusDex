package p054u.aly;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.C1233a;
import java.util.Arrays;
import java.util.List;

/* compiled from: SessionTracker */
/* renamed from: u.aly.v */
public class C1452v {
    /* renamed from: a */
    private static final String f6600a = "session_start_time";
    /* renamed from: b */
    private static final String f6601b = "session_end_time";
    /* renamed from: c */
    private static final String f6602c = "session_id";
    /* renamed from: f */
    private static final String f6603f = "activities";
    /* renamed from: d */
    private final String f6604d = "a_start_time";
    /* renamed from: e */
    private final String f6605e = "a_end_time";

    /* renamed from: a */
    public af m10470a(Context context) {
        SharedPreferences a = C1451u.m10465a(context);
        String string = a.getString(f6602c, null);
        if (string == null) {
            return null;
        }
        long j = a.getLong(f6600a, 0);
        long j2 = a.getLong(f6601b, 0);
        long j3 = 0;
        if (j2 != 0) {
            j3 = j2 - j;
            if (Math.abs(j3) > C1233a.f5597m) {
                j3 = 0;
            }
        }
        af afVar = new af();
        afVar.m8652a(string);
        afVar.m8651a(j);
        afVar.m8659b(j2);
        afVar.m8666c(j3);
        double[] location = AnalyticsConfig.getLocation();
        if (location != null) {
            aw awVar = new aw(location[0], location[1], System.currentTimeMillis());
            if (afVar.m8693y()) {
                afVar.m8655a(awVar);
            } else {
                afVar.m8660b(Arrays.asList(new aw[]{awVar}));
            }
        }
        be a2 = C1455y.m10486a(context);
        if (a2 != null) {
            afVar.m8654a(a2);
        }
        List a3 = C1456z.m10488a(a);
        if (a3 != null && a3.size() > 0) {
            afVar.m8653a(a3);
        }
        m10468a(a);
        return afVar;
    }

    /* renamed from: a */
    private void m10468a(SharedPreferences sharedPreferences) {
        Editor edit = sharedPreferences.edit();
        edit.remove(f6600a);
        edit.remove(f6601b);
        edit.remove(f6602c);
        edit.remove("a_start_time");
        edit.remove("a_end_time");
        edit.putString(f6603f, bi_常量类.f6358b);
        edit.commit();
    }

    /* renamed from: b */
    public String m10471b(Context context) {
        String f = bi_常量类.m9981f(context);
        String appkey = AnalyticsConfig.getAppkey(context);
        long currentTimeMillis = System.currentTimeMillis();
        if (appkey == null) {
            throw new RuntimeException("Appkey is null or empty, Please check AndroidManifest.xml");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(currentTimeMillis).append(appkey).append(f);
        return bv.m10055a(stringBuilder.toString());
    }

    /* renamed from: c */
    public void m10472c(Context context) {
        SharedPreferences a = C1451u.m10465a(context);
        if (a != null) {
            if (m10469b(a)) {
                bj.m10000a(C1233a.f5589e, "Start new session: " + m10467a(context, a));
            } else {
                bj.m10000a(C1233a.f5589e, "Extend current session: " + a.getString(f6602c, null));
            }
            Editor edit = a.edit();
            edit.putLong("a_start_time", System.currentTimeMillis());
            edit.putLong("a_end_time", 0);
            edit.commit();
        }
    }

    /* renamed from: d */
    public void m10473d(Context context) {
        SharedPreferences a = C1451u.m10465a(context);
        if (a != null) {
            if (a.getLong("a_start_time", 0) == 0 && AnalyticsConfig.ACTIVITY_DURATION_OPEN) {
                bj.m10002b(C1233a.f5589e, "onPause called before onResume");
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            Editor edit = a.edit();
            edit.putLong("a_start_time", 0);
            edit.putLong("a_end_time", currentTimeMillis);
            edit.putLong(f6601b, currentTimeMillis);
            edit.commit();
        }
    }

    /* renamed from: b */
    private boolean m10469b(SharedPreferences sharedPreferences) {
        long j = sharedPreferences.getLong("a_start_time", 0);
        long j2 = sharedPreferences.getLong("a_end_time", 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (j != 0 && currentTimeMillis - j < AnalyticsConfig.kContinueSessionMillis) {
            bj.m10002b(C1233a.f5589e, "onResume called before onPause");
            return false;
        } else if (currentTimeMillis - j2 > AnalyticsConfig.kContinueSessionMillis) {
            return true;
        } else {
            return false;
        }
    }

    /* renamed from: a */
    private String m10467a(Context context, SharedPreferences sharedPreferences) {
        C1444k a = C1444k.m10413a(context);
        String b = m10471b(context);
        C1275p a2 = m10470a(context);
        Editor edit = sharedPreferences.edit();
        edit.putString(f6602c, b);
        edit.putLong(f6600a, System.currentTimeMillis());
        edit.putLong(f6601b, 0);
        edit.commit();
        if (a2 != null) {
            a.mo1999a(a2);
        } else {
            a.mo1999a((af) null);
        }
        return b;
    }
}
