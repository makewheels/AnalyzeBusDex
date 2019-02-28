package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import com.tencent.smtt.export.external.interfaces.IconListener;
import com.tencent.smtt.export.external.libwebp;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.utils.C1135b;
import com.tencent.smtt.utils.TbsLog;
import java.io.InputStream;
import java.util.Map;

class ap {
    /* renamed from: a */
    private Context f4978a = null;
    /* renamed from: b */
    private Context f4979b = null;
    /* renamed from: c */
    private String f4980c = null;
    /* renamed from: d */
    private String[] f4981d = null;
    /* renamed from: e */
    private DexLoader f4982e = null;
    /* renamed from: f */
    private String f4983f = "TbsDexOpt";
    /* renamed from: g */
    private String f4984g = null;

    public ap(Context context, Context context2, String str, String str2, String[] strArr) {
        TbsLog.m7927i("TbsWizard", "construction start...");
        if (context == null || context2 == null || TextUtils.isEmpty(str) || strArr == null || strArr.length == 0) {
            throw new Exception("TbsWizard paramter error:-1");
        }
        this.f4978a = context.getApplicationContext();
        this.f4979b = context2;
        this.f4980c = str;
        this.f4981d = strArr;
        this.f4983f = str2;
        this.f4982e = new DexLoader(this.f4978a, this.f4981d, str2);
        libwebp.loadWepLibraryIfNeed(context2, this.f4980c);
        if ("com.nd.android.pandahome2".equals(this.f4978a.getApplicationInfo().packageName)) {
            this.f4982e.invokeStaticMethod("com.tencent.tbs.common.beacon.X5CoreBeaconUploader", "getInstance", new Class[]{Context.class}, this.f4978a);
        }
        int h = m7765h(context);
        if (h < 0) {
            throw new Exception("TbsWizard init error: " + h + "; msg: " + this.f4984g);
        }
        TbsLog.m7927i("TbsWizard", "construction end...");
    }

    /* renamed from: h */
    private int m7765h(Context context) {
        int i;
        this.f4982e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "putInfo", new Class[]{Context.class, String.class, String.class, String.class, String.class}, context, C1135b.f5119a, C1135b.f5120b, C1135b.f5121c, C1135b.f5122d);
        Object invokeStaticMethod = this.f4982e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[]{Context.class, Context.class, DexLoader.class, String.class, String.class, String.class, Integer.TYPE, String.class}, context, this.f4979b, this.f4982e, this.f4980c, this.f4983f, TbsConfig.TBS_SDK_VERSIONNAME, Integer.valueOf(36509), QbSdk.m7550b());
        if (invokeStaticMethod == null) {
            m7766p();
            m7767q();
            invokeStaticMethod = this.f4982e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[]{Context.class, Context.class, DexLoader.class, String.class, String.class}, context, this.f4979b, this.f4982e, this.f4980c, this.f4983f);
        }
        if (invokeStaticMethod == null) {
            i = -3;
        } else if (invokeStaticMethod instanceof Integer) {
            i = ((Integer) invokeStaticMethod).intValue();
        } else if (invokeStaticMethod instanceof Throwable) {
            TbsCoreLoadStat.getInstance().m7564a(this.f4978a, ErrorCode.THROWABLE_INITTESRUNTIMEENVIRONMENT, (Throwable) invokeStaticMethod);
            i = -5;
        } else {
            i = -4;
        }
        if (i < 0) {
            Object invokeStaticMethod2 = this.f4982e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new Class[0], new Object[0]);
            if (invokeStaticMethod2 instanceof Throwable) {
                Throwable th = (Throwable) invokeStaticMethod2;
                this.f4984g = "#" + th.getMessage() + "; cause: " + th.getCause() + "; th: " + th;
            }
            if (invokeStaticMethod2 instanceof String) {
                this.f4984g = (String) invokeStaticMethod2;
            }
        } else {
            this.f4984g = null;
        }
        return i;
    }

    /* renamed from: p */
    private void m7766p() {
        this.f4982e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "setTesSdkVersionName", new Class[]{String.class}, TbsConfig.TBS_SDK_VERSIONNAME);
    }

    /* renamed from: q */
    private void m7767q() {
        this.f4982e.setStaticField("com.tencent.tbs.tbsshell.TBSShell", "VERSION", Integer.valueOf(36509));
    }

    /* renamed from: a */
    public int m7768a(Context context, String str, Map<String, String> map, String str2) {
        if (TbsDownloader.getOverSea(context)) {
            return -1;
        }
        Object invokeStaticMethod;
        if (str2 == null) {
            invokeStaticMethod = this.f4982e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[]{Context.class, String.class, Map.class}, context, str, map);
            if (invokeStaticMethod == null) {
                invokeStaticMethod = this.f4982e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[]{Context.class, String.class}, context, str);
            }
            return invokeStaticMethod == null ? -3 : ((Integer) invokeStaticMethod).intValue();
        } else {
            invokeStaticMethod = this.f4982e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[]{Context.class, String.class, String.class}, context, str, str2);
            return invokeStaticMethod == null ? -3 : ((Integer) invokeStaticMethod).intValue();
        }
    }

    /* renamed from: a */
    public IX5WebViewBase m7769a(Context context) {
        IX5WebViewBase iX5WebViewBase;
        Exception e;
        IX5WebViewBase iX5WebViewBase2;
        Object invokeStaticMethod = this.f4982e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createSDKWebview", new Class[]{Context.class}, context);
        if (invokeStaticMethod == null) {
            try {
                Object invokeStaticMethod2 = this.f4982e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new Class[0], new Object[0]);
                if (invokeStaticMethod2 != null && (invokeStaticMethod2 instanceof Throwable)) {
                    TbsCoreLoadStat.getInstance().m7564a(context, ErrorCode.THROWABLE_INITX5CORE, (Throwable) invokeStaticMethod2);
                }
                if (invokeStaticMethod2 != null && (invokeStaticMethod2 instanceof String)) {
                    TbsCoreLoadStat.getInstance().m7564a(context, ErrorCode.THROWABLE_INITX5CORE, new Throwable((String) invokeStaticMethod2));
                }
                iX5WebViewBase = null;
                invokeStaticMethod = null;
            } catch (Exception e2) {
                e = e2;
                iX5WebViewBase2 = null;
                e.printStackTrace();
                iX5WebViewBase = iX5WebViewBase2;
                return invokeStaticMethod == null ? null : iX5WebViewBase;
            }
        } else {
            iX5WebViewBase = (IX5WebViewBase) invokeStaticMethod;
            if (iX5WebViewBase != null) {
                try {
                    if (iX5WebViewBase.getView() == null) {
                        TbsCoreLoadStat.getInstance().m7564a(context, ErrorCode.THROWABLE_INITX5CORE, new Throwable("x5webview.getView is null!"));
                        invokeStaticMethod = null;
                    }
                } catch (Exception e3) {
                    Exception exception = e3;
                    iX5WebViewBase2 = iX5WebViewBase;
                    e = exception;
                    e.printStackTrace();
                    iX5WebViewBase = iX5WebViewBase2;
                    if (invokeStaticMethod == null) {
                    }
                }
            }
        }
        if (invokeStaticMethod == null) {
        }
    }

    /* renamed from: a */
    public InputStream m7770a(String str, boolean z) {
        Object invokeStaticMethod = this.f4982e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getCacheFile", new Class[]{String.class, Boolean.TYPE}, str, Boolean.valueOf(z));
        return invokeStaticMethod == null ? null : (InputStream) invokeStaticMethod;
    }

    /* renamed from: a */
    public Object m7771a() {
        return this.f4982e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cacheDisabled", new Class[0], new Object[0]);
    }

    /* renamed from: a */
    public String m7772a(String str) {
        Object invokeStaticMethod = this.f4982e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getCookie", new Class[]{String.class}, str);
        return invokeStaticMethod == null ? null : (String) invokeStaticMethod;
    }

    /* renamed from: a */
    public void m7773a(Context context, boolean z) {
        Log.e("desktop", " tbsWizard clearAllX5Cache");
        if (z) {
            this.f4982e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "clearAllCache", new Class[]{Context.class}, context);
            return;
        }
        try {
            this.f4982e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "clearAllCache", new Class[]{Context.class, Boolean.TYPE}, context, Boolean.valueOf(z));
        } catch (Exception e) {
            this.f4982e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearUsernamePassword", new Class[]{Context.class}, context);
            this.f4982e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearHttpAuthUsernamePassword", new Class[]{Context.class}, context);
            this.f4982e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearFormData", new Class[]{Context.class}, context);
            this.f4982e.invokeStaticMethod("com.tencent.smtt.webkit.CacheManager", "removeAllCacheFiles", null, new Object[0]);
            this.f4982e.invokeStaticMethod("com.tencent.smtt.webkit.CacheManager", "clearLocalStorage", null, new Object[0]);
            Object invokeStaticMethod = this.f4982e.invokeStaticMethod("com.tencent.smtt.net.http.DnsManager", "getInstance", null, new Object[0]);
            if (invokeStaticMethod != null) {
                this.f4982e.invokeMethod(invokeStaticMethod, "com.tencent.smtt.net.http.DnsManager", "removeAllDns", null, new Object[0]);
            }
            invokeStaticMethod = this.f4982e.invokeStaticMethod("com.tencent.smtt.webkit.SmttPermanentPermissions", "getInstance", null, new Object[0]);
            if (invokeStaticMethod != null) {
                this.f4982e.invokeMethod(invokeStaticMethod, "com.tencent.smtt.webkit.SmttPermanentPermissions", "clearAllPermanentPermission", null, new Object[0]);
            }
            this.f4982e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "removeAllIcons", null, new Object[0]);
        }
    }

    /* renamed from: a */
    public void m7774a(ValueCallback<Map> valueCallback) {
        this.f4982e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageGetOrigins", new Class[]{ValueCallback.class}, valueCallback);
    }

    /* renamed from: a */
    public void m7775a(String str, long j) {
        this.f4982e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageSetQuotaForOrigin", new Class[]{String.class, Long.TYPE}, str, Long.valueOf(j));
    }

    /* renamed from: a */
    public void m7776a(String str, ValueCallback<Long> valueCallback) {
        this.f4982e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageGetUsageForOrigin", new Class[]{String.class, ValueCallback.class}, str, valueCallback);
    }

    /* renamed from: a */
    public void m7777a(String str, IconListener iconListener) {
        this.f4982e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "requestIconForPageUrl", new Class[]{String.class, IconListener.class}, str, iconListener);
    }

    /* renamed from: a */
    public boolean m7778a(Context context, String str) {
        Object invokeStaticMethod = this.f4982e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "canOpenFile", new Class[]{Context.class, String.class}, context, str);
        return invokeStaticMethod instanceof Boolean ? ((Boolean) invokeStaticMethod).booleanValue() : false;
    }

    /* renamed from: a */
    public boolean m7779a(Context context, String str, String str2, Bundle bundle) {
        Object invokeStaticMethod = this.f4982e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "installLocalQbApk", new Class[]{Context.class, String.class, String.class, Bundle.class}, context, str, str2, bundle);
        return invokeStaticMethod == null ? false : ((Boolean) invokeStaticMethod).booleanValue();
    }

    /* renamed from: a */
    public boolean m7780a(Map<String, String[]> map) {
        Object invokeStaticMethod = this.f4982e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookies", new Class[]{Map.class}, map);
        return invokeStaticMethod == null ? false : ((Boolean) invokeStaticMethod).booleanValue();
    }

    /* renamed from: a */
    public Uri[] m7781a(int i, Intent intent) {
        Object invokeStaticMethod = this.f4982e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "parseFileChooserResult", new Class[]{Integer.TYPE, Intent.class}, Integer.valueOf(i), intent);
        return invokeStaticMethod == null ? null : (Uri[]) invokeStaticMethod;
    }

    /* renamed from: b */
    public void m7782b(String str) {
        this.f4982e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "openIconDB", new Class[]{String.class}, str);
    }

    /* renamed from: b */
    public void m7783b(String str, ValueCallback<Long> valueCallback) {
        this.f4982e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageGetQuotaForOrigin", new Class[]{String.class, ValueCallback.class}, str, valueCallback);
    }

    /* renamed from: b */
    public boolean m7784b() {
        Object invokeStaticMethod = this.f4982e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_acceptCookie", new Class[0], new Object[0]);
        return invokeStaticMethod == null ? false : ((Boolean) invokeStaticMethod).booleanValue();
    }

    /* renamed from: b */
    public boolean m7785b(Context context) {
        Object invokeStaticMethod = this.f4982e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseHasUsernamePassword", new Class[]{Context.class}, context);
        return invokeStaticMethod == null ? false : ((Boolean) invokeStaticMethod).booleanValue();
    }

    /* renamed from: c */
    public void m7786c() {
        this.f4982e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeAllCookie", new Class[0], new Object[0]);
    }

    /* renamed from: c */
    public void m7787c(Context context) {
        this.f4982e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearUsernamePassword", new Class[]{Context.class}, context);
    }

    /* renamed from: c */
    public void m7788c(String str) {
        this.f4982e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "retainIconForPageUrl", new Class[]{String.class}, str);
    }

    /* renamed from: d */
    public String m7789d() {
        Object invokeStaticMethod = this.f4982e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getMiniQBVersion", new Class[0], new Object[0]);
        return invokeStaticMethod == null ? null : (String) invokeStaticMethod;
    }

    /* renamed from: d */
    public void m7790d(String str) {
        this.f4982e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "releaseIconForPageUrl", new Class[]{String.class}, str);
    }

    /* renamed from: d */
    public boolean m7791d(Context context) {
        Object invokeStaticMethod = this.f4982e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseHasHttpAuthUsernamePassword", new Class[]{Context.class}, context);
        return invokeStaticMethod == null ? false : ((Boolean) invokeStaticMethod).booleanValue();
    }

    /* renamed from: e */
    public Object m7792e() {
        return this.f4982e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getCachFileBaseDir", new Class[0], new Object[0]);
    }

    /* renamed from: e */
    public void m7793e(Context context) {
        this.f4982e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearHttpAuthUsernamePassword", new Class[]{Context.class}, context);
    }

    /* renamed from: e */
    public void m7794e(String str) {
        this.f4982e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageDeleteOrigin", new Class[]{String.class}, str);
    }

    /* renamed from: f */
    public boolean m7795f() {
        Object invokeStaticMethod = this.f4982e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_hasCookies", new Class[0], new Object[0]);
        return invokeStaticMethod == null ? false : ((Boolean) invokeStaticMethod).booleanValue();
    }

    /* renamed from: f */
    public boolean m7796f(Context context) {
        Object invokeStaticMethod = this.f4982e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseHasFormData", new Class[]{Context.class}, context);
        return invokeStaticMethod == null ? false : ((Boolean) invokeStaticMethod).booleanValue();
    }

    /* renamed from: g */
    public IX5WebChromeClient m7797g() {
        Object invokeStaticMethod = this.f4982e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebChromeClient", new Class[0], new Object[0]);
        return invokeStaticMethod == null ? null : (IX5WebChromeClient) invokeStaticMethod;
    }

    /* renamed from: g */
    public void m7798g(Context context) {
        this.f4982e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearFormData", new Class[]{Context.class}, context);
    }

    /* renamed from: h */
    public IX5WebViewClient m7799h() {
        Object invokeStaticMethod = this.f4982e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebViewClient", new Class[0], new Object[0]);
        return invokeStaticMethod == null ? null : (IX5WebViewClient) invokeStaticMethod;
    }

    /* renamed from: i */
    public IX5WebViewClientExtension m7800i() {
        Object invokeStaticMethod = this.f4982e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebChromeClientExtension", new Class[0], new Object[0]);
        return invokeStaticMethod == null ? null : (IX5WebViewClientExtension) invokeStaticMethod;
    }

    /* renamed from: j */
    public void m7801j() {
        this.f4982e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "removeAllIcons", null, new Object[0]);
    }

    /* renamed from: k */
    public void m7802k() {
        this.f4982e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "closeIconDB", null, new Object[0]);
    }

    /* renamed from: l */
    public void m7803l() {
        this.f4982e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageDeleteAllData", null, new Object[0]);
    }

    /* renamed from: m */
    public String m7804m() {
        String str = null;
        Object invokeStaticMethod = this.f4982e.invokeStaticMethod("com.tencent.smtt.util.CrashTracker", "getCrashExtraInfo", null, new Object[0]);
        Object invokeStaticMethod2 = this.f4982e.invokeStaticMethod("com.tencent.mtt.video.internal.media.WonderPlayer", "getVersion", null, new Object[0]);
        if (invokeStaticMethod != null) {
            str = invokeStaticMethod2 != null ? String.valueOf(invokeStaticMethod) + " ReaderPackName=" + TbsReaderView.gReaderPackName + " ReaderPackVersion=" + TbsReaderView.gReaderPackVersion + " WonderPlayVersion=" + String.valueOf(invokeStaticMethod2) : String.valueOf(invokeStaticMethod) + " ReaderPackName=" + TbsReaderView.gReaderPackName + " ReaderPackVersion=" + TbsReaderView.gReaderPackVersion;
        }
        return str == null ? "X5 core get nothing..." : str;
    }

    /* renamed from: n */
    public void m7805n() {
        this.f4982e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "closeFileReader", new Class[0], new Object[0]);
    }

    /* renamed from: o */
    public DexLoader m7806o() {
        return this.f4982e;
    }
}
