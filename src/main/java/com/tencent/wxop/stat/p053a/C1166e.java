package com.tencent.wxop.stat.p053a;

import android.content.Context;
import com.tencent.p041a.p042a.p043a.p044a.C1043h;
import com.tencent.wxop.stat.StatConfig;
import com.tencent.wxop.stat.StatSpecifyReportedInfo;
import com.tencent.wxop.stat.au;
import com.tencent.wxop.stat.common.C1182a;
import com.tencent.wxop.stat.common.C1192k;
import com.tencent.wxop.stat.common.C1198q;
import org.json.JSONObject;
import p054u.aly.bi_常量类;

/* renamed from: com.tencent.wxop.stat.a.e */
public abstract class C1166e {
    /* renamed from: j */
    protected static String f5284j = null;
    /* renamed from: a */
    private StatSpecifyReportedInfo f5285a = null;
    /* renamed from: b */
    protected String f5286b = null;
    /* renamed from: c */
    protected long f5287c;
    /* renamed from: d */
    protected int f5288d;
    /* renamed from: e */
    protected C1182a f5289e = null;
    /* renamed from: f */
    protected int f5290f;
    /* renamed from: g */
    protected String f5291g = null;
    /* renamed from: h */
    protected String f5292h = null;
    /* renamed from: i */
    protected String f5293i = null;
    /* renamed from: k */
    protected boolean f5294k = false;
    /* renamed from: l */
    protected Context f5295l;

    C1166e(Context context, int i, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.f5295l = context;
        this.f5287c = System.currentTimeMillis() / 1000;
        this.f5288d = i;
        this.f5292h = StatConfig.getInstallChannel(context);
        this.f5293i = C1192k.m8299j(context);
        this.f5286b = StatConfig.getAppKey(context);
        if (statSpecifyReportedInfo != null) {
            this.f5285a = statSpecifyReportedInfo;
            if (C1192k.m8287c(statSpecifyReportedInfo.getAppKey())) {
                this.f5286b = statSpecifyReportedInfo.getAppKey();
            }
            if (C1192k.m8287c(statSpecifyReportedInfo.getInstallChannel())) {
                this.f5292h = statSpecifyReportedInfo.getInstallChannel();
            }
            if (C1192k.m8287c(statSpecifyReportedInfo.getVersion())) {
                this.f5293i = statSpecifyReportedInfo.getVersion();
            }
            this.f5294k = statSpecifyReportedInfo.isImportant();
        }
        this.f5291g = StatConfig.getCustomUserId(context);
        this.f5289e = au.m8199a(context).m8232b(context);
        if (mo1911a() != C1171f.NETWORK_DETECTOR) {
            this.f5290f = C1192k.m8308s(context).intValue();
        } else {
            this.f5290f = -C1171f.NETWORK_DETECTOR.m8151a();
        }
        if (!C1043h.m7501c(f5284j)) {
            String localMidOnly = StatConfig.getLocalMidOnly(context);
            f5284j = localMidOnly;
            if (!C1192k.m8287c(localMidOnly)) {
                f5284j = "0";
            }
        }
    }

    /* renamed from: a */
    public abstract C1171f mo1911a();

    /* renamed from: a */
    public abstract boolean mo1912a(JSONObject jSONObject);

    /* renamed from: b */
    public boolean m8135b(JSONObject jSONObject) {
        boolean z = false;
        try {
            C1198q.m8331a(jSONObject, "ky", this.f5286b);
            jSONObject.put("et", mo1911a().m8151a());
            if (this.f5289e != null) {
                jSONObject.put("ui", this.f5289e.m8248b());
                C1198q.m8331a(jSONObject, "mc", this.f5289e.m8249c());
                int d = this.f5289e.m8250d();
                jSONObject.put("ut", d);
                if (d == 0 && C1192k.m8312w(this.f5295l) == 1) {
                    jSONObject.put("ia", 1);
                }
            }
            C1198q.m8331a(jSONObject, "cui", this.f5291g);
            if (mo1911a() != C1171f.SESSION_ENV) {
                C1198q.m8331a(jSONObject, "av", this.f5293i);
                C1198q.m8331a(jSONObject, "ch", this.f5292h);
            }
            if (this.f5294k) {
                jSONObject.put("impt", 1);
            }
            C1198q.m8331a(jSONObject, "mid", f5284j);
            jSONObject.put("idx", this.f5290f);
            jSONObject.put("si", this.f5288d);
            jSONObject.put("ts", this.f5287c);
            jSONObject.put("dts", C1192k.m8272a(this.f5295l, false));
            z = mo1912a(jSONObject);
        } catch (Throwable th) {
        }
        return z;
    }

    /* renamed from: c */
    public long m8136c() {
        return this.f5287c;
    }

    /* renamed from: d */
    public StatSpecifyReportedInfo m8137d() {
        return this.f5285a;
    }

    /* renamed from: e */
    public Context m8138e() {
        return this.f5295l;
    }

    /* renamed from: f */
    public boolean m8139f() {
        return this.f5294k;
    }

    /* renamed from: g */
    public String m8140g() {
        try {
            JSONObject jSONObject = new JSONObject();
            m8135b(jSONObject);
            return jSONObject.toString();
        } catch (Throwable th) {
            return bi_常量类.f6358b_空串;
        }
    }
}
