package com.alipay.sdk.protocol;

import android.text.TextUtils;
import com.alipay.sdk.cons.C0108a;
import com.alipay.sdk.cons.C0109b;
import com.alipay.sdk.cons.C0110c;
import org.json.JSONObject;
import p054u.aly.bi_常量类;

/* renamed from: com.alipay.sdk.protocol.b */
public final class C0127b {
    /* renamed from: a */
    String f379a;
    /* renamed from: b */
    String f380b;
    /* renamed from: c */
    String f381c;
    /* renamed from: d */
    String f382d;
    /* renamed from: e */
    String f383e;
    /* renamed from: f */
    boolean f384f;
    /* renamed from: g */
    boolean f385g = true;
    /* renamed from: h */
    boolean f386h = true;
    /* renamed from: i */
    String f387i;
    /* renamed from: j */
    String f388j;
    /* renamed from: k */
    String f389k;
    /* renamed from: l */
    JSONObject f390l;

    private C0127b(String str) {
        this.f379a = str;
    }

    /* renamed from: a */
    private static C0127b m423a(String str, C0126a c0126a) {
        return C0127b.m424a(str, c0126a.m416f(), c0126a.m422l(), c0126a.m417g(), c0126a.m418h(), c0126a.m419i(), c0126a.m420j(), c0126a.m421k(), c0126a.m413c(), c0126a.m414d(), c0126a.m412b(), c0126a.m411a());
    }

    /* renamed from: a */
    private static C0127b m424a(String str, String str2, String str3, String str4, String str5, boolean z, boolean z2, boolean z3, String str6, String str7, String str8, JSONObject jSONObject) {
        String str9 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0127b c0127b = new C0127b(str);
        c0127b.f379a = str;
        if (!TextUtils.isEmpty(str2)) {
            str9 = str2.trim();
        }
        c0127b.f380b = str9;
        c0127b.f381c = str3;
        c0127b.f382d = str4;
        c0127b.f383e = str5;
        c0127b.f384f = z;
        c0127b.f385g = z2;
        c0127b.f386h = z3;
        c0127b.f387i = str6;
        c0127b.f388j = str7;
        c0127b.f389k = str8;
        c0127b.f390l = jSONObject;
        return c0127b;
    }

    /* renamed from: a */
    private static C0127b m425a(JSONObject jSONObject) {
        String str = null;
        boolean z = true;
        String optString = (jSONObject == null || !jSONObject.has(C0110c.f289e)) ? null : jSONObject.optString(C0110c.f289e);
        String optString2 = (jSONObject == null || !jSONObject.has(C0110c.f290f)) ? null : jSONObject.optString(C0110c.f290f);
        String optString3 = (jSONObject == null || !jSONObject.has("params")) ? null : jSONObject.optString("params");
        String optString4 = (jSONObject == null || !jSONObject.has(C0110c.f292h)) ? null : jSONObject.optString(C0110c.f292h);
        if (jSONObject != null && jSONObject.has(C0110c.f293i)) {
            str = jSONObject.optString(C0110c.f293i);
        }
        boolean optBoolean = (jSONObject == null || !jSONObject.has(C0110c.f294j)) ? true : jSONObject.optBoolean(C0110c.f294j, true);
        boolean z2 = (jSONObject == null || !jSONObject.has(C0109b.f275a)) ? true : !jSONObject.optBoolean(C0109b.f275a);
        if (jSONObject != null && jSONObject.has(C0110c.f295k)) {
            z = jSONObject.optBoolean(C0110c.f295k);
        }
        String str2 = bi_常量类.f6358b;
        if (jSONObject != null && jSONObject.has(C0110c.f296l)) {
            str2 = jSONObject.optString(C0110c.f296l);
        }
        String str3 = bi_常量类.f6358b;
        if (jSONObject != null && jSONObject.has(C0110c.f297m)) {
            str3 = jSONObject.optString(C0110c.f297m);
        }
        String str4 = bi_常量类.f6358b;
        if (jSONObject != null && jSONObject.has(C0110c.f298n)) {
            str4 = jSONObject.optString(C0110c.f298n);
        }
        return C0127b.m424a(optString, optString2, optString3, optString4, str, optBoolean, z2, z, str2, str3, str4, jSONObject);
    }

    /* renamed from: a */
    public static C0127b m426a(JSONObject jSONObject, String str) {
        String str2 = null;
        boolean z = true;
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        String optString = (optJSONObject == null || !optJSONObject.has(C0110c.f289e)) ? null : optJSONObject.optString(C0110c.f289e);
        String optString2 = (optJSONObject == null || !optJSONObject.has(C0110c.f290f)) ? null : optJSONObject.optString(C0110c.f290f);
        String optString3 = (optJSONObject == null || !optJSONObject.has("params")) ? null : optJSONObject.optString("params");
        String optString4 = (optJSONObject == null || !optJSONObject.has(C0110c.f292h)) ? null : optJSONObject.optString(C0110c.f292h);
        if (optJSONObject != null && optJSONObject.has(C0110c.f293i)) {
            str2 = optJSONObject.optString(C0110c.f293i);
        }
        boolean optBoolean = (optJSONObject == null || !optJSONObject.has(C0110c.f294j)) ? true : optJSONObject.optBoolean(C0110c.f294j, true);
        boolean z2 = (optJSONObject == null || !optJSONObject.has(C0109b.f275a)) ? true : !optJSONObject.optBoolean(C0109b.f275a);
        if (optJSONObject != null && optJSONObject.has(C0110c.f295k)) {
            z = optJSONObject.optBoolean(C0110c.f295k);
        }
        String str3 = bi_常量类.f6358b;
        if (optJSONObject != null && optJSONObject.has(C0110c.f296l)) {
            str3 = optJSONObject.optString(C0110c.f296l);
        }
        String str4 = bi_常量类.f6358b;
        if (optJSONObject != null && optJSONObject.has(C0110c.f297m)) {
            str4 = optJSONObject.optString(C0110c.f297m);
        }
        String str5 = bi_常量类.f6358b;
        if (optJSONObject != null && optJSONObject.has(C0110c.f298n)) {
            str5 = optJSONObject.optString(C0110c.f298n);
        }
        return C0127b.m424a(optString, optString2, optString3, optString4, str2, optBoolean, z2, z, str3, str4, str5, optJSONObject);
    }

    /* renamed from: b */
    private JSONObject m427b() {
        return this.f390l;
    }

    /* renamed from: c */
    private String m428c() {
        return this.f389k;
    }

    /* renamed from: d */
    private String m429d() {
        return this.f387i;
    }

    /* renamed from: e */
    private String m430e() {
        return this.f388j;
    }

    /* renamed from: f */
    private String m431f() {
        return this.f379a;
    }

    /* renamed from: g */
    private String m432g() {
        if (TextUtils.isEmpty(this.f380b)) {
            this.f380b = C0108a.f259b;
        }
        return this.f380b;
    }

    /* renamed from: h */
    private String m433h() {
        return this.f381c;
    }

    /* renamed from: i */
    private String m434i() {
        return this.f382d;
    }

    /* renamed from: j */
    private String m435j() {
        return this.f383e;
    }

    /* renamed from: k */
    private boolean m436k() {
        return this.f384f;
    }

    /* renamed from: l */
    private boolean m437l() {
        return this.f385g;
    }

    /* renamed from: m */
    private boolean m438m() {
        return this.f386h;
    }

    /* renamed from: a */
    public final JSONObject m439a() {
        try {
            return new JSONObject(this.f381c);
        } catch (Exception e) {
            return null;
        }
    }
}
