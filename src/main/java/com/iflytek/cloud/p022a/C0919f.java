package com.iflytek.cloud.p022a;

import android.content.Context;
import android.text.TextUtils;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.iflytek.cloud.a.f */
public class C0919f {
    /* renamed from: a */
    private String f4381a;
    /* renamed from: b */
    private String f4382b;
    /* renamed from: c */
    private Vector<C0915c> f4383c;
    /* renamed from: d */
    private Vector<C0915c> f4384d;
    /* renamed from: e */
    private Object f4385e;

    public C0919f() {
        this.f4381a = "-1";
        this.f4382b = "zh_CN";
        this.f4383c = null;
        this.f4384d = null;
        this.f4385e = new Object();
        this.f4383c = new Vector();
        this.f4384d = new Vector();
    }

    /* renamed from: b */
    private JSONObject m7006b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ver", this.f4381a);
            jSONObject.put("lang", this.f4382b);
            jSONObject.put("ad", m7009a(this.f4383c));
            jSONObject.put("err", m7009a(this.f4384d));
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    /* renamed from: a */
    public String m7007a() {
        return this.f4381a;
    }

    /* renamed from: a */
    public Vector<C0915c> m7008a(JSONArray jSONArray, boolean z) {
        Vector<C0915c> vector = new Vector();
        int i = 0;
        while (i < jSONArray.length()) {
            try {
                C0915c c0915c = new C0915c(new JSONObject(jSONArray.getString(i)), z);
                if (!z || c0915c.m6988d()) {
                    vector.add(c0915c);
                }
                i++;
            } catch (Exception e) {
            }
        }
        return vector;
    }

    /* renamed from: a */
    public JSONArray m7009a(Vector<C0915c> vector) {
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < vector.size(); i++) {
            jSONArray.put(((C0915c) vector.get(i)).toString());
        }
        return jSONArray;
    }

    /* renamed from: a */
    public void m7010a(C0915c c0915c) {
        this.f4383c.remove(c0915c);
    }

    /* renamed from: a */
    public void m7011a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f4381a = jSONObject.getString("ver");
                this.f4382b = jSONObject.getString("lang");
                synchronized (this.f4385e) {
                    if (jSONObject.has("ad")) {
                        this.f4383c = m7008a(jSONObject.getJSONArray("ad"), true);
                    }
                    if (jSONObject.has("err")) {
                        this.f4384d = m7008a(jSONObject.getJSONArray("err"), false);
                    }
                }
            } catch (JSONException e) {
            }
        }
    }

    /* renamed from: a */
    public boolean m7012a(Context context) {
        return (System.currentTimeMillis() - C0913a.m6973a(context).m6979b("ad_last_update", 0)) / 1000 > 86400;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public com.iflytek.cloud.p022a.C0915c m7013b(android.content.Context r6) {
        /*
        r5 = this;
        r1 = r5.f4385e;
        monitor-enter(r1);
        r0 = r5.f4382b;	 Catch:{ all -> 0x003e }
        r0 = com.iflytek.cloud.resource.Resource.matchLanguage(r0);	 Catch:{ all -> 0x003e }
        if (r0 != 0) goto L_0x0021;
    L_0x000b:
        r0 = com.iflytek.cloud.p022a.C0913a.m6973a(r6);	 Catch:{ all -> 0x003e }
        r2 = "ad_last_update";
        r3 = 0;
        r0.m6978a(r2, r3);	 Catch:{ all -> 0x003e }
    L_0x0016:
        monitor-exit(r1);	 Catch:{ all -> 0x003e }
        r0 = new com.iflytek.cloud.a.c;
        r1 = "";
        r2 = 0;
        r3 = -1;
        r0.<init>(r1, r2, r3);
    L_0x0020:
        return r0;
    L_0x0021:
        r0 = r5.f4383c;	 Catch:{ all -> 0x003e }
        r0 = r0.size();	 Catch:{ all -> 0x003e }
        if (r0 <= 0) goto L_0x0016;
    L_0x0029:
        r0 = r5.f4383c;	 Catch:{ all -> 0x003e }
        r2 = 0;
        r3 = r5.f4383c;	 Catch:{ all -> 0x003e }
        r3 = r3.size();	 Catch:{ all -> 0x003e }
        r2 = com.iflytek.cloud.p023b.p024e.C0943b.m7132a(r2, r3);	 Catch:{ all -> 0x003e }
        r0 = r0.get(r2);	 Catch:{ all -> 0x003e }
        r0 = (com.iflytek.cloud.p022a.C0915c) r0;	 Catch:{ all -> 0x003e }
        monitor-exit(r1);	 Catch:{ all -> 0x003e }
        goto L_0x0020;
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003e }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.a.f.b(android.content.Context):com.iflytek.cloud.a.c");
    }

    public String toString() {
        return m7006b().toString();
    }
}
