package com.alipay.sdk.app;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alipay.sdk.cons.C0108a;
import com.alipay.sdk.widget.C0151a;
import com.stub.StubApp;
import java.net.URLDecoder;
import p054u.aly.bi_常量类;

public class H5PayActivity extends Activity {
    /* renamed from: a */
    private WebView f167a;
    /* renamed from: b */
    private C0151a f168b;
    /* renamed from: c */
    private Handler f169c;
    /* renamed from: d */
    private boolean f170d;
    /* renamed from: e */
    private boolean f171e;
    /* renamed from: f */
    private Runnable f172f = new C0083g(this);

    /* renamed from: com.alipay.sdk.app.H5PayActivity$a */
    private class C0076a extends WebViewClient {
        /* renamed from: a */
        final /* synthetic */ H5PayActivity f166a;

        private C0076a(H5PayActivity h5PayActivity) {
            this.f166a = h5PayActivity;
        }

        public final void onLoadResource(WebView webView, String str) {
        }

        public final void onPageFinished(WebView webView, String str) {
            H5PayActivity.m219f(this.f166a);
            this.f166a.f169c.removeCallbacks(this.f166a.f172f);
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            H5PayActivity.m216c(this.f166a);
            this.f166a.f169c.postDelayed(this.f166a.f172f, 30000);
            super.onPageStarted(webView, str, bitmap);
        }

        public final void onReceivedError(WebView webView, int i, String str, String str2) {
            this.f166a.f170d = true;
            super.onReceivedError(webView, i, str, str2);
        }

        public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (this.f166a.f171e) {
                sslErrorHandler.proceed();
                this.f166a.f171e = false;
                return;
            }
            this.f166a.runOnUiThread(new C0084h(this, sslErrorHandler));
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str.startsWith(C0108a.f268k)) {
                return false;
            }
            if (TextUtils.equals(str, C0108a.f270m) || TextUtils.equals(str, C0108a.f271n)) {
                C0088l.f189a = C0088l.m224a();
                this.f166a.finish();
                return true;
            } else if (str.startsWith(C0108a.f269l)) {
                try {
                    String substring = str.substring(str.indexOf(C0108a.f269l) + 24);
                    int parseInt = Integer.parseInt(substring.substring(substring.lastIndexOf(C0108a.f272o) + 10));
                    if (parseInt == C0089m.SUCCEEDED.m232a() || parseInt == C0089m.PAY_WAITTING.m232a()) {
                        StringBuilder stringBuilder = new StringBuilder();
                        substring = URLDecoder.decode(str);
                        substring = substring.substring(substring.indexOf(C0108a.f269l) + 24, substring.lastIndexOf(C0108a.f272o));
                        if (substring.contains(C0108a.f273p)) {
                            int indexOf = substring.indexOf(C0108a.f273p) + 13;
                            stringBuilder.append(substring.split(C0108a.f273p)[0]).append(C0108a.f273p).append(substring.substring(indexOf, substring.indexOf("\"&", indexOf))).append(substring.substring(substring.indexOf("\"&", indexOf)));
                            substring = stringBuilder.toString();
                        }
                        C0089m a = C0089m.m229a(parseInt);
                        C0088l.f189a = C0088l.m225a(a.m232a(), a.m233b(), substring);
                        this.f166a.runOnUiThread(new C0087k(this));
                        return true;
                    }
                    C0089m a2 = C0089m.m229a(C0089m.FAILED.m232a());
                    C0088l.f189a = C0088l.m225a(a2.m232a(), a2.m233b(), bi_常量类.f6358b);
                    this.f166a.runOnUiThread(new C0087k(this));
                    return true;
                } catch (Exception e) {
                    C0088l.f189a = C0088l.m227b();
                }
            } else {
                webView.loadUrl(str);
                return true;
            }
        }
    }

    static {
        StubApp.interface11(0);
    }

    /* renamed from: a */
    private static void m210a() {
        Object obj = PayTask.f173a;
        synchronized (obj) {
            try {
                obj.notify();
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: b */
    private void m213b() {
        if (this.f168b == null) {
            this.f168b = new C0151a(this);
        }
        this.f168b.m544b();
    }

    /* renamed from: c */
    private void m215c() {
        if (this.f168b != null && this.f168b.m543a()) {
            this.f168b.m545c();
        }
        this.f168b = null;
    }

    /* renamed from: c */
    static /* synthetic */ void m216c(H5PayActivity h5PayActivity) {
        if (h5PayActivity.f168b == null) {
            h5PayActivity.f168b = new C0151a(h5PayActivity);
        }
        h5PayActivity.f168b.m544b();
    }

    /* renamed from: f */
    static /* synthetic */ void m219f(H5PayActivity h5PayActivity) {
        if (h5PayActivity.f168b != null && h5PayActivity.f168b.m543a()) {
            h5PayActivity.f168b.m545c();
        }
        h5PayActivity.f168b = null;
    }

    public void finish() {
        Object obj = PayTask.f173a;
        synchronized (obj) {
            try {
                obj.notify();
            } catch (Exception e) {
            }
        }
        super.finish();
    }

    public void onBackPressed() {
        if (!this.f167a.canGoBack()) {
            C0088l.f189a = C0088l.m224a();
            finish();
        } else if (this.f170d) {
            C0089m a = C0089m.m229a(C0089m.NETWORK_ERROR.m232a());
            C0088l.f189a = C0088l.m225a(a.m232a(), a.m233b(), bi_常量类.f6358b);
            finish();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    protected native void onCreate(Bundle bundle);

    protected void onDestroy() {
        super.onDestroy();
        if (this.f167a != null) {
            this.f167a.removeAllViews();
            this.f167a.destroy();
            this.f167a = null;
        }
    }
}
