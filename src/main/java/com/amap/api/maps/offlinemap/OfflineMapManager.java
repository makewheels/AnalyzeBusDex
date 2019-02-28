package com.amap.api.maps.offlinemap;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.alipay.sdk.cons.C0110c;
import com.amap.api.mapcore.util.C0405u;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import p054u.aly.bi_常量类;

public final class OfflineMapManager {
    protected static final String UPDATE_OFFLINE_FILE = "update_file";
    /* renamed from: a */
    static String f2421a = bi_常量类.f6358b;
    /* renamed from: b */
    private static String f2422b = "citycode";
    /* renamed from: c */
    private static String f2423c = "cityname";
    protected static final int mMessageUpdateFile = 1;
    /* renamed from: d */
    private Context f2424d;
    /* renamed from: e */
    private AMap f2425e;
    /* renamed from: f */
    private C0425d f2426f;
    /* renamed from: g */
    private OfflineMapDownloadListener f2427g;
    /* renamed from: h */
    private CopyOnWriteArrayList<OfflineMapCity> f2428h = new CopyOnWriteArrayList();
    /* renamed from: i */
    private CopyOnWriteArrayList<OfflineMapProvince> f2429i = new CopyOnWriteArrayList();
    /* renamed from: j */
    private CopyOnWriteArrayList<OfflineMapCity> f2430j = new CopyOnWriteArrayList();
    /* renamed from: k */
    private CopyOnWriteArrayList<OfflineMapProvince> f2431k = new CopyOnWriteArrayList();
    /* renamed from: l */
    private boolean f2432l = false;
    /* renamed from: m */
    private String f2433m = bi_常量类.f6358b;
    /* renamed from: n */
    private String f2434n = bi_常量类.f6358b;
    /* renamed from: o */
    private OfflineDBDao f2435o;
    /* renamed from: p */
    private ExecutorService f2436p = null;
    /* renamed from: q */
    private ExecutorService f2437q = null;

    public interface OfflineMapDownloadListener {
        void onCheckUpdate(boolean z, String str);

        void onDownload(int i, int i2, String str);

        void onRemove(boolean z, String str, String str2);
    }

    /* renamed from: com.amap.api.maps.offlinemap.OfflineMapManager$a */
    class C0420a extends Handler {
        /* renamed from: a */
        final /* synthetic */ OfflineMapManager f2420a;

        public C0420a(OfflineMapManager offlineMapManager, Looper looper) {
            this.f2420a = offlineMapManager;
            super(looper);
        }

        public void handleMessage(Message message) {
            try {
                if (message.what == 1) {
                    Bundle data = message.getData();
                    if (data != null) {
                        List parcelableArrayList = data.getParcelableArrayList(OfflineMapManager.UPDATE_OFFLINE_FILE);
                        if (parcelableArrayList != null && parcelableArrayList.size() != 0) {
                            this.f2420a.f2426f.m3675f();
                            this.f2420a.f2426f.m3667a(parcelableArrayList);
                        }
                    }
                } else if (this.f2420a.f2427g != null) {
                    this.f2420a.m3612a(message);
                    this.f2420a.f2427g.onDownload(message.getData().getInt("status"), message.getData().getInt("complete"), message.getData().getString(C0110c.f289e));
                    int i = message.getData().getInt("status");
                    if (i == 101 || i == 102 || i == 103) {
                        this.f2420a.pause();
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public OfflineMapManager(Context context, OfflineMapDownloadListener offlineMapDownloadListener) {
        m3611a(context, offlineMapDownloadListener);
    }

    public OfflineMapManager(Context context, OfflineMapDownloadListener offlineMapDownloadListener, AMap aMap) {
        this.f2425e = aMap;
        m3611a(context, offlineMapDownloadListener);
    }

    /* renamed from: a */
    private void m3611a(Context context, OfflineMapDownloadListener offlineMapDownloadListener) {
        this.f2424d = context.getApplicationContext();
        this.f2435o = OfflineDBDao.getInstance(context.getApplicationContext());
        this.f2426f = new C0425d(context, new C0420a(this, context.getMainLooper()), this, this.f2425e);
        this.f2426f.m3673d();
        this.f2427g = offlineMapDownloadListener;
        this.f2426f.m3674e();
        m3622b();
        if (isStart()) {
            pause();
        }
    }

    public void downloadByCityCode(String str) throws AMapException {
        m3625b(str, f2422b);
    }

    public void downloadByCityName(String str) throws AMapException {
        m3625b(str, f2423c);
    }

    public void downloadByProvinceName(String str) throws AMapException {
        try {
            m3638d();
            OfflineMapProvince itemByProvinceName = getItemByProvinceName(str);
            if (itemByProvinceName == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            Iterator it = itemByProvinceName.getCityList().iterator();
            while (it.hasNext()) {
                downloadByCityName(((OfflineMapCity) it.next()).getCity());
            }
        } catch (Throwable th) {
            if (th instanceof AMapException) {
                AMapException aMapException = (AMapException) th;
            }
        }
    }

    public ArrayList<OfflineMapProvince> getOfflineMapProvinceList() {
        ArrayList<OfflineMapProvince> arrayList = new ArrayList();
        Iterator it = this.f2426f.f2463c.iterator();
        while (it.hasNext()) {
            OfflineMapProvince offlineMapProvince = (OfflineMapProvince) it.next();
            Iterator it2 = this.f2429i.iterator();
            while (it2.hasNext()) {
                OfflineMapProvince offlineMapProvince2 = (OfflineMapProvince) it2.next();
                if (offlineMapProvince.getProvinceName().equalsIgnoreCase(offlineMapProvince2.getProvinceName())) {
                    offlineMapProvince.setCompleteCode(offlineMapProvince2.getcompleteCode());
                    offlineMapProvince.setState(offlineMapProvince2.getState());
                }
            }
            it2 = this.f2431k.iterator();
            while (it2.hasNext()) {
                offlineMapProvince2 = (OfflineMapProvince) it2.next();
                if (offlineMapProvince.getProvinceName().equalsIgnoreCase(offlineMapProvince2.getProvinceName())) {
                    offlineMapProvince.setCompleteCode(offlineMapProvince2.getcompleteCode());
                    offlineMapProvince.setState(offlineMapProvince2.getState());
                }
            }
            arrayList.add(offlineMapProvince);
        }
        return arrayList;
    }

    public void remove(final String str) {
        if (this.f2437q == null) {
            this.f2437q = Executors.newSingleThreadExecutor();
        }
        this.f2437q.execute(new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ OfflineMapManager f2417b;

            public void run() {
                int state;
                boolean z = false;
                OfflineMapCity itemByCityName = this.f2417b.getItemByCityName(str);
                if (itemByCityName == null) {
                    state = this.f2417b.getItemByProvinceName(str).getState();
                } else {
                    state = itemByCityName.getState();
                }
                if (state == 1) {
                    synchronized (this.f2417b.f2426f.f2466f) {
                        while (this.f2417b.isStart()) {
                            try {
                                this.f2417b.f2426f.f2466f.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                } else if (state == 0) {
                    this.f2417b.setStart(false);
                    this.f2417b.f2426f.m3664a(0);
                    this.f2417b.f2433m = bi_常量类.f6358b;
                    this.f2417b.f2434n = bi_常量类.f6358b;
                } else if (state == 6) {
                    this.f2417b.f2427g.onRemove(false, str, "本地无数据");
                    return;
                }
                boolean c = this.f2417b.m3619a(str);
                boolean z2;
                if (c) {
                    z2 = false;
                } else {
                    z2 = this.f2417b.m3627b(str);
                }
                if (this.f2417b.f2427g != null) {
                    OfflineMapDownloadListener b = this.f2417b.f2427g;
                    if (c || r0) {
                        z = true;
                    }
                    b.onRemove(z, str, bi_常量类.f6358b);
                }
            }
        });
    }

    protected synchronized void setStart(boolean z) {
        this.f2432l = z;
    }

    protected synchronized boolean isStart() {
        return this.f2432l;
    }

    /* renamed from: a */
    private boolean m3619a(String str) {
        OfflineMapCity itemByCityName = getItemByCityName(str);
        if (itemByCityName == null) {
            return false;
        }
        boolean a = this.f2426f.m3668a(new C0436o(itemByCityName));
        if (!a) {
            return false;
        }
        Iterator it = this.f2428h.iterator();
        while (it.hasNext()) {
            OfflineMapCity offlineMapCity = (OfflineMapCity) it.next();
            if (str.equalsIgnoreCase(offlineMapCity.getCity())) {
                this.f2428h.remove(offlineMapCity);
            }
        }
        it = this.f2430j.iterator();
        while (it.hasNext()) {
            offlineMapCity = (OfflineMapCity) it.next();
            if (str.equalsIgnoreCase(offlineMapCity.getCity())) {
                this.f2430j.remove(offlineMapCity);
            }
        }
        it = this.f2429i.iterator();
        while (it.hasNext()) {
            OfflineMapProvince offlineMapProvince = (OfflineMapProvince) it.next();
            if (offlineMapProvince.getProvinceName().equalsIgnoreCase(str)) {
                this.f2429i.remove(offlineMapProvince);
            }
        }
        it = this.f2431k.iterator();
        while (it.hasNext()) {
            offlineMapProvince = (OfflineMapProvince) it.next();
            if (offlineMapProvince.getProvinceName().equalsIgnoreCase(str)) {
                this.f2431k.remove(offlineMapProvince);
            }
        }
        if (m3635d(itemByCityName) == null) {
            String f = m3644f(itemByCityName.getAdcode());
            it = this.f2431k.iterator();
            while (it.hasNext()) {
                offlineMapProvince = (OfflineMapProvince) it.next();
                if (offlineMapProvince.getProvinceCode().equals(f)) {
                    this.f2431k.remove(offlineMapProvince);
                    this.f2435o.m3601e(f);
                }
            }
        }
        return a;
    }

    /* renamed from: b */
    private boolean m3627b(String str) {
        OfflineMapProvince itemByProvinceName = getItemByProvinceName(str);
        if (itemByProvinceName == null) {
            return false;
        }
        Iterator it = itemByProvinceName.getCityList().iterator();
        int i = 0;
        boolean z = false;
        while (it.hasNext()) {
            int i2;
            boolean z2;
            OfflineMapCity offlineMapCity = (OfflineMapCity) it.next();
            if (offlineMapCity.getCity().equals(str)) {
                i2 = i + 1;
                z2 = z;
            } else {
                z = m3619a(offlineMapCity.getCity());
                if (z) {
                    i2 = i + 1;
                    z2 = z;
                } else {
                    i2 = i;
                    z2 = z;
                }
            }
            z = z2;
            i = i2;
        }
        if (i == 0) {
            return z;
        }
        Iterator it2 = this.f2429i.iterator();
        while (it2.hasNext()) {
            OfflineMapProvince offlineMapProvince = (OfflineMapProvince) it2.next();
            if (offlineMapProvince.getProvinceName().equalsIgnoreCase(offlineMapProvince.getProvinceName())) {
                this.f2429i.remove(offlineMapProvince);
            }
        }
        it2 = this.f2431k.iterator();
        while (it2.hasNext()) {
            offlineMapProvince = (OfflineMapProvince) it2.next();
            if (offlineMapProvince.getProvinceName().equalsIgnoreCase(offlineMapProvince.getProvinceName())) {
                this.f2431k.remove(offlineMapProvince);
            }
        }
        this.f2435o.m3601e(itemByProvinceName.getProvinceCode());
        return z;
    }

    public OfflineMapCity getItemByCityCode(String str) {
        if (str == null || str.equals(bi_常量类.f6358b)) {
            return null;
        }
        Iterator it = this.f2428h.iterator();
        while (it.hasNext()) {
            OfflineMapCity offlineMapCity = (OfflineMapCity) it.next();
            if (offlineMapCity.getCode().equals(str)) {
                return offlineMapCity;
            }
        }
        it = this.f2430j.iterator();
        while (it.hasNext()) {
            offlineMapCity = (OfflineMapCity) it.next();
            if (offlineMapCity.getCode().equals(str)) {
                return offlineMapCity;
            }
        }
        it = this.f2426f.f2463c.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((OfflineMapProvince) it.next()).getCityList().iterator();
            while (it2.hasNext()) {
                offlineMapCity = (OfflineMapCity) it2.next();
                if (offlineMapCity.getCode().equals(str)) {
                    return offlineMapCity;
                }
            }
        }
        return null;
    }

    public OfflineMapCity getItemByCityName(String str) {
        if (str == null || str.equals(bi_常量类.f6358b)) {
            return null;
        }
        Iterator it = this.f2430j.iterator();
        while (it.hasNext()) {
            OfflineMapCity offlineMapCity = (OfflineMapCity) it.next();
            if (offlineMapCity.getCity().trim().equalsIgnoreCase(str.trim())) {
                return offlineMapCity;
            }
        }
        it = this.f2428h.iterator();
        while (it.hasNext()) {
            offlineMapCity = (OfflineMapCity) it.next();
            if (offlineMapCity.getCity().trim().equalsIgnoreCase(str.trim())) {
                return offlineMapCity;
            }
        }
        it = this.f2426f.f2463c.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((OfflineMapProvince) it.next()).getCityList().iterator();
            while (it2.hasNext()) {
                offlineMapCity = (OfflineMapCity) it2.next();
                if (offlineMapCity.getCity().trim().equalsIgnoreCase(str.trim())) {
                    offlineMapCity.setState(6);
                    return offlineMapCity;
                }
            }
        }
        return null;
    }

    public OfflineMapProvince getItemByProvinceName(String str) {
        if (str == null || str.equals(bi_常量类.f6358b)) {
            return null;
        }
        Iterator it = this.f2431k.iterator();
        while (it.hasNext()) {
            OfflineMapProvince offlineMapProvince = (OfflineMapProvince) it.next();
            if (offlineMapProvince.getProvinceName().trim().equalsIgnoreCase(str.trim())) {
                return offlineMapProvince;
            }
        }
        it = this.f2429i.iterator();
        while (it.hasNext()) {
            offlineMapProvince = (OfflineMapProvince) it.next();
            if (offlineMapProvince.getProvinceName().trim().equalsIgnoreCase(str.trim())) {
                return offlineMapProvince;
            }
        }
        it = this.f2426f.f2463c.iterator();
        while (it.hasNext()) {
            offlineMapProvince = (OfflineMapProvince) it.next();
            if (offlineMapProvince.getProvinceName().trim().equalsIgnoreCase(str.trim())) {
                offlineMapProvince.setState(6);
                return offlineMapProvince;
            }
        }
        return null;
    }

    public ArrayList<OfflineMapCity> getOfflineMapCityList() {
        ArrayList<OfflineMapCity> arrayList = new ArrayList();
        Iterator it = this.f2426f.f2463c.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((OfflineMapProvince) it.next()).getCityList().iterator();
            while (it2.hasNext()) {
                OfflineMapCity offlineMapCity = (OfflineMapCity) it2.next();
                Iterator it3 = this.f2428h.iterator();
                while (it3.hasNext()) {
                    OfflineMapCity offlineMapCity2 = (OfflineMapCity) it3.next();
                    if (offlineMapCity.getCity().equalsIgnoreCase(offlineMapCity2.getCity())) {
                        offlineMapCity.setCompleteCode(offlineMapCity2.getcompleteCode());
                        offlineMapCity.setState(offlineMapCity2.getState());
                    }
                }
                it3 = this.f2430j.iterator();
                while (it3.hasNext()) {
                    offlineMapCity2 = (OfflineMapCity) it3.next();
                    if (offlineMapCity.getCity().equalsIgnoreCase(offlineMapCity2.getCity())) {
                        offlineMapCity.setCompleteCode(offlineMapCity2.getcompleteCode());
                        offlineMapCity.setState(offlineMapCity2.getState());
                    }
                }
                arrayList.add(offlineMapCity);
            }
        }
        return arrayList;
    }

    public ArrayList<OfflineMapCity> getDownloadingCityList() {
        ArrayList<OfflineMapCity> arrayList = new ArrayList();
        Iterator it = this.f2428h.iterator();
        while (it.hasNext()) {
            arrayList.add((OfflineMapCity) it.next());
        }
        return arrayList;
    }

    public ArrayList<OfflineMapProvince> getDownloadingProvinceList() {
        ArrayList<OfflineMapProvince> arrayList = new ArrayList();
        Iterator it = this.f2429i.iterator();
        while (it.hasNext()) {
            arrayList.add((OfflineMapProvince) it.next());
        }
        return arrayList;
    }

    public ArrayList<OfflineMapCity> getDownloadOfflineMapCityList() {
        ArrayList<OfflineMapCity> arrayList = new ArrayList();
        Iterator it = this.f2430j.iterator();
        while (it.hasNext()) {
            arrayList.add((OfflineMapCity) it.next());
        }
        return arrayList;
    }

    public ArrayList<OfflineMapProvince> getDownloadOfflineMapProvinceList() {
        ArrayList<OfflineMapProvince> arrayList = new ArrayList();
        Iterator it = this.f2431k.iterator();
        while (it.hasNext()) {
            arrayList.add((OfflineMapProvince) it.next());
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m3617a(final String str, String str2) throws AMapException {
        if (this.f2426f.f2463c.size() <= 0) {
            if (this.f2427g != null) {
                this.f2427g.onCheckUpdate(false, str);
            }
        } else if (str == null || str.equals(bi_常量类.f6358b)) {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } else {
            int i = 0;
            boolean z = false;
            while (i < this.f2426f.f2463c.size() && !str.trim().equals(((OfflineMapProvince) this.f2426f.f2463c.get(i)).getProvinceName().trim())) {
                Iterator it = ((OfflineMapProvince) this.f2426f.f2463c.get(i)).getCityList().iterator();
                while (it.hasNext()) {
                    OfflineMapCity offlineMapCity = (OfflineMapCity) it.next();
                    if (!str.trim().equals(offlineMapCity.getCode().trim())) {
                        if (str.trim().equals(offlineMapCity.getCity().trim())) {
                        }
                    }
                    z = true;
                }
                if (z) {
                    break;
                } else if (i == this.f2426f.f2463c.size() - 1) {
                    throw new AMapException("无效的参数 - IllegalArgumentException");
                } else {
                    i++;
                }
            }
            if (this.f2436p == null) {
                this.f2436p = Executors.newSingleThreadExecutor();
            }
            this.f2436p.execute(new Runnable(this) {
                /* renamed from: b */
                final /* synthetic */ OfflineMapManager f2419b;

                public void run() {
                    try {
                        OfflineMapCity offlineMapCity;
                        String adcode;
                        boolean z;
                        OfflineMapProvince offlineMapProvince;
                        String str = bi_常量类.f6358b;
                        Iterator it = this.f2419b.f2428h.iterator();
                        boolean z2 = false;
                        while (it.hasNext()) {
                            offlineMapCity = (OfflineMapCity) it.next();
                            if (offlineMapCity.getCity().equals(str)) {
                                adcode = offlineMapCity.getAdcode();
                                z = true;
                            } else {
                                adcode = str;
                                z = z2;
                            }
                            z2 = z;
                            str = adcode;
                        }
                        it = this.f2419b.f2430j.iterator();
                        while (it.hasNext()) {
                            offlineMapCity = (OfflineMapCity) it.next();
                            if (offlineMapCity.getCity().equals(str)) {
                                adcode = offlineMapCity.getAdcode();
                                z = true;
                            } else {
                                adcode = str;
                                z = z2;
                            }
                            z2 = z;
                            str = adcode;
                        }
                        it = this.f2419b.f2429i.iterator();
                        while (it.hasNext()) {
                            offlineMapProvince = (OfflineMapProvince) it.next();
                            if (offlineMapProvince.getProvinceName().equals(str)) {
                                adcode = offlineMapProvince.getProvinceCode();
                                z = true;
                            } else {
                                adcode = str;
                                z = z2;
                            }
                            z2 = z;
                            str = adcode;
                        }
                        it = this.f2419b.f2431k.iterator();
                        while (it.hasNext()) {
                            offlineMapProvince = (OfflineMapProvince) it.next();
                            if (offlineMapProvince.getProvinceName().equals(str)) {
                                adcode = offlineMapProvince.getProvinceCode();
                                z = true;
                            } else {
                                adcode = str;
                                z = z2;
                            }
                            z2 = z;
                            str = adcode;
                        }
                        if (z2) {
                            if (str.length() > 0) {
                                adcode = this.f2419b.f2435o.m3605i(str);
                                if (OfflineMapManager.f2421a.length() > 0 && !adcode.equals(OfflineMapManager.f2421a)) {
                                    if (this.f2419b.f2427g != null) {
                                        this.f2419b.f2427g.onCheckUpdate(true, str);
                                        return;
                                    }
                                    return;
                                }
                            }
                            this.f2419b.m3638d();
                            C0427f c0427f = (C0427f) new C0429g(this.f2419b.f2424d, OfflineMapManager.f2421a).m3686f();
                            if (this.f2419b.f2427g == null) {
                                return;
                            }
                            if (c0427f == null) {
                                this.f2419b.f2427g.onCheckUpdate(false, str);
                            } else if (c0427f == null || !c0427f.f2476a) {
                                this.f2419b.f2427g.onCheckUpdate(false, str);
                            } else {
                                this.f2419b.updateAllCityList();
                                this.f2419b.f2427g.onCheckUpdate(true, str);
                            }
                        } else if (this.f2419b.f2427g != null) {
                            this.f2419b.f2427g.onCheckUpdate(true, str);
                        }
                    } catch (Exception e) {
                        if (this.f2419b.f2427g != null) {
                            this.f2419b.f2427g.onCheckUpdate(false, str);
                        }
                    }
                }
            });
        }
    }

    public void updateOfflineCityByCode(String str) throws AMapException {
        OfflineMapCity itemByCityCode = getItemByCityCode(str);
        if (itemByCityCode == null || itemByCityCode.getCity() == null) {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
        m3617a(itemByCityCode.getCity(), f2423c);
    }

    public void updateOfflineCityByName(String str) throws AMapException {
        m3617a(str, f2423c);
    }

    public void updateOfflineMapProvinceByName(String str) throws AMapException {
        m3617a(str, f2423c);
    }

    /* renamed from: a */
    private void m3609a() {
        this.f2430j.clear();
        this.f2428h.clear();
        this.f2431k.clear();
        this.f2429i.clear();
    }

    /* renamed from: b */
    private synchronized void m3622b() {
        m3609a();
        this.f2426f.f2461a.clear();
        ArrayList a = this.f2435o.m3592a();
        if (a.size() < 1) {
            ArrayList c = m3629c();
            if (c.size() > 0) {
                Iterator it = c.iterator();
                while (it.hasNext()) {
                    this.f2435o.m3593a((C0436o) it.next());
                }
            }
            a = c;
        }
        Iterator it2 = a.iterator();
        while (it2.hasNext()) {
            C0436o c0436o = (C0436o) it2.next();
            if (!(c0436o == null || c0436o.m3725b() == null || c0436o.m3733e().length() < 1)) {
                if (!m3633c(c0436o.m3733e())) {
                    try {
                        this.f2426f.m3666a(c0436o.m3733e());
                    } catch (IOException e) {
                    } catch (Exception e2) {
                    }
                } else if (c0436o.f2504a == 4) {
                    m3624b(c0436o);
                } else {
                    if (c0436o.f2504a >= 0 && c0436o.f2504a != 2) {
                        c0436o.f2504a = 3;
                    }
                    m3615a(c0436o);
                    this.f2426f.f2461a.add(c0436o);
                }
            }
        }
    }

    /* renamed from: c */
    private ArrayList<C0436o> m3629c() {
        ArrayList<C0436o> arrayList = new ArrayList();
        File file = new File(C0425d.m3655a());
        if (file.exists()) {
            for (File file2 : file.listFiles()) {
                if (file2.getName().endsWith(".zip.tmp.dt")) {
                    C0436o a = m3607a(file2);
                    if (!(a == null || a.m3725b() == null)) {
                        arrayList.add(a);
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private C0436o m3607a(File file) {
        String a = C0405u.m3457a(file);
        C0436o c0436o = new C0436o();
        c0436o.m3742i(a);
        return c0436o;
    }

    /* renamed from: c */
    private boolean m3633c(String str) {
        List<String> c = this.f2435o.m3599c(str);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(C0405u.m3456a(this.f2424d));
        stringBuilder.append("vmap/");
        int length = stringBuilder.length();
        for (String replace : c) {
            stringBuilder.replace(length, stringBuilder.length(), replace);
            if (!new File(stringBuilder.toString()).exists()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private void m3615a(C0436o c0436o) {
        if (m3643e(c0436o.m3725b())) {
            this.f2429i.add(m3636d(c0436o));
            this.f2428h.add(m3628c(c0436o));
        } else if (c0436o.m3746m()) {
            this.f2429i.add(m3636d(c0436o));
        } else {
            this.f2428h.add(m3628c(c0436o));
        }
    }

    /* renamed from: b */
    private void m3624b(C0436o c0436o) {
        if (m3643e(c0436o.m3725b())) {
            this.f2431k.add(m3636d(c0436o));
            this.f2430j.add(m3628c(c0436o));
        } else if (c0436o.m3746m()) {
            this.f2431k.add(m3636d(c0436o));
        } else {
            this.f2430j.add(m3628c(c0436o));
        }
    }

    protected void updateAllCityList() throws AMapException {
        C0432j c0432j = new C0432j(this.f2424d, bi_常量类.f6358b);
        c0432j.m3700a(this.f2424d);
        List list = (List) c0432j.m3686f();
        if (list != null) {
            this.f2426f.m3675f();
            this.f2426f.m3667a(list);
        }
    }

    /* renamed from: a */
    private void m3613a(OfflineMapCity offlineMapCity) {
        C0436o c0436o = new C0436o(offlineMapCity);
        Iterator it = this.f2426f.f2461a.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2;
            C0436o c0436o2 = (C0436o) it.next();
            if (c0436o2.m3733e().equals(c0436o.m3733e())) {
                i = 1;
                if (c0436o2.f2504a == 0) {
                    c0436o.f2504a = c0436o2.f2504a;
                    return;
                } else if (c0436o2.f2504a == 3 || c0436o2.f2504a == 6) {
                    c0436o2.f2504a = 2;
                    if (!isStart()) {
                        c0436o2.f2504a = 0;
                    }
                    c0436o.f2504a = c0436o2.f2504a;
                    i2 = 1;
                    i = i2;
                } else if (c0436o2.f2504a == 2) {
                    if (!isStart()) {
                        c0436o2.f2504a = 0;
                    }
                    c0436o.f2504a = c0436o2.f2504a;
                    i2 = 1;
                    i = i2;
                } else if (c0436o2.f2504a == 101 || c0436o2.f2504a == 102 || c0436o2.f2504a == 103) {
                    if (!isStart()) {
                        c0436o2.f2504a = 0;
                    }
                    c0436o2.f2504a = 2;
                    c0436o.f2504a = c0436o2.f2504a;
                }
            }
            i2 = i;
            i = i2;
        }
        if (i == 0) {
            if (isStart()) {
                c0436o.f2504a = 2;
                this.f2426f.f2461a.add(c0436o);
            } else {
                c0436o.f2504a = 0;
                this.f2426f.f2461a.add(0, c0436o);
            }
        }
        this.f2435o.m3593a(c0436o);
        if (m3626b(offlineMapCity)) {
            Iterator it2;
            if (m3643e(c0436o.m3725b())) {
                it2 = this.f2429i.iterator();
                while (it2.hasNext()) {
                    OfflineMapProvince offlineMapProvince = (OfflineMapProvince) it2.next();
                    if (offlineMapProvince.getProvinceCode().equals(c0436o.m3733e())) {
                        offlineMapProvince.setState(c0436o.f2504a);
                    }
                }
            }
            it2 = this.f2428h.iterator();
            while (it2.hasNext()) {
                OfflineMapCity offlineMapCity2 = (OfflineMapCity) it2.next();
                if (offlineMapCity2.getAdcode().equals(c0436o.m3733e())) {
                    offlineMapCity2.setState(c0436o.f2504a);
                }
            }
        } else {
            if (m3643e(c0436o.m3725b())) {
                this.f2429i.add(m3636d(c0436o));
            }
            this.f2428h.add(m3628c(c0436o));
        }
        this.f2426f.m3669b();
    }

    /* renamed from: b */
    private boolean m3626b(OfflineMapCity offlineMapCity) {
        if (offlineMapCity == null) {
            return false;
        }
        try {
            Iterator it = this.f2428h.iterator();
            while (it.hasNext()) {
                City city = (City) it.next();
                String city2 = city.getCity();
                String adcode = city.getAdcode();
                if (city2.equals(offlineMapCity.getCity()) && adcode.equals(offlineMapCity.getAdcode())) {
                    return true;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    /* renamed from: d */
    private void m3638d() throws AMapException {
        if (!C0405u.m3484c(this.f2424d)) {
            throw new AMapException("http连接失败 - ConnectionException");
        }
    }

    /* renamed from: c */
    private OfflineMapCity m3628c(C0436o c0436o) {
        OfflineMapCity offlineMapCity = new OfflineMapCity();
        offlineMapCity.setCity(c0436o.m3725b());
        offlineMapCity.setAdcode(c0436o.m3733e());
        offlineMapCity.setSize(c0436o.m3737g());
        offlineMapCity.setState(c0436o.f2504a);
        offlineMapCity.setUrl(c0436o.m3735f());
        offlineMapCity.setVersion(c0436o.m3729c());
        offlineMapCity.setCompleteCode(c0436o.m3747n());
        offlineMapCity.setCode(c0436o.m3748o());
        return offlineMapCity;
    }

    /* renamed from: d */
    private OfflineMapProvince m3636d(C0436o c0436o) {
        OfflineMapProvince offlineMapProvince = new OfflineMapProvince();
        offlineMapProvince.setProvinceName(c0436o.m3725b());
        offlineMapProvince.setProvinceCode(c0436o.m3733e());
        offlineMapProvince.setSize(c0436o.m3737g());
        offlineMapProvince.setState(c0436o.f2504a);
        offlineMapProvince.setUrl(c0436o.m3735f());
        offlineMapProvince.setVersion(c0436o.m3729c());
        offlineMapProvince.setCompleteCode(c0436o.m3747n());
        Iterator it = this.f2426f.f2463c.iterator();
        while (it.hasNext()) {
            OfflineMapProvince offlineMapProvince2 = (OfflineMapProvince) it.next();
            if (offlineMapProvince2.getProvinceName().trim().equalsIgnoreCase(offlineMapProvince.getProvinceName().trim())) {
                offlineMapProvince.setCityList(offlineMapProvince2.getCityList());
            }
        }
        return offlineMapProvince;
    }

    /* renamed from: d */
    private void m3639d(String str) {
        File[] listFiles = new File(C0425d.m3655a()).listFiles();
        if (listFiles != null && listFiles.length != 0) {
            for (File file : listFiles) {
                if (file.getName().contains(str)) {
                    file.delete();
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m3618a(int i, int i2) {
        if (i == 4) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    private void m3625b(String str, String str2) throws AMapException {
        try {
            m3638d();
            OfflineMapCity offlineMapCity = null;
            if (str2.equals(f2422b)) {
                offlineMapCity = getItemByCityCode(str);
            }
            if (str2.equals(f2423c)) {
                offlineMapCity = getItemByCityName(str);
            }
            if (offlineMapCity == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            } else if (m3631c(offlineMapCity)) {
                m3613a(offlineMapCity);
            } else if (this.f2427g != null) {
                this.f2427g.onDownload(1002, -1, str);
            }
        } catch (Throwable th) {
            if (th instanceof AMapException) {
                AMapException aMapException = (AMapException) th;
            } else {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: c */
    private boolean m3631c(OfflineMapCity offlineMapCity) throws AMapException {
        long j;
        long j2 = 0;
        try {
            Iterator it = getDownloadingCityList().iterator();
            while (it.hasNext()) {
                long size;
                OfflineMapCity offlineMapCity2 = (OfflineMapCity) it.next();
                if (offlineMapCity.getCity().equals(offlineMapCity2.getCity())) {
                    size = (offlineMapCity2.getSize() * ((long) offlineMapCity2.getcompleteCode())) / 100;
                } else {
                    size = j2;
                }
                j2 = size;
            }
            j = j2;
        } catch (Throwable th) {
            j = 0;
            th.printStackTrace();
        }
        m3616a(offlineMapCity, offlineMapCity.getSize(), j);
        if (!m3634c(offlineMapCity.getAdcode(), offlineMapCity.getCity())) {
            return true;
        }
        if (!m3641d(offlineMapCity.getAdcode(), offlineMapCity.getVersion())) {
            return false;
        }
        m3639d(offlineMapCity.getAdcode());
        return true;
    }

    /* renamed from: c */
    private boolean m3634c(String str, String str2) {
        for (OfflineMapCity adcode : getDownloadOfflineMapCityList()) {
            if (adcode.getAdcode().equalsIgnoreCase(str)) {
                return true;
            }
        }
        for (OfflineMapProvince provinceCode : getDownloadOfflineMapProvinceList()) {
            if (provinceCode.getProvinceCode().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private void m3616a(Object obj, long j, long j2) throws AMapException {
        if (obj == null) {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } else if (((double) C0437p.m3750a()) < (((double) j) * 2.5d) - ((double) j2)) {
            throw new AMapException(AMapException.ERROR_NOT_ENOUGH_SPACE);
        } else if (!C0437p.m3761b()) {
            throw new AMapException(AMapException.ERROR_NOT_AVAILABLE);
        }
    }

    /* renamed from: d */
    private boolean m3641d(String str, String str2) {
        String i = this.f2435o.m3605i(str);
        if (i == null || bi_常量类.f6358b.equals(i) || !str2.equals(i)) {
            return true;
        }
        return false;
    }

    public void restart() {
        if (!isStart()) {
            this.f2426f.m3669b();
        }
    }

    public void stop() {
        setStart(false);
        this.f2426f.m3671c();
    }

    public void pause() {
        setStart(false);
        this.f2426f.m3664a(0);
    }

    /* renamed from: e */
    private boolean m3643e(String str) {
        if (str == null || bi_常量类.f6358b.equals(str)) {
            return false;
        }
        if (str.equals("北京") || str.equals("上海") || str.equals("天津") || str.equals("重庆") || str.equals("香港") || str.equals("澳门") || str.equals("全国概要图")) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private void m3612a(Message message) {
        String string = message.getData().getString("adcode");
        String string2 = message.getData().getString(C0110c.f289e);
        int i = message.getData().getInt("status");
        int i2 = message.getData().getInt("complete");
        boolean z = message.getData().getBoolean("sheng");
        if (i < 0) {
            setStart(false);
        }
        if (m3643e(string2)) {
            m3623b(i, string2, string, i2);
            m3610a(i, string2, string, i2);
        } else if (z) {
            m3623b(i, string2, string, i2);
        } else {
            m3610a(i, string2, string, i2);
        }
    }

    /* renamed from: a */
    private void m3610a(int i, String str, String str2, int i2) {
        int i3 = 0;
        while (i3 < this.f2428h.size()) {
            try {
                OfflineMapCity offlineMapCity = (OfflineMapCity) this.f2428h.get(i3);
                if (offlineMapCity.getCity().equals(str) && offlineMapCity.getAdcode().equals(str2)) {
                    offlineMapCity.setCompleteCode(i2);
                    offlineMapCity.setState(i);
                    if (m3618a(i, i2)) {
                        this.f2428h.remove(offlineMapCity);
                        this.f2430j.add(offlineMapCity);
                        this.f2433m = bi_常量类.f6358b;
                        setStart(false);
                        OfflineMapProvince d = m3635d(offlineMapCity);
                        if (d != null) {
                            this.f2431k.add(d);
                            this.f2435o.m3593a(new C0436o(d));
                        }
                    }
                }
                i3++;
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
    }

    /* renamed from: b */
    private void m3623b(int i, String str, String str2, int i2) {
        Iterator it = this.f2429i.iterator();
        while (it.hasNext()) {
            OfflineMapProvince offlineMapProvince = (OfflineMapProvince) it.next();
            if (offlineMapProvince.getProvinceName().equals(str) && offlineMapProvince.getProvinceCode().equals(str2)) {
                offlineMapProvince.setCompleteCode(i2);
                offlineMapProvince.setState(i);
                if (m3618a(i, i2)) {
                    this.f2429i.remove(offlineMapProvince);
                    this.f2431k.add(offlineMapProvince);
                    this.f2434n = bi_常量类.f6358b;
                    setStart(false);
                }
                Iterator it2 = offlineMapProvince.getCityList().iterator();
                while (it2.hasNext()) {
                    OfflineMapCity offlineMapCity = (OfflineMapCity) it2.next();
                    offlineMapCity.setCompleteCode(i2);
                    offlineMapCity.setState(i);
                }
            }
        }
    }

    /* renamed from: f */
    private String m3644f(String str) {
        return (Integer.parseInt(str) / 10000) + "0000";
    }

    /* renamed from: d */
    private OfflineMapProvince m3635d(OfflineMapCity offlineMapCity) {
        if (offlineMapCity == null || offlineMapCity.getAdcode().length() < 1) {
            return null;
        }
        String f = m3644f(offlineMapCity.getAdcode());
        for (int i = 0; i < this.f2426f.f2463c.size(); i++) {
            OfflineMapProvince offlineMapProvince = (OfflineMapProvince) this.f2426f.f2463c.get(i);
            if (offlineMapProvince.getProvinceCode().equals(f)) {
                Iterator it = offlineMapProvince.getCityList().iterator();
                while (it.hasNext()) {
                    if (!this.f2430j.contains(getItemByCityName(((OfflineMapCity) it.next()).getCity()))) {
                        return null;
                    }
                }
                offlineMapProvince.setState(4);
                return offlineMapProvince;
            }
        }
        return null;
    }

    public void destroy() {
        if (!(this.f2436p == null || this.f2436p.isShutdown())) {
            this.f2436p.shutdownNow();
        }
        if (!(this.f2437q == null || this.f2437q.isShutdown())) {
            this.f2437q.shutdownNow();
        }
        pause();
        m3609a();
        this.f2426f.m3675f();
        this.f2426f.f2461a.clear();
    }
}
