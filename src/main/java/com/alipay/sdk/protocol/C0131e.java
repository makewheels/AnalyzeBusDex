package com.alipay.sdk.protocol;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.cons.C0109b;
import com.alipay.sdk.cons.C0110c;
import com.alipay.sdk.data.C0111a;
import com.alipay.sdk.data.C0115e;
import com.alipay.sdk.data.C0116f;
import com.alipay.sdk.exception.NetErrorException;
import com.alipay.sdk.sys.C0136b;
import com.alipay.sdk.tid.C0138a;
import com.alipay.sdk.tid.C0139b;
import com.alipay.sdk.util.C0141b;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;
import p054u.aly.bi;

/* renamed from: com.alipay.sdk.protocol.e */
public final class C0131e {
    /* renamed from: a */
    public static C0134g m445a(C0128c c0128c) throws NetErrorException {
        C0115e c0115e = c0128c.f391a;
        C0116f c0116f = c0128c.f392b;
        JSONObject jSONObject = c0128c.f393c;
        C0134g c0134g;
        if (jSONObject.has(C0110c.f287c)) {
            c0134g = new C0134g(c0115e, c0116f);
            c0134g.mo26a(c0128c.f393c);
            return c0134g;
        } else if (!jSONObject.has("status")) {
            return null;
        } else {
            switch (C0132f.m447a(jSONObject.optString("status"))) {
                case SUCCESS:
                case NOT_POP_TYPE:
                case POP_TYPE:
                    c0134g = new C0134g(c0115e, c0116f);
                    c0134g.mo26a(jSONObject);
                    return c0134g;
                case TID_REFRESH:
                    Context context = C0136b.m459a().f414a;
                    String a = C0141b.m491a(context).m497a();
                    String b = C0141b.m491a(context).m498b();
                    C0138a c0138a = new C0138a(context);
                    c0138a.m476a(a, b);
                    c0138a.close();
                    return null;
                default:
                    return null;
            }
        }
    }

    /* renamed from: b */
    private static void m446b(C0128c c0128c) throws NetErrorException {
        C0116f c0116f = c0128c.f392b;
        JSONObject jSONObject = c0128c.f393c;
        C0111a c0111a = c0128c.f391a.f316a;
        C0111a c0111a2 = c0128c.f392b.f334l;
        if (TextUtils.isEmpty(c0111a2.f301c)) {
            c0111a2.f301c = c0111a.f301c;
        }
        if (TextUtils.isEmpty(c0111a2.f302d)) {
            c0111a2.f302d = c0111a.f302d;
        }
        if (TextUtils.isEmpty(c0111a2.f300b)) {
            c0111a2.f300b = c0111a.f300b;
        }
        if (TextUtils.isEmpty(c0111a2.f299a)) {
            c0111a2.f299a = c0111a.f299a;
        }
        String str = "session";
        JSONObject optJSONObject = jSONObject.optJSONObject("reflected_data");
        if (optJSONObject != null) {
            "session = " + optJSONObject.optString(str, bi.f6358b);
            c0128c.f392b.f331i = optJSONObject;
        } else if (jSONObject.has(str)) {
            optJSONObject = new JSONObject();
            try {
                optJSONObject.put(str, jSONObject.optString(str));
                CharSequence charSequence = C0139b.m480a().f422a;
                if (!TextUtils.isEmpty(charSequence)) {
                    optJSONObject.put(C0109b.f277c, charSequence);
                }
                c0116f.f331i = optJSONObject;
            } catch (JSONException e) {
            }
        }
        c0116f.f328f = jSONObject.optString("end_code", "0");
        c0116f.f332j = jSONObject.optString("user_id", bi.f6358b);
        str = jSONObject.optString("result");
        try {
            str = URLDecoder.decode(jSONObject.optString("result"), "UTF-8");
        } catch (UnsupportedEncodingException e2) {
        }
        c0116f.f329g = str;
        c0116f.f330h = jSONObject.optString("memo", bi.f6358b);
    }
}
