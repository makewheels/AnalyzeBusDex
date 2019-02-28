package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.utils.C1135b;
import com.tencent.smtt.utils.C1146j;
import com.tencent.smtt.utils.C1149m;
import com.tencent.smtt.utils.C1159w;
import com.tencent.smtt.utils.TbsLog;
import com.umeng.analytics.C1233a;
import java.io.File;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
import p054u.aly.bi_常量类;

public class TbsDownloader {
    public static final boolean DEBUG_DISABLE_DOWNLOAD = false;
    public static boolean DOWNLOAD_OVERSEA_TBS = false;
    public static final String LOGTAG = "TbsDownload";
    /* renamed from: a */
    static boolean f4828a;
    /* renamed from: b */
    private static String f4829b;
    /* renamed from: c */
    private static Context f4830c;
    /* renamed from: d */
    private static Handler f4831d;
    /* renamed from: e */
    private static String f4832e;
    /* renamed from: f */
    private static C1129w f4833f;
    /* renamed from: g */
    private static HandlerThread f4834g;
    /* renamed from: h */
    private static boolean f4835h = false;
    /* renamed from: i */
    private static boolean f4836i = false;
    /* renamed from: j */
    private static boolean f4837j = false;

    /* renamed from: a */
    static String m7575a(Context context) {
        if (!TextUtils.isEmpty(f4829b)) {
            return f4829b;
        }
        String str;
        Locale locale = Locale.getDefault();
        StringBuffer stringBuffer = new StringBuffer();
        String str2 = VERSION.RELEASE;
        try {
            str = new String(str2.getBytes("UTF-8"), "ISO8859-1");
        } catch (Exception e) {
            str = str2;
        }
        if (str.length() > 0) {
            stringBuffer.append(str);
        } else {
            stringBuffer.append("1.0");
        }
        stringBuffer.append("; ");
        str = locale.getLanguage();
        if (str != null) {
            stringBuffer.append(str.toLowerCase());
            str = locale.getCountry();
            if (str != null) {
                stringBuffer.append("-");
                stringBuffer.append(str.toLowerCase());
            }
        } else {
            stringBuffer.append("en");
        }
        if ("REL".equals(VERSION.CODENAME)) {
            str2 = Build.MODEL;
            try {
                str = new String(str2.getBytes("UTF-8"), "ISO8859-1");
            } catch (Exception e2) {
                str = str2;
            }
            if (str.length() > 0) {
                stringBuffer.append("; ");
                stringBuffer.append(str);
            }
        }
        str = Build.ID.replaceAll("[一-龥]", bi_常量类.f6358b_空串);
        if (str.length() > 0) {
            stringBuffer.append(" Build/");
            stringBuffer.append(str);
        }
        str = String.format("Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko)Version/4.0 Mobile Safari/533.1", new Object[]{stringBuffer});
        f4829b = str;
        return str;
    }

    /* renamed from: a */
    private static String m7576a(String str) {
        return str == null ? bi_常量类.f6358b_空串 : str;
    }

    @TargetApi(11)
    /* renamed from: a */
    private static boolean m7577a(String str, int i) {
        TbsLog.m7927i(LOGTAG, "[TbsDownloader.readResponse] response=" + str);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.getInt("RET") != 0) {
            return false;
        }
        int i2;
        TbsDownloadConfig a = TbsDownloadConfig.m7565a(f4830c);
        int i3 = jSONObject.getInt("RESPONSECODE");
        Object string = jSONObject.getString("DOWNLOADURL");
        int i4 = jSONObject.getInt("TBSAPKSERVERVERSION");
        int i5 = jSONObject.getInt("DOWNLOADMAXFLOW");
        int i6 = jSONObject.getInt("DOWNLOAD_MIN_FREE_SPACE");
        int i7 = jSONObject.getInt("DOWNLOAD_SUCCESS_MAX_RETRYTIMES");
        int i8 = jSONObject.getInt("DOWNLOAD_FAILED_MAX_RETRYTIMES");
        long j = jSONObject.getLong("DOWNLOAD_SINGLE_TIMEOUT");
        long j2 = jSONObject.getLong("TBSAPKFILESIZE");
        long optLong = jSONObject.optLong("RETRY_INTERVAL");
        String str2 = null;
        int i9 = 0;
        int i10 = 0;
        try {
            str2 = jSONObject.getString("PKGMD5");
            i9 = jSONObject.getInt("RESETX5");
            Object obj = str2;
            i2 = i9;
            i9 = jSONObject.getInt("UPLOADLOG");
        } catch (Exception e) {
            int i11 = i10;
            String str3 = str2;
            i2 = i9;
            i9 = i11;
        }
        if (i2 == 1) {
            QbSdk.reset(f4830c);
            return false;
        }
        if (i9 == 1) {
            f4831d.removeMessages(ErrorCode.WRITE_DISK_ERROR);
            Message.obtain(f4831d, ErrorCode.WRITE_DISK_ERROR).sendToTarget();
        }
        if (TextUtils.isEmpty(string) && TbsShareManager.isThirdPartyApp(f4830c)) {
            a.f4826a.put(TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.valueOf(false));
            a.m7572g();
            TbsShareManager.writeCoreInfoForThirdPartyApp(f4830c, i4, false);
            return false;
        } else if (i3 == 0) {
            a.f4826a.put(TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.valueOf(false));
            a.m7572g();
            return false;
        } else {
            i2 = TbsDownloadConfig.m7565a(f4830c).f4827b.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
            i9 = (VERSION.SDK_INT >= 11 ? f4830c.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : f4830c.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0)).getInt("tbs_precheck_disable_version", -1);
            if (i9 == i4 || i >= i4 || i2 > i4 || TextUtils.isEmpty(string)) {
                if (i9 == i4) {
                    TbsLog.m7925e(LOGTAG, "Download is disabled by preload_x5_check; tbs_version:" + i4);
                }
                a.f4826a.put(TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.valueOf(false));
                a.m7572g();
                return false;
            }
            if (!string.equals(a.f4827b.getString(TbsConfigKey.KEY_TBSDOWNLOADURL, null))) {
                f4833f.m7903f();
                a.f4826a.put(TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, Integer.valueOf(0));
                a.f4826a.put(TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, Integer.valueOf(0));
            }
            a.f4826a.put(TbsConfigKey.KEY_TBS_DOWNLOAD_V, Integer.valueOf(i4));
            a.f4826a.put(TbsConfigKey.KEY_TBSDOWNLOADURL, string);
            a.f4826a.put(TbsConfigKey.KEY_RESPONSECODE, Integer.valueOf(i3));
            a.f4826a.put(TbsConfigKey.KEY_DOWNLOAD_MAXFLOW, Integer.valueOf(i5));
            a.f4826a.put(TbsConfigKey.KEY_DOWNLOAD_MIN_FREE_SPACE, Integer.valueOf(i6));
            a.f4826a.put(TbsConfigKey.KEY_DOWNLOAD_SUCCESS_MAX_RETRYTIMES, Integer.valueOf(i7));
            a.f4826a.put(TbsConfigKey.KEY_DOWNLOAD_FAILED_MAX_RETRYTIMES, Integer.valueOf(i8));
            a.f4826a.put(TbsConfigKey.KEY_DOWNLOAD_SINGLE_TIMEOUT, Long.valueOf(j));
            a.f4826a.put(TbsConfigKey.KEY_TBSAPKFILESIZE, Long.valueOf(j2));
            a.f4826a.put(TbsConfigKey.KEY_RETRY_INTERVAL, Long.valueOf(optLong));
            if (obj != null) {
                a.f4826a.put(TbsConfigKey.KEY_TBSAPK_MD5, obj);
            }
            if (ac.m7706a().m7738a(f4830c, i4)) {
                a.f4826a.put(TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.valueOf(false));
            } else {
                a.f4826a.put(TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.valueOf(true));
            }
            a.m7572g();
            return true;
        }
    }

    /* renamed from: b */
    private static JSONObject m7580b(boolean z) {
        TbsDownloadConfig a = TbsDownloadConfig.m7565a(f4830c);
        String a2 = m7575a(f4830c);
        String d = C1135b.m7953d(f4830c);
        String c = C1135b.m7952c(f4830c);
        String f = C1135b.m7955f(f4830c);
        JSONObject jSONObject = new JSONObject();
        try {
            int c2;
            jSONObject.put("PROTOCOLVERSION", 1);
            if (TbsShareManager.isThirdPartyApp(f4830c)) {
                c2 = TbsShareManager.m7633c(f4830c);
            } else {
                int e = ac.m7706a().m7746e(f4830c);
                c2 = (!z && e == 0 && ac.m7706a().m7745d(f4830c)) ? -1 : e;
            }
            if (z) {
                jSONObject.put("FUNCTION", 2);
            } else {
                jSONObject.put("FUNCTION", c2 == 0 ? 0 : 1);
            }
            if (TbsShareManager.isThirdPartyApp(f4830c)) {
                Object obj;
                JSONArray jSONArray = new JSONArray();
                Object coreProviderAppList = TbsShareManager.getCoreProviderAppList();
                String packageName = f4830c.getApplicationContext().getPackageName();
                Object obj2;
                if (packageName.equals(TbsShareManager.m7635e(f4830c))) {
                    int length = coreProviderAppList.length;
                    obj = new String[(length + 1)];
                    System.arraycopy(coreProviderAppList, 0, obj, 0, length);
                    obj[length] = packageName;
                    obj2 = obj;
                } else {
                    obj2 = coreProviderAppList;
                }
                for (String sharedTbsCoreVersion : r3) {
                    int sharedTbsCoreVersion2 = TbsShareManager.getSharedTbsCoreVersion(f4830c, sharedTbsCoreVersion);
                    if (sharedTbsCoreVersion2 > 0) {
                        obj = null;
                        for (int i = 0; i < jSONArray.length(); i++) {
                            if (jSONArray.optInt(i) == sharedTbsCoreVersion2) {
                                obj = 1;
                                break;
                            }
                        }
                        if (obj == null) {
                            jSONArray.put(sharedTbsCoreVersion2);
                        }
                    }
                }
                jSONObject.put("TBSVLARR", jSONArray);
                if (QbSdk.f4784c) {
                    jSONObject.put("THIRDREQ", 1);
                }
            }
            jSONObject.put("APPN", f4830c.getPackageName());
            jSONObject.put("APPVN", m7576a(a.f4827b.getString(TbsConfigKey.KEY_APP_VERSIONNAME, null)));
            jSONObject.put("APPVC", a.f4827b.getInt(TbsConfigKey.KEY_APP_VERSIONCODE, 0));
            jSONObject.put("APPMETA", m7576a(a.f4827b.getString(TbsConfigKey.KEY_APP_METADATA, null)));
            jSONObject.put("TBSSDKV", 36509);
            jSONObject.put("TBSV", c2);
            if (c2 != 0) {
                jSONObject.put("TBSBACKUPV", f4833f.m7901d());
            }
            jSONObject.put("CPU", f4832e);
            jSONObject.put("UA", a2);
            jSONObject.put("IMSI", m7576a(d));
            jSONObject.put("IMEI", m7576a(c));
            jSONObject.put("ANDROID_ID", m7576a(f));
            if (!TbsShareManager.isThirdPartyApp(f4830c)) {
                jSONObject.put("STATUS", QbSdk.m7546a(f4830c, c2) ? 0 : 1);
            }
            if (getOverSea(f4830c)) {
                jSONObject.put("OVERSEA", 1);
            }
            if (QbSdk.mTbsDebugInstallOnline) {
                jSONObject.put("TBSDEBUG", 1);
            }
        } catch (Exception e2) {
        }
        TbsLog.m7927i(LOGTAG, "[TbsDownloader.postJsonData] jsonData=" + jSONObject.toString());
        return jSONObject;
    }

    @TargetApi(11)
    /* renamed from: b */
    static void m7581b(Context context) {
        TbsDownloadConfig.m7565a(context).m7573h();
        TbsLogReport.m7589a(context).m7616d();
        C1129w.m7884b(context);
        (VERSION.SDK_INT >= 11 ? context.getSharedPreferences("tbs_extension_config", 4) : context.getSharedPreferences("tbs_extension_config", 0)).edit().clear().commit();
        (VERSION.SDK_INT >= 11 ? context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0)).edit().clear().commit();
    }

    /* renamed from: c */
    private static synchronized void m7582c() {
        synchronized (TbsDownloader.class) {
            if (f4834g == null) {
                f4834g = ab.m7705a();
                try {
                    f4833f = new C1129w(f4830c);
                    f4831d = new C1132z(f4834g.getLooper());
                } catch (Exception e) {
                    f4835h = true;
                    TbsLog.m7925e(LOGTAG, "TbsApkDownloader init has Exception");
                }
            }
        }
    }

    /* renamed from: c */
    private static boolean m7583c(boolean z) {
        TbsLog.m7927i(LOGTAG, "[TbsDownloader.sendRequest]");
        if (ac.m7706a().m7743b(f4830c)) {
            TbsLog.m7927i(LOGTAG, "[TbsDownloader.sendRequest] -- isTbsLocalInstalled!");
            return false;
        }
        int i;
        boolean a;
        TbsDownloadConfig a2 = TbsDownloadConfig.m7565a(f4830c);
        File file = new File(C1146j.m7976a(f4830c, 1), getOverSea(f4830c) ? "x5.oversea.tbs.org" : "x5.tbs.org");
        File file2 = new File(C1146j.m7976a(f4830c, 2), getOverSea(f4830c) ? "x5.oversea.tbs.org" : "x5.tbs.org");
        File file3 = new File(C1146j.m7976a(f4830c, 3), getOverSea(f4830c) ? "x5.oversea.tbs.org" : "x5.tbs.org");
        if (!file3.exists()) {
            if (file2.exists()) {
                file2.renameTo(file3);
            } else if (file.exists()) {
                file.renameTo(file3);
            }
        }
        a2.f4826a.put(TbsConfigKey.KEY_LAST_CHECK, Long.valueOf(System.currentTimeMillis()));
        a2.f4826a.put(TbsConfigKey.KEY_APP_VERSIONNAME, C1135b.m7948a(f4830c));
        a2.f4826a.put(TbsConfigKey.KEY_APP_VERSIONCODE, Integer.valueOf(C1135b.m7951b(f4830c)));
        a2.f4826a.put(TbsConfigKey.KEY_APP_METADATA, C1135b.m7949a(f4830c, "com.tencent.mm.BuildInfo.CLIENT_VERSION"));
        a2.m7572g();
        if (f4832e == null) {
            f4832e = C1135b.m7947a();
            a2.f4826a.put(TbsConfigKey.KEY_DEVICE_CPUABI, f4832e);
            a2.m7572g();
        }
        if (!TextUtils.isEmpty(f4832e)) {
            Matcher matcher = null;
            try {
                matcher = Pattern.compile("i686|mips|x86_64").matcher(f4832e);
            } catch (Exception e) {
            }
            if (matcher != null && matcher.find()) {
                return false;
            }
        }
        JSONObject b = m7580b(z);
        try {
            i = b.getInt("TBSV");
        } catch (Exception e2) {
            i = -1;
        }
        if (i != -1) {
            try {
                a = m7577a(C1149m.m8001a(C1159w.m8057a(f4830c).m8062d(), b.toString().getBytes("utf-8"), new aa(), false), i);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return a;
        }
        a = false;
        return a;
    }

    /* renamed from: d */
    private static void m7584d() {
        TbsLog.m7927i(LOGTAG, "[TbsDownloader.queryConfig]");
        f4831d.removeMessages(100);
        Message.obtain(f4831d, 100).sendToTarget();
    }

    /* renamed from: e */
    private static boolean m7585e() {
        TbsDownloadConfig a = TbsDownloadConfig.m7565a(f4830c);
        if (a.f4827b.getInt(TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, 0) >= a.m7569d()) {
            TbsLog.m7928i(LOGTAG, "[TbsDownloader.needStartDownload] out of success retrytimes", true);
            return false;
        } else if (a.f4827b.getInt(TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, 0) >= a.m7570e()) {
            TbsLog.m7928i(LOGTAG, "[TbsDownloader.needStartDownload] out of failed retrytimes", true);
            return false;
        } else if (f4833f.m7900c()) {
            if (System.currentTimeMillis() - a.f4827b.getLong(TbsConfigKey.KEY_TBSDOWNLOAD_STARTTIME, 0) <= C1233a.f5597m) {
                long j = a.f4827b.getLong(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, 0);
                TbsLog.m7927i(LOGTAG, "[TbsDownloader.needStartDownload] downloadFlow=" + j);
                if (j >= a.m7566a()) {
                    TbsLog.m7928i(LOGTAG, "[TbsDownloader.needStartDownload] failed because you exceeded max flow!", true);
                    return false;
                }
            }
            return true;
        } else {
            TbsLog.m7928i(LOGTAG, "[TbsDownloader.needStartDownload] local rom freespace limit", true);
            return false;
        }
    }

    public static synchronized boolean getOverSea(Context context) {
        boolean z;
        synchronized (TbsDownloader.class) {
            if (!f4837j) {
                f4837j = true;
                TbsDownloadConfig a = TbsDownloadConfig.m7565a(context);
                if (a.f4827b.contains(TbsConfigKey.KEY_IS_OVERSEA)) {
                    f4836i = a.f4827b.getBoolean(TbsConfigKey.KEY_IS_OVERSEA, false);
                    TbsLog.m7927i(LOGTAG, "[TbsDownloader.getOverSea]  first called. sOverSea = " + f4836i);
                }
                TbsLog.m7927i(LOGTAG, "[TbsDownloader.getOverSea]  sOverSea = " + f4836i);
            }
            z = f4836i;
        }
        return z;
    }

    public static synchronized boolean isDownloading() {
        boolean z;
        synchronized (TbsDownloader.class) {
            TbsLog.m7927i(LOGTAG, "[TbsDownloader.isDownloading]");
            z = f4828a;
        }
        return z;
    }

    public static boolean needDownload(Context context, boolean z) {
        boolean z2 = false;
        TbsLog.app_extra(LOGTAG, context);
        if (VERSION.SDK_INT >= 8) {
            f4830c = context.getApplicationContext();
            TbsDownloadConfig a = TbsDownloadConfig.m7565a(f4830c);
            if (!a.f4827b.contains(TbsConfigKey.KEY_IS_OVERSEA)) {
                if (z && !"com.tencent.mm".equals(context.getApplicationInfo().packageName)) {
                    z = false;
                    TbsLog.m7927i(LOGTAG, "needDownload-oversea is true, but not WX");
                }
                a.f4826a.put(TbsConfigKey.KEY_IS_OVERSEA, Boolean.valueOf(z));
                a.m7572g();
                f4836i = z;
                TbsLog.m7927i(LOGTAG, "needDownload-first-called--isoversea = " + z);
            }
            if (!getOverSea(context) || VERSION.SDK_INT == 16 || VERSION.SDK_INT == 17 || VERSION.SDK_INT == 18) {
                f4832e = a.f4827b.getString(TbsConfigKey.KEY_DEVICE_CPUABI, null);
                if (!TextUtils.isEmpty(f4832e)) {
                    Matcher matcher = null;
                    try {
                        matcher = Pattern.compile("i686|mips|x86_64").matcher(f4832e);
                    } catch (Exception e) {
                    }
                    if (matcher != null && matcher.find()) {
                        QbSdk.f4786e.onCallBackErrorCode(1000, ErrorCode.INFO_ERROR_NOMATCH_CPU);
                        return false;
                    }
                }
                m7582c();
                if (f4835h) {
                    return false;
                }
                Object obj;
                String string = a.f4827b.getString(TbsConfigKey.KEY_APP_VERSIONNAME, null);
                int i = a.f4827b.getInt(TbsConfigKey.KEY_APP_VERSIONCODE, 0);
                String string2 = a.f4827b.getString(TbsConfigKey.KEY_APP_METADATA, null);
                String a2 = C1135b.m7948a(f4830c);
                int b = C1135b.m7951b(f4830c);
                String a3 = C1135b.m7949a(f4830c, "com.tencent.mm.BuildInfo.CLIENT_VERSION");
                if (System.currentTimeMillis() - a.f4827b.getLong(TbsConfigKey.KEY_LAST_CHECK, 0) > 1000 * a.m7567b()) {
                    obj = 1;
                } else if (a2 == null || b == 0 || a3 == null || (a2.equals(string) && b == i && a3.equals(string2))) {
                    obj = null;
                } else {
                    int i2 = 1;
                }
                if (obj != null) {
                    m7584d();
                }
                f4831d.removeMessages(102);
                Message.obtain(f4831d, 102).sendToTarget();
                z2 = a.f4827b.contains(TbsConfigKey.KEY_NEEDDOWNLOAD);
                TbsLog.m7927i(LOGTAG, "[TbsDownloader.needDownload] hasNeedDownloadKey=" + z2);
                z2 = (z2 || TbsShareManager.isThirdPartyApp(context)) ? a.f4827b.getBoolean(TbsConfigKey.KEY_NEEDDOWNLOAD, false) : true;
                if (z2) {
                    if (!m7585e()) {
                        z2 = false;
                    }
                } else if (obj != null) {
                    f4831d.removeMessages(103);
                    Message.obtain(f4831d, 103, f4830c).sendToTarget();
                }
            } else {
                TbsLog.m7927i(LOGTAG, "needDownload- return false,  because of  version is " + VERSION.SDK_INT + ", and overea");
                return false;
            }
        }
        TbsLog.m7927i(LOGTAG, "[TbsDownloader.needDownload] needDownload=" + z2);
        return z2;
    }

    public static synchronized void startDownload(Context context) {
        synchronized (TbsDownloader.class) {
            TbsLog.m7927i(LOGTAG, "[TbsDownloader.startDownload] sAppContext=" + f4830c);
            f4828a = true;
            if (VERSION.SDK_INT < 8) {
                QbSdk.f4786e.onDownloadFinish(ErrorCode.NONEEDTODOWN_ERROR);
            } else {
                f4830c = context.getApplicationContext();
                m7582c();
                if (!f4835h) {
                    f4831d.removeMessages(101);
                    f4831d.removeMessages(100);
                    Message.obtain(f4831d, 101, QbSdk.f4786e).sendToTarget();
                }
            }
        }
    }

    public static void stopDownload() {
        if (!f4835h) {
            TbsLog.m7927i(LOGTAG, "[TbsDownloader.stopDownload]");
            if (f4833f != null) {
                f4833f.m7902e();
            }
            if (f4831d != null) {
                f4831d.removeMessages(100);
                f4831d.removeMessages(101);
            }
        }
    }
}
