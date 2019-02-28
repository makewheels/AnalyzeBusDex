package com.alipay.sdk.app;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebSettings.TextSize;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import com.alipay.sdk.cons.C0108a;
import com.alipay.sdk.util.C0150k;
import com.alipay.sdk.widget.C0151a;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import p054u.aly.bi_常量类;

public class H5AuthActivity extends Activity {
    /* renamed from: a */
    private WebView f160a;
    /* renamed from: b */
    private C0151a f161b;
    /* renamed from: c */
    private Handler f162c;
    /* renamed from: d */
    private boolean f163d;
    /* renamed from: e */
    private boolean f164e;
    /* renamed from: f */
    private Runnable f165f = new C0078b(this);

    /* renamed from: com.alipay.sdk.app.H5AuthActivity$a */
    private class C0075a extends WebViewClient {
        /* renamed from: a */
        final /* synthetic */ H5AuthActivity f159a;

        private C0075a(H5AuthActivity h5AuthActivity) {
            this.f159a = h5AuthActivity;
        }

        public final void onPageFinished(WebView webView, String str) {
            H5AuthActivity.m209f(this.f159a);
            this.f159a.f162c.removeCallbacks(this.f159a.f165f);
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            H5AuthActivity.m206c(this.f159a);
            this.f159a.f162c.postDelayed(this.f159a.f165f, 30000);
            super.onPageStarted(webView, str, bitmap);
        }

        public final void onReceivedError(WebView webView, int i, String str, String str2) {
            this.f159a.f164e = true;
            super.onReceivedError(webView, i, str, str2);
        }

        public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (this.f159a.f163d) {
                sslErrorHandler.proceed();
                this.f159a.f163d = false;
                return;
            }
            this.f159a.runOnUiThread(new C0079c(this, sslErrorHandler));
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (TextUtils.equals(str, C0108a.f270m) || TextUtils.equals(str, C0108a.f271n)) {
                C0088l.f189a = C0088l.m224a();
                this.f159a.finish();
            } else if (str.startsWith(C0108a.f269l)) {
                try {
                    String substring = str.substring(str.indexOf(C0108a.f269l) + 24);
                    int parseInt = Integer.parseInt(substring.substring(substring.lastIndexOf(C0108a.f272o) + 10));
                    C0089m a;
                    if (parseInt == C0089m.SUCCEEDED.m232a()) {
                        String decode = URLDecoder.decode(str);
                        decode = decode.substring(decode.indexOf(C0108a.f269l) + 24, decode.lastIndexOf(C0108a.f272o));
                        a = C0089m.m229a(parseInt);
                        C0088l.f189a = C0088l.m225a(a.m232a(), a.m233b(), decode);
                    } else {
                        a = C0089m.m229a(C0089m.FAILED.m232a());
                        C0088l.f189a = C0088l.m225a(a.m232a(), a.m233b(), bi_常量类.f6358b);
                    }
                } catch (Exception e) {
                    C0088l.f189a = C0088l.m227b();
                }
                this.f159a.runOnUiThread(new C0082f(this));
            } else {
                webView.loadUrl(str);
            }
            return true;
        }
    }

    /* renamed from: a */
    private static void m200a() {
        Object obj = AuthTask.f155a;
        synchronized (obj) {
            try {
                obj.notify();
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: b */
    private void m203b() {
        if (this.f161b == null) {
            this.f161b = new C0151a(this);
        }
        try {
            this.f161b.m544b();
        } catch (Exception e) {
            this.f161b = null;
        }
    }

    /* renamed from: c */
    private void m205c() {
        if (this.f161b != null && this.f161b.m543a()) {
            this.f161b.m545c();
        }
        this.f161b = null;
    }

    /* renamed from: c */
    static /* synthetic */ void m206c(H5AuthActivity h5AuthActivity) {
        if (h5AuthActivity.f161b == null) {
            h5AuthActivity.f161b = new C0151a(h5AuthActivity);
        }
        try {
            h5AuthActivity.f161b.m544b();
        } catch (Exception e) {
            h5AuthActivity.f161b = null;
        }
    }

    /* renamed from: f */
    static /* synthetic */ void m209f(H5AuthActivity h5AuthActivity) {
        if (h5AuthActivity.f161b != null && h5AuthActivity.f161b.m543a()) {
            h5AuthActivity.f161b.m545c();
        }
        h5AuthActivity.f161b = null;
    }

    public void finish() {
        Object obj = AuthTask.f155a;
        synchronized (obj) {
            try {
                obj.notify();
            } catch (Exception e) {
            }
        }
        super.finish();
    }

    public void onBackPressed() {
        if (!this.f160a.canGoBack()) {
            C0088l.f189a = C0088l.m224a();
            finish();
        } else if (this.f164e) {
            C0089m a = C0089m.m229a(C0089m.NETWORK_ERROR.m232a());
            C0088l.f189a = C0088l.m225a(a.m232a(), a.m233b(), bi_常量类.f6358b);
            finish();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                finish();
                return;
            }
            try {
                String string = extras.getString("url");
                if (C0150k.m525a(string)) {
                    Method method;
                    super.requestWindowFeature(1);
                    this.f162c = new Handler(getMainLooper());
                    View linearLayout = new LinearLayout(getApplicationContext());
                    LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
                    linearLayout.setOrientation(1);
                    setContentView(linearLayout, layoutParams);
                    this.f160a = new WebView(getApplicationContext());
                    layoutParams.weight = 1.0f;
                    this.f160a.setVisibility(0);
                    linearLayout.addView(this.f160a, layoutParams);
                    WebSettings settings = this.f160a.getSettings();
                    settings.setUserAgentString(settings.getUserAgentString() + C0150k.m530c(getApplicationContext()));
                    settings.setRenderPriority(RenderPriority.HIGH);
                    settings.setSupportMultipleWindows(true);
                    settings.setJavaScriptEnabled(true);
                    settings.setSavePassword(false);
                    settings.setJavaScriptCanOpenWindowsAutomatically(true);
                    settings.setMinimumFontSize(settings.getMinimumFontSize() + 8);
                    settings.setAllowFileAccess(false);
                    settings.setTextSize(TextSize.NORMAL);
                    this.f160a.setVerticalScrollbarOverlay(true);
                    this.f160a.setWebViewClient(new C0075a());
                    this.f160a.setDownloadListener(new C0077a(this));
                    this.f160a.loadUrl(string);
                    if (VERSION.SDK_INT >= 7) {
                        try {
                            method = this.f160a.getSettings().getClass().getMethod("setDomStorageEnabled", new Class[]{Boolean.TYPE});
                            if (method != null) {
                                method.invoke(this.f160a.getSettings(), new Object[]{Boolean.valueOf(true)});
                            }
                        } catch (Exception e) {
                        }
                    }
                    try {
                        method = this.f160a.getClass().getMethod("removeJavascriptInterface", new Class[0]);
                        if (method != null) {
                            method.invoke(this.f160a, new Object[]{"searchBoxJavaBridge_"});
                            return;
                        }
                        return;
                    } catch (Exception e2) {
                        return;
                    }
                }
                finish();
            } catch (Exception e3) {
                finish();
            }
        } catch (Exception e4) {
            finish();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.f160a != null) {
            this.f160a.removeAllViews();
            this.f160a.destroy();
            this.f160a = null;
        }
    }
}
