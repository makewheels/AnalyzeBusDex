package com.tencent.wxop.stat.p053a;

import android.content.Context;
import com.tencent.wxop.stat.StatAccount;
import com.tencent.wxop.stat.StatSpecifyReportedInfo;
import com.tencent.wxop.stat.common.C1198q;
import org.json.JSONObject;

/* renamed from: com.tencent.wxop.stat.a.a */
public class C1167a extends C1166e {
    /* renamed from: a */
    private StatAccount f5296a = null;

    public C1167a(Context context, int i, StatAccount statAccount, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, i, statSpecifyReportedInfo);
        this.f5296a = statAccount;
    }

    /* renamed from: a */
    public C1171f mo1911a() {
        return C1171f.ADDITION;
    }

    /* renamed from: a */
    public boolean mo1912a(JSONObject jSONObject) {
        C1198q.m8331a(jSONObject, "qq", this.f5296a.getAccount());
        jSONObject.put("acc", this.f5296a.toJsonString());
        return true;
    }
}
