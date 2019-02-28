package com.autonavi.tbt;

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
/* renamed from: com.autonavi.tbt.l */
public class C0623l {
    /* renamed from: a */
    private static String f3823a = null;
    /* renamed from: b */
    private static boolean f3824b = false;
    /* renamed from: c */
    private static String f3825c = null;
    /* renamed from: d */
    private static String f3826d = null;
    /* renamed from: e */
    private static String f3827e = null;
    /* renamed from: f */
    private static String f3828f = null;

    /* compiled from: DeviceInfo */
    /* renamed from: com.autonavi.tbt.l$a */
    static class C0622a extends DefaultHandler {
        C0622a() {
        }

        public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
            if (str2.equals("string") && "UTDID".equals(attributes.getValue(C0110c.f289e))) {
                C0623l.f3824b = true;
            }
        }

        public void characters(char[] cArr, int i, int i2) throws SAXException {
            if (C0623l.f3824b) {
                C0623l.f3823a = new String(cArr, i, i2);
            }
        }

        public void endElement(String str, String str2, String str3) throws SAXException {
            C0623l.f3824b = false;
        }
    }

    /* renamed from: a */
    public static String m4882a(Context context) {
        try {
            if (f3823a != null && !bi_常量类.f6358b_空串.equals(f3823a)) {
                return f3823a;
            }
            if (context.checkCallingOrSelfPermission("android.permission.WRITE_SETTINGS") == 0) {
                f3823a = System.getString(context.getContentResolver(), "mqBRboGZkQPcAkyk");
            }
            if (!(f3823a == null || bi_常量类.f6358b_空串.equals(f3823a))) {
                return f3823a;
            }
            try {
                if ("mounted".equals(Environment.getExternalStorageState())) {
                    File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/.UTSystemConfig/Global/Alvin2.xml");
                    if (file.exists()) {
                        SAXParserFactory.newInstance().newSAXParser().parse(file, new C0622a());
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
            return f3823a;
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    /* renamed from: b */
    static String m4887b(Context context) {
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
                        List a = C0623l.m4884a(scanResults);
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
                ae.m4671a(th, "DeviceInfo", "getWifiMacs");
                th.printStackTrace();
            }
        }
        return stringBuilder.toString();
    }

    /* renamed from: c */
    static String m4888c(Context context) {
        try {
            if (f3825c != null && !bi_常量类.f6358b_空串.equals(f3825c)) {
                return f3825c;
            }
            if (context.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") != 0) {
                return f3825c;
            }
            f3825c = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
            return f3825c;
        } catch (Throwable th) {
            ae.m4671a(th, "DeviceInfo", "getDeviceMac");
            th.printStackTrace();
        }
    }

    /* renamed from: d */
    static String m4889d(Context context) {
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
            ae.m4671a(th, "DeviceInfo", "cellInfo");
            th.printStackTrace();
        }
    }

    /* renamed from: e */
    static String m4890e(Context context) {
        String str = bi_常量类.f6358b_空串;
        try {
            str = C0623l.m4907v(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return str;
    }

    /* renamed from: f */
    static int m4891f(Context context) {
        int i = -1;
        try {
            i = C0623l.m4908w(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return i;
    }

    /* renamed from: g */
    public static int m4892g(Context context) {
        int i = -1;
        try {
            i = C0623l.m4906u(context);
        } catch (Throwable th) {
            ae.m4671a(th, "DeviceInfo", "getActiveNetWorkType");
            th.printStackTrace();
        }
        return i;
    }

    /* renamed from: h */
    static int m4893h(Context context) {
        int i = -1;
        try {
            i = C0623l.m4906u(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return i;
    }

    /* renamed from: i */
    static String m4894i(Context context) {
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
            ae.m4671a(th, "DeviceInfo", "getNetworkExtraInfo");
            th.printStackTrace();
            extraInfo = null;
        }
    }

    /* renamed from: j */
    static String m4895j(Context context) {
        try {
            if (f3826d != null && !bi_常量类.f6358b_空串.equals(f3826d)) {
                return f3826d;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            f3826d = i2 > i ? i + "*" + i2 : i2 + "*" + i;
            return f3826d;
        } catch (Throwable th) {
            ae.m4671a(th, "DeviceInfo", "getReslution");
            th.printStackTrace();
        }
    }

    /* renamed from: k */
    static String m4896k(Context context) {
        try {
            return C0623l.m4905t(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: l */
    static String m4897l(Context context) {
        try {
            return C0623l.m4905t(context);
        } catch (Throwable th) {
            ae.m4671a(th, "DeviceInfo", "getActiveNetworkTypeName");
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: m */
    static String m4898m(Context context) {
        try {
            if (f3827e != null && !bi_常量类.f6358b_空串.equals(f3827e)) {
                return f3827e;
            }
            if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
                return f3827e;
            }
            f3827e = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            return f3827e;
        } catch (Throwable th) {
            ae.m4671a(th, "DeviceInfo", "getDeviceID");
            th.printStackTrace();
        }
    }

    /* renamed from: n */
    static String m4899n(Context context) {
        String str = null;
        try {
            str = C0623l.m4903r(context);
        } catch (Throwable th) {
            ae.m4671a(th, "DeviceInfo", "getSubscriberId");
            th.printStackTrace();
        }
        return str;
    }

    /* renamed from: o */
    static String m4900o(Context context) {
        try {
            return C0623l.m4904s(context);
        } catch (Throwable th) {
            ae.m4671a(th, "DeviceInfo", "getNetworkOperatorName");
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: p */
    static String m4901p(Context context) {
        try {
            return C0623l.m4904s(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: q */
    static String m4902q(Context context) {
        try {
            return C0623l.m4903r(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: r */
    private static String m4903r(Context context) {
        if (f3828f != null && !bi_常量类.f6358b_空串.equals(f3828f)) {
            return f3828f;
        }
        if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
            return f3828f;
        }
        f3828f = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
        return f3828f;
    }

    /* renamed from: s */
    private static String m4904s(Context context) {
        if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
            return null;
        }
        return ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName();
    }

    /* renamed from: t */
    private static String m4905t(Context context) {
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
            return bi_常量类.f6358b_空串;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return bi_常量类.f6358b_空串;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return bi_常量类.f6358b_空串;
        }
        return activeNetworkInfo.getTypeName();
    }

    /* renamed from: u */
    private static int m4906u(Context context) {
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
    private static String m4907v(Context context) {
        String str = bi_常量类.f6358b_空串;
        String n = C0623l.m4899n(context);
        if (n == null || n.length() < 5) {
            return str;
        }
        return n.substring(3, 5);
    }

    /* renamed from: w */
    private static int m4908w(Context context) {
        if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
            return -1;
        }
        return ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
    }

    /* renamed from: a */
    private static List<ScanResult> m4884a(List<ScanResult> list) {
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
