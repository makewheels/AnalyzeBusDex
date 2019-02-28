package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.alipay.sdk.cons.C0108a;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.utils.C1135b;
import com.tencent.smtt.utils.C1146j;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import p054u.aly.bi_常量类;

public class TbsShareManager {
    /* renamed from: a */
    private static Context f4869a;
    /* renamed from: b */
    private static boolean f4870b;
    /* renamed from: c */
    private static String f4871c = null;
    /* renamed from: d */
    private static int f4872d = 0;
    /* renamed from: e */
    private static String f4873e = null;
    /* renamed from: f */
    private static boolean f4874f = false;
    /* renamed from: g */
    private static boolean f4875g = false;
    /* renamed from: h */
    private static String f4876h = null;
    /* renamed from: i */
    private static boolean f4877i = false;

    /* renamed from: a */
    private static File m7627a(Context context, String str) {
        File g = ac.m7706a().m7748g(context);
        if (g == null) {
            return null;
        }
        File file = new File(g, str);
        if (file != null && file.exists()) {
            return file;
        }
        try {
            file.createNewFile();
            return file;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    static void m7628a(Context context) {
        try {
            TbsLinuxToolsJni tbsLinuxToolsJni = new TbsLinuxToolsJni(context);
            m7629a(context, tbsLinuxToolsJni, ac.m7706a().m7747f(context));
            tbsLinuxToolsJni.m7587a(ac.m7706a().m7748g(context).getAbsolutePath(), "755");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    private static void m7629a(Context context, TbsLinuxToolsJni tbsLinuxToolsJni, File file) {
        if (file != null && file.exists() && file.isDirectory()) {
            tbsLinuxToolsJni.m7587a(file.getAbsolutePath(), "755");
            for (File file2 : file.listFiles()) {
                if (file2.isFile()) {
                    if (file2.getAbsolutePath().indexOf(".so") > 0) {
                        tbsLinuxToolsJni.m7587a(file2.getAbsolutePath(), "755");
                    } else {
                        tbsLinuxToolsJni.m7587a(file2.getAbsolutePath(), "644");
                    }
                } else if (file2.isDirectory()) {
                    m7629a(context, tbsLinuxToolsJni, file2);
                } else {
                    TbsLog.m7926e("TbsShareManager", "unknown file type.", true);
                }
            }
        }
    }

    /* renamed from: a */
    private static void m7630a(Context context, boolean z) {
        FileInputStream fileInputStream;
        Throwable th;
        FileInputStream fileInputStream2 = null;
        try {
            File a = m7627a(context, "core_info");
            if (a == null) {
                try {
                    fileInputStream2.close();
                    return;
                } catch (Exception e) {
                    return;
                }
            }
            fileInputStream = new FileInputStream(a);
            try {
                Properties properties = new Properties();
                properties.load(fileInputStream);
                properties.setProperty("core_disabled", String.valueOf(false));
                if (z) {
                    String absolutePath = ac.m7706a().m7747f(context).getAbsolutePath();
                    String packageName = context.getApplicationContext().getPackageName();
                    int b = C1135b.m7951b(context);
                    properties.setProperty("core_packagename", packageName);
                    properties.setProperty("core_path", absolutePath);
                    properties.setProperty("app_version", String.valueOf(b));
                }
                properties.store(new FileOutputStream(a), null);
                fileInputStream.close();
            } catch (Throwable th2) {
                th = th2;
                try {
                    th.printStackTrace();
                    fileInputStream.close();
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        fileInputStream.close();
                    } catch (Exception e2) {
                    }
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
            fileInputStream.close();
            throw th;
        }
    }

    /* renamed from: b */
    private static Context m7631b(Context context, String str) {
        Context context2 = null;
        try {
            context2 = context.createPackageContext(str, 2);
        } catch (NameNotFoundException e) {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return context2;
    }

    /* renamed from: b */
    static String m7632b(Context context) {
        m7638h(context);
        return f4871c;
    }

    /* renamed from: c */
    static int m7633c(Context context) {
        m7638h(context);
        return f4872d;
    }

    /* renamed from: d */
    static Context m7634d(Context context) {
        m7638h(context);
        return f4873e == null ? null : m7631b(context, f4873e);
    }

    /* renamed from: e */
    static synchronized String m7635e(Context context) {
        Throwable th;
        Throwable th2;
        String str = null;
        synchronized (TbsShareManager.class) {
            FileInputStream fileInputStream = null;
            FileInputStream fileInputStream2;
            try {
                File a = m7627a(context, "core_info");
                if (a == null) {
                    if (null != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e) {
                        }
                    }
                } else {
                    fileInputStream2 = new FileInputStream(a);
                    try {
                        Properties properties = new Properties();
                        properties.load(fileInputStream2);
                        String property = properties.getProperty("core_packagename", bi_常量类.f6358b);
                        if (!bi_常量类.f6358b.equals(property)) {
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (Exception e2) {
                                }
                            }
                            str = property;
                        } else if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            th.printStackTrace();
                            if (fileInputStream2 != null) {
                                fileInputStream2.close();
                            }
                            return str;
                        } catch (Throwable th4) {
                            th2 = th4;
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (Exception e3) {
                                }
                            }
                            throw th2;
                        }
                    }
                }
            } catch (Throwable th5) {
                fileInputStream2 = null;
                th2 = th5;
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                throw th2;
            }
        }
        return str;
    }

    /* renamed from: f */
    static synchronized int m7636f(Context context) {
        Throwable th;
        int i = 0;
        synchronized (TbsShareManager.class) {
            FileInputStream fileInputStream = null;
            FileInputStream fileInputStream2;
            try {
                File a = m7627a(context, "core_info");
                if (a == null) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    fileInputStream2 = new FileInputStream(a);
                    try {
                        Properties properties = new Properties();
                        properties.load(fileInputStream2);
                        String property = properties.getProperty("core_version", bi_常量类.f6358b);
                        if (bi_常量类.f6358b.equals(property)) {
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                        } else {
                            i = Math.max(Integer.parseInt(property), 0);
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (Exception e22) {
                                    e22.printStackTrace();
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            th.printStackTrace();
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                }
                            }
                            i = -2;
                            return i;
                        } catch (Throwable th3) {
                            th = th3;
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (Exception e222) {
                                    e222.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                throw th;
            }
        }
        return i;
    }

    public static boolean forceLoadX5FromTBSDemo(Context context) {
        if (context == null) {
            return false;
        }
        int sharedTbsCoreVersion = getSharedTbsCoreVersion(context, TbsConfig.APP_DEMO);
        if (sharedTbsCoreVersion <= 0) {
            return false;
        }
        writeProperties(context, Integer.toString(sharedTbsCoreVersion), TbsConfig.APP_DEMO, ac.m7706a().m7747f(m7631b(context, TbsConfig.APP_DEMO)).getAbsolutePath(), C0108a.f262e);
        return true;
    }

    /* renamed from: g */
    static boolean m7637g(Context context) {
        try {
            if (f4872d == 0) {
                m7641k(context);
            }
            if (f4872d == 0) {
                return false;
            }
            if (f4872d != 0 && getSharedTbsCoreVersion(context, f4873e) == f4872d) {
                return true;
            }
            f4871c = null;
            f4872d = 0;
            TbsLog.m7925e("TbsShareManager", "isShareTbsCoreAvailableInner forceSysWebViewInner!");
            QbSdk.m7544a();
            QbSdk.f4786e.onCallBackErrorCode(ErrorCode.ERROR_COREVERSION_CHANGED, ErrorCode.INFO_ERROR_COREVERSION_CHANGED);
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static String[] getCoreProviderAppList() {
        return new String[]{"com.tencent.mm", TbsConfig.APP_QQ, TbsConfig.APP_QB, TbsConfig.APP_QZONE, "com.tencent.qqpimsecure", TbsConfig.APP_DEMO, TbsConfig.APP_DEMO_TEST};
    }

    public static int getSharedTbsCoreVersion(Context context, String str) {
        Context b = m7631b(context, str);
        return b == null ? 0 : ac.m7706a().m7744c(b);
    }

    /* renamed from: h */
    static boolean m7638h(Context context) {
        if (m7637g(context)) {
            return true;
        }
        TbsLog.m7925e("TbsShareManager", "isShareTbsCoreAvailable forceSysWebViewInner!");
        QbSdk.m7544a();
        return false;
    }

    /* renamed from: i */
    private static boolean m7639i(Context context) {
        return f4873e != null && f4872d == getSharedTbsCoreVersion(context, f4873e);
    }

    public static boolean isThirdPartyApp(Context context) {
        try {
            if (f4869a != null && f4869a.equals(context.getApplicationContext())) {
                return f4870b;
            }
            f4869a = context.getApplicationContext();
            String packageName = f4869a.getPackageName();
            for (Object equals : getCoreProviderAppList()) {
                if (packageName.equals(equals)) {
                    f4870b = false;
                    return false;
                }
            }
            f4870b = true;
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: j */
    private static boolean m7640j(Context context) {
        String[] coreProviderAppList = getCoreProviderAppList();
        int length = coreProviderAppList.length;
        int i = 0;
        while (i < length) {
            String str = coreProviderAppList[i];
            if (f4872d <= 0 || f4872d != getSharedTbsCoreVersion(context, str)) {
                i++;
            } else {
                f4871c = ac.m7706a().m7740b(context, m7631b(context, str)).getAbsolutePath();
                f4873e = str;
                return true;
            }
        }
        return false;
    }

    /* renamed from: k */
    private static int m7641k(Context context) {
        m7643m(context);
        TbsLog.m7927i("TbsShareManager", "core_info mAvailableCoreVersion is " + f4872d + " mAvailableCorePath is " + f4871c + " mSrcPackageName is " + f4873e);
        if (!(m7639i(context) || m7640j(context))) {
            f4872d = 0;
            f4871c = null;
            f4873e = null;
            TbsLog.m7927i("TbsShareManager", "core_info error checkCoreInfo is false and checkCoreInOthers is false ");
            QbSdk.f4786e.onCallBackErrorCode(1003, ErrorCode.INFO_ERROR_NOMATCH_COREVERSION);
        }
        if (f4872d > 0 && (QbSdk.m7546a(context, f4872d) || f4874f)) {
            f4872d = 0;
            f4871c = null;
            f4873e = null;
            TbsLog.m7927i("TbsShareManager", "core_info error QbSdk.isX5Disabled ");
        }
        return f4872d;
    }

    /* renamed from: l */
    private static boolean m7642l(Context context) {
        writeProperties(context, Integer.toString(0), bi_常量类.f6358b, bi_常量类.f6358b, Integer.toString(0));
        return true;
    }

    /* renamed from: m */
    private static synchronized void m7643m(Context context) {
        FileInputStream fileInputStream;
        Throwable th;
        synchronized (TbsShareManager.class) {
            if (!f4877i) {
                FileInputStream fileInputStream2 = null;
                try {
                    File a = m7627a(context, "core_info");
                    if (a != null) {
                        fileInputStream = new FileInputStream(a);
                        try {
                            Properties properties = new Properties();
                            properties.load(fileInputStream);
                            String property = properties.getProperty("core_version", bi_常量类.f6358b);
                            if (!bi_常量类.f6358b.equals(property)) {
                                f4872d = Math.max(Integer.parseInt(property), 0);
                            }
                            property = properties.getProperty("core_packagename", bi_常量类.f6358b);
                            if (!bi_常量类.f6358b.equals(property)) {
                                f4873e = property;
                            }
                            property = properties.getProperty("core_path", bi_常量类.f6358b);
                            if (!bi_常量类.f6358b.equals(property)) {
                                f4871c = property;
                            }
                            property = properties.getProperty("app_version", bi_常量类.f6358b);
                            if (!bi_常量类.f6358b.equals(property)) {
                                f4876h = property;
                            }
                            f4874f = Boolean.parseBoolean(properties.getProperty("core_disabled", "false"));
                            f4877i = true;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                th.printStackTrace();
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Exception e2) {
                                        e2.printStackTrace();
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Exception e3) {
                                        e3.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        }
                    } else if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Exception e22) {
                            e22.printStackTrace();
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
            }
        }
    }

    public static void writeCoreInfoForThirdPartyApp(Context context, int i, boolean z) {
        int i2 = 0;
        if (i == 0) {
            m7642l(context);
            return;
        }
        int f = m7636f(context);
        if (f < 0) {
            return;
        }
        if (i == f) {
            m7630a(context, z);
        } else if (i < f) {
            m7642l(context);
        } else {
            String[] coreProviderAppList = getCoreProviderAppList();
            if (z) {
                coreProviderAppList = new String[]{context.getApplicationContext().getPackageName()};
            }
            int length = coreProviderAppList.length;
            while (i2 < length) {
                String str = coreProviderAppList[i2];
                if (i == getSharedTbsCoreVersion(context, str)) {
                    String absolutePath = ac.m7706a().m7747f(m7631b(context, str)).getAbsolutePath();
                    length = C1135b.m7951b(context);
                    if (!str.equals(context.getApplicationContext().getPackageName())) {
                        TbsLog.m7927i(TbsDownloader.LOGTAG, "thirdAPP pre--> delete old core_share Directory:" + i);
                        try {
                            C1146j.m7988b(ac.m7706a().m7747f(context));
                            TbsLog.m7927i(TbsDownloader.LOGTAG, "thirdAPP success--> delete old core_share Directory");
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                    writeProperties(context, Integer.toString(i), str, absolutePath, Integer.toString(length));
                    try {
                        File a = m7627a(context, "core_info");
                        if (!f4875g && a != null) {
                            TbsLinuxToolsJni tbsLinuxToolsJni = new TbsLinuxToolsJni(f4869a);
                            tbsLinuxToolsJni.m7587a(a.getAbsolutePath(), "644");
                            tbsLinuxToolsJni.m7587a(ac.m7706a().m7748g(context).getAbsolutePath(), "755");
                            f4875g = true;
                            return;
                        }
                        return;
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                        return;
                    }
                }
                i2++;
            }
        }
    }

    public static void writeProperties(Context context, String str, String str2, String str3, String str4) {
        Exception e;
        Throwable th;
        int i = 0;
        FileInputStream fileInputStream = null;
        try {
            File a = m7627a(context, "core_info");
            if (a == null) {
                try {
                    fileInputStream.close();
                } catch (Exception e2) {
                    e = e2;
                }
            } else {
                fileInputStream = new FileInputStream(a);
                try {
                    Properties properties = new Properties();
                    properties.load(fileInputStream);
                    try {
                        i = Integer.parseInt(str);
                    } catch (Exception e3) {
                    }
                    if (i != 0) {
                        properties.setProperty("core_version", str);
                        properties.setProperty("core_disabled", String.valueOf(false));
                        properties.setProperty("core_packagename", str2);
                        properties.setProperty("core_path", str3);
                        properties.setProperty("app_version", str4);
                    } else {
                        properties.setProperty("core_disabled", String.valueOf(true));
                    }
                    properties.store(new FileOutputStream(a), null);
                    f4877i = false;
                    try {
                        fileInputStream.close();
                    } catch (Exception e4) {
                        e = e4;
                        e.printStackTrace();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        th.printStackTrace();
                        try {
                            fileInputStream.close();
                        } catch (Exception e5) {
                            e = e5;
                            e.printStackTrace();
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            fileInputStream.close();
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                        throw th;
                    }
                }
            }
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
            fileInputStream.close();
            throw th;
        }
    }
}
