package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.net.http.SslCertificate;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebSettingsExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.FindListener;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.sdk.p051a.C1086b;
import com.tencent.smtt.utils.C1138d;
import com.tencent.smtt.utils.C1157u;
import com.tencent.smtt.utils.C1160x;
import com.tencent.smtt.utils.TbsLog;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.channels.FileLock;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import p054u.aly.bi_常量类;

public class WebView extends FrameLayout implements OnLongClickListener {
    public static final int GETPVERROR = -1;
    public static int NIGHT_MODE_ALPHA = 153;
    public static final int NIGHT_MODE_COLOR = -16777216;
    public static final int NORMAL_MODE_ALPHA = 255;
    public static final String SCHEME_GEO = "geo:0,0?q=";
    public static final String SCHEME_MAILTO = "mailto:";
    public static final String SCHEME_TEL = "tel:";
    public static String TBS_DEBUG_INSTALL_ONLINE = "tbsdebug_install_online_";
    /* renamed from: b */
    static boolean f4894b = false;
    /* renamed from: d */
    private static final Lock f4895d = new ReentrantLock();
    /* renamed from: e */
    private static OutputStream f4896e = null;
    /* renamed from: k */
    private static Context f4897k = null;
    public static boolean mSysWebviewCreated = false;
    /* renamed from: o */
    private static C1160x f4898o = null;
    /* renamed from: p */
    private static Method f4899p = null;
    /* renamed from: q */
    private static String f4900q = null;
    /* renamed from: w */
    private static Paint f4901w = null;
    /* renamed from: x */
    private static boolean f4902x = true;
    /* renamed from: a */
    int f4903a;
    /* renamed from: c */
    private final String f4904c;
    /* renamed from: f */
    private boolean f4905f;
    /* renamed from: g */
    private IX5WebViewBase f4906g;
    /* renamed from: h */
    private C1084a f4907h;
    /* renamed from: i */
    private WebSettings f4908i;
    /* renamed from: j */
    private Context f4909j;
    /* renamed from: l */
    private boolean f4910l;
    /* renamed from: m */
    private boolean f4911m;
    public WebViewCallbackClient mWebViewCallbackClient;
    /* renamed from: n */
    private WebViewClient f4912n;
    /* renamed from: r */
    private final int f4913r;
    /* renamed from: s */
    private final int f4914s;
    /* renamed from: t */
    private final int f4915t;
    /* renamed from: u */
    private final String f4916u;
    /* renamed from: v */
    private final String f4917v;
    /* renamed from: y */
    private Object f4918y;
    /* renamed from: z */
    private OnLongClickListener f4919z;

    public static class HitTestResult {
        @Deprecated
        public static final int ANCHOR_TYPE = 1;
        public static final int EDIT_TEXT_TYPE = 9;
        public static final int EMAIL_TYPE = 4;
        public static final int GEO_TYPE = 3;
        @Deprecated
        public static final int IMAGE_ANCHOR_TYPE = 6;
        public static final int IMAGE_TYPE = 5;
        public static final int PHONE_TYPE = 2;
        public static final int SRC_ANCHOR_TYPE = 7;
        public static final int SRC_IMAGE_ANCHOR_TYPE = 8;
        public static final int UNKNOWN_TYPE = 0;
        /* renamed from: a */
        private com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult f4889a;
        /* renamed from: b */
        private android.webkit.WebView.HitTestResult f4890b;

        public HitTestResult() {
            this.f4890b = null;
            this.f4889a = null;
            this.f4890b = null;
        }

        public HitTestResult(android.webkit.WebView.HitTestResult hitTestResult) {
            this.f4890b = null;
            this.f4889a = null;
            this.f4890b = hitTestResult;
        }

        public HitTestResult(com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult hitTestResult) {
            this.f4890b = null;
            this.f4889a = hitTestResult;
            this.f4890b = null;
        }

        public String getExtra() {
            return this.f4889a != null ? this.f4889a.getExtra() : this.f4890b != null ? this.f4890b.getExtra() : bi_常量类.f6358b;
        }

        public int getType() {
            return this.f4889a != null ? this.f4889a.getType() : this.f4890b != null ? this.f4890b.getType() : 0;
        }
    }

    public interface PictureListener {
        void onNewPicture(WebView webView, Picture picture);
    }

    public class WebViewTransport {
        /* renamed from: a */
        final /* synthetic */ WebView f4891a;
        /* renamed from: b */
        private WebView f4892b;

        public WebViewTransport(WebView webView) {
            this.f4891a = webView;
        }

        public synchronized WebView getWebView() {
            return this.f4892b;
        }

        public synchronized void setWebView(WebView webView) {
            this.f4892b = webView;
        }
    }

    /* renamed from: com.tencent.smtt.sdk.WebView$a */
    private class C1084a extends android.webkit.WebView {
        /* renamed from: a */
        final /* synthetic */ WebView f4893a;

        public C1084a(WebView webView, Context context) {
            this(webView, context, null);
        }

        public C1084a(WebView webView, Context context, AttributeSet attributeSet) {
            this.f4893a = webView;
            super(context, attributeSet);
            CookieSyncManager.createInstance(webView.f4909j).startSync();
            try {
                Method declaredMethod = Class.forName("android.webkit.WebViewWorker").getDeclaredMethod("getHandler", new Class[0]);
                declaredMethod.setAccessible(true);
                ((Handler) declaredMethod.invoke(null, new Object[0])).getLooper().getThread().setUncaughtExceptionHandler(new C1111j());
                WebView.mSysWebviewCreated = true;
            } catch (Exception e) {
            }
        }

        /* renamed from: a */
        public void m7651a() {
            super.computeScroll();
        }

        /* renamed from: a */
        public void m7652a(int i, int i2, int i3, int i4) {
            super.onScrollChanged(i, i2, i3, i4);
        }

        @TargetApi(9)
        /* renamed from: a */
        public void m7653a(int i, int i2, boolean z, boolean z2) {
            if (VERSION.SDK_INT >= 9) {
                super.onOverScrolled(i, i2, z, z2);
            }
        }

        @TargetApi(9)
        /* renamed from: a */
        public boolean m7654a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            return VERSION.SDK_INT >= 9 ? super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z) : false;
        }

        /* renamed from: a */
        public boolean m7655a(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        /* renamed from: b */
        public boolean m7656b(MotionEvent motionEvent) {
            return super.dispatchTouchEvent(motionEvent);
        }

        /* renamed from: c */
        public boolean m7657c(MotionEvent motionEvent) {
            return super.onInterceptTouchEvent(motionEvent);
        }

        public void computeScroll() {
            if (this.f4893a.mWebViewCallbackClient != null) {
                this.f4893a.mWebViewCallbackClient.computeScroll(this);
            } else {
                super.computeScroll();
            }
        }

        protected void dispatchDraw(Canvas canvas) {
            try {
                super.dispatchDraw(canvas);
                if (!WebView.f4902x && WebView.f4901w != null) {
                    canvas.save();
                    canvas.drawPaint(WebView.f4901w);
                    canvas.restore();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return this.f4893a.mWebViewCallbackClient != null ? this.f4893a.mWebViewCallbackClient.dispatchTouchEvent(motionEvent, this) : super.dispatchTouchEvent(motionEvent);
        }

        public WebSettings getSettings() {
            try {
                return super.getSettings();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return this.f4893a.mWebViewCallbackClient != null ? this.f4893a.mWebViewCallbackClient.onInterceptTouchEvent(motionEvent, this) : super.onInterceptTouchEvent(motionEvent);
        }

        @TargetApi(9)
        public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
            if (this.f4893a.mWebViewCallbackClient != null) {
                this.f4893a.mWebViewCallbackClient.onOverScrolled(i, i2, z, z2, this);
            } else if (VERSION.SDK_INT >= 9) {
                super.onOverScrolled(i, i2, z, z2);
            }
        }

        protected void onScrollChanged(int i, int i2, int i3, int i4) {
            if (this.f4893a.mWebViewCallbackClient != null) {
                this.f4893a.mWebViewCallbackClient.onScrollChanged(i, i2, i3, i4, this);
                return;
            }
            super.onScrollChanged(i, i2, i3, i4);
            this.f4893a.onScrollChanged(i, i2, i3, i4);
        }

        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (!hasFocus()) {
                requestFocus();
            }
            if (this.f4893a.mWebViewCallbackClient != null) {
                return this.f4893a.mWebViewCallbackClient.onTouchEvent(motionEvent, this);
            }
            try {
                return super.onTouchEvent(motionEvent);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        @TargetApi(9)
        public boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            return this.f4893a.mWebViewCallbackClient != null ? this.f4893a.mWebViewCallbackClient.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z, this) : VERSION.SDK_INT >= 9 ? super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z) : false;
        }
    }

    public WebView(Context context) {
        this(context, null);
    }

    public WebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WebView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, false);
    }

    @TargetApi(11)
    public WebView(Context context, AttributeSet attributeSet, int i, Map<String, Object> map, boolean z) {
        super(context, attributeSet, i);
        this.f4904c = "WebView";
        this.f4905f = false;
        this.f4908i = null;
        this.f4909j = null;
        this.f4903a = 0;
        this.f4910l = false;
        this.f4911m = false;
        this.f4912n = null;
        this.f4913r = 1;
        this.f4914s = 2;
        this.f4915t = 3;
        this.f4916u = "javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));";
        this.f4917v = "javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);";
        this.f4918y = null;
        this.f4919z = null;
        if (context == null) {
            f4894b = this.f4905f;
            throw new IllegalArgumentException("Invalid context argument");
        }
        if (f4898o == null) {
            f4898o = C1160x.m8066a(context);
        }
        if (f4898o.f5179a) {
            TbsLog.m7926e("WebView", "sys WebView: debug.conf force syswebview", true);
            QbSdk.f4786e.onCallBackErrorCode(1002, ErrorCode.INFO_ERROR_FORCE_SYSWEBVIEW);
            QbSdk.m7544a();
        }
        m7665c(context);
        this.f4909j = context;
        if (context != null) {
            f4897k = context.getApplicationContext();
        }
        if (this.f4905f) {
            this.f4906g = C1110i.m7845a(true).m7852a().m7769a(context);
            if (this.f4906g == null || this.f4906g.getView() == null) {
                TbsLog.m7926e("WebView", "sys WebView: failed to createTBSWebview", true);
                this.f4906g = null;
                this.f4905f = false;
                TbsCoreLoadStat.getInstance().m7563a(context, (int) ErrorCode.ERROR_FORCE_SYSTEM_WEBVIEW_INNER_FAILED_TO_CREATE);
                TbsCoreLoadStat.getInstance().m7563a(context, (int) ErrorCode.INFO_CAN_NOT_LOAD_TBS);
                QbSdk.f4786e.onCallBackErrorCode(ErrorCode.ERROR_FORCE_SYSTEM_WEBVIEW_INNER_FAILED_TO_CREATE, ErrorCode.INFO_ERROR_FORCE_SYSTEM_WEBVIEW_INNER_FAILED_TO_CREATE);
                QbSdk.m7544a();
                m7665c(context);
                if (TbsShareManager.isThirdPartyApp(this.f4909j)) {
                    this.f4907h = new C1084a(this, context, attributeSet);
                } else {
                    this.f4907h = new C1084a(this, context);
                }
                TbsLog.m7927i("WebView", "SystemWebView Created Success! #1");
                this.f4907h.setFocusableInTouchMode(true);
                addView(this.f4907h, new LayoutParams(-1, -1));
                try {
                    if (VERSION.SDK_INT >= 11) {
                        removeJavascriptInterface("searchBoxJavaBridge_");
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                f4894b = this.f4905f;
                return;
            }
            TbsLog.m7927i("WebView", "X5 WebView Created Success!!");
            this.f4906g.getView().setFocusableInTouchMode(true);
            m7659a(attributeSet);
            addView(this.f4906g.getView(), new LayoutParams(-1, -1));
            this.f4906g.setDownloadListener(new C1103b(this, null, this.f4905f));
            this.f4906g.getX5WebViewExtension().setWebViewClientExtension(new at(this, C1110i.m7845a(false).m7857b(true).m7800i()));
        } else {
            this.f4906g = null;
            this.f4905f = false;
            QbSdk.m7544a();
            if (TbsShareManager.isThirdPartyApp(this.f4909j)) {
                this.f4907h = new C1084a(this, context, attributeSet);
            } else {
                this.f4907h = new C1084a(this, context);
            }
            TbsLog.m7927i("WebView", "SystemWebView Created Success! #2");
            this.f4907h.setFocusableInTouchMode(true);
            addView(this.f4907h, new LayoutParams(-1, -1));
            setDownloadListener(null);
        }
        try {
            if (VERSION.SDK_INT >= 11) {
                removeJavascriptInterface("searchBoxJavaBridge_");
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        if ((TbsConfig.APP_QQ.equals(this.f4909j.getApplicationInfo().packageName) || "com.tencent.mm".equals(this.f4909j.getApplicationInfo().packageName)) && C1110i.m7845a(true).m7864h() && VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
        f4894b = this.f4905f;
    }

    public WebView(Context context, AttributeSet attributeSet, int i, boolean z) {
        this(context, attributeSet, i, null, z);
    }

    /* renamed from: a */
    private void m7659a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            try {
                int attributeCount = attributeSet.getAttributeCount();
                for (int i = 0; i < attributeCount; i++) {
                    if (attributeSet.getAttributeName(i).equalsIgnoreCase("scrollbars")) {
                        int[] intArray = getResources().getIntArray(16842974);
                        int attributeIntValue = attributeSet.getAttributeIntValue(i, -1);
                        if (attributeIntValue == intArray[1]) {
                            this.f4906g.getView().setVerticalScrollBarEnabled(false);
                            this.f4906g.getView().setHorizontalScrollBarEnabled(false);
                        } else if (attributeIntValue == intArray[2]) {
                            this.f4906g.getView().setVerticalScrollBarEnabled(false);
                        } else if (attributeIntValue == intArray[3]) {
                            this.f4906g.getView().setHorizontalScrollBarEnabled(false);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private boolean m7661a(View view) {
        if (this.f4909j != null && getTbsCoreVersion(this.f4909j) > 36200) {
            return false;
        }
        Object a = C1157u.m8042a(this.f4918y, "onLongClick", new Class[]{View.class}, view);
        return a != null ? ((Boolean) a).booleanValue() : false;
    }

    /* renamed from: b */
    private boolean m7663b(Context context) {
        try {
            if (context.getPackageName().indexOf(TbsConfig.APP_QQ) >= 0) {
                return true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    /* renamed from: c */
    static void m7664c() {
        if (f4897k != null) {
            C1110i a = C1110i.m7845a(true);
            if (!C1110i.f5034a) {
                C1131y a2 = C1131y.m7904a(f4897k);
                int i = a2.m7921i();
                if (i == 2) {
                    a.m7856a(String.valueOf(a2.m7920h()));
                    a.m7860c(true);
                    return;
                }
                int b = a2.m7910b();
                if (b == 1) {
                    a.m7856a(String.valueOf(a2.m7906a()));
                    a.m7860c(true);
                } else if (!a.m7858b()) {
                    if (i == 3 || b == 3) {
                        a.m7856a(String.valueOf(C1110i.m7849d()));
                        a.m7860c(true);
                    }
                }
            }
        }
    }

    /* renamed from: c */
    private void m7665c(Context context) {
        C1110i a = C1110i.m7845a(true);
        a.m7853a(context);
        this.f4905f = a.m7858b();
    }

    /* renamed from: d */
    private int m7666d(Context context) {
        Exception e;
        Throwable th;
        int i = -1;
        FileOutputStream k = ac.m7723k(context);
        if (k != null) {
            FileLock a = ac.m7707a(context, k);
            if (a != null) {
                if (f4895d.tryLock()) {
                    FileInputStream fileInputStream = null;
                    FileInputStream fileInputStream2;
                    try {
                        File file = new File(context.getDir("tbs", 0) + File.separator + "core_private", "pv.db");
                        if (file == null || !file.exists()) {
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e2) {
                                    TbsLog.m7925e("getTbsCorePV", "TbsInstaller--getTbsCorePV IOException=" + e2.toString());
                                }
                            }
                            f4895d.unlock();
                            ac.m7712a(a, k);
                        } else {
                            Properties properties = new Properties();
                            fileInputStream2 = new FileInputStream(file);
                            try {
                                properties.load(fileInputStream2);
                                fileInputStream2.close();
                                String property = properties.getProperty("PV");
                                if (property == null) {
                                    if (fileInputStream2 != null) {
                                        try {
                                            fileInputStream2.close();
                                        } catch (IOException e22) {
                                            TbsLog.m7925e("getTbsCorePV", "TbsInstaller--getTbsCorePV IOException=" + e22.toString());
                                        }
                                    }
                                    f4895d.unlock();
                                    ac.m7712a(a, k);
                                } else {
                                    i = Integer.parseInt(property);
                                    if (fileInputStream2 != null) {
                                        try {
                                            fileInputStream2.close();
                                        } catch (IOException e222) {
                                            TbsLog.m7925e("getTbsCorePV", "TbsInstaller--getTbsCorePV IOException=" + e222.toString());
                                        }
                                    }
                                    f4895d.unlock();
                                    ac.m7712a(a, k);
                                }
                            } catch (Exception e3) {
                                e = e3;
                                try {
                                    TbsLog.m7925e("getTbsCorePV", "TbsInstaller--getTbsCorePV Exception=" + e.toString());
                                    if (fileInputStream2 != null) {
                                        try {
                                            fileInputStream2.close();
                                        } catch (IOException e2222) {
                                            TbsLog.m7925e("getTbsCorePV", "TbsInstaller--getTbsCorePV IOException=" + e2222.toString());
                                        }
                                    }
                                    f4895d.unlock();
                                    ac.m7712a(a, k);
                                    return i;
                                } catch (Throwable th2) {
                                    th = th2;
                                    fileInputStream = fileInputStream2;
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (IOException e22222) {
                                            TbsLog.m7925e("getTbsCorePV", "TbsInstaller--getTbsCorePV IOException=" + e22222.toString());
                                        }
                                    }
                                    f4895d.unlock();
                                    ac.m7712a(a, k);
                                    throw th;
                                }
                            }
                        }
                    } catch (Exception e4) {
                        e = e4;
                        fileInputStream2 = fileInputStream;
                        TbsLog.m7925e("getTbsCorePV", "TbsInstaller--getTbsCorePV Exception=" + e.toString());
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        f4895d.unlock();
                        ac.m7712a(a, k);
                        return i;
                    } catch (Throwable th3) {
                        th = th3;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        f4895d.unlock();
                        ac.m7712a(a, k);
                        throw th;
                    }
                }
                ac.m7712a(a, k);
            }
        }
        return i;
    }

    @Deprecated
    public static void disablePlatformNotifications() {
        if (C1110i.m7845a(false) == null || !C1110i.m7845a(false).m7858b()) {
            C1157u.m8043a("android.webkit.WebView", "disablePlatformNotifications");
        }
    }

    /* renamed from: e */
    private void m7669e(Context context) {
        try {
            File file = new File(context.getDir("tbs", 0) + File.separator + "core_private", "pv.db");
            if (file != null && file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            TbsLog.m7927i("getTbsCorePV", "TbsInstaller--getTbsCorePV Exception=" + e.toString());
        }
    }

    @Deprecated
    public static void enablePlatformNotifications() {
        if (C1110i.m7845a(false) == null || !C1110i.m7845a(false).m7858b()) {
            C1157u.m8043a("android.webkit.WebView", "enablePlatformNotifications");
        }
    }

    public static String findAddress(String str) {
        return (C1110i.m7845a(false) == null || C1110i.m7845a(false).m7858b()) ? null : android.webkit.WebView.findAddress(str);
    }

    public static String getCrashExtraMessage(Context context) {
        String str = "tbs_core_version:" + QbSdk.getTbsVersion(context) + ";" + "tbs_sdk_version:" + 36509 + ";";
        if (TbsShareManager.isThirdPartyApp(context)) {
            return "nothing return ^-^." + str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(C1110i.m7845a(true).m7861e());
        stringBuilder.append("\n");
        stringBuilder.append(str);
        return stringBuilder.length() > 8192 ? stringBuilder.substring(stringBuilder.length() - 8192) : stringBuilder.toString();
    }

    @Deprecated
    public static synchronized Object getPluginList() {
        Object a;
        synchronized (WebView.class) {
            a = (C1110i.m7845a(false) == null || C1110i.m7845a(false).m7858b()) ? null : C1157u.m8043a("android.webkit.WebView", "getPluginList");
        }
        return a;
    }

    public static int getTbsCoreVersion(Context context) {
        return QbSdk.getTbsVersion(context);
    }

    public static boolean getTbsNeedReboot() {
        m7664c();
        return C1110i.m7845a(true).m7862f();
    }

    public static int getTbsSDKVersion(Context context) {
        return 36509;
    }

    public static synchronized void setSysDayOrNight(boolean z) {
        synchronized (WebView.class) {
            if (z != f4902x) {
                f4902x = z;
                if (f4901w == null) {
                    f4901w = new Paint();
                    f4901w.setColor(-16777216);
                }
                if (z) {
                    if (f4901w.getAlpha() != NORMAL_MODE_ALPHA) {
                        f4901w.setAlpha(NORMAL_MODE_ALPHA);
                    }
                } else if (f4901w.getAlpha() != NIGHT_MODE_ALPHA) {
                    f4901w.setAlpha(NIGHT_MODE_ALPHA);
                }
            }
        }
    }

    public static void setWebContentsDebuggingEnabled(boolean z) {
        if (VERSION.SDK_INT >= 19) {
            try {
                f4899p = Class.forName("android.webkit.WebView").getDeclaredMethod("setWebContentsDebuggingEnabled", new Class[]{Boolean.TYPE});
                if (f4899p != null) {
                    f4899p.setAccessible(true);
                    f4899p.invoke(null, new Object[]{Boolean.valueOf(z)});
                }
            } catch (Exception e) {
                TbsLog.m7925e("QbSdk", "Exception:" + e.getStackTrace());
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    android.webkit.WebView m7670a() {
        return !this.f4905f ? this.f4907h : null;
    }

    /* renamed from: a */
    void m7671a(Context context) {
        String str;
        int d = m7666d(context);
        if (d != -1) {
            str = "PV=" + String.valueOf(d + 1);
        } else {
            str = "PV=1";
        }
        File file = new File(context.getDir("tbs", 0) + File.separator + "core_private", "pv.db");
        if (file != null) {
            try {
                file.getParentFile().mkdirs();
                if (!(file.isFile() && file.exists())) {
                    file.createNewFile();
                }
                f4896e = new FileOutputStream(file, false);
                f4896e.write(str.getBytes());
                if (f4896e != null) {
                    f4896e.flush();
                }
            } catch (Throwable th) {
            }
        }
    }

    /* renamed from: a */
    void m7672a(android.webkit.WebView webView) {
        if (!this.f4905f) {
        }
    }

    /* renamed from: a */
    void m7673a(IX5WebViewBase iX5WebViewBase) {
        this.f4906g = iX5WebViewBase;
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (this.f4905f) {
            this.f4906g.addJavascriptInterface(obj, str);
        } else {
            this.f4907h.addJavascriptInterface(obj, str);
        }
    }

    public void addView(View view) {
        if (this.f4905f) {
            View view2 = this.f4906g.getView();
            try {
                Method a = C1157u.m8044a(view2, "addView", View.class);
                a.setAccessible(true);
                a.invoke(view2, new Object[]{view});
                return;
            } catch (Throwable th) {
                return;
            }
        }
        this.f4907h.addView(view);
    }

    /* renamed from: b */
    IX5WebViewBase m7674b() {
        return this.f4906g;
    }

    public boolean canGoBack() {
        return !this.f4905f ? this.f4907h.canGoBack() : this.f4906g.canGoBack();
    }

    public boolean canGoBackOrForward(int i) {
        return !this.f4905f ? this.f4907h.canGoBackOrForward(i) : this.f4906g.canGoBackOrForward(i);
    }

    public boolean canGoForward() {
        return !this.f4905f ? this.f4907h.canGoForward() : this.f4906g.canGoForward();
    }

    @Deprecated
    public boolean canZoomIn() {
        if (this.f4905f) {
            return this.f4906g.canZoomIn();
        }
        if (VERSION.SDK_INT < 11) {
            return false;
        }
        Object a = C1157u.m8041a(this.f4907h, "canZoomIn");
        return a == null ? false : ((Boolean) a).booleanValue();
    }

    @Deprecated
    public boolean canZoomOut() {
        if (this.f4905f) {
            return this.f4906g.canZoomOut();
        }
        if (VERSION.SDK_INT < 11) {
            return false;
        }
        Object a = C1157u.m8041a(this.f4907h, "canZoomOut");
        return a == null ? false : ((Boolean) a).booleanValue();
    }

    @Deprecated
    public Picture capturePicture() {
        if (this.f4905f) {
            return this.f4906g.capturePicture();
        }
        Object a = C1157u.m8041a(this.f4907h, "capturePicture");
        return a == null ? null : (Picture) a;
    }

    public void clearCache(boolean z) {
        if (this.f4905f) {
            this.f4906g.clearCache(z);
        } else {
            this.f4907h.clearCache(z);
        }
    }

    public void clearFormData() {
        if (this.f4905f) {
            this.f4906g.clearFormData();
        } else {
            this.f4907h.clearFormData();
        }
    }

    public void clearHistory() {
        if (this.f4905f) {
            this.f4906g.clearHistory();
        } else {
            this.f4907h.clearHistory();
        }
    }

    @TargetApi(3)
    public void clearMatches() {
        if (this.f4905f) {
            this.f4906g.clearMatches();
        } else {
            this.f4907h.clearMatches();
        }
    }

    public void clearSslPreferences() {
        if (this.f4905f) {
            this.f4906g.clearSslPreferences();
        } else {
            this.f4907h.clearSslPreferences();
        }
    }

    @Deprecated
    public void clearView() {
        if (this.f4905f) {
            this.f4906g.clearView();
        } else {
            C1157u.m8041a(this.f4907h, "clearView");
        }
    }

    public void computeScroll() {
        if (this.f4905f) {
            this.f4906g.computeScroll();
        } else {
            this.f4907h.computeScroll();
        }
    }

    public WebBackForwardList copyBackForwardList() {
        return this.f4905f ? WebBackForwardList.m7645a(this.f4906g.copyBackForwardList()) : WebBackForwardList.m7644a(this.f4907h.copyBackForwardList());
    }

    public Object createPrintDocumentAdapter(String str) {
        Object obj = null;
        if (this.f4905f) {
            try {
                return this.f4906g.createPrintDocumentAdapter(str);
            } catch (Throwable th) {
                th.printStackTrace();
                return obj;
            }
        } else if (VERSION.SDK_INT < 21) {
            return obj;
        } else {
            return C1157u.m8042a(this.f4907h, "createPrintDocumentAdapter", new Class[]{String.class}, str);
        }
    }

    public void destroy() {
        if (!(this.f4910l || this.f4903a == 0)) {
            this.f4910l = true;
            String str = bi_常量类.f6358b;
            String str2 = bi_常量类.f6358b;
            String str3 = bi_常量类.f6358b;
            if (this.f4905f) {
                Bundle sdkQBStatisticsInfo = this.f4906g.getX5WebViewExtension().getSdkQBStatisticsInfo();
                if (sdkQBStatisticsInfo != null) {
                    str = sdkQBStatisticsInfo.getString("guid");
                    str2 = sdkQBStatisticsInfo.getString("qua2");
                    str3 = sdkQBStatisticsInfo.getString("lc");
                }
            }
            if (TbsConfig.APP_QZONE.equals(this.f4909j.getApplicationInfo().packageName)) {
                int d = m7666d(this.f4909j);
                if (d == -1) {
                    d = this.f4903a;
                }
                this.f4903a = d;
                m7669e(this.f4909j);
            }
            C1086b.m7688a(this.f4909j, str, str2, str3, this.f4903a, this.f4905f);
            this.f4903a = 0;
            this.f4910l = false;
        }
        if (this.f4905f) {
            this.f4906g.destroy();
            return;
        }
        Object invoke;
        try {
            Class cls = Class.forName("android.webkit.WebViewClassic");
            Method method = cls.getMethod("fromWebView", new Class[]{android.webkit.WebView.class});
            method.setAccessible(true);
            invoke = method.invoke(null, new Object[]{this.f4907h});
            if (invoke != null) {
                Field declaredField = cls.getDeclaredField("mListBoxDialog");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(invoke);
                if (obj != null) {
                    Dialog dialog = (Dialog) obj;
                    dialog.setOnCancelListener(null);
                    Class cls2 = Class.forName("android.app.Dialog");
                    Field declaredField2 = cls2.getDeclaredField("CANCEL");
                    declaredField2.setAccessible(true);
                    int intValue = ((Integer) declaredField2.get(dialog)).intValue();
                    Field declaredField3 = cls2.getDeclaredField("mListenersHandler");
                    declaredField3.setAccessible(true);
                    ((Handler) declaredField3.get(dialog)).removeMessages(intValue);
                }
            }
        } catch (Exception e) {
        }
        this.f4907h.destroy();
        try {
            declaredField2 = Class.forName("android.webkit.BrowserFrame").getDeclaredField("sConfigCallback");
            declaredField2.setAccessible(true);
            ComponentCallbacks componentCallbacks = (ComponentCallbacks) declaredField2.get(null);
            if (componentCallbacks != null) {
                declaredField2.set(null, null);
                declaredField2 = Class.forName("android.view.ViewRoot").getDeclaredField("sConfigCallbacks");
                declaredField2.setAccessible(true);
                invoke = declaredField2.get(null);
                if (invoke != null) {
                    List list = (List) invoke;
                    synchronized (list) {
                        list.remove(componentCallbacks);
                    }
                }
            }
        } catch (Exception e2) {
        }
    }

    public void documentHasImages(Message message) {
        if (this.f4905f) {
            this.f4906g.documentHasImages(message);
        } else {
            this.f4907h.documentHasImages(message);
        }
    }

    public void dumpViewHierarchyWithProperties(BufferedWriter bufferedWriter, int i) {
        if (this.f4905f) {
            this.f4906g.dumpViewHierarchyWithProperties(bufferedWriter, i);
            return;
        }
        C1157u.m8042a(this.f4907h, "dumpViewHierarchyWithProperties", new Class[]{BufferedWriter.class, Integer.TYPE}, bufferedWriter, Integer.valueOf(i));
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        Method a;
        if (this.f4905f) {
            try {
                a = C1157u.m8044a(this.f4906g.getView(), "evaluateJavascript", String.class, ValueCallback.class);
                a.setAccessible(true);
                a.invoke(this.f4906g.getView(), new Object[]{str, valueCallback});
            } catch (Exception e) {
                e.printStackTrace();
                loadUrl(str);
            }
        } else if (VERSION.SDK_INT >= 19) {
            try {
                a = Class.forName("android.webkit.WebView").getDeclaredMethod("evaluateJavascript", new Class[]{String.class, ValueCallback.class});
                a.setAccessible(true);
                a.invoke(this.f4907h, new Object[]{str, valueCallback});
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Deprecated
    public int findAll(String str) {
        if (this.f4905f) {
            return this.f4906g.findAll(str);
        }
        Object a = C1157u.m8042a(this.f4907h, "findAll", new Class[]{String.class}, str);
        return a == null ? 0 : ((Integer) a).intValue();
    }

    @TargetApi(16)
    public void findAllAsync(String str) {
        if (this.f4905f) {
            this.f4906g.findAllAsync(str);
        } else if (VERSION.SDK_INT >= 16) {
            C1157u.m8042a(this.f4907h, "findAllAsync", new Class[]{String.class}, str);
        }
    }

    public View findHierarchyView(String str, int i) {
        if (this.f4905f) {
            return this.f4906g.findHierarchyView(str, i);
        }
        return (View) C1157u.m8042a(this.f4907h, "findHierarchyView", new Class[]{String.class, Integer.TYPE}, str, Integer.valueOf(i));
    }

    @TargetApi(3)
    public void findNext(boolean z) {
        if (this.f4905f) {
            this.f4906g.findNext(z);
        } else {
            this.f4907h.findNext(z);
        }
    }

    public void flingScroll(int i, int i2) {
        if (this.f4905f) {
            this.f4906g.flingScroll(i, i2);
        } else {
            this.f4907h.flingScroll(i, i2);
        }
    }

    @Deprecated
    public void freeMemory() {
        if (this.f4905f) {
            this.f4906g.freeMemory();
        } else {
            C1157u.m8041a(this.f4907h, "freeMemory");
        }
    }

    public SslCertificate getCertificate() {
        return !this.f4905f ? this.f4907h.getCertificate() : this.f4906g.getCertificate();
    }

    public int getContentHeight() {
        return !this.f4905f ? this.f4907h.getContentHeight() : this.f4906g.getContentHeight();
    }

    public int getContentWidth() {
        if (this.f4905f) {
            return this.f4906g.getContentWidth();
        }
        Object a = C1157u.m8041a(this.f4907h, "getContentWidth");
        return a == null ? 0 : ((Integer) a).intValue();
    }

    public Bitmap getFavicon() {
        return !this.f4905f ? this.f4907h.getFavicon() : this.f4906g.getFavicon();
    }

    public HitTestResult getHitTestResult() {
        return !this.f4905f ? new HitTestResult(this.f4907h.getHitTestResult()) : new HitTestResult(this.f4906g.getHitTestResult());
    }

    public String[] getHttpAuthUsernamePassword(String str, String str2) {
        return !this.f4905f ? this.f4907h.getHttpAuthUsernamePassword(str, str2) : this.f4906g.getHttpAuthUsernamePassword(str, str2);
    }

    @TargetApi(3)
    public String getOriginalUrl() {
        return !this.f4905f ? this.f4907h.getOriginalUrl() : this.f4906g.getOriginalUrl();
    }

    public int getProgress() {
        return !this.f4905f ? this.f4907h.getProgress() : this.f4906g.getProgress();
    }

    @Deprecated
    public float getScale() {
        if (this.f4905f) {
            return this.f4906g.getScale();
        }
        Object a = C1157u.m8041a(this.f4907h, "getScale");
        return a == null ? 0.0f : ((Float) a).floatValue();
    }

    public int getScrollBarDefaultDelayBeforeFade() {
        return getView().getScrollBarDefaultDelayBeforeFade();
    }

    public int getScrollBarFadeDuration() {
        return getView().getScrollBarFadeDuration();
    }

    public int getScrollBarSize() {
        return getView().getScrollBarSize();
    }

    public int getScrollBarStyle() {
        return getView().getScrollBarStyle();
    }

    public WebSettings getSettings() {
        if (this.f4908i != null) {
            return this.f4908i;
        }
        if (this.f4905f) {
            WebSettings webSettings = new WebSettings(this.f4906g.getSettings());
            this.f4908i = webSettings;
            return webSettings;
        }
        webSettings = new WebSettings(this.f4907h.getSettings());
        this.f4908i = webSettings;
        return webSettings;
    }

    public IX5WebSettingsExtension getSettingsExtension() {
        return !this.f4905f ? null : this.f4906g.getX5WebViewExtension().getSettingsExtension();
    }

    public int getSysNightModeAlpha() {
        return NIGHT_MODE_ALPHA;
    }

    public String getTitle() {
        return !this.f4905f ? this.f4907h.getTitle() : this.f4906g.getTitle();
    }

    public String getUrl() {
        return !this.f4905f ? this.f4907h.getUrl() : this.f4906g.getUrl();
    }

    public View getView() {
        return !this.f4905f ? this.f4907h : this.f4906g.getView();
    }

    public int getVisibleTitleHeight() {
        if (this.f4905f) {
            return this.f4906g.getVisibleTitleHeight();
        }
        Object a = C1157u.m8041a(this.f4907h, "getVisibleTitleHeight");
        return a == null ? 0 : ((Integer) a).intValue();
    }

    public IX5WebChromeClientExtension getWebChromeClientExtension() {
        return !this.f4905f ? null : this.f4906g.getX5WebViewExtension().getWebChromeClientExtension();
    }

    public int getWebScrollX() {
        return this.f4905f ? this.f4906g.getView().getScrollX() : this.f4907h.getScrollX();
    }

    public int getWebScrollY() {
        if (this.f4905f) {
            return this.f4906g.getView().getScrollY();
        }
        Object a = C1157u.m8041a(this.f4907h, "getWebScrollY");
        return a == null ? this.f4907h.getScrollY() : ((Integer) a).intValue();
    }

    public IX5WebViewClientExtension getWebViewClientExtension() {
        return !this.f4905f ? null : this.f4906g.getX5WebViewExtension().getWebViewClientExtension();
    }

    public IX5WebViewExtension getX5WebViewExtension() {
        return !this.f4905f ? null : this.f4906g.getX5WebViewExtension();
    }

    @Deprecated
    public View getZoomControls() {
        return !this.f4905f ? (View) C1157u.m8041a(this.f4907h, "getZoomControls") : this.f4906g.getZoomControls();
    }

    public void goBack() {
        if (this.f4905f) {
            this.f4906g.goBack();
        } else {
            this.f4907h.goBack();
        }
    }

    public void goBackOrForward(int i) {
        if (this.f4905f) {
            this.f4906g.goBackOrForward(i);
        } else {
            this.f4907h.goBackOrForward(i);
        }
    }

    public void goForward() {
        if (this.f4905f) {
            this.f4906g.goForward();
        } else {
            this.f4907h.goForward();
        }
    }

    public void invokeZoomPicker() {
        if (this.f4905f) {
            this.f4906g.invokeZoomPicker();
        } else {
            this.f4907h.invokeZoomPicker();
        }
    }

    public boolean isDayMode() {
        return f4902x;
    }

    public boolean isPrivateBrowsingEnabled() {
        if (this.f4905f) {
            return this.f4906g.isPrivateBrowsingEnable();
        }
        if (VERSION.SDK_INT < 11) {
            return false;
        }
        Object a = C1157u.m8041a(this.f4907h, "isPrivateBrowsingEnabled");
        return a == null ? false : ((Boolean) a).booleanValue();
    }

    public void loadData(String str, String str2, String str3) {
        if (this.f4905f) {
            this.f4906g.loadData(str, str2, str3);
        } else {
            this.f4907h.loadData(str, str2, str3);
        }
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (this.f4905f) {
            this.f4906g.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } else {
            this.f4907h.loadDataWithBaseURL(str, str2, str3, str4, str5);
        }
    }

    public void loadUrl(String str) {
        if (str != null && !showDebugView(str)) {
            if (this.f4905f) {
                this.f4906g.loadUrl(str);
            } else {
                this.f4907h.loadUrl(str);
            }
        }
    }

    @TargetApi(8)
    public void loadUrl(String str, Map<String, String> map) {
        if (str != null && !showDebugView(str)) {
            if (this.f4905f) {
                this.f4906g.loadUrl(str, map);
            } else if (VERSION.SDK_INT >= 8) {
                this.f4907h.loadUrl(str, map);
            }
        }
    }

    protected void onDetachedFromWindow() {
        if (!(this.f4910l || this.f4903a == 0)) {
            this.f4910l = true;
            String str = bi_常量类.f6358b;
            String str2 = bi_常量类.f6358b;
            String str3 = bi_常量类.f6358b;
            if (this.f4905f) {
                Bundle sdkQBStatisticsInfo = this.f4906g.getX5WebViewExtension().getSdkQBStatisticsInfo();
                if (sdkQBStatisticsInfo != null) {
                    str = sdkQBStatisticsInfo.getString("guid");
                    str2 = sdkQBStatisticsInfo.getString("qua2");
                    str3 = sdkQBStatisticsInfo.getString("lc");
                }
            }
            if (TbsConfig.APP_QZONE.equals(this.f4909j.getApplicationInfo().packageName)) {
                int d = m7666d(this.f4909j);
                if (d == -1) {
                    d = this.f4903a;
                }
                this.f4903a = d;
                m7669e(this.f4909j);
            }
            C1086b.m7688a(this.f4909j, str, str2, str3, this.f4903a, this.f4905f);
            this.f4903a = 0;
            this.f4910l = false;
        }
        super.onDetachedFromWindow();
    }

    public boolean onLongClick(View view) {
        return this.f4919z != null ? !this.f4919z.onLongClick(view) ? m7661a(view) : true : m7661a(view);
    }

    public void onPause() {
        if (this.f4905f) {
            this.f4906g.onPause();
        } else {
            C1157u.m8041a(this.f4907h, "onPause");
        }
    }

    public void onResume() {
        if (this.f4905f) {
            this.f4906g.onResume();
        } else {
            C1157u.m8041a(this.f4907h, "onResume");
        }
    }

    @TargetApi(11)
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (VERSION.SDK_INT >= 21 && m7663b(this.f4909j) && isHardwareAccelerated() && i > 0 && i2 > 0 && getLayerType() != 2 && this.f4906g != null && this.f4906g.getView() != null) {
            this.f4906g.getView().setLayerType(2, null);
        }
    }

    protected void onVisibilityChanged(View view, int i) {
        if (this.f4909j == null) {
            super.onVisibilityChanged(view, i);
            return;
        }
        if (f4900q == null) {
            f4900q = this.f4909j.getApplicationInfo().packageName;
        }
        if (f4900q == null || !(f4900q.equals("com.tencent.mm") || f4900q.equals(TbsConfig.APP_QQ))) {
            if (!(i == 0 || this.f4910l || this.f4903a == 0)) {
                this.f4910l = true;
                String str = bi_常量类.f6358b;
                String str2 = bi_常量类.f6358b;
                String str3 = bi_常量类.f6358b;
                if (this.f4905f) {
                    Bundle sdkQBStatisticsInfo = this.f4906g.getX5WebViewExtension().getSdkQBStatisticsInfo();
                    if (sdkQBStatisticsInfo != null) {
                        str = sdkQBStatisticsInfo.getString("guid");
                        str2 = sdkQBStatisticsInfo.getString("qua2");
                        str3 = sdkQBStatisticsInfo.getString("lc");
                    }
                }
                if (TbsConfig.APP_QZONE.equals(this.f4909j.getApplicationInfo().packageName)) {
                    int d = m7666d(this.f4909j);
                    if (d == -1) {
                        d = this.f4903a;
                    }
                    this.f4903a = d;
                    m7669e(this.f4909j);
                }
                C1086b.m7688a(this.f4909j, str, str2, str3, this.f4903a, this.f4905f);
                this.f4903a = 0;
                this.f4910l = false;
            }
            super.onVisibilityChanged(view, i);
            return;
        }
        super.onVisibilityChanged(view, i);
    }

    public boolean overlayHorizontalScrollbar() {
        return !this.f4905f ? this.f4907h.overlayHorizontalScrollbar() : this.f4906g.overlayHorizontalScrollbar();
    }

    public boolean overlayVerticalScrollbar() {
        return this.f4905f ? this.f4906g.overlayVerticalScrollbar() : this.f4907h.overlayVerticalScrollbar();
    }

    public boolean pageDown(boolean z) {
        return !this.f4905f ? this.f4907h.pageDown(z) : this.f4906g.pageDown(z, -1);
    }

    public boolean pageUp(boolean z) {
        return !this.f4905f ? this.f4907h.pageUp(z) : this.f4906g.pageUp(z, -1);
    }

    public void pauseTimers() {
        if (this.f4905f) {
            this.f4906g.pauseTimers();
        } else {
            this.f4907h.pauseTimers();
        }
    }

    @TargetApi(5)
    public void postUrl(String str, byte[] bArr) {
        if (this.f4905f) {
            this.f4906g.postUrl(str, bArr);
        } else {
            this.f4907h.postUrl(str, bArr);
        }
    }

    @Deprecated
    public void refreshPlugins(boolean z) {
        if (this.f4905f) {
            this.f4906g.refreshPlugins(z);
            return;
        }
        C1157u.m8042a(this.f4907h, "refreshPlugins", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
    }

    public void reload() {
        if (this.f4905f) {
            this.f4906g.reload();
        } else {
            this.f4907h.reload();
        }
    }

    @TargetApi(11)
    public void removeJavascriptInterface(String str) {
        if (!this.f4905f) {
            if (VERSION.SDK_INT >= 11) {
                C1157u.m8042a(this.f4907h, "removeJavascriptInterface", new Class[]{String.class}, str);
                return;
            }
            this.f4906g.removeJavascriptInterface(str);
        }
    }

    public void removeView(View view) {
        if (this.f4905f) {
            View view2 = this.f4906g.getView();
            try {
                Method a = C1157u.m8044a(view2, "removeView", View.class);
                a.setAccessible(true);
                a.invoke(view2, new Object[]{view});
                return;
            } catch (Throwable th) {
                return;
            }
        }
        this.f4907h.removeView(view);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        if (this.f4905f) {
            View view2 = this.f4906g.getView();
            if (!(view2 instanceof ViewGroup)) {
                return false;
            }
            ViewGroup viewGroup = (ViewGroup) view2;
            if (view != this) {
                view2 = view;
            }
            return viewGroup.requestChildRectangleOnScreen(view2, rect, z);
        }
        android.webkit.WebView webView = this.f4907h;
        if (view == this) {
            view = this.f4907h;
        }
        return webView.requestChildRectangleOnScreen(view, rect, z);
    }

    public void requestFocusNodeHref(Message message) {
        if (this.f4905f) {
            this.f4906g.requestFocusNodeHref(message);
        } else {
            this.f4907h.requestFocusNodeHref(message);
        }
    }

    public void requestImageRef(Message message) {
        if (this.f4905f) {
            this.f4906g.requestImageRef(message);
        } else {
            this.f4907h.requestImageRef(message);
        }
    }

    @Deprecated
    public boolean restorePicture(Bundle bundle, File file) {
        if (this.f4905f) {
            return this.f4906g.restorePicture(bundle, file);
        }
        Object a = C1157u.m8042a(this.f4907h, "restorePicture", new Class[]{Bundle.class, File.class}, bundle, file);
        return a == null ? false : ((Boolean) a).booleanValue();
    }

    public WebBackForwardList restoreState(Bundle bundle) {
        return !this.f4905f ? WebBackForwardList.m7644a(this.f4907h.restoreState(bundle)) : WebBackForwardList.m7645a(this.f4906g.restoreState(bundle));
    }

    public void resumeTimers() {
        if (this.f4905f) {
            this.f4906g.resumeTimers();
        } else {
            this.f4907h.resumeTimers();
        }
    }

    @Deprecated
    public void savePassword(String str, String str2, String str3) {
        if (this.f4905f) {
            this.f4906g.savePassword(str, str2, str3);
            return;
        }
        C1157u.m8042a(this.f4907h, "savePassword", new Class[]{String.class, String.class, String.class}, str, str2, str3);
    }

    @Deprecated
    public boolean savePicture(Bundle bundle, File file) {
        if (this.f4905f) {
            return this.f4906g.savePicture(bundle, file);
        }
        Object a = C1157u.m8042a(this.f4907h, "savePicture", new Class[]{Bundle.class, File.class}, bundle, file);
        return a == null ? false : ((Boolean) a).booleanValue();
    }

    public WebBackForwardList saveState(Bundle bundle) {
        return !this.f4905f ? WebBackForwardList.m7644a(this.f4907h.saveState(bundle)) : WebBackForwardList.m7645a(this.f4906g.saveState(bundle));
    }

    @TargetApi(11)
    public void saveWebArchive(String str) {
        if (this.f4905f) {
            this.f4906g.saveWebArchive(str);
        } else if (VERSION.SDK_INT >= 11) {
            C1157u.m8042a(this.f4907h, "saveWebArchive", new Class[]{String.class}, str);
        }
    }

    @TargetApi(11)
    public void saveWebArchive(String str, boolean z, ValueCallback<String> valueCallback) {
        if (this.f4905f) {
            this.f4906g.saveWebArchive(str, z, valueCallback);
        } else if (VERSION.SDK_INT >= 11) {
            C1157u.m8042a(this.f4907h, "saveWebArchive", new Class[]{String.class, Boolean.TYPE, ValueCallback.class}, str, Boolean.valueOf(z), valueCallback);
        }
    }

    public void setBackgroundColor(int i) {
        if (this.f4905f) {
            this.f4906g.setBackgroundColor(i);
        } else {
            this.f4907h.setBackgroundColor(i);
        }
        super.setBackgroundColor(i);
    }

    @Deprecated
    public void setCertificate(SslCertificate sslCertificate) {
        if (this.f4905f) {
            this.f4906g.setCertificate(sslCertificate);
        } else {
            this.f4907h.setCertificate(sslCertificate);
        }
    }

    public void setDayOrNight(boolean z) {
        try {
            if (this.f4905f) {
                getSettingsExtension().setDayOrNight(z);
            }
            setSysDayOrNight(z);
            getView().postInvalidate();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setDownloadListener(DownloadListener downloadListener) {
        if (this.f4905f) {
            this.f4906g.setDownloadListener(new C1103b(this, downloadListener, this.f4905f));
        } else {
            this.f4907h.setDownloadListener(new av(this, downloadListener));
        }
    }

    @TargetApi(16)
    public void setFindListener(FindListener findListener) {
        if (this.f4905f) {
            this.f4906g.setFindListener(findListener);
        } else if (VERSION.SDK_INT >= 16) {
            this.f4907h.setFindListener(new au(this, findListener));
        }
    }

    public void setHorizontalScrollbarOverlay(boolean z) {
        if (this.f4905f) {
            this.f4906g.setHorizontalScrollbarOverlay(z);
        } else {
            this.f4907h.setHorizontalScrollbarOverlay(z);
        }
    }

    public void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
        if (this.f4905f) {
            this.f4906g.setHttpAuthUsernamePassword(str, str2, str3, str4);
        } else {
            this.f4907h.setHttpAuthUsernamePassword(str, str2, str3, str4);
        }
    }

    public void setInitialScale(int i) {
        if (this.f4905f) {
            this.f4906g.setInitialScale(i);
        } else {
            this.f4907h.setInitialScale(i);
        }
    }

    public void setLongPressTextExtensionMenu(int i) {
        if (this.f4905f) {
            C1157u.m8042a(this.f4906g, "setLongPressTextExtensionMenu", new Class[]{Integer.TYPE}, Integer.valueOf(i));
        }
    }

    @Deprecated
    public void setMapTrackballToArrowKeys(boolean z) {
        if (this.f4905f) {
            this.f4906g.setMapTrackballToArrowKeys(z);
            return;
        }
        C1157u.m8042a(this.f4907h, "setMapTrackballToArrowKeys", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
    }

    public void setNetworkAvailable(boolean z) {
        if (this.f4905f) {
            this.f4906g.setNetworkAvailable(z);
        } else if (VERSION.SDK_INT >= 3) {
            this.f4907h.setNetworkAvailable(z);
        }
    }

    public void setOnLongClickListener(OnLongClickListener onLongClickListener) {
        if (this.f4905f) {
            View view = this.f4906g.getView();
            try {
                if (this.f4918y == null) {
                    Method a = C1157u.m8044a(view, "getListenerInfo", new Class[0]);
                    a.setAccessible(true);
                    Object invoke = a.invoke(view, (Object[]) null);
                    Field declaredField = invoke.getClass().getDeclaredField("mOnLongClickListener");
                    declaredField.setAccessible(true);
                    this.f4918y = declaredField.get(invoke);
                }
                this.f4919z = onLongClickListener;
                getView().setOnLongClickListener(this);
                return;
            } catch (Throwable th) {
                return;
            }
        }
        this.f4907h.setOnLongClickListener(onLongClickListener);
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        getView().setOnTouchListener(onTouchListener);
    }

    public void setPictureListener(PictureListener pictureListener) {
        if (this.f4905f) {
            if (pictureListener == null) {
                this.f4906g.setPictureListener(null);
            } else {
                this.f4906g.setPictureListener(new ax(this, pictureListener));
            }
        } else if (pictureListener == null) {
            this.f4907h.setPictureListener(null);
        } else {
            this.f4907h.setPictureListener(new aw(this, pictureListener));
        }
    }

    public void setScrollBarStyle(int i) {
        if (this.f4905f) {
            this.f4906g.getView().setScrollBarStyle(i);
        } else {
            this.f4907h.setScrollBarStyle(i);
        }
    }

    public void setSysNightModeAlpha(int i) {
        NIGHT_MODE_ALPHA = i;
    }

    public void setVerticalScrollbarOverlay(boolean z) {
        if (this.f4905f) {
            this.f4906g.setVerticalScrollbarOverlay(z);
        } else {
            this.f4907h.setVerticalScrollbarOverlay(z);
        }
    }

    public boolean setVideoFullScreen(Context context, boolean z) {
        if (!context.getApplicationInfo().processName.contains("com.tencent.android.qqdownloader") || this.f4906g == null) {
            return false;
        }
        Bundle bundle = new Bundle();
        if (z) {
            bundle.putInt("DefaultVideoScreen", 2);
        } else {
            bundle.putInt("DefaultVideoScreen", 1);
        }
        this.f4906g.getX5WebViewExtension().invokeMiscMethod("setVideoParams", bundle);
        return true;
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        WebChromeClient webChromeClient2 = null;
        if (this.f4905f) {
            IX5WebChromeClient c1113k;
            IX5WebViewBase iX5WebViewBase = this.f4906g;
            if (webChromeClient != null) {
                c1113k = new C1113k(C1110i.m7845a(true).m7857b(true).m7797g(), this, webChromeClient);
            }
            iX5WebViewBase.setWebChromeClient(c1113k);
            return;
        }
        android.webkit.WebView webView = this.f4907h;
        if (webChromeClient != null) {
            webChromeClient2 = new SystemWebChromeClient(this, webChromeClient);
        }
        webView.setWebChromeClient(webChromeClient2);
    }

    public void setWebChromeClientExtension(IX5WebChromeClientExtension iX5WebChromeClientExtension) {
        if (this.f4905f) {
            this.f4906g.getX5WebViewExtension().setWebChromeClientExtension(iX5WebChromeClientExtension);
        }
    }

    public void setWebViewCallbackClient(WebViewCallbackClient webViewCallbackClient) {
        this.mWebViewCallbackClient = webViewCallbackClient;
        if (this.f4905f && getX5WebViewExtension() != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("flag", true);
            getX5WebViewExtension().invokeMiscMethod("setWebViewCallbackClientFlag", bundle);
        }
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        WebViewClient webViewClient2 = null;
        this.f4912n = webViewClient;
        if (this.f4905f) {
            IX5WebViewClient c1118p;
            IX5WebViewBase iX5WebViewBase = this.f4906g;
            if (webViewClient != null) {
                c1118p = new C1118p(C1110i.m7845a(true).m7857b(true).m7799h(), this, webViewClient);
            }
            iX5WebViewBase.setWebViewClient(c1118p);
            return;
        }
        android.webkit.WebView webView = this.f4907h;
        if (webViewClient != null) {
            webViewClient2 = new C1128v(this, webViewClient);
        }
        webView.setWebViewClient(webViewClient2);
    }

    public void setWebViewClientExtension(IX5WebViewClientExtension iX5WebViewClientExtension) {
        if (this.f4905f) {
            this.f4906g.getX5WebViewExtension().setWebViewClientExtension(iX5WebViewClientExtension);
        }
    }

    @SuppressLint({"NewApi"})
    public boolean showDebugView(String str) {
        if (!str.startsWith("http://debugtbs.qq.com")) {
            return false;
        }
        getView().setVisibility(4);
        C1138d.m7960a(this.f4909j).m7966b(str, this, this.f4909j);
        return true;
    }

    public boolean showFindDialog(String str, boolean z) {
        return false;
    }

    public void stopLoading() {
        if (this.f4905f) {
            this.f4906g.stopLoading();
        } else {
            this.f4907h.stopLoading();
        }
    }

    public void super_computeScroll() {
        if (this.f4905f) {
            try {
                C1157u.m8041a(this.f4906g.getView(), "super_computeScroll");
                return;
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        this.f4907h.m7651a();
    }

    public boolean super_dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.f4905f) {
            return this.f4907h.m7656b(motionEvent);
        }
        try {
            Object a = C1157u.m8042a(this.f4906g.getView(), "super_dispatchTouchEvent", new Class[]{MotionEvent.class}, motionEvent);
            return a == null ? false : ((Boolean) a).booleanValue();
        } catch (Throwable th) {
            return false;
        }
    }

    public boolean super_onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f4905f) {
            return this.f4907h.m7657c(motionEvent);
        }
        try {
            Object a = C1157u.m8042a(this.f4906g.getView(), "super_onInterceptTouchEvent", new Class[]{MotionEvent.class}, motionEvent);
            return a == null ? false : ((Boolean) a).booleanValue();
        } catch (Throwable th) {
            return false;
        }
    }

    public void super_onOverScrolled(int i, int i2, boolean z, boolean z2) {
        if (this.f4905f) {
            try {
                C1157u.m8042a(this.f4906g.getView(), "super_onOverScrolled", new Class[]{Integer.TYPE, Integer.TYPE, Boolean.TYPE, Boolean.TYPE}, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2));
                return;
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        this.f4907h.m7653a(i, i2, z, z2);
    }

    public void super_onScrollChanged(int i, int i2, int i3, int i4) {
        if (this.f4905f) {
            try {
                C1157u.m8042a(this.f4906g.getView(), "super_onScrollChanged", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
                return;
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        this.f4907h.m7652a(i, i2, i3, i4);
    }

    public boolean super_onTouchEvent(MotionEvent motionEvent) {
        if (!this.f4905f) {
            return this.f4907h.m7655a(motionEvent);
        }
        try {
            Object a = C1157u.m8042a(this.f4906g.getView(), "super_onTouchEvent", new Class[]{MotionEvent.class}, motionEvent);
            return a == null ? false : ((Boolean) a).booleanValue();
        } catch (Throwable th) {
            return false;
        }
    }

    public boolean super_overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        if (!this.f4905f) {
            return this.f4907h.m7654a(i, i2, i3, i4, i5, i6, i7, i8, z);
        }
        try {
            Object a = C1157u.m8042a(this.f4906g.getView(), "super_overScrollBy", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Boolean.TYPE}, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Boolean.valueOf(z));
            return a == null ? false : ((Boolean) a).booleanValue();
        } catch (Throwable th) {
            return false;
        }
    }

    public void switchNightMode(boolean z) {
        if (z != f4902x) {
            f4902x = z;
            if (f4902x) {
                TbsLog.m7925e("QB_SDK", "deleteNightMode");
                loadUrl("javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));");
                return;
            }
            TbsLog.m7925e("QB_SDK", "nightMode");
            loadUrl("javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);");
        }
    }

    public void switchToNightMode() {
        TbsLog.m7925e("QB_SDK", "switchToNightMode 01");
        if (!f4902x) {
            TbsLog.m7925e("QB_SDK", "switchToNightMode");
            loadUrl("javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);");
        }
    }

    public boolean zoomIn() {
        return !this.f4905f ? this.f4907h.zoomIn() : this.f4906g.zoomIn();
    }

    public boolean zoomOut() {
        return !this.f4905f ? this.f4907h.zoomOut() : this.f4906g.zoomOut();
    }
}
