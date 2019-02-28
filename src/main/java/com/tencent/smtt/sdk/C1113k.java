package com.tencent.smtt.sdk;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.FileChooserParams;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.proxy.X5ProxyWebChromeClient;
import com.tencent.smtt.sdk.WebStorage.QuotaUpdater;
import com.tencent.smtt.sdk.WebView.WebViewTransport;

/* renamed from: com.tencent.smtt.sdk.k */
class C1113k extends X5ProxyWebChromeClient {
    /* renamed from: a */
    private WebView f5046a;
    /* renamed from: b */
    private WebChromeClient f5047b;

    /* renamed from: com.tencent.smtt.sdk.k$a */
    class C1112a implements QuotaUpdater {
        /* renamed from: a */
        com.tencent.smtt.export.external.interfaces.QuotaUpdater f5044a;
        /* renamed from: b */
        final /* synthetic */ C1113k f5045b;

        C1112a(C1113k c1113k, com.tencent.smtt.export.external.interfaces.QuotaUpdater quotaUpdater) {
            this.f5045b = c1113k;
            this.f5044a = quotaUpdater;
        }

        public void updateQuota(long j) {
            this.f5044a.updateQuota(j);
        }
    }

    public C1113k(IX5WebChromeClient iX5WebChromeClient, WebView webView, WebChromeClient webChromeClient) {
        super(iX5WebChromeClient);
        this.f5046a = webView;
        this.f5047b = webChromeClient;
    }

    public Bitmap getDefaultVideoPoster() {
        return this.f5047b.getDefaultVideoPoster();
    }

    public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
    }

    public void onCloseWindow(IX5WebViewBase iX5WebViewBase) {
        this.f5046a.m7673a(iX5WebViewBase);
        this.f5047b.onCloseWindow(this.f5046a);
    }

    public void onConsoleMessage(String str, int i, String str2) {
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return this.f5047b.onConsoleMessage(consoleMessage);
    }

    public boolean onCreateWindow(IX5WebViewBase iX5WebViewBase, boolean z, boolean z2, Message message) {
        WebView webView = this.f5046a;
        webView.getClass();
        WebViewTransport webViewTransport = new WebViewTransport(webView);
        Message obtain = Message.obtain(message.getTarget(), new C1114l(this, webViewTransport, message));
        obtain.obj = webViewTransport;
        return this.f5047b.onCreateWindow(this.f5046a, z, z2, obtain);
    }

    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, com.tencent.smtt.export.external.interfaces.QuotaUpdater quotaUpdater) {
        this.f5047b.onExceededDatabaseQuota(str, str2, j, j2, j3, new C1112a(this, quotaUpdater));
    }

    public void onGeolocationPermissionsHidePrompt() {
        this.f5047b.onGeolocationPermissionsHidePrompt();
    }

    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissionsCallback geolocationPermissionsCallback) {
        this.f5047b.onGeolocationPermissionsShowPrompt(str, geolocationPermissionsCallback);
    }

    public void onHideCustomView() {
        this.f5047b.onHideCustomView();
    }

    public boolean onJsAlert(IX5WebViewBase iX5WebViewBase, String str, String str2, JsResult jsResult) {
        this.f5046a.m7673a(iX5WebViewBase);
        return this.f5047b.onJsAlert(this.f5046a, str, str2, jsResult);
    }

    public boolean onJsBeforeUnload(IX5WebViewBase iX5WebViewBase, String str, String str2, JsResult jsResult) {
        this.f5046a.m7673a(iX5WebViewBase);
        return this.f5047b.onJsBeforeUnload(this.f5046a, str, str2, jsResult);
    }

    public boolean onJsConfirm(IX5WebViewBase iX5WebViewBase, String str, String str2, JsResult jsResult) {
        this.f5046a.m7673a(iX5WebViewBase);
        return this.f5047b.onJsConfirm(this.f5046a, str, str2, jsResult);
    }

    public boolean onJsPrompt(IX5WebViewBase iX5WebViewBase, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        this.f5046a.m7673a(iX5WebViewBase);
        return this.f5047b.onJsPrompt(this.f5046a, str, str2, str3, jsPromptResult);
    }

    public boolean onJsTimeout() {
        return this.f5047b.onJsTimeout();
    }

    public void onProgressChanged(IX5WebViewBase iX5WebViewBase, int i) {
        this.f5046a.m7673a(iX5WebViewBase);
        this.f5047b.onProgressChanged(this.f5046a, i);
    }

    public void onReachedMaxAppCacheSize(long j, long j2, com.tencent.smtt.export.external.interfaces.QuotaUpdater quotaUpdater) {
        this.f5047b.onReachedMaxAppCacheSize(j, j2, new C1112a(this, quotaUpdater));
    }

    public void onReceivedIcon(IX5WebViewBase iX5WebViewBase, Bitmap bitmap) {
        this.f5046a.m7673a(iX5WebViewBase);
        this.f5047b.onReceivedIcon(this.f5046a, bitmap);
    }

    public void onReceivedTitle(IX5WebViewBase iX5WebViewBase, String str) {
        this.f5046a.m7673a(iX5WebViewBase);
        this.f5047b.onReceivedTitle(this.f5046a, str);
    }

    public void onReceivedTouchIconUrl(IX5WebViewBase iX5WebViewBase, String str, boolean z) {
        this.f5046a.m7673a(iX5WebViewBase);
        this.f5047b.onReceivedTouchIconUrl(this.f5046a, str, z);
    }

    public void onRequestFocus(IX5WebViewBase iX5WebViewBase) {
        this.f5046a.m7673a(iX5WebViewBase);
        this.f5047b.onRequestFocus(this.f5046a);
    }

    public void onShowCustomView(View view, int i, CustomViewCallback customViewCallback) {
        this.f5047b.onShowCustomView(view, i, customViewCallback);
    }

    public void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        this.f5047b.onShowCustomView(view, customViewCallback);
    }

    public boolean onShowFileChooser(IX5WebViewBase iX5WebViewBase, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
        ValueCallback c1116n = new C1116n(this, valueCallback);
        WebChromeClient.FileChooserParams c1117o = new C1117o(this, fileChooserParams);
        this.f5046a.m7673a(iX5WebViewBase);
        return this.f5047b.onShowFileChooser(this.f5046a, c1116n, c1117o);
    }

    public void openFileChooser(ValueCallback<Uri[]> valueCallback, String str, String str2, boolean z) {
        this.f5047b.openFileChooser(new C1115m(this, valueCallback), str, str2);
    }
}
