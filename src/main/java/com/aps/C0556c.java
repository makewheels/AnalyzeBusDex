package com.aps;

import com.amap.api.location.core.AMapLocException;
import com.amap.api.services.district.DistrictSearchQuery;
import com.iflytek.cloud.speech.SpeechConstant;
import com.umeng.analytics.onlineconfig.C1248a;
import org.json.JSONObject;
import p054u.aly.bi_常量类;

/* compiled from: AmapLoc */
/* renamed from: com.aps.c */
public class C0556c {
    /* renamed from: a */
    private String f3417a = bi_常量类.f6358b;
    /* renamed from: b */
    private double f3418b = 0.0d;
    /* renamed from: c */
    private double f3419c = 0.0d;
    /* renamed from: d */
    private float f3420d = 0.0f;
    /* renamed from: e */
    private float f3421e = 0.0f;
    /* renamed from: f */
    private float f3422f = 0.0f;
    /* renamed from: g */
    private long f3423g = 0;
    /* renamed from: h */
    private AMapLocException f3424h = new AMapLocException();
    /* renamed from: i */
    private String f3425i = "new";
    /* renamed from: j */
    private String f3426j = bi_常量类.f6358b;
    /* renamed from: k */
    private String f3427k = bi_常量类.f6358b;
    /* renamed from: l */
    private String f3428l = bi_常量类.f6358b;
    /* renamed from: m */
    private String f3429m = bi_常量类.f6358b;
    /* renamed from: n */
    private String f3430n = bi_常量类.f6358b;
    /* renamed from: o */
    private String f3431o = bi_常量类.f6358b;
    /* renamed from: p */
    private String f3432p = bi_常量类.f6358b;
    /* renamed from: q */
    private String f3433q = bi_常量类.f6358b;
    /* renamed from: r */
    private String f3434r = bi_常量类.f6358b;
    /* renamed from: s */
    private String f3435s = bi_常量类.f6358b;
    /* renamed from: t */
    private String f3436t = bi_常量类.f6358b;
    /* renamed from: u */
    private String f3437u = bi_常量类.f6358b;
    /* renamed from: v */
    private JSONObject f3438v = null;

    /* renamed from: a */
    public AMapLocException m4428a() {
        return this.f3424h;
    }

    /* renamed from: a */
    public void m4432a(AMapLocException aMapLocException) {
        this.f3424h = aMapLocException;
    }

    /* renamed from: b */
    public String m4435b() {
        return this.f3436t;
    }

    /* renamed from: a */
    public void m4433a(String str) {
        this.f3436t = str;
    }

    /* renamed from: c */
    public String m4438c() {
        return this.f3437u;
    }

    /* renamed from: b */
    public void m4437b(String str) {
        this.f3437u = str;
    }

    public C0556c(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.f3417a = jSONObject.getString("provider");
                this.f3418b = jSONObject.getDouble("lon");
                this.f3419c = jSONObject.getDouble("lat");
                this.f3420d = (float) jSONObject.getLong("accuracy");
                this.f3421e = (float) jSONObject.getLong(SpeechConstant.SPEED);
                this.f3422f = (float) jSONObject.getLong("bearing");
                this.f3425i = jSONObject.getString(C1248a.f5654a);
                this.f3426j = jSONObject.getString("retype");
                this.f3427k = jSONObject.getString("citycode");
                this.f3428l = jSONObject.getString("desc");
                this.f3429m = jSONObject.getString("adcode");
                this.f3430n = jSONObject.getString(DistrictSearchQuery.KEYWORDS_COUNTRY);
                this.f3431o = jSONObject.getString(DistrictSearchQuery.KEYWORDS_PROVINCE);
                this.f3432p = jSONObject.getString(DistrictSearchQuery.KEYWORDS_CITY);
                this.f3433q = jSONObject.getString("road");
                this.f3435s = jSONObject.getString("poiname");
                this.f3437u = jSONObject.getString("floor");
                this.f3436t = jSONObject.getString("poiid");
                this.f3423g = jSONObject.getLong("time");
            } catch (Throwable th) {
                th.printStackTrace();
                C0583t.m4574a(th);
            }
        }
    }

    /* renamed from: c */
    public void m4439c(String str) {
        this.f3417a = str;
    }

    /* renamed from: d */
    public double m4440d() {
        return this.f3418b;
    }

    /* renamed from: a */
    public void m4429a(double d) {
        this.f3418b = d;
    }

    /* renamed from: e */
    public double m4442e() {
        return this.f3419c;
    }

    /* renamed from: b */
    public void m4436b(double d) {
        this.f3419c = d;
    }

    /* renamed from: f */
    public float m4444f() {
        return this.f3420d;
    }

    /* renamed from: a */
    public void m4430a(float f) {
        this.f3420d = f;
    }

    /* renamed from: g */
    public long m4446g() {
        return this.f3423g;
    }

    /* renamed from: a */
    public void m4431a(long j) {
        this.f3423g = j;
    }

    /* renamed from: h */
    public String m4448h() {
        return this.f3425i;
    }

    /* renamed from: d */
    public void m4441d(String str) {
        this.f3425i = str;
    }

    /* renamed from: i */
    public String m4450i() {
        return this.f3426j;
    }

    /* renamed from: e */
    public void m4443e(String str) {
        this.f3426j = str;
    }

    /* renamed from: j */
    public String m4452j() {
        return this.f3427k;
    }

    /* renamed from: f */
    public void m4445f(String str) {
        this.f3427k = str;
    }

    /* renamed from: k */
    public String m4454k() {
        return this.f3428l;
    }

    /* renamed from: g */
    public void m4447g(String str) {
        this.f3428l = str;
    }

    /* renamed from: l */
    public String m4456l() {
        return this.f3429m;
    }

    /* renamed from: h */
    public void m4449h(String str) {
        this.f3429m = str;
    }

    /* renamed from: i */
    public void m4451i(String str) {
        this.f3430n = str;
    }

    /* renamed from: j */
    public void m4453j(String str) {
        this.f3431o = str;
    }

    /* renamed from: k */
    public void m4455k(String str) {
        this.f3432p = str;
    }

    /* renamed from: l */
    public void m4457l(String str) {
        this.f3433q = str;
    }

    /* renamed from: m */
    public void m4459m(String str) {
        this.f3434r = str;
    }

    /* renamed from: n */
    public void m4461n(String str) {
        this.f3435s = str;
    }

    /* renamed from: m */
    public JSONObject m4458m() {
        return this.f3438v;
    }

    /* renamed from: a */
    public void m4434a(JSONObject jSONObject) {
        this.f3438v = jSONObject;
    }

    /* renamed from: n */
    public String m4460n() {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
            jSONObject.put("provider", this.f3417a);
            jSONObject.put("lon", this.f3418b);
            jSONObject.put("lat", this.f3419c);
            jSONObject.put("accuracy", (double) this.f3420d);
            jSONObject.put(SpeechConstant.SPEED, (double) this.f3421e);
            jSONObject.put("bearing", (double) this.f3422f);
            jSONObject.put("time", this.f3423g);
            jSONObject.put(C1248a.f5654a, this.f3425i);
            jSONObject.put("retype", this.f3426j);
            jSONObject.put("citycode", this.f3427k);
            jSONObject.put("desc", this.f3428l);
            jSONObject.put("adcode", this.f3429m);
            jSONObject.put(DistrictSearchQuery.KEYWORDS_COUNTRY, this.f3430n);
            jSONObject.put(DistrictSearchQuery.KEYWORDS_PROVINCE, this.f3431o);
            jSONObject.put(DistrictSearchQuery.KEYWORDS_CITY, this.f3432p);
            jSONObject.put("road", this.f3433q);
            jSONObject.put("street", this.f3434r);
            jSONObject.put("poiname", this.f3435s);
            jSONObject.put("poiid", this.f3436t);
            jSONObject.put("floor", this.f3437u);
        } catch (Throwable e) {
            C0583t.m4574a(e);
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString();
    }
}
