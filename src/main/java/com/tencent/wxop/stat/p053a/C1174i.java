package com.tencent.wxop.stat.p053a;

import android.content.Context;
import com.tencent.wxop.stat.StatConfig;
import com.tencent.wxop.stat.StatSpecifyReportedInfo;
import com.tencent.wxop.stat.common.C1198q;
import org.json.JSONObject;

/* renamed from: com.tencent.wxop.stat.a.i */
public class C1174i extends C1166e {
    /* renamed from: a */
    public static final StatSpecifyReportedInfo f5321a;

    static {
        StatSpecifyReportedInfo statSpecifyReportedInfo = new StatSpecifyReportedInfo();
        f5321a = statSpecifyReportedInfo;
        statSpecifyReportedInfo.setAppKey("A9VH9B8L4GX4");
    }

    public C1174i(Context context) {
        super(context, 0, f5321a);
    }

    /* renamed from: a */
    public C1171f mo1911a() {
        return C1171f.NETWORK_DETECTOR;
    }

    /* renamed from: a */
    public boolean mo1912a(JSONObject jSONObject) {
        C1198q.m8331a(jSONObject, "actky", StatConfig.getAppKey(this.l));
        return true;
    }
}
