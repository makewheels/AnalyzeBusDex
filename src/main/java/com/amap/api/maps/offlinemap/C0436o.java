package com.amap.api.maps.offlinemap;

import com.amap.api.mapcore.util.az;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import org.json.JSONObject;
import p054u.aly.bi_常量类;

/* compiled from: UpdateItem */
/* renamed from: com.amap.api.maps.offlinemap.o */
class C0436o {
    /* renamed from: a */
    public int f2504a = 3;
    /* renamed from: b */
    long f2505b = 0;
    /* renamed from: c */
    private String f2506c = null;
    /* renamed from: d */
    private String f2507d = null;
    /* renamed from: e */
    private String f2508e = null;
    /* renamed from: f */
    private String f2509f = null;
    /* renamed from: g */
    private String f2510g = bi_常量类.f6358b;
    /* renamed from: h */
    private long f2511h = 0;
    /* renamed from: i */
    private long f2512i = 0;
    /* renamed from: j */
    private String f2513j;
    /* renamed from: k */
    private String f2514k;
    /* renamed from: l */
    private int f2515l;
    /* renamed from: m */
    private boolean f2516m = false;
    /* renamed from: n */
    private int f2517n;
    /* renamed from: o */
    private String f2518o = bi_常量类.f6358b;

    public C0436o(OfflineMapCity offlineMapCity) {
        this.f2506c = offlineMapCity.getCity();
        this.f2508e = offlineMapCity.getAdcode();
        this.f2507d = offlineMapCity.getUrl();
        this.f2512i = offlineMapCity.getSize();
        m3720a();
        this.f2510g = offlineMapCity.getVersion();
        this.f2518o = offlineMapCity.getCode();
        this.f2516m = false;
        this.f2504a = offlineMapCity.getState();
    }

    public C0436o(OfflineMapProvince offlineMapProvince) {
        this.f2506c = offlineMapProvince.getProvinceName();
        this.f2508e = offlineMapProvince.getProvinceCode();
        this.f2507d = offlineMapProvince.getUrl();
        this.f2512i = offlineMapProvince.getSize();
        m3720a();
        this.f2510g = offlineMapProvince.getVersion();
        this.f2516m = true;
        this.f2504a = offlineMapProvince.getState();
    }

    /* renamed from: a */
    protected void m3720a() {
        String a = C0425d.m3655a();
        this.f2509f = a + this.f2508e + ".zip" + ".tmp";
        try {
            if (!new File(a + this.f2508e).exists() && !new File(a + this.f2508e + ".zip" + ".tmp").exists()) {
                new File(this.f2509f).createNewFile();
            }
        } catch (Throwable e) {
            az.m3143a(e, "UpdateItem", "init");
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public String m3725b() {
        return this.f2506c;
    }

    /* renamed from: a */
    public void m3723a(String str) {
        this.f2506c = str;
    }

    /* renamed from: c */
    public String m3729c() {
        return this.f2510g;
    }

    /* renamed from: b */
    public void m3728b(String str) {
        this.f2510g = str;
    }

    /* renamed from: d */
    public String m3731d() {
        return this.f2509f;
    }

    /* renamed from: c */
    public void m3730c(String str) {
        this.f2509f = str;
    }

    /* renamed from: e */
    public String m3733e() {
        return this.f2508e;
    }

    /* renamed from: d */
    public void m3732d(String str) {
        this.f2508e = str;
    }

    /* renamed from: f */
    public String m3735f() {
        return this.f2507d;
    }

    /* renamed from: e */
    public void m3734e(String str) {
        this.f2507d = str;
    }

    /* renamed from: g */
    public long m3737g() {
        return this.f2512i;
    }

    /* renamed from: a */
    public void m3721a(int i) {
        this.f2515l = i;
    }

    /* renamed from: h */
    public int m3739h() {
        return this.f2515l;
    }

    /* renamed from: i */
    public long m3741i() {
        return this.f2511h;
    }

    /* renamed from: a */
    public void m3722a(long j) {
        this.f2511h = j;
    }

    /* renamed from: j */
    public long m3743j() {
        return this.f2512i;
    }

    /* renamed from: b */
    public void m3727b(long j) {
        this.f2512i = j;
    }

    /* renamed from: k */
    public String m3744k() {
        return this.f2513j;
    }

    /* renamed from: f */
    public void m3736f(String str) {
        this.f2513j = str;
    }

    /* renamed from: l */
    public String m3745l() {
        return this.f2514k;
    }

    /* renamed from: g */
    public void m3738g(String str) {
        this.f2514k = str;
    }

    /* renamed from: m */
    public boolean m3746m() {
        return this.f2516m;
    }

    /* renamed from: a */
    public void m3724a(boolean z) {
        this.f2516m = z;
    }

    /* renamed from: b */
    public void m3726b(int i) {
        this.f2517n = i;
    }

    /* renamed from: n */
    public int m3747n() {
        return this.f2517n;
    }

    /* renamed from: h */
    public void m3740h(String str) {
        this.f2518o = str;
    }

    /* renamed from: o */
    public String m3748o() {
        return this.f2518o;
    }

    /* renamed from: i */
    public void m3742i(String str) {
        if (str != null) {
            try {
                if (!str.equals(bi_常量类.f6358b)) {
                    JSONObject jSONObject = new JSONObject(str).getJSONObject("file");
                    if (jSONObject != null) {
                        this.f2506c = jSONObject.optString("title");
                        this.f2508e = jSONObject.optString("code");
                        this.f2507d = jSONObject.optString("url");
                        this.f2509f = jSONObject.optString("fileName");
                        this.f2511h = jSONObject.optLong("lLocalLength");
                        this.f2512i = jSONObject.optLong("lRemoteLength");
                        this.f2504a = jSONObject.optInt("mState");
                        this.f2505b = jSONObject.optLong("Schedule");
                        this.f2510g = jSONObject.optString("version");
                        this.f2514k = jSONObject.optString("localPath");
                        this.f2513j = jSONObject.optString("vMapFileNames");
                        this.f2516m = jSONObject.optBoolean("isSheng");
                        this.f2517n = jSONObject.optInt("mCompleteCode");
                        this.f2518o = jSONObject.optString("mCityCode");
                    }
                }
            } catch (Throwable e) {
                az.m3143a(e, "UpdateItem", "readFileToJSONObject");
                e.printStackTrace();
            }
        }
    }

    /* renamed from: p */
    public void m3749p() {
        Throwable e;
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("title", this.f2506c);
            jSONObject2.put("code", this.f2508e);
            jSONObject2.put("url", this.f2507d);
            jSONObject2.put("fileName", this.f2509f);
            jSONObject2.put("lLocalLength", this.f2511h);
            jSONObject2.put("lRemoteLength", this.f2512i);
            jSONObject2.put("mState", this.f2504a);
            jSONObject2.put("Schedule", this.f2505b);
            jSONObject2.put("version", this.f2510g);
            jSONObject2.put("localPath", this.f2514k);
            if (this.f2513j != null) {
                jSONObject2.put("vMapFileNames", this.f2513j);
            }
            jSONObject2.put("isSheng", this.f2516m);
            jSONObject2.put("mCompleteCode", this.f2517n);
            jSONObject2.put("mCityCode", this.f2518o);
            jSONObject.put("file", jSONObject2);
            File file = new File(this.f2509f + ".dt");
            file.delete();
            OutputStreamWriter outputStreamWriter;
            try {
                outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file, true), "utf-8");
                try {
                    outputStreamWriter.write(jSONObject.toString());
                    if (outputStreamWriter != null) {
                        try {
                            outputStreamWriter.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    try {
                        az.m3143a(e, "UpdateItem", "saveJSONObjectToFile");
                        e.printStackTrace();
                        if (outputStreamWriter != null) {
                            try {
                                outputStreamWriter.close();
                            } catch (IOException e22) {
                                e22.printStackTrace();
                            }
                        }
                    } catch (Throwable th) {
                        e = th;
                        if (outputStreamWriter != null) {
                            try {
                                outputStreamWriter.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw e;
                    }
                }
            } catch (IOException e5) {
                e = e5;
                outputStreamWriter = null;
                az.m3143a(e, "UpdateItem", "saveJSONObjectToFile");
                e.printStackTrace();
                if (outputStreamWriter != null) {
                    outputStreamWriter.close();
                }
            } catch (Throwable th2) {
                e = th2;
                outputStreamWriter = null;
                if (outputStreamWriter != null) {
                    outputStreamWriter.close();
                }
                throw e;
            }
        } catch (Throwable e6) {
            az.m3143a(e6, "UpdateItem", "saveJSONObjectToFile parseJson");
            e6.printStackTrace();
        }
    }
}
