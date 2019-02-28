package com.amap.api.maps.offlinemap;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.amap.api.mapcore.C0344n;
import com.amap.api.mapcore.util.C0405u;
import com.amap.api.mapcore.util.C0407w;
import com.amap.api.mapcore.util.C0409y;
import com.amap.api.mapcore.util.ae;
import com.amap.api.mapcore.util.az;
import com.amap.api.maps.AMapException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import p054u.aly.bi_常量类;

/* compiled from: OfflineUpdateCityHandler */
/* renamed from: com.amap.api.maps.offlinemap.j */
class C0432j extends C0428k<String, List<OfflineMapProvince>> {
    /* renamed from: j */
    private Context f2485j;

    /* renamed from: b */
    protected /* synthetic */ Object mo623b(String str) throws AMapException {
        return m3698a(str);
    }

    /* renamed from: b */
    protected /* synthetic */ Object mo625b(byte[] bArr) throws AMapException {
        return mo624a(bArr);
    }

    public C0432j(Context context, String str) {
        super(context, str);
        getClass();
        m3047a(5000);
        getClass();
        m3050b(50000);
    }

    /* renamed from: a */
    public void m3700a(Context context) {
        this.f2485j = context;
    }

    /* renamed from: a */
    protected List<OfflineMapProvince> mo624a(byte[] bArr) throws AMapException {
        String str;
        Throwable e;
        List<OfflineMapProvince> arrayList = new ArrayList();
        try {
            str = new String(bArr, "utf-8");
            try {
                C0405u.m3464a(str);
                if (!(str == null || bi_常量类.f6358b.equals(str))) {
                    String optString = new JSONObject(str).optString("status");
                    if (!(optString == null || optString.equals(bi_常量类.f6358b) || optString.equals("0"))) {
                        if (this.f2485j != null) {
                            m3696c(str);
                        }
                        try {
                            arrayList = C0437p.m3763c(str);
                        } catch (Throwable e2) {
                            az.m3143a(e2, "OfflineUpdateCityHandler", "loadData parseJson");
                            e2.printStackTrace();
                        }
                    }
                }
            } catch (Throwable th) {
                e2 = th;
                az.m3143a(e2, "OfflineUpdateCityHandler", "loadData jsonInit");
                e2.printStackTrace();
                arrayList = C0437p.m3763c(str);
                return arrayList;
            }
        } catch (Throwable th2) {
            e2 = th2;
            str = null;
            az.m3143a(e2, "OfflineUpdateCityHandler", "loadData jsonInit");
            e2.printStackTrace();
            arrayList = C0437p.m3763c(str);
            return arrayList;
        }
        return arrayList;
    }

    /* renamed from: c */
    private void m3696c(String str) {
        Throwable e;
        if (!C0405u.m3476b(this.f2485j).equals(bi_常量类.f6358b)) {
            File file = new File(C0405u.m3476b(this.f2485j) + "offlinemap3.png");
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (Throwable e2) {
                    az.m3143a(e2, "OfflineUpdateCityHandler", "writeSD dirCreate");
                    e2.printStackTrace();
                }
            }
            if (m3697a() > 1048576) {
                OutputStream fileOutputStream;
                try {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        fileOutputStream.write(str.getBytes("utf-8"));
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                    } catch (FileNotFoundException e4) {
                        e = e4;
                        try {
                            az.m3143a(e, "OfflineUpdateCityHandler", "writeSD filenotfound");
                            e.printStackTrace();
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e32) {
                                    e32.printStackTrace();
                                }
                            }
                        } catch (Throwable th) {
                            e = th;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                            }
                            throw e;
                        }
                    } catch (IOException e6) {
                        e = e6;
                        az.m3143a(e, "OfflineUpdateCityHandler", "writeSD io");
                        e.printStackTrace();
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e322) {
                                e322.printStackTrace();
                            }
                        }
                    }
                } catch (FileNotFoundException e7) {
                    e = e7;
                    fileOutputStream = null;
                    az.m3143a(e, "OfflineUpdateCityHandler", "writeSD filenotfound");
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (IOException e8) {
                    e = e8;
                    fileOutputStream = null;
                    az.m3143a(e, "OfflineUpdateCityHandler", "writeSD io");
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (Throwable th2) {
                    e = th2;
                    fileOutputStream = null;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw e;
                }
            }
        }
    }

    /* renamed from: a */
    public long m3697a() {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return 0;
        }
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }

    /* renamed from: d */
    public String mo587d() {
        return "http://restapi.amap.com/v3/config/resource";
    }

    /* renamed from: a */
    protected List<OfflineMapProvince> m3698a(String str) throws AMapException {
        List<OfflineMapProvince> list = null;
        try {
            if (this.f2485j != null) {
                m3696c(str);
            }
        } catch (Throwable th) {
            az.m3143a(th, "OfflineUpdateCityHandler", "loadData jsonInit");
            th.printStackTrace();
        }
        try {
            list = C0437p.m3763c(str);
        } catch (Throwable th2) {
            az.m3143a(th2, "OfflineUpdateCityHandler", "loadData parseJson");
            th2.printStackTrace();
        }
        return list;
    }

    /* renamed from: c */
    public Map<String, String> mo586c() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("key", C0407w.m3495f(this.f2485j));
        hashMap.put("opertype", "offlinemap_with_province");
        hashMap.put("plattype", "android");
        hashMap.put("product", C0344n.f1879b);
        hashMap.put("version", "V2.5.1");
        hashMap.put("ext", "standard");
        hashMap.put("output", "json");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=").append(C0407w.m3495f(this.f2485j));
        stringBuffer.append("&opertype=offlinemap_with_province");
        stringBuffer.append("&plattype=android");
        stringBuffer.append("&product=").append(C0344n.f1879b);
        stringBuffer.append("&version=").append("V2.5.1");
        stringBuffer.append("&ext=standard");
        stringBuffer.append("&output=json");
        String a = ae.m3039a(stringBuffer.toString());
        String a2 = C0409y.m3502a();
        hashMap.put("ts", a2);
        hashMap.put("scode", C0409y.m3506a(this.f2485j, a2, a));
        return hashMap;
    }
}
