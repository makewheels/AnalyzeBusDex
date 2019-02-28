package com.alipay.sdk.authjs;

import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.alipay.sdk.authjs.e */
final class C0107e extends TimerTask {
    /* renamed from: a */
    final /* synthetic */ C0104a f256a;
    /* renamed from: b */
    final /* synthetic */ C0105c f257b;

    C0107e(C0105c c0105c, C0104a c0104a) {
        this.f257b = c0105c;
        this.f256a = c0104a;
    }

    public final void run() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("toastCallBack", "true");
        } catch (JSONException e) {
        }
        C0104a c0104a = new C0104a(C0104a.f240c);
        c0104a.f246i = this.f256a.f246i;
        c0104a.f250m = jSONObject;
        this.f257b.f252a.mo22a(c0104a);
    }
}
