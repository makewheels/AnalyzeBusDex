package p054u.aly;

import android.content.Context;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.C1233a;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: EventTracker */
/* renamed from: u.aly.n */
public class C1447n {
    /* renamed from: a */
    private final int f6578a = 128;
    /* renamed from: b */
    private final int f6579b = 256;
    /* renamed from: c */
    private C1445l f6580c;
    /* renamed from: d */
    private Context f6581d;
    /* renamed from: e */
    private C1444k f6582e;

    public C1447n(Context context) {
        if (context == null) {
            throw new RuntimeException("Context is null, can't track event");
        }
        this.f6581d = context.getApplicationContext();
        this.f6580c = new C1445l(this.f6581d);
        this.f6580c.m10425a(!AnalyticsConfig.ENABLE_MEMORY_BUFFER);
        this.f6582e = C1444k.m10413a(this.f6581d);
    }

    /* renamed from: a */
    public void m10435a(String str, Map<String, Object> map, long j) {
        try {
            if (m10429a(str) && m10430a((Map) map)) {
                this.f6582e.mo1999a(new ab(str, map, j, -1));
            }
        } catch (Exception e) {
            bj.m10003b(C1233a.f5589e, "Exception occurred in Mobclick.onEvent(). ", e);
        }
    }

    /* renamed from: a */
    public void m10433a(String str, String str2, long j, int i) {
        if (m10429a(str) && m10431b(str2)) {
            Map hashMap = new HashMap();
            if (str2 == null) {
                str2 = bi_常量类.f6358b;
            }
            hashMap.put(str, str2);
            this.f6582e.mo1999a(new ab(str, hashMap, j, i));
        }
    }

    /* renamed from: a */
    public void m10434a(String str, Map<String, Object> map) {
        try {
            if (m10429a(str)) {
                this.f6582e.mo1999a(new ad(str, map));
            }
        } catch (Exception e) {
            bj.m10003b(C1233a.f5589e, "Exception occurred in Mobclick.onEvent(). ", e);
        }
    }

    /* renamed from: a */
    public void m10432a(String str, String str2) {
        if (m10429a(str) && m10431b(str2)) {
            this.f6580c.m10424a(ab.m8575b(str, str2, null), ab.m8574a(str, str2, null));
        }
    }

    /* renamed from: b */
    public void m10437b(String str, String str2) {
        if (m10429a(str) && m10431b(str2)) {
            aa b = this.f6580c.m10426b(ab.m8575b(str, str2, null));
            if (b != null) {
                m10433a(str, str2, (long) ((int) (System.currentTimeMillis() - b.f5731a)), 0);
            }
        }
    }

    /* renamed from: a */
    public void m10436a(String str, Map<String, Object> map, String str2) {
        if (m10429a(str) && m10430a((Map) map)) {
            this.f6580c.m10424a(ab.m8575b(str, str2, map), ab.m8574a(str, str2, map));
        }
    }

    /* renamed from: c */
    public void m10438c(String str, String str2) {
        if (m10429a(str)) {
            aa b = this.f6580c.m10426b(ab.m8575b(str, str2, null));
            if (b != null) {
                m10435a(str, b.f5734d, (long) ((int) (System.currentTimeMillis() - b.f5731a)));
            }
        }
    }

    /* renamed from: a */
    private boolean m10429a(String str) {
        if (str != null) {
            int length = str.trim().getBytes().length;
            if (length > 0 && length <= 128) {
                return true;
            }
        }
        bj.m10002b(C1233a.f5589e, "Event id is empty or too long in tracking Event");
        return false;
    }

    /* renamed from: b */
    private boolean m10431b(String str) {
        if (str == null || str.trim().getBytes().length <= 256) {
            return true;
        }
        bj.m10002b(C1233a.f5589e, "Event label or value is empty or too long in tracking Event");
        return false;
    }

    /* renamed from: a */
    private boolean m10430a(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            bj.m10002b(C1233a.f5589e, "map is null or empty in onEvent");
            return false;
        }
        for (Entry entry : map.entrySet()) {
            if (!m10429a((String) entry.getKey())) {
                return false;
            }
            if (entry.getValue() == null) {
                return false;
            }
            if ((entry.getValue() instanceof String) && !m10431b(entry.getValue().toString())) {
                return false;
            }
        }
        return true;
    }
}
