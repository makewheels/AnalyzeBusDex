package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebIconDatabase;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewDatabase;
import android.widget.Toast;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.sdk.p051a.C1091d;
import com.tencent.smtt.utils.C1135b;
import com.tencent.smtt.utils.C1146j;
import com.tencent.smtt.utils.C1151o;
import com.tencent.smtt.utils.C1157u;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.TbsLogClient;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p054u.aly.bi_常量类;

@SuppressLint({"NewApi"})
public class QbSdk {
    public static final String LOGIN_TYPE_KEY_PARTNER_CALL_POS = "PosID";
    public static final String LOGIN_TYPE_KEY_PARTNER_ID = "ChannelID";
    public static final String PARAM_KEY_FEATUREID = "param_key_featureid";
    public static final String PARAM_KEY_FUNCTIONID = "param_key_functionid";
    public static final String PARAM_KEY_POSITIONID = "param_key_positionid";
    public static final int SVNVERSION = 382471;
    public static final String TID_QQNumber_Prefix = "QQ:";
    public static final int VERSION = 1;
    /* renamed from: a */
    static boolean f4782a = false;
    /* renamed from: b */
    static boolean f4783b = false;
    /* renamed from: c */
    static boolean f4784c = false;
    /* renamed from: d */
    static volatile boolean f4785d = f4782a;
    /* renamed from: e */
    static TbsListener f4786e = new C1108g();
    /* renamed from: f */
    private static int f4787f;
    /* renamed from: g */
    private static String f4788g = bi_常量类.f6358b_空串;
    /* renamed from: h */
    private static Class<?> f4789h;
    /* renamed from: i */
    private static Object f4790i;
    /* renamed from: j */
    private static boolean f4791j = false;
    /* renamed from: k */
    private static String[] f4792k;
    /* renamed from: l */
    private static String f4793l = null;
    /* renamed from: m */
    private static String f4794m = null;
    public static boolean mTbsDebugInstallOnline = false;
    public static TbsListener mTbsListenerDebug = null;
    /* renamed from: n */
    private static boolean f4795n = true;
    /* renamed from: o */
    private static TbsListener f4796o = null;
    /* renamed from: p */
    private static boolean f4797p = false;
    /* renamed from: q */
    private static boolean f4798q = false;
    public static boolean sIsVersionPrinted = false;

    public interface PreInitCallback {
        void onCoreInitFinished();

        void onViewInitFinished();
    }

    /* renamed from: a */
    static Bundle m7543a(Context context, Bundle bundle) {
        if (m7545a(context)) {
            Object a = C1157u.m8042a(f4790i, "incrUpdate", new Class[]{Context.class, Bundle.class}, context, bundle);
            if (a != null) {
                return (Bundle) a;
            }
            TbsLogReport.m7589a(context).m7601a((int) ErrorCode.INCR_UPDATE_ERROR, "incrUpdate return null!");
            return null;
        }
        TbsLogReport.m7589a(context).m7601a((int) ErrorCode.INCR_UPDATE_ERROR, "initForPatch return false!");
        return null;
    }

    /* renamed from: a */
    static void m7544a() {
        f4782a = true;
        TbsLog.m7925e("QbSdk", "sys WebView: SysWebViewForcedInner");
    }

    /* renamed from: a */
    static boolean m7545a(Context context) {
        try {
            if (f4789h != null) {
                return true;
            }
            File f = ac.m7706a().m7747f(context);
            if (f == null) {
                TbsLog.m7925e("QbSdk", "QbSdk initForPatch (false) optDir == null");
                return false;
            }
            File file = new File(f, "tbs_sdk_extension_dex.jar");
            if (file.exists()) {
                f4789h = new DexClassLoader(file.getAbsolutePath(), f.getAbsolutePath(), null, QbSdk.class.getClassLoader()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                f4790i = f4789h.getConstructor(new Class[]{Context.class, Context.class}).newInstance(new Object[]{context, context});
                return true;
            }
            TbsLog.m7926e("QbSdk", "QbSdk initForPatch (false) dexFile.exists()=false", true);
            return false;
        } catch (Throwable th) {
            TbsLog.m7925e("QbSdk", "initForPatch sys WebView: " + Log.getStackTraceString(th));
            return false;
        }
    }

    /* renamed from: a */
    static boolean m7546a(Context context, int i) {
        return m7547a(context, i, (int) BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT);
    }

    /* renamed from: a */
    static boolean m7547a(Context context, int i, int i2) {
        if (!m7551b(context)) {
            return true;
        }
        Object a = C1157u.m8042a(f4790i, "isX5Disabled", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE}, Integer.valueOf(i), Integer.valueOf(36509), Integer.valueOf(i2));
        if (a != null) {
            return ((Boolean) a).booleanValue();
        }
        a = C1157u.m8042a(f4790i, "isX5Disabled", new Class[]{Integer.TYPE, Integer.TYPE}, Integer.valueOf(i), Integer.valueOf(36509));
        return a != null ? ((Boolean) a).booleanValue() : true;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    private static boolean m7548a(Context context, boolean z) {
        if (!sIsVersionPrinted) {
            TbsLog.m7927i("QbSdk", "svn revision: 382471; SDK_VERSION_CODE: 36509; SDK_VERSION_NAME: 2.1.2.1083");
            sIsVersionPrinted = true;
        }
        if (f4782a && !z) {
            TbsLog.m7926e("QbSdk", "QbSdk init mIsSysWebViewForced = true", false);
            TbsCoreLoadStat.getInstance().m7563a(context, (int) ErrorCode.INFO_FORCE_SYSTEM_WEBVIEW_INNER);
            f4786e.onCallBackErrorCode(ErrorCode.INFO_FORCE_SYSTEM_WEBVIEW_INNER, ErrorCode.FORCE_SYSTEM_WEBVIEW_INNER);
            return false;
        } else if (f4783b) {
            TbsLog.m7926e("QbSdk", "QbSdk init mIsSysWebViewForcedByOuter = true", true);
            TbsCoreLoadStat.getInstance().m7563a(context, (int) ErrorCode.INFO_FORCE_SYSTEM_WEBVIEW_OUTER);
            f4786e.onCallBackErrorCode(ErrorCode.INFO_FORCE_SYSTEM_WEBVIEW_OUTER, ErrorCode.FORCE_SYSTEM_WEBVIEW_OUTER);
            return false;
        } else {
            if (!f4795n) {
                m7554d(context);
            }
            try {
                File f = ac.m7706a().m7747f(context);
                if (f == null) {
                    TbsLog.m7925e("QbSdk", "QbSdk init (false) optDir == null");
                    TbsCoreLoadStat.getInstance().m7563a(context, (int) ErrorCode.ERROR_TBSCORE_SHARE_DIR);
                    return false;
                }
                if (!TbsShareManager.isThirdPartyApp(context)) {
                    int c;
                    if (f4787f != 0) {
                        c = ac.m7706a().m7744c(context);
                        if (f4787f != c) {
                            if (c != 88888888) {
                                f4789h = null;
                                f4790i = null;
                                TbsLog.m7926e("QbSdk", "QbSdk init (false) not isThirdPartyApp tbsCoreInstalledVer=" + c, true);
                                TbsLog.m7926e("QbSdk", "QbSdk init (false) not isThirdPartyApp sTbsVersion=" + f4787f, true);
                                TbsCoreLoadStat.getInstance().m7564a(context, ErrorCode.ERROR_UNMATCH_TBSCORE_VER, new Throwable("sTbsVersion: " + f4787f + "; tbsCoreInstalledVer: " + c));
                                return false;
                            }
                            File file = new File(context.getDir("tbs", 0), "core_private");
                            if (file != null && file.isDirectory()) {
                                File file2 = new File(file, "tbs_extension.conf");
                                if (file2.exists()) {
                                    file2.delete();
                                    TbsLog.m7928i("QbSdk", "LOCAL_SDCARD_TBS_VERSION --> (" + file2.getName() + ") is deleted!", true);
                                }
                            }
                        }
                    } else {
                        c = 0;
                    }
                    f4787f = c;
                } else if (f4787f == 0 || f4787f == TbsShareManager.m7633c(context)) {
                    f4787f = TbsShareManager.m7633c(context);
                } else {
                    f4789h = null;
                    f4790i = null;
                    TbsLog.m7925e("QbSdk", "QbSdk init (false) isThirdPartyApp");
                    TbsCoreLoadStat.getInstance().m7563a(context, (int) ErrorCode.ERROR_UNMATCH_TBSCORE_VER_THIRDPARTY);
                    return false;
                }
                if (f4789h != null) {
                    return true;
                }
                File file3;
                if (!TbsShareManager.isThirdPartyApp(context)) {
                    file3 = new File(ac.m7706a().m7747f(context), "tbs_sdk_extension_dex.jar");
                } else if (TbsShareManager.m7638h(context)) {
                    file3 = new File(TbsShareManager.m7632b(context), "tbs_sdk_extension_dex.jar");
                } else {
                    TbsCoreLoadStat.getInstance().m7563a(context, (int) ErrorCode.ERROR_HOST_UNAVAILABLE);
                    f4786e.onCallBackErrorCode(ErrorCode.ERROR_HOST_UNAVAILABLE, ErrorCode.INFO_ERROR_HOST_UNAVAILABLE);
                    return false;
                }
                if (file3.exists()) {
                    f4789h = new DexClassLoader(file3.getAbsolutePath(), f.getAbsolutePath(), null, QbSdk.class.getClassLoader()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                    Constructor constructor = f4789h.getConstructor(new Class[]{Context.class, Context.class});
                    if (TbsShareManager.isThirdPartyApp(context)) {
                        f4790i = constructor.newInstance(new Object[]{context, TbsShareManager.m7634d(context)});
                    } else {
                        f4790i = constructor.newInstance(new Object[]{context, context});
                    }
                    C1157u.m8042a(f4790i, "putInfo", new Class[]{String.class, String.class, String.class, String.class}, C1135b.f5119a, C1135b.f5120b, C1135b.f5121c, C1135b.f5122d);
                    C1157u.m8042a(f4790i, "setClientVersion", new Class[]{Integer.TYPE}, Integer.valueOf(1));
                    return true;
                }
                TbsCoreLoadStat.getInstance().m7563a(context, (int) ErrorCode.INFO_MISS_SDKEXTENSION_JAR);
                f4786e.onCallBackErrorCode(ErrorCode.INFO_MISS_SDKEXTENSION_JAR, ErrorCode.METHOD_MISS_SDKEXTENSION_JAR);
                return false;
            } catch (Throwable e) {
                TbsLog.m7925e("QbSdk", "QbSdk init Exception: " + Log.getStackTraceString(e));
                TbsCoreLoadStat.getInstance().m7564a(context, ErrorCode.EXCEPTION_QBSDK_INIT, e);
                f4786e.onCallBackErrorCode(ErrorCode.EXCEPTION_QBSDK_INIT, ErrorCode.INFO_EXCEPTION_QBSDK_INIT);
                TbsLog.m7925e(TbsListener.tag_load_error, "316");
                return false;
            } catch (Throwable e2) {
                TbsLog.m7925e("QbSdk", "QbSdk init Throwable: " + Log.getStackTraceString(e2));
                TbsCoreLoadStat.getInstance().m7564a(context, ErrorCode.THROWABLE_QBSDK_INIT, e2);
                f4786e.onCallBackErrorCode(ErrorCode.THROWABLE_QBSDK_INIT, ErrorCode.INFO_EXCEPTION_QBSDK_INIT);
                TbsLog.m7925e(TbsListener.tag_load_error, "316");
                return false;
            }
        }
    }

    /* renamed from: a */
    static boolean m7549a(Context context, boolean z, boolean z2) {
        int i = 1;
        boolean z3 = false;
        if (TbsShareManager.isThirdPartyApp(context) && !TbsShareManager.m7637g(context)) {
            TbsCoreLoadStat.getInstance().m7563a(context, (int) ErrorCode.ERROR_UNMATCH_TBSCORE_VER_THIRDPARTY);
        } else if (m7548a(context, z)) {
            Object a = C1157u.m8042a(f4790i, "canLoadX5Core", new Class[]{Integer.TYPE}, Integer.valueOf(36509));
            boolean a2;
            if (a == null) {
                a = C1157u.m8042a(f4790i, "canLoadX5", new Class[]{Integer.TYPE}, Integer.valueOf(C1092a.m7702a()));
                if (a == null) {
                    TbsCoreLoadStat.getInstance().m7563a(context, (int) ErrorCode.ERROR_CANLOADX5_RETURN_NULL);
                    f4786e.onCallBackErrorCode(ErrorCode.ERROR_CANLOADX5_RETURN_NULL, ErrorCode.INFO_ERROR_CANLOADX5_RETURN_NULL);
                } else if ((a instanceof String) && ((String) a).equalsIgnoreCase("AuthenticationFail")) {
                    if (!z2) {
                        Toast.makeText(context, "Authentication fail, use sys webview, please contact tencent ", 1).show();
                    }
                    TbsLog.m7925e(TbsListener.tag_load_error, "317");
                    f4786e.onCallBackErrorCode(ErrorCode.ERROR_AUTHENTICATION, ErrorCode.INFO_ERROR_AUTHENTICATION);
                } else if (a instanceof Boolean) {
                    a2 = m7546a(context, C1110i.m7849d());
                    f4787f = C1110i.m7849d();
                    if (((Boolean) a).booleanValue() && !a2) {
                        z3 = true;
                    }
                    if (!z3) {
                        TbsLog.m7925e(TbsListener.tag_load_error, "318");
                        TbsLog.m7931w(TbsListener.tag_load_error, "isX5Disable:" + a2);
                        TbsLog.m7931w(TbsListener.tag_load_error, "(Boolean) ret:" + ((Boolean) a));
                    }
                }
            } else if ((a instanceof String) && ((String) a).equalsIgnoreCase("AuthenticationFail")) {
                if (!z2) {
                    Toast.makeText(context, "Authentication fail, use sys webview, please contact tencent ", 1).show();
                }
                f4786e.onCallBackErrorCode(ErrorCode.ERROR_AUTHENTICATION, ErrorCode.INFO_ERROR_AUTHENTICATION);
                TbsLog.m7925e(TbsListener.tag_load_error, "317");
            } else if (a instanceof Bundle) {
                Bundle bundle = (Bundle) a;
                int i2 = bundle.getInt("result_code", -1);
                a2 = i2 == 0;
                if (TbsShareManager.isThirdPartyApp(context)) {
                    C1110i.m7846a(TbsShareManager.m7633c(context));
                    f4788g = String.valueOf(TbsShareManager.m7633c(context));
                    if (f4788g.length() == 5) {
                        f4788g = "0" + f4788g;
                    }
                    if (f4788g.length() != 6) {
                        f4788g = bi_常量类.f6358b_空串;
                    }
                } else {
                    if (VERSION.SDK_INT >= 12) {
                        f4788g = bundle.getString("tbs_core_version", "0");
                    } else {
                        f4788g = bundle.getString("tbs_core_version");
                        if (f4788g == null) {
                            f4788g = "0";
                        }
                    }
                    try {
                        f4787f = Integer.parseInt(f4788g);
                    } catch (NumberFormatException e) {
                        f4787f = 0;
                    }
                    C1110i.m7846a(f4787f);
                    if ((f4787f <= 0 || f4787f > 25438) && f4787f != 25472) {
                        i = 0;
                    }
                    if (i != 0) {
                        C1146j.m7988b(ac.m7706a().m7747f(context));
                        TbsCoreLoadStat.getInstance().m7563a(context, (int) ErrorCode.ERROR_CANLOADX5_RETURN_FALSE);
                        TbsLog.m7925e(TbsListener.tag_load_error, "is_obsolete -- delete 319");
                        f4786e.onCallBackErrorCode(ErrorCode.ERROR_COREVERSION_TOOLOW, ErrorCode.INFO_ERROR_COREVERSION_TOOLOW);
                    }
                }
                try {
                    f4792k = bundle.getStringArray("tbs_jarfiles");
                    switch (i2) {
                        case -2:
                            if (TbsShareManager.isThirdPartyApp(context)) {
                                TbsCoreLoadStat.getInstance().m7563a(context, (int) ErrorCode.INFO_DISABLE_X5);
                            }
                            f4786e.onCallBackErrorCode(ErrorCode.INFO_DISABLE_X5, ErrorCode.DISABLE_X5);
                            break;
                        case -1:
                            a = null;
                            try {
                                a = C1157u.m8042a(f4790i, "getErrorCodeForLogReport", new Class[0], new Object[0]);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            if (!(a instanceof Integer) || ((Integer) a).intValue() == -1) {
                                TbsCoreLoadStat.getInstance().m7563a(context, (int) ErrorCode.ERROR_CANLOADX5_RETURN_FALSE);
                            } else {
                                TbsCoreLoadStat.getInstance().m7563a(context, ((Integer) a).intValue());
                            }
                            f4786e.onCallBackErrorCode(ErrorCode.ERROR_CANLOADX5_RETURN_FALSE, ErrorCode.INFO_ERROR_CANLOADX5_RETURN_FALSE);
                            break;
                    }
                    z3 = a2;
                } catch (Throwable th) {
                    TbsCoreLoadStat.getInstance().m7564a(context, ErrorCode.ERROR_GETSTRINGARRAY_JARFILE, th);
                }
            } else {
                f4786e.onCallBackErrorCode(ErrorCode.ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE, ErrorCode.INFO_ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE);
                TbsCoreLoadStat.getInstance().m7564a(context, ErrorCode.ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE, new Throwable(bi_常量类.f6358b_空串 + a));
                TbsLog.m7925e(TbsListener.tag_load_error, "ret not instance of bundle");
            }
            if (!z3) {
                TbsLog.m7925e(TbsListener.tag_load_error, "319");
                f4786e.onCallBackErrorCode(ErrorCode.ERROR_QBSDK_INIT_CANLOADX5, ErrorCode.INFO_ERROR_QBSDK_INIT_CANLOADX5);
            }
        } else {
            TbsLog.m7925e(TbsListener.tag_load_error, "315");
            f4786e.onCallBackErrorCode(ErrorCode.ERROR_QBSDK_INIT, ErrorCode.INFO_ERROR_QBSDK_INIT);
        }
        return z3;
    }

    public static void allowThirdAppDownload(boolean z) {
        f4784c = z;
    }

    /* renamed from: b */
    static String m7550b() {
        return f4788g;
    }

    /* renamed from: b */
    private static boolean m7551b(Context context) {
        try {
            if (f4789h != null) {
                return true;
            }
            File f = ac.m7706a().m7747f(context);
            if (f == null) {
                f4786e.onCallBackErrorCode(ErrorCode.ERROR_TBSCORE_DEXOPT_DIR, ErrorCode.INFO_ERROR_TBSCORE_DEXOPT_DIR);
                TbsLog.m7925e("QbSdk", "QbSdk initForX5DisableConfig (false) optDir == null");
                return false;
            }
            File file;
            if (!TbsShareManager.isThirdPartyApp(context)) {
                file = new File(ac.m7706a().m7747f(context), "tbs_sdk_extension_dex.jar");
            } else if (TbsShareManager.m7638h(context)) {
                file = new File(TbsShareManager.m7632b(context), "tbs_sdk_extension_dex.jar");
            } else {
                TbsCoreLoadStat.getInstance().m7563a(context, 1001);
                f4786e.onCallBackErrorCode(1001, ErrorCode.INFO_ERROR_HOST_UNAVAILABLE);
                return false;
            }
            if (file.exists()) {
                f4789h = new DexClassLoader(file.getAbsolutePath(), f.getAbsolutePath(), null, QbSdk.class.getClassLoader()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                Constructor constructor = f4789h.getConstructor(new Class[]{Context.class, Context.class});
                if (TbsShareManager.isThirdPartyApp(context)) {
                    f4790i = constructor.newInstance(new Object[]{context, TbsShareManager.m7634d(context)});
                } else {
                    f4790i = constructor.newInstance(new Object[]{context, context});
                }
                C1157u.m8042a(f4790i, "putInfo", new Class[]{String.class, String.class, String.class, String.class}, C1135b.f5119a, C1135b.f5120b, C1135b.f5121c, C1135b.f5122d);
                C1157u.m8042a(f4790i, "setClientVersion", new Class[]{Integer.TYPE}, Integer.valueOf(1));
                return true;
            }
            f4786e.onCallBackErrorCode(ErrorCode.ERROR_TBSCORE_DEXOPT_DIR, ErrorCode.INFO_ERROR_TBSCORE_DEXOPT_DIR);
            return false;
        } catch (Throwable th) {
            TbsLog.m7925e("QbSdk", "initForX5DisableConfig sys WebView: " + Log.getStackTraceString(th));
            return false;
        }
    }

    /* renamed from: c */
    private static boolean m7553c(Context context) {
        try {
            File file = new File(context.getFilesDir().getParentFile().getPath() + "/app_x5core");
            if (file == null || !file.exists() || !file.isDirectory()) {
                return true;
            }
            C1146j.m7988b(new File(context.getFilesDir().getParentFile().getPath() + "/app_tes_private"));
            File file2 = new File(context.getFilesDir().getParentFile().getPath() + "/app_appcache");
            C1146j.m7988b(new File(file2, "ApplicationCache.db"));
            C1146j.m7988b(new File(file2, "cache.db"));
            file2 = context.getCacheDir();
            C1146j.m7988b(new File(file2, "com.android.renderscript.cache"));
            C1146j.m7988b(new File(file2, "webviewCache"));
            C1146j.m7988b(new File(file2, "webviewCacheChromium"));
            C1146j.m7988b(new File(file2, "webviewCacheChromiumStaging"));
            C1146j.m7988b(context.getDatabasePath("smtt_webviewPrivate.db"));
            C1146j.m7988b(context.getDatabasePath("smtt_webviewPrivate.db-journal"));
            C1146j.m7988b(context.getDatabasePath("webview.db"));
            C1146j.m7988b(context.getDatabasePath("webview.db-journal"));
            C1146j.m7988b(context.getDatabasePath("webviewCache_x5.db"));
            C1146j.m7988b(context.getDatabasePath("webviewCache_x5.db-journal"));
            C1146j.m7988b(context.getDatabasePath("webviewCookiesChromium.db"));
            C1146j.m7988b(context.getDatabasePath("webviewCookiesChromiumPrivate.db"));
            C1146j.m7988b(context.getDatabasePath("webview_x5.db"));
            C1146j.m7988b(context.getDatabasePath("webview_x5.db-journal"));
            C1146j.m7988b(new File(context.getFilesDir(), "safe_uxss.js"));
            C1146j.m7988b(new File(context.getFilesDir().getParentFile().getPath() + "/lib" + "/libwebviewext.so"));
            C1146j.m7988b(new File(context.getFilesDir().getParentFile().getPath() + "/shared_prefs" + "/SHARED_PREFERENCE_SECURE_WEBVIEW.xml"));
            C1146j.m7988b(new File(context.getFilesDir().getParentFile().getPath() + "/shared_prefs" + "/x5_config.xml"));
            C1146j.m7988b(file);
            return true;
        } catch (Throwable th) {
            TbsLog.m7925e("QbSdk", "deleteFilesUseless Exception: " + Log.getStackTraceString(th));
            return false;
        }
    }

    public static boolean canLoadVideo(Context context) {
        Object a = C1157u.m8042a(f4790i, "canLoadVideo", new Class[]{Integer.TYPE}, Integer.valueOf(0));
        if (a == null) {
            TbsCoreLoadStat.getInstance().m7563a(context, (int) ErrorCode.ERROR_CANLOADVIDEO_RETURN_NULL);
        } else if (!((Boolean) a).booleanValue()) {
            TbsCoreLoadStat.getInstance().m7563a(context, (int) ErrorCode.ERROR_CANLOADVIDEO_RETURN_FALSE);
        }
        return a == null ? false : ((Boolean) a).booleanValue();
    }

    public static void canOpenFile(Context context, String str, ValueCallback<Boolean> valueCallback) {
        new C1104c(context, str, valueCallback).start();
    }

    public static boolean canOpenMimeFileType(Context context, String str) {
        return !m7548a(context, false) ? false : false;
    }

    public static boolean canUseVideoFeatrue(Context context, int i) {
        Object a = C1157u.m8042a(f4790i, "canUseVideoFeatrue", new Class[]{Integer.TYPE}, Integer.valueOf(i));
        return (a == null || !(a instanceof Boolean)) ? false : ((Boolean) a).booleanValue();
    }

    public static void clear(Context context) {
    }

    public static void clearAllWebViewCache(Context context, boolean z) {
        try {
            new WebView(context).clearCache(true);
            if (z) {
                CookieSyncManager.createInstance(context);
                CookieManager.getInstance().removeAllCookie();
            }
            WebViewDatabase.getInstance(context).clearUsernamePassword();
            WebViewDatabase.getInstance(context).clearHttpAuthUsernamePassword();
            WebViewDatabase.getInstance(context).clearFormData();
            WebStorage.getInstance().deleteAllData();
            WebIconDatabase.getInstance().removeAllIcons();
        } catch (Throwable th) {
            TbsLog.m7925e("QbSdk", "clearAllWebViewCache exception 1 -- " + Log.getStackTraceString(th));
        }
        try {
            if (new WebView(context).getWebViewClientExtension() != null) {
                C1110i a = C1110i.m7845a(false);
                if (a != null && a.m7858b()) {
                    a.m7852a().m7773a(context, z);
                }
            }
        } catch (Throwable th2) {
        }
    }

    public static void closeFileReader(Context context) {
        C1110i a = C1110i.m7845a(true);
        a.m7853a(context);
        if (a.m7858b()) {
            a.m7852a().m7805n();
        }
    }

    public static boolean createMiniQBShortCut(Context context, String str, String str2, Drawable drawable) {
        if (context == null) {
            return false;
        }
        if (TbsDownloader.getOverSea(context)) {
            return false;
        }
        if (isMiniQBShortCutExist(context, str, str2)) {
            return false;
        }
        C1110i a = C1110i.m7845a(false);
        if (a == null || !a.m7858b()) {
            return false;
        }
        Bitmap bitmap = null;
        if (drawable instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) drawable).getBitmap();
        }
        DexLoader o = a.m7852a().m7806o();
        TbsLog.m7925e("QbSdk", "qbsdk createMiniQBShortCut");
        Object invokeStaticMethod = o.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createMiniQBShortCut", new Class[]{Context.class, String.class, String.class, Bitmap.class}, context, str, str2, bitmap);
        TbsLog.m7925e("QbSdk", "qbsdk after createMiniQBShortCut ret: " + invokeStaticMethod);
        return invokeStaticMethod != null;
    }

    /* renamed from: d */
    private static void m7554d(Context context) {
        Throwable th;
        Editor edit;
        File d;
        int i = -1;
        f4795n = true;
        SharedPreferences sharedPreferences;
        int i2;
        int i3;
        int i4;
        try {
            sharedPreferences = VERSION.SDK_INT >= 11 ? context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0);
            try {
                i2 = sharedPreferences.getInt("tbs_preload_x5_recorder", -1);
                if (i2 >= 0) {
                    i2++;
                    if (i2 <= 4) {
                        i3 = i2;
                    } else {
                        return;
                    }
                }
                i3 = i2;
                i2 = -1;
            } catch (Throwable th2) {
                th = th2;
                i2 = -1;
                i4 = -1;
                TbsLog.m7925e("QbSdk", "tbs_preload_x5_counter Inc exception:" + Log.getStackTraceString(th));
                i3 = -1;
                if (i3 <= 3) {
                    TbsLog.m7927i("QbSdk", "QbSdk - preload_x5_check -- before creation!");
                    C1110i.m7845a(true).m7853a(context);
                    TbsLog.m7927i("QbSdk", "QbSdk - preload_x5_check -- after creation!");
                    i = 0;
                    try {
                        i3 = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                        if (i3 > 0) {
                            sharedPreferences.edit().putInt("tbs_preload_x5_counter", i3 - 1).commit();
                        }
                    } catch (Throwable th3) {
                        TbsLog.m7925e("QbSdk", "tbs_preload_x5_counter Dec exception:" + Log.getStackTraceString(th3));
                    }
                    TbsLog.m7927i("QbSdk", "QbSdk -- preload_x5_check result:" + i);
                }
                try {
                    i3 = sharedPreferences.getInt("tbs_preload_x5_version", -1);
                    edit = sharedPreferences.edit();
                    if (i3 != i4) {
                        TbsLog.m7925e("QbSdk", "QbSdk - preload_x5_check -- reset exception core_ver:" + i4 + "; value:" + i3);
                    } else {
                        C1146j.m7977a(ac.m7706a().m7747f(context), false);
                        d = C1131y.m7904a(context).m7915d();
                        if (d != null) {
                            C1146j.m7977a(d, false);
                        }
                        TbsLog.m7925e("QbSdk", "QbSdk - preload_x5_check: tbs core " + i4 + " is deleted!");
                    }
                    edit.putInt("tbs_precheck_disable_version", i3);
                    edit.commit();
                } catch (Throwable th32) {
                    TbsLog.m7925e("QbSdk", "tbs_preload_x5_counter disable version exception:" + Log.getStackTraceString(th32));
                    return;
                }
            }
            try {
                i4 = ac.m7706a().m7744c(context);
                if (i4 > 0) {
                    if (i3 <= 4) {
                        try {
                            sharedPreferences.edit().putInt("tbs_preload_x5_recorder", i3).commit();
                        } catch (Throwable th4) {
                            th32 = th4;
                            TbsLog.m7925e("QbSdk", "tbs_preload_x5_counter Inc exception:" + Log.getStackTraceString(th32));
                            i3 = -1;
                            if (i3 <= 3) {
                                TbsLog.m7927i("QbSdk", "QbSdk - preload_x5_check -- before creation!");
                                C1110i.m7845a(true).m7853a(context);
                                TbsLog.m7927i("QbSdk", "QbSdk - preload_x5_check -- after creation!");
                                i = 0;
                                i3 = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                                if (i3 > 0) {
                                    sharedPreferences.edit().putInt("tbs_preload_x5_counter", i3 - 1).commit();
                                }
                                TbsLog.m7927i("QbSdk", "QbSdk -- preload_x5_check result:" + i);
                            }
                            i3 = sharedPreferences.getInt("tbs_preload_x5_version", -1);
                            edit = sharedPreferences.edit();
                            if (i3 != i4) {
                                TbsLog.m7925e("QbSdk", "QbSdk - preload_x5_check -- reset exception core_ver:" + i4 + "; value:" + i3);
                            } else {
                                C1146j.m7977a(ac.m7706a().m7747f(context), false);
                                d = C1131y.m7904a(context).m7915d();
                                if (d != null) {
                                    C1146j.m7977a(d, false);
                                }
                                TbsLog.m7925e("QbSdk", "QbSdk - preload_x5_check: tbs core " + i4 + " is deleted!");
                            }
                            edit.putInt("tbs_precheck_disable_version", i3);
                            edit.commit();
                        }
                    }
                    i3 = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                    if (i3 >= 0) {
                        i3++;
                        sharedPreferences.edit().putInt("tbs_preload_x5_counter", i3).commit();
                        if (i3 <= 3) {
                            i3 = sharedPreferences.getInt("tbs_preload_x5_version", -1);
                            edit = sharedPreferences.edit();
                            if (i3 != i4) {
                                C1146j.m7977a(ac.m7706a().m7747f(context), false);
                                d = C1131y.m7904a(context).m7915d();
                                if (d != null) {
                                    C1146j.m7977a(d, false);
                                }
                                TbsLog.m7925e("QbSdk", "QbSdk - preload_x5_check: tbs core " + i4 + " is deleted!");
                            } else {
                                TbsLog.m7925e("QbSdk", "QbSdk - preload_x5_check -- reset exception core_ver:" + i4 + "; value:" + i3);
                            }
                            edit.putInt("tbs_precheck_disable_version", i3);
                            edit.commit();
                        }
                        if (i2 > 0 && i2 <= 3) {
                            TbsLog.m7927i("QbSdk", "QbSdk - preload_x5_check -- before creation!");
                            C1110i.m7845a(true).m7853a(context);
                            TbsLog.m7927i("QbSdk", "QbSdk - preload_x5_check -- after creation!");
                            i = 0;
                        }
                        i3 = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                        if (i3 > 0) {
                            sharedPreferences.edit().putInt("tbs_preload_x5_counter", i3 - 1).commit();
                        }
                        TbsLog.m7927i("QbSdk", "QbSdk -- preload_x5_check result:" + i);
                    }
                    i3 = -1;
                    if (i3 <= 3) {
                        TbsLog.m7927i("QbSdk", "QbSdk - preload_x5_check -- before creation!");
                        C1110i.m7845a(true).m7853a(context);
                        TbsLog.m7927i("QbSdk", "QbSdk - preload_x5_check -- after creation!");
                        i = 0;
                        i3 = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                        if (i3 > 0) {
                            sharedPreferences.edit().putInt("tbs_preload_x5_counter", i3 - 1).commit();
                        }
                        TbsLog.m7927i("QbSdk", "QbSdk -- preload_x5_check result:" + i);
                    }
                    i3 = sharedPreferences.getInt("tbs_preload_x5_version", -1);
                    edit = sharedPreferences.edit();
                    if (i3 != i4) {
                        TbsLog.m7925e("QbSdk", "QbSdk - preload_x5_check -- reset exception core_ver:" + i4 + "; value:" + i3);
                    } else {
                        C1146j.m7977a(ac.m7706a().m7747f(context), false);
                        d = C1131y.m7904a(context).m7915d();
                        if (d != null) {
                            C1146j.m7977a(d, false);
                        }
                        TbsLog.m7925e("QbSdk", "QbSdk - preload_x5_check: tbs core " + i4 + " is deleted!");
                    }
                    edit.putInt("tbs_precheck_disable_version", i3);
                    edit.commit();
                }
            } catch (Throwable th5) {
                th32 = th5;
                i4 = -1;
                TbsLog.m7925e("QbSdk", "tbs_preload_x5_counter Inc exception:" + Log.getStackTraceString(th32));
                i3 = -1;
                if (i3 <= 3) {
                    i3 = sharedPreferences.getInt("tbs_preload_x5_version", -1);
                    edit = sharedPreferences.edit();
                    if (i3 != i4) {
                        C1146j.m7977a(ac.m7706a().m7747f(context), false);
                        d = C1131y.m7904a(context).m7915d();
                        if (d != null) {
                            C1146j.m7977a(d, false);
                        }
                        TbsLog.m7925e("QbSdk", "QbSdk - preload_x5_check: tbs core " + i4 + " is deleted!");
                    } else {
                        TbsLog.m7925e("QbSdk", "QbSdk - preload_x5_check -- reset exception core_ver:" + i4 + "; value:" + i3);
                    }
                    edit.putInt("tbs_precheck_disable_version", i3);
                    edit.commit();
                }
                TbsLog.m7927i("QbSdk", "QbSdk - preload_x5_check -- before creation!");
                C1110i.m7845a(true).m7853a(context);
                TbsLog.m7927i("QbSdk", "QbSdk - preload_x5_check -- after creation!");
                i = 0;
                i3 = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                if (i3 > 0) {
                    sharedPreferences.edit().putInt("tbs_preload_x5_counter", i3 - 1).commit();
                }
                TbsLog.m7927i("QbSdk", "QbSdk -- preload_x5_check result:" + i);
            }
        } catch (Throwable th6) {
            th32 = th6;
            sharedPreferences = null;
            i4 = -1;
            i2 = -1;
            TbsLog.m7925e("QbSdk", "tbs_preload_x5_counter Inc exception:" + Log.getStackTraceString(th32));
            i3 = -1;
            if (i3 <= 3) {
                i3 = sharedPreferences.getInt("tbs_preload_x5_version", -1);
                edit = sharedPreferences.edit();
                if (i3 != i4) {
                    C1146j.m7977a(ac.m7706a().m7747f(context), false);
                    d = C1131y.m7904a(context).m7915d();
                    if (d != null) {
                        C1146j.m7977a(d, false);
                    }
                    TbsLog.m7925e("QbSdk", "QbSdk - preload_x5_check: tbs core " + i4 + " is deleted!");
                } else {
                    TbsLog.m7925e("QbSdk", "QbSdk - preload_x5_check -- reset exception core_ver:" + i4 + "; value:" + i3);
                }
                edit.putInt("tbs_precheck_disable_version", i3);
                edit.commit();
            }
            TbsLog.m7927i("QbSdk", "QbSdk - preload_x5_check -- before creation!");
            C1110i.m7845a(true).m7853a(context);
            TbsLog.m7927i("QbSdk", "QbSdk - preload_x5_check -- after creation!");
            i = 0;
            i3 = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
            if (i3 > 0) {
                sharedPreferences.edit().putInt("tbs_preload_x5_counter", i3 - 1).commit();
            }
            TbsLog.m7927i("QbSdk", "QbSdk -- preload_x5_check result:" + i);
        }
    }

    public static boolean deleteMiniQBShortCut(Context context, String str, String str2) {
        if (context == null || TbsDownloader.getOverSea(context)) {
            return false;
        }
        C1110i a = C1110i.m7845a(false);
        if (a == null || !a.m7858b()) {
            return false;
        }
        return a.m7852a().m7806o().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "deleteMiniQBShortCut", new Class[]{Context.class, String.class, String.class}, context, str, str2) != null;
    }

    public static void forceSysWebView() {
        f4783b = true;
        TbsLog.m7925e("QbSdk", "sys WebView: SysWebViewForcedByOuter");
    }

    public static long getApkFileSize(Context context) {
        return context != null ? TbsDownloadConfig.m7565a(context.getApplicationContext()).f4827b.getLong(TbsConfigKey.KEY_TBSAPKFILESIZE, 0) : 0;
    }

    public static String[] getDexLoaderFileList(Context context, Context context2, String str) {
        int i = 0;
        if (f4792k != null) {
            int length = f4792k.length;
            String[] strArr = new String[length];
            while (i < length) {
                strArr[i] = str + f4792k[i];
                i++;
            }
            return strArr;
        }
        Object a = C1157u.m8042a(f4790i, "getJarFiles", new Class[]{Context.class, Context.class, String.class}, context, context2, str);
        if (a == null) {
            a = bi_常量类.f6358b_空串;
        }
        return (String[]) a;
    }

    public static boolean getDownloadWithoutWifi() {
        return f4797p;
    }

    public static String getMiniQBVersion() {
        C1110i a = C1110i.m7845a(false);
        return (a == null || !a.m7858b()) ? null : a.m7852a().m7789d();
    }

    public static String getQQBuildNumber() {
        return f4794m;
    }

    public static boolean getTBSInstalling() {
        return f4798q;
    }

    public static String getTID() {
        return f4793l;
    }

    public static int getTbsVersion(Context context) {
        m7553c(context);
        return TbsShareManager.isThirdPartyApp(context) ? TbsShareManager.m7633c(context) : ac.m7706a().m7744c(context);
    }

    public static String getX5CoreTimestamp() {
        Object a = C1157u.m8040a(f4789h, "getX5CoreTimestamp", null, new Object[0]);
        return a == null ? bi_常量类.f6358b_空串 : (String) a;
    }

    public static boolean installLocalQbApk(Context context, String str, String str2, Bundle bundle) {
        C1110i a = C1110i.m7845a(false);
        return (a == null || !a.m7858b()) ? false : a.m7852a().m7779a(context, str, str2, bundle);
    }

    public static boolean intentDispatch(WebView webView, Intent intent, String str, String str2) {
        if (webView == null) {
            return false;
        }
        if (str.startsWith("mttbrowser://miniqb/ch=icon?")) {
            Context context = webView.getContext();
            int indexOf = str.indexOf("url=");
            String substring = indexOf > 0 ? str.substring(indexOf + 4) : null;
            HashMap hashMap = new HashMap();
            Object obj = "unknown";
            try {
                obj = context.getApplicationInfo().packageName;
            } catch (Exception e) {
                e.printStackTrace();
            }
            hashMap.put(LOGIN_TYPE_KEY_PARTNER_ID, obj);
            hashMap.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, "14004");
            if (C1091d.m7691a(context, "miniqb://home".equals(substring) ? "qb://navicard/addCard?cardId=168&cardName=168" : substring, hashMap, "QbSdk.startMiniQBToLoadUrl") != 0) {
                C1110i a = C1110i.m7845a(false);
                if (a != null && a.m7858b() && a.m7852a().m7768a(context, substring, null, str2) == 0) {
                    return true;
                }
                webView.loadUrl(substring);
            }
        } else {
            webView.loadUrl(str);
        }
        return false;
    }

    public static boolean isMiniQBShortCutExist(Context context, String str, String str2) {
        if (context == null) {
            return false;
        }
        if (TbsDownloader.getOverSea(context)) {
            return false;
        }
        C1110i a = C1110i.m7845a(false);
        if (a == null || !a.m7858b()) {
            return false;
        }
        Object invokeStaticMethod = a.m7852a().m7806o().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "isMiniQBShortCutExist", new Class[]{Context.class, String.class}, context, str);
        if (invokeStaticMethod == null) {
            return false;
        }
        return (invokeStaticMethod instanceof Boolean ? (Boolean) invokeStaticMethod : Boolean.valueOf(false)).booleanValue();
    }

    public static boolean isSdkVideoServiceFg(Context context) {
        try {
            List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getApplicationContext().getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses == null || runningAppProcesses.size() == 0) {
                return false;
            }
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.importance == 100 && runningAppProcessInfo.processName != null && runningAppProcessInfo.processName.contains("com.tencent.mtt:VideoService")) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            TbsLog.m7925e("QbSdk", "isSdkVideoServiceFg Exception: " + Log.getStackTraceString(th));
        }
    }

    public static boolean isTbsCoreInited() {
        C1110i a = C1110i.m7845a(false);
        return a != null && a.m7863g();
    }

    public static boolean isX5DisabledSync(Context context) {
        if (C1131y.m7904a(context).m7921i() == 2) {
            int i = 1;
        } else {
            boolean z = false;
        }
        if (i != 0) {
            return false;
        }
        if (!m7551b(context)) {
            return true;
        }
        i = ac.m7706a().m7744c(context);
        Object a = C1157u.m8042a(f4790i, "isX5DisabledSync", new Class[]{Integer.TYPE, Integer.TYPE}, Integer.valueOf(i), Integer.valueOf(36509));
        return a != null ? ((Boolean) a).booleanValue() : true;
    }

    public static synchronized void preInit(Context context) {
        synchronized (QbSdk.class) {
            preInit(context, null);
        }
    }

    public static synchronized void preInit(Context context, PreInitCallback preInitCallback) {
        synchronized (QbSdk.class) {
            f4785d = f4782a;
            if (!f4791j) {
                new C1107f(context, new C1106e(Looper.getMainLooper(), context, preInitCallback)).start();
                f4791j = true;
            }
        }
    }

    public static void reset(Context context) {
        TbsLog.m7926e("QbSdk", "QbSdk reset!", true);
        try {
            TbsDownloader.stopDownload();
            TbsDownloader.m7581b(context);
            C1146j.m7988b(context.getDir("tbs", 0));
            TbsLog.m7928i("QbSdk", "delete downloaded apk success", true);
            ac.m7706a().f4955a = 0;
        } catch (Throwable th) {
            TbsLog.m7925e("QbSdk", "QbSdk reset exception:" + Log.getStackTraceString(th));
        }
    }

    public static void setCurrentID(String str) {
        if (str != null && str.startsWith(TID_QQNumber_Prefix)) {
            String substring = str.substring(TID_QQNumber_Prefix.length());
            f4793l = "0000000000000000".substring(substring.length()) + substring;
        }
    }

    public static void setDeviceInfo(String str, String str2, String str3, String str4) {
        C1135b.f5119a = str;
        C1135b.f5120b = str2;
        C1135b.f5121c = str3;
        C1135b.f5122d = str4;
    }

    public static void setDownloadWithoutWifi(boolean z) {
        f4797p = z;
    }

    public static void setQQBuildNumber(String str) {
        f4794m = str;
    }

    public static void setTBSInstallingStatus(boolean z) {
        f4798q = z;
    }

    public static void setTbsListener(TbsListener tbsListener) {
        f4796o = tbsListener;
    }

    public static void setTbsLogClient(TbsLogClient tbsLogClient) {
        TbsLog.setTbsLogClient(tbsLogClient);
    }

    public static int startMiniQBToLoadUrl(Context context, String str, HashMap<String, String> hashMap) {
        if (context == null) {
            return -100;
        }
        C1110i a = C1110i.m7845a(true);
        a.m7853a(context);
        return a.m7858b() ? (context == null || !context.getApplicationInfo().packageName.equals("com.nd.android.pandahome2") || getTbsVersion(context) >= 25487) ? a.m7852a().m7768a(context, str, (Map) hashMap, null) : -101 : -102;
    }

    public static boolean startQBForDoc(Context context, String str, int i, int i2, String str2) {
        return startQBForDoc(context, str, i, i2, str2, null);
    }

    public static boolean startQBForDoc(Context context, String str, int i, int i2, String str2, Bundle bundle) {
        HashMap hashMap = new HashMap();
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationContext().getApplicationInfo().processName);
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, Integer.toString(i));
        return C1091d.m7695a(context, str, i2, str2, hashMap, bundle);
    }

    public static boolean startQBForVideo(Context context, String str, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationInfo().processName);
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, Integer.toString(i));
        return C1091d.m7696a(context, str, hashMap);
    }

    public static boolean startQBToLoadurl(Context context, String str, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationInfo().processName);
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, Integer.toString(i));
        return C1091d.m7691a(context, str, hashMap, "QbSdk.startQBToLoadurl") == 0;
    }

    public static int startQBWeb(Context context, String str) {
        if (context == null) {
            return -1;
        }
        C1110i a = C1110i.m7845a(false);
        if (a == null || !a.m7858b()) {
            return -1;
        }
        Object invokeStaticMethod = a.m7852a().m7806o().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startQBWeb", new Class[]{Context.class, String.class, String.class}, context, str, null);
        return invokeStaticMethod == null ? -3 : ((Integer) invokeStaticMethod).intValue();
    }

    public static boolean startQbOrMiniQBToLoadUrl(Context context, String str, HashMap<String, String> hashMap) {
        if (context == null) {
            return false;
        }
        String string;
        String string2;
        C1110i a = C1110i.m7845a(true);
        a.m7853a(context);
        String str2 = "QbSdk.startMiniQBToLoadUrl";
        if ("miniqb://home".equals(str)) {
            String str3 = "qb://navicard/addCard?cardId=168&cardName=168";
            if (a.m7858b()) {
                Bundle bundle = (Bundle) a.m7852a().m7806o().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getAdWebViewInfoFromX5Core", new Class[0], new Object[0]);
                if (bundle != null) {
                    string = bundle.getString("ad_webview_detail_url");
                    string2 = bundle.getString("ad_webview_click_stat_posid_for_qb");
                    if (!TextUtils.isEmpty(string)) {
                        if (hashMap != null) {
                            hashMap.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, string2);
                        }
                        str = string;
                    }
                }
            }
            string = str3;
        } else {
            string = str;
        }
        if ("miniqb://home".equals(str) && hashMap != null) {
            string2 = (String) hashMap.get("curUrlQQ");
            if (!TextUtils.isEmpty(string2)) {
                str = "http://adsolution.imtt.qq.com/index?p=tad&u=" + C1151o.m8009b(string2.getBytes());
                string = str;
            }
        }
        if (C1091d.m7691a(context, string, hashMap, str2) == 0) {
            return true;
        }
        if (a.m7858b()) {
            if (context != null && context.getApplicationInfo().packageName.equals("com.nd.android.pandahome2") && getTbsVersion(context) < 25487) {
                return false;
            }
            if (a.m7852a().m7768a(context, str, (Map) hashMap, null) == 0) {
                return true;
            }
        }
        return false;
    }

    public static void unForceSysWebView() {
        f4783b = false;
        TbsLog.m7925e("QbSdk", "sys WebView: unForceSysWebView called");
    }

    public static boolean useSoftWare() {
        if (f4790i == null) {
            return false;
        }
        Object a = C1157u.m8042a(f4790i, "useSoftWare", new Class[0], new Object[0]);
        if (a == null) {
            a = C1157u.m8042a(f4790i, "useSoftWare", new Class[]{Integer.TYPE}, Integer.valueOf(C1092a.m7702a()));
        }
        return a == null ? false : ((Boolean) a).booleanValue();
    }
}
