package com.tencent.wxop.stat.common;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.wxop.stat.C1178a;
import com.tencent.wxop.stat.StatConfig;
import com.tencent.wxop.stat.au;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.wxop.stat.common.d */
class C1185d {
    /* renamed from: a */
    String f5442a;
    /* renamed from: b */
    String f5443b;
    /* renamed from: c */
    DisplayMetrics f5444c;
    /* renamed from: d */
    int f5445d;
    /* renamed from: e */
    String f5446e;
    /* renamed from: f */
    String f5447f;
    /* renamed from: g */
    String f5448g;
    /* renamed from: h */
    String f5449h;
    /* renamed from: i */
    String f5450i;
    /* renamed from: j */
    String f5451j;
    /* renamed from: k */
    String f5452k;
    /* renamed from: l */
    int f5453l;
    /* renamed from: m */
    String f5454m;
    /* renamed from: n */
    String f5455n;
    /* renamed from: o */
    Context f5456o;
    /* renamed from: p */
    private String f5457p;
    /* renamed from: q */
    private String f5458q;
    /* renamed from: r */
    private String f5459r;
    /* renamed from: s */
    private String f5460s;

    private C1185d(Context context) {
        this.f5443b = StatConstants.VERSION;
        this.f5445d = VERSION.SDK_INT;
        this.f5446e = Build.MODEL;
        this.f5447f = Build.MANUFACTURER;
        this.f5448g = Locale.getDefault().getLanguage();
        this.f5453l = 0;
        this.f5454m = null;
        this.f5455n = null;
        this.f5456o = null;
        this.f5457p = null;
        this.f5458q = null;
        this.f5459r = null;
        this.f5460s = null;
        this.f5456o = context.getApplicationContext();
        this.f5444c = C1192k.m8288d(this.f5456o);
        this.f5442a = C1192k.m8299j(this.f5456o);
        this.f5449h = StatConfig.getInstallChannel(this.f5456o);
        this.f5450i = C1192k.m8298i(this.f5456o);
        this.f5451j = TimeZone.getDefault().getID();
        this.f5453l = C1192k.m8304o(this.f5456o);
        this.f5452k = C1192k.m8305p(this.f5456o);
        this.f5454m = this.f5456o.getPackageName();
        if (this.f5445d >= 14) {
            this.f5457p = C1192k.m8311v(this.f5456o);
        }
        this.f5458q = C1192k.m8310u(this.f5456o).toString();
        this.f5459r = C1192k.m8309t(this.f5456o);
        this.f5460s = C1192k.m8289d();
        this.f5455n = C1192k.m8269C(this.f5456o);
    }

    /* renamed from: a */
    void m8254a(JSONObject jSONObject, Thread thread) {
        if (thread == null) {
            if (this.f5444c != null) {
                jSONObject.put("sr", this.f5444c.widthPixels + "*" + this.f5444c.heightPixels);
                jSONObject.put("dpi", this.f5444c.xdpi + "*" + this.f5444c.ydpi);
            }
            if (C1178a.m8165a(this.f5456o).m8177e()) {
                JSONObject jSONObject2 = new JSONObject();
                C1198q.m8331a(jSONObject2, "bs", C1198q.m8336d(this.f5456o));
                C1198q.m8331a(jSONObject2, "ss", C1198q.m8337e(this.f5456o));
                if (jSONObject2.length() > 0) {
                    C1198q.m8331a(jSONObject, "wf", jSONObject2.toString());
                }
            }
            JSONArray a = C1198q.m8330a(this.f5456o, 10);
            if (a != null && a.length() > 0) {
                C1198q.m8331a(jSONObject, "wflist", a.toString());
            }
            C1198q.m8331a(jSONObject, "sen", this.f5457p);
        } else {
            C1198q.m8331a(jSONObject, "thn", thread.getName());
            C1198q.m8331a(jSONObject, "qq", StatConfig.getQQ(this.f5456o));
            C1198q.m8331a(jSONObject, "cui", StatConfig.getCustomUserId(this.f5456o));
            if (C1192k.m8287c(this.f5459r) && this.f5459r.split("/").length == 2) {
                C1198q.m8331a(jSONObject, "fram", this.f5459r.split("/")[0]);
            }
            if (C1192k.m8287c(this.f5460s) && this.f5460s.split("/").length == 2) {
                C1198q.m8331a(jSONObject, "from", this.f5460s.split("/")[0]);
            }
            if (au.m8199a(this.f5456o).m8232b(this.f5456o) != null) {
                jSONObject.put("ui", au.m8199a(this.f5456o).m8232b(this.f5456o).m8248b());
            }
            C1198q.m8331a(jSONObject, "mid", StatConfig.getLocalMidOnly(this.f5456o));
        }
        C1198q.m8331a(jSONObject, "pcn", C1192k.m8306q(this.f5456o));
        C1198q.m8331a(jSONObject, "osn", VERSION.RELEASE);
        C1198q.m8331a(jSONObject, "av", this.f5442a);
        C1198q.m8331a(jSONObject, "ch", this.f5449h);
        C1198q.m8331a(jSONObject, "mf", this.f5447f);
        C1198q.m8331a(jSONObject, "sv", this.f5443b);
        C1198q.m8331a(jSONObject, "osd", Build.DISPLAY);
        C1198q.m8331a(jSONObject, "prod", Build.PRODUCT);
        C1198q.m8331a(jSONObject, "tags", Build.TAGS);
        C1198q.m8331a(jSONObject, "id", Build.ID);
        C1198q.m8331a(jSONObject, "fng", Build.FINGERPRINT);
        C1198q.m8331a(jSONObject, "lch", this.f5455n);
        C1198q.m8331a(jSONObject, "ov", Integer.toString(this.f5445d));
        jSONObject.put("os", 1);
        C1198q.m8331a(jSONObject, "op", this.f5450i);
        C1198q.m8331a(jSONObject, "lg", this.f5448g);
        C1198q.m8331a(jSONObject, "md", this.f5446e);
        C1198q.m8331a(jSONObject, "tz", this.f5451j);
        if (this.f5453l != 0) {
            jSONObject.put("jb", this.f5453l);
        }
        C1198q.m8331a(jSONObject, "sd", this.f5452k);
        C1198q.m8331a(jSONObject, "apn", this.f5454m);
        C1198q.m8331a(jSONObject, "cpu", this.f5458q);
        C1198q.m8331a(jSONObject, "abi", Build.CPU_ABI);
        C1198q.m8331a(jSONObject, "abi2", Build.CPU_ABI2);
        C1198q.m8331a(jSONObject, "ram", this.f5459r);
        C1198q.m8331a(jSONObject, "rom", this.f5460s);
    }
}
