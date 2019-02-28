package com.tencent.wxop.stat.p053a;

import android.content.Context;
import com.tencent.wxop.stat.StatSpecifyReportedInfo;
import com.tencent.wxop.stat.common.C1183b;
import com.tencent.wxop.stat.common.C1192k;
import org.json.JSONObject;

/* renamed from: com.tencent.wxop.stat.a.l */
public class C1177l extends C1166e {
    /* renamed from: a */
    private C1183b f5328a;
    /* renamed from: m */
    private JSONObject f5329m = null;

    public C1177l(Context context, int i, JSONObject jSONObject, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, i, statSpecifyReportedInfo);
        this.f5328a = new C1183b(context);
        this.f5329m = jSONObject;
    }

    /* renamed from: a */
    public C1171f mo1911a() {
        return C1171f.SESSION_ENV;
    }

    /* renamed from: a */
    public boolean mo1912a(JSONObject jSONObject) {
        if (this.f5289e != null) {
            jSONObject.put("ut", this.f5289e.m8250d());
        }
        if (this.f5329m != null) {
            jSONObject.put("cfg", this.f5329m);
        }
        if (C1192k.m8314y(this.l)) {
            jSONObject.put("ncts", 1);
        }
        this.f5328a.m8253a(jSONObject, null);
        return true;
    }
}
