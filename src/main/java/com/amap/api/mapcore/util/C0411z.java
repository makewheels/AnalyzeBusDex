package com.amap.api.mapcore.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Environment;
import android.provider.Settings.System;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.alipay.sdk.cons.C0110c;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import p054u.aly.bi_常量类;

/* compiled from: DeviceInfo */
/* renamed from: com.amap.api.mapcore.util.z */
public class C0411z {
    /* renamed from: a */
    private static String f2203a = null;
    /* renamed from: b */
    private static boolean f2204b = false;
    /* renamed from: c */
    private static String f2205c = null;
    /* renamed from: d */
    private static String f2206d = null;
    /* renamed from: e */
    private static String f2207e = null;
    /* renamed from: f */
    private static String f2208f = null;

    /* compiled from: DeviceInfo */
    /* renamed from: com.amap.api.mapcore.util.z$a */
    static class C0410a extends DefaultHandler {
        C0410a() {
        }

        public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
            if (str2.equals("string") && "UTDID".equals(attributes.getValue(C0110c.f289e))) {
                C0411z.f2204b = true;
            }
        }

        public void characters(char[] cArr, int i, int i2) throws SAXException {
            if (C0411z.f2204b) {
                C0411z.f2203a = new String(cArr, i, i2);
            }
        }

        public void endElement(String str, String str2, String str3) throws SAXException {
            C0411z.f2204b = false;
        }
    }

    /* renamed from: a */
    public static String m3511a(Context context) {
        try {
            if (f2203a != null && !bi_常量类.f6358b.equals(f2203a)) {
                return f2203a;
            }
            if (context.checkCallingOrSelfPermission("android.permission.WRITE_SETTINGS") == 0) {
                f2203a = System.getString(context.getContentResolver(), "mqBRboGZkQPcAkyk");
            }
            if (!(f2203a == null || bi_常量类.f6358b.equals(f2203a))) {
                return f2203a;
            }
            try {
                if ("mounted".equals(Environment.getExternalStorageState())) {
                    File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/.UTSystemConfig/Global/Alvin2.xml");
                    if (file.exists()) {
                        SAXParserFactory.newInstance().newSAXParser().parse(file, new C0410a());
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (ParserConfigurationException e2) {
                e2.printStackTrace();
            } catch (SAXException e3) {
                e3.printStackTrace();
            } catch (IOException e4) {
                e4.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return f2203a;
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    /* renamed from: b */
    static String m3516b(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        if (context != null) {
            try {
                if (context.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0) {
                    WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                    if (wifiManager.isWifiEnabled()) {
                        List scanResults = wifiManager.getScanResults();
                        if (scanResults == null || scanResults.size() == 0) {
                            return stringBuilder.toString();
                        }
                        List a = C0411z.m3513a(scanResults);
                        Object obj = 1;
                        int i = 0;
                        while (i < a.size() && i < 10) {
                            ScanResult scanResult = (ScanResult) a.get(i);
                            if (obj != null) {
                                obj = null;
                            } else {
                                stringBuilder.append("||");
                            }
                            stringBuilder.append(scanResult.BSSID);
                            i++;
                        }
                    }
                    return stringBuilder.toString();
                }
            } catch (Throwable th) {
                az.m3143a(th, "DeviceInfo", "getWifiMacs");
                th.printStackTrace();
            }
        }
        return stringBuilder.toString();
    }

    /* renamed from: c */
    static String m3517c(Context context) {
        try {
            if (f2205c != null && !bi_常量类.f6358b.equals(f2205c)) {
                return f2205c;
            }
            if (context.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") != 0) {
                return f2205c;
            }
            f2205c = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
            return f2205c;
        } catch (Throwable th) {
            az.m3143a(th, "DeviceInfo", "getDeviceMac");
            th.printStackTrace();
        }
    }

    /* renamed from: d */
    static String m3518d(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
                return stringBuilder.toString();
            }
            CellLocation cellLocation = ((TelephonyManager) context.getSystemService("phone")).getCellLocation();
            if (cellLocation instanceof GsmCellLocation) {
                GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                stringBuilder.append(gsmCellLocation.getLac()).append("||").append(gsmCellLocation.getCid()).append("&bt=gsm");
            } else if (cellLocation instanceof CdmaCellLocation) {
                CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                int systemId = cdmaCellLocation.getSystemId();
                int networkId = cdmaCellLocation.getNetworkId();
                int baseStationId = cdmaCellLocation.getBaseStationId();
                if (systemId < 0 || networkId < 0 || baseStationId < 0) {
                    stringBuilder.append(systemId).append("||").append(networkId).append("||").append(baseStationId).append("&bt=cdma");
                } else {
                    stringBuilder.append(systemId).append("||").append(networkId).append("||").append(baseStationId).append("&bt=cdma");
                }
            }
            return stringBuilder.toString();
        } catch (Throwable th) {
            az.m3143a(th, "DeviceInfo", "cellInfo");
            th.printStackTrace();
        }
    }

    /* renamed from: e */
    static String m3519e(Context context) {
        String str = bi_常量类.f6358b;
        try {
            str = C0411z.m3536v(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return str;
    }

    /* renamed from: f */
    static int m3520f(Context context) {
        int i = -1;
        try {
            i = C0411z.m3537w(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return i;
    }

    /* renamed from: g */
    public static int m3521g(Context context) {
        int i = -1;
        try {
            i = C0411z.m3535u(context);
        } catch (Throwable th) {
            az.m3143a(th, "DeviceInfo", "getActiveNetWorkType");
            th.printStackTrace();
        }
        return i;
    }

    /* renamed from: h */
    static int m3522h(Context context) {
        int i = -1;
        try {
            i = C0411z.m3535u(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return i;
    }

    /* renamed from: i */
    static String m3523i(Context context) {
        String extraInfo;
        try {
            if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
                return null;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return null;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return null;
            }
            extraInfo = activeNetworkInfo.getExtraInfo();
            return extraInfo;
        } catch (Throwable th) {
            az.m3143a(th, "DeviceInfo", "getNetworkExtraInfo");
            th.printStackTrace();
            extraInfo = null;
        }
    }

    /* renamed from: j */
    static String m3524j(Context context) {
        try {
            if (f2206d != null && !bi_常量类.f6358b.equals(f2206d)) {
                return f2206d;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            f2206d = i2 > i ? i + "*" + i2 : i2 + "*" + i;
            return f2206d;
        } catch (Throwable th) {
            az.m3143a(th, "DeviceInfo", "getReslution");
            th.printStackTrace();
        }
    }

    /* renamed from: k */
    static String m3525k(Context context) {
        try {
            return C0411z.m3534t(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: l */
    static String m3526l(Context context) {
        try {
            return C0411z.m3534t(context);
        } catch (Throwable th) {
            az.m3143a(th, "DeviceInfo", "getActiveNetworkTypeName");
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: m */
    static String m3527m(Context context) {
        try {
            if (f2207e != null && !bi_常量类.f6358b.equals(f2207e)) {
                return f2207e;
            }
            if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
                return f2207e;
            }
            f2207e = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            return f2207e;
        } catch (Throwable th) {
            az.m3143a(th, "DeviceInfo", "getDeviceID");
            th.printStackTrace();
        }
    }

    /* renamed from: n */
    static String m3528n(Context context) {
        String str = null;
        try {
            str = C0411z.m3532r(context);
        } catch (Throwable th) {
            az.m3143a(th, "DeviceInfo", "getSubscriberId");
            th.printStackTrace();
        }
        return str;
    }

    /* renamed from: o */
    static String m3529o(Context context) {
        try {
            return C0411z.m3533s(context);
        } catch (Throwable th) {
            az.m3143a(th, "DeviceInfo", "getNetworkOperatorName");
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: p */
    static String m3530p(Context context) {
        try {
            return C0411z.m3533s(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: q */
    static String m3531q(Context context) {
        try {
            return C0411z.m3532r(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: r */
    private static String m3532r(Context context) {
        if (f2208f != null && !bi_常量类.f6358b.equals(f2208f)) {
            return f2208f;
        }
        if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
            return f2208f;
        }
        f2208f = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
        return f2208f;
    }

    /* renamed from: s */
    private static String m3533s(Context context) {
        if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
            return null;
        }
        return ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName();
    }

    /* renamed from: t */
    private static String m3534t(Context context) {
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
            return bi_常量类.f6358b;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return bi_常量类.f6358b;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return bi_常量类.f6358b;
        }
        return activeNetworkInfo.getTypeName();
    }

    /* renamed from: u */
    private static int m3535u(Context context) {
        if (context == null || context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
            return -1;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return -1;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return -1;
        }
        return activeNetworkInfo.getType();
    }

    /* renamed from: v */
    private static String m3536v(Context context) {
        String str = bi_常量类.f6358b;
        String n = C0411z.m3528n(context);
        if (n == null || n.length() < 5) {
            return str;
        }
        return n.substring(3, 5);
    }

    /* renamed from: w */
    private static int m3537w(Context context) {
        if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
            return -1;
        }
        return ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
    }

    /* renamed from: a */
    private static List<ScanResult> m3513a(List<ScanResult> list) {
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            for (int i2 = 1; i2 < size - i; i2++) {
                if (((ScanResult) list.get(i2 - 1)).level > ((ScanResult) list.get(i2)).level) {
                    ScanResult scanResult = (ScanResult) list.get(i2 - 1);
                    list.set(i2 - 1, list.get(i2));
                    list.set(i2, scanResult);
                }
            }
        }
        return list;
    }
}
