package com.tencent.wxop.stat.p053a;

import android.content.Context;
import com.tencent.wxop.stat.StatSpecifyReportedInfo;
import com.tencent.wxop.stat.common.C1198q;
import org.json.JSONObject;

/* renamed from: com.tencent.wxop.stat.a.k */
public class C1176k extends C1166e {
    /* renamed from: a */
    Long f5325a = null;
    /* renamed from: m */
    String f5326m;
    /* renamed from: n */
    String f5327n;

    public C1176k(Context context, String str, String str2, int i, Long l, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, i, statSpecifyReportedInfo);
        this.f5327n = str;
        this.f5326m = str2;
        this.f5325a = l;
    }

    /* renamed from: a */
    public C1171f mo1911a() {
        return C1171f.PAGE_VIEW;
    }

    /* renamed from: a */
    public boolean mo1912a(JSONObject jSONObject) {
        C1198q.m8331a(jSONObject, "pi", this.f5326m);
        C1198q.m8331a(jSONObject, "rf", this.f5327n);
        if (this.f5325a != null) {
            jSONObject.put("du", this.f5325a);
        }
        return true;
    }
}
