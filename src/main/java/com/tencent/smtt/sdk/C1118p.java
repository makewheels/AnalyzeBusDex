package com.tencent.smtt.sdk;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import com.tencent.smtt.export.external.interfaces.HttpAuthHandler;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.export.external.proxy.X5ProxyWebViewClient;
import com.tencent.smtt.sdk.p052b.C1102d;
import com.tencent.smtt.utils.C1154r;
import com.tencent.smtt.utils.C1160x;
import com.tencent.smtt.utils.TbsLog;

/* renamed from: com.tencent.smtt.sdk.p */
class C1118p extends X5ProxyWebViewClient {
    /* renamed from: c */
    private static String f5057c = null;
    /* renamed from: a */
    private WebViewClient f5058a;
    /* renamed from: b */
    private WebView f5059b;

    public C1118p(IX5WebViewClient iX5WebViewClient, WebView webView, WebViewClient webViewClient) {
        super(iX5WebViewClient);
        this.f5059b = webView;
        this.f5058a = webViewClient;
    }

    /* renamed from: a */
    public void m7867a(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(this.f5059b.m7674b(), 0, 0, str, bitmap);
    }

    /* renamed from: a */
    public void m7868a(String str) {
        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(str));
        intent.addFlags(268435456);
        try {
            if (this.f5059b.getContext() != null) {
                this.f5059b.getContext().startActivity(intent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doUpdateVisitedHistory(IX5WebViewBase iX5WebViewBase, String str, boolean z) {
        this.f5059b.m7673a(iX5WebViewBase);
        this.f5058a.doUpdateVisitedHistory(this.f5059b, str, z);
    }

    public void onDetectedBlankScreen(IX5WebViewBase iX5WebViewBase, String str, int i) {
        this.f5059b.m7673a(iX5WebViewBase);
        this.f5058a.onDetectedBlankScreen(str, i);
    }

    public void onFormResubmission(IX5WebViewBase iX5WebViewBase, Message message, Message message2) {
        this.f5059b.m7673a(iX5WebViewBase);
        this.f5058a.onFormResubmission(this.f5059b, message, message2);
    }

    public void onLoadResource(IX5WebViewBase iX5WebViewBase, String str) {
        this.f5059b.m7673a(iX5WebViewBase);
        this.f5058a.onLoadResource(this.f5059b, str);
    }

    public void onPageFinished(IX5WebViewBase iX5WebViewBase, int i, int i2, String str) {
        if (f5057c == null) {
            C1160x a = C1160x.m8065a();
            if (a != null) {
                a.m8068a(false);
                f5057c = Boolean.toString(false);
            }
        }
        this.f5059b.m7673a(iX5WebViewBase);
        WebView webView = this.f5059b;
        webView.f4903a++;
        this.f5058a.onPageFinished(this.f5059b, str);
        if (TbsConfig.APP_QZONE.equals(iX5WebViewBase.getView().getContext().getApplicationInfo().packageName)) {
            this.f5059b.m7671a(iX5WebViewBase.getView().getContext());
        }
        TbsLog.app_extra("SmttWebViewClient", iX5WebViewBase.getView().getContext());
        try {
            super.onPageFinished(iX5WebViewBase, i, i2, str);
        } catch (Exception e) {
        }
        WebView.m7664c();
        C1102d.m7831a(this.f5059b);
        if (this.f5059b.getContext() != null && TbsShareManager.isThirdPartyApp(this.f5059b.getContext()) && !TbsShareManager.forceLoadX5FromTBSDemo(this.f5059b.getContext()) && TbsDownloader.needDownload(this.f5059b.getContext(), false)) {
            TbsDownloader.startDownload(this.f5059b.getContext());
        }
    }

    public void onPageFinished(IX5WebViewBase iX5WebViewBase, String str) {
        onPageFinished(iX5WebViewBase, 0, 0, str);
    }

    public void onPageStarted(IX5WebViewBase iX5WebViewBase, int i, int i2, String str, Bitmap bitmap) {
        this.f5059b.m7673a(iX5WebViewBase);
        this.f5058a.onPageStarted(this.f5059b, str, bitmap);
    }

    public void onPageStarted(IX5WebViewBase iX5WebViewBase, String str, Bitmap bitmap) {
        onPageStarted(iX5WebViewBase, 0, 0, str, bitmap);
    }

    public void onReceivedError(IX5WebViewBase iX5WebViewBase, int i, String str, String str2) {
        if (i < -15) {
            if (i == -17) {
                i = -1;
            } else {
                return;
            }
        }
        this.f5059b.m7673a(iX5WebViewBase);
        this.f5058a.onReceivedError(this.f5059b, i, str, str2);
    }

    public void onReceivedHttpAuthRequest(IX5WebViewBase iX5WebViewBase, HttpAuthHandler httpAuthHandler, String str, String str2) {
        this.f5059b.m7673a(iX5WebViewBase);
        this.f5058a.onReceivedHttpAuthRequest(this.f5059b, httpAuthHandler, str, str2);
    }

    public void onReceivedHttpError(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        this.f5059b.m7673a(iX5WebViewBase);
        this.f5058a.onReceivedHttpError(this.f5059b, webResourceRequest, webResourceResponse);
    }

    public void onReceivedLoginRequest(IX5WebViewBase iX5WebViewBase, String str, String str2, String str3) {
        this.f5059b.m7673a(iX5WebViewBase);
        this.f5058a.onReceivedLoginRequest(this.f5059b, str, str2, str3);
    }

    public void onReceivedSslError(IX5WebViewBase iX5WebViewBase, SslErrorHandler sslErrorHandler, SslError sslError) {
        this.f5059b.m7673a(iX5WebViewBase);
        this.f5058a.onReceivedSslError(this.f5059b, sslErrorHandler, sslError);
    }

    public void onScaleChanged(IX5WebViewBase iX5WebViewBase, float f, float f2) {
        this.f5059b.m7673a(iX5WebViewBase);
        this.f5058a.onScaleChanged(this.f5059b, f, f2);
    }

    public void onTooManyRedirects(IX5WebViewBase iX5WebViewBase, Message message, Message message2) {
        this.f5059b.m7673a(iX5WebViewBase);
        this.f5058a.onTooManyRedirects(this.f5059b, message, message2);
    }

    public void onUnhandledKeyEvent(IX5WebViewBase iX5WebViewBase, KeyEvent keyEvent) {
        this.f5059b.m7673a(iX5WebViewBase);
        this.f5058a.onUnhandledKeyEvent(this.f5059b, keyEvent);
    }

    public WebResourceResponse shouldInterceptRequest(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest) {
        this.f5059b.m7673a(iX5WebViewBase);
        return this.f5058a.shouldInterceptRequest(this.f5059b, webResourceRequest);
    }

    public WebResourceResponse shouldInterceptRequest(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest, Bundle bundle) {
        this.f5059b.m7673a(iX5WebViewBase);
        return this.f5058a.shouldInterceptRequest(this.f5059b, webResourceRequest, bundle);
    }

    public WebResourceResponse shouldInterceptRequest(IX5WebViewBase iX5WebViewBase, String str) {
        this.f5059b.m7673a(iX5WebViewBase);
        return this.f5058a.shouldInterceptRequest(this.f5059b, str);
    }

    public boolean shouldOverrideKeyEvent(IX5WebViewBase iX5WebViewBase, KeyEvent keyEvent) {
        this.f5059b.m7673a(iX5WebViewBase);
        return this.f5058a.shouldOverrideKeyEvent(this.f5059b, keyEvent);
    }

    public boolean shouldOverrideUrlLoading(IX5WebViewBase iX5WebViewBase, String str) {
        if (str == null || this.f5059b.showDebugView(str)) {
            return true;
        }
        this.f5059b.m7673a(iX5WebViewBase);
        if (C1154r.m8022a().m8035a(this.f5059b.getContext().getApplicationContext(), str)) {
            return true;
        }
        boolean shouldOverrideUrlLoading = this.f5058a.shouldOverrideUrlLoading(this.f5059b, str);
        if (!shouldOverrideUrlLoading) {
            if (str.startsWith("wtai://wp/mc;")) {
                this.f5059b.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(WebView.SCHEME_TEL + str.substring("wtai://wp/mc;".length()))));
                return true;
            } else if (str.startsWith(WebView.SCHEME_TEL)) {
                m7868a(str);
                return true;
            }
        }
        return shouldOverrideUrlLoading;
    }
}
