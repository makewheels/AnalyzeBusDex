package p054u.aly;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiManager;
import android.os.Environment;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: DeviceConfig */
/* renamed from: u.aly.bi */
public class bi_常量类 {
    /* renamed from: a */
    protected static final String f6357a = bi_常量类.class.getName();
    /* renamed from: b */
    public static final String f6358b_空串 = "";
    /* renamed from: c */
    public static final String f6359c = "2G/3G";
    /* renamed from: d */
    public static final String f6360d = "Wi-Fi";
    /* renamed from: e */
    public static final int f6361e = 8;

    /* renamed from: a */
    public static boolean m9973a(String str, Context context) {
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m9971a(Context context) {
        return context.getResources().getConfiguration().locale.toString().equals(Locale.CHINA.toString());
    }

    /* renamed from: b */
    public static boolean m9976b(Context context) {
        if (context.getResources().getConfiguration().orientation == 1) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    public static String m9978c(Context context) {
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (NameNotFoundException e) {
            return f6358b_空串;
        }
    }

    /* renamed from: d */
    public static String m9979d(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            return f6358b_空串;
        }
    }

    /* renamed from: a */
    public static boolean m9972a(Context context, String str) {
        if (context.getPackageManager().checkPermission(str, context.getPackageName()) != 0) {
            return false;
        }
        return true;
    }

    /* renamed from: e */
    public static String m9980e(Context context) {
        ApplicationInfo applicationInfo;
        PackageManager packageManager = context.getPackageManager();
        try {
            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            applicationInfo = null;
        }
        return (String) (applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo) : f6358b_空串);
    }

    /* renamed from: a */
    public static String[] m9974a(GL10 gl10) {
        try {
            String[] strArr = new String[2];
            String glGetString = gl10.glGetString(7936);
            String glGetString2 = gl10.glGetString(7937);
            strArr[0] = glGetString;
            strArr[1] = glGetString2;
            return strArr;
        } catch (Exception e) {
            bj.m10003b(f6357a, "Could not read gpu infor:", e);
            return new String[0];
        }
    }

    /* renamed from: a */
    public static String m9968a() {
        String str = null;
        try {
            Reader fileReader = new FileReader("/proc/cpuinfo");
            if (fileReader != null) {
                try {
                    BufferedReader bufferedReader = new BufferedReader(fileReader, 1024);
                    str = bufferedReader.readLine();
                    bufferedReader.close();
                    fileReader.close();
                } catch (Exception e) {
                    bj.m10003b(f6357a, "Could not read from file /proc/cpuinfo", e);
                }
            }
        } catch (Exception e2) {
            bj.m10003b(f6357a, "Could not open file /proc/cpuinfo", e2);
        }
        if (str != null) {
            return str.substring(str.indexOf(58) + 1).trim();
        }
        return f6358b_空串;
    }

    /* renamed from: f */
    public static String m9981f(Context context) {
        String deviceId;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            bj.m10008e(f6357a, "No IMEI.");
        }
        String str = f6358b_空串;
        try {
            if (bi_常量类.m9972a(context, "android.permission.READ_PHONE_STATE")) {
                deviceId = telephonyManager.getDeviceId();
                if (TextUtils.isEmpty(deviceId)) {
                    return deviceId;
                }
                bj.m10008e(f6357a, "No IMEI.");
                deviceId = bi_常量类.m9991p(context);
                if (TextUtils.isEmpty(deviceId)) {
                    return deviceId;
                }
                bj.m10008e(f6357a, "Failed to take mac as IMEI. Try to use Secure.ANDROID_ID instead.");
                deviceId = Secure.getString(context.getContentResolver(), "android_id");
                bj.m10000a(f6357a, "getDeviceId: Secure.ANDROID_ID: " + deviceId);
                return deviceId;
            }
        } catch (Exception e) {
            bj.m10009e(f6357a, "No IMEI.", e);
        }
        deviceId = str;
        if (TextUtils.isEmpty(deviceId)) {
            return deviceId;
        }
        bj.m10008e(f6357a, "No IMEI.");
        deviceId = bi_常量类.m9991p(context);
        if (TextUtils.isEmpty(deviceId)) {
            return deviceId;
        }
        bj.m10008e(f6357a, "Failed to take mac as IMEI. Try to use Secure.ANDROID_ID instead.");
        deviceId = Secure.getString(context.getContentResolver(), "android_id");
        bj.m10000a(f6357a, "getDeviceId: Secure.ANDROID_ID: " + deviceId);
        return deviceId;
    }

    /* renamed from: g */
    public static String m9982g(Context context) {
        return bv.m10061b(bi_常量类.m9981f(context));
    }

    /* renamed from: h */
    public static String m9983h(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return f6358b_空串;
            }
            return telephonyManager.getNetworkOperatorName();
        } catch (Exception e) {
            e.printStackTrace();
            return f6358b_空串;
        }
    }

    /* renamed from: i */
    public static String m9984i(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return new StringBuilder(String.valueOf(String.valueOf(displayMetrics.heightPixels))).append("*").append(String.valueOf(displayMetrics.widthPixels)).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return f6358b_空串;
        }
    }

    /* renamed from: j */
    public static String[] m9985j(Context context) {
        String[] strArr = new String[]{f6358b_空串, f6358b_空串};
        try {
            if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) != 0) {
                strArr[0] = f6358b_空串;
                return strArr;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                strArr[0] = f6358b_空串;
                return strArr;
            } else if (connectivityManager.getNetworkInfo(1).getState() == State.CONNECTED) {
                strArr[0] = f6360d;
                return strArr;
            } else {
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
                if (networkInfo.getState() == State.CONNECTED) {
                    strArr[0] = f6359c;
                    strArr[1] = networkInfo.getSubtypeName();
                    return strArr;
                }
                return strArr;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: k */
    public static boolean m9986k(Context context) {
        return f6360d.equals(bi_常量类.m9985j(context)[0]);
    }

    /* renamed from: l */
    public static boolean m9987l(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnectedOrConnecting();
            }
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    /* renamed from: b */
    public static boolean m9975b() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            return true;
        }
        return false;
    }

    /* renamed from: m */
    public static int m9988m(Context context) {
        try {
            Calendar instance = Calendar.getInstance(bi_常量类.m9999x(context));
            if (instance != null) {
                return instance.getTimeZone().getRawOffset() / 3600000;
            }
        } catch (Exception e) {
            bj.m10001a(f6357a, "error in getTimeZone", e);
        }
        return 8;
    }

    /* renamed from: n */
    public static String[] m9989n(Context context) {
        String[] strArr = new String[2];
        try {
            Locale x = bi_常量类.m9999x(context);
            if (x != null) {
                strArr[0] = x.getCountry();
                strArr[1] = x.getLanguage();
            }
            if (TextUtils.isEmpty(strArr[0])) {
                strArr[0] = "Unknown";
            }
            if (TextUtils.isEmpty(strArr[1])) {
                strArr[1] = "Unknown";
            }
        } catch (Exception e) {
            bj.m10003b(f6357a, "error in getLocaleInfo", e);
        }
        return strArr;
    }

    /* renamed from: x */
    private static Locale m9999x(Context context) {
        Locale locale = null;
        try {
            Configuration configuration = new Configuration();
            configuration.setToDefaults();
            System.getConfiguration(context.getContentResolver(), configuration);
            if (configuration != null) {
                locale = configuration.locale;
            }
        } catch (Exception e) {
            bj.m10002b(f6357a, "fail to read user config locale");
        }
        if (locale == null) {
            return Locale.getDefault();
        }
        return locale;
    }

    /* renamed from: o */
    public static String m9990o(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                String string = applicationInfo.metaData.getString("UMENG_APPKEY");
                if (string != null) {
                    return string.trim();
                }
                bj.m10002b(f6357a, "Could not read UMENG_APPKEY meta-data from AndroidManifest.xml.");
            }
        } catch (Exception e) {
            bj.m10003b(f6357a, "Could not read UMENG_APPKEY meta-data from AndroidManifest.xml.", e);
        }
        return null;
    }

    /* renamed from: p */
    public static String m9991p(Context context) {
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (bi_常量类.m9972a(context, "android.permission.ACCESS_WIFI_STATE")) {
                return wifiManager.getConnectionInfo().getMacAddress();
            }
            bj.m10008e(f6357a, "Could not get mac address.[no permission android.permission.ACCESS_WIFI_STATE");
            return f6358b_空串;
        } catch (Exception e) {
            bj.m10008e(f6357a, "Could not get mac address." + e.toString());
        }
    }

    /* renamed from: q */
    public static String m9992q(Context context) {
        int[] r = bi_常量类.m9993r(context);
        if (r == null) {
            return "Unknown";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(r[0]);
        stringBuffer.append("*");
        stringBuffer.append(r[1]);
        return stringBuffer.toString();
    }

    /* renamed from: r */
    public static int[] m9993r(Context context) {
        try {
            int a;
            int a2;
            int i;
            Object displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            if ((context.getApplicationInfo().flags & 8192) == 0) {
                a = bi_常量类.m9966a(displayMetrics, "noncompatWidthPixels");
                a2 = bi_常量类.m9966a(displayMetrics, "noncompatHeightPixels");
            } else {
                a2 = -1;
                a = -1;
            }
            if (a == -1 || a2 == -1) {
                i = displayMetrics.widthPixels;
                a = displayMetrics.heightPixels;
            } else {
                i = a;
                a = a2;
            }
            int[] iArr = new int[2];
            if (i > a) {
                iArr[0] = a;
                iArr[1] = i;
                return iArr;
            }
            iArr[0] = i;
            iArr[1] = a;
            return iArr;
        } catch (Exception e) {
            bj.m10003b(f6357a, "read resolution fail", e);
            return null;
        }
    }

    /* renamed from: a */
    private static int m9966a(Object obj, String str) {
        try {
            Field declaredField = DisplayMetrics.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.getInt(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /* renamed from: s */
    public static String m9994s(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName();
        } catch (Exception e) {
            bj.m10001a(f6357a, "read carrier fail", e);
            return "Unknown";
        }
    }

    /* renamed from: a */
    public static String m9969a(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(date);
    }

    /* renamed from: c */
    public static String m9977c() {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(new Date());
    }

    /* renamed from: a */
    public static Date m9970a(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).parse(str);
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: a */
    public static int m9967a(Date date, Date date2) {
        if (!date.after(date2)) {
            Date date3 = date2;
            date2 = date;
            date = date3;
        }
        return (int) ((date.getTime() - date2.getTime()) / 1000);
    }

    /* renamed from: t */
    public static String m9995t(Context context) {
        String str = "Unknown";
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                Object obj = applicationInfo.metaData.get("UMENG_CHANNEL");
                if (obj != null) {
                    String obj2 = obj.toString();
                    if (obj2 != null) {
                        return obj2;
                    }
                    bj.m10000a(f6357a, "Could not read UMENG_CHANNEL meta-data from AndroidManifest.xml.");
                    return str;
                }
            }
        } catch (Exception e) {
            bj.m10000a(f6357a, "Could not read UMENG_CHANNEL meta-data from AndroidManifest.xml.");
            e.printStackTrace();
        }
        return str;
    }

    /* renamed from: u */
    public static String m9996u(Context context) {
        return context.getPackageName();
    }

    /* renamed from: v */
    public static String m9997v(Context context) {
        return context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString();
    }

    /* renamed from: w */
    public static boolean m9998w(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception e) {
            return false;
        }
    }
}
