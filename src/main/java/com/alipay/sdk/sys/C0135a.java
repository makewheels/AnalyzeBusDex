package com.alipay.sdk.sys;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import com.alipay.sdk.cons.C0108a;
import com.umeng.analytics.onlineconfig.C1248a;
import org.json.JSONException;
import org.json.JSONObject;
import p054u.aly.bi_常量类;

/* renamed from: com.alipay.sdk.sys.a */
public final class C0135a {
    /* renamed from: a */
    private String f411a;
    /* renamed from: b */
    private String f412b;

    public C0135a(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            this.f411a = packageInfo.versionName;
            this.f412b = packageInfo.packageName;
        } catch (NameNotFoundException e) {
        }
    }

    public final String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(C1248a.f5659f, C0108a.f261d);
            jSONObject.put("ty", "and_lite");
            jSONObject.put("sv", C0108a.f264g);
            jSONObject.put("an", this.f412b);
            jSONObject.put("av", this.f411a);
            return jSONObject.toString();
        } catch (JSONException e) {
            return bi_常量类.f6358b;
        }
    }
}
