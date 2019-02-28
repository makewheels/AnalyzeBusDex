package com.iflytek.cloud.p022a;

import android.content.Context;
import com.iflytek.cloud.Version;
import com.iflytek.cloud.p023b.p024e.C0942a;
import com.iflytek.cloud.p030c.C0950a;
import com.iflytek.cloud.p030c.C0952c;
import com.iflytek.cloud.resource.Resource;
import com.iflytek.cloud.speech.SpeechConstant;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;
import p054u.aly.bi_常量类;

/* renamed from: com.iflytek.cloud.a.b */
public class C0914b {
    /* renamed from: a */
    private C0950a f4366a = null;

    public C0914b(Context context) {
        m6980a(context);
    }

    /* renamed from: a */
    private void m6980a(Context context) {
        this.f4366a = C0942a.m7128a(context).m7174b();
        this.f4366a.m7170a("lang", Resource.getLanguage());
        this.f4366a.m7170a(SpeechConstant.APPID, C0952c.m7181a());
        this.f4366a.m7170a("md5", C0952c.m7189b());
        this.f4366a.m7170a("msc.ver", Version.getVersion());
        C0952c.m7186a(context, this.f4366a);
        this.f4366a.m7170a("logtime", bi_常量类.f6358b + System.currentTimeMillis());
        this.f4366a.m7170a("msc.lat", bi_常量类.f6358b + C0913a.m6973a(context).m6976a("msc.lat"));
        this.f4366a.m7170a("msc.lng", bi_常量类.f6358b + C0913a.m6973a(context).m6976a("msc.lng"));
    }

    /* renamed from: a */
    public JSONObject m6981a(boolean z) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        for (Entry entry : this.f4366a.m7178c().entrySet()) {
            try {
                jSONObject2.put((String) entry.getKey(), entry.getValue());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        jSONObject.put("header", jSONObject2);
        return z ? jSONObject : jSONObject2;
    }

    /* renamed from: a */
    public void m6982a(String str, String str2) {
        this.f4366a.m7170a(str, str2);
    }
}
