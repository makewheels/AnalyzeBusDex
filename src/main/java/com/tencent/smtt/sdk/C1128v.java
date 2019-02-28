package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.Build.VERSION;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.smtt.export.external.interfaces.HttpAuthHandler;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.sdk.p052b.C1102d;
import com.tencent.smtt.utils.C1154r;
import com.tencent.smtt.utils.C1160x;
import com.tencent.smtt.utils.TbsLog;
import java.util.Map;

/* renamed from: com.tencent.smtt.sdk.v */
class C1128v extends WebViewClient {
    /* renamed from: c */
    private static String f5080c = null;
    /* renamed from: a */
    private WebViewClient f5081a;
    /* renamed from: b */
    private WebView f5082b;

    /* renamed from: com.tencent.smtt.sdk.v$a */
    private static class C1124a implements HttpAuthHandler {
        /* renamed from: a */
        private android.webkit.HttpAuthHandler f5071a;

        C1124a(android.webkit.HttpAuthHandler httpAuthHandler) {
            this.f5071a = httpAuthHandler;
        }

        public void cancel() {
            this.f5071a.cancel();
        }

        public void proceed(String str, String str2) {
            this.f5071a.proceed(str, str2);
        }

        public boolean useHttpAuthUsernamePassword() {
            return this.f5071a.useHttpAuthUsernamePassword();
        }
    }

    /* renamed from: com.tencent.smtt.sdk.v$b */
    private static class C1125b implements SslErrorHandler {
        /* renamed from: a */
        android.webkit.SslErrorHandler f5072a;

        C1125b(android.webkit.SslErrorHandler sslErrorHandler) {
            this.f5072a = sslErrorHandler;
        }

        public void cancel() {
            this.f5072a.cancel();
        }

        public void proceed() {
            this.f5072a.proceed();
        }
    }

    /* renamed from: com.tencent.smtt.sdk.v$c */
    private static class C1126c implements SslError {
        /* renamed from: a */
        android.net.http.SslError f5073a;

        C1126c(android.net.http.SslError sslError) {
            this.f5073a = sslError;
        }

        public boolean addError(int i) {
            return this.f5073a.addError(i);
        }

        public SslCertificate getCertificate() {
            return this.f5073a.getCertificate();
        }

        public int getPrimaryError() {
            return this.f5073a.getPrimaryError();
        }

        public boolean hasError(int i) {
            return this.f5073a.hasError(i);
        }
    }

    /* renamed from: com.tencent.smtt.sdk.v$d */
    private class C1127d implements WebResourceRequest {
        /* renamed from: a */
        final /* synthetic */ C1128v f5074a;
        /* renamed from: b */
        private String f5075b;
        /* renamed from: c */
        private boolean f5076c;
        /* renamed from: d */
        private boolean f5077d;
        /* renamed from: e */
        private String f5078e;
        /* renamed from: f */
        private Map<String, String> f5079f;

        public C1127d(C1128v c1128v, String str, boolean z, boolean z2, String str2, Map<String, String> map) {
            this.f5074a = c1128v;
            this.f5075b = str;
            this.f5076c = z;
            this.f5077d = z2;
            this.f5078e = str2;
            this.f5079f = map;
        }

        public String getMethod() {
            return this.f5078e;
        }

        public Map<String, String> getRequestHeaders() {
            return this.f5079f;
        }

        public Uri getUrl() {
            return Uri.parse(this.f5075b);
        }

        public boolean hasGesture() {
            return this.f5077d;
        }

        public boolean isForMainFrame() {
            return this.f5076c;
        }
    }

    C1128v(WebView webView, WebViewClient webViewClient) {
        this.f5082b = webView;
        this.f5081a = webViewClient;
    }

    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        this.f5082b.m7672a(webView);
        this.f5081a.doUpdateVisitedHistory(this.f5082b, str, z);
    }

    public void onFormResubmission(WebView webView, Message message, Message message2) {
        this.f5082b.m7672a(webView);
        this.f5081a.onFormResubmission(this.f5082b, message, message2);
    }

    public void onLoadResource(WebView webView, String str) {
        this.f5082b.m7672a(webView);
        this.f5081a.onLoadResource(this.f5082b, str);
    }

    public void onPageFinished(WebView webView, String str) {
        if (f5080c == null) {
            C1160x a = C1160x.m8065a();
            if (a != null) {
                a.m8068a(true);
                f5080c = Boolean.toString(true);
            }
        }
        this.f5082b.m7672a(webView);
        WebView webView2 = this.f5082b;
        webView2.f4903a++;
        this.f5081a.onPageFinished(this.f5082b, str);
        if (TbsConfig.APP_QZONE.equals(webView.getContext().getApplicationInfo().packageName)) {
            this.f5082b.m7671a(webView.getContext());
        }
        TbsLog.app_extra("SystemWebViewClient", webView.getContext());
        WebView.m7664c();
        C1102d.m7831a(this.f5082b);
        if (this.f5082b.getContext() != null && TbsShareManager.isThirdPartyApp(this.f5082b.getContext()) && !TbsShareManager.forceLoadX5FromTBSDemo(this.f5082b.getContext()) && TbsDownloader.needDownload(this.f5082b.getContext(), false)) {
            TbsDownloader.startDownload(this.f5082b.getContext());
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.f5082b.m7672a(webView);
        this.f5081a.onPageStarted(this.f5082b, str, bitmap);
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        this.f5082b.m7672a(webView);
        this.f5081a.onReceivedError(this.f5082b, i, str, str2);
    }

    public void onReceivedHttpAuthRequest(WebView webView, android.webkit.HttpAuthHandler httpAuthHandler, String str, String str2) {
        this.f5082b.m7672a(webView);
        this.f5081a.onReceivedHttpAuthRequest(this.f5082b, new C1124a(httpAuthHandler), str, str2);
    }

    @TargetApi(12)
    public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        if (VERSION.SDK_INT >= 12) {
            this.f5082b.m7672a(webView);
            this.f5081a.onReceivedLoginRequest(this.f5082b, str, str2, str3);
        }
    }

    @TargetApi(8)
    public void onReceivedSslError(WebView webView, android.webkit.SslErrorHandler sslErrorHandler, android.net.http.SslError sslError) {
        if (VERSION.SDK_INT >= 8) {
            this.f5082b.m7672a(webView);
            this.f5081a.onReceivedSslError(this.f5082b, new C1125b(sslErrorHandler), new C1126c(sslError));
        }
    }

    public void onScaleChanged(WebView webView, float f, float f2) {
        this.f5082b.m7672a(webView);
        this.f5081a.onScaleChanged(this.f5082b, f, f2);
    }

    public void onTooManyRedirects(WebView webView, Message message, Message message2) {
        this.f5082b.m7672a(webView);
        this.f5081a.onTooManyRedirects(this.f5082b, message, message2);
    }

    public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        this.f5082b.m7672a(webView);
        this.f5081a.onUnhandledKeyEvent(this.f5082b, keyEvent);
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, android.webkit.WebResourceRequest webResourceRequest) {
        if (VERSION.SDK_INT < 21) {
            return null;
        }
        if (webResourceRequest == null) {
            return null;
        }
        com.tencent.smtt.export.external.interfaces.WebResourceResponse shouldInterceptRequest = this.f5081a.shouldInterceptRequest(this.f5082b, new C1127d(this, webResourceRequest.getUrl().toString(), webResourceRequest.isForMainFrame(), webResourceRequest.hasGesture(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders()));
        if (shouldInterceptRequest == null) {
            return null;
        }
        WebResourceResponse webResourceResponse = new WebResourceResponse(shouldInterceptRequest.getMimeType(), shouldInterceptRequest.getEncoding(), shouldInterceptRequest.getData());
        webResourceResponse.setResponseHeaders(shouldInterceptRequest.getResponseHeaders());
        int statusCode = shouldInterceptRequest.getStatusCode();
        String reasonPhrase = shouldInterceptRequest.getReasonPhrase();
        if (statusCode == webResourceResponse.getStatusCode() && (reasonPhrase == null || reasonPhrase.equals(webResourceResponse.getReasonPhrase()))) {
            return webResourceResponse;
        }
        webResourceResponse.setStatusCodeAndReasonPhrase(statusCode, reasonPhrase);
        return webResourceResponse;
    }

    @TargetApi(11)
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (VERSION.SDK_INT < 11) {
            return null;
        }
        com.tencent.smtt.export.external.interfaces.WebResourceResponse shouldInterceptRequest = this.f5081a.shouldInterceptRequest(this.f5082b, str);
        return shouldInterceptRequest != null ? new WebResourceResponse(shouldInterceptRequest.getMimeType(), shouldInterceptRequest.getEncoding(), shouldInterceptRequest.getData()) : null;
    }

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        this.f5082b.m7672a(webView);
        return this.f5081a.shouldOverrideKeyEvent(this.f5082b, keyEvent);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str == null || this.f5082b.showDebugView(str)) {
            return true;
        }
        this.f5082b.m7672a(webView);
        return !C1154r.m8022a().m8035a(this.f5082b.getContext().getApplicationContext(), str) ? this.f5081a.shouldOverrideUrlLoading(this.f5082b, str) : true;
    }
}
