package com.tencent.smtt.sdk;

import android.content.Context;

public class WebViewDatabase {
    /* renamed from: a */
    private static WebViewDatabase f4921a;
    /* renamed from: b */
    private android.webkit.WebViewDatabase f4922b;
    /* renamed from: c */
    private Context f4923c;

    protected WebViewDatabase(Context context) {
        this.f4923c = context;
    }

    /* renamed from: a */
    private static synchronized WebViewDatabase m7675a(Context context) {
        WebViewDatabase webViewDatabase;
        synchronized (WebViewDatabase.class) {
            if (f4921a == null) {
                f4921a = new WebViewDatabase(context);
            }
            webViewDatabase = f4921a;
        }
        return webViewDatabase;
    }

    public static WebViewDatabase getInstance(Context context) {
        return m7675a(context);
    }

    public void clearFormData() {
        C1110i a = C1110i.m7845a(false);
        if (a == null || !a.m7858b()) {
            this.f4922b.clearFormData();
        } else {
            a.m7852a().m7798g(this.f4923c);
        }
    }

    public void clearHttpAuthUsernamePassword() {
        C1110i a = C1110i.m7845a(false);
        if (a == null || !a.m7858b()) {
            this.f4922b.clearHttpAuthUsernamePassword();
        } else {
            a.m7852a().m7793e(this.f4923c);
        }
    }

    @Deprecated
    public void clearUsernamePassword() {
        C1110i a = C1110i.m7845a(false);
        if (a == null || !a.m7858b()) {
            this.f4922b.clearUsernamePassword();
        } else {
            a.m7852a().m7787c(this.f4923c);
        }
    }

    public boolean hasFormData() {
        C1110i a = C1110i.m7845a(false);
        return (a == null || !a.m7858b()) ? this.f4922b.hasFormData() : a.m7852a().m7796f(this.f4923c);
    }

    public boolean hasHttpAuthUsernamePassword() {
        C1110i a = C1110i.m7845a(false);
        return (a == null || !a.m7858b()) ? this.f4922b.hasHttpAuthUsernamePassword() : a.m7852a().m7791d(this.f4923c);
    }

    @Deprecated
    public boolean hasUsernamePassword() {
        C1110i a = C1110i.m7845a(false);
        return (a == null || !a.m7858b()) ? this.f4922b.hasUsernamePassword() : a.m7852a().m7785b(this.f4923c);
    }
}
