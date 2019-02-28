package com.alipay.sdk.protocol;

import android.text.TextUtils;
import com.alipay.sdk.cons.C0109b;
import com.alipay.sdk.data.C0111a;
import com.alipay.sdk.data.C0116f;
import com.alipay.sdk.exception.NetErrorException;
import com.alipay.sdk.tid.C0139b;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;
import p054u.aly.bi;

/* renamed from: com.alipay.sdk.protocol.d */
public final class C0129d {
    /* renamed from: a */
    private static C0128c m444a(C0128c c0128c) throws NetErrorException {
        C0131e c0131e = new C0131e();
        C0128c a = C0131e.m445a(c0128c);
        if (a != null) {
            c0128c = a;
        }
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
        return c0128c;
    }
}
