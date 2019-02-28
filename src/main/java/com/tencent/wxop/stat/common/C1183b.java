package com.tencent.wxop.stat.common;

import android.content.Context;
import com.tencent.wxop.stat.C1178a;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONObject;

/* renamed from: com.tencent.wxop.stat.common.b */
public class C1183b {
    /* renamed from: a */
    static C1185d f5437a;
    /* renamed from: d */
    private static StatLogger f5438d = C1192k.m8283b();
    /* renamed from: e */
    private static JSONObject f5439e = new JSONObject();
    /* renamed from: b */
    Integer f5440b = null;
    /* renamed from: c */
    String f5441c = null;

    public C1183b(Context context) {
        try {
            C1183b.m8251a(context);
            this.f5440b = C1192k.m8302m(context.getApplicationContext());
            this.f5441c = C1178a.m8165a(context).m8174b();
        } catch (Throwable th) {
            f5438d.m8242e(th);
        }
    }

    /* renamed from: a */
    static synchronized C1185d m8251a(Context context) {
        C1185d c1185d;
        synchronized (C1183b.class) {
            if (f5437a == null) {
                f5437a = new C1185d(context.getApplicationContext());
            }
            c1185d = f5437a;
        }
        return c1185d;
    }

    /* renamed from: a */
    public static void m8252a(Context context, Map<String, String> map) {
        if (map != null) {
            for (Entry entry : new HashMap(map).entrySet()) {
                f5439e.put((String) entry.getKey(), entry.getValue());
            }
        }
    }

    /* renamed from: a */
    public void m8253a(JSONObject jSONObject, Thread thread) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (f5437a != null) {
                f5437a.m8254a(jSONObject2, thread);
            }
            C1198q.m8331a(jSONObject2, "cn", this.f5441c);
            if (this.f5440b != null) {
                jSONObject2.put("tn", this.f5440b);
            }
            if (thread == null) {
                jSONObject.put("ev", jSONObject2);
            } else {
                jSONObject.put("errkv", jSONObject2.toString());
            }
            if (f5439e != null && f5439e.length() > 0) {
                jSONObject.put("eva", f5439e);
            }
        } catch (Throwable th) {
            f5438d.m8242e(th);
        }
    }
}
