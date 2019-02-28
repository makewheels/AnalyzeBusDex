package com.aps;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.location.GpsStatus.NmeaListener;
import android.location.LocationManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Looper;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.amap.api.location.LocationManagerProxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TreeMap;
import p054u.aly.bi_常量类;

public final class ai {
    /* renamed from: C */
    private static int f3332C = 10000;
    /* renamed from: t */
    private static ai f3333t = null;
    /* renamed from: A */
    private Thread f3334A = null;
    /* renamed from: B */
    private Looper f3335B = null;
    /* renamed from: a */
    private Context f3336a = null;
    /* renamed from: b */
    private TelephonyManager f3337b = null;
    /* renamed from: c */
    private LocationManager f3338c = null;
    /* renamed from: d */
    private WifiManager f3339d = null;
    /* renamed from: e */
    private String f3340e = bi_常量类.f6358b_空串;
    /* renamed from: f */
    private String f3341f = bi_常量类.f6358b_空串;
    /* renamed from: g */
    private String f3342g = bi_常量类.f6358b_空串;
    /* renamed from: h */
    private boolean f3343h = false;
    /* renamed from: i */
    private int f3344i = 0;
    /* renamed from: j */
    private boolean f3345j = false;
    /* renamed from: k */
    private long f3346k = -1;
    /* renamed from: l */
    private String f3347l = bi_常量类.f6358b_空串;
    /* renamed from: m */
    private String f3348m = bi_常量类.f6358b_空串;
    /* renamed from: n */
    private int f3349n = 0;
    /* renamed from: o */
    private int f3350o = 0;
    /* renamed from: p */
    private int f3351p = 0;
    /* renamed from: q */
    private String f3352q = bi_常量类.f6358b_空串;
    /* renamed from: r */
    private long f3353r = 0;
    /* renamed from: s */
    private long f3354s = 0;
    /* renamed from: u */
    private ak f3355u = null;
    /* renamed from: v */
    private al f3356v = null;
    /* renamed from: w */
    private CellLocation f3357w = null;
    /* renamed from: x */
    private am f3358x = null;
    /* renamed from: y */
    private List f3359y = new ArrayList();
    /* renamed from: z */
    private Timer f3360z = null;

    private ai(Context context) {
        if (context != null) {
            this.f3336a = context;
            this.f3340e = Build.MODEL;
            this.f3337b = (TelephonyManager) context.getSystemService("phone");
            this.f3338c = (LocationManager) context.getSystemService(LocationManagerProxy.KEY_LOCATION_CHANGED);
            this.f3339d = (WifiManager) context.getSystemService("wifi");
            context.getSystemService("sensor");
            if (this.f3337b != null && this.f3339d != null) {
                try {
                    this.f3341f = this.f3337b.getDeviceId();
                } catch (Exception e) {
                }
                this.f3342g = this.f3337b.getSubscriberId();
                if (this.f3339d.getConnectionInfo() != null) {
                    this.f3348m = this.f3339d.getConnectionInfo().getMacAddress();
                    if (this.f3348m != null && this.f3348m.length() > 0) {
                        this.f3348m = this.f3348m.replace(":", bi_常量类.f6358b_空串);
                    }
                }
                String[] b = m4350b(this.f3337b);
                this.f3349n = Integer.parseInt(b[0]);
                this.f3350o = Integer.parseInt(b[1]);
                this.f3351p = this.f3337b.getNetworkType();
                this.f3352q = context.getPackageName();
                this.f3343h = this.f3337b.getPhoneType() == 2;
            }
        }
    }

    /* renamed from: a */
    protected static ai m4333a(Context context) {
        if (f3333t == null && m4354c(context)) {
            Object obj;
            LocationManager locationManager = (LocationManager) context.getSystemService(LocationManagerProxy.KEY_LOCATION_CHANGED);
            if (locationManager != null) {
                for (String str : locationManager.getAllProviders()) {
                    if (!str.equals("passive")) {
                        if (str.equals("gps")) {
                        }
                    }
                    obj = 1;
                }
            }
            obj = null;
            if (obj != null) {
                f3333t = new ai(context);
            }
        }
        return f3333t;
    }

    /* renamed from: a */
    private void m4339a(BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver != null && this.f3336a != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
            this.f3336a.registerReceiver(broadcastReceiver, intentFilter);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m4340a(ai aiVar, NmeaListener nmeaListener) {
        if (aiVar.f3338c != null && nmeaListener != null) {
            aiVar.f3338c.addNmeaListener(nmeaListener);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m4341a(ai aiVar, PhoneStateListener phoneStateListener) {
        if (aiVar.f3337b != null) {
            aiVar.f3337b.listen(phoneStateListener, 273);
        }
    }

    /* renamed from: a */
    private static void m4342a(List list) {
        if (list != null && list.size() > 0) {
            Object hashMap = new HashMap();
            for (int i = 0; i < list.size(); i++) {
                ScanResult scanResult = (ScanResult) list.get(i);
                if (scanResult.SSID == null) {
                    scanResult.SSID = "null";
                }
                hashMap.put(Integer.valueOf(scanResult.level), scanResult);
            }
            TreeMap treeMap = new TreeMap(Collections.reverseOrder());
            treeMap.putAll(hashMap);
            list.clear();
            for (Integer num : treeMap.keySet()) {
                list.add(treeMap.get(num));
            }
            hashMap.clear();
            treeMap.clear();
        }
    }

    /* renamed from: b */
    private void m4348b(BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver != null && this.f3336a != null) {
            try {
                this.f3336a.unregisterReceiver(broadcastReceiver);
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: b */
    protected static boolean m4349b(Context context) {
        if (context == null) {
            return false;
        }
        boolean z;
        if (!Secure.getString(context.getContentResolver(), "mock_location").equals("0")) {
            PackageManager packageManager = context.getPackageManager();
            List<ApplicationInfo> installedApplications = packageManager.getInstalledApplications(128);
            String str = "android.permission.ACCESS_MOCK_LOCATION";
            String packageName = context.getPackageName();
            z = false;
            for (ApplicationInfo applicationInfo : installedApplications) {
                if (z) {
                    break;
                }
                boolean z2;
                try {
                    String[] strArr = packageManager.getPackageInfo(applicationInfo.packageName, 4096).requestedPermissions;
                    if (strArr != null) {
                        int length = strArr.length;
                        int i = 0;
                        while (i < length) {
                            if (!strArr[i].equals(str)) {
                                i++;
                            } else if (!applicationInfo.packageName.equals(packageName)) {
                                z2 = true;
                                z = z2;
                            }
                        }
                    }
                } catch (Exception e) {
                    z2 = z;
                }
            }
        } else {
            z = false;
        }
        return z;
    }

    /* renamed from: b */
    private static String[] m4350b(TelephonyManager telephonyManager) {
        int i = 0;
        String str = null;
        if (telephonyManager != null) {
            str = telephonyManager.getNetworkOperator();
        }
        String[] strArr = new String[]{"0", "0"};
        if (TextUtils.isDigitsOnly(str) && str.length() > 4) {
            strArr[0] = str.substring(0, 3);
            char[] toCharArray = str.substring(3).toCharArray();
            while (i < toCharArray.length && Character.isDigit(toCharArray[i])) {
                i++;
            }
            strArr[1] = str.substring(3, i + 3);
        }
        return strArr;
    }

    /* renamed from: c */
    private static boolean m4354c(Context context) {
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            for (String a : bb.f3408a) {
                if (!bb.m4416a(strArr, a)) {
                    return false;
                }
            }
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    /* renamed from: z */
    private void m4361z() {
        if (this.f3339d != null) {
            this.f3339d.startScan();
        }
    }

    /* renamed from: a */
    protected final List m4362a(float f) {
        List arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(f) <= 1.0f) {
            f = 1.0f;
        }
        if (m4366c()) {
            CellLocation cellLocation = (CellLocation) m4373j().get(1);
            if (cellLocation != null && (cellLocation instanceof GsmCellLocation)) {
                arrayList.add(Integer.valueOf(((GsmCellLocation) cellLocation).getLac()));
                arrayList.add(Integer.valueOf(((GsmCellLocation) cellLocation).getCid()));
                if (((double) (currentTimeMillis - ((Long) m4373j().get(0)).longValue())) <= 50000.0d / ((double) f)) {
                    arrayList.add(Integer.valueOf(1));
                } else {
                    arrayList.add(Integer.valueOf(0));
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    protected final void m4363a() {
        String str = bi_常量类.f6358b_空串;
        m4365b();
        if (this.f3335B != null) {
            this.f3335B.quit();
            this.f3335B = null;
        }
        if (this.f3334A != null) {
            this.f3334A.interrupt();
            this.f3334A = null;
        }
        this.f3334A = new aj(this, str);
        this.f3334A.start();
    }

    /* renamed from: b */
    protected final List m4364b(float f) {
        List arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(f) <= 1.0f) {
            f = 1.0f;
        }
        if (m4366c()) {
            CellLocation cellLocation = (CellLocation) m4373j().get(1);
            if (cellLocation != null && (cellLocation instanceof CdmaCellLocation)) {
                CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                arrayList.add(Integer.valueOf(cdmaCellLocation.getSystemId()));
                arrayList.add(Integer.valueOf(cdmaCellLocation.getNetworkId()));
                arrayList.add(Integer.valueOf(cdmaCellLocation.getBaseStationId()));
                arrayList.add(Integer.valueOf(cdmaCellLocation.getBaseStationLongitude()));
                arrayList.add(Integer.valueOf(cdmaCellLocation.getBaseStationLatitude()));
                if (((double) (currentTimeMillis - ((Long) m4373j().get(0)).longValue())) <= 50000.0d / ((double) f)) {
                    arrayList.add(Integer.valueOf(1));
                } else {
                    arrayList.add(Integer.valueOf(0));
                }
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    protected final void m4365b() {
        if (this.f3355u != null) {
            PhoneStateListener phoneStateListener = this.f3355u;
            if (this.f3337b != null) {
                this.f3337b.listen(phoneStateListener, 0);
            }
            this.f3355u = null;
        }
        if (this.f3356v != null) {
            NmeaListener nmeaListener = this.f3356v;
            if (!(this.f3338c == null || nmeaListener == null)) {
                this.f3338c.removeNmeaListener(nmeaListener);
            }
            this.f3356v = null;
        }
        if (this.f3360z != null) {
            this.f3360z.cancel();
            this.f3360z = null;
        }
        if (this.f3335B != null) {
            this.f3335B.quit();
            this.f3335B = null;
        }
        if (this.f3334A != null) {
            this.f3334A.interrupt();
            this.f3334A = null;
        }
    }

    /* renamed from: c */
    protected final boolean m4366c() {
        CellLocation cellLocation = null;
        if (this.f3337b != null && this.f3337b.getSimState() == 5 && this.f3345j) {
            return true;
        }
        if (this.f3337b != null) {
            try {
                cellLocation = this.f3337b.getCellLocation();
            } catch (Exception e) {
            }
            if (cellLocation != null) {
                this.f3354s = System.currentTimeMillis();
                this.f3357w = cellLocation;
                return true;
            }
        }
        return false;
    }

    /* renamed from: d */
    protected final boolean m4367d() {
        return this.f3339d != null && this.f3339d.isWifiEnabled();
    }

    /* renamed from: e */
    protected final boolean m4368e() {
        try {
            if (this.f3338c != null && this.f3338c.isProviderEnabled("gps")) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    /* renamed from: f */
    protected final String m4369f() {
        if (this.f3340e == null) {
            this.f3340e = Build.MODEL;
        }
        return this.f3340e != null ? this.f3340e : bi_常量类.f6358b_空串;
    }

    /* renamed from: g */
    protected final String m4370g() {
        if (this.f3341f == null && this.f3336a != null) {
            this.f3337b = (TelephonyManager) this.f3336a.getSystemService("phone");
            if (this.f3337b != null) {
                this.f3341f = this.f3337b.getDeviceId();
            }
        }
        return this.f3341f != null ? this.f3341f : bi_常量类.f6358b_空串;
    }

    /* renamed from: h */
    protected final String m4371h() {
        if (this.f3342g == null && this.f3336a != null) {
            this.f3337b = (TelephonyManager) this.f3336a.getSystemService("phone");
            if (this.f3337b != null) {
                this.f3342g = this.f3337b.getSubscriberId();
            }
        }
        return this.f3342g != null ? this.f3342g : bi_常量类.f6358b_空串;
    }

    /* renamed from: i */
    protected final boolean m4372i() {
        return this.f3343h;
    }

    /* renamed from: j */
    protected final List m4373j() {
        if (System.getInt(this.f3336a.getContentResolver(), "airplane_mode_on", 0) == 1) {
            return new ArrayList();
        }
        if (!m4366c()) {
            return new ArrayList();
        }
        List arrayList = new ArrayList();
        arrayList.add(Long.valueOf(this.f3354s));
        arrayList.add(this.f3357w);
        return arrayList;
    }

    /* renamed from: k */
    protected final List m4374k() {
        int i = 0;
        List arrayList = new ArrayList();
        if (!m4367d()) {
            return new ArrayList();
        }
        List arrayList2 = new ArrayList();
        synchronized (this) {
            if ((System.currentTimeMillis() - this.f3353r < 3500 ? 1 : 0) != 0) {
                arrayList2.add(Long.valueOf(this.f3353r));
                while (i < this.f3359y.size()) {
                    arrayList.add(this.f3359y.get(i));
                    i++;
                }
                arrayList2.add(arrayList);
            }
        }
        return arrayList2;
    }

    /* renamed from: l */
    protected final byte m4375l() {
        return m4366c() ? (byte) this.f3344i : Byte.MIN_VALUE;
    }

    /* renamed from: m */
    protected final List m4376m() {
        List arrayList = new ArrayList();
        if (this.f3337b == null) {
            return arrayList;
        }
        if (!m4366c()) {
            return arrayList;
        }
        int i = 0;
        for (NeighboringCellInfo neighboringCellInfo : this.f3337b.getNeighboringCellInfo()) {
            if (i > 15) {
                break;
            } else if (!(neighboringCellInfo.getLac() == 0 || neighboringCellInfo.getLac() == 65535 || neighboringCellInfo.getCid() == 65535 || neighboringCellInfo.getCid() == 268435455)) {
                arrayList.add(neighboringCellInfo);
                i++;
            }
        }
        return arrayList;
    }

    /* renamed from: n */
    protected final List m4377n() {
        long j;
        Object obj;
        List arrayList = new ArrayList();
        String str = bi_常量类.f6358b_空串;
        if (m4368e()) {
            long j2 = this.f3346k;
            j = j2;
            obj = this.f3347l;
        } else {
            String str2 = str;
            j = -1;
            String str3 = str2;
        }
        if (j <= 0) {
            j = System.currentTimeMillis() / 1000;
        }
        if (j > 2147483647L) {
            j /= 1000;
        }
        arrayList.add(Long.valueOf(j));
        arrayList.add(obj);
        return arrayList;
    }

    /* renamed from: o */
    protected final long m4378o() {
        long j = 0;
        long j2 = this.f3346k;
        if (j2 > 0) {
            j = j2;
            int length = String.valueOf(j2).length();
            while (length != 13) {
                j = length > 13 ? j / 10 : j * 10;
                length = String.valueOf(j).length();
            }
        }
        return j;
    }

    /* renamed from: p */
    protected final String m4379p() {
        if (this.f3348m == null && this.f3336a != null) {
            this.f3339d = (WifiManager) this.f3336a.getSystemService("wifi");
            if (!(this.f3339d == null || this.f3339d.getConnectionInfo() == null)) {
                this.f3348m = this.f3339d.getConnectionInfo().getMacAddress();
                if (this.f3348m != null && this.f3348m.length() > 0) {
                    this.f3348m = this.f3348m.replace(":", bi_常量类.f6358b_空串);
                }
            }
        }
        return this.f3348m != null ? this.f3348m : bi_常量类.f6358b_空串;
    }

    /* renamed from: q */
    protected final int m4380q() {
        return this.f3349n;
    }

    /* renamed from: r */
    protected final int m4381r() {
        return this.f3350o;
    }

    /* renamed from: s */
    protected final int m4382s() {
        return this.f3351p;
    }

    /* renamed from: t */
    protected final String m4383t() {
        if (this.f3352q == null && this.f3336a != null) {
            this.f3352q = this.f3336a.getPackageName();
        }
        return this.f3352q != null ? this.f3352q : bi_常量类.f6358b_空串;
    }

    /* renamed from: u */
    protected final List m4384u() {
        int i = 0;
        List arrayList = new ArrayList();
        if (m4367d()) {
            List k = m4374k();
            List list = (List) k.get(1);
            long longValue = ((Long) k.get(0)).longValue();
            m4342a(list);
            arrayList.add(Long.valueOf(longValue));
            if (list != null && list.size() > 0) {
                while (i < list.size()) {
                    ScanResult scanResult = (ScanResult) list.get(i);
                    if (arrayList.size() - 1 >= 40) {
                        break;
                    }
                    if (scanResult != null) {
                        List arrayList2 = new ArrayList();
                        arrayList2.add(scanResult.BSSID.replace(":", bi_常量类.f6358b_空串));
                        arrayList2.add(Integer.valueOf(scanResult.level));
                        arrayList2.add(scanResult.SSID);
                        arrayList.add(arrayList2);
                    }
                    i++;
                }
            }
        }
        return arrayList;
    }

    /* renamed from: v */
    protected final void m4385v() {
        synchronized (this) {
            this.f3359y.clear();
        }
        if (this.f3358x != null) {
            m4348b(this.f3358x);
            this.f3358x = null;
        }
        if (this.f3360z != null) {
            this.f3360z.cancel();
            this.f3360z = null;
        }
        this.f3360z = new Timer();
        this.f3358x = new am();
        m4339a(this.f3358x);
        m4361z();
    }

    /* renamed from: w */
    protected final void m4386w() {
        synchronized (this) {
            this.f3359y.clear();
        }
        if (this.f3358x != null) {
            m4348b(this.f3358x);
            this.f3358x = null;
        }
        if (this.f3360z != null) {
            this.f3360z.cancel();
            this.f3360z = null;
        }
    }

    /* renamed from: x */
    protected final Context m4387x() {
        return this.f3336a;
    }
}
