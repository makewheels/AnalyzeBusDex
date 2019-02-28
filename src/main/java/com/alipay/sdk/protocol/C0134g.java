package com.alipay.sdk.protocol;

import android.text.TextUtils;
import com.alipay.sdk.cons.C0110c;
import com.alipay.sdk.data.C0115e;
import com.alipay.sdk.data.C0116f;
import com.umeng.analytics.onlineconfig.C1248a;
import org.json.JSONObject;

/* renamed from: com.alipay.sdk.protocol.g */
public final class C0134g extends C0133h {
    /* renamed from: l */
    private int f409l;
    /* renamed from: m */
    private boolean f410m = false;

    protected C0134g(C0115e c0115e, C0116f c0116f) {
        super(c0115e, c0116f);
    }

    /* renamed from: d */
    private boolean m454d() {
        return this.f410m;
    }

    /* renamed from: a */
    public final void mo26a(JSONObject jSONObject) {
        int i = 0;
        super.mo26a(jSONObject);
        if (jSONObject.has(C0110c.f287c)) {
            JSONObject optJSONObject = jSONObject.optJSONObject(C0110c.f287c);
            CharSequence optString = optJSONObject.optString(C1248a.f5654a);
            this.f408k = Boolean.parseBoolean(optJSONObject.optString("oneTime"));
            if (TextUtils.equals("page", optString)) {
                this.f410m = true;
                this.f409l = 9;
            } else if (TextUtils.equals("dialog", optString)) {
                this.f409l = 7;
                this.f410m = false;
            } else if (TextUtils.equals("toast", optString)) {
                C0127b a = C0127b.m426a(optJSONObject, C0110c.f288d);
                this.f409l = 6;
                if (a != null) {
                    C0126a[] a2 = C0126a.m408a(a);
                    int length = a2.length;
                    while (i < length) {
                        C0126a c0126a = a2[i];
                        if (c0126a == C0126a.Confirm || c0126a == C0126a.Alert) {
                            this.f409l = 10;
                        }
                        i++;
                    }
                }
            } else if (!TextUtils.equals("confirm", optString)) {
                this.f410m = TextUtils.equals(optString, "fullscreen");
                this.f409l = 4;
            }
        } else if (C0132f.m447a(jSONObject.optString("status")) == C0132f.POP_TYPE) {
            this.f409l = -10;
        } else {
            this.f409l = 8;
        }
    }

    /* renamed from: a */
    public final boolean mo23a() {
        return this.f409l == 4 || this.f409l == 9;
    }

    /* renamed from: b */
    public final int mo24b() {
        return this.f409l;
    }

    /* renamed from: c */
    public final String mo25c() {
        return null;
    }
}
