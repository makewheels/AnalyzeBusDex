package com.alipay.sdk.protocol;

import com.alipay.sdk.data.C0115e;
import com.alipay.sdk.data.C0116f;
import org.json.JSONObject;

/* renamed from: com.alipay.sdk.protocol.c */
public class C0128c {
    /* renamed from: a */
    public C0115e f391a;
    /* renamed from: b */
    public C0116f f392b;
    /* renamed from: c */
    public JSONObject f393c;

    public C0128c(C0115e c0115e, C0116f c0116f) {
        this.f391a = c0115e;
        this.f392b = c0116f;
    }

    /* renamed from: a */
    private C0115e mo23a() {
        return this.f391a;
    }

    /* renamed from: b */
    private C0116f mo24b() {
        return this.f392b;
    }

    /* renamed from: c */
    private JSONObject mo25c() {
        return this.f393c;
    }

    /* renamed from: a */
    public void mo26a(JSONObject jSONObject) {
        this.f393c = jSONObject;
    }
}
