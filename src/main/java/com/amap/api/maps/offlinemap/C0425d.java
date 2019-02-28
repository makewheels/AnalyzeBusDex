package com.amap.api.maps.offlinemap;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.alipay.sdk.cons.C0110c;
import com.amap.api.mapcore.util.C0402s;
import com.amap.api.mapcore.util.C0405u;
import com.amap.api.mapcore.util.az;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import p054u.aly.bi_常量类;

/* compiled from: MapDownloadManager */
/* renamed from: com.amap.api.maps.offlinemap.d */
class C0425d {
    /* renamed from: j */
    private static Context f2460j = null;
    /* renamed from: a */
    protected CopyOnWriteArrayList<C0436o> f2461a;
    /* renamed from: b */
    protected CopyOnWriteArrayList<OfflineMapProvince> f2462b;
    /* renamed from: c */
    protected CopyOnWriteArrayList<OfflineMapProvince> f2463c;
    /* renamed from: d */
    C0434m f2464d;
    /* renamed from: e */
    OfflineDBDao f2465e;
    /* renamed from: f */
    public Object f2466f;
    /* renamed from: g */
    private Handler f2467g;
    /* renamed from: h */
    private Bundle f2468h;
    /* renamed from: i */
    private String f2469i;
    /* renamed from: k */
    private OfflineMapManager f2470k;
    /* renamed from: l */
    private AMap f2471l;

    /* compiled from: MapDownloadManager */
    /* renamed from: com.amap.api.maps.offlinemap.d$1 */
    class C04241 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C0425d f2459a;

        C04241(C0425d c0425d) {
            this.f2459a = c0425d;
        }

        public void run() {
            C0427f c0427f;
            try {
                c0427f = (C0427f) new C0429g(C0425d.f2460j, OfflineMapManager.f2421a).m3686f();
            } catch (AMapException e) {
                c0427f = null;
            }
            if (c0427f != null && c0427f.f2476a) {
                C0432j c0432j = new C0432j(C0425d.f2460j, bi_常量类.f6358b_空串);
                c0432j.m3700a(C0425d.f2460j);
                try {
                    ArrayList arrayList = (ArrayList) c0432j.m3686f();
                    Bundle bundle = new Bundle();
                    bundle.putParcelableArrayList("update_file", arrayList);
                    Message message = new Message();
                    message.what = 1;
                    message.setData(bundle);
                    this.f2459a.f2467g.sendMessage(message);
                } catch (AMapException e2) {
                }
            }
        }
    }

    /* renamed from: a */
    public static String m3655a() {
        return C0405u.m3476b(f2460j);
    }

    public C0425d(Context context, Handler handler, OfflineMapManager offlineMapManager) {
        this.f2461a = new CopyOnWriteArrayList();
        this.f2462b = new CopyOnWriteArrayList();
        this.f2463c = new CopyOnWriteArrayList();
        this.f2468h = new Bundle();
        this.f2469i = null;
        this.f2466f = new Object();
        f2460j = context;
        this.f2470k = offlineMapManager;
        this.f2467g = handler;
        this.f2469i = C0405u.m3456a(context);
        this.f2465e = OfflineDBDao.getInstance(f2460j.getApplicationContext());
    }

    public C0425d(Context context, Handler handler, OfflineMapManager offlineMapManager, AMap aMap) {
        this(context, handler, offlineMapManager);
        this.f2471l = aMap;
    }

    /* renamed from: b */
    public void m3669b() {
        C0436o c0436o = null;
        if (this.f2461a != null && this.f2461a.size() > 0) {
            C0436o c0436o2;
            C0436o c0436o3;
            Iterator it = this.f2461a.iterator();
            while (it.hasNext()) {
                c0436o2 = (C0436o) it.next();
                if (c0436o2.f2504a != 0) {
                    c0436o2 = c0436o;
                }
                c0436o = c0436o2;
            }
            if (c0436o == null) {
                c0436o3 = (C0436o) this.f2461a.get(0);
            } else {
                c0436o3 = c0436o;
            }
            switch (c0436o3.f2504a) {
                case -1:
                    if (m3668a(c0436o3)) {
                        m3669b();
                        return;
                    }
                    return;
                case 0:
                    if (!this.f2470k.isStart()) {
                        String e = c0436o3.m3733e();
                        String str = (e + ".zip") + ".tmp";
                        try {
                            if (this.f2464d != null && this.f2464d.isAlive()) {
                                this.f2464d.interrupt();
                                this.f2464d = null;
                            }
                            this.f2464d = new C0434m(new C0435n(c0436o3.m3735f(), C0425d.m3655a(), str, 5, e), this, c0436o3, f2460j, this.f2467g);
                            this.f2464d.start();
                            this.f2470k.setStart(true);
                            return;
                        } catch (Throwable th) {
                            az.m3143a(th, "MapDownloadManager", "startDownload");
                            th.printStackTrace();
                            return;
                        }
                    }
                    return;
                case 2:
                    c0436o3.f2504a = 0;
                    m3669b();
                    return;
                case 3:
                    it = this.f2461a.iterator();
                    int i = 1;
                    while (it.hasNext()) {
                        int i2;
                        c0436o2 = (C0436o) it.next();
                        if (c0436o2.f2504a == 0 || c0436o2.f2504a == 2) {
                            i2 = 0;
                        } else {
                            i2 = i;
                        }
                        i = i2;
                    }
                    if (i == 0) {
                        this.f2461a.remove(c0436o3);
                        this.f2461a.add(c0436o3);
                        m3669b();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: a */
    public void m3664a(int i) {
        if (this.f2464d != null) {
            this.f2470k.setStart(false);
            Iterator it = this.f2461a.iterator();
            while (it.hasNext()) {
                C0436o c0436o = (C0436o) it.next();
                if (c0436o.f2504a == 1) {
                    this.f2470k.setStart(true);
                    return;
                } else if (c0436o.f2504a == 0) {
                    m3665a(c0436o, 3, c0436o.m3747n());
                    c0436o.f2504a = 3;
                }
            }
            this.f2464d.m3714b();
            this.f2464d.interrupt();
        }
    }

    /* renamed from: a */
    public boolean m3668a(C0436o c0436o) {
        if (c0436o == null || c0436o.m3733e().length() < 1) {
            return false;
        }
        List<String> d = this.f2465e.m3600d(c0436o.m3733e());
        String a = C0405u.m3456a(f2460j);
        for (String str : d) {
            try {
                if (!C0437p.m3756a(new File(a + "vmap/" + str))) {
                    return false;
                }
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        try {
            m3660b(a + "vmap/");
            m3666a(c0436o.m3733e());
            this.f2465e.m3601e(c0436o.m3733e());
            m3670b(c0436o);
            return true;
        } catch (IOException e3) {
            e3.printStackTrace();
            return false;
        } catch (Exception e22) {
            e22.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    public void m3666a(String str) throws IOException, Exception {
        for (File file : new File(C0405u.m3476b(f2460j)).listFiles()) {
            if (file.exists() && file.getName().contains(str)) {
                C0437p.m3756a(file);
            }
        }
        m3660b(C0405u.m3476b(f2460j));
    }

    /* renamed from: b */
    private void m3660b(String str) {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                if (file2.isDirectory() && file2.list().length == 0) {
                    file2.delete();
                }
            }
        }
    }

    /* renamed from: c */
    public void m3671c() {
        this.f2470k.setStart(false);
        Iterator it = this.f2461a.iterator();
        while (it.hasNext()) {
            C0436o c0436o = (C0436o) it.next();
            if (c0436o.f2504a == 2 || c0436o.f2504a == 0) {
                m3665a(c0436o, 3, c0436o.m3747n());
                c0436o.f2504a = 3;
            }
        }
        if (this.f2464d != null) {
            this.f2464d.m3714b();
            this.f2464d.interrupt();
        }
    }

    /* renamed from: b */
    public void m3670b(C0436o c0436o) {
        Iterator it = this.f2461a.iterator();
        while (it.hasNext()) {
            C0436o c0436o2 = (C0436o) it.next();
            if (c0436o2.m3733e().equals(c0436o.m3733e())) {
                this.f2461a.remove(c0436o2);
            }
        }
    }

    /* renamed from: d */
    public void m3673d() {
        new Thread(new C04241(this)).start();
    }

    /* renamed from: e */
    public void m3674e() {
        if (!C0425d.m3655a().equals(bi_常量类.f6358b_空串)) {
            this.f2462b.clear();
            File file = new File(C0425d.m3655a() + "offlinemap3.png");
            if (file.exists()) {
                m3656a(file);
            } else {
                m3663h();
            }
        }
    }

    /* renamed from: h */
    private void m3663h() {
        try {
            m3661c(C0405u.m3458a(C0402s.m3433a(f2460j).open("offlinemap3.png")));
        } catch (Throwable th) {
            az.m3143a(th, "MapDownloadManager", "readOfflineAsset");
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m3656a(File file) {
        BufferedReader bufferedReader;
        Throwable e;
        FileInputStream fileInputStream;
        BufferedReader bufferedReader2 = null;
        StringBuffer stringBuffer = new StringBuffer();
        FileInputStream fileInputStream2;
        try {
            fileInputStream2 = new FileInputStream(file);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream2, "utf-8"));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuffer.append(readLine);
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        fileInputStream = fileInputStream2;
                    } catch (IOException e3) {
                        e = e3;
                        bufferedReader2 = bufferedReader;
                    } catch (JSONException e4) {
                        e = e4;
                        bufferedReader2 = bufferedReader;
                    } catch (Throwable th) {
                        e = th;
                        bufferedReader2 = bufferedReader;
                    }
                }
                m3661c(stringBuffer.toString());
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e52) {
                        e52.printStackTrace();
                    }
                }
            } catch (FileNotFoundException e6) {
                e = e6;
                bufferedReader = null;
                fileInputStream = fileInputStream2;
                try {
                    az.m3143a(e, "MapDownloadManager", "readOfflineSD filenotfound");
                    e.printStackTrace();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e522) {
                            e522.printStackTrace();
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e5222) {
                            e5222.printStackTrace();
                        }
                    }
                } catch (Throwable th2) {
                    e = th2;
                    fileInputStream2 = fileInputStream;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e72) {
                            e72.printStackTrace();
                        }
                    }
                    throw e;
                }
            } catch (IOException e8) {
                e = e8;
                try {
                    az.m3143a(e, "MapDownloadManager", "readOfflineSD io");
                    e.printStackTrace();
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e52222) {
                            e52222.printStackTrace();
                        }
                    }
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e522222) {
                            e522222.printStackTrace();
                        }
                    }
                } catch (Throwable th3) {
                    e = th3;
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    throw e;
                }
            } catch (JSONException e9) {
                e = e9;
                az.m3143a(e, "MapDownloadManager", "readOfflineSD parseJson");
                e.printStackTrace();
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e5222222) {
                        e5222222.printStackTrace();
                    }
                }
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e52222222) {
                        e52222222.printStackTrace();
                    }
                }
            }
        } catch (FileNotFoundException e10) {
            e = e10;
            bufferedReader = null;
            az.m3143a(e, "MapDownloadManager", "readOfflineSD filenotfound");
            e.printStackTrace();
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        } catch (IOException e11) {
            e = e11;
            fileInputStream2 = null;
            az.m3143a(e, "MapDownloadManager", "readOfflineSD io");
            e.printStackTrace();
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
        } catch (JSONException e12) {
            e = e12;
            fileInputStream2 = null;
            az.m3143a(e, "MapDownloadManager", "readOfflineSD parseJson");
            e.printStackTrace();
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
        } catch (Throwable th4) {
            e = th4;
            fileInputStream2 = null;
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            throw e;
        }
    }

    /* renamed from: c */
    private void m3661c(String str) throws JSONException {
        List c = C0437p.m3763c(str);
        if (c != null && c.size() != 0) {
            m3675f();
            m3667a(c);
        }
    }

    /* renamed from: f */
    protected void m3675f() {
        this.f2463c.clear();
        this.f2462b.clear();
    }

    /* renamed from: a */
    protected void m3667a(List<OfflineMapProvince> list) {
        for (OfflineMapProvince offlineMapProvince : list) {
            this.f2463c.add(offlineMapProvince);
            this.f2462b.add(offlineMapProvince);
        }
    }

    /* renamed from: a */
    public void m3665a(C0436o c0436o, int i, int i2) {
        if (!c0436o.m3733e().equalsIgnoreCase(this.f2468h.getString("adcode")) || i != this.f2468h.getInt("status") || i2 != this.f2468h.getInt("complete")) {
            if (i2 == 100) {
                c0436o.m3726b(100);
            }
            if (c0436o.f2504a != 3) {
                c0436o.f2504a = i;
                if (i != 1 || i2 <= 2 || i2 >= 98) {
                    this.f2465e.m3593a(c0436o);
                }
                if (i == 4) {
                    c0436o.m3749p();
                }
                this.f2467g.sendMessage(m3659b(c0436o, i, i2));
                this.f2468h.putInt("status", i);
                this.f2468h.putInt("complete", i2);
                this.f2468h.putString("adcode", c0436o.m3733e());
                this.f2468h.putString(C0110c.f289e, c0436o.m3725b());
                this.f2468h.putBoolean("sheng", c0436o.m3746m());
            }
        }
    }

    /* renamed from: b */
    private Message m3659b(C0436o c0436o, int i, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("status", i);
        bundle.putInt("complete", i2);
        if (c0436o != null) {
            bundle.putString(C0110c.f289e, c0436o.m3725b());
            bundle.putString("adcode", c0436o.m3733e());
            bundle.putBoolean("sheng", c0436o.m3746m());
        }
        Message obtainMessage = this.f2467g.obtainMessage();
        obtainMessage.setData(bundle);
        return obtainMessage;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: c */
    public void m3672c(com.amap.api.maps.offlinemap.C0436o r9) {
        /*
        r8 = this;
        r1 = 0;
        r3 = r8.f2466f;
        monitor-enter(r3);
        r0 = 0;
        r2 = 100;
        r8.m3665a(r9, r0, r2);	 Catch:{ IOException -> 0x0146, Throwable -> 0x017c }
        r0 = r8.f2471l;	 Catch:{ IOException -> 0x0146, Throwable -> 0x017c }
        if (r0 == 0) goto L_0x0014;
    L_0x000e:
        r0 = r8.f2471l;	 Catch:{ IOException -> 0x0146, Throwable -> 0x017c }
        r2 = 1;
        r0.setLoadOfflineData(r2);	 Catch:{ IOException -> 0x0146, Throwable -> 0x017c }
    L_0x0014:
        r0 = r9.m3733e();	 Catch:{ IOException -> 0x0146, Throwable -> 0x017c }
        r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0146, Throwable -> 0x017c }
        r2.<init>();	 Catch:{ IOException -> 0x0146, Throwable -> 0x017c }
        r4 = com.amap.api.maps.offlinemap.C0425d.m3655a();	 Catch:{ IOException -> 0x0146, Throwable -> 0x017c }
        r2 = r2.append(r4);	 Catch:{ IOException -> 0x0146, Throwable -> 0x017c }
        r0 = r2.append(r0);	 Catch:{ IOException -> 0x0146, Throwable -> 0x017c }
        r0 = r0.toString();	 Catch:{ IOException -> 0x0146, Throwable -> 0x017c }
        r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0146, Throwable -> 0x017c }
        r2.<init>();	 Catch:{ IOException -> 0x0146, Throwable -> 0x017c }
        r2 = r2.append(r0);	 Catch:{ IOException -> 0x0146, Throwable -> 0x017c }
        r4 = ".zip";
        r2 = r2.append(r4);	 Catch:{ IOException -> 0x0146, Throwable -> 0x017c }
        r4 = r2.toString();	 Catch:{ IOException -> 0x0146, Throwable -> 0x017c }
        r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0146, Throwable -> 0x017c }
        r2.<init>();	 Catch:{ IOException -> 0x0146, Throwable -> 0x017c }
        r2 = r2.append(r4);	 Catch:{ IOException -> 0x0146, Throwable -> 0x017c }
        r5 = ".tmp";
        r2 = r2.append(r5);	 Catch:{ IOException -> 0x0146, Throwable -> 0x017c }
        r2 = r2.toString();	 Catch:{ IOException -> 0x0146, Throwable -> 0x017c }
        r5 = 1;
        r9.f2504a = r5;	 Catch:{ IOException -> 0x0146, Throwable -> 0x017c }
        r5 = new java.io.File;	 Catch:{ IOException -> 0x0146, Throwable -> 0x017c }
        r5.<init>(r4);	 Catch:{ IOException -> 0x0146, Throwable -> 0x017c }
        r6 = r5.exists();	 Catch:{ IOException -> 0x0146, Throwable -> 0x017c }
        if (r6 != 0) goto L_0x0069;
    L_0x0061:
        r6 = new java.io.File;	 Catch:{ IOException -> 0x0146, Throwable -> 0x017c }
        r6.<init>(r2);	 Catch:{ IOException -> 0x0146, Throwable -> 0x017c }
        r6.renameTo(r5);	 Catch:{ IOException -> 0x0146, Throwable -> 0x017c }
    L_0x0069:
        r2 = r5.exists();	 Catch:{ IOException -> 0x0146, Throwable -> 0x017c }
        if (r2 == 0) goto L_0x01fe;
    L_0x006f:
        r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0146, Throwable -> 0x017c }
        r2.<init>();	 Catch:{ IOException -> 0x0146, Throwable -> 0x017c }
        r2 = r2.append(r0);	 Catch:{ IOException -> 0x0146, Throwable -> 0x017c }
        r5 = "/";
        r2 = r2.append(r5);	 Catch:{ IOException -> 0x0146, Throwable -> 0x017c }
        r2 = r2.toString();	 Catch:{ IOException -> 0x0146, Throwable -> 0x017c }
        r2 = com.amap.api.maps.offlinemap.C0438q.m3764a(r2, r4, r9, r8);	 Catch:{ IOException -> 0x0146, Throwable -> 0x017c }
        r5 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x01f6, Throwable -> 0x01f4, all -> 0x01ee }
        r5.<init>();	 Catch:{ IOException -> 0x01f6, Throwable -> 0x01f4, all -> 0x01ee }
        r6 = r8.f2469i;	 Catch:{ IOException -> 0x01f6, Throwable -> 0x01f4, all -> 0x01ee }
        r5 = r5.append(r6);	 Catch:{ IOException -> 0x01f6, Throwable -> 0x01f4, all -> 0x01ee }
        r6 = "vmap/";
        r5 = r5.append(r6);	 Catch:{ IOException -> 0x01f6, Throwable -> 0x01f4, all -> 0x01ee }
        r5 = r5.toString();	 Catch:{ IOException -> 0x01f6, Throwable -> 0x01f4, all -> 0x01ee }
        r9.m3738g(r5);	 Catch:{ IOException -> 0x01f6, Throwable -> 0x01f4, all -> 0x01ee }
        r5 = new java.io.File;	 Catch:{ IOException -> 0x01f6, Throwable -> 0x01f4, all -> 0x01ee }
        r6 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x01f6, Throwable -> 0x01f4, all -> 0x01ee }
        r6.<init>();	 Catch:{ IOException -> 0x01f6, Throwable -> 0x01f4, all -> 0x01ee }
        r0 = r6.append(r0);	 Catch:{ IOException -> 0x01f6, Throwable -> 0x01f4, all -> 0x01ee }
        r6 = "/";
        r0 = r0.append(r6);	 Catch:{ IOException -> 0x01f6, Throwable -> 0x01f4, all -> 0x01ee }
        r0 = r0.toString();	 Catch:{ IOException -> 0x01f6, Throwable -> 0x01f4, all -> 0x01ee }
        r5.<init>(r0);	 Catch:{ IOException -> 0x01f6, Throwable -> 0x01f4, all -> 0x01ee }
        r0 = new java.io.File;	 Catch:{ IOException -> 0x01f6, Throwable -> 0x01f4, all -> 0x01ee }
        r6 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x01f6, Throwable -> 0x01f4, all -> 0x01ee }
        r6.<init>();	 Catch:{ IOException -> 0x01f6, Throwable -> 0x01f4, all -> 0x01ee }
        r7 = r8.f2469i;	 Catch:{ IOException -> 0x01f6, Throwable -> 0x01f4, all -> 0x01ee }
        r6 = r6.append(r7);	 Catch:{ IOException -> 0x01f6, Throwable -> 0x01f4, all -> 0x01ee }
        r7 = "vmap/";
        r6 = r6.append(r7);	 Catch:{ IOException -> 0x01f6, Throwable -> 0x01f4, all -> 0x01ee }
        r6 = r6.toString();	 Catch:{ IOException -> 0x01f6, Throwable -> 0x01f4, all -> 0x01ee }
        r0.<init>(r6);	 Catch:{ IOException -> 0x01f6, Throwable -> 0x01f4, all -> 0x01ee }
        r6 = new java.io.File;	 Catch:{ IOException -> 0x01f6, Throwable -> 0x01f4, all -> 0x01ee }
        r7 = r8.f2469i;	 Catch:{ IOException -> 0x01f6, Throwable -> 0x01f4, all -> 0x01ee }
        r6.<init>(r7);	 Catch:{ IOException -> 0x01f6, Throwable -> 0x01f4, all -> 0x01ee }
        r7 = r6.exists();	 Catch:{ IOException -> 0x01f6, Throwable -> 0x01f4, all -> 0x01ee }
        if (r7 != 0) goto L_0x00e0;
    L_0x00dd:
        r6.mkdir();	 Catch:{ IOException -> 0x01f6, Throwable -> 0x01f4, all -> 0x01ee }
    L_0x00e0:
        r6 = r0.exists();	 Catch:{ IOException -> 0x01f6, Throwable -> 0x01f4, all -> 0x01ee }
        if (r6 != 0) goto L_0x00e9;
    L_0x00e6:
        r0.mkdir();	 Catch:{ IOException -> 0x01f6, Throwable -> 0x01f4, all -> 0x01ee }
    L_0x00e9:
        r8.m3657a(r5, r0, r9);	 Catch:{ IOException -> 0x01f6, Throwable -> 0x01f4, all -> 0x01ee }
        if (r2 == 0) goto L_0x00f9;
    L_0x00ee:
        r0 = new java.io.File;	 Catch:{ IOException -> 0x01f6, Throwable -> 0x01f4, all -> 0x01ee }
        r0.<init>(r4);	 Catch:{ IOException -> 0x01f6, Throwable -> 0x01f4, all -> 0x01ee }
        r0.delete();	 Catch:{ IOException -> 0x01f6, Throwable -> 0x01f4, all -> 0x01ee }
        r8.m3658a(r5, r9);	 Catch:{ IOException -> 0x01f6, Throwable -> 0x01f4, all -> 0x01ee }
    L_0x00f9:
        r0 = r8.f2471l;	 Catch:{ IOException -> 0x01fa, Throwable -> 0x01f4 }
        if (r0 == 0) goto L_0x0103;
    L_0x00fd:
        r0 = r8.f2471l;	 Catch:{ IOException -> 0x01fa, Throwable -> 0x01f4 }
        r4 = 0;
        r0.setLoadOfflineData(r4);	 Catch:{ IOException -> 0x01fa, Throwable -> 0x01f4 }
    L_0x0103:
        if (r2 == 0) goto L_0x013d;
    L_0x0105:
        r0 = 4;
        r9.f2504a = r0;	 Catch:{ all -> 0x0143 }
        r0 = 4;
        r1 = 100;
        r8.m3665a(r9, r0, r1);	 Catch:{ all -> 0x0143 }
        r8.m3670b(r9);	 Catch:{ all -> 0x0143 }
    L_0x0111:
        r0 = r8.f2470k;	 Catch:{ all -> 0x0143 }
        r1 = 0;
        r0.setStart(r1);	 Catch:{ all -> 0x0143 }
        r0 = r8.f2461a;	 Catch:{ all -> 0x0143 }
        r0 = r0.size();	 Catch:{ all -> 0x0143 }
        if (r0 <= 0) goto L_0x0136;
    L_0x011f:
        r0 = r8.f2464d;	 Catch:{ all -> 0x0143 }
        if (r0 == 0) goto L_0x0133;
    L_0x0123:
        r0 = r8.f2464d;	 Catch:{ all -> 0x0143 }
        r0 = r0.isAlive();	 Catch:{ all -> 0x0143 }
        if (r0 == 0) goto L_0x0133;
    L_0x012b:
        r0 = r8.f2464d;	 Catch:{ all -> 0x0143 }
        r0.interrupt();	 Catch:{ all -> 0x0143 }
        r0 = 0;
        r8.f2464d = r0;	 Catch:{ all -> 0x0143 }
    L_0x0133:
        r8.m3669b();	 Catch:{ all -> 0x0143 }
    L_0x0136:
        r0 = r8.f2466f;	 Catch:{ all -> 0x0143 }
        r0.notify();	 Catch:{ all -> 0x0143 }
        monitor-exit(r3);	 Catch:{ all -> 0x0143 }
        return;
    L_0x013d:
        r0 = -1;
        r1 = -1;
        r8.m3665a(r9, r0, r1);	 Catch:{ all -> 0x0143 }
        goto L_0x0111;
    L_0x0143:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0143 }
        throw r0;
    L_0x0146:
        r0 = move-exception;
    L_0x0147:
        r2 = "MapDownloadManager";
        r4 = "unZip --> deleteFile";
        com.amap.api.mapcore.util.az.m3143a(r0, r2, r4);	 Catch:{ all -> 0x01b3 }
        r0.printStackTrace();	 Catch:{ all -> 0x01b3 }
        r0 = -1;
        r1 = -1;
        r8.m3665a(r9, r0, r1);	 Catch:{ all -> 0x0143 }
        r0 = r8.f2470k;	 Catch:{ all -> 0x0143 }
        r1 = 0;
        r0.setStart(r1);	 Catch:{ all -> 0x0143 }
        r0 = r8.f2461a;	 Catch:{ all -> 0x0143 }
        r0 = r0.size();	 Catch:{ all -> 0x0143 }
        if (r0 <= 0) goto L_0x0136;
    L_0x0164:
        r0 = r8.f2464d;	 Catch:{ all -> 0x0143 }
        if (r0 == 0) goto L_0x0178;
    L_0x0168:
        r0 = r8.f2464d;	 Catch:{ all -> 0x0143 }
        r0 = r0.isAlive();	 Catch:{ all -> 0x0143 }
        if (r0 == 0) goto L_0x0178;
    L_0x0170:
        r0 = r8.f2464d;	 Catch:{ all -> 0x0143 }
        r0.interrupt();	 Catch:{ all -> 0x0143 }
        r0 = 0;
        r8.f2464d = r0;	 Catch:{ all -> 0x0143 }
    L_0x0178:
        r8.m3669b();	 Catch:{ all -> 0x0143 }
        goto L_0x0136;
    L_0x017c:
        r0 = move-exception;
        r2 = r1;
    L_0x017e:
        r4 = "MapDownloadManager";
        r5 = "unZip";
        com.amap.api.mapcore.util.az.m3143a(r0, r4, r5);	 Catch:{ all -> 0x01f1 }
        r0.printStackTrace();	 Catch:{ all -> 0x01b3 }
        r0 = -1;
        r1 = -1;
        r8.m3665a(r9, r0, r1);	 Catch:{ all -> 0x0143 }
        r0 = r8.f2470k;	 Catch:{ all -> 0x0143 }
        r1 = 0;
        r0.setStart(r1);	 Catch:{ all -> 0x0143 }
        r0 = r8.f2461a;	 Catch:{ all -> 0x0143 }
        r0 = r0.size();	 Catch:{ all -> 0x0143 }
        if (r0 <= 0) goto L_0x0136;
    L_0x019b:
        r0 = r8.f2464d;	 Catch:{ all -> 0x0143 }
        if (r0 == 0) goto L_0x01af;
    L_0x019f:
        r0 = r8.f2464d;	 Catch:{ all -> 0x0143 }
        r0 = r0.isAlive();	 Catch:{ all -> 0x0143 }
        if (r0 == 0) goto L_0x01af;
    L_0x01a7:
        r0 = r8.f2464d;	 Catch:{ all -> 0x0143 }
        r0.interrupt();	 Catch:{ all -> 0x0143 }
        r0 = 0;
        r8.f2464d = r0;	 Catch:{ all -> 0x0143 }
    L_0x01af:
        r8.m3669b();	 Catch:{ all -> 0x0143 }
        goto L_0x0136;
    L_0x01b3:
        r0 = move-exception;
    L_0x01b4:
        if (r1 == 0) goto L_0x01e8;
    L_0x01b6:
        r1 = 4;
        r9.f2504a = r1;	 Catch:{ all -> 0x0143 }
        r1 = 4;
        r2 = 100;
        r8.m3665a(r9, r1, r2);	 Catch:{ all -> 0x0143 }
        r8.m3670b(r9);	 Catch:{ all -> 0x0143 }
    L_0x01c2:
        r1 = r8.f2470k;	 Catch:{ all -> 0x0143 }
        r2 = 0;
        r1.setStart(r2);	 Catch:{ all -> 0x0143 }
        r1 = r8.f2461a;	 Catch:{ all -> 0x0143 }
        r1 = r1.size();	 Catch:{ all -> 0x0143 }
        if (r1 <= 0) goto L_0x01e7;
    L_0x01d0:
        r1 = r8.f2464d;	 Catch:{ all -> 0x0143 }
        if (r1 == 0) goto L_0x01e4;
    L_0x01d4:
        r1 = r8.f2464d;	 Catch:{ all -> 0x0143 }
        r1 = r1.isAlive();	 Catch:{ all -> 0x0143 }
        if (r1 == 0) goto L_0x01e4;
    L_0x01dc:
        r1 = r8.f2464d;	 Catch:{ all -> 0x0143 }
        r1.interrupt();	 Catch:{ all -> 0x0143 }
        r1 = 0;
        r8.f2464d = r1;	 Catch:{ all -> 0x0143 }
    L_0x01e4:
        r8.m3669b();	 Catch:{ all -> 0x0143 }
    L_0x01e7:
        throw r0;	 Catch:{ all -> 0x0143 }
    L_0x01e8:
        r1 = -1;
        r2 = -1;
        r8.m3665a(r9, r1, r2);	 Catch:{ all -> 0x0143 }
        goto L_0x01c2;
    L_0x01ee:
        r0 = move-exception;
        r1 = r2;
        goto L_0x01b4;
    L_0x01f1:
        r0 = move-exception;
        r1 = r2;
        goto L_0x01b4;
    L_0x01f4:
        r0 = move-exception;
        goto L_0x017e;
    L_0x01f6:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0147;
    L_0x01fa:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0147;
    L_0x01fe:
        r2 = r1;
        goto L_0x00f9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.maps.offlinemap.d.c(com.amap.api.maps.offlinemap.o):void");
    }

    /* renamed from: a */
    private void m3657a(File file, File file2, C0436o c0436o) {
        int i = 0;
        double n = (double) c0436o.m3747n();
        double d = (100.0d - n) * 0.75d;
        if (file.isDirectory()) {
            if (!file2.exists()) {
                file2.mkdir();
            }
            String[] list = file.list();
            double d2 = n;
            int i2 = 0;
            while (i < list.length) {
                C0437p.m3754a(new File(file, list[i]), new File(file2, list[i]));
                d2 += d / ((double) list.length);
                if (((int) d2) != i2) {
                    c0436o.m3726b((int) d2);
                    m3665a(c0436o, 1, (int) d2);
                }
                i2 = (int) d2;
                i++;
            }
        }
    }

    /* renamed from: a */
    private boolean m3658a(File file, C0436o c0436o) throws IOException, Exception {
        double n = (double) c0436o.m3747n();
        double d = 99.9d - n;
        if (file == null || !file.exists()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            double d2 = n;
            int i = 0;
            for (int i2 = 0; i2 < listFiles.length; i2++) {
                d2 += d / ((double) listFiles.length);
                if (((int) d2) != i) {
                    c0436o.m3726b((int) d2);
                    m3665a(c0436o, 1, (int) d2);
                }
                i = (int) d2;
                if (listFiles[i2].isFile()) {
                    if (!listFiles[i2].delete()) {
                        return false;
                    }
                } else if (!C0437p.m3756a(listFiles[i2])) {
                    return false;
                }
            }
        }
        return file.delete();
    }
}
