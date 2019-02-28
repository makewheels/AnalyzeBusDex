package com.iflytek.cloud.p023b.p024e;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.iflytek.cloud.p023b.p024e.p029a.C0939a;
import com.iflytek.cloud.p030c.C0950a;
import java.lang.reflect.Field;
import p054u.aly.bi_常量类;

/* renamed from: com.iflytek.cloud.b.e.a */
public class C0942a {
    /* renamed from: a */
    public static String[][] f4485a;
    /* renamed from: b */
    private static String[][] f4486b;
    /* renamed from: c */
    private static C0950a f4487c = new C0950a();
    /* renamed from: d */
    private static boolean f4488d = false;

    static {
        r0 = new String[11][];
        r0[0] = new String[]{"os.manufact", Build.MANUFACTURER};
        r0[1] = new String[]{"os.model", Build.MODEL};
        r0[2] = new String[]{"os.product", Build.PRODUCT};
        r0[3] = new String[]{"os.display", Build.DISPLAY};
        r0[4] = new String[]{"os.host", Build.HOST};
        r0[5] = new String[]{"os.id", Build.ID};
        r0[6] = new String[]{"os.device", Build.DEVICE};
        r0[7] = new String[]{"os.board", Build.BOARD};
        r0[8] = new String[]{"os.brand", Build.BRAND};
        r0[9] = new String[]{"os.user", Build.USER};
        r0[10] = new String[]{"os.type", Build.TYPE};
        f4485a = r0;
        r0 = new String[6][];
        r0[0] = new String[]{"os.cpu", "CPU_ABI"};
        r0[1] = new String[]{"os.cpu2", "CPU_ABI2"};
        r0[2] = new String[]{"os.serial", "SERIAL"};
        r0[3] = new String[]{"os.hardware", "HARDWARE"};
        r0[4] = new String[]{"os.bootloader", "BOOTLOADER"};
        r0[5] = new String[]{"os.radio", "RADIO"};
        f4486b = r0;
    }

    /* renamed from: a */
    public static synchronized C0950a m7128a(Context context) {
        C0950a c0950a;
        synchronized (C0942a.class) {
            if (f4488d) {
                c0950a = f4487c;
            } else {
                C0942a.m7131b(context);
                c0950a = f4487c;
            }
        }
        return c0950a;
    }

    /* renamed from: a */
    private static String m7129a(String str) {
        try {
            Field field = Build.class.getField(str);
            return field != null ? field.get(new Build()).toString() : "unknown";
        } catch (Exception e) {
            return "unknown";
        }
    }

    /* renamed from: a */
    public static void m7130a(C0950a c0950a, Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
            c0950a.m7170a("app.ver.name", packageInfo.versionName);
            c0950a.m7170a("app.ver.code", bi_常量类.f6358b + packageInfo.versionCode);
            c0950a.m7170a("app.pkg", applicationInfo.packageName);
            c0950a.m7170a("app.path", applicationInfo.dataDir);
            c0950a.m7170a("app.name", applicationInfo.loadLabel(context.getPackageManager()).toString());
        } catch (Exception e) {
        }
    }

    /* renamed from: b */
    private static void m7131b(Context context) {
        try {
            int i;
            f4487c.m7167a();
            f4487c.m7170a("os.system", "Android");
            C0942a.m7130a(f4487c, context);
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            f4487c.m7170a("os.resolution", displayMetrics.widthPixels + "*" + displayMetrics.heightPixels);
            f4487c.m7170a("os.density", bi_常量类.f6358b + displayMetrics.density);
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            f4487c.m7170a("os.imei", telephonyManager.getDeviceId());
            f4487c.m7170a("os.imsi", telephonyManager.getSubscriberId());
            f4487c.m7170a("net.mac", ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress());
            f4487c.m7170a("os.version", VERSION.SDK);
            f4487c.m7170a("os.release", VERSION.RELEASE);
            f4487c.m7170a("os.incremental", VERSION.INCREMENTAL);
            for (i = 0; i < f4485a.length; i++) {
                f4487c.m7170a(f4485a[i][0], f4485a[i][1]);
            }
            for (i = 0; i < f4486b.length; i++) {
                f4487c.m7170a(f4486b[i][0], C0942a.m7129a(f4486b[i][1]));
            }
            f4488d = true;
        } catch (Exception e) {
            C0939a.m7120a("Failed to get prop Info");
            f4488d = false;
        }
    }
}
