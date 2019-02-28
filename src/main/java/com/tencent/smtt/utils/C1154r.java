package com.tencent.smtt.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.smtt.sdk.p051a.C1091d;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import p054u.aly.bi_常量类;

/* renamed from: com.tencent.smtt.utils.r */
public class C1154r {
    /* renamed from: a */
    private static C1154r f5157a = null;
    /* renamed from: b */
    private Handler f5158b;

    private C1154r() {
        this.f5158b = null;
        this.f5158b = new C1155s(this, Looper.getMainLooper());
    }

    /* renamed from: a */
    private int m8021a(Context context) {
        return m8034a(TbsConfig.APP_QB, context, 128) != null ? 2 : !TextUtils.isEmpty(m8032e(context)) ? 1 : 0;
    }

    /* renamed from: a */
    public static C1154r m8022a() {
        if (f5157a == null) {
            f5157a = new C1154r();
        }
        return f5157a;
    }

    /* renamed from: a */
    private Map<String, String> m8023a(String str) {
        Throwable th;
        if (str == null || str.length() <= 0) {
            return null;
        }
        Map<String, String> hashMap;
        try {
            hashMap = new HashMap();
            try {
                for (String str2 : str.split("\n")) {
                    if (str2 != null && str2.length() > 0) {
                        String[] split = str2.trim().split("=", 2);
                        if (split != null && split.length >= 2) {
                            String str3 = split[0];
                            Object obj = split[1];
                            if (str3 != null && str3.length() > 0) {
                                hashMap.put(str3, obj);
                            }
                        }
                    }
                }
                return hashMap;
            } catch (Throwable th2) {
                th = th2;
                th.printStackTrace();
                return hashMap;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            hashMap = null;
            th = th4;
            th.printStackTrace();
            return hashMap;
        }
    }

    /* renamed from: b */
    private void m8026b(Context context) {
        Object obj = new Object[]{context};
        Message message = new Message();
        message.what = 1;
        message.obj = obj;
        this.f5158b.sendMessage(message);
    }

    /* renamed from: b */
    public static void m8027b(Context context, String str) {
        if (context != null && str != null && str.length() > 0) {
            C1091d.m7698b(context, str, null);
        }
    }

    /* renamed from: c */
    private void m8028c(Context context) {
        try {
            Object e = m8032e(context);
            if (!TextUtils.isEmpty(e)) {
                File file = new File(e);
                if (file.exists()) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.addFlags(268435456);
                    intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
                    context.startActivity(intent);
                    C1156t.m8036a(context).m8039a(context.getApplicationInfo().processName);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: c */
    private void m8029c(Context context, String str) {
        Object obj = new Object[]{context, str};
        Message message = new Message();
        message.what = 0;
        message.obj = obj;
        this.f5158b.sendMessage(message);
    }

    /* renamed from: d */
    private Map<String, String> m8030d(Context context) {
        FileInputStream fileInputStream;
        Throwable th;
        IOException e;
        Throwable th2;
        FileInputStream fileInputStream2 = null;
        String str = bi_常量类.f6358b;
        try {
            String str2 = "/data/data/com.tencent.mobileqq/app_tbs/share/QQBrowserDownloadInfo.ini";
            String str3 = "/data/data/com.qzone/app_tbs/share/QQBrowserDownloadInfo.ini";
            File file = new File("/data/data/com.tencent.mm/app_tbs/share/QQBrowserDownloadInfo.ini");
            if (file == null || !file.exists()) {
                file = new File(str2);
            }
            if (file == null || !file.exists()) {
                file = new File(str3);
            }
            if (file == null || !file.exists()) {
                fileInputStream = null;
            } else {
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] b = C1146j.m7993b((InputStream) fileInputStream);
                    if (b != null) {
                        str = new String(b, "utf-8");
                    }
                } catch (Throwable th3) {
                    th2 = th3;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    throw th2;
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e2) {
                    e = e2;
                    e.printStackTrace();
                    return m8023a(str);
                }
            }
        } catch (Throwable th4) {
            th = th4;
            th.printStackTrace();
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            return m8023a(str);
        }
        return m8023a(str);
    }

    /* renamed from: d */
    private void m8031d(Context context, String str) {
        Object obj = new Object[]{context, str};
        Message message = new Message();
        message.what = 2;
        message.obj = obj;
        this.f5158b.sendMessage(message);
    }

    /* renamed from: e */
    private String m8032e(Context context) {
        Map d = m8030d(context);
        if (d != null && d.size() > 0) {
            String str = (String) d.get("FileDownloadPath");
            String str2 = (String) d.get("FileDownloadVerifyInfo");
            if (TextUtils.isEmpty(str)) {
                return bi_常量类.f6358b;
            }
            if (TextUtils.isEmpty(str2)) {
                return bi_常量类.f6358b;
            }
            File file = new File(str);
            if (!file.exists()) {
                return bi_常量类.f6358b;
            }
            if (TextUtils.equals(C1150n.m8007a(file.lastModified() + bi_常量类.f6358b), str2)) {
                return str;
            }
        }
        return bi_常量类.f6358b;
    }

    /* renamed from: e */
    private void m8033e(Context context, String str) {
        if (context != null && str != null && str.length() > 0) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    /* renamed from: a */
    public PackageInfo m8034a(String str, Context context, int i) {
        PackageInfo packageInfo = null;
        if (!(context == null || TextUtils.isEmpty(str))) {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str, i);
            } catch (Throwable th) {
            }
        }
        return packageInfo;
    }

    /* renamed from: a */
    public boolean m8035a(Context context, String str) {
        String str2 = null;
        if (str != null) {
            try {
                if (str.startsWith("tbsqbdownload://")) {
                    String substring;
                    String[] split = str.substring("tbsqbdownload://".length()).split(",");
                    if (split.length > 1) {
                        String[] split2 = split[0].split("=");
                        substring = (split2.length <= 1 || !"url".equalsIgnoreCase(split2[0])) ? null : split[0].substring("url".length() + 1);
                        String[] split3 = split[1].split("=");
                        if (split3.length > 1 && "downloadurl".equalsIgnoreCase(split3[0])) {
                            str2 = split[1].substring("downloadurl".length() + 1);
                        }
                    } else {
                        substring = null;
                    }
                    if (substring == null || str2 == null) {
                        return false;
                    }
                    int a = m8021a(context);
                    if (a == 2) {
                        m8029c(context, substring);
                        return true;
                    } else if (a == 1) {
                        m8026b(context);
                        return true;
                    } else if (a != 0) {
                        return true;
                    } else {
                        m8031d(context, str2);
                        return true;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
