package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.FileChooserParams;
import android.webkit.WebStorage;
import android.webkit.WebView;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage.MessageLevel;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.WebStorage.QuotaUpdater;
import com.tencent.smtt.sdk.WebView.WebViewTransport;

class SystemWebChromeClient extends WebChromeClient {
    /* renamed from: a */
    private WebView f4813a;
    /* renamed from: b */
    private WebChromeClient f4814b;

    /* renamed from: com.tencent.smtt.sdk.SystemWebChromeClient$a */
    private static class C1077a implements ConsoleMessage {
        /* renamed from: a */
        private MessageLevel f4799a;
        /* renamed from: b */
        private String f4800b;
        /* renamed from: c */
        private String f4801c;
        /* renamed from: d */
        private int f4802d;

        C1077a(android.webkit.ConsoleMessage consoleMessage) {
            this.f4799a = MessageLevel.valueOf(consoleMessage.messageLevel().name());
            this.f4800b = consoleMessage.message();
            this.f4801c = consoleMessage.sourceId();
            this.f4802d = consoleMessage.lineNumber();
        }

        C1077a(String str, String str2, int i) {
            this.f4799a = MessageLevel.LOG;
            this.f4800b = str;
            this.f4801c = str2;
            this.f4802d = i;
        }

        public int lineNumber() {
            return this.f4802d;
        }

        public String message() {
            return this.f4800b;
        }

        public MessageLevel messageLevel() {
            return this.f4799a;
        }

        public String sourceId() {
            return this.f4801c;
        }
    }

    /* renamed from: com.tencent.smtt.sdk.SystemWebChromeClient$b */
    class C1078b implements CustomViewCallback {
        /* renamed from: a */
        WebChromeClient.CustomViewCallback f4803a;
        /* renamed from: b */
        final /* synthetic */ SystemWebChromeClient f4804b;

        C1078b(SystemWebChromeClient systemWebChromeClient, WebChromeClient.CustomViewCallback customViewCallback) {
            this.f4804b = systemWebChromeClient;
            this.f4803a = customViewCallback;
        }

        public void onCustomViewHidden() {
            this.f4803a.onCustomViewHidden();
        }
    }

    /* renamed from: com.tencent.smtt.sdk.SystemWebChromeClient$c */
    class C1079c implements GeolocationPermissionsCallback {
        /* renamed from: a */
        Callback f4805a;
        /* renamed from: b */
        final /* synthetic */ SystemWebChromeClient f4806b;

        C1079c(SystemWebChromeClient systemWebChromeClient, Callback callback) {
            this.f4806b = systemWebChromeClient;
            this.f4805a = callback;
        }

        public void invoke(String str, boolean z, boolean z2) {
            this.f4805a.invoke(str, z, z2);
        }
    }

    /* renamed from: com.tencent.smtt.sdk.SystemWebChromeClient$d */
    private class C1080d implements JsPromptResult {
        /* renamed from: a */
        android.webkit.JsPromptResult f4807a;
        /* renamed from: b */
        final /* synthetic */ SystemWebChromeClient f4808b;

        C1080d(SystemWebChromeClient systemWebChromeClient, android.webkit.JsPromptResult jsPromptResult) {
            this.f4808b = systemWebChromeClient;
            this.f4807a = jsPromptResult;
        }

        public void cancel() {
            this.f4807a.cancel();
        }

        public void confirm() {
            this.f4807a.confirm();
        }

        public void confirm(String str) {
            this.f4807a.confirm(str);
        }
    }

    /* renamed from: com.tencent.smtt.sdk.SystemWebChromeClient$e */
    private class C1081e implements JsResult {
        /* renamed from: a */
        android.webkit.JsResult f4809a;
        /* renamed from: b */
        final /* synthetic */ SystemWebChromeClient f4810b;

        C1081e(SystemWebChromeClient systemWebChromeClient, android.webkit.JsResult jsResult) {
            this.f4810b = systemWebChromeClient;
            this.f4809a = jsResult;
        }

        public void cancel() {
            this.f4809a.cancel();
        }

        public void confirm() {
            this.f4809a.confirm();
        }
    }

    /* renamed from: com.tencent.smtt.sdk.SystemWebChromeClient$f */
    class C1082f implements QuotaUpdater {
        /* renamed from: a */
        WebStorage.QuotaUpdater f4811a;
        /* renamed from: b */
        final /* synthetic */ SystemWebChromeClient f4812b;

        C1082f(SystemWebChromeClient systemWebChromeClient, WebStorage.QuotaUpdater quotaUpdater) {
            this.f4812b = systemWebChromeClient;
            this.f4811a = quotaUpdater;
        }

        public void updateQuota(long j) {
            this.f4811a.updateQuota(j);
        }
    }

    SystemWebChromeClient(WebView webView, WebChromeClient webChromeClient) {
        this.f4813a = webView;
        this.f4814b = webChromeClient;
    }

    @TargetApi(7)
    public Bitmap getDefaultVideoPoster() {
        return this.f4814b.getDefaultVideoPoster();
    }

    @TargetApi(7)
    public View getVideoLoadingProgressView() {
        return this.f4814b.getVideoLoadingProgressView();
    }

    public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
        this.f4814b.getVisitedHistory(new C1119q(this, valueCallback));
    }

    public void onCloseWindow(WebView webView) {
        this.f4813a.m7672a(webView);
        this.f4814b.onCloseWindow(this.f4813a);
    }

    public void onConsoleMessage(String str, int i, String str2) {
        this.f4814b.onConsoleMessage(new C1077a(str, str2, i));
    }

    public boolean onConsoleMessage(android.webkit.ConsoleMessage consoleMessage) {
        return this.f4814b.onConsoleMessage(new C1077a(consoleMessage));
    }

    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        WebView webView2 = this.f4813a;
        webView2.getClass();
        WebViewTransport webViewTransport = new WebViewTransport(webView2);
        Message obtain = Message.obtain(message.getTarget(), new C1120r(this, webViewTransport, message));
        obtain.obj = webViewTransport;
        return this.f4814b.onCreateWindow(this.f4813a, z, z2, obtain);
    }

    @TargetApi(5)
    @Deprecated
    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        this.f4814b.onExceededDatabaseQuota(str, str2, j, j2, j3, new C1082f(this, quotaUpdater));
    }

    @TargetApi(5)
    public void onGeolocationPermissionsHidePrompt() {
        this.f4814b.onGeolocationPermissionsHidePrompt();
    }

    @TargetApi(5)
    public void onGeolocationPermissionsShowPrompt(String str, Callback callback) {
        this.f4814b.onGeolocationPermissionsShowPrompt(str, new C1079c(this, callback));
    }

    @TargetApi(7)
    public void onHideCustomView() {
        this.f4814b.onHideCustomView();
    }

    public boolean onJsAlert(WebView webView, String str, String str2, android.webkit.JsResult jsResult) {
        this.f4813a.m7672a(webView);
        return this.f4814b.onJsAlert(this.f4813a, str, str2, new C1081e(this, jsResult));
    }

    public boolean onJsBeforeUnload(WebView webView, String str, String str2, android.webkit.JsResult jsResult) {
        this.f4813a.m7672a(webView);
        return this.f4814b.onJsBeforeUnload(this.f4813a, str, str2, new C1081e(this, jsResult));
    }

    public boolean onJsConfirm(WebView webView, String str, String str2, android.webkit.JsResult jsResult) {
        this.f4813a.m7672a(webView);
        return this.f4814b.onJsConfirm(this.f4813a, str, str2, new C1081e(this, jsResult));
    }

    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, android.webkit.JsPromptResult jsPromptResult) {
        this.f4813a.m7672a(webView);
        return this.f4814b.onJsPrompt(this.f4813a, str, str2, str3, new C1080d(this, jsPromptResult));
    }

    @TargetApi(7)
    public boolean onJsTimeout() {
        return this.f4814b.onJsTimeout();
    }

    public void onProgressChanged(WebView webView, int i) {
        this.f4813a.m7672a(webView);
        this.f4814b.onProgressChanged(this.f4813a, i);
    }

    @TargetApi(7)
    @Deprecated
    public void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
        this.f4814b.onReachedMaxAppCacheSize(j, j2, new C1082f(this, quotaUpdater));
    }

    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
        this.f4813a.m7672a(webView);
        this.f4814b.onReceivedIcon(this.f4813a, bitmap);
    }

    public void onReceivedTitle(WebView webView, String str) {
        this.f4813a.m7672a(webView);
        this.f4814b.onReceivedTitle(this.f4813a, str);
    }

    @TargetApi(7)
    public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
        this.f4813a.m7672a(webView);
        this.f4814b.onReceivedTouchIconUrl(this.f4813a, str, z);
    }

    public void onRequestFocus(WebView webView) {
        this.f4813a.m7672a(webView);
        this.f4814b.onRequestFocus(this.f4813a);
    }

    @TargetApi(14)
    @Deprecated
    public void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        this.f4814b.onShowCustomView(view, i, new C1078b(this, customViewCallback));
    }

    @TargetApi(7)
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        this.f4814b.onShowCustomView(view, new C1078b(this, customViewCallback));
    }

    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
        ValueCallback c1122t = new C1122t(this, valueCallback);
        WebChromeClient.FileChooserParams c1123u = new C1123u(this, fileChooserParams);
        this.f4813a.m7672a(webView);
        return this.f4814b.onShowFileChooser(this.f4813a, c1122t, c1123u);
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback) {
        openFileChooser(valueCallback, null, null);
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
        openFileChooser(valueCallback, str, null);
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        this.f4814b.openFileChooser(new C1121s(this, valueCallback), str, str2);
    }

    public void setupAutoFill(Message message) {
    }
}
