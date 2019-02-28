package com.alipay.sdk.auth;

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
import android.webkit.ConsoleMessage;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebSettings.TextSize;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import com.alipay.sdk.authjs.C0104a;
import com.alipay.sdk.authjs.C0104a.C0103a;
import com.alipay.sdk.authjs.C0105c;
import com.alipay.sdk.util.C0150k;
import com.alipay.sdk.widget.C0151a;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;
import p054u.aly.bi_常量类;

public class AuthActivity extends Activity {
    /* renamed from: a */
    static final String f205a = "params";
    /* renamed from: b */
    static final String f206b = "redirectUri";
    /* renamed from: c */
    private WebView f207c;
    /* renamed from: d */
    private String f208d;
    /* renamed from: e */
    private C0151a f209e;
    /* renamed from: f */
    private Handler f210f;
    /* renamed from: g */
    private boolean f211g;
    /* renamed from: h */
    private boolean f212h;
    /* renamed from: i */
    private Runnable f213i = new C0096d(this);

    /* renamed from: com.alipay.sdk.auth.AuthActivity$a */
    private class C0090a extends WebChromeClient {
        /* renamed from: a */
        final /* synthetic */ AuthActivity f203a;

        private C0090a(AuthActivity authActivity) {
            this.f203a = authActivity;
        }

        public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            String message = consoleMessage.message();
            if (TextUtils.isEmpty(message)) {
                return super.onConsoleMessage(consoleMessage);
            }
            Object obj = null;
            if (message.startsWith("h5container.message: ")) {
                obj = message.replaceFirst("h5container.message: ", bi_常量类.f6358b_空串);
            }
            if (TextUtils.isEmpty(obj)) {
                return super.onConsoleMessage(consoleMessage);
            }
            AuthActivity.m242b(this.f203a, obj);
            return super.onConsoleMessage(consoleMessage);
        }
    }

    /* renamed from: com.alipay.sdk.auth.AuthActivity$b */
    private class C0091b extends WebViewClient {
        /* renamed from: a */
        final /* synthetic */ AuthActivity f204a;

        private C0091b(AuthActivity authActivity) {
            this.f204a = authActivity;
        }

        public final void onPageFinished(WebView webView, String str) {
            AuthActivity.m249g(this.f204a);
            this.f204a.f210f.removeCallbacks(this.f204a.f213i);
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            AuthActivity.m246d(this.f204a);
            this.f204a.f210f.postDelayed(this.f204a.f213i, 30000);
            super.onPageStarted(webView, str, bitmap);
        }

        public final void onReceivedError(WebView webView, int i, String str, String str2) {
            this.f204a.f212h = true;
            super.onReceivedError(webView, i, str, str2);
        }

        public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (this.f204a.f211g) {
                sslErrorHandler.proceed();
                this.f204a.f211g = false;
                return;
            }
            this.f204a.runOnUiThread(new C0097e(this, sslErrorHandler));
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!AuthActivity.m238a(this.f204a, str)) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            webView.stopLoading();
            return true;
        }
    }

    /* renamed from: a */
    private void m234a() {
        try {
            if (this.f209e == null) {
                this.f209e = new C0151a(this);
            }
            this.f209e.m544b();
        } catch (Exception e) {
            this.f209e = null;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m235a(AuthActivity authActivity, C0104a c0104a) {
        if (authActivity.f207c != null && c0104a != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(C0104a.f242e, c0104a.f246i);
                jSONObject.put(C0104a.f244g, c0104a.f248k);
                jSONObject.put(C0104a.f243f, c0104a.f250m);
                jSONObject.put(C0104a.f245h, c0104a.f249l);
                authActivity.runOnUiThread(new C0095c(authActivity, String.format("AlipayJSBridge._invokeJS(%s)", new Object[]{jSONObject.toString()})));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private void m236a(C0104a c0104a) {
        if (this.f207c != null && c0104a != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(C0104a.f242e, c0104a.f246i);
                jSONObject.put(C0104a.f244g, c0104a.f248k);
                jSONObject.put(C0104a.f243f, c0104a.f250m);
                jSONObject.put(C0104a.f245h, c0104a.f249l);
                runOnUiThread(new C0095c(this, String.format("AlipayJSBridge._invokeJS(%s)", new Object[]{jSONObject.toString()})));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ boolean m238a(AuthActivity authActivity, String str) {
        if (TextUtils.isEmpty(str) || str.startsWith("http://") || str.startsWith("https://")) {
            return false;
        }
        if (!"SDKLite://h5quit".equalsIgnoreCase(str)) {
            if (TextUtils.equals(str, authActivity.f208d)) {
                str = str + "?resultCode=150";
            }
            C0100h.m256a((Activity) authActivity, str);
        }
        authActivity.finish();
        return true;
    }

    /* renamed from: a */
    private boolean m240a(String str) {
        if (TextUtils.isEmpty(str) || str.startsWith("http://") || str.startsWith("https://")) {
            return false;
        }
        if (!"SDKLite://h5quit".equalsIgnoreCase(str)) {
            if (TextUtils.equals(str, this.f208d)) {
                str = str + "?resultCode=150";
            }
            C0100h.m256a((Activity) this, str);
        }
        finish();
        return true;
    }

    /* renamed from: b */
    private void m241b() {
        if (this.f209e != null && this.f209e.m543a()) {
            this.f209e.m545c();
        }
        this.f209e = null;
    }

    /* renamed from: b */
    static /* synthetic */ void m242b(AuthActivity authActivity, String str) {
        String str2;
        C0105c c0105c = new C0105c(authActivity.getApplicationContext(), new C0094b(authActivity));
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString(C0104a.f242e);
            try {
                if (!TextUtils.isEmpty(string)) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(C0104a.f243f);
                    jSONObject2 = jSONObject2 instanceof JSONObject ? jSONObject2 : null;
                    String string2 = jSONObject.getString(C0104a.f244g);
                    String string3 = jSONObject.getString(C0104a.f241d);
                    C0104a c0104a = new C0104a(C0104a.f239b);
                    c0104a.f247j = string3;
                    c0104a.f248k = string2;
                    c0104a.f250m = jSONObject2;
                    c0104a.f246i = string;
                    c0105c.m283a(c0104a);
                }
            } catch (Exception e) {
                str2 = string;
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        c0105c.m284a(str2, C0103a.RUNTIME_ERROR);
                    } catch (JSONException e2) {
                    }
                }
            }
        } catch (Exception e3) {
            str2 = null;
            if (!TextUtils.isEmpty(str2)) {
                c0105c.m284a(str2, C0103a.RUNTIME_ERROR);
            }
        }
    }

    /* renamed from: b */
    private void m243b(String str) {
        String str2;
        C0105c c0105c = new C0105c(getApplicationContext(), new C0094b(this));
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString(C0104a.f242e);
            try {
                if (!TextUtils.isEmpty(string)) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(C0104a.f243f);
                    jSONObject2 = jSONObject2 instanceof JSONObject ? jSONObject2 : null;
                    String string2 = jSONObject.getString(C0104a.f244g);
                    String string3 = jSONObject.getString(C0104a.f241d);
                    C0104a c0104a = new C0104a(C0104a.f239b);
                    c0104a.f247j = string3;
                    c0104a.f248k = string2;
                    c0104a.f250m = jSONObject2;
                    c0104a.f246i = string;
                    c0105c.m283a(c0104a);
                }
            } catch (Exception e) {
                str2 = string;
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        c0105c.m284a(str2, C0103a.RUNTIME_ERROR);
                    } catch (JSONException e2) {
                    }
                }
            }
        } catch (Exception e3) {
            str2 = null;
            if (!TextUtils.isEmpty(str2)) {
                c0105c.m284a(str2, C0103a.RUNTIME_ERROR);
            }
        }
    }

    /* renamed from: d */
    static /* synthetic */ void m246d(AuthActivity authActivity) {
        try {
            if (authActivity.f209e == null) {
                authActivity.f209e = new C0151a(authActivity);
            }
            authActivity.f209e.m544b();
        } catch (Exception e) {
            authActivity.f209e = null;
        }
    }

    /* renamed from: g */
    static /* synthetic */ void m249g(AuthActivity authActivity) {
        if (authActivity.f209e != null && authActivity.f209e.m543a()) {
            authActivity.f209e.m545c();
        }
        authActivity.f209e = null;
    }

    public void onBackPressed() {
        if (!this.f207c.canGoBack()) {
            C0100h.m256a((Activity) this, this.f208d + "?resultCode=150");
            finish();
        } else if (this.f212h) {
            C0100h.m256a((Activity) this, this.f208d + "?resultCode=150");
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
                this.f208d = extras.getString(f206b);
                String string = extras.getString("params");
                if (C0150k.m525a(string)) {
                    Method method;
                    super.requestWindowFeature(1);
                    this.f210f = new Handler(getMainLooper());
                    View linearLayout = new LinearLayout(getApplicationContext());
                    LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
                    linearLayout.setOrientation(1);
                    setContentView(linearLayout, layoutParams);
                    this.f207c = new WebView(getApplicationContext());
                    layoutParams.weight = 1.0f;
                    this.f207c.setVisibility(0);
                    linearLayout.addView(this.f207c, layoutParams);
                    WebSettings settings = this.f207c.getSettings();
                    settings.setUserAgentString(settings.getUserAgentString() + C0150k.m530c(getApplicationContext()));
                    settings.setRenderPriority(RenderPriority.HIGH);
                    settings.setSupportMultipleWindows(true);
                    settings.setJavaScriptEnabled(true);
                    settings.setSavePassword(false);
                    settings.setJavaScriptCanOpenWindowsAutomatically(true);
                    settings.setMinimumFontSize(settings.getMinimumFontSize() + 8);
                    settings.setAllowFileAccess(false);
                    settings.setTextSize(TextSize.NORMAL);
                    this.f207c.setVerticalScrollbarOverlay(true);
                    this.f207c.setWebViewClient(new C0091b());
                    this.f207c.setWebChromeClient(new C0090a());
                    this.f207c.setDownloadListener(new C0092a(this));
                    this.f207c.loadUrl(string);
                    if (VERSION.SDK_INT >= 7) {
                        try {
                            method = this.f207c.getSettings().getClass().getMethod("setDomStorageEnabled", new Class[]{Boolean.TYPE});
                            if (method != null) {
                                method.invoke(this.f207c.getSettings(), new Object[]{Boolean.valueOf(true)});
                            }
                        } catch (Exception e) {
                        }
                    }
                    try {
                        method = this.f207c.getClass().getMethod("removeJavascriptInterface", new Class[0]);
                        if (method != null) {
                            method.invoke(this.f207c, new Object[]{"searchBoxJavaBridge_"});
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
        if (this.f207c != null) {
            this.f207c.removeAllViews();
            this.f207c.destroy();
            this.f207c = null;
        }
    }
}
