package com.tencent.smtt.sdk.p052b;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.smtt.sdk.TbsShareManager;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.utils.C1135b;
import com.tencent.smtt.utils.C1159w;
import com.umeng.analytics.C1233a;
import java.util.List;
import p054u.aly.bi_常量类;

/* renamed from: com.tencent.smtt.sdk.b.d */
public class C1102d {
    /* renamed from: a */
    private static boolean f5017a = true;
    /* renamed from: b */
    private static long f5018b = 0;
    /* renamed from: c */
    private static long f5019c = -1;
    /* renamed from: d */
    private static DownloadManager f5020d = null;

    /* renamed from: com.tencent.smtt.sdk.b.d$a */
    private static class C1100a {
        /* renamed from: a */
        public int f5012a;
        /* renamed from: b */
        public int f5013b;
        /* renamed from: c */
        public String f5014c;

        private C1100a() {
            this.f5012a = -1;
            this.f5013b = -1;
            this.f5014c = bi_常量类.f6358b;
        }
    }

    /* renamed from: com.tencent.smtt.sdk.b.d$b */
    private static class C1101b {
        /* renamed from: a */
        public String f5015a;
        /* renamed from: b */
        public String f5016b;

        private C1101b() {
            this.f5015a = bi_常量类.f6358b;
            this.f5016b = bi_常量类.f6358b;
        }
    }

    /* renamed from: a */
    private static C1100a m7829a(Context context) {
        PackageInfo packageInfo = null;
        C1100a c1100a = new C1100a();
        try {
            PackageManager packageManager = context.getPackageManager();
            try {
                packageInfo = packageManager.getPackageInfo(TbsConfig.APP_QB, 0);
                c1100a.f5012a = 2;
                c1100a.f5014c = "ADRQB_";
                if (packageInfo != null && packageInfo.versionCode > 420000) {
                    c1100a.f5013b = packageInfo.versionCode;
                    c1100a.f5014c += packageInfo.versionName.replaceAll("\\.", bi_常量类.f6358b);
                    return c1100a;
                }
            } catch (NameNotFoundException e) {
            }
            try {
                packageInfo = packageManager.getPackageInfo("com.tencent.qbx", 0);
                c1100a.f5012a = 0;
                c1100a.f5014c = "ADRQBX_";
            } catch (NameNotFoundException e2) {
                try {
                    packageInfo = packageManager.getPackageInfo("com.tencent.qbx5", 0);
                    c1100a.f5012a = 1;
                    c1100a.f5014c = "ADRQBX5_";
                } catch (NameNotFoundException e3) {
                    try {
                        packageInfo = packageManager.getPackageInfo(TbsConfig.APP_QB, 0);
                        c1100a.f5012a = 2;
                        c1100a.f5014c = "ADRQB_";
                    } catch (NameNotFoundException e4) {
                        try {
                            packageInfo = packageManager.getPackageInfo("com.tencent.mtt.x86", 0);
                            c1100a.f5012a = 2;
                            c1100a.f5014c = "ADRQB_";
                        } catch (Exception e5) {
                            try {
                                C1101b a = C1102d.m7830a(context, Uri.parse("http://mdc.html5.qq.com/mh?channel_id=21094&u="));
                                if (!(a == null || a.f5016b == null || a.f5016b.length() == 0)) {
                                    packageInfo = packageManager.getPackageInfo(a.f5016b, 0);
                                    c1100a.f5012a = 2;
                                    c1100a.f5014c = "ADRQB_";
                                }
                            } catch (Exception e6) {
                            }
                        }
                    }
                }
            }
            if (packageInfo != null) {
                c1100a.f5013b = packageInfo.versionCode;
                c1100a.f5014c += packageInfo.versionName.replaceAll("\\.", bi_常量类.f6358b);
            }
        } catch (Exception e7) {
        }
        return c1100a;
    }

    /* renamed from: a */
    private static C1101b m7830a(Context context, Uri uri) {
        Intent intent = new Intent("com.tencent.QQBrowser.action.VIEW");
        intent.setData(uri);
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities.size() <= 0) {
            return null;
        }
        C1101b c1101b = new C1101b();
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            String str = resolveInfo.activityInfo.packageName;
            if (str.contains(TbsConfig.APP_QB)) {
                c1101b.f5015a = resolveInfo.activityInfo.name;
                c1101b.f5016b = resolveInfo.activityInfo.packageName;
                return c1101b;
            } else if (str.contains("com.tencent.qbx")) {
                c1101b.f5015a = resolveInfo.activityInfo.name;
                c1101b.f5016b = resolveInfo.activityInfo.packageName;
            }
        }
        return c1101b;
    }

    /* renamed from: a */
    public static void m7831a(WebView webView) {
        String c;
        Throwable th;
        if (f5017a) {
            Context context;
            long j;
            long currentTimeMillis;
            C1098c c1098c;
            String d;
            try {
                context = webView.getContext();
                try {
                    if (TbsShareManager.isThirdPartyApp(context)) {
                        C1097b.m7824a(context);
                        j = C1096a.m7819b() ? 600000 : C1233a.f5598n;
                        currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - f5018b < j || f5018b == 0) {
                            f5018b = currentTimeMillis;
                            try {
                                c1098c = new C1098c();
                                c = C1135b.m7952c(context);
                                d = C1135b.m7953d(context);
                                if (c != null || bi_常量类.f6358b.equals(c)) {
                                    c1098c.m7827a("imei", "-1");
                                } else {
                                    c1098c.m7827a("imei", c);
                                }
                                if (d != null || bi_常量类.f6358b.equals(d)) {
                                    c1098c.m7827a("imsi", "-1");
                                } else {
                                    c1098c.m7827a("imsi", d);
                                }
                                c1098c.m7827a("paK", context.getPackageName());
                                c1098c.m7827a("from", "-1");
                                c1098c.m7827a("qb_ver", C1102d.m7829a(context).f5013b + bi_常量类.f6358b);
                                c1098c.m7827a("mode", C1096a.m7818a(C1096a.m7816a()));
                                c1098c.m7827a("url", webView.getUrl());
                                d = "x5insertadnode";
                                webView.loadUrl("javascript:var insertJsNode=document.getElementById(\"" + d + "\");if(null==insertJsNode){insertJsNode=document.createElement('script');insertJsNode.setAttribute('id',\"" + d + "\");insertJsNode.setAttribute('charset','" + "gbk" + "');insertJsNode.setAttribute('src',\"" + c1098c.m7828a(C1159w.m8057a(context).m8064f()) + "\");document.body.appendChild(insertJsNode);}");
                            } catch (Throwable th2) {
                                th2.printStackTrace();
                            }
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    th.printStackTrace();
                    if (C1096a.m7819b()) {
                    }
                    currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - f5018b < j) {
                    }
                    f5018b = currentTimeMillis;
                    c1098c = new C1098c();
                    c = C1135b.m7952c(context);
                    d = C1135b.m7953d(context);
                    if (c != null) {
                    }
                    c1098c.m7827a("imei", "-1");
                    if (d != null) {
                    }
                    c1098c.m7827a("imsi", "-1");
                    c1098c.m7827a("paK", context.getPackageName());
                    c1098c.m7827a("from", "-1");
                    c1098c.m7827a("qb_ver", C1102d.m7829a(context).f5013b + bi_常量类.f6358b);
                    c1098c.m7827a("mode", C1096a.m7818a(C1096a.m7816a()));
                    c1098c.m7827a("url", webView.getUrl());
                    d = "x5insertadnode";
                    webView.loadUrl("javascript:var insertJsNode=document.getElementById(\"" + d + "\");if(null==insertJsNode){insertJsNode=document.createElement('script');insertJsNode.setAttribute('id',\"" + d + "\");insertJsNode.setAttribute('charset','" + "gbk" + "');insertJsNode.setAttribute('src',\"" + c1098c.m7828a(C1159w.m8057a(context).m8064f()) + "\");document.body.appendChild(insertJsNode);}");
                }
            } catch (Throwable th22) {
                Throwable th4 = th22;
                context = null;
                th = th4;
                th.printStackTrace();
                if (C1096a.m7819b()) {
                }
                currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - f5018b < j) {
                }
                f5018b = currentTimeMillis;
                c1098c = new C1098c();
                c = C1135b.m7952c(context);
                d = C1135b.m7953d(context);
                if (c != null) {
                }
                c1098c.m7827a("imei", "-1");
                if (d != null) {
                }
                c1098c.m7827a("imsi", "-1");
                c1098c.m7827a("paK", context.getPackageName());
                c1098c.m7827a("from", "-1");
                c1098c.m7827a("qb_ver", C1102d.m7829a(context).f5013b + bi_常量类.f6358b);
                c1098c.m7827a("mode", C1096a.m7818a(C1096a.m7816a()));
                c1098c.m7827a("url", webView.getUrl());
                d = "x5insertadnode";
                webView.loadUrl("javascript:var insertJsNode=document.getElementById(\"" + d + "\");if(null==insertJsNode){insertJsNode=document.createElement('script');insertJsNode.setAttribute('id',\"" + d + "\");insertJsNode.setAttribute('charset','" + "gbk" + "');insertJsNode.setAttribute('src',\"" + c1098c.m7828a(C1159w.m8057a(context).m8064f()) + "\");document.body.appendChild(insertJsNode);}");
            }
        }
    }
}
