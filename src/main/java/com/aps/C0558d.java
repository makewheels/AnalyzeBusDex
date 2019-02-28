package com.aps;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import p054u.aly.bi_常量类;

/* compiled from: Cache */
/* renamed from: com.aps.d */
public class C0558d {
    /* renamed from: a */
    private static C0558d f3441a = null;
    /* renamed from: b */
    private LinkedHashMap<String, List<C0557a>> f3442b = new LinkedHashMap();
    /* renamed from: c */
    private C0578p f3443c = null;
    /* renamed from: d */
    private long f3444d = 0;

    /* compiled from: Cache */
    /* renamed from: com.aps.d$a */
    static class C0557a {
        /* renamed from: a */
        private C0556c f3439a = null;
        /* renamed from: b */
        private String f3440b = null;

        protected C0557a() {
        }

        /* renamed from: a */
        public C0556c m4462a() {
            return this.f3439a;
        }

        /* renamed from: a */
        public void m4463a(C0556c c0556c) {
            this.f3439a = c0556c;
        }

        /* renamed from: b */
        public String m4465b() {
            return this.f3440b;
        }

        /* renamed from: a */
        public void m4464a(String str) {
            this.f3440b = str.replace("##", "#");
        }
    }

    private C0558d(Context context) {
        try {
            File b = m4472b(context);
            if (b != null) {
                this.f3443c = C0578p.m4551a(b, 1, 1048576);
            }
        } catch (Throwable th) {
        }
    }

    /* renamed from: b */
    private File m4472b(Context context) {
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.getExternalCacheDir().getAbsolutePath()).append(File.separator);
        stringBuilder.append("locationCache");
        return new File(stringBuilder.toString());
    }

    /* renamed from: a */
    static synchronized C0558d m4468a(Context context) {
        C0558d c0558d;
        synchronized (C0558d.class) {
            if (f3441a == null) {
                f3441a = new C0558d(context);
            }
            c0558d = f3441a;
        }
        return c0558d;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    void m4475a(java.lang.String r8, com.aps.C0556c r9, java.lang.StringBuilder r10) {
        /*
        r7 = this;
        r2 = 0;
        r0 = com.aps.C0560f.f3465k;
        if (r0 != 0) goto L_0x0009;
    L_0x0005:
        r7.m4474a();
    L_0x0008:
        return;
    L_0x0009:
        r0 = r7.m4476a(r8, r9);
        if (r0 == 0) goto L_0x0008;
    L_0x000f:
        r0 = r9.m4448h();
        r1 = "mem";
        r0 = r0.equals(r1);
        if (r0 != 0) goto L_0x0008;
    L_0x001b:
        if (r8 == 0) goto L_0x0115;
    L_0x001d:
        r0 = "wifi";
        r0 = r8.contains(r0);
        if (r0 == 0) goto L_0x0115;
    L_0x0025:
        r0 = android.text.TextUtils.isEmpty(r10);
        if (r0 != 0) goto L_0x0008;
    L_0x002b:
        r0 = r9.m4444f();
        r1 = 1133903872; // 0x43960000 float:300.0 double:5.60222949E-315;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 < 0) goto L_0x0109;
    L_0x0035:
        r0 = r10.toString();
        r1 = "#";
        r3 = r0.split(r1);
        r4 = r3.length;
        r1 = r2;
        r0 = r2;
    L_0x0042:
        if (r1 >= r4) goto L_0x0053;
    L_0x0044:
        r5 = r3[r1];
        r6 = ",";
        r5 = r5.contains(r6);
        if (r5 == 0) goto L_0x0050;
    L_0x004e:
        r0 = r0 + 1;
    L_0x0050:
        r1 = r1 + 1;
        goto L_0x0042;
    L_0x0053:
        r1 = 3;
        if (r0 >= r1) goto L_0x0008;
    L_0x0056:
        r0 = com.aps.C0583t.m4572a();
        r7.f3444d = r0;
        r1 = new com.aps.d$a;
        r1.<init>();
        r0 = "mem";
        r9.m4441d(r0);
        r1.m4463a(r9);
        if (r10 == 0) goto L_0x0072;
    L_0x006b:
        r0 = r10.toString();
        r1.m4464a(r0);
    L_0x0072:
        r0 = r7.f3442b;
        if (r0 != 0) goto L_0x007d;
    L_0x0076:
        r0 = new java.util.LinkedHashMap;
        r0.<init>();
        r7.f3442b = r0;
    L_0x007d:
        if (r8 == 0) goto L_0x0008;
    L_0x007f:
        r0 = r7.f3442b;
        r0 = r0.containsKey(r8);
        if (r0 == 0) goto L_0x012a;
    L_0x0087:
        r0 = r7.f3442b;
        r0 = r0.get(r8);
        r0 = (java.util.List) r0;
        if (r0 == 0) goto L_0x009a;
    L_0x0091:
        r3 = r0.contains(r1);
        if (r3 != 0) goto L_0x009a;
    L_0x0097:
        r0.add(r2, r1);
    L_0x009a:
        if (r0 == 0) goto L_0x00a6;
    L_0x009c:
        r1 = r7.f3442b;
        r1.remove(r8);
        r1 = r7.f3442b;
        r1.put(r8, r0);
    L_0x00a6:
        if (r10 == 0) goto L_0x00ae;
    L_0x00a8:
        r0 = r10.length();	 Catch:{ IOException -> 0x018c, Exception -> 0x018f }
        if (r0 != 0) goto L_0x00b5;
    L_0x00ae:
        r10 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x018c, Exception -> 0x018f }
        r0 = "cell#";
        r10.<init>(r0);	 Catch:{ IOException -> 0x018c, Exception -> 0x018f }
    L_0x00b5:
        r0 = r7.f3443c;	 Catch:{ IOException -> 0x018c, Exception -> 0x018f }
        r4 = r0.m4556a(r8);	 Catch:{ IOException -> 0x018c, Exception -> 0x018f }
        if (r4 == 0) goto L_0x00c3;
    L_0x00bd:
        r0 = r4.size();	 Catch:{ IOException -> 0x018c, Exception -> 0x018f }
        if (r0 != 0) goto L_0x0139;
    L_0x00c3:
        r0 = new java.util.HashMap;	 Catch:{ IOException -> 0x018c, Exception -> 0x018f }
        r0.<init>();	 Catch:{ IOException -> 0x018c, Exception -> 0x018f }
        r1 = r10.toString();	 Catch:{ IOException -> 0x018c, Exception -> 0x018f }
        r2 = r9.m4460n();	 Catch:{ IOException -> 0x018c, Exception -> 0x018f }
        r0.put(r1, r2);	 Catch:{ IOException -> 0x018c, Exception -> 0x018f }
        r1 = r7.f3443c;	 Catch:{ IOException -> 0x018c, Exception -> 0x018f }
        r1.m4557b(r8, r0);	 Catch:{ IOException -> 0x018c, Exception -> 0x018f }
    L_0x00d8:
        r0 = "";
        r0 = r7.f3442b;
        r0 = r0.size();
        r1 = 360; // 0x168 float:5.04E-43 double:1.78E-321;
        if (r0 <= r1) goto L_0x0008;
    L_0x00e4:
        r0 = r7.f3442b;
        r0 = r0.entrySet();
        r0 = r0.iterator();
        if (r0 == 0) goto L_0x0008;
    L_0x00f0:
        r1 = r0.hasNext();
        if (r1 == 0) goto L_0x0008;
    L_0x00f6:
        r0 = r0.next();
        r0 = (java.util.Map.Entry) r0;
        r0 = r0.getKey();
        r0 = (java.lang.String) r0;
        r1 = r7.f3442b;
        r1.remove(r0);
        goto L_0x0008;
    L_0x0109:
        r0 = r9.m4444f();
        r1 = 1092616192; // 0x41200000 float:10.0 double:5.398241246E-315;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 > 0) goto L_0x0056;
    L_0x0113:
        goto L_0x0008;
    L_0x0115:
        if (r8 == 0) goto L_0x0056;
    L_0x0117:
        r0 = "cell";
        r0 = r8.contains(r0);
        if (r0 == 0) goto L_0x0056;
    L_0x011f:
        r0 = ",";
        r0 = r10.indexOf(r0);
        r1 = -1;
        if (r0 == r1) goto L_0x0056;
    L_0x0128:
        goto L_0x0008;
    L_0x012a:
        r0 = new java.util.ArrayList;
        r0.<init>();
        r0.add(r1);
        r1 = r7.f3442b;
        r1.put(r8, r0);
        goto L_0x00a6;
    L_0x0139:
        r0 = r4.entrySet();	 Catch:{ IOException -> 0x018c, Exception -> 0x018f }
        r5 = r0.iterator();	 Catch:{ IOException -> 0x018c, Exception -> 0x018f }
        r3 = 1;
    L_0x0142:
        if (r5 == 0) goto L_0x0192;
    L_0x0144:
        r0 = r5.hasNext();	 Catch:{ IOException -> 0x018c, Exception -> 0x018f }
        if (r0 == 0) goto L_0x0192;
    L_0x014a:
        r0 = r5.next();	 Catch:{ IOException -> 0x018c, Exception -> 0x018f }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ IOException -> 0x018c, Exception -> 0x018f }
        r1 = r0.getKey();	 Catch:{ IOException -> 0x018c, Exception -> 0x018f }
        r1 = (java.lang.String) r1;	 Catch:{ IOException -> 0x018c, Exception -> 0x018f }
        r6 = r10.toString();	 Catch:{ IOException -> 0x018c, Exception -> 0x018f }
        r1 = r7.m4470a(r1, r6);	 Catch:{ IOException -> 0x018c, Exception -> 0x018f }
        if (r1 == 0) goto L_0x0142;
    L_0x0160:
        r0 = r0.getKey();	 Catch:{ IOException -> 0x018c, Exception -> 0x018f }
        r4.remove(r0);	 Catch:{ IOException -> 0x018c, Exception -> 0x018f }
        r0 = r10.toString();	 Catch:{ IOException -> 0x018c, Exception -> 0x018f }
        r1 = r9.m4460n();	 Catch:{ IOException -> 0x018c, Exception -> 0x018f }
        r4.put(r0, r1);	 Catch:{ IOException -> 0x018c, Exception -> 0x018f }
        r0 = r7.f3443c;	 Catch:{ IOException -> 0x018c, Exception -> 0x018f }
        r0.m4557b(r8, r4);	 Catch:{ IOException -> 0x018c, Exception -> 0x018f }
        r0 = r2;
    L_0x0178:
        if (r0 == 0) goto L_0x00d8;
    L_0x017a:
        r0 = r10.toString();	 Catch:{ IOException -> 0x018c, Exception -> 0x018f }
        r1 = r9.m4460n();	 Catch:{ IOException -> 0x018c, Exception -> 0x018f }
        r4.put(r0, r1);	 Catch:{ IOException -> 0x018c, Exception -> 0x018f }
        r0 = r7.f3443c;	 Catch:{ IOException -> 0x018c, Exception -> 0x018f }
        r0.m4557b(r8, r4);	 Catch:{ IOException -> 0x018c, Exception -> 0x018f }
        goto L_0x00d8;
    L_0x018c:
        r0 = move-exception;
        goto L_0x00d8;
    L_0x018f:
        r0 = move-exception;
        goto L_0x00d8;
    L_0x0192:
        r0 = r3;
        goto L_0x0178;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aps.d.a(java.lang.String, com.aps.c, java.lang.StringBuilder):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    com.aps.C0556c m4473a(java.lang.String r7, java.lang.StringBuilder r8, java.lang.String r9) {
        /*
        r6 = this;
        r1 = -1;
        r3 = 0;
        r0 = "mem";
        r0 = r9.equals(r0);
        if (r0 == 0) goto L_0x0012;
    L_0x000a:
        r0 = com.aps.C0560f.f3465k;
        if (r0 != 0) goto L_0x0012;
    L_0x000e:
        r6.m4474a();
    L_0x0011:
        return r3;
    L_0x0012:
        r0 = "";
        if (r7 == 0) goto L_0x00a6;
    L_0x0016:
        r0 = "#cellwifi";
        r0 = r7.indexOf(r0);
        if (r0 == r1) goto L_0x00a6;
    L_0x001e:
        r0 = "#cellwifi";
        r2 = r6.m4467a(r7, r8, r0, r9);
        if (r2 == 0) goto L_0x00a3;
    L_0x0026:
        r0 = "found#cellwifi";
    L_0x0028:
        if (r2 != 0) goto L_0x009d;
    L_0x002a:
        if (r8 == 0) goto L_0x0032;
    L_0x002c:
        r0 = r8.length();	 Catch:{ JSONException -> 0x0148, IOException -> 0x0141, Throwable -> 0x013a }
        if (r0 != 0) goto L_0x0039;
    L_0x0032:
        r8 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x0148, IOException -> 0x0141, Throwable -> 0x013a }
        r0 = "cell#";
        r8.<init>(r0);	 Catch:{ JSONException -> 0x0148, IOException -> 0x0141, Throwable -> 0x013a }
    L_0x0039:
        r0 = r6.f3443c;	 Catch:{ JSONException -> 0x0148, IOException -> 0x0141, Throwable -> 0x013a }
        if (r0 == 0) goto L_0x0151;
    L_0x003d:
        r0 = r6.f3443c;	 Catch:{ JSONException -> 0x0148, IOException -> 0x0141, Throwable -> 0x013a }
        r0 = r0.m4556a(r7);	 Catch:{ JSONException -> 0x0148, IOException -> 0x0141, Throwable -> 0x013a }
    L_0x0043:
        if (r0 == 0) goto L_0x009d;
    L_0x0045:
        r0 = r0.entrySet();	 Catch:{ JSONException -> 0x0148, IOException -> 0x0141, Throwable -> 0x013a }
        r4 = r0.iterator();	 Catch:{ JSONException -> 0x0148, IOException -> 0x0141, Throwable -> 0x013a }
    L_0x004d:
        if (r4 == 0) goto L_0x009d;
    L_0x004f:
        r0 = r4.hasNext();	 Catch:{ JSONException -> 0x0148, IOException -> 0x0141, Throwable -> 0x013a }
        if (r0 == 0) goto L_0x009d;
    L_0x0055:
        r0 = r4.next();	 Catch:{ JSONException -> 0x0148, IOException -> 0x0141, Throwable -> 0x013a }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ JSONException -> 0x0148, IOException -> 0x0141, Throwable -> 0x013a }
        r1 = r0.getKey();	 Catch:{ JSONException -> 0x0148, IOException -> 0x0141, Throwable -> 0x013a }
        r1 = (java.lang.String) r1;	 Catch:{ JSONException -> 0x0148, IOException -> 0x0141, Throwable -> 0x013a }
        r5 = r8.toString();	 Catch:{ JSONException -> 0x0148, IOException -> 0x0141, Throwable -> 0x013a }
        r1 = r6.m4470a(r1, r5);	 Catch:{ JSONException -> 0x0148, IOException -> 0x0141, Throwable -> 0x013a }
        if (r1 == 0) goto L_0x014f;
    L_0x006b:
        r0 = r0.getValue();	 Catch:{ JSONException -> 0x0148, IOException -> 0x0141, Throwable -> 0x013a }
        r0 = (java.lang.String) r0;	 Catch:{ JSONException -> 0x0148, IOException -> 0x0141, Throwable -> 0x013a }
        r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0148, IOException -> 0x0141, Throwable -> 0x013a }
        r1.<init>(r0);	 Catch:{ JSONException -> 0x0148, IOException -> 0x0141, Throwable -> 0x013a }
        r0 = new com.aps.c;	 Catch:{ JSONException -> 0x0148, IOException -> 0x0141, Throwable -> 0x013a }
        r0.<init>(r1);	 Catch:{ JSONException -> 0x0148, IOException -> 0x0141, Throwable -> 0x013a }
        r1 = "mem";
        r0.m4441d(r1);	 Catch:{ JSONException -> 0x0148, IOException -> 0x0141, Throwable -> 0x013a }
        r1 = new com.aps.d$a;	 Catch:{ JSONException -> 0x0148, IOException -> 0x0141, Throwable -> 0x013a }
        r1.<init>();	 Catch:{ JSONException -> 0x0148, IOException -> 0x0141, Throwable -> 0x013a }
        r1.m4463a(r0);	 Catch:{ JSONException -> 0x014b, IOException -> 0x0144, Throwable -> 0x013d }
        r0 = r8.toString();	 Catch:{ JSONException -> 0x014b, IOException -> 0x0144, Throwable -> 0x013d }
        r1.m4464a(r0);	 Catch:{ JSONException -> 0x014b, IOException -> 0x0144, Throwable -> 0x013d }
        r0 = r6.f3442b;	 Catch:{ JSONException -> 0x014b, IOException -> 0x0144, Throwable -> 0x013d }
        if (r0 != 0) goto L_0x009a;
    L_0x0093:
        r0 = new java.util.LinkedHashMap;	 Catch:{ JSONException -> 0x014b, IOException -> 0x0144, Throwable -> 0x013d }
        r0.<init>();	 Catch:{ JSONException -> 0x014b, IOException -> 0x0144, Throwable -> 0x013d }
        r6.f3442b = r0;	 Catch:{ JSONException -> 0x014b, IOException -> 0x0144, Throwable -> 0x013d }
    L_0x009a:
        if (r7 != 0) goto L_0x00f9;
    L_0x009c:
        r2 = r1;
    L_0x009d:
        if (r2 != 0) goto L_0x0134;
    L_0x009f:
        r0 = r3;
    L_0x00a0:
        r3 = r0;
        goto L_0x0011;
    L_0x00a3:
        r0 = "no found";
        goto L_0x0028;
    L_0x00a6:
        if (r7 == 0) goto L_0x00c0;
    L_0x00a8:
        r0 = "#wifi";
        r0 = r7.indexOf(r0);
        if (r0 == r1) goto L_0x00c0;
    L_0x00b0:
        r0 = "#wifi";
        r2 = r6.m4467a(r7, r8, r0, r9);
        if (r2 == 0) goto L_0x00bc;
    L_0x00b8:
        r0 = "found#wifi";
        goto L_0x0028;
    L_0x00bc:
        r0 = "no found";
        goto L_0x0028;
    L_0x00c0:
        if (r7 == 0) goto L_0x0156;
    L_0x00c2:
        r0 = "#cell";
        r0 = r7.indexOf(r0);
        if (r0 == r1) goto L_0x0156;
    L_0x00ca:
        r0 = "mem";
        r0 = r9.equals(r0);
        if (r0 == 0) goto L_0x0154;
    L_0x00d2:
        r0 = r6.f3442b;
        r0 = r0.get(r7);
        r0 = (java.util.List) r0;
        if (r0 == 0) goto L_0x0154;
    L_0x00dc:
        r1 = r0.size();
        if (r1 <= 0) goto L_0x0154;
    L_0x00e2:
        r1 = r0.size();
        r1 = r1 + -1;
        r0 = r0.get(r1);
        r0 = (com.aps.C0558d.C0557a) r0;
        r2 = r0;
    L_0x00ef:
        if (r2 == 0) goto L_0x00f5;
    L_0x00f1:
        r0 = "found#cell";
        goto L_0x0028;
    L_0x00f5:
        r0 = "no found";
        goto L_0x0028;
    L_0x00f9:
        r0 = r6.f3442b;	 Catch:{ JSONException -> 0x014b, IOException -> 0x0144, Throwable -> 0x013d }
        r0 = r0.containsKey(r7);	 Catch:{ JSONException -> 0x014b, IOException -> 0x0144, Throwable -> 0x013d }
        if (r0 == 0) goto L_0x0125;
    L_0x0101:
        r0 = r6.f3442b;	 Catch:{ JSONException -> 0x014b, IOException -> 0x0144, Throwable -> 0x013d }
        r0 = r0.get(r7);	 Catch:{ JSONException -> 0x014b, IOException -> 0x0144, Throwable -> 0x013d }
        r0 = (java.util.List) r0;	 Catch:{ JSONException -> 0x014b, IOException -> 0x0144, Throwable -> 0x013d }
        if (r0 == 0) goto L_0x0115;
    L_0x010b:
        r2 = r0.contains(r1);	 Catch:{ JSONException -> 0x014b, IOException -> 0x0144, Throwable -> 0x013d }
        if (r2 != 0) goto L_0x0115;
    L_0x0111:
        r2 = 0;
        r0.add(r2, r1);	 Catch:{ JSONException -> 0x014b, IOException -> 0x0144, Throwable -> 0x013d }
    L_0x0115:
        if (r0 == 0) goto L_0x0121;
    L_0x0117:
        r2 = r6.f3442b;	 Catch:{ JSONException -> 0x014b, IOException -> 0x0144, Throwable -> 0x013d }
        r2.remove(r7);	 Catch:{ JSONException -> 0x014b, IOException -> 0x0144, Throwable -> 0x013d }
        r2 = r6.f3442b;	 Catch:{ JSONException -> 0x014b, IOException -> 0x0144, Throwable -> 0x013d }
        r2.put(r7, r0);	 Catch:{ JSONException -> 0x014b, IOException -> 0x0144, Throwable -> 0x013d }
    L_0x0121:
        r0 = r1;
    L_0x0122:
        r2 = r0;
        goto L_0x004d;
    L_0x0125:
        r0 = new java.util.ArrayList;	 Catch:{ JSONException -> 0x014b, IOException -> 0x0144, Throwable -> 0x013d }
        r0.<init>();	 Catch:{ JSONException -> 0x014b, IOException -> 0x0144, Throwable -> 0x013d }
        r0.add(r1);	 Catch:{ JSONException -> 0x014b, IOException -> 0x0144, Throwable -> 0x013d }
        r2 = r6.f3442b;	 Catch:{ JSONException -> 0x014b, IOException -> 0x0144, Throwable -> 0x013d }
        r2.put(r7, r0);	 Catch:{ JSONException -> 0x014b, IOException -> 0x0144, Throwable -> 0x013d }
        r0 = r1;
        goto L_0x0122;
    L_0x0134:
        r0 = r2.m4462a();
        goto L_0x00a0;
    L_0x013a:
        r0 = move-exception;
        goto L_0x009d;
    L_0x013d:
        r0 = move-exception;
        r2 = r1;
        goto L_0x009d;
    L_0x0141:
        r0 = move-exception;
        goto L_0x009d;
    L_0x0144:
        r0 = move-exception;
        r2 = r1;
        goto L_0x009d;
    L_0x0148:
        r0 = move-exception;
        goto L_0x009d;
    L_0x014b:
        r0 = move-exception;
        r2 = r1;
        goto L_0x009d;
    L_0x014f:
        r0 = r2;
        goto L_0x0122;
    L_0x0151:
        r0 = r3;
        goto L_0x0043;
    L_0x0154:
        r2 = r3;
        goto L_0x00ef;
    L_0x0156:
        r2 = r3;
        goto L_0x0028;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aps.d.a(java.lang.String, java.lang.StringBuilder, java.lang.String):com.aps.c");
    }

    /* renamed from: a */
    boolean m4476a(String str, C0556c c0556c) {
        if (str == null || c0556c == null || str.indexOf("#network") == -1 || c0556c.m4440d() == 0.0d) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    void m4474a() {
        this.f3444d = 0;
        this.f3442b.clear();
    }

    /* renamed from: a */
    private C0557a m4467a(String str, StringBuilder stringBuilder, String str2, String str3) {
        Iterator it;
        C0557a c0557a = null;
        Hashtable hashtable = new Hashtable();
        Hashtable hashtable2 = new Hashtable();
        Hashtable hashtable3 = new Hashtable();
        if (str3.equals("mem")) {
            it = this.f3442b.entrySet().iterator();
        } else {
            it = null;
        }
        Object obj = 1;
        while (it != null && it.hasNext()) {
            List list;
            Object obj2;
            String str4;
            if (obj != null) {
                str4 = str;
                list = (List) this.f3442b.get(str);
                obj2 = null;
            } else {
                Entry entry = (Entry) it.next();
                str4 = (String) entry.getKey();
                list = (List) entry.getValue();
                obj2 = obj;
            }
            if (c0557a != null) {
                break;
            } else if (list == null) {
                obj = obj2;
            } else {
                C0557a c0557a2;
                for (int i = 0; i < list.size(); i++) {
                    c0557a2 = (C0557a) list.get(i);
                    if (!(TextUtils.isEmpty(c0557a2.m4465b()) || TextUtils.isEmpty(stringBuilder) || r12.indexOf(str2) == -1)) {
                        Object obj3;
                        if (!m4471a(c0557a2.m4465b(), stringBuilder)) {
                            obj3 = null;
                        } else if (c0557a2.m4462a().m4444f() > 300.0f) {
                            obj3 = null;
                        } else {
                            int i2 = 1;
                        }
                        m4469a(c0557a2.m4465b(), hashtable);
                        m4469a(stringBuilder.toString(), hashtable2);
                        hashtable3.clear();
                        for (String put : hashtable.keySet()) {
                            hashtable3.put(put, bi_常量类.f6358b_空串);
                        }
                        for (String put2 : hashtable2.keySet()) {
                            hashtable3.put(put2, bi_常量类.f6358b_空串);
                        }
                        Set<String> keySet = hashtable3.keySet();
                        double[] dArr = new double[keySet.size()];
                        double[] dArr2 = new double[keySet.size()];
                        int i3 = 0;
                        for (String put22 : keySet) {
                            dArr[i3] = hashtable.containsKey(put22) ? 1.0d : 0.0d;
                            dArr2[i3] = hashtable2.containsKey(put22) ? 1.0d : 0.0d;
                            i3++;
                        }
                        keySet.clear();
                        double a = m4466a(dArr, dArr2);
                        if (str3.equals("mem")) {
                            if (obj3 != null && a > 0.8500000238418579d) {
                                break;
                            } else if (a > 0.8500000238418579d) {
                                break;
                            }
                        } else {
                            if (str3.equals("db") && a > 0.8500000238418579d) {
                                break;
                            }
                        }
                    }
                }
                c0557a2 = c0557a;
                obj = obj2;
                c0557a = c0557a2;
            }
        }
        hashtable.clear();
        hashtable2.clear();
        hashtable3.clear();
        return c0557a;
    }

    /* renamed from: a */
    private boolean m4470a(String str, String str2) {
        Hashtable hashtable = new Hashtable();
        Hashtable hashtable2 = new Hashtable();
        Hashtable hashtable3 = new Hashtable();
        m4469a(str2, hashtable);
        m4469a(str, hashtable2);
        hashtable3.clear();
        for (String put : hashtable.keySet()) {
            hashtable3.put(put, bi_常量类.f6358b_空串);
        }
        for (String put2 : hashtable2.keySet()) {
            hashtable3.put(put2, bi_常量类.f6358b_空串);
        }
        Set<String> keySet = hashtable3.keySet();
        double[] dArr = new double[keySet.size()];
        double[] dArr2 = new double[keySet.size()];
        int i = 0;
        for (String put22 : keySet) {
            dArr[i] = hashtable.containsKey(put22) ? 1.0d : 0.0d;
            dArr2[i] = hashtable2.containsKey(put22) ? 1.0d : 0.0d;
            i++;
        }
        keySet.clear();
        double a = m4466a(dArr, dArr2);
        hashtable.clear();
        hashtable2.clear();
        hashtable3.clear();
        if (a > 0.8500000238418579d) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private boolean m4471a(String str, StringBuilder stringBuilder) {
        int indexOf = str.indexOf(",access");
        if (indexOf == -1 || indexOf < 17 || stringBuilder.indexOf(",access") == -1) {
            return false;
        }
        if (stringBuilder.toString().indexOf(str.substring(indexOf - 17, indexOf) + ",access") != -1) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private void m4469a(String str, Hashtable<String, String> hashtable) {
        hashtable.clear();
        for (String str2 : str.split("#")) {
            if (str2.length() > 0) {
                hashtable.put(str2, bi_常量类.f6358b_空串);
            }
        }
    }

    /* renamed from: a */
    private double m4466a(double[] dArr, double[] dArr2) {
        double d = 0.0d;
        double d2 = 0.0d;
        double d3 = 0.0d;
        for (int i = 0; i < dArr.length; i++) {
            d2 += dArr[i] * dArr[i];
            d += dArr2[i] * dArr2[i];
            d3 += dArr[i] * dArr2[i];
        }
        return d3 / (Math.sqrt(d) * Math.sqrt(d2));
    }
}
