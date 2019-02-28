package com.alipay.sdk.data;

import android.os.Build;
import android.text.TextUtils;
import com.alipay.sdk.cons.C0108a;
import com.alipay.sdk.cons.C0110c;
import com.alipay.sdk.encrypt.C0120d;
import com.alipay.sdk.encrypt.C0121e;
import com.alipay.sdk.util.C0142c;
import com.umeng.analytics.onlineconfig.C1248a;
import java.lang.ref.WeakReference;
import java.util.Locale;
import org.json.JSONObject;

/* renamed from: com.alipay.sdk.data.e */
public final class C0115e {
    /* renamed from: a */
    public C0111a f316a;
    /* renamed from: b */
    public WeakReference<C0113c> f317b;
    /* renamed from: c */
    public boolean f318c;
    /* renamed from: d */
    boolean f319d;
    /* renamed from: e */
    private JSONObject f320e;
    /* renamed from: f */
    private JSONObject f321f;
    /* renamed from: g */
    private long f322g;

    public C0115e(C0111a c0111a, JSONObject jSONObject) {
        this(c0111a, jSONObject, (byte) 0);
    }

    private C0115e(C0111a c0111a, JSONObject jSONObject, byte b) {
        this.f317b = null;
        this.f318c = true;
        this.f319d = true;
        this.f316a = c0111a;
        this.f320e = jSONObject;
        this.f321f = null;
        this.f317b = new WeakReference(null);
    }

    /* renamed from: a */
    private void m327a(long j) {
        this.f322g = j;
    }

    /* renamed from: a */
    private void m328a(C0113c c0113c) {
        this.f317b = new WeakReference(c0113c);
    }

    /* renamed from: a */
    private void m329a(JSONObject jSONObject) {
        this.f321f = jSONObject;
    }

    /* renamed from: a */
    private void m330a(boolean z) {
        this.f319d = z;
    }

    /* renamed from: a */
    private boolean m331a() {
        return this.f319d;
    }

    /* renamed from: b */
    private String m332b() {
        return this.f316a.f299a;
    }

    /* renamed from: b */
    private void m333b(boolean z) {
        this.f318c = z;
    }

    /* renamed from: c */
    private long m334c() {
        return this.f322g;
    }

    /* renamed from: d */
    private C0113c m335d() {
        return (C0113c) this.f317b.get();
    }

    /* renamed from: e */
    private boolean m336e() {
        return this.f318c;
    }

    /* renamed from: f */
    private C0111a m337f() {
        return this.f316a;
    }

    /* renamed from: a */
    public final JSONObject m338a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("device", Build.MODEL);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject2 = C0142c.m501a(jSONObject2, this.f321f);
            jSONObject2.put(C0110c.f296l, this.f316a.f300b);
            jSONObject2.put("api_name", this.f316a.f303e);
            jSONObject2.put("api_version", this.f316a.f302d);
            if (this.f320e == null) {
                this.f320e = new JSONObject();
            }
            this.f320e.put("action", jSONObject3);
            Object obj = this.f316a.f301c;
            if (!TextUtils.isEmpty(obj)) {
                try {
                    String[] split = obj.split("/");
                    jSONObject3.put(C1248a.f5654a, split[1]);
                    if (split.length > 1) {
                        jSONObject3.put("method", split[2]);
                    }
                } catch (Exception e) {
                }
            }
            this.f320e.put("gzip", this.f319d);
            if (this.f318c) {
                jSONObject3 = new JSONObject();
                "requestData before: " + this.f320e.toString();
                String jSONObject4 = this.f320e.toString();
                String a = C0120d.m364a(str, C0108a.f260c);
                jSONObject4 = C0121e.m369a(str, jSONObject4);
                jSONObject3.put("req_data", String.format(Locale.getDefault(), "%08X%s%08X%s", new Object[]{Integer.valueOf(a.length()), a, Integer.valueOf(jSONObject4.length()), jSONObject4}));
                jSONObject2.put("params", jSONObject3);
            } else {
                jSONObject2.put("params", this.f320e);
            }
            jSONObject.put("data", jSONObject2);
        } catch (Exception e2) {
        }
        "requestData : " + jSONObject.toString();
        return jSONObject;
    }

    public final String toString() {
        return this.f316a.toString() + ", requestData = " + C0142c.m501a(this.f320e, this.f321f) + ", timeStamp = " + this.f322g;
    }
}
