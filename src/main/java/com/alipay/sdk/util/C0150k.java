package com.alipay.sdk.util;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.alipay.sdk.cons.C0108a;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.alipay.sdk.util.k */
public final class C0150k {
    /* renamed from: a */
    static final String f465a = "com.alipay.android.app";
    /* renamed from: b */
    public static final String f466b = "com.eg.android.AlipayGphone";
    /* renamed from: c */
    private static final String f467c = "7.0.0";

    /* renamed from: a */
    private static int m520a(String str, String str2) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        arrayList.addAll(Arrays.asList(str.split("\\.")));
        arrayList2.addAll(Arrays.asList(str2.split("\\.")));
        int max = Math.max(arrayList.size(), arrayList2.size());
        while (arrayList.size() < max) {
            arrayList.add("0");
        }
        while (arrayList2.size() < max) {
            arrayList2.add("0");
        }
        for (int i = 0; i < max; i++) {
            if (Integer.parseInt((String) arrayList.get(i)) != Integer.parseInt((String) arrayList2.get(i))) {
                return Integer.parseInt((String) arrayList.get(i)) - Integer.parseInt((String) arrayList2.get(i));
            }
        }
        return 0;
    }

    /* renamed from: a */
    public static String m521a() {
        return "Android " + VERSION.RELEASE;
    }

    /* renamed from: a */
    public static String m522a(byte[] bArr) {
        try {
            String obj = ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArr))).getPublicKey().toString();
            if (obj.indexOf("modulus") != -1) {
                return obj.substring(obj.indexOf("modulus") + 8, obj.lastIndexOf(",")).trim();
            }
        } catch (Exception e) {
        }
        return null;
    }

    /* renamed from: a */
    public static boolean m523a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(f465a, 128) != null;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m524a(PackageInfo packageInfo) {
        int i = packageInfo.applicationInfo.flags;
        return (i & 1) == 0 && (i & 128) == 0;
    }

    /* renamed from: a */
    public static boolean m525a(String str) {
        return Pattern.compile("^http(s)?://([a-z0-9_\\-]+\\.)*(alipay|taobao)\\.(com|net)(:\\d+)?(/.*)?$").matcher(str).matches();
    }

    /* renamed from: a */
    private static byte[] m526a(Context context, String str) {
        for (PackageInfo packageInfo : context.getPackageManager().getInstalledPackages(64)) {
            if (packageInfo.packageName.equals(str)) {
                return packageInfo.signatures[0].toByteArray();
            }
        }
        return null;
    }

    /* renamed from: b */
    public static String m527b() {
        String c = C0150k.m529c();
        int indexOf = c.indexOf("-");
        if (indexOf != -1) {
            c = c.substring(0, indexOf);
        }
        indexOf = c.indexOf("\n");
        if (indexOf != -1) {
            c = c.substring(0, indexOf);
        }
        return "Linux " + c;
    }

    /* renamed from: b */
    public static boolean m528b(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(f466b, 128);
            if (packageInfo == null) {
                return false;
            }
            int parseInt;
            String str = packageInfo.versionName;
            String str2 = f467c;
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            arrayList.addAll(Arrays.asList(str.split("\\.")));
            arrayList2.addAll(Arrays.asList(str2.split("\\.")));
            int max = Math.max(arrayList.size(), arrayList2.size());
            while (arrayList.size() < max) {
                arrayList.add("0");
            }
            while (arrayList2.size() < max) {
                arrayList2.add("0");
            }
            for (int i = 0; i < max; i++) {
                if (Integer.parseInt((String) arrayList.get(i)) != Integer.parseInt((String) arrayList2.get(i))) {
                    parseInt = Integer.parseInt((String) arrayList.get(i)) - Integer.parseInt((String) arrayList2.get(i));
                    break;
                }
            }
            parseInt = 0;
            return parseInt >= 0;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    /* renamed from: c */
    private static String m529c() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/version"), 256);
            CharSequence readLine = bufferedReader.readLine();
            bufferedReader.close();
            Matcher matcher = Pattern.compile("\\w+\\s+\\w+\\s+([^\\s]+)\\s+\\(([^\\s@]+(?:@[^\\s.]+)?)[^)]*\\)\\s+\\((?:[^(]*\\([^)]*\\))?[^)]*\\)\\s+([^\\s]+)\\s+(?:PREEMPT\\s+)?(.+)").matcher(readLine);
            return !matcher.matches() ? "Unavailable" : matcher.groupCount() < 4 ? "Unavailable" : new StringBuilder(matcher.group(1)).append("\n").append(matcher.group(2)).append(" ").append(matcher.group(3)).append("\n").append(matcher.group(4)).toString();
        } catch (IOException e) {
            return "Unavailable";
        } catch (Throwable th) {
            bufferedReader.close();
        }
    }

    /* renamed from: c */
    public static String m530c(Context context) {
        String a = C0150k.m521a();
        String b = C0150k.m527b();
        String d = C0150k.m532d(context);
        return " (" + a + ";" + b + ";" + d + ";;" + C0150k.m534e(context) + ")(sdk android)";
    }

    /* renamed from: d */
    private static String m531d() {
        String str = C0108a.f259b;
        return str.substring(0, str.indexOf("://"));
    }

    /* renamed from: d */
    public static String m532d(Context context) {
        return context.getResources().getConfiguration().locale.toString();
    }

    /* renamed from: e */
    private static String m533e() {
        return "-1;-1";
    }

    /* renamed from: e */
    public static String m534e(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(displayMetrics.widthPixels);
        stringBuilder.append("*");
        stringBuilder.append(displayMetrics.heightPixels);
        return stringBuilder.toString();
    }

    /* renamed from: f */
    private static String m535f() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 24; i++) {
            switch (random.nextInt(3)) {
                case 0:
                    stringBuilder.append(String.valueOf((char) ((int) Math.round((Math.random() * 25.0d) + 65.0d))));
                    break;
                case 1:
                    stringBuilder.append(String.valueOf((char) ((int) Math.round((Math.random() * 25.0d) + 97.0d))));
                    break;
                case 2:
                    stringBuilder.append(String.valueOf(new Random().nextInt(10)));
                    break;
                default:
                    break;
            }
        }
        return stringBuilder.toString();
    }

    /* renamed from: f */
    public static String m536f(Context context) {
        try {
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName.contains(f466b)) {
                    return runningAppProcessInfo.processName;
                }
            }
            return null;
        } catch (Throwable th) {
            return "error";
        }
    }

    /* renamed from: g */
    public static String m537g(Context context) {
        List installedPackages = context.getPackageManager().getInstalledPackages(0);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < installedPackages.size(); i++) {
            PackageInfo packageInfo = (PackageInfo) installedPackages.get(i);
            int i2 = packageInfo.applicationInfo.flags;
            i2 = ((i2 & 1) == 0 && (i2 & 128) == 0) ? 1 : 0;
            if (i2 != 0) {
                if (packageInfo.packageName.equals(f466b)) {
                    stringBuilder.append(packageInfo.packageName).append(packageInfo.versionCode).append("-");
                } else if (!packageInfo.packageName.contains("theme")) {
                    stringBuilder.append(packageInfo.packageName).append("-");
                }
            }
        }
        String stringBuilder2 = stringBuilder.toString();
        return (stringBuilder2 == null || stringBuilder2.length() <= 0) ? null : stringBuilder2.substring(0, stringBuilder2.length() - 1);
    }

    /* renamed from: h */
    private static DisplayMetrics m538h(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }
}
