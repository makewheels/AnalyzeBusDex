package com.tencent.wxop.stat.p053a;

import android.content.Context;
import com.tencent.wxop.stat.C1178a;
import com.tencent.wxop.stat.StatAppMonitor;
import com.tencent.wxop.stat.StatSpecifyReportedInfo;
import com.tencent.wxop.stat.common.C1192k;
import com.tencent.wxop.stat.common.C1198q;
import org.json.JSONObject;

/* renamed from: com.tencent.wxop.stat.a.h */
public class C1173h extends C1166e {
    /* renamed from: m */
    private static String f5318m = null;
    /* renamed from: n */
    private static String f5319n = null;
    /* renamed from: a */
    private StatAppMonitor f5320a = null;

    public C1173h(Context context, int i, StatAppMonitor statAppMonitor, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, i, statSpecifyReportedInfo);
        this.f5320a = statAppMonitor.clone();
    }

    /* renamed from: a */
    public C1171f mo1911a() {
        return C1171f.MONITOR_STAT;
    }

    /* renamed from: a */
    public boolean mo1912a(JSONObject jSONObject) {
        if (this.f5320a == null) {
            return false;
        }
        jSONObject.put("na", this.f5320a.getInterfaceName());
        jSONObject.put("rq", this.f5320a.getReqSize());
        jSONObject.put("rp", this.f5320a.getRespSize());
        jSONObject.put("rt", this.f5320a.getResultType());
        jSONObject.put("tm", this.f5320a.getMillisecondsConsume());
        jSONObject.put("rc", this.f5320a.getReturnCode());
        jSONObject.put("sp", this.f5320a.getSampling());
        if (f5319n == null) {
            f5319n = C1192k.m8303n(this.l);
        }
        C1198q.m8331a(jSONObject, "av", f5319n);
        if (f5318m == null) {
            f5318m = C1192k.m8298i(this.l);
        }
        C1198q.m8331a(jSONObject, "op", f5318m);
        jSONObject.put("cn", C1178a.m8165a(this.l).m8174b());
        return true;
    }
}
