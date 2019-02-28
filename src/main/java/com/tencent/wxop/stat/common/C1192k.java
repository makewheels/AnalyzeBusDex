package com.tencent.wxop.stat.common;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.sdk.WebView;
import com.tencent.wxop.stat.StatConfig;
import com.tencent.wxop.stat.StatSpecifyReportedInfo;
import com.umeng.analytics.C1233a;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpHost;
import org.json.JSONObject;
import p054u.aly.bi_常量类;

/* renamed from: com.tencent.wxop.stat.common.k */
public class C1192k {
    /* renamed from: a */
    private static String f5480a = null;
    /* renamed from: b */
    private static String f5481b = null;
    /* renamed from: c */
    private static String f5482c = null;
    /* renamed from: d */
    private static String f5483d = null;
    /* renamed from: e */
    private static Random f5484e = null;
    /* renamed from: f */
    private static DisplayMetrics f5485f = null;
    /* renamed from: g */
    private static String f5486g = null;
    /* renamed from: h */
    private static String f5487h = bi_常量类.f6358b;
    /* renamed from: i */
    private static String f5488i = bi_常量类.f6358b;
    /* renamed from: j */
    private static int f5489j = -1;
    /* renamed from: k */
    private static StatLogger f5490k = null;
    /* renamed from: l */
    private static String f5491l = null;
    /* renamed from: m */
    private static String f5492m = null;
    /* renamed from: n */
    private static volatile int f5493n = -1;
    /* renamed from: o */
    private static String f5494o = null;
    /* renamed from: p */
    private static String f5495p = null;
    /* renamed from: q */
    private static long f5496q = -1;
    /* renamed from: r */
    private static String f5497r = bi_常量类.f6358b;
    /* renamed from: s */
    private static C1195n f5498s = null;
    /* renamed from: t */
    private static String f5499t = "__MTA_FIRST_ACTIVATE__";
    /* renamed from: u */
    private static int f5500u = -1;
    /* renamed from: v */
    private static long f5501v = -1;
    /* renamed from: w */
    private static int f5502w = 0;
    /* renamed from: x */
    private static String f5503x = bi_常量类.f6358b;

    /* renamed from: A */
    public static int m8267A(Context context) {
        return C1197p.m8321a(context, "mta.qq.com.difftime", 0);
    }

    /* renamed from: B */
    public static boolean m8268B(Context context) {
        if (context == null) {
            return false;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return false;
        }
        String packageName = context.getPackageName();
        for (RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
            if (runningAppProcessInfo.processName.startsWith(packageName)) {
                return runningAppProcessInfo.importance == ErrorCode.INFO_CODE_BASE;
            }
        }
        return false;
    }

    /* renamed from: C */
    public static String m8269C(Context context) {
        if (context == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 0);
        return (resolveActivity.activityInfo == null || resolveActivity.activityInfo.packageName.equals("android")) ? null : resolveActivity.activityInfo.packageName;
    }

    /* renamed from: D */
    private static long m8270D(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        MemoryInfo memoryInfo = new MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    /* renamed from: a */
    public static int m8271a() {
        return C1192k.m8295g().nextInt(Integer.MAX_VALUE);
    }

    /* renamed from: a */
    public static int m8272a(Context context, boolean z) {
        if (z) {
            f5502w = C1192k.m8267A(context);
        }
        return f5502w;
    }

    /* renamed from: a */
    public static Long m8273a(String str, String str2, int i, int i2, Long l) {
        if (str == null || str2 == null) {
            return l;
        }
        if (str2.equalsIgnoreCase(".") || str2.equalsIgnoreCase("|")) {
            str2 = "\\" + str2;
        }
        String[] split = str.split(str2);
        if (split.length != i2) {
            return l;
        }
        try {
            Long valueOf = Long.valueOf(0);
            int i3 = 0;
            while (i3 < split.length) {
                Long valueOf2 = Long.valueOf(((long) i) * (valueOf.longValue() + Long.valueOf(split[i3]).longValue()));
                i3++;
                valueOf = valueOf2;
            }
            return valueOf;
        } catch (NumberFormatException e) {
            return l;
        }
    }

    /* renamed from: a */
    public static String m8274a(int i) {
        Calendar instance = Calendar.getInstance();
        instance.roll(6, i);
        return new SimpleDateFormat("yyyyMMdd").format(instance.getTime());
    }

    /* renamed from: a */
    public static String m8275a(long j) {
        return new SimpleDateFormat("yyyyMMdd").format(new Date(j));
    }

    /* renamed from: a */
    public static String m8276a(Context context, String str) {
        if (!StatConfig.isEnableConcurrentProcess()) {
            return str;
        }
        if (f5492m == null) {
            f5492m = C1192k.m8306q(context);
        }
        return f5492m != null ? str + "_" + f5492m : str;
    }

    /* renamed from: a */
    public static String m8277a(String str) {
        if (str == null) {
            return "0";
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                int i = b & WebView.NORMAL_MODE_ALPHA;
                if (i < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i));
            }
            return stringBuffer.toString();
        } catch (Throwable th) {
            return "0";
        }
    }

    /* renamed from: a */
    public static HttpHost m8278a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) != 0) {
                return null;
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return null;
            }
            if (activeNetworkInfo.getTypeName() != null && activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) {
                return null;
            }
            String extraInfo = activeNetworkInfo.getExtraInfo();
            if (extraInfo == null) {
                return null;
            }
            if (extraInfo.equals("cmwap") || extraInfo.equals("3gwap") || extraInfo.equals("uniwap")) {
                return new HttpHost("10.0.0.172", 80);
            }
            if (extraInfo.equals("ctwap")) {
                return new HttpHost("10.0.0.200", 80);
            }
            String defaultHost = Proxy.getDefaultHost();
            if (defaultHost != null && defaultHost.trim().length() > 0) {
                return new HttpHost(defaultHost, Proxy.getDefaultPort());
            }
            return null;
        } catch (Throwable th) {
            f5490k.m8242e(th);
        }
    }

    /* renamed from: a */
    public static void m8279a(Context context, int i) {
        f5502w = i;
        C1197p.m8325b(context, "mta.qq.com.difftime", i);
    }

    /* renamed from: a */
    public static boolean m8280a(StatSpecifyReportedInfo statSpecifyReportedInfo) {
        return statSpecifyReportedInfo == null ? false : C1192k.m8287c(statSpecifyReportedInfo.getAppKey());
    }

    /* renamed from: a */
    public static byte[] m8281a(byte[] bArr) {
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        byte[] bArr2 = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length * 2);
        while (true) {
            int read = gZIPInputStream.read(bArr2);
            if (read != -1) {
                byteArrayOutputStream.write(bArr2, 0, read);
            } else {
                bArr2 = byteArrayOutputStream.toByteArray();
                byteArrayInputStream.close();
                gZIPInputStream.close();
                byteArrayOutputStream.close();
                return bArr2;
            }
        }
    }

    /* renamed from: b */
    public static long m8282b(String str) {
        return C1192k.m8273a(str, ".", 100, 3, Long.valueOf(0)).longValue();
    }

    /* renamed from: b */
    public static synchronized StatLogger m8283b() {
        StatLogger statLogger;
        synchronized (C1192k.class) {
            if (f5490k == null) {
                statLogger = new StatLogger(StatConstants.LOG_TAG);
                f5490k = statLogger;
                statLogger.setDebugEnable(false);
            }
            statLogger = f5490k;
        }
        return statLogger;
    }

    /* renamed from: b */
    public static synchronized String m8284b(Context context) {
        String a;
        synchronized (C1192k.class) {
            if (f5480a == null || f5480a.trim().length() == 0) {
                a = C1198q.m8328a(context);
                f5480a = a;
                if (a == null || f5480a.trim().length() == 0) {
                    f5480a = Integer.toString(C1192k.m8295g().nextInt(Integer.MAX_VALUE));
                }
                a = f5480a;
            } else {
                a = f5480a;
            }
        }
        return a;
    }

    /* renamed from: c */
    public static long m8285c() {
        try {
            Calendar instance = Calendar.getInstance();
            instance.set(11, 0);
            instance.set(12, 0);
            instance.set(13, 0);
            instance.set(14, 0);
            return instance.getTimeInMillis() + C1233a.f5597m;
        } catch (Throwable th) {
            f5490k.m8242e(th);
            return System.currentTimeMillis() + C1233a.f5597m;
        }
    }

    /* renamed from: c */
    public static synchronized String m8286c(Context context) {
        String str;
        synchronized (C1192k.class) {
            if (f5482c == null || f5482c.trim().length() == 0) {
                f5482c = C1198q.m8333b(context);
            }
            str = f5482c;
        }
        return str;
    }

    /* renamed from: c */
    public static boolean m8287c(String str) {
        return (str == null || str.trim().length() == 0) ? false : true;
    }

    /* renamed from: d */
    public static DisplayMetrics m8288d(Context context) {
        if (f5485f == null) {
            f5485f = new DisplayMetrics();
            ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(f5485f);
        }
        return f5485f;
    }

    /* renamed from: d */
    public static String m8289d() {
        if (C1192k.m8287c(f5495p)) {
            return f5495p;
        }
        long e = C1192k.m8290e() / 1000000;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        String str = String.valueOf((((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / 1000000) + "/" + String.valueOf(e);
        f5495p = str;
        return str;
    }

    /* renamed from: e */
    public static long m8290e() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
    }

    /* renamed from: e */
    public static boolean m8291e(Context context) {
        try {
            if (C1198q.m8332a(context, "android.permission.ACCESS_WIFI_STATE")) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
                if (connectivityManager != null) {
                    NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
                    if (allNetworkInfo != null) {
                        int i = 0;
                        while (i < allNetworkInfo.length) {
                            if (allNetworkInfo[i].getTypeName().equalsIgnoreCase("WIFI") && allNetworkInfo[i].isConnected()) {
                                return true;
                            }
                            i++;
                        }
                    }
                }
                return false;
            }
            f5490k.warn("can not get the permission of android.permission.ACCESS_WIFI_STATE");
            return false;
        } catch (Throwable th) {
            f5490k.m8242e(th);
        }
    }

    /* renamed from: f */
    public static String m8293f(Context context) {
        if (f5481b != null) {
            return f5481b;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                String string = applicationInfo.metaData.getString("TA_APPKEY");
                if (string != null) {
                    f5481b = string;
                    return string;
                }
                f5490k.m8243i("Could not read APPKEY meta-data from AndroidManifest.xml");
            }
        } catch (Throwable th) {
            f5490k.m8243i("Could not read APPKEY meta-data from AndroidManifest.xml");
        }
        return null;
    }

    /* renamed from: g */
    public static String m8294g(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                Object obj = applicationInfo.metaData.get("InstallChannel");
                if (obj != null) {
                    return obj.toString();
                }
                f5490k.m8245w("Could not read InstallChannel meta-data from AndroidManifest.xml");
            }
        } catch (Throwable th) {
            f5490k.m8241e((Object) "Could not read InstallChannel meta-data from AndroidManifest.xml");
        }
        return null;
    }

    /* renamed from: g */
    private static synchronized Random m8295g() {
        Random random;
        synchronized (C1192k.class) {
            if (f5484e == null) {
                f5484e = new Random();
            }
            random = f5484e;
        }
        return random;
    }

    /* renamed from: h */
    private static long m8296h() {
        if (f5496q > 0) {
            return f5496q;
        }
        long j = 1;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            j = (long) (Integer.valueOf(bufferedReader.readLine().split("\\s+")[1]).intValue() * 1024);
            bufferedReader.close();
        } catch (Exception e) {
        }
        f5496q = j;
        return j;
    }

    /* renamed from: h */
    public static String m8297h(Context context) {
        return context == null ? null : context.getClass().getName();
    }

    /* renamed from: i */
    public static String m8298i(Context context) {
        if (f5486g != null) {
            return f5486g;
        }
        try {
            if (!C1198q.m8332a(context, "android.permission.READ_PHONE_STATE")) {
                f5490k.m8241e((Object) "Could not get permission of android.permission.READ_PHONE_STATE");
            } else if (C1192k.m8300k(context)) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    f5486g = telephonyManager.getSimOperator();
                }
            }
        } catch (Throwable th) {
            f5490k.m8242e(th);
        }
        return f5486g;
    }

    /* renamed from: j */
    public static String m8299j(Context context) {
        if (C1192k.m8287c(f5487h)) {
            return f5487h;
        }
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            f5487h = str;
            if (str == null) {
                return bi_常量类.f6358b;
            }
        } catch (Throwable th) {
            f5490k.m8242e(th);
        }
        return f5487h;
    }

    /* renamed from: k */
    public static boolean m8300k(Context context) {
        return context.getPackageManager().checkPermission("android.permission.READ_PHONE_STATE", context.getPackageName()) == 0;
    }

    /* renamed from: l */
    public static String m8301l(Context context) {
        String str = bi_常量类.f6358b;
        try {
            if (C1198q.m8332a(context, "android.permission.INTERNET") && C1198q.m8332a(context, "android.permission.ACCESS_NETWORK_STATE")) {
                String typeName;
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    typeName = activeNetworkInfo.getTypeName();
                    String extraInfo = activeNetworkInfo.getExtraInfo();
                    if (typeName != null) {
                        if (typeName.equalsIgnoreCase("WIFI")) {
                            return "WIFI";
                        }
                        if (typeName.equalsIgnoreCase("MOBILE")) {
                            return extraInfo != null ? extraInfo : "MOBILE";
                        } else {
                            if (extraInfo != null) {
                                return extraInfo;
                            }
                            return typeName;
                        }
                    }
                }
                typeName = str;
                return typeName;
            }
            f5490k.m8241e((Object) "can not get the permission of android.permission.ACCESS_WIFI_STATE");
            return str;
        } catch (Throwable th) {
            f5490k.m8242e(th);
            return str;
        }
    }

    /* renamed from: m */
    public static Integer m8302m(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                return Integer.valueOf(telephonyManager.getNetworkType());
            }
        } catch (Throwable th) {
        }
        return null;
    }

    /* renamed from: n */
    public static String m8303n(Context context) {
        if (C1192k.m8287c(f5488i)) {
            return f5488i;
        }
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            f5488i = str;
            if (str == null || f5488i.length() == 0) {
                return "unknown";
            }
        } catch (Throwable th) {
            f5490k.m8242e(th);
        }
        return f5488i;
    }

    /* renamed from: o */
    public static int m8304o(Context context) {
        if (f5489j != -1) {
            return f5489j;
        }
        try {
            if (C1196o.m8320a()) {
                f5489j = 1;
            }
        } catch (Throwable th) {
            f5490k.m8242e(th);
        }
        f5489j = 0;
        return 0;
    }

    /* renamed from: p */
    public static String m8305p(Context context) {
        if (C1192k.m8287c(f5491l)) {
            return f5491l;
        }
        try {
            if (C1198q.m8332a(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                String externalStorageState = Environment.getExternalStorageState();
                if (externalStorageState != null && externalStorageState.equals("mounted")) {
                    externalStorageState = Environment.getExternalStorageDirectory().getPath();
                    if (externalStorageState != null) {
                        StatFs statFs = new StatFs(externalStorageState);
                        long availableBlocks = (((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / 1000000;
                        externalStorageState = String.valueOf(availableBlocks) + "/" + String.valueOf((((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 1000000);
                        f5491l = externalStorageState;
                        return externalStorageState;
                    }
                }
                return null;
            }
            f5490k.warn("can not get the permission of android.permission.WRITE_EXTERNAL_STORAGE");
            return null;
        } catch (Throwable th) {
            f5490k.m8242e(th);
        }
    }

    /* renamed from: q */
    static String m8306q(Context context) {
        try {
            if (f5492m != null) {
                return f5492m;
            }
            int myPid = Process.myPid();
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    f5492m = runningAppProcessInfo.processName;
                    break;
                }
            }
            return f5492m;
        } catch (Throwable th) {
        }
    }

    /* renamed from: r */
    public static String m8307r(Context context) {
        return C1192k.m8276a(context, StatConstants.DATABASE_NAME);
    }

    /* renamed from: s */
    public static synchronized Integer m8308s(Context context) {
        Integer valueOf;
        int i = 0;
        synchronized (C1192k.class) {
            if (f5493n <= 0) {
                f5493n = C1197p.m8321a(context, "MTA_EVENT_INDEX", 0);
                C1197p.m8325b(context, "MTA_EVENT_INDEX", f5493n + 1000);
            } else if (f5493n % 1000 == 0) {
                try {
                    int i2 = f5493n + 1000;
                    if (f5493n < 2147383647) {
                        i = i2;
                    }
                    C1197p.m8325b(context, "MTA_EVENT_INDEX", i);
                } catch (Throwable th) {
                    f5490k.m8245w(th);
                }
            }
            i = f5493n + 1;
            f5493n = i;
            valueOf = Integer.valueOf(i);
        }
        return valueOf;
    }

    /* renamed from: t */
    public static String m8309t(Context context) {
        try {
            return String.valueOf(C1192k.m8270D(context) / 1000000) + "/" + String.valueOf(C1192k.m8296h() / 1000000);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: u */
    public static JSONObject m8310u(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("n", C1193l.m8316a());
            String d = C1193l.m8319d();
            if (d != null && d.length() > 0) {
                jSONObject.put("na", d);
            }
            int b = C1193l.m8317b();
            if (b > 0) {
                jSONObject.put("fx", b / 1000000);
            }
            b = C1193l.m8318c();
            if (b > 0) {
                jSONObject.put("fn", b / 1000000);
            }
        } catch (Throwable th) {
            Log.w(StatConstants.LOG_TAG, "get cpu error", th);
        }
        return jSONObject;
    }

    /* renamed from: v */
    public static String m8311v(Context context) {
        if (C1192k.m8287c(f5497r)) {
            return f5497r;
        }
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            if (sensorManager != null) {
                List sensorList = sensorManager.getSensorList(-1);
                if (sensorList != null) {
                    StringBuilder stringBuilder = new StringBuilder(sensorList.size() * 10);
                    for (int i = 0; i < sensorList.size(); i++) {
                        stringBuilder.append(((Sensor) sensorList.get(i)).getType());
                        if (i != sensorList.size() - 1) {
                            stringBuilder.append(",");
                        }
                    }
                    f5497r = stringBuilder.toString();
                }
            }
        } catch (Throwable th) {
            f5490k.m8242e(th);
        }
        return f5497r;
    }

    /* renamed from: w */
    public static synchronized int m8312w(Context context) {
        int i;
        synchronized (C1192k.class) {
            if (f5500u != -1) {
                i = f5500u;
            } else {
                C1192k.m8313x(context);
                i = f5500u;
            }
        }
        return i;
    }

    /* renamed from: x */
    public static void m8313x(Context context) {
        int a = C1197p.m8321a(context, f5499t, 1);
        f5500u = a;
        if (a == 1) {
            C1197p.m8325b(context, f5499t, 0);
        }
    }

    /* renamed from: y */
    public static boolean m8314y(Context context) {
        if (f5501v < 0) {
            f5501v = C1197p.m8322a(context, "mta.qq.com.checktime", 0);
        }
        return Math.abs(System.currentTimeMillis() - f5501v) > C1233a.f5597m;
    }

    /* renamed from: z */
    public static void m8315z(Context context) {
        f5501v = System.currentTimeMillis();
        C1197p.m8326b(context, "mta.qq.com.checktime", f5501v);
    }
}
