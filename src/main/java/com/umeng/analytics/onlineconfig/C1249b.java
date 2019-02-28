package com.umeng.analytics.onlineconfig;

import com.umeng.analytics.C1233a;
import java.util.Locale;
import org.json.JSONObject;
import p054u.aly.bj;
import p054u.aly.bq;

/* compiled from: OnlineConfigResponse */
/* renamed from: com.umeng.analytics.onlineconfig.b */
public class C1249b extends bq {
    /* renamed from: a */
    public JSONObject f5667a = null;
    /* renamed from: b */
    boolean f5668b = false;
    /* renamed from: c */
    int f5669c = -1;
    /* renamed from: d */
    int f5670d = -1;
    /* renamed from: e */
    String f5671e;
    /* renamed from: f */
    private final String f5672f = "config_update";
    /* renamed from: g */
    private final String f5673g = "report_policy";
    /* renamed from: h */
    private final String f5674h = "online_params";
    /* renamed from: i */
    private final String f5675i = "last_config_time";
    /* renamed from: j */
    private final String f5676j = "report_interval";

    public C1249b(JSONObject jSONObject) {
        super(jSONObject);
        if (jSONObject != null) {
            m8461a(jSONObject);
            m8460a();
        }
    }

    /* renamed from: a */
    private void m8461a(JSONObject jSONObject) {
        try {
            if (jSONObject.has("config_update") && !jSONObject.getString("config_update").toLowerCase(Locale.US).equals("no")) {
                if (jSONObject.has("report_policy")) {
                    this.f5669c = jSONObject.getInt("report_policy");
                    this.f5670d = jSONObject.optInt("report_interval") * 1000;
                    this.f5671e = jSONObject.optString("last_config_time");
                } else {
                    bj.m10008e(C1233a.f5589e, " online config fetch no report policy");
                }
                this.f5667a = jSONObject.optJSONObject("online_params");
                this.f5668b = true;
            }
        } catch (Exception e) {
            bj.m10009e(C1233a.f5589e, "fail to parce online config response", e);
        }
    }

    /* renamed from: a */
    private void m8460a() {
        if (this.f5669c < 0 || this.f5669c > 6) {
            this.f5669c = 1;
        }
    }
}
