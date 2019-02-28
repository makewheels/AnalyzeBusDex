package com.alipay.sdk.authjs;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.alipay.sdk.authjs.a */
public final class C0104a {
    /* renamed from: a */
    public static final String f238a = "CallInfo";
    /* renamed from: b */
    public static final String f239b = "call";
    /* renamed from: c */
    public static final String f240c = "callback";
    /* renamed from: d */
    public static final String f241d = "bundleName";
    /* renamed from: e */
    public static final String f242e = "clientId";
    /* renamed from: f */
    public static final String f243f = "param";
    /* renamed from: g */
    public static final String f244g = "func";
    /* renamed from: h */
    public static final String f245h = "msgType";
    /* renamed from: i */
    public String f246i;
    /* renamed from: j */
    public String f247j;
    /* renamed from: k */
    public String f248k;
    /* renamed from: l */
    public String f249l;
    /* renamed from: m */
    public JSONObject f250m;
    /* renamed from: n */
    private boolean f251n = false;

    /* renamed from: com.alipay.sdk.authjs.a$a */
    public enum C0103a {
        NONE_ERROR,
        FUNCTION_NOT_FOUND,
        INVALID_PARAMETER,
        RUNTIME_ERROR,
        NONE_PERMISS
    }

    public C0104a(String str) {
        this.f249l = str;
    }

    /* renamed from: a */
    private static String m262a(C0103a c0103a) {
        switch (c0103a) {
            case FUNCTION_NOT_FOUND:
                return "function not found";
            case INVALID_PARAMETER:
                return "invalid parameter";
            case RUNTIME_ERROR:
                return "runtime error";
            default:
                return "none";
        }
    }

    /* renamed from: a */
    private void m263a(String str) {
        this.f246i = str;
    }

    /* renamed from: a */
    private void m264a(JSONObject jSONObject) {
        this.f250m = jSONObject;
    }

    /* renamed from: a */
    private void m265a(boolean z) {
        this.f251n = z;
    }

    /* renamed from: a */
    private boolean m266a() {
        return this.f251n;
    }

    /* renamed from: b */
    private String m267b() {
        return this.f246i;
    }

    /* renamed from: b */
    private void m268b(String str) {
        this.f247j = str;
    }

    /* renamed from: c */
    private String m269c() {
        return this.f247j;
    }

    /* renamed from: c */
    private void m270c(String str) {
        this.f248k = str;
    }

    /* renamed from: d */
    private String m271d() {
        return this.f248k;
    }

    /* renamed from: d */
    private void m272d(String str) {
        this.f249l = str;
    }

    /* renamed from: e */
    private String m273e() {
        return this.f249l;
    }

    /* renamed from: f */
    private JSONObject m274f() {
        return this.f250m;
    }

    /* renamed from: g */
    private String m275g() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(f242e, this.f246i);
        jSONObject.put(f244g, this.f248k);
        jSONObject.put(f243f, this.f250m);
        jSONObject.put(f245h, this.f249l);
        return jSONObject.toString();
    }
}
