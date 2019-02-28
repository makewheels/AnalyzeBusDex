package com.tencent.smtt.sdk.p051a;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.smtt.sdk.TbsConfig;
import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import p054u.aly.bi_常量类;

/* renamed from: com.tencent.smtt.sdk.a.d */
public class C1091d {

    /* renamed from: com.tencent.smtt.sdk.a.d$a */
    public static class C1089a {
        /* renamed from: a */
        public int f4939a = -1;
        /* renamed from: b */
        public int f4940b = -1;
        /* renamed from: c */
        public String f4941c = bi_常量类.f6358b_空串;
        /* renamed from: d */
        public String f4942d = "0";
        /* renamed from: e */
        public String f4943e = null;
    }

    /* renamed from: com.tencent.smtt.sdk.a.d$b */
    private static class C1090b {
        /* renamed from: a */
        public String f4944a;
        /* renamed from: b */
        public String f4945b;

        private C1090b() {
            this.f4944a = bi_常量类.f6358b_空串;
            this.f4945b = bi_常量类.f6358b_空串;
        }
    }

    /* renamed from: a */
    public static int m7691a(Context context, String str, HashMap<String, String> hashMap, String str2) {
        Object obj;
        String encode;
        Object obj2 = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            Object obj3;
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                PackageInfo packageInfo = packageManager.getPackageInfo(TbsConfig.APP_QB, 0);
                if (packageInfo != null && packageInfo.versionCode > 601000) {
                    obj3 = 1;
                    obj = obj3;
                    encode = URLEncoder.encode(str, "UTF-8");
                    if (obj != null) {
                        str = encode;
                    }
                    obj2 = obj;
                    stringBuilder.append("mttbrowser://url=").append(str).append(",product=").append("TBS").append(",packagename=").append(context.getPackageName()).append(",from=").append(str2).append(",version=").append(TbsConfig.TBS_SDK_VERSIONNAME).append(obj2 == null ? ",encoded=1" : bi_常量类.f6358b_空串);
                    return C1091d.m7698b(context, stringBuilder.toString(), hashMap);
                }
            }
            obj3 = null;
            obj = obj3;
        } catch (Throwable th) {
            obj = null;
        }
        try {
            encode = URLEncoder.encode(str, "UTF-8");
            if (obj != null) {
                str = encode;
            }
            obj2 = obj;
        } catch (Exception e) {
        }
        if (obj2 == null) {
        }
        stringBuilder.append("mttbrowser://url=").append(str).append(",product=").append("TBS").append(",packagename=").append(context.getPackageName()).append(",from=").append(str2).append(",version=").append(TbsConfig.TBS_SDK_VERSIONNAME).append(obj2 == null ? ",encoded=1" : bi_常量类.f6358b_空串);
        return C1091d.m7698b(context, stringBuilder.toString(), hashMap);
    }

    /* renamed from: a */
    public static C1089a m7692a(Context context) {
        boolean z = context.getApplicationContext().getSharedPreferences("x5_proxy_setting", 0).getBoolean("qb_install_status", false);
        C1089a c1089a = new C1089a();
        if (z) {
            return c1089a;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = null;
            try {
                packageInfo = packageManager.getPackageInfo(TbsConfig.APP_QB, 0);
                c1089a.f4939a = 2;
                c1089a.f4943e = TbsConfig.APP_QB;
                c1089a.f4941c = "ADRQB_";
                if (packageInfo != null && packageInfo.versionCode > 420000) {
                    c1089a.f4940b = packageInfo.versionCode;
                    c1089a.f4941c += packageInfo.versionName.replaceAll("\\.", bi_常量类.f6358b_空串);
                    c1089a.f4942d = packageInfo.versionName.replaceAll("\\.", bi_常量类.f6358b_空串);
                    return c1089a;
                }
            } catch (NameNotFoundException e) {
            }
            try {
                packageInfo = packageManager.getPackageInfo("com.tencent.qbx", 0);
                c1089a.f4939a = 0;
                c1089a.f4943e = "com.tencent.qbx";
                c1089a.f4941c = "ADRQBX_";
            } catch (NameNotFoundException e2) {
                try {
                    packageInfo = packageManager.getPackageInfo("com.tencent.qbx5", 0);
                    c1089a.f4939a = 1;
                    c1089a.f4943e = "com.tencent.qbx5";
                    c1089a.f4941c = "ADRQBX5_";
                } catch (NameNotFoundException e3) {
                    try {
                        packageInfo = packageManager.getPackageInfo(TbsConfig.APP_QB, 0);
                        c1089a.f4943e = TbsConfig.APP_QB;
                        c1089a.f4939a = 2;
                        c1089a.f4941c = "ADRQB_";
                    } catch (NameNotFoundException e4) {
                        try {
                            packageInfo = packageManager.getPackageInfo("com.tencent.mtt.x86", 0);
                            c1089a.f4943e = "com.tencent.mtt.x86";
                            c1089a.f4939a = 2;
                            c1089a.f4941c = "ADRQB_";
                        } catch (Exception e5) {
                            try {
                                C1090b a = C1091d.m7693a(context, Uri.parse("http://mdc.html5.qq.com/mh?channel_id=50079&u="));
                                if (!(a == null || TextUtils.isEmpty(a.f4945b))) {
                                    packageInfo = packageManager.getPackageInfo(a.f4945b, 0);
                                    c1089a.f4943e = a.f4945b;
                                    c1089a.f4939a = 2;
                                    c1089a.f4941c = "ADRQB_";
                                }
                            } catch (Exception e6) {
                            }
                        }
                    }
                }
            }
            if (packageInfo != null) {
                c1089a.f4940b = packageInfo.versionCode;
                c1089a.f4941c += packageInfo.versionName.replaceAll("\\.", bi_常量类.f6358b_空串);
                c1089a.f4942d = packageInfo.versionName.replaceAll("\\.", bi_常量类.f6358b_空串);
            }
        } catch (Exception e7) {
        }
        return c1089a;
    }

    /* renamed from: a */
    private static C1090b m7693a(Context context, Uri uri) {
        Intent intent = new Intent("com.tencent.QQBrowser.action.VIEW");
        intent.setData(uri);
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities.size() <= 0) {
            return null;
        }
        C1090b c1090b = new C1090b();
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            String str = resolveInfo.activityInfo.packageName;
            if (str.contains(TbsConfig.APP_QB)) {
                c1090b.f4944a = resolveInfo.activityInfo.name;
                c1090b.f4945b = resolveInfo.activityInfo.packageName;
                return c1090b;
            } else if (str.contains("com.tencent.qbx")) {
                c1090b.f4944a = resolveInfo.activityInfo.name;
                c1090b.f4945b = resolveInfo.activityInfo.packageName;
            }
        }
        return c1090b;
    }

    /* renamed from: a */
    public static boolean m7694a(Context context, long j, long j2) {
        C1089a a = C1091d.m7692a(context);
        boolean z = false;
        try {
            if (Long.valueOf(a.f4942d).longValue() >= j) {
                z = true;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return ((long) a.f4940b) >= j2 ? true : z;
    }

    /* renamed from: a */
    public static boolean m7695a(Context context, String str, int i, String str2, HashMap<String, String> hashMap, Bundle bundle) {
        try {
            Intent intent = new Intent("com.tencent.QQBrowser.action.sdk.document");
            if (hashMap != null) {
                Set<String> keySet = hashMap.keySet();
                if (keySet != null) {
                    for (String str3 : keySet) {
                        String str4 = (String) hashMap.get(str3);
                        if (!TextUtils.isEmpty(str4)) {
                            intent.putExtra(str3, str4);
                        }
                    }
                }
            }
            File file = new File(str);
            intent.putExtra("key_reader_sdk_id", 3);
            intent.putExtra("key_reader_sdk_type", i);
            if (i == 0) {
                intent.putExtra("key_reader_sdk_path", str);
            } else if (i == 1) {
                intent.putExtra("key_reader_sdk_url", str);
            }
            intent.putExtra("key_reader_sdk_format", str2);
            intent.setData(Uri.fromFile(file));
            intent.putExtra("loginType", C1091d.m7701d(context.getApplicationContext()));
            if (bundle != null) {
                intent.putExtra("key_reader_sdk_extrals", bundle);
            }
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m7696a(Context context, String str, HashMap<String, String> hashMap) {
        Object obj;
        Uri parse = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setFlags(268435456);
        intent.setDataAndType(parse, "video/*");
        if (hashMap != null) {
            Set<String> keySet = hashMap.keySet();
            if (keySet != null) {
                for (String str2 : keySet) {
                    String str3 = (String) hashMap.get(str2);
                    if (!TextUtils.isEmpty(str3)) {
                        intent.putExtra(str2, str3);
                    }
                }
            }
        }
        try {
            intent.putExtra("loginType", C1091d.m7701d(context));
            intent.setComponent(new ComponentName(TbsConfig.APP_QB, "com.tencent.mtt.browser.video.H5VideoThrdcallActivity"));
            context.startActivity(intent);
            obj = 1;
        } catch (Throwable th) {
            obj = null;
        }
        if (obj == null) {
            try {
                intent.setComponent(null);
                context.startActivity(intent);
            } catch (Throwable th2) {
                th2.printStackTrace();
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m7697a(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        String trim = str.trim();
        int indexOf = trim.toLowerCase().indexOf("://");
        int indexOf2 = trim.toLowerCase().indexOf(46);
        return (indexOf <= 0 || indexOf2 <= 0 || indexOf <= indexOf2) ? trim.toLowerCase().contains("://") : false;
    }

    /* renamed from: b */
    public static int m7698b(Context context, String str, HashMap<String, String> hashMap) {
        if (context == null) {
            return 3;
        }
        if (!C1091d.m7697a(str)) {
            str = "http://" + str;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                return 2;
            }
            C1089a a = C1091d.m7692a(context);
            if (a.f4939a == -1) {
                return 4;
            }
            if (a.f4939a == 2 && a.f4940b < 33) {
                return 5;
            }
            Intent intent;
            Intent intent2 = new Intent("android.intent.action.VIEW");
            C1090b a2;
            if (a.f4939a == 2) {
                if (a.f4940b >= 33 && a.f4940b <= 39) {
                    intent2.setClassName(TbsConfig.APP_QB, "com.tencent.mtt.MainActivity");
                    intent = intent2;
                } else if (a.f4940b < 40 || a.f4940b > 45) {
                    if (a.f4940b >= 46) {
                        intent2 = new Intent("com.tencent.QQBrowser.action.VIEW");
                        a2 = C1091d.m7693a(context, parse);
                        if (!(a2 == null || TextUtils.isEmpty(a2.f4944a))) {
                            intent2.setClassName(a2.f4945b, a2.f4944a);
                        }
                        intent = intent2;
                    }
                    intent = intent2;
                } else {
                    intent2.setClassName(TbsConfig.APP_QB, "com.tencent.mtt.SplashActivity");
                    intent = intent2;
                }
            } else if (a.f4939a == 1) {
                if (a.f4940b == 1) {
                    intent2.setClassName("com.tencent.qbx5", "com.tencent.qbx5.MainActivity");
                    intent = intent2;
                } else {
                    if (a.f4940b == 2) {
                        intent2.setClassName("com.tencent.qbx5", "com.tencent.qbx5.SplashActivity");
                        intent = intent2;
                    }
                    intent = intent2;
                }
            } else if (a.f4939a != 0) {
                intent2 = new Intent("com.tencent.QQBrowser.action.VIEW");
                a2 = C1091d.m7693a(context, parse);
                if (!(a2 == null || TextUtils.isEmpty(a2.f4944a))) {
                    intent2.setClassName(a2.f4945b, a2.f4944a);
                }
                intent = intent2;
            } else if (a.f4940b < 4 || a.f4940b > 6) {
                if (a.f4940b > 6) {
                    intent2 = new Intent("com.tencent.QQBrowser.action.VIEW");
                    a2 = C1091d.m7693a(context, parse);
                    if (!(a2 == null || TextUtils.isEmpty(a2.f4944a))) {
                        intent2.setClassName(a2.f4945b, a2.f4944a);
                    }
                    intent = intent2;
                }
                intent = intent2;
            } else {
                intent2.setClassName("com.tencent.qbx", "com.tencent.qbx.SplashActivity");
                intent = intent2;
            }
            intent.setData(parse);
            if (hashMap != null) {
                Set<String> keySet = hashMap.keySet();
                if (keySet != null) {
                    for (String str2 : keySet) {
                        String str3 = (String) hashMap.get(str2);
                        if (!TextUtils.isEmpty(str3)) {
                            intent.putExtra(str2, str3);
                        }
                    }
                }
            }
            try {
                intent.putExtra("loginType", C1091d.m7701d(context));
                intent.addFlags(268435456);
                context.startActivity(intent);
                return 0;
            } catch (ActivityNotFoundException e) {
                return 4;
            }
        } catch (Exception e2) {
            return 2;
        }
    }

    /* renamed from: b */
    public static boolean m7699b(Context context) {
        return C1091d.m7692a(context).f4939a != -1;
    }

    /* renamed from: c */
    public static boolean m7700c(Context context) {
        C1089a a = C1091d.m7692a(context);
        boolean z = false;
        try {
            if (Long.valueOf(a.f4942d).longValue() >= 6001500) {
                z = true;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return a.f4940b >= 601500 ? true : z;
    }

    /* renamed from: d */
    private static int m7701d(Context context) {
        String str = context.getApplicationInfo().processName;
        return str.equals(TbsConfig.APP_QQ) ? 13 : str.equals(TbsConfig.APP_QZONE) ? 14 : str.equals("com.tencent.WBlog") ? 15 : str.equals("com.tencent.mm") ? 24 : 26;
    }
}
