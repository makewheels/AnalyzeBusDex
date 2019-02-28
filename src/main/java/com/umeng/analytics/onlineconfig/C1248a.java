package com.umeng.analytics.onlineconfig;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.C1233a;
import com.umeng.analytics.C1245f;
import java.util.Iterator;
import org.json.JSONObject;
import p054u.aly.bi_常量类;
import p054u.aly.bj;
import p054u.aly.bo;
import p054u.aly.bp;
import p054u.aly.bv;

/* compiled from: OnlineConfigAgent */
/* renamed from: com.umeng.analytics.onlineconfig.a */
public class C1248a {
    /* renamed from: a */
    public static final String f5654a = "type";
    /* renamed from: b */
    public static final String f5655b = "package";
    /* renamed from: c */
    public static final String f5656c = "channel";
    /* renamed from: d */
    public static final String f5657d = "idmd5";
    /* renamed from: e */
    public static final String f5658e = "version_code";
    /* renamed from: f */
    public static final String f5659f = "appkey";
    /* renamed from: g */
    public static final String f5660g = "sdk_version";
    /* renamed from: h */
    private final String f5661h = "last_config_time";
    /* renamed from: i */
    private final String f5662i = "report_policy";
    /* renamed from: j */
    private final String f5663j = "online_config";
    /* renamed from: k */
    private UmengOnlineConfigureListener f5664k = null;
    /* renamed from: l */
    private C1250c f5665l = null;
    /* renamed from: m */
    private long f5666m = 0;

    /* compiled from: OnlineConfigAgent */
    /* renamed from: com.umeng.analytics.onlineconfig.a$a */
    public class C1246a extends bp {
        /* renamed from: a */
        final /* synthetic */ C1248a f5648a;
        /* renamed from: e */
        private JSONObject f5649e;

        public C1246a(C1248a c1248a, JSONObject jSONObject) {
            this.f5648a = c1248a;
            super(null);
            this.f5649e = jSONObject;
        }

        /* renamed from: a */
        public JSONObject mo1918a() {
            return this.f5649e;
        }

        /* renamed from: b */
        public String mo1919b() {
            return this.d;
        }
    }

    /* compiled from: OnlineConfigAgent */
    /* renamed from: com.umeng.analytics.onlineconfig.a$b */
    public class C1247b extends bo implements Runnable {
        /* renamed from: a */
        Context f5652a;
        /* renamed from: b */
        final /* synthetic */ C1248a f5653b;

        public C1247b(C1248a c1248a, Context context) {
            this.f5653b = c1248a;
            this.f5652a = context.getApplicationContext();
        }

        public void run() {
            try {
                m8443b();
            } catch (Exception e) {
                this.f5653b.m8450a(null);
                bj.m10005c(C1233a.f5589e, "reques update error", e);
            }
        }

        /* renamed from: a */
        public boolean mo1920a() {
            return false;
        }

        /* renamed from: b */
        private void m8443b() {
            bp c1246a = new C1246a(this.f5653b, this.f5653b.m8451b(this.f5652a));
            String[] strArr = C1233a.f5591g;
            C1249b c1249b = null;
            for (String a : strArr) {
                c1246a.m8429a(a);
                c1249b = (C1249b) m8441a(c1246a, C1249b.class);
                if (c1249b != null) {
                    break;
                }
            }
            if (c1249b == null) {
                this.f5653b.m8450a(null);
            } else if (c1249b.f5668b) {
                if (this.f5653b.f5665l != null) {
                    this.f5653b.f5665l.mo1998a(c1249b.f5669c, (long) c1249b.f5670d);
                }
                this.f5653b.m8447a(this.f5652a, c1249b);
                this.f5653b.m8452b(this.f5652a, c1249b);
                this.f5653b.m8450a(c1249b.f5667a);
            } else {
                this.f5653b.m8450a(null);
            }
        }
    }

    /* renamed from: a */
    public void m8456a(Context context) {
        if (context == null) {
            try {
                bj.m10002b(C1233a.f5589e, "unexpected null context in updateOnlineConfig");
            } catch (Exception e) {
                bj.m10002b(C1233a.f5589e, "exception in updateOnlineConfig");
            }
        } else if (bj.f6362a && bi_常量类.m9998w(context)) {
            new Thread(new C1247b(this, context.getApplicationContext())).start();
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f5666m > C1233a.f5598n) {
                this.f5666m = currentTimeMillis;
                new Thread(new C1247b(this, context.getApplicationContext())).start();
            }
        }
    }

    /* renamed from: a */
    public void m8457a(UmengOnlineConfigureListener umengOnlineConfigureListener) {
        this.f5664k = umengOnlineConfigureListener;
    }

    /* renamed from: a */
    public void m8455a() {
        this.f5664k = null;
    }

    /* renamed from: a */
    public void m8458a(C1250c c1250c) {
        this.f5665l = c1250c;
    }

    /* renamed from: b */
    public void m8459b() {
        this.f5665l = null;
    }

    /* renamed from: a */
    private void m8450a(JSONObject jSONObject) {
        if (this.f5664k != null) {
            this.f5664k.onDataReceived(jSONObject);
        }
    }

    /* renamed from: b */
    private JSONObject m8451b(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            String str = f5654a;
            getClass();
            jSONObject.put(str, "online_config");
            jSONObject.put(f5659f, AnalyticsConfig.getAppkey(context));
            jSONObject.put(f5658e, bi_常量类.m9978c(context));
            jSONObject.put(f5655b, bi_常量类.m9996u(context));
            jSONObject.put(f5660g, C1233a.f5587c);
            jSONObject.put(f5657d, bv.m10061b(bi_常量类.m9981f(context)));
            jSONObject.put(f5656c, AnalyticsConfig.getChannel(context));
            jSONObject.put("report_policy", C1245f.m8407a(context).m8416a()[0]);
            jSONObject.put("last_config_time", m8454c(context));
            return jSONObject;
        } catch (Exception e) {
            bj.m10002b(C1233a.f5589e, "exception in onlineConfigInternal");
            return null;
        }
    }

    /* renamed from: c */
    private String m8454c(Context context) {
        return C1245f.m8407a(context).m8424g().getString(C1233a.f5594j, bi_常量类.f6358b);
    }

    /* renamed from: a */
    private void m8447a(Context context, C1249b c1249b) {
        Editor edit = C1245f.m8407a(context).m8424g().edit();
        if (!TextUtils.isEmpty(c1249b.f5671e)) {
            edit.putString(C1233a.f5594j, c1249b.f5671e);
            edit.commit();
        }
        if (c1249b.f5669c != -1) {
            C1245f.m8407a(context).m8413a(c1249b.f5669c, c1249b.f5670d);
        }
    }

    /* renamed from: b */
    private void m8452b(Context context, C1249b c1249b) {
        if (c1249b.f5667a != null && c1249b.f5667a.length() != 0) {
            Editor edit = C1245f.m8407a(context).m8424g().edit();
            try {
                JSONObject jSONObject = c1249b.f5667a;
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    edit.putString(str, jSONObject.getString(str));
                }
                edit.commit();
                bj.m10000a(C1233a.f5589e, "get online setting params: " + jSONObject);
            } catch (Exception e) {
                bj.m10005c(C1233a.f5589e, "save online config params", e);
            }
        }
    }
}
