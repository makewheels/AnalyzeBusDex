package com.alipay.sdk.protocol;

import android.text.TextUtils;
import com.alipay.sdk.cons.C0108a;
import org.json.JSONObject;

/* renamed from: com.alipay.sdk.protocol.a */
public enum C0126a {
    WapPay("js://wappay"),
    DownLoad("js://download"),
    Submit("submit"),
    Confirm("js://confirm"),
    Alert("js://alert"),
    Update("js://update"),
    Exit("js://exit");
    
    /* renamed from: h */
    private String f365h;
    /* renamed from: i */
    private String f366i;
    /* renamed from: j */
    private String f367j;
    /* renamed from: k */
    private JSONObject f368k;
    /* renamed from: l */
    private String f369l;
    /* renamed from: m */
    private String f370m;
    /* renamed from: n */
    private String f371n;
    /* renamed from: o */
    private boolean f372o;
    /* renamed from: p */
    private boolean f373p;
    /* renamed from: q */
    private boolean f374q;
    /* renamed from: r */
    private String f375r;
    /* renamed from: s */
    private String f376s;
    /* renamed from: t */
    private String f377t;
    /* renamed from: u */
    private JSONObject f378u;

    private C0126a(String str) {
        this.f365h = str;
    }

    /* renamed from: a */
    public static C0126a[] m408a(C0127b c0127b) {
        if (c0127b != null) {
            Object obj = c0127b.f379a;
            String[] split = !TextUtils.isEmpty(obj) ? obj.split(";") : null;
            if (split == null) {
                return new C0126a[]{Submit};
            }
            C0126a[] c0126aArr = new C0126a[split.length];
            int length = split.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                String str = split[i];
                C0126a c0126a = Submit;
                for (C0126a c0126a2 : C0126a.values()) {
                    if (str.startsWith(c0126a2.f365h)) {
                        break;
                    }
                }
                C0126a c0126a22 = c0126a;
                c0126a22.f366i = str;
                if (TextUtils.isEmpty(c0127b.f380b)) {
                    c0127b.f380b = C0108a.f259b;
                }
                c0126a22.f367j = c0127b.f380b;
                c0126a22.f368k = c0127b.m439a();
                c0126a22.f369l = c0127b.f381c;
                c0126a22.f370m = c0127b.f382d;
                c0126a22.f371n = c0127b.f383e;
                c0126a22.f372o = c0127b.f384f;
                c0126a22.f373p = c0127b.f385g;
                c0126a22.f374q = c0127b.f386h;
                c0126a22.f375r = c0127b.f387i;
                c0126a22.f376s = c0127b.f388j;
                c0126a22.f377t = c0127b.f389k;
                c0126a22.f378u = c0127b.f390l;
                c0126aArr[i2] = c0126a22;
                i++;
                i2++;
            }
            return c0126aArr;
        }
        return new C0126a[]{Submit};
    }

    /* renamed from: a */
    private static String[] m409a(String str) {
        return !TextUtils.isEmpty(str) ? str.split(";") : null;
    }

    /* renamed from: m */
    private JSONObject m410m() {
        return this.f368k;
    }

    /* renamed from: a */
    public final JSONObject m411a() {
        return this.f378u;
    }

    /* renamed from: b */
    public final String m412b() {
        return this.f377t;
    }

    /* renamed from: c */
    public final String m413c() {
        return this.f375r;
    }

    /* renamed from: d */
    public final String m414d() {
        return this.f376s;
    }

    /* renamed from: e */
    public final String m415e() {
        return this.f366i;
    }

    /* renamed from: f */
    public final String m416f() {
        return this.f367j;
    }

    /* renamed from: g */
    public final String m417g() {
        return this.f370m;
    }

    /* renamed from: h */
    public final String m418h() {
        return this.f371n;
    }

    /* renamed from: i */
    public final boolean m419i() {
        return this.f372o;
    }

    /* renamed from: j */
    public final boolean m420j() {
        return this.f373p;
    }

    /* renamed from: k */
    public final boolean m421k() {
        return this.f374q;
    }

    /* renamed from: l */
    public final String m422l() {
        return this.f369l;
    }
}
