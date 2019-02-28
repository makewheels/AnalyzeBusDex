package com.tencent.wxop.stat.p053a;

import android.content.Context;
import com.tencent.wxop.stat.StatServiceImpl;
import com.tencent.wxop.stat.StatSpecifyReportedInfo;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.wxop.stat.a.b */
public class C1168b extends C1166e {
    /* renamed from: a */
    protected C1169c f5297a = new C1169c();
    /* renamed from: m */
    private long f5298m = -1;

    public C1168b(Context context, int i, String str, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, i, statSpecifyReportedInfo);
        this.f5297a.f5299a = str;
    }

    /* renamed from: h */
    private void m8143h() {
        if (this.f5297a.f5299a != null) {
            Map commonKeyValueForKVEvent = StatServiceImpl.getCommonKeyValueForKVEvent(this.f5297a.f5299a);
            if (commonKeyValueForKVEvent != null && commonKeyValueForKVEvent.size() > 0) {
                if (this.f5297a.f5301c == null || this.f5297a.f5301c.length() == 0) {
                    this.f5297a.f5301c = new JSONObject(commonKeyValueForKVEvent);
                    return;
                }
                for (Entry entry : commonKeyValueForKVEvent.entrySet()) {
                    try {
                        this.f5297a.f5301c.put(entry.getKey().toString(), entry.getValue());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public C1171f mo1911a() {
        return C1171f.CUSTOM;
    }

    /* renamed from: a */
    public void m8145a(long j) {
        this.f5298m = j;
    }

    /* renamed from: a */
    public boolean mo1912a(JSONObject jSONObject) {
        jSONObject.put("ei", this.f5297a.f5299a);
        if (this.f5298m > 0) {
            jSONObject.put("du", this.f5298m);
        }
        if (this.f5297a.f5300b == null) {
            m8143h();
            jSONObject.put("kv", this.f5297a.f5301c);
        } else {
            jSONObject.put("ar", this.f5297a.f5300b);
        }
        return true;
    }

    /* renamed from: b */
    public C1169c m8147b() {
        return this.f5297a;
    }
}
