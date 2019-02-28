package com.tencent.wxop.stat.p053a;

import android.content.Context;
import com.tencent.wxop.stat.C1178a;
import com.tencent.wxop.stat.StatSpecifyReportedInfo;
import com.tencent.wxop.stat.common.C1192k;
import com.tencent.wxop.stat.common.C1198q;
import org.json.JSONObject;

/* renamed from: com.tencent.wxop.stat.a.j */
public class C1175j extends C1166e {
    /* renamed from: a */
    private static String f5322a = null;
    /* renamed from: m */
    private String f5323m = null;
    /* renamed from: n */
    private String f5324n = null;

    public C1175j(Context context, int i, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, i, statSpecifyReportedInfo);
        this.f5323m = C1178a.m8165a(context).m8174b();
        if (f5322a == null) {
            f5322a = C1192k.m8298i(context);
        }
    }

    /* renamed from: a */
    public C1171f mo1911a() {
        return C1171f.NETWORK_MONITOR;
    }

    /* renamed from: a */
    public void m8159a(String str) {
        this.f5324n = str;
    }

    /* renamed from: a */
    public boolean mo1912a(JSONObject jSONObject) {
        C1198q.m8331a(jSONObject, "op", f5322a);
        C1198q.m8331a(jSONObject, "cn", this.f5323m);
        jSONObject.put("sp", this.f5324n);
        return true;
    }
}
