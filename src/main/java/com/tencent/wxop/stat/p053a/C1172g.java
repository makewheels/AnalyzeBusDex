package com.tencent.wxop.stat.p053a;

import android.content.Context;
import com.tencent.wxop.stat.StatGameUser;
import com.tencent.wxop.stat.StatSpecifyReportedInfo;
import com.tencent.wxop.stat.common.C1198q;
import org.json.JSONObject;

/* renamed from: com.tencent.wxop.stat.a.g */
public class C1172g extends C1166e {
    /* renamed from: a */
    private StatGameUser f5317a = null;

    public C1172g(Context context, int i, StatGameUser statGameUser, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, i, statSpecifyReportedInfo);
        this.f5317a = statGameUser.clone();
    }

    /* renamed from: a */
    public C1171f mo1911a() {
        return C1171f.MTA_GAME_USER;
    }

    /* renamed from: a */
    public boolean mo1912a(JSONObject jSONObject) {
        if (this.f5317a == null) {
            return false;
        }
        C1198q.m8331a(jSONObject, "wod", this.f5317a.getWorldName());
        C1198q.m8331a(jSONObject, "gid", this.f5317a.getAccount());
        C1198q.m8331a(jSONObject, "lev", this.f5317a.getLevel());
        return true;
    }
}
